/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Trip;

/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public final class DBTripManager {

    private Connection myConn;
    private Statement myStmt;
    private ResultSet myRs;
    
    public DBTripManager() throws SQLException {
        // ekkert hér
    }
 
    public Trip[] search(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, String type, String area, String location) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:daytrips.db");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("SELECT * FROM Trips");
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
        
        // hér þarf að breyta myRs í Trip[]
        
        return null;
    }
}
