package com.cinema.client.data.session;

import java.io.Serializable;
import java.util.List;

public class Session implements Serializable {
    private long id;
    private long hallId;
    private long movieId;
    private long showTimeInMills;
    private String date;
    private String time;
    private List<Integer> seats;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public Session(){

    }

    public Session(long id, long hallId, long movieId, long showTimeInMills) {
        this.id = id;
        this.hallId = hallId;
        this.movieId = movieId;
        this.showTimeInMills = showTimeInMills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getHallId() {
        return hallId;
    }

    public void setHallId(long hallId) {
        this.hallId = hallId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public long getShowTimeInMills() {
        return showTimeInMills;
    }

    public void setShowTimeInMills(long showTimeInMills) {
        this.showTimeInMills = showTimeInMills;
    }
}
