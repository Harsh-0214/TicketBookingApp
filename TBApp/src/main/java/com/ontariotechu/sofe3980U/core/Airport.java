package com.ontariotechu.sofe3980U.core;

import java.time.ZoneId;

public class Airport {
    private String name;
    private ZoneId timeZone;
    private int ID;

    public Airport() {
    }
    public Airport(String name, String timeZone, int ID) {
        this.name = name;
        this.timeZone = ZoneId.of(timeZone); 
        this.ID = ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTimeZone(String timeZone) {
        this.timeZone = ZoneId.of(timeZone); 
    }
    public int getID() {
        return this.ID;
    }
    public String getName() {
        return this.name;
    }
    public String getTimeZone() {
        return this.timeZone.toString(); 
    }
}
