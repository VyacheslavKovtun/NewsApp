package com.example.newsapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.newsapp.R;
import com.example.newsapp.ViewHitActivity;
import com.example.newsapp.business.services.models.Hit;
import com.orm.SugarContext;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<Hit> {
    private LayoutInflater inflater;
    private List<Hit> news;
    private int resource;

    public NewsAdapter(@NonNull Context context, int resource, List<Hit> news) {
        super(context, resource, news);

        this.news = news;
        this.inflater = LayoutInflater.from(context);
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = inflater.inflate(resource, parent, false);

        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvPubDate = view.findViewById(R.id.tvPubDate);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        Button btnSave = view.findViewById(R.id.btnSave);
        Button btnView = view.findViewById(R.id.btnView);

        SugarContext.init(view.getContext());

        Hit curNews = news.get(position);
        tvTitle.setText(curNews.getTitle());
        tvPubDate.setText(curNews.getPubDate());
        tvDescription.setText(curNews.getDescription());

        btnSave.setOnClickListener(btn -> {
            List<Hit> saved = Hit.listAll(Hit.class);

            if(saved.stream().filter(h -> h.getUrl().equals(curNews.getUrl())).findFirst().get() == null) {
                Hit.save(curNews);
                news.remove(curNews);
                notifyDataSetChanged();
            }
        });

        btnView.setOnClickListener(btn -> {
            Intent intent = new Intent(view.getContext(), ViewHitActivity.class);
            curNews.setWatches(curNews.getWatches() + 1);
            intent.putExtra(Hit.class.getSimpleName(), curNews);
            getContext().startActivity(intent);
        });

        return view;
    }
}
