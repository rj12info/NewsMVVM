package com.example.newsapp.ui.sourcedetailscreen;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.example.newsapp.data.model.api.Article;
import com.example.newsapp.ui.base.BaseViewModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jayanth on 20/02/18.
 */

public class NewsSourceDetailViewModel extends BaseViewModel {

  private MutableLiveData<ArrayList<Article>> listMutableLiveData;
  private ObservableArrayList<Article> observableArrayList;

  public NewsSourceDetailViewModel() {
    listMutableLiveData = new MutableLiveData<>();
    observableArrayList = new ObservableArrayList<>();
  }

  public void getSourceDetails(String sourceId, String apiKey) {
    setIsLoading(true);
    addDisposable(getDataManager().getSourceDetails(sourceId, apiKey)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .map(response -> response.articles).subscribe(list -> {
          setIsLoading(false);
          listMutableLiveData.postValue(list);
        }));
  }

  public MutableLiveData<ArrayList<Article>> getMutableLiveData() {
    return listMutableLiveData;
  }

  public ObservableArrayList<Article> getObservableArrayList() {
    return observableArrayList;
  }
}