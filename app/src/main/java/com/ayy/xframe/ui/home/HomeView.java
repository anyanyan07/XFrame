package com.ayy.xframe.ui.home;

import com.ayy.xframe.base.BaseResWithPage;
import com.ayy.xframe.base.BaseView;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.bean.HomeBanner;

import java.util.List;

public interface HomeView extends BaseView {
    void getBannerSuccess(List<HomeBanner> homeBannerList);

    void getArticleSuccess(BaseResWithPage<Article> res);
}
