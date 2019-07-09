package com.cinema.client.data;

import com.cinema.client.data.hall.Place;
import com.cinema.client.data.session.Session;

public class Ticket {
    private Place place;
    private Session session;

    public Ticket(Place place, Session session) {
        this.place = place;
        this.session = session;
    }

    public Ticket(){

    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
