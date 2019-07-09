package com.cinema.client.data.movie;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Random;

public class Movie implements Serializable {
    private int id;
    private String title;
    private String shortDescription;
    private String fullDescription;
    private String posterUrl;
    private String verticalPosterUrl;
    private String videoUrl;

    public String getVerticalPosterUrl() {
        return verticalPosterUrl;
    }

    public void setVerticalPosterUrl(String verticalPosterUrl) {
        this.verticalPosterUrl = verticalPosterUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    private long releaseDateInMills;

    public Movie() {
    }

    public Movie(int id, String title, String shortDescription, String fullDescription, String posterUrl, long releaseDateInMills) {
        this.id = id;
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.posterUrl = posterUrl;
        this.releaseDateInMills = releaseDateInMills;
    }

    public Movie(String title, String shortDescription, String fullDescription, String posterUrl){
        this.title = title;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.posterUrl = posterUrl;
        this.releaseDateInMills = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public long getReleaseDateInMills() {
        return releaseDateInMills;
    }

    public void setReleaseDateInMills(long releaseDateInMills) {
        this.releaseDateInMills = releaseDateInMills;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", posterUrl='" + posterUrl + '\'' +
                ", releaseDateInMills=" + releaseDateInMills +
                '}';
    }
}
