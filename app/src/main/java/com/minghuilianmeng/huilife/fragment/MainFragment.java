package com.minghuilianmeng.huilife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minghuilianmeng.huilife.R;
import com.minghuilianmeng.huilife.activity.ChoiceCityActivity;
import com.minghuilianmeng.huilife.activity.MessagesActivity;
import com.minghuilianmeng.huilife.view.FlashView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainFragment extends Fragment {


    private View view;
    private Intent intent;

    @InjectView(R.id.tv_city)
    TextView tvCity;
    @InjectView(R.id.tv_store_name)
    TextView tvStoreName;
    @InjectView(R.id.img_messages)
    ImageView imgMessages;
    @InjectView(R.id.flash_view)
    FlashView mFlashView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        ButterKnife.inject(this, view);
        clickEvent();
        initFlashView();
        return view;
    }

    private void initFlashView()
    {
          mFlashView.setImagesUrl(new String[] {
         "http://img04.muzhiwan.com/2015/06/16/upload_557fd293326f5.jpg",
         "http://img03.muzhiwan.com/2015/06/05/upload_557165f4850cf.png",
         "http://img02.muzhiwan.com/2015/06/11/upload_557903dc0f165.jpg",
         "http://img04.muzhiwan.com/2015/06/05/upload_5571659957d90.png",
         "http://img03.muzhiwan.com/2015/06/16/upload_557fd2a8da7a3.jpg" });


    }

    private void clickEvent() {
        //选择城市的界面
        tvCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), ChoiceCityActivity.class);
                startActivity(intent);
            }
        });

        //消息的界面
        imgMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getActivity(), MessagesActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
