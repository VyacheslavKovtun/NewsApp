package com.example.newsapp.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.newsapp.R;
import com.example.newsapp.adapters.NewsAdapter;
import com.example.newsapp.business.services.NewsService;
import com.example.newsapp.business.services.models.DataNewsResponse;
import com.example.newsapp.business.services.models.Hit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFragment extends Fragment {

    NewsViewModel newsViewModel;
    List<Hit> news = new ArrayList<>();
    GridView gvNews;
    NewsAdapter adapter;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        newsViewModel = new NewsViewModel(news);
        View root = inflater.inflate(R.layout.fragment_news, container, false);
        gvNews = root.findViewById(R.id.gvNews);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.datanews.io/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        NewsService newsService = retrofit.create(NewsService.class);
        newsService.getAllNews().enqueue(new Callback<DataNewsResponse>() {
            @Override
            public void onResponse(Call<DataNewsResponse> call, Response<DataNewsResponse> response) {
                DataNewsResponse body = response.body();
                news.addAll(body.getHits());

                adapter = new NewsAdapter(root.getContext(), R.layout.news_layout, news);
                gvNews.setAdapter(adapter);

                gvNews.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //gvNews.getSelectedItem(); - open selected item to read a full info
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
            }

            @Override
            public void onFailure(Call<DataNewsResponse> call, Throwable t) {
            }
        });

        return root;
    }
}