package com.ayy.xframe.base;

public class BasePresenter<V extends BaseView> {
    protected V view;

    public void attachView(V view){
        this.view = view;
    }

    public void detachView(){
        if (view != null) {
            view = null;
        }
    }
}
