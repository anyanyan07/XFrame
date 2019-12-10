package com.ayy.xframe.ui;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ayy.xframe.R;
import com.ayy.xframe.base.BaseActivity;
import com.ayy.xframe.config.Constant;
import com.ayy.xframe.databinding.ActivitySplashBinding;
import com.ayy.xframe.util.RxThreadUtil;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    private int second = 3;
    private Disposable timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initData() {
        countdown();
    }

    //倒计时进入主页
    private void countdown() {
        timer = Observable.interval(0, 1000, TimeUnit.MILLISECONDS)
                .take(second + 1)
                .compose(RxThreadUtil.observableToMain())
                .subscribe(aLong -> {
                    binding.second.setText(String.valueOf(second - aLong));
                    if (aLong >= second) {
                        goMain();
                    }
                });
    }

    private void goMain() {
        ARouter.getInstance().build(Constant.MAIN).navigation();
    }

    @Override
    protected void onDestroy() {
        if (timer != null && !timer.isDisposed()) {
            timer.dispose();
            timer = null;
        }
        super.onDestroy();
    }
}
