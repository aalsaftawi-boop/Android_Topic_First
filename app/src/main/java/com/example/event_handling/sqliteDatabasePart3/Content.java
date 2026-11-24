package com.example.event_handling.sqliteDatabasePart3;

public class Content {
    private int id;
    private String name;
    private String email;
    private String phone;
    private long yearOfBirth;


    public Content(String name, String email, String phone, long yearOfBirth) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.yearOfBirth = yearOfBirth;
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

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    @Override
    public String toString() {
        return "Content{\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
