package com.example.newsapp.business.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavedDTO {
    @SerializedName("news")
    @Expose
    private NewsDTO news;

    @SerializedName("watches")
    @Expose
    private int watches;
}
