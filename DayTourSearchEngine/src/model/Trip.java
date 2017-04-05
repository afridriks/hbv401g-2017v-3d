/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;




/**
 *
 * @author Sigurlaug
 */
public class Trip implements Comparable<Trip> {
    
    private final int id;
    private final String name;
    private final Date date;
    private final Time startTime; 
    private final Time endTime;
    private final String description;
    private final int price;
    private final String type;
    private final String Area;
    private final String Location;
    private final int maxTravelers;
    private final boolean familyFriendly;
    private final boolean accessible;
    private final TourCompany tourCompany;
    private int availablePlaces;

    public Trip(int id, String name, Date date, Time startTime, Time endTime, String description, int price, String type, String Area, String Location, int maxTravelers, boolean familyFriendly, boolean accessible, TourCompany tourCompany, int availablePlaces) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.price = price;
        this.type = type;
        this.Area = Area;
        this.Location = Location;
        this.maxTravelers = maxTravelers;
        this.familyFriendly = familyFriendly;
        this.accessible = accessible;
        this.tourCompany = tourCompany;
        this.availablePlaces = availablePlaces;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getArea() {
        return Area;
    }

    public String getLocation() {
        return Location;
    }

    public int getMaxTravelers() {
        return maxTravelers;
    }

    public boolean isFamilyFriendly() {
        return familyFriendly;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public TourCompany getTourCompany() {
        return tourCompany;
    }

    public int getAvailablePlaces() {
        return availablePlaces;
    }

    public void setAvailablePlaces(int availablePlaces) {
        this.availablePlaces = availablePlaces;
    }

    @Override
    public int compareTo(Trip o) {
        return this.getName().compareTo(o.getName());
    }        
}
