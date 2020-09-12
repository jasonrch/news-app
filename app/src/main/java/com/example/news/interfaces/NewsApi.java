package com.example.news.interfaces;


import com.example.news.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("v2/top-headlines")
    Call<NewsResponse> getTopNews(@Query("country") String country,
                                  @Query("apiKey") String key);

    @GET("v2/everything")
    Call<NewsResponse> getNewsByWord(@Query("q") String word,
                                     @Query("apiKey") String key);
}
