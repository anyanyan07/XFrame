package com.ayy.xframe.config;

import com.ayy.xframe.base.BaseResponse;
import com.ayy.xframe.bean.Banner;
import com.ayy.xframe.util.RxThreadUtil;

import java.util.List;

import io.reactivex.Observable;

public class Http {
    /**
     * 首页banner
     */
    public static Observable<BaseResponse<List<Banner>>> getBanner(){
        return HttpManager.getInstance().api().getBanner()
                .compose(RxThreadUtil.observableToMain());
    }

}
