/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Date;
import java.sql.Time;
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
    public void testSortTripsByName_ValidInput() throws Exception {
        
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = instance.searchTrips("", null, null, null, "", Boolean.FALSE, Boolean.FALSE, 0, 0, 0, 0);
        
        //Act        
        Trip[] sortedTrips = instance.sortTripsByName(trips);
        
        //Assert
        String currName = "";
        String prevName = "";
        
        for(Trip t : sortedTrips){
            currName = t.getName();
            if(!"".equals(prevName))
                assertTrue(currName.compareTo(prevName) >= 0);
            prevName = currName;
        }
        
    }
    
    @Test
    public void testSortTripsByName_InvalidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = new Trip[0];
        boolean thrown = false;
        
        //Act
        try{
            Trip[] sortedTrips = instance.sortTripsByName(trips);
        }
        catch(IllegalArgumentException ex){
            thrown = true;
        }
        
        //Assert
        assertTrue(thrown);
        
    }
    
    /**
     * Test of sortTripsByTime method, of class TripController.
     */
    @Test
    public void testSortTripsByTime_ValidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = instance.searchTrips("", null, null, null, "", Boolean.FALSE, Boolean.FALSE, 0, 0, 0, 0);
        
        //Act
        Trip[] sortedTrips = instance.sortTripsByTime(trips);
        
        
        //Assert
        Time currTime;
        Time prevTime = new Time(0, 0, 0);
        
        for(Trip t : sortedTrips){
            currTime = t.getStartTime();
            assertTrue(currTime.after(prevTime));
            prevTime = currTime;
        }
    }
    
    @Test
    public void testSortTripsByTime_InvalidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = new Trip[0];
        boolean thrown = false;
        
        //Act
        try{
            Trip[] sortedTrips = instance.sortTripsByTime(trips);
        }
        catch(IllegalArgumentException ex){
            thrown = true;
        }
        
        //Assert
        assertTrue(thrown);
        
    }
    
    /**
     * Test of sortTripsByPrice method, of class TripController.
     */
    @Test
    public void testSortTripsByPrice_ValidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = instance.searchTrips("", null, null, null, "", Boolean.FALSE, Boolean.FALSE, 0, 0, 0, 0);
        
        //Act
        Trip[] sortedTrips = instance.sortTripsByPrice(trips);
        
        //Assert
        int currPrice = 0;
        int prevPrice = 0;
        
        for(Trip t : sortedTrips){
            currPrice = t.getPrice();
            if(prevPrice != 0)
                assertTrue(currPrice >= prevPrice);
            prevPrice = currPrice;
        }
        
    }
    
    @Test
    public void testsortTripsByPrice_InvalidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        Trip[] trips = new Trip[0];
        boolean thrown = false;
        
        //Act
        try{
            Trip[] sortedTrips = instance.sortTripsByPrice(trips);
        }
        catch(IllegalArgumentException ex){
            thrown = true;
        }
        
        //Arrange
        assertTrue(thrown);
    }

    /**
     * Test of bookTrip method, of class TripController.
     */
    @Test
    public void testBookTrip_ValidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        
        TourCompany tc = new TourCompany(1, "Fyrirtækið", 5675678, "hábær 15", "email@email.com");
        Trip trip = new Trip(1, "Ferð", new Date(117, 05, 22), new Time(9, 0, 0), new Time(18, 0, 0), "", 1000, "Gamanferð", "Heima", "Rvk", 20, false, false, tc, 20);
        
        //Act
        Trip trip2 = instance.bookTrip("Jón Jónsson", 334234, "Jónsgeisli 5", "jon@jon.is", trip, 3, true, true);
        
        //Assert
        assertTrue(trip2.getAvailablePlaces() == 17);
    }

    @Test
    public void testBookTrip_InvalidInput() throws Exception {
        //Arrange
        TripController instance = new TripController();
        TourCompany tc = new TourCompany(1, "Fyrirtækið", 5675678, "hábær 15", "email@email.com");
        Trip trip = new Trip(1, "Ferð", new Date(117, 05, 22), new Time(9, 0, 0), new Time(18, 0, 0), "", 1000, "Gamanferð", "Heima", "Rvk", 20, false, false, tc, 20);
        boolean thrown = false;
        
        //Act
        try{
            Trip trip2 = instance.bookTrip("", 0, "", "", trip, 0, null, null);
        }
        catch (IllegalArgumentException ex){
            thrown = true;
        }
        
        //Assert
        assertTrue(thrown);
    }
}
