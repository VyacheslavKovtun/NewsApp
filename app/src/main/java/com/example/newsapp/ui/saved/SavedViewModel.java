package com.example.newsapp.ui.saved;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsapp.business.dto.SavedDTO;

import java.util.List;

public class SavedViewModel extends ViewModel {
    private MutableLiveData<List<SavedDTO>> mSaved;

    public SavedViewModel(List<SavedDTO> saved) {
        mSaved = new MutableLiveData<>();
        mSaved.setValue(saved);
    }

    public LiveData<List<SavedDTO>> getSaved() {
        return mSaved;
    }
}
