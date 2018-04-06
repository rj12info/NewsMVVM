package com.example.newsapp.ui.sourcelistscreen;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.example.newsapp.data.model.api.Source;
import com.example.newsapp.ui.base.BaseViewModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jayanth on 20/02/18.
 */

public class NewsSourceViewModel extends BaseViewModel {

  private MutableLiveData<ArrayList<Source>> listMutableLiveData;
  private ObservableArrayList<Source> observableArrayList;

  public NewsSourceViewModel() {
    listMutableLiveData = new MutableLiveData<>();
    observableArrayList = new ObservableArrayList<>();
  }

  public void getNewsSources() {
    setIsLoading(true);
    addDisposable(getDataManager().getNewsSources()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .map(response -> response.sources).subscribe(list -> {
          setIsLoading(false);
          listMutableLiveData.postValue(list);
        }));
  }

  public MutableLiveData<ArrayList<Source>> getMutableLiveData() {
    return listMutableLiveData;
  }

  public ObservableArrayList<Source> getObservableArrayList() {
    return observableArrayList;
  }
}