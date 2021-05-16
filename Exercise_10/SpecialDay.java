package com.example.demo;

public class SpecialDay {
    private int id;
    private String name;
    private int day;
    private int month;

    public SpecialDay() {
    }

    public SpecialDay(int id, String name, int day, int month) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
