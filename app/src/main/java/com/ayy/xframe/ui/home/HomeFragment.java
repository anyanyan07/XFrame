package com.ayy.xframe.ui.home;


import android.content.Context;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ayy.xframe.R;
import com.ayy.xframe.base.BasePresenterFragment;
import com.ayy.xframe.base.BaseResWithPage;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.bean.HomeBanner;
import com.ayy.xframe.databinding.FragmentHomeBinding;
import com.bumptech.glide.Glide;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.youth.banner.loader.ImageLoader;

import java.util.List;


public class HomeFragment extends BasePresenterFragment<FragmentHomeBinding, HomePresenter> implements HomeView, OnRefreshLoadMoreListener {

    private int page;
    private ArticleAdapter adapter;

    public HomeFragment() {
    }

    public static HomeFragment getInstance() {
        return new HomeFragment();
    }


    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    protected void initData() {
        super.initData();
        binding.smart.setOnRefreshLoadMoreListener(this);
        binding.rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new ArticleAdapter(null, context);
        binding.rv.setAdapter(adapter);
        presenter.getBanner();
        presenter.getArticle(0);
    }


    @Override
    public void getBannerSuccess(List<HomeBanner> homeBannerList) {
        binding.banner
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(((HomeBanner) path).getImagePath()).into(imageView);
                    }
                }).setImages(homeBannerList).start();
    }

    @Override
    public void getArticleSuccess(BaseResWithPage<Article> res) {
        if (res.getCurPage() == 1) {
            binding.smart.finishRefresh();
            adapter.setData(res.getDatas());
        } else {
            binding.smart.finishLoadMore(0, true, res.isOver());
            adapter.addData(res.getDatas());
        }
        page = res.getCurPage();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        presenter.getArticle(page);
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        presenter.getArticle(0);
    }
}
