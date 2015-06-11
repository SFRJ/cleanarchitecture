package com.djordje.cleanarchitecture.core.entities;

public class TimeReport {

    private String location;
    private String time;

    public TimeReport(String location, String time) {
        this.location = location;
        this.time = time;
    }


    public String getLocation() {
        return location;
    }

    public String getTime() {
        return time;
    }

}
