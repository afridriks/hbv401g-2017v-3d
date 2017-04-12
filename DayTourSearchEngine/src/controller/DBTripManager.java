/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TourCompany;
import model.Trip;

/**
 *
 * @author Einar Andreas Helgason, Háskóli Íslands, eah8@hi.is
 */
public final class DBTripManager {

    private Connection myConn;
    private PreparedStatement myStmt;
    private ResultSet myRs;
    private final String dbname;
    
    public DBTripManager(String dbname) throws SQLException {
        this.dbname = dbname;
    }
 
    public Trip[] search(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, String type, String area) throws SQLException, ClassNotFoundException {
        ArrayList<Trip> trips;
        trips = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            
            
            // ná í Tourcompanies og búa til objects
            ArrayList<TourCompany> tc = new ArrayList<>();
            myStmt = myConn.prepareStatement("SELECT * FROM TourCompany;");
            myRs = myStmt.executeQuery();

            while(myRs.next()) {
                tc.add(new TourCompany(myRs.getInt("id"),myRs.getString("name"),myRs.getInt("phone"),myRs.getString("address"),myRs.getString("email")));
              	//System.out.println(myRs.getInt("id")+myRs.getString("name")+myRs.getInt("phone")+myRs.getString("address")+myRs.getString("email"));
            }            
            
            String queryString = "Select * FROM Trip WHERE ";
            queryString += tripName.length() == 0 ? "" : "name LIKE ? AND ";
            queryString += description.length() == 0 ? "": "description LIKE ? AND ";
            queryString += "date = ? AND ";
            queryString += "startTime >= ? OR ";
            queryString += "startTime <= ? OR ";
            queryString += familyFriendly ? "familyFriendly = 1 AND " : "";
            queryString += accessible ? "accessible = 1 AND " : "";
            queryString += "price >= ? AND ";
            queryString += "price <= ? AND ";
            queryString += "typeName = ? AND ";
            queryString += "area = ? ;";
            
            myStmt = myConn.prepareStatement(queryString);
            int i = 1;
            if(tripName.length() != 0){
                myStmt.setString(i,"%"+tripName+"%");
                i++;
            }
            if (description.length() != 0){
                myStmt.setString(i,"%"+description+"%");
                i++;
            }
            myStmt.setString(i,date.toString());
            i++;
            myStmt.setString(i,startTime.toString());
            i++;
            myStmt.setString(i,endTime.toString());
            i++;
            myStmt.setString(i,Integer.toString(minPrice));
            i++;
            myStmt.setString(i,Integer.toString(maxPrice));
            i++;
            myStmt.setString(i,type);
            i++;
            myStmt.setString(i,area);
            
            myStmt.setQueryTimeout(30);
            
            myRs = myStmt.executeQuery();
 
            // breyta ResultSet í fylki af Trip
             while(myRs.next()) {
                // finna rétt tourcompany
                TourCompany newTC = null;
                for(TourCompany tourCo : tc) {
                    if(tourCo.getId() == myRs.getInt("tourCompanyId")) {
                        newTC = tourCo;
                        break;
                    }
                }
                Trip newTrip = new Trip(myRs.getInt("id"),myRs.getString("name"),Date.valueOf(myRs.getString("date")),Time.valueOf(myRs.getString("startTime")+":00"),Time.valueOf(myRs.getString("endTime")+":00"),myRs.getString("description"),myRs.getInt("price"),myRs.getString("typeName"),myRs.getString("area"),myRs.getString("area"),myRs.getInt("maxTravelers"),(myRs.getInt("familyFriendly")==1),(myRs.getInt("accessible")==1),newTC,myRs.getInt("availablePlaces"));
                trips.add(newTrip);
                // bara til að testa
              	//System.out.println(myRs.getString("name") + ", " + myRs.getInt("maxTravelers") + ", " + myRs.getString("date") + ", " + myRs.getString("startTime"));
            }
            
        } catch (SQLException ex) {
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

        return trips.toArray(new Trip[0]);
    }
   
    public void updateAvailablePlaces(Trip t) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            myStmt = myConn.prepareStatement("UPDATE Trip SET availableplaces = ? WHERE id = ?;");
            myStmt.setInt(1,t.getAvailablePlaces());
            myStmt.setInt(2,t.getId());            
            
            myStmt.setQueryTimeout(30);
            
            myStmt.executeUpdate();
            
        } catch (SQLException ex) {
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
    }
 
    
    // main fall til að testa
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBTripManager man = new DBTripManager("daytrips.db");
        Trip[] trips = man.search("",Date.valueOf("2017-06-22"),Time.valueOf("09:00:00"),Time.valueOf("11:00:00"),"mm",false,false,5000,30000,"Horse Trips","Selfoss");
        
        for(Trip t: trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getDate() + ", " + t.getTourCompany().getName() + ", " + t.getType() + ", " + t.getArea() + ", " + t.getLocation());
        }
    }
    
}
