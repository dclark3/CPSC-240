/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bpd3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author drado_000
 */
public class InventoryTest {
    
//    public InventoryTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }

    /**
     * Test of getQuantity method, of class Inventory.
     */
    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        int expResult = 4;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updateQ method, of class Inventory.
     */
    @Test
    public void testUpdateQ() {
        System.out.println("updateQ");
        int q = 9;
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        int expResult = 9;
        int result = instance.updateQ(q);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of addQ method, of class Inventory.
     */
    @Test
    public void testAddQ() {
        System.out.println("addQ");
        int q = 4;
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        int expResult = 8;
        int result = instance.addQ(q);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of subtractQ method, of class Inventory.
     */
    @Test
    public void testSubtractQ() {
        System.out.println("subtractQ");
        int q = 2;
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        int expResult = 2;
        int result = instance.subtractQ(q);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Inventory.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        String expResult = "saddle,1234567890,4.99,3.99,false,4";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class Inventory.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Inventory instance = new Inventory("saddle", 1234567890, 4.99, 3.99, false, 4);
        double expResult = 4.99;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
