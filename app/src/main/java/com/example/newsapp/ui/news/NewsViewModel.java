package com.example.newsapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.business.services.models.Hit;

import java.util.List;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<List<Hit>> mNews;

    public NewsViewModel(List<Hit> news) {
        mNews = new MutableLiveData<>();
        mNews.setValue(news);
    }

    public LiveData<List<Hit>> getNews() {
        return mNews;
    }
}
