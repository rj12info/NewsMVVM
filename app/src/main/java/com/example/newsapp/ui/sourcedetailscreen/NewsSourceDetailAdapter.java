package com.example.newsapp.ui.sourcedetailscreen;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.data.model.api.Article;
import com.example.newsapp.databinding.LayoutArticleItemBinding;

/**
 * Created by Jayanth on 21/02/18.
 */

public class NewsSourceDetailAdapter extends RecyclerView.Adapter<NewsSourceDetailViewHolder> {
  private ObservableArrayList<Article> observableArrayList;

  public NewsSourceDetailAdapter(ObservableArrayList<Article> observableArrayList) {
    this.observableArrayList = observableArrayList;
  }

  @Override
  public NewsSourceDetailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutArticleItemBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.layout_article_item, parent, false);
    return new NewsSourceDetailViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(NewsSourceDetailViewHolder holder, int position) {
    holder.bindData(observableArrayList.get(position));
  }

  @Override
  public int getItemCount() {
    if (observableArrayList == null) {
      return 0;
    }
    return observableArrayList.size();
  }
}
