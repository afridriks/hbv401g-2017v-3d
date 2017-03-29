/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Booking;
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
public class DBBookingManagerTest {
    
    public DBBookingManagerTest() {
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
     * Test of bookTrip method, of class DBBookingManager.
     */
    @Test
    public void testBookTrip() throws Exception {
        System.out.println("bookTrip");
        Booking booking = null;
        DBBookingManager instance = null;
        instance.bookTrip(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelBooking method, of class DBBookingManager.
     */
    @Test
    public void testCancelBooking() throws Exception {
        System.out.println("cancelBooking");
        Booking booking = null;
        DBBookingManager instance = null;
        instance.cancelBooking(booking);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DBBookingManager.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DBBookingManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
