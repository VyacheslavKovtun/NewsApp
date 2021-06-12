package com.example.newsapp.business.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsDTO {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("authors")
    @Expose
    private List<String> authors = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("pubDate")
    @Expose
    private String pubDate;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("content")
    @Expose
    private String content;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}