package com.example.newsapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.business.dto.NewsDTO;

import java.util.List;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<NewsDTO>> mNews;

    public NewsViewModel(List<NewsDTO> news) {
        mNews = new MutableLiveData<>();
        mNews.setValue(news);
    }

    public LiveData<List<NewsDTO>> getNews() {
        return mNews;
    }
}
