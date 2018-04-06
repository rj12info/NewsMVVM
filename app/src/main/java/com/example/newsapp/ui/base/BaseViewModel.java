package com.example.newsapp.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.example.newsapp.data.AppDataManager;
import com.example.newsapp.data.DataManager;
import com.example.newsapp.data.remote.AppApiHelper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by Jayanth on 21/02/18.
 */

public class BaseViewModel<T> extends ViewModel {
  private DataManager dataManager;
  private CompositeDisposable compositeDisposable;
  public PublishSubject<Boolean> isLoading = PublishSubject.create();

  public BaseViewModel() {
    dataManager =
        AppDataManager.getInstance(AppApiHelper.getInstance());
    compositeDisposable = new CompositeDisposable();
  }

  protected void addDisposable(Disposable disposable) {
    compositeDisposable.add(disposable);
  }

  public DataManager getDataManager() {
    return dataManager;
  }

  @Override
  protected void onCleared() {
    if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
    super.onCleared();
  }

  public void setIsLoading(boolean loading) {
    isLoading.onNext(loading);
  }

  public PublishSubject<Boolean> getIsLoading() {
    return isLoading;
  }
}
