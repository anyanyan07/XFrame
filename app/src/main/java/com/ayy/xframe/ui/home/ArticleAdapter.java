package com.ayy.xframe.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ayy.xframe.R;
import com.ayy.xframe.bean.Article;
import com.ayy.xframe.databinding.ArticleItemBinding;

import java.util.List;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {

    private List<Article> articleList;
    private Context context;

    public ArticleAdapter(List<Article> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
    }

    public void addData(List<Article> data) {
        if (articleList != null && data != null) {
            articleList.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void setData(List<Article> data) {
        if (data != null) {
            articleList = data;
            notifyDataSetChanged();
        }
    }


    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ArticleItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.article_item, parent, false);
        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        if (article != null) {
            holder.binding.title.setText(article.getTitle());
            holder.binding.type.setText("分类：" + article.getSuperChapterName() + "/" + article.getChapterName());
            holder.binding.author.setText("作者：" + article.getAuthor());
            holder.binding.time.setText(article.getNiceDate());
            holder.binding.heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "heart", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return articleList == null ? 0 : articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        ArticleItemBinding binding;

        public ArticleViewHolder(ArticleItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
