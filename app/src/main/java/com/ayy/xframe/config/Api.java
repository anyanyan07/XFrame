package com.ayy.xframe.config;

import com.ayy.xframe.base.BaseResWithPage;
import com.ayy.xframe.base.BaseResponse;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.bean.HomeBanner;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    /**
     * 首页banner
     */
    @GET("banner/json")
    Observable<BaseResponse<List<HomeBanner>>> getBanner();

    /**
     * 首页文章列表
     */
    @GET("article/list/{page}/json")
    Observable<BaseResponse<BaseResWithPage<Article>>> getArticle(@Path("page") int page);
}
