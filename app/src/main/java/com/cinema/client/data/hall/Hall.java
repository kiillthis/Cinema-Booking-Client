package com.cinema.client.data.hall;

import java.util.ArrayList;
import java.util.List;

public class Hall {
    private long id;
    private String name;
    private int rows;
    private int placesInRow;
    private List<Place> places;

    public Hall(long id, String name, int rows, int placesInRow) {
        this.id = id;
        this.name = name;
        this.rows = rows;
        this.placesInRow = placesInRow;
    }

    public List<Place> generatePlaces(){
        List<Place> places = new ArrayList<>();
        for(int row = 1; row <= rows; row++){
            for(int numberInRow = 1; numberInRow <= placesInRow; numberInRow++){ //number in row
                places.add(new Place(row,numberInRow));
            }
        }
        return places;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPlacesInRow() {
        return placesInRow;
    }

    public void setPlacesInRow(int placesInRow) {
        this.placesInRow = placesInRow;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}
