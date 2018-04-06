package com.example.newsapp.ui.sourcelistscreen;

import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.newsapp.data.model.api.Source;

/**
 * Created by Jayanth on 21/02/18.
 */

public class NewsSourceListAdapter extends RecyclerView.Adapter<NewsSourceListViewHolder> {
  private ObservableArrayList<Source> observableArrayList;

  public NewsSourceListAdapter(ObservableArrayList<Source> observableArrayList) {
    this.observableArrayList = observableArrayList;
  }

  @Override
  public NewsSourceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return ViewHolderFactory.getViewHolder(parent, viewType);
  }

  @Override
  public void onBindViewHolder(NewsSourceListViewHolder holder, int position) {
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
