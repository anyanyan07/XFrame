package com.ayy.xframe.config;

import com.ayy.xframe.base.BaseResponse;
import com.ayy.xframe.bean.Banner;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface Api {
    /**
     * 首页banner
     */
    @GET("banner/json")
    Observable<BaseResponse<List<Banner>>> getBanner();
}
