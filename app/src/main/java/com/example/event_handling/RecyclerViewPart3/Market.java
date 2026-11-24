package com.example.event_handling.RecyclerViewPart3;

public class Market {
     String name;
     int id;
     int history;
     String details;


    public Market(String name, int id, int history, String details) {
        this.name = name;
        this.id = id;
        this.history = history;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
