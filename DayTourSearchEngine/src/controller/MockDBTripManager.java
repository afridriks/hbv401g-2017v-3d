/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import model.TourCompany;
import model.Trip;
import controller.TripController;

/**
 *
 * @author andri
 */
public class MockDBTripManager {

    private Connection myConn;
    private PreparedStatement myStmt;
    private ResultSet myRs;
    private final String dbname;
    
    public MockDBTripManager(String dbname) throws SQLException {
        this.dbname = dbname;
    }
    
    public Trip[] search(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, Integer type, Integer location) throws SQLException, ClassNotFoundException {
        Trip[] trips = new Trip[10];
        TourCompany tc = new TourCompany(1, "Fyrirtækið", 5675678, "hábær 15", "email@email.com");
        for(int i = 0; i < 10; i++){
            Trip trip = new Trip(i, "Ferð"+i, new Date(117, 05, 22+i), new Time(9+i, 0, 0), new Time(18+i, 0, 0), "", 1000+(i*100), "Gamanferð", "Heima", "Rvk", 20, false, false, tc, 20-i);
            trips[i] = trip;
        }
        return trips;
    }
    
    public void updateAvailablePlaces(Trip t) throws ClassNotFoundException {
    }
    
    // Til þess að prófa sort föll.
    public static void main(String[] args) {
        Trip[] trips = new Trip[10];
        TourCompany tc = new TourCompany(1, "Fyrirtækið", 5675678, "hábær 15", "email@email.com");
        for(int i = 0; i < 10; i++){
            Trip trip = new Trip(i, "Ferð"+(int)(Math.random()*10), new Date(117, 05, 22+i), new Time((int) (24*Math.random()), 0, 0), new Time((int) (24*Math.random()), 0, 0), "", (int) (1000+(100*Math.random())), "Gamanferð", "Heima", "Rvk", 20, false, false, tc, 20-i);
            trips[i] = trip;
        }
         for(Trip t: trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getStartTime()+ ", " + t.getPrice());
        }
         
        Trip[] sortedByPrice;
        //sortedByPrice = TripController.sortTripsByName(trips);
        
        //  for(Trip t: sortedByPrice) {
        //    System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getStartTime()+ ", " + t.getPrice());
        //}
    }
}