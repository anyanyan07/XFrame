package com.ayy.xframe.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayy.xframe.R;
import com.ayy.xframe.bean.Article;

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
        View view = LayoutInflater.from(context).inflate(R.layout.article_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articleList.get(position);
        if (article != null) {
            holder.title.setText(article.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return articleList == null ? 0 : articleList.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }

}
