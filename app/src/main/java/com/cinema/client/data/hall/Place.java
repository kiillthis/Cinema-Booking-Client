package com.cinema.client.data.hall;

import java.util.UUID;

public class Place {
    private long id;
    private int row;
    private int numberInRow;
    private boolean free;

    public Place(long id,int row, int numberInRow, boolean free) {
        this.id = id;
        this.row = row;
        this.numberInRow = numberInRow;
        this.free = free;
    }

    public Place(int row, int numberInRow) {
        this.id = row + numberInRow;
        this.row = row;
        this.numberInRow = numberInRow;
        this.free = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getNumberInRow() {
        return numberInRow;
    }

    public void setNumberInRow(int numberInRow) {
        this.numberInRow = numberInRow;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}
