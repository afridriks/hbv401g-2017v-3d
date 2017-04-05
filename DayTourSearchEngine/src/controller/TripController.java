/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;   // líka til java.util.Date, en þessi hentar líklega betur fyrir okkur útaf SQLite
import java.sql.SQLException;
import java.sql.Time;
import java.util.Arrays;

import model.*;

/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public class TripController {
    
    private Trip[] results;
    private final DBTripManager tripManager;
    private final DBBookingManager bookingManager;
    
    public TripController() throws SQLException {
        tripManager = new DBTripManager("daytrips.db");
        bookingManager = new DBBookingManager("daytrips.db");
    }
    
    public Trip[] searchTrips(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, Integer type, Integer location) throws SQLException, ClassNotFoundException {
        results = tripManager.search(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        return results;
    }
    
    public Trip bookTrip(String name, int phone, String address, String email, Trip trip, int numTravelers, Boolean hotelPickup, Boolean active) throws ClassNotFoundException {
        if(name == null || phone < 0 || address == null || email == null || trip == null || numTravelers <= 0 || hotelPickup == null || active == null) {
            throw new IllegalArgumentException("Invalid argument");
        }        
        Customer customer = new Customer(0, name, phone, address, email);
        Booking booking = new Booking(0, customer, trip, numTravelers, hotelPickup, active);
        bookingManager.bookTrip(booking);
        trip.setAvailablePlaces(trip.getAvailablePlaces() - numTravelers);
        tripManager.updateAvailablePlaces(trip);
        return trip;
    }
    
    public Trip[] sortTripsByName(Trip[] trips) {
        if(trips.length <= 0) throw new IllegalArgumentException("Invalid argument");
        Arrays.sort(trips);
        return trips;
    }
    
    public Trip[] sortTripsByTime(Trip[] trips) {
        if(trips.length <= 0) throw new IllegalArgumentException("Invalid argument");
        return trips;
    }
    
    public Trip[] sortTripsByPrice(Trip[] trips) {
        if(trips.length <= 0) throw new IllegalArgumentException("Invalid argument");
        return trips;
    }
    
}
