package com.ayy.xframe.base;

import androidx.databinding.ViewDataBinding;

public abstract class BasePresenterActivity<B extends ViewDataBinding, P extends BasePresenter>
        extends BaseActivity<B> implements BaseView {
    protected P presenter;

    abstract P createPresenter();

    @Override
    protected void initData() {
        presenter = createPresenter();
        presenter.attachView(this);
    }


    @Override
    protected void onDestroy() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroy();
    }
}
