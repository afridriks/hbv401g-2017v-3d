/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Booking;
import model.Customer;
import model.Trip;

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
            
            Customer customer = booking.getCustomer();
            myStmt = myConn.prepareStatement("INSERT INTO Customer(name, phone, address, email) VALUES(?,?,?,?);");
            myStmt.setString(1,customer.getName());
            myStmt.setInt(2,customer.getPhoneNumber());
            myStmt.setString(3,customer.getAddress());
            myStmt.setString(4,customer.getEmail());

            myStmt.setQueryTimeout(30);
            
            myStmt.executeUpdate();
            
            myStmt = myConn.prepareStatement("SELECT * FROM Customer WHERE name like ? AND phone = ? AND address LIKE ? AND email LIKE ?;");
            myStmt.setString(1,customer.getName());
            myStmt.setInt(2,customer.getPhoneNumber());
            myStmt.setString(3,customer.getAddress());
            myStmt.setString(4,customer.getEmail());

            myStmt.setQueryTimeout(30);
            
            myRs = myStmt.executeQuery();

            int customerId = myRs.getInt("id");
            
            myStmt = myConn.prepareStatement("INSERT INTO Booking(customerId, tripId, numTravelers, hotelPickup, active) VALUES(?,?,?,?,?);");
            myStmt.setInt(1,customerId);
            myStmt.setInt(2,booking.getTrip().getId());
            myStmt.setInt(3,booking.getNumTravelers());
            myStmt.setInt(4,(booking.isHotelPickup() ? 1 : 0));
            myStmt.setInt(5,(booking.isActive() ? 1 : 0));

            myStmt.setQueryTimeout(30);
            
            myStmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBookingManager.class.getName()).log(Level.SEVERE, null, ex);
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
            
            myStmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DBBookingManager.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public Booking[] GetBookingsByName(String name, Trip[] trips) throws SQLException, ClassNotFoundException{
        ArrayList<Booking> bookings;
        bookings = new ArrayList<>();
        try{
           Class.forName("org.sqlite.JDBC");
           myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
           
          ArrayList<Customer> customers;
          customers = new ArrayList<>();
           myStmt = myConn.prepareStatement("SELECT * FROM Customer WHERE name LIKE ? ;");
           myStmt.setString(1,"%"+name+"%");
           myRs = myStmt.executeQuery();
           
           while(myRs.next()){
              customers.add(new Customer(myRs.getInt("id"), myRs.getString("name"), myRs.getInt("phone"), myRs.getString("address"), myRs.getString("email")));
            }
           
           String statement = "SELECT * FROM Booking WHERE active = 1 ";
                      
           for(int i = 0; i < customers.size(); i++){
               if(i == 0)
                   statement += "AND ( customerid = ? ";
               else
                   statement += "OR customerid = ? ";
           }           
           statement += ");";
                      
           myStmt = myConn.prepareStatement(statement);
           for(int i = 0; i < customers.size(); i++){
               myStmt.setString(i+1, Integer.toString(customers.get(i).getId()));
               System.out.println(customers.get(i).getId());
           }
           myRs = myStmt.executeQuery();
           
           
           while(myRs.next()) {
                // finna rétt trip
                Trip newTrip = null;
                for(Trip trip : trips) {
                    if(trip.getId() == myRs.getInt("tripId")) {
                        newTrip = trip;
                        break;
                    }
                }   
                Customer newCust = null;
                for(Customer cust : customers) {
                    if(cust.getId() == myRs.getInt("customerId")) {
                        newCust = cust;
                        break;
                    }
                }
                bookings.add(new Booking(myRs.getInt("id"), newCust, newTrip, myRs.getInt("numTravelers"), (myRs.getInt("hotelPickup")==1), (myRs.getInt("active")==1)));              
           }
        } 
        catch (SQLException ex) {
            Logger.getLogger(DBTripManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(myConn != null)
                    myConn.close();
            } catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
        return bookings.toArray(new Booking[0]);
    }
}
