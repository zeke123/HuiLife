package com.minghuilianmeng.huilife.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.minghuilianmeng.huilife.R;
import com.minghuilianmeng.huilife.fragment.FindFragment;
import com.minghuilianmeng.huilife.fragment.MainFragment;
import com.minghuilianmeng.huilife.fragment.MineFragment;
import com.minghuilianmeng.huilife.fragment.MoreFragment;

import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends FragmentActivity implements OnClickListener
{
    private MainFragment mainFragment;
    private FindFragment findFragment;
    private MineFragment mineFragment;
    private MoreFragment moreFragment;

    @InjectView(R.id.tab_main_fragment_img)
    ImageButton tabMainFragmentImg;
    @InjectView(R.id.tab_find_fragment_img)
    ImageButton tabFindFragmentImg;
    @InjectView(R.id.tab_mine_fragment_img)
    ImageButton tabMineFragmentImg;
    @InjectView(R.id.tab_more_fragment_img)
    ImageButton tabMoreFragmentImg;

    @InjectView(R.id.tab_main_fragment)
    LinearLayout tabMainFragment;
    @InjectView(R.id.tab_find_fragment)
    LinearLayout tabFindFragment;
    @InjectView(R.id.tab_mine_fragment)
    LinearLayout tabMineFragment;
    @InjectView(R.id.tab_more_fragment)
    LinearLayout tabMoreFragment;

    @InjectView(R.id.tab_tv_main)
    TextView tabTvMain;
    @InjectView(R.id.tab_tv_find)
    TextView tabTvFind;
    @InjectView(R.id.tab_tv_mine)
    TextView tabTvMine;
    @InjectView(R.id.tab_tv_more)
    TextView tabTvMore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initEvent();
        setSelect(0);

        getMonthCalendar(2016,9);
    }


    public static int[] getMonthCalendar(int year, int month) {

        Calendar cl = Calendar.getInstance();
        cl.set(year, month, 1);
        int firstDay = cl.getMinimum(Calendar.DAY_OF_MONTH);
        int lastDay = cl.getMaximum(Calendar.DAY_OF_MONTH);

        int[] day = new int[lastDay];

        for (int i = 0; i < lastDay; i++) {

            day[i] =  i + firstDay;
        }

        return day;
    }






    private void initEvent()
    {
        tabMainFragment.setOnClickListener(this);
        tabFindFragment.setOnClickListener(this);
        tabMineFragment.setOnClickListener(this);
        tabMoreFragment.setOnClickListener(this);
    }

    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        switch (i)
        {
            case 0:
                if (mainFragment == null)
                {
                    mainFragment = new MainFragment();
                    transaction.add(R.id.id_content, mainFragment);
                }
                else
                {
                    transaction.show(mainFragment);
                }
                tabTvMain.setTextColor(Color.parseColor("#E51C23"));
                tabMainFragmentImg.setImageResource(R.mipmap.tab_weixin_pressed);
                break;
            case 1:
                if (findFragment == null)
                {
                    findFragment = new FindFragment();
                    transaction.add(R.id.id_content, findFragment);
                }
                else
                {
                    transaction.show(findFragment);
                }
                tabTvFind.setTextColor(Color.parseColor("#E51C23"));
                tabFindFragmentImg.setImageResource(R.mipmap.tab_find_frd_pressed);
                break;

            case 2:
                if (mineFragment == null)
                {
                    mineFragment = new MineFragment();
                    transaction.add(R.id.id_content, mineFragment);
                }
                else
                {
                    transaction.show(mineFragment);
                }
                tabTvMine.setTextColor(Color.parseColor("#E51C23"));
                tabMineFragmentImg.setImageResource(R.mipmap.tab_address_pressed);
                break;

            case 3:
                if (moreFragment == null)
                {
                    moreFragment = new MoreFragment();
                    transaction.add(R.id.id_content, moreFragment);
                }
                else
                {
                    transaction.show(moreFragment);
                }
                tabTvMore.setTextColor(Color.parseColor("#E51C23"));
                tabMoreFragmentImg.setImageResource(R.mipmap.tab_settings_pressed);
                break;
        }
        transaction.commit();
    }

    @Override
    public void onAttachFragment(Fragment fragment)
    {
        super.onAttachFragment(fragment);
        if (mainFragment == null && fragment instanceof MainFragment) {
            mainFragment = (MainFragment) fragment;
        } else if (findFragment == null && fragment instanceof FindFragment) {
            findFragment = (FindFragment) fragment;
        } else if (mineFragment == null && fragment instanceof MineFragment) {
            mineFragment = (MineFragment) fragment;
        } else if (moreFragment == null && fragment instanceof MoreFragment) {
            moreFragment = (MoreFragment) fragment;
        }
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (findFragment != null) {
            transaction.hide(findFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImages();
        switch (v.getId())
        {
            case R.id.tab_main_fragment:
                setSelect(0);
                break;
            case R.id.tab_find_fragment:
                setSelect(1);
                break;
            case R.id.tab_mine_fragment:
                setSelect(2);
                break;
            case R.id.tab_more_fragment:
                setSelect(3);
                break;
        }
    }

    private void resetImages()
    {
        tabMainFragmentImg.setImageResource(R.mipmap.tab_weixin_normal);
        tabFindFragmentImg.setImageResource(R.mipmap.tab_find_frd_normal);
        tabMineFragmentImg.setImageResource(R.mipmap.tab_address_normal);
        tabMoreFragmentImg.setImageResource(R.mipmap.tab_settings_normal);
        tabTvMain.setTextColor(Color.parseColor("#444444"));
        tabTvFind.setTextColor(Color.parseColor("#444444"));
        tabTvMine.setTextColor(Color.parseColor("#444444"));
        tabTvMore.setTextColor(Color.parseColor("#444444"));
    }
}