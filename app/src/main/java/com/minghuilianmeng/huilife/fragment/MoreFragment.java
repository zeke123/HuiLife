package com.minghuilianmeng.huilife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.minghuilianmeng.huilife.R;
import com.minghuilianmeng.huilife.activity.AboutHuiLifeActivity;
import com.minghuilianmeng.huilife.activity.AboutUnionActivity;
import com.minghuilianmeng.huilife.activity.ApplicationForActivity;
import com.minghuilianmeng.huilife.activity.AskCardActivity;
import com.minghuilianmeng.huilife.activity.CardGuideActivity;
import com.minghuilianmeng.huilife.activity.FeedBackActivity;
import com.minghuilianmeng.huilife.activity.MessageRemindActivity;
import com.minghuilianmeng.huilife.activity.QuestionnaireSurveyActivity;
import com.minghuilianmeng.huilife.activity.ShareCardActivity;
import com.minghuilianmeng.huilife.activity.SuperSelectActivity;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class MoreFragment extends Fragment
{

    private View view;
    private Intent intent;

    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.tv_title_name)
    TextView tvTitleName;

    //索取明慧联盟卡
    @InjectView(R.id.rl_ask_for_card)
    RelativeLayout rlAskForCard;
    //邀请好友索取明慧联盟卡
    @InjectView(R.id.rl_ask_card_for_friend)
    RelativeLayout rlAskCardForFriend;
    //省流量模式开
    @InjectView(R.id.switch_on)
    ImageView switchOn;
    //省流量模式关
    @InjectView(R.id.switch_off)
    ImageView switchOff;
    //消息提醒
    @InjectView(R.id.rl_message_to_remind)
    RelativeLayout rlMessageToRemind;
    //清空缓存
    @InjectView(R.id.rl_clear_the_cache)
    RelativeLayout rlClearCache;
    //缓存数量
    @InjectView(R.id.tv_cache)
    TextView tvCache;
    //意见反馈
    @InjectView(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    //问卷调查
    @InjectView(R.id.rl_the_questionnaire_survey)
    RelativeLayout rlTheQuestionnaireSurvey;
    //合作申请
    @InjectView(R.id.rl_application_for)
    RelativeLayout rlApplicationFor;
    //用卡指南
    @InjectView(R.id.rl_card_guide)
    RelativeLayout rlCardGuide;
    //超级选拔活动
    @InjectView(R.id.rl_super_optional_activity)
    RelativeLayout rlSuperOptionalActivity;
    //关于明慧联盟
    @InjectView(R.id.rl_about_union)
    RelativeLayout rlAboutUnion;
    //关于慧生活
    @InjectView(R.id.rl_about_hui_life)
    RelativeLayout rlAboutHuiLife;
    //慧生活版本
    @InjectView(R.id.tv_version)
    TextView tvVersion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //快捷键command+option+v		导出变量
        //快捷键command+option+f		导出字段
        view = inflater.inflate(R.layout.more_fragment, container, false);
        ButterKnife.inject(this, view);
        initTitle();
        clickEvent();
        return view;
    }

    private void initTitle()
    {
        ivTitleBack.setVisibility(View.GONE);
        tvTitleName.setText("更多");
    }

    private void clickEvent()
    {
        //索取明慧联盟卡的点击事件
        rlAskForCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),AskCardActivity.class);
                startActivity(intent);
            }
        });

        //邀请好友索取明慧联盟卡
        rlAskCardForFriend.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),ShareCardActivity.class);
                startActivity(intent);

            }
        });

        //打开开关的点击事件
        switchOn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switchOff.setVisibility(View.VISIBLE);
                switchOn.setVisibility(View.INVISIBLE);
            }
        });

        //关闭开关的点击事件
        switchOff.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                switchOff.setVisibility(View.INVISIBLE);
                switchOn.setVisibility(View.VISIBLE);
            }
        });


        //消息提醒的点击事件
        rlMessageToRemind.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MessageRemindActivity.class);
                startActivity(intent);
            }
        });

        //清空缓存的点击事件
        rlClearCache.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });


        //意见反馈的点击事件
        rlFeedback.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),FeedBackActivity.class);
                startActivity(intent);
            }
        });

        //问卷调查的点击事件
        rlTheQuestionnaireSurvey.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),QuestionnaireSurveyActivity.class);
                startActivity(intent);
            }
        });

        //合作申请的点击事件
        rlApplicationFor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),ApplicationForActivity.class);
                startActivity(intent);
            }
        });

        //用卡指南的点击事件
        rlCardGuide.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),CardGuideActivity.class);
                startActivity(intent);
            }
        });
        //超级选拔活动的点击事件
        rlSuperOptionalActivity.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),SuperSelectActivity.class);
                startActivity(intent);
            }
        });

        //关于明慧联盟的点击事件
        rlAboutUnion.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),AboutUnionActivity.class);
                startActivity(intent);
            }
        });

        //关于慧生活的点击事件
        rlAboutHuiLife.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),AboutHuiLifeActivity.class);
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
