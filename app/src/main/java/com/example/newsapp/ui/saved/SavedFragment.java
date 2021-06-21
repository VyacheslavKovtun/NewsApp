package com.example.newsapp.ui.saved;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.newsapp.R;
import com.example.newsapp.adapters.NewsAdapter;
import com.example.newsapp.business.services.models.Hit;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SavedFragment extends Fragment {

    SavedViewModel savedViewModel;
    static List<Hit> saved = new ArrayList<>();
    GridView gvSaved;
    NewsAdapter adapter;

    public SavedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        savedViewModel = new SavedViewModel(saved);
        View root = inflater.inflate(R.layout.fragment_saved, container, false);
        gvSaved = root.findViewById(R.id.gvSaved);

        SugarContext.init(root.getContext());

        saved.clear();
        saved.addAll(Hit.listAll(Hit.class));
        Collections.sort(saved, (h1, h2) -> h2.getWatches() - h1.getWatches());

        adapter = new NewsAdapter(root.getContext(), R.layout.news_layout, saved, true);
        gvSaved.setAdapter(adapter);

        return root;
    }
}