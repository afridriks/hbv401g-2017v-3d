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
 
    public Trip[] search(String tripName, Date date, Time startTime, Time endTime, String description, Boolean familyFriendly, Boolean accessible, int minPrice, int maxPrice, int type, int location) throws SQLException, ClassNotFoundException {
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
  
            // ef familyFriendly er TRUE þá viljum við leita að "familyFriendly = 1"
            // ef familyFriendly er FALSE þá viljum við ekki breyta leitarstrengnum því
            // þá erum við að takmarka okkur við trips sem eru EKKI familyFriendly.
            // eins með accessible
            String familyFriendlyAccessible = makeFFAString(familyFriendly, accessible);
            
            myStmt = myConn.prepareStatement("SELECT * FROM Trip "
                    + "WHERE name LIKE ? "
                    + "AND description LIKE ? "
                    + "AND date = ? "
                    + "AND startTime >= ? "
                    + "AND startTime <= ? "
                    + "AND price >= ? "
                    + "AND price <= ? "
                    + "AND typeId = ? "
                    + "AND locationId = ? "
                    + familyFriendlyAccessible + ";");
            myStmt.setString(1,"%"+tripName+"%");
            myStmt.setString(2,"%"+description+"%");
            myStmt.setString(3,date.toString());
            myStmt.setString(4,startTime.toString());
            myStmt.setString(5,endTime.toString());
            myStmt.setString(6,Integer.toString(minPrice));
            myStmt.setString(7,Integer.toString(maxPrice));
            myStmt.setString(8,Integer.toString(type));
            myStmt.setString(9,Integer.toString(location));
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
                Trip newTrip = new Trip(myRs.getInt("id"),myRs.getString("name"),Date.valueOf(myRs.getString("date")),Time.valueOf(myRs.getString("startTime")+":00"),Time.valueOf(myRs.getString("endTime")+":00"),myRs.getString("description"),myRs.getInt("price"),null,null,null,myRs.getInt("maxTravelers"),(myRs.getInt("familyFriendly")==1),(myRs.getInt("accessible")==1),newTC,myRs.getInt("availablePlaces"));
                trips.add(newTrip);
                // bara til að testa
              	//System.out.println(myRs.getString("name") + ", " + myRs.getInt("maxTravelers") + ", " + myRs.getString("date") + ", " + myRs.getString("startTime"));
            }
            
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
        
        return trips.toArray(new Trip[0]);
    }
    
    private String makeFFAString(Boolean a, Boolean b) {
        String res = "";
        if(a) {
            res = res + "AND familyFriendly = 1";
        }
        if(b) {
            res = res + "AND accessible = 1";
        }
        return res;
    }
    
    public void updateAvailablePlaces(Trip t) throws ClassNotFoundException {
        try {
            Class.forName("org.sqlite.JDBC");
            myConn = DriverManager.getConnection("jdbc:sqlite:"+dbname);
            myStmt = myConn.prepareStatement("UPDATE Trip SET availableplaces = ? WHERE id = ?;");
            myStmt.setInt(1,t.getAvailablePlaces());
            myStmt.setInt(2,t.getId());            
            
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
 
    
    // main fall til að testa
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBTripManager man = new DBTripManager("daytrips.db");
        Trip[] trips = man.search("hest",Date.valueOf("2017-06-22"),Time.valueOf("09:00:00"),Time.valueOf("11:00:00"),"mm",false,false,10000,20000,2,1);
        
        for(Trip t: trips) {
            System.out.println(t.getName() + ", " + t.getAvailablePlaces() + ", " + t.getDate() + ", " + t.getTourCompany().getName());
        }
    }
    
}
