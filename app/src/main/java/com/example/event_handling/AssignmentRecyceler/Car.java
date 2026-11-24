package com.example.event_handling.AssignmentRecyceler;

import java.io.Serializable;

public class Car implements Serializable {
    private int id;
    private String name, model , color;
    private int image;


    public Car(String name, String model, String color, int image) {
        this.name = name;
        this.model = model;
        this.color = color;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setCar(String car) {
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
