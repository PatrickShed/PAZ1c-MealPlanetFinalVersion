/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

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
public class MySqlRecipeDaoTest {

    public MySqlRecipeDaoTest() {
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
     * Test of add method, of class MySqlRecipeDao.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Recipe recipe = new Recipe();
        recipe.setIdR(4);
        recipe.setName("test");
        recipe.setType(2);
        recipe.setRating(80);
        recipe.setPrepTime(12);
        recipe.setSteps("testovacie steps");
        MySqlRecipeDao instance = new MySqlRecipeDao();
        List<Recipe> recepty = instance.getAll();
        instance.add(recipe);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(recepty.size()+1, 3);
    }

    /**
     * Test of remove method, of class MySqlRecipeDao.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Recipe recipe = new Recipe();
        recipe.setIdR(4);
        MySqlRecipeDao instance = new MySqlRecipeDao();
        List<Recipe> recepty = instance.getAll();
        instance.remove(recipe);
        assertEquals(recepty.size()-1, 2);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class MySqlRecipeDao.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Recipe recipe = new Recipe();
        recipe.setIdR(3);
        recipe.setName("Bravcove na salame");
        recipe.setPrepTime(60);
        recipe.setSteps("Nameisto bravcoveho mame kuracie a namiesto salamy je mrkva. A sprav to.");
        recipe.setRating(80);
        
        MySqlRecipeDao instance = new MySqlRecipeDao();
        Recipe stary = instance.getMatchingName(recipe.getName()).get(0);
        instance.update(recipe);               
        
        assertNotSame(stary, instance.getMatchingName(stary.getName()));        
    }

    /**
     * Test of getAll method, of class MySqlRecipeDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        MySqlRecipeDao instance = new MySqlRecipeDao();
        int expResult = 2;
        List<Recipe> result = instance.getAll();
        assertEquals(expResult, result.size());        
    }

    /**
     * Test of getMatchingName method, of class MySqlRecipeDao.
     */
    @Test
    public void testGetMatchingName() {
        System.out.println("getMatchingName");
        String name = "Ham and Eggs";
        MySqlRecipeDao instance = new MySqlRecipeDao();
        int expResult = 1;
        List<Recipe> result = instance.getMatchingName(name);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getMatching method, of class MySqlRecipeDao.
     */
    @Test
    public void testGetMatching() {
        System.out.println("getMatching");
        String name = "";
        int mealType = 1;
        MySqlRecipeDao instance = new MySqlRecipeDao();
        int expResult = 1;
        List<Recipe> result = instance.getMatching(name, mealType);
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getLast method, of class MySqlRecipeDao.
     */
    @Test
    public void testGetLast() {
        System.out.println("getLast");
        MySqlRecipeDao instance = new MySqlRecipeDao();
        Recipe expResult = new Recipe();
        expResult.setIdR(3L);
        expResult.setName("Bravcove na salame");
        expResult.setPrepTime(60);
        expResult.setSteps("Nameisto bravcoveho mame kuracie a namiesto salamy je mrkva. A sprav to.");
        expResult.setRating(80);
        expResult.setType(0);
        Recipe result = instance.getLast().get(0);
        System.out.println(result.getType());
        System.out.println(expResult.getType());
        
        assertEquals(expResult.getName(), result.getName());
        // TODO review the generated test code and remove the default call to fail.
        
    }

}
