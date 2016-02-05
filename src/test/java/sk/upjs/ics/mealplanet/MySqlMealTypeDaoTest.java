/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Patrik
 */
public class MySqlMealTypeDaoTest {
    
    public MySqlMealTypeDaoTest() {
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
     * Test of getAllNames method, of class MySqlMealTypeDao.
     */
    @org.junit.Test
    public void testGetAllNames() {
        System.out.println("getAllNames");
        MySqlMealTypeDao instance = new MySqlMealTypeDao();
        List<String> expResult = new ArrayList<>();
        expResult.add("meal types");
        expResult.add("appetizer");
        expResult.add("soup");
        expResult.add("main course");
        expResult.add("dessert");
        expResult.add("snack");
        expResult.add("ther");
        List<String> result = instance.getAllNames();
        assertEquals(expResult, result);        
    }

    /**
     * Test of getAll method, of class MySqlMealTypeDao.
     */
    @org.junit.Test
    public void testGetAll() {
        System.out.println("getAll");
        MySqlMealTypeDao instance = new MySqlMealTypeDao();
        int expResult = 7;
        List<MealType> mealTypes = instance.getAll();
        int result=mealTypes.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
}
