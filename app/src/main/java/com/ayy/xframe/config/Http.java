package com.ayy.xframe.config;

import com.ayy.xframe.base.BaseResWithPage;
import com.ayy.xframe.base.BaseResponse;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.bean.HomeBanner;
import com.ayy.xframe.util.RxThreadUtil;

import java.util.List;

import io.reactivex.Observable;

public class Http {
    /**
     * 首页banner
     */
    public static Observable<BaseResponse<List<HomeBanner>>> getBanner() {
        return HttpManager.getInstance().api().getBanner()
                .compose(RxThreadUtil.observableToMain());
    }

    public static Observable<BaseResponse<BaseResWithPage<Article>>> getArticle(int page) {
        return HttpManager.getInstance().api().getArticle(page)
                .compose(RxThreadUtil.observableToMain());
    }

}
