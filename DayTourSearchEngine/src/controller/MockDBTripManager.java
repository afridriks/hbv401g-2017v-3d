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
import model.Trip;

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
        return trips;
    }
    
    public void updateAvailablePlaces(Trip t) throws ClassNotFoundException {
    }
    
}
