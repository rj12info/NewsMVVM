package com.example.newsapp.data;

import com.example.newsapp.data.model.api.SourceDetailResponse;
import com.example.newsapp.data.model.api.SourceListResponse;
import com.example.newsapp.data.remote.ApiHelper;

import io.reactivex.Single;

/**
 * This class is abstracted from API helper but uses APIhelper class to make
 * calls against sources and the corresponding details api
 * Created by Jayanth on 21/02/18.
 */

public class AppDataManager implements DataManager {
  private static volatile AppDataManager INSTANCE;
  private ApiHelper apiHelper;

  private AppDataManager() {

  }

  public static AppDataManager getInstance(ApiHelper apiHelper) {
    if (INSTANCE == null) {
      synchronized (AppDataManager.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppDataManager();
          INSTANCE.apiHelper = apiHelper;
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<SourceListResponse> getNewsSources() {
    return apiHelper.getNewsSources();
  }

  @Override
  public Single<SourceDetailResponse> getSourceDetails(String sourceId, String apiKey) {
    return apiHelper.getSourceDetails(sourceId, apiKey);
  }
}
