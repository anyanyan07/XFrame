package com.ayy.xframe.ui.home;

import com.ayy.xframe.base.BaseObserver;
import com.ayy.xframe.base.BasePresenter;
import com.ayy.xframe.base.BaseResWithPage;
import com.ayy.xframe.base.BaseResponse;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.bean.HomeBanner;
import com.ayy.xframe.config.Http;

import java.util.List;

public class HomePresenter extends BasePresenter<HomeView> {

    public void getBanner() {
        Http.getBanner().subscribe(new BaseObserver<BaseResponse<List<HomeBanner>>>() {
            @Override
            public void success(BaseResponse<List<HomeBanner>> listBaseResponse) {
                if (view != null) {
                    view.getBannerSuccess(listBaseResponse.getData());
                }
            }

            @Override
            public void error(Throwable e) {

            }
        });
    }

    public void getArticle(int page) {
        Http.getArticle(page).subscribe(new BaseObserver<BaseResponse<BaseResWithPage<Article>>>() {
            @Override
            public void success(BaseResponse<BaseResWithPage<Article>> baseResWithPageBaseResponse) {
                view.getArticleSuccess(baseResWithPageBaseResponse.getData());
            }

            @Override
            public void error(Throwable e) {

            }
        });
    }

}
