package com.minghuilianmeng.huilife.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.minghuilianmeng.huilife.R;
import com.minghuilianmeng.huilife.activity.CardManagerActivity;
import com.minghuilianmeng.huilife.activity.CarePlanActivity;
import com.minghuilianmeng.huilife.activity.ConsumptionRecordActivity;
import com.minghuilianmeng.huilife.activity.IntegralMallActivity;
import com.minghuilianmeng.huilife.activity.MallOrdersActivity;
import com.minghuilianmeng.huilife.activity.MineCollectionActivity;
import com.minghuilianmeng.huilife.activity.MineCommentsActivity;
import com.minghuilianmeng.huilife.activity.MinePointsActivity;
import com.minghuilianmeng.huilife.activity.MyCarInsuranceActivity;
import com.minghuilianmeng.huilife.activity.ShippingAddressActivity;
import com.minghuilianmeng.huilife.view.CircleImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MineFragment extends Fragment
{

    private View view;
    private Intent intent;

    //头像
    @InjectView(R.id.head_img)
    CircleImageView headImg;
    //名字
    @InjectView(R.id.tv_name)
    TextView tvName;

    //我的明慧联盟卡
    @InjectView(R.id.rl_mime_card)
    RelativeLayout rlMimeCard;
    //我的明慧联盟卡是否绑定
    @InjectView(R.id.whether_binding)
    TextView whetherBinding;


    //消费记录
    @InjectView(R.id.rl_records_of_consumption)
    RelativeLayout rlRecordsOfConsumption;
    //省了多少钱
    @InjectView(R.id.save_money)
    TextView saveMoney;


    //关爱计划
    @InjectView(R.id.rl_care_plan)
    RelativeLayout rlCarePlan;
    //关爱计划是否激活
    @InjectView(R.id.tv_active)
    TextView tvActive;


    //我的车险
    @InjectView(R.id.rl_my_car_insurance)
    RelativeLayout rlMyCarInsurance;
    //我的车险的数量
    @InjectView(R.id.car_insurance_number)
    TextView carInsuranceNumber;


    //我的积分
    @InjectView(R.id.rl_mine_points)
    RelativeLayout rlMinePoints;
    //我的积分的数量
    @InjectView(R.id.points_number)
    TextView pointsNumber;


    //积分商城
    @InjectView(R.id.rl_integral_mall)
    RelativeLayout rlIntegralMall;
    //积分商城换购好礼
    @InjectView(R.id.tv_integral_mall)
    TextView tvIntegralMall;


    //商城订单
    @InjectView(R.id.rl_mall_orders)
    RelativeLayout rlMallOrders;
    //商城订单的数量
    @InjectView(R.id.mall_orders_number)
    TextView mallOrdersNumber;


    //收货地址
    @InjectView(R.id.rl_shipping_address)
    RelativeLayout rlShippingAddress;
    //收货地址的数量
    @InjectView(R.id.shipping_address_number)
    TextView shippingAddressNumber;


    //我的收藏
    @InjectView(R.id.rl_mine_collection)
    RelativeLayout rlMineCollection;
    //我的收藏的数量
    @InjectView(R.id.mine_collection_number)
    TextView mineCollectionNumber;


    //我的评论
    @InjectView(R.id.rl_mine_comment)
    RelativeLayout rlMineComment;
    //我的评论的数量
    @InjectView(R.id.mine_comment_number)
    TextView mineCommentNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.mine_fragment, container, false);
        ButterKnife.inject(this,view);
        clickEvent();
        return view;
    }

    private void clickEvent()
    {
        //我的明慧联盟卡的点击事件
        rlMimeCard.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),CardManagerActivity.class);
                startActivity(intent);
            }
        });

        //消费记录的点击事件
        rlRecordsOfConsumption.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),ConsumptionRecordActivity.class);
                startActivity(intent);
            }
        });

        //关爱计划的点击事件
        rlCarePlan.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),CarePlanActivity.class);
                startActivity(intent);
            }
        });

        //我的车险的点击事件
        rlMyCarInsurance.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MyCarInsuranceActivity.class);
                startActivity(intent);

            }
        });

        //我的积分的点击事件
        rlMinePoints.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MinePointsActivity.class);
                startActivity(intent);

            }
        });

        //积分商城的点击事件
        rlIntegralMall.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                intent = new Intent(getActivity(),IntegralMallActivity.class);
                startActivity(intent);


            }
        });

        //商城订单的点击事件
        rlMallOrders.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MallOrdersActivity.class);
                startActivity(intent);

            }
        });

        //收货地址的点击事件
        rlShippingAddress.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),ShippingAddressActivity.class);
                startActivity(intent);

            }
        });

        //我的收藏的点击事件
        rlMineCollection.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MineCollectionActivity.class);
                startActivity(intent);

            }
        });

        //我的评论的点击事件
        rlMineComment.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                intent = new Intent(getActivity(),MineCommentsActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
