package com.example.newsapp.business.services;

import com.example.newsapp.business.dto.NewsDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsService {
    @GET("/news")
    Call<List<NewsDTO>> getAllNews();
}
