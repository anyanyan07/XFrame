package com.ayy.xframe.base;

import androidx.databinding.ViewDataBinding;

public abstract class BasePresenterFragment<B extends ViewDataBinding, P extends BasePresenter> extends BaseFragment<B>
        implements BaseView {

    protected P presenter;

    public abstract P createPresenter();

    @Override
    protected void initData() {
        presenter = createPresenter();
        presenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        if (presenter != null) {
            presenter.detachView();
        }
        super.onDestroyView();
    }
}
