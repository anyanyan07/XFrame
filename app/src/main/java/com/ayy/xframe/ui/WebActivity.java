package com.ayy.xframe.ui;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.ayy.xframe.R;
import com.ayy.xframe.base.BaseActivity;
import com.ayy.xframe.config.Constant;
import com.ayy.xframe.databinding.ActivityWebBinding;

@Route(path = Constant.WEB)
public class WebActivity extends BaseActivity<ActivityWebBinding> {
    private String url;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initData() {
        url = getIntent().getStringExtra("url");
        binding.web.loadUrl(url);

    }
}
