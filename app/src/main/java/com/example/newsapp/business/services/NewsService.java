package com.example.newsapp.business.services;

import com.example.newsapp.business.services.models.DataNewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface NewsService {
    @Headers("x-api-key: 0jc2u2jsfrzsx9konfsek0dyc")
    @GET("v1/news")
    Call<DataNewsResponse> getAllNews();
}
