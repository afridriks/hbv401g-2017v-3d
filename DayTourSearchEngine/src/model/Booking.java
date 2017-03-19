/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Sigurlaug
 */
public class Booking {
    
    private int id;
    private Customer customer;
    private Trip trip;
    private int numTravelers;
    private boolean hotelPickup;
    private boolean active;

    public Booking(int id, Customer customer, Trip trip, int numTravelers, boolean hotelPickup, boolean active) {
        this.id = id;
        this.customer = customer;
        this.trip = trip;
        this.numTravelers = numTravelers;
        this.hotelPickup = hotelPickup;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Trip getTrip() {
        return trip;
    }

    public int getNumTravelers() {
        return numTravelers;
    }

    public boolean isHotelPickup() {
        return hotelPickup;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
