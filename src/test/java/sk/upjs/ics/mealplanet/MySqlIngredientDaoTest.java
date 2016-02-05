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
public class MySqlIngredientDaoTest {
    
    public MySqlIngredientDaoTest() {
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
     * Test of addIngredient method, of class MySqlIngredientDao.
     */
    @Test
    public void testAddIngredient() {
        System.out.println("addIngredient");
        MySqlIngredientDao instance = new MySqlIngredientDao();
        Ingredient ingredient = new Ingredient();
        ingredient.setName("Potkan");
        ingredient.setCarb(20);
        ingredient.setFat(30);
        ingredient.setProtein(20);
        List<Ingredient> ingredients = instance.getAllOrdered();
        int pocetPred=ingredients.size();
        instance.addIngredient(ingredient);
        ingredients=instance.getAllOrdered();
        int pocetPo=ingredients.size();
        assertEquals(pocetPred+1, pocetPo);
        
        
    }

    /**
     * Test of getAllOrdered method, of class MySqlIngredientDao.
     */
    @Test
    public void testGetAllOrdered() {
        System.out.println("getAllOrdered");
        MySqlIngredientDao instance = new MySqlIngredientDao();
        int expResult = 44;
        String prve = "Bean";
        String posledne = "Wholmeal flour";
        List<Ingredient> result = instance.getAllOrdered();
        assertEquals(expResult, result.size());
        assertEquals(prve, result.get(0).getName());
        assertEquals(posledne, result.get(result.size()-1).getName());
    }
    
}
