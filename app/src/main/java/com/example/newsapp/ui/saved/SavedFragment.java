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

        adapter = new NewsAdapter(root.getContext(), R.layout.news_layout, saved);
        gvSaved.setAdapter(adapter);

        /*gvSaved.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(root.getContext(), ViewHitActivity.class);
                Hit selHit = saved.get(position);
                selHit.setWatches(selHit.getWatches() + 1);
                intent.putExtra(Hit.class.getSimpleName(), selHit);
                Hit.deleteAll(Hit.class);

                for(Hit hit: saved) {
                    Hit.save(hit);
                }

                startActivity(intent);
            }
        });*/

        return root;
    }
}