/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Booking;

/**
 *
 * @author andri
 */
public class MockDBBookingManager {
    private Connection myConn;
    private PreparedStatement myStmt;
    private ResultSet myRs;
    private final String dbname;
    
    public MockDBBookingManager(String dbname) {
        this.dbname = dbname;
    }
    
     public void bookTrip(Booking booking) throws ClassNotFoundException {
     }
     
     public void cancelBooking(Booking booking) throws ClassNotFoundException {
     }
}
