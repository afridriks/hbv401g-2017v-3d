/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;   // líka til java.util.Date, en þessi hentar líklega betur fyrir okkur útaf SQLite
import java.sql.SQLException;
import java.sql.Time;

import model.*;

/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public class TripController {
    
    private Trip[] results;
    private final MockDBTripManager tripManager;
    private final MockDBBookingManager bookingManager;
    
    public TripController() throws SQLException {
        tripManager = new MockDBTripManager("daytrips.db");
        bookingManager = new MockDBBookingManager("daytrips.db");
    }
    
    public Trip[] searchTrips(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, Integer type, Integer location) throws SQLException, ClassNotFoundException {
        if(tripName == null || date == null || startTime == null || endTime == null || description == null || familyFriendly == null || accessible == null || minPrice > maxPrice || minPrice < 0 || maxPrice < 0) {
            throw new IllegalArgumentException("Invalid argument");
        }
        results = tripManager.search(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        return results;
    }
    
    public void bookTrip(String name, int phone, String address, String email, Trip trip, int numTravelers, Boolean hotelPickup, Boolean active) throws ClassNotFoundException {
        if(name == null || phone < 0 || address == null || email == null || trip == null || numTravelers <= 0 || hotelPickup == null || active == null) {
            throw new IllegalArgumentException("Invalid argument");
        }        
        Customer customer = new Customer(0, name, phone, address, email);
        Booking booking = new Booking(0, customer, trip, numTravelers, hotelPickup, active);
        bookingManager.bookTrip(booking);
        trip.setAvailablePlaces(trip.getAvailablePlaces() - numTravelers);
        tripManager.updateAvailablePlaces(trip);
    }
    
    public Trip[] sortTripsByName(Trip[] trips) {
        return null;
    }
    
    public Trip[] sortTripsByTime(Trip[] trips) {
        return null;
    }
    
    public Trip[] sortTripsByPrice(Trip[] trips) {
        return null;
    }
    
}
