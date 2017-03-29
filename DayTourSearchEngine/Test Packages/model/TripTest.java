/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.sql.Time;
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
public class TripTest {
    
    public TripTest() {
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
     * Test of getId method, of class Trip.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Trip instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Trip.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Trip instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Trip.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Trip instance = null;
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTime method, of class Trip.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Trip instance = null;
        Time expResult = null;
        Time result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class Trip.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Trip instance = null;
        Time expResult = null;
        Time result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Trip.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Trip instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Trip.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Trip instance = null;
        int expResult = 0;
        int result = instance.getPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Trip.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Trip instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class Trip.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        Trip instance = null;
        String expResult = "";
        String result = instance.getArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Trip.
     */
    @Test
    public void testGetLocation() {
        System.out.println("getLocation");
        Trip instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxTravelers method, of class Trip.
     */
    @Test
    public void testGetMaxTravelers() {
        System.out.println("getMaxTravelers");
        Trip instance = null;
        int expResult = 0;
        int result = instance.getMaxTravelers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFamilyFriendly method, of class Trip.
     */
    @Test
    public void testIsFamilyFriendly() {
        System.out.println("isFamilyFriendly");
        Trip instance = null;
        boolean expResult = false;
        boolean result = instance.isFamilyFriendly();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccessible method, of class Trip.
     */
    @Test
    public void testIsAccessible() {
        System.out.println("isAccessible");
        Trip instance = null;
        boolean expResult = false;
        boolean result = instance.isAccessible();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTourCompany method, of class Trip.
     */
    @Test
    public void testGetTourCompany() {
        System.out.println("getTourCompany");
        Trip instance = null;
        TourCompany expResult = null;
        TourCompany result = instance.getTourCompany();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailablePlaces method, of class Trip.
     */
    @Test
    public void testGetAvailablePlaces() {
        System.out.println("getAvailablePlaces");
        Trip instance = null;
        int expResult = 0;
        int result = instance.getAvailablePlaces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailablePlaces method, of class Trip.
     */
    @Test
    public void testSetAvailablePlaces() {
        System.out.println("setAvailablePlaces");
        int availablePlaces = 0;
        Trip instance = null;
        instance.setAvailablePlaces(availablePlaces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
