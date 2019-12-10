package com.ayy.xframe.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

/**
 * 所有activty基类
 */
public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {
    protected B binding;

    protected abstract int getLayoutId();

    protected abstract void initData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
        initData();
    }

    /**
     * 释放资源
     */
    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}
