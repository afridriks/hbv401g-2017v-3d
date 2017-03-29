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
public class DBTripManagerTest {
    
    public DBTripManagerTest() {
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
     * Test of search method, of class DBTripManager.
     */
    @Test
    public void testSearch() throws Exception {
        System.out.println("search");
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
        DBTripManager instance = null;
        Trip[] expResult = null;
        Trip[] result = instance.search(tripName, date, startTime, endTime, description, familyFriendly, accessible, minPrice, maxPrice, type, location);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateAvailablePlaces method, of class DBTripManager.
     */
    @Test
    public void testUpdateAvailablePlaces() throws Exception {
        System.out.println("updateAvailablePlaces");
        Trip t = null;
        DBTripManager instance = null;
        instance.updateAvailablePlaces(t);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class DBTripManager.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        DBTripManager.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
