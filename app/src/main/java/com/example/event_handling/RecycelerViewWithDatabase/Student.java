package com.example.event_handling.RecycelerViewWithDatabase;

import java.io.Serializable;

public class Student implements Serializable {
      private int id;
      private String name ;
      private double Gba;
      private String field;


    @Override
    public String toString() {
        return "Student{\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Gba=" + Gba +
                ", field='" + field + '\'' +
                '}';
    }


    public Student(int id, String name, double gba, String field) {
        this.id = id;
        this.name = name;
        Gba = gba;
        this.field = field;
    }

    public Student(String name, double gba, String field) {
        this.name = name;
        Gba = gba;
        this.field = field;
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

    public double getGba() {
        return Gba;
    }

    public void setGba(double gba) {
        Gba = gba;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
