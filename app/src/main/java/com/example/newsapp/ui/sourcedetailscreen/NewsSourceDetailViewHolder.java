package com.example.newsapp.ui.sourcedetailscreen;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.newsapp.data.model.api.Article;
import com.example.newsapp.databinding.LayoutArticleItemBinding;

/**
 * Created by Jayanth on 21/02/18.
 */

public class NewsSourceDetailViewHolder extends RecyclerView.ViewHolder {
  private LayoutArticleItemBinding binding;

  public NewsSourceDetailViewHolder(LayoutArticleItemBinding binding) {
    super(binding.getRoot());
    this.binding = binding;
  }

  public void bindData(Article article) {
    binding.setArticle(article);
    binding.executePendingBindings();
  }

  @BindingAdapter("imageUrl")
  public static void setImageUrl(ImageView imageView, String url) {
    Context context = imageView.getContext();
    Glide.with(context).load(url).into(imageView);
  }
}
