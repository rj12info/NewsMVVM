package com.example.newsapp.ui.sourcelistscreen;

import android.support.v7.widget.RecyclerView;

import com.example.newsapp.data.model.api.Source;
import com.example.newsapp.databinding.LayoutSourceItemBinding;

/**
 * Created by Jayanth on 21/02/18.
 */

public class NewsSourceListViewHolder extends RecyclerView.ViewHolder {
  private LayoutSourceItemBinding binding;

  public NewsSourceListViewHolder(LayoutSourceItemBinding binding) {
    super(binding.getRoot());
    this.binding = binding;
  }

  public void bindData(Source source) {
    binding.setSource(source);
    binding.setHandler(new SourceActionHandler());
    binding.executePendingBindings();
  }
}
