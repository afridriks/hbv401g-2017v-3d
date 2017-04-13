/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;   
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
    
    public Trip[] searchTrips(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, String type, String location) throws SQLException, ClassNotFoundException {
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
    
    // Notkun: Trip[] sorted = sortTripsByName(trips);
    // Fyrir:  trips er listi af Trip hlutum.
    // Eftir:  Búið er að raða trips eftir nafni í vaxandi röð.
    public Trip[] sortTripsByName(Trip[] trips) {
        if(trips.length <= 0) throw new IllegalArgumentException("Invalid argument");
        Arrays.sort(trips);
        return trips;
    }
    
    // Notkun: Trip[] sorted = sortTripsByTime(trips);
    // Fyrir:  trips er listi af Trip hlutum.
    // Eftir:  Búið er að raða trips eftir upphafstíma í vaxandi röð.
    public Trip[] sortTripsByTime(Trip[] trips) {
        int inner;
        int outer;
        int n = trips.length;
        for(outer = 1; outer<n; outer++) {
            Trip temp = trips[outer];
            inner = outer;
            while( inner > 0 && trips[inner-1].getStartTime().after(temp.getStartTime()) ) {
                trips[inner] = trips[inner-1];
                inner--;
            }
           trips[inner] = temp;
        }
        return trips;
    }
    
    // Notkun: Trip[] sorted = sortTripsByPrice(trips);
    // Fyrir:  trips er listi af Trip hlutum.
    // Eftir:  Búið er að raða trips eftir verði í vaxandi röð.
    public Trip[] sortTripsByPrice(Trip[] trips) {
        int inner;
        int outer;
        int n = trips.length;
        for(outer = 1; outer<n; outer++) {
            Trip temp = trips[outer];
            inner = outer;
            while( inner > 0 && trips[inner-1].getPrice() >= temp.getPrice()) {
                trips[inner] = trips[inner-1];
                inner--;
            }
           trips[inner] = temp;
        }
        return trips;
    }
    
    public Booking[] GetBookingsByName(String name) throws SQLException, ClassNotFoundException{
        Trip[] trips = tripManager.getAllTrips();
        return bookingManager.GetBookingsByName(name, trips);
    }
    
    public void cancelBooking(Booking booking) throws ClassNotFoundException {
        int placesCancelled = booking.getNumTravelers();
        Trip trip = booking.getTrip();
        int placesBefore = trip.getAvailablePlaces();
        trip.setAvailablePlaces(placesBefore + placesCancelled);
        tripManager.updateAvailablePlaces(trip);
        bookingManager.cancelBooking(booking);
    }
    
}
