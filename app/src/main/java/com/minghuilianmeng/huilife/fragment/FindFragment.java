package com.minghuilianmeng.huilife.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.minghuilianmeng.huilife.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class FindFragment extends Fragment {

    @InjectView(R.id.iv_title_back)
    ImageView ivTitleBack;
    @InjectView(R.id.tv_title_name)
    TextView tvTitleName;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.find_fragment, container, false);
        ButterKnife.inject(this, view);
        initTitle();
        return view;
    }

    private void initTitle()
    {
        ivTitleBack.setVisibility(View.GONE);
        tvTitleName.setText("发现");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}
