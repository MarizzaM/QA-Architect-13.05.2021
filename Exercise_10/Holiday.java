package com.example.demo;

public class Holiday {
    private int id;
    private String name;
    private int day;
    private int month;
    private int length;

    public Holiday() {
    }

    public Holiday(int id, String name, int day, int month, int length) {
        this.id = id;
        this.name = name;
        this.day = day;
        this.month = month;
        this.length = length;
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

    public int getLength() {
        return length;
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

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", month=" + month +
                ", length=" + length +
                '}';
    }
}
