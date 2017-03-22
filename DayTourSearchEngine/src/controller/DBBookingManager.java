/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Booking;

/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public class DBBookingManager {

    private Connection myConn;
    private Statement myStmt;
    private ResultSet myRs;
    private final String dbname;
    
    public DBBookingManager(String dbname) {
        this.dbname = dbname;
    }
    
    public void bookTrip(Booking booking) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("Insert into Bookings ...");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(myConn != null)
                    myConn.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
    
    public void cancelBooking(Booking booking) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:daytrips.db");
            myStmt = myConn.createStatement();
            myStmt.executeUpdate("UPDATE Bookings SET active = false WHERE id == "+booking.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(myConn != null)
                    myConn.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }

}
