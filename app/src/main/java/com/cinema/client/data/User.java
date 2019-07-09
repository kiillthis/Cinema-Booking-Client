package com.cinema.client.data;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String nickname;
    private String email;
    private String phone;
    private String card;
    private List<Integer> favorite;
    private Ticket ticket;

    public User() {
    }

    public User(String nickname, String email, String phone, String card, List<Integer> favorite, Ticket ticket) {
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.card = card;
        this.favorite = favorite;
        this.ticket = ticket;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public List<Integer> getFavorite() {
        return favorite;
    }

    public void setFavorite(List<Integer> favorite) {
        this.favorite = favorite;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
