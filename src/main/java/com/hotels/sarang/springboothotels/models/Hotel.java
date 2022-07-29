package com.hotels.sarang.springboothotels.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "allhotels")
public class Hotel {


    private int id;
    private String name;
    private int weekdayPrice;
    private int weekendPrice;
    private Boolean isAvailable;
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
    public int getWeekdayPrice() {
        return weekdayPrice;
    }
    public void setWeekdayPrice(int weekdayPrice) {
        this.weekdayPrice = weekdayPrice;
    }
    public int getWeekendPrice() {
        return weekendPrice;
    }
    public void setWeekendPrice(int weekendPrice) {
        this.weekendPrice = weekendPrice;
    }
    public Boolean getIsAvailable() {
        return isAvailable;
    }
    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public Hotel(int id, String name, int weekdayPrice, int weekendPrice, Boolean isAvailable) {
        this.id = id;
        this.name = name;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.isAvailable = isAvailable;
    }
    public Hotel() {
    }

    
}
