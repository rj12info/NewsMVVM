package com.example.newsapp.data.remote;

import com.example.newsapp.data.model.api.SourceDetailResponse;
import com.example.newsapp.data.model.api.SourceListResponse;
import com.example.newsapp.data.remote.service.SourceDetailService;
import com.example.newsapp.data.remote.service.SourceListService;
import com.example.newsapp.utils.NetworkHelper;

import io.reactivex.Single;

/**
 * Singleton class to make API calls. We can add more here
 * Created by Jayanth on 21/02/18.
 */

public class AppApiHelper implements ApiHelper {
  private static volatile AppApiHelper INSTANCE;

  private AppApiHelper() {

  }

  public static AppApiHelper getInstance() {
    if (INSTANCE == null) {
      synchronized (AppApiHelper.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppApiHelper();
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<SourceListResponse> getNewsSources() {
    return NetworkHelper.getRetrofit().create(SourceListService.class).getNewsSources();
  }

  @Override
  public Single<SourceDetailResponse> getSourceDetails(String sourceId, String apiKey) {
    return NetworkHelper.getRetrofit()
        .create(SourceDetailService.class)
        .getSourceDetails(sourceId, apiKey);
  }
}
