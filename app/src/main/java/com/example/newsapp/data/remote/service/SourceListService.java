package com.example.newsapp.data.remote.service;

import com.example.newsapp.data.model.api.SourceListResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by Jayanth on 05/04/18.
 */

public interface SourceListService {
  @GET("sources")
  Single<SourceListResponse> getNewsSources();
}
