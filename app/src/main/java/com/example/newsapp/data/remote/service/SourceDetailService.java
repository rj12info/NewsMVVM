package com.example.newsapp.data.remote.service;

import com.example.newsapp.data.model.api.SourceDetailResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jayanth on 05/04/18.
 */

public interface SourceDetailService {
  @GET("articles/")
  Single<SourceDetailResponse> getSourceDetails(@Query("source") String sourceId,
                                               @Query("apiKey") String apiKey);
}
