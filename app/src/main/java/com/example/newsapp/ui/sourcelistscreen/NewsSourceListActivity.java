package com.example.newsapp.ui.sourcelistscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.LinearLayout;

import com.example.newsapp.BR;
import com.example.newsapp.R;
import com.example.newsapp.databinding.ActivityNewsSourceListBinding;
import com.example.newsapp.ui.base.BaseActivity;

public class NewsSourceListActivity
    extends BaseActivity<ActivityNewsSourceListBinding, NewsSourceViewModel> {
  private NewsSourceViewModel mNewsSourceViewModel;
  private ActivityNewsSourceListBinding mNewsSourceListBinding;
  private NewsSourceListAdapter mNewsSourceListAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mNewsSourceListBinding = getDataBinding();
    initProgressBar();
    initRecyclerView();
    initData();
  }

  private void initProgressBar() {
    mNewsSourceViewModel.getIsLoading().subscribe(o -> {
      if ((boolean) o) {
        showProgressBar();
      } else {
        hideProgressBar();
      }
    });
  }

  private void initRecyclerView() {
    mNewsSourceListBinding.rv.setLayoutManager(new LinearLayoutManager(this));
    mNewsSourceListAdapter =
        new NewsSourceListAdapter(mNewsSourceViewModel.getObservableArrayList());
    mNewsSourceListBinding.rv.addItemDecoration(
        new DividerItemDecoration(this, LinearLayout.VERTICAL));
    mNewsSourceListBinding.rv.setAdapter(mNewsSourceListAdapter);
  }

  private void initData() {
    subscribeToLiveData();
    mNewsSourceViewModel.getNewsSources();
  }

  private void subscribeToLiveData() {
    mNewsSourceViewModel.getMutableLiveData().observe(null,
        sources -> {
          mNewsSourceViewModel.getObservableArrayList().addAll(sources);
          mNewsSourceListAdapter.notifyDataSetChanged();
        });
  }

  @Override
  protected int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  protected NewsSourceViewModel getViewModel() {
    mNewsSourceViewModel = ViewModelProviders.of(this).get(NewsSourceViewModel.class);
    return mNewsSourceViewModel;
  }

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_news_source_list;
  }
}
