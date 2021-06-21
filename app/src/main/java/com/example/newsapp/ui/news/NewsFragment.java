package com.example.newsapp.ui.news;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.newsapp.R;
import com.example.newsapp.adapters.NewsAdapter;
import com.example.newsapp.business.services.NewsService;
import com.example.newsapp.business.services.models.DataNewsResponse;
import com.example.newsapp.business.services.models.Hit;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orm.SugarContext;

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
    Button btnSave;
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
        btnSave = root.findViewById(R.id.btnSave);

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
                SugarContext.init(root.getContext());

                List<Hit> savedHits = Hit.listAll(Hit.class);
                List<Hit> hits = body.getHits();

                for (Hit sHit : savedHits) {
                    Hit hit = hits.stream().filter(h -> h.getUrl().equals(sHit.getUrl())).findFirst().get();
                    hits.remove(hit);
                }

                news.addAll(hits);

                adapter = new NewsAdapter(root.getContext(), R.layout.news_layout, news);
                gvNews.setAdapter(adapter);

                /*Intent intent = new Intent(root.getContext(), ViewHitActivity.class);

                gvNews.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Hit selHit = news.get(position);
                        intent.putExtra(Hit.class.getSimpleName(), selHit);
                        startActivity(intent);
                    }
                });*/
            }

            @Override
            public void onFailure(Call<DataNewsResponse> call, Throwable t) {
            }
        });

        return root;
    }
}