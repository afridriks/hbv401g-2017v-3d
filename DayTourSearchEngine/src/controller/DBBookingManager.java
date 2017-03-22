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
    private PreparedStatement myStmt;
    private ResultSet myRs;
    private final String dbname;
    
    public DBBookingManager(String dbname) {
        this.dbname = dbname;
    }
    
    public void bookTrip(Booking booking) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            myStmt = myConn.prepareStatement("INSERT INTO Booking(customerId, tripId, numTravelers, hotelPickup, active) VALUES(?,?,?,?,?);");
            myStmt.setInt(1,booking.getCustomer().getId());
            myStmt.setInt(2,booking.getTrip().getId());
            myStmt.setInt(3,booking.getNumTravelers());
            myStmt.setInt(4,(booking.isHotelPickup() ? 1 : 0));
            myStmt.setInt(5,(booking.isActive() ? 1 : 0));

            myStmt.setQueryTimeout(30);
            
            myStmt.executeQuery();
            
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
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            myStmt = myConn.prepareStatement("UPDATE Booking SET active = 0 WHERE id = ?;");
            myStmt.setInt(1,booking.getId());
            
            myStmt.setQueryTimeout(30);
            
            myStmt.executeQuery();

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
    
    public static void main(String[] args) {
        // skrifa test hér
    }

}
