package com.example.newsapp.ui.sourcelistscreen;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.databinding.LayoutSourceItemBinding;


/**
 * Created by Jayanth on 21/02/18.
 */

public class ViewHolderFactory {

  public static NewsSourceListViewHolder getViewHolder(ViewGroup parent, int viewType) {
    LayoutSourceItemBinding binding =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
            R.layout.layout_source_item, parent, false);
    return new NewsSourceListViewHolder(binding);
  }
}
