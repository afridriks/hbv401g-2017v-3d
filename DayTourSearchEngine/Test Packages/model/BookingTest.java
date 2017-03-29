/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class BookingTest {
    
    public BookingTest() {
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
     * Test of getId method, of class Booking.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Booking instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class Booking.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        Booking instance = null;
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTrip method, of class Booking.
     */
    @Test
    public void testGetTrip() {
        System.out.println("getTrip");
        Booking instance = null;
        Trip expResult = null;
        Trip result = instance.getTrip();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumTravelers method, of class Booking.
     */
    @Test
    public void testGetNumTravelers() {
        System.out.println("getNumTravelers");
        Booking instance = null;
        int expResult = 0;
        int result = instance.getNumTravelers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isHotelPickup method, of class Booking.
     */
    @Test
    public void testIsHotelPickup() {
        System.out.println("isHotelPickup");
        Booking instance = null;
        boolean expResult = false;
        boolean result = instance.isHotelPickup();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActive method, of class Booking.
     */
    @Test
    public void testIsActive() {
        System.out.println("isActive");
        Booking instance = null;
        boolean expResult = false;
        boolean result = instance.isActive();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActive method, of class Booking.
     */
    @Test
    public void testSetActive() {
        System.out.println("setActive");
        boolean active = false;
        Booking instance = null;
        instance.setActive(active);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
