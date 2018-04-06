package com.example.newsapp.data.remote;

import com.example.newsapp.data.model.api.SourceDetailResponse;
import com.example.newsapp.data.model.api.SourceListResponse;

import io.reactivex.Single;

/**
 * Created by Jayanth on 21/02/18.
 */

public interface ApiHelper {
  Single<SourceListResponse> getNewsSources();

  Single<SourceDetailResponse> getSourceDetails(String sourceId, String apiKey);
}
