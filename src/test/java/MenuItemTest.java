/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ville
 */
public class MenuItemTest {
    
    public MenuItemTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getName method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetName() {
        System.out.println("getName");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        MenuItem instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrice method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetPrice() {
        System.out.println("getPrice");
        MenuItem instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrice method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        MenuItem instance = null;
        instance.setPrice(price);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImagePath method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testGetImagePath() {
        System.out.println("getImagePath");
        MenuItem instance = null;
        String expResult = "";
        String result = instance.getImagePath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImagePath method, of class MenuItem.
     */
    @org.junit.jupiter.api.Test
    public void testSetImagePath() {
        System.out.println("setImagePath");
        String imagePath = "";
        MenuItem instance = null;
        instance.setImagePath(imagePath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
