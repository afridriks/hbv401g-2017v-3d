/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.Time;
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
     * Test of searchTrips method, of class TripController.
     */
    @Test
    public void testSearchTrips() throws Exception {
        System.out.println("searchTrips");
        String tripName = "";
        Date date = null;
        Time startTime = null;
        Time endTime = null;
        String description = "";
        Boolean familyFriendly = null;
        Boolean accessible = null;
        int minPrice = 0;
        int maxPrice = 0;
        int type = 0;
        int location = 0;
        TripController instance = new TripController();
        Trip[] expResult = null;
        Trip[] result = instance.searchTrips(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of bookTrip method, of class TripController.
     */
    @Test
    public void testBookTrip() throws Exception {
        System.out.println("bookTrip");
        String name = "";
        int phone = 0;
        String address = "";
        String email = "";
        Trip trip = null;
        int numTravelers = 0;
        Boolean hotelPickup = null;
        Boolean active = null;
        TripController instance = new TripController();
        instance.bookTrip(name, phone, address, email, trip, numTravelers, hotelPickup, active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
