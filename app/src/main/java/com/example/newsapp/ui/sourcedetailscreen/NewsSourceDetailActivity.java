package com.example.newsapp.ui.sourcedetailscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.widget.LinearLayout;

import com.example.newsapp.BR;
import com.example.newsapp.R;
import com.example.newsapp.databinding.ActivityNewsSourceDetailBinding;
import com.example.newsapp.ui.base.BaseActivity;
import com.example.newsapp.utils.AppConstants;

public class NewsSourceDetailActivity
    extends BaseActivity<ActivityNewsSourceDetailBinding, NewsSourceDetailViewModel> {
  private NewsSourceDetailViewModel mNewsSourceDetailViewModel;
  private ActivityNewsSourceDetailBinding mNewsSourceDetailBinding;
  private NewsSourceDetailAdapter mNewsSourceDetailAdapter;
  private String sourceId;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mNewsSourceDetailBinding = getDataBinding();
    initProgressBar();
    initRecyclerView();
    initData();
  }

  private void initProgressBar() {
    mNewsSourceDetailViewModel.getIsLoading().subscribe(o -> {
      if ((boolean) o) {
        showProgressBar();
      } else {
        hideProgressBar();
      }
    });
  }

  private void initRecyclerView() {
    mNewsSourceDetailBinding.rv.setLayoutManager(new LinearLayoutManager(this));
    mNewsSourceDetailAdapter =
        new NewsSourceDetailAdapter(mNewsSourceDetailViewModel.getObservableArrayList());
    mNewsSourceDetailBinding.rv.addItemDecoration(
        new DividerItemDecoration(this, LinearLayout.VERTICAL));
    mNewsSourceDetailBinding.rv.setAdapter(mNewsSourceDetailAdapter);
  }

  private void initData() {
    Intent intent = getIntent();
    if (intent != null && intent.hasExtra(AppConstants.SOURCE_ID)) {
      sourceId = intent.getStringExtra(AppConstants.SOURCE_ID);
    }
    if (TextUtils.isEmpty(sourceId)) {
      finish();
    }
    subscribeToLiveData();
    mNewsSourceDetailViewModel.getSourceDetails(sourceId, AppConstants.API_KEY);
  }

  private void subscribeToLiveData() {
    mNewsSourceDetailViewModel.getMutableLiveData().observe(this,
        sources -> {
          mNewsSourceDetailViewModel.getObservableArrayList().addAll(sources);
          mNewsSourceDetailAdapter.notifyDataSetChanged();
        });
  }

  @Override
  protected int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  protected NewsSourceDetailViewModel getViewModel() {
    mNewsSourceDetailViewModel = ViewModelProviders.of(this).get(NewsSourceDetailViewModel.class);
    return mNewsSourceDetailViewModel;
  }

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_news_source_detail;
  }
}
