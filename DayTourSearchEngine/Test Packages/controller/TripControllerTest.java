/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.Time;
import model.Booking;
import model.Customer;
import model.TourCompany;
import model.Trip;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andri
 */
public class TripControllerTest {
    
    public TripControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of sortTripsByName method, of class TripController.
     */
    @Test
    public void testsortTripsByName_ValidInput() throws Exception {
        TripController instance = new TripController();
        Trip[] trips = instance.searchTrips("", null, null, null, "", Boolean.FALSE, Boolean.FALSE, 0, 0, 0, 0);
        
        Trip[] sortedTrips = instance.sortTripsByName(trips);
        
        String currName = "";
        String prevName = "";
        
        for(Trip t : sortedTrips){
            currName = t.getName();
            if(prevName != "")
                assertTrue(currName.compareTo(prevName) >= 0);
            prevName = currName;
        }
        
    }
    
    @Test
    public void testsortTripsByName_InvalidInput() throws Exception {
        TripController instance = new TripController();
        Trip[] trips = new Trip[0];
        boolean thrown = false;
        try{
            Trip[] sortedTrips = instance.sortTripsByName(trips);
        }
        catch(IllegalArgumentException ex){
            thrown = true;
        }
        
        assertTrue(thrown);
        
    }
    
    /**
     * Test of sortTripsByTime method, of class TripController.
     */
    @Test
    public void testsortTripsByTime() throws Exception {

    }
    
    /**
     * Test of sortTripsByPrice method, of class TripController.
     */
    @Test
    public void testsortTripsByPrice() throws Exception {

    }

    /**
     * Test of bookTrip method, of class TripController.
     */
    @Test
    public void testBookTrip() throws Exception {
        TripController instance = new TripController();
        
        TourCompany tc = new TourCompany(1, "Fyrirtækið", 5675678, "hábær 15", "email@email.com");
        Trip trip = new Trip(1, "Ferð", new Date(117, 05, 22), new Time(9, 0, 0), new Time(18, 0, 0), "", 1000, "Gamanferð", "Heima", "Rvk", 20, false, false, tc, 20);
        
        Trip trip2 = instance.bookTrip("Jón Jónsson", 334234, "Jónsgeisli 5", "jon@jon.is", trip, 3, Boolean.TRUE, Boolean.TRUE);
        
        assertTrue(trip2.getAvailablePlaces() == 17);
    }    
}
