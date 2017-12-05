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
public class SysAdminTest {
    
//    public SysAdminTest() {
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
     * Test of getLname method, of class SysAdmin.
     */
    @Test
    public void testGetLname() {
        System.out.println("getLname");
        SysAdmin instance = new SysAdmin("joe", "schmo", "admin", "abc", "email");;
        String expResult = "schmo";
        String result = instance.getLname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getfName method, of class SysAdmin.
     */
    @Test
    public void testGetfName() {
        System.out.println("getfName");
        SysAdmin instance = new SysAdmin("joe", "schmo", "admin", "abc", "email");;
        String expResult = "joe";
        String result = instance.getfName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class SysAdmin.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        SysAdmin instance = new SysAdmin("joe", "schmo", "admin", "abc", "email");;
        String expResult = "admin";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class SysAdmin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        SysAdmin instance = new SysAdmin("joe", "schmo", "admin", "abc", "email");;
        String expResult = "abc";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class SysAdmin.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        SysAdmin instance = new SysAdmin("joe", "schmo", "admin", "abc", "email");;
        String expResult = "email";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
