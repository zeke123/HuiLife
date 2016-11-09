package com.minghuilianmeng.huilife.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.minghuilianmeng.huilife.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 关于明慧联盟的界面
 * Created by zhoujian on 16/8/30.
 */
public class AboutUnionActivity extends Activity
{
    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.tv_title_name)
    TextView tvTitleName;
    @InjectView(R.id.iv_title_menu_right)
    ImageView ivTitleMenuRight;
    @InjectView(R.id.tv_title_menu_right)
    TextView tvTitleMenuRight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_card_manager);
        ButterKnife.inject(this);
        initTitle();
    }

    private void initTitle()
    {
        Toast.makeText(this, "哈哈哈", Toast.LENGTH_SHORT).show();
        tvTitleName.setText("关于明慧联盟");
        ivTitleMenuRight.setVisibility(View.GONE);
        tvTitleMenuRight.setVisibility(View.GONE);
        ivTitleBack.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}
