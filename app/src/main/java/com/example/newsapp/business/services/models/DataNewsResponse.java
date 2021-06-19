package com.example.newsapp.business.services.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataNewsResponse {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("numResults")
    @Expose
    private Integer numResults;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }
}
