package com.example.newsapp.ui.saved;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.business.services.models.Hit;

import java.util.List;

public class SavedViewModel extends ViewModel {
    private MutableLiveData<List<Hit>> mSaved;

    public SavedViewModel(List<Hit> saved) {
        mSaved = new MutableLiveData<>();
        mSaved.setValue(saved);
    }

    public LiveData<List<Hit>> getSaved() {
        return mSaved;
    }
}
