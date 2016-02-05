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
public class MySqlRelationDaoTest {
    
    public MySqlRelationDaoTest() {
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
     * Test of addRelation method, of class MySqlRelationDao.
     */
    @Test
    public void testAddRelation() {
        System.out.println("addRelation");
        
        Relation relation = new Relation();
        relation.setIdI(1);
        relation.setIdR(4);
        relation.setAmount("5g");
        MySqlRelationDao instance = new MySqlRelationDao();
               
        List<Relation> relations = instance.getAll();
        int pocetPred = relations.size();
        
        instance.addRelation(relation); 
        List<Relation> relations2 = instance.getAll();
        assertEquals(pocetPred+1, relations2.size());
    }

    /**
     * Test of getAll method, of class MySqlRelationDao.
     */
    @Test
    public void testGetAll() {
        System.out.println("getAll");
        MySqlRelationDao instance = new MySqlRelationDao();
        int expResult = 9;
        List<Relation> result = instance.getAll();
        assertEquals(expResult, result.size());        
    }

    /**
     * Test of getMatching method, of class MySqlRelationDao.
     */
    @Test
    public void testGetMatching() {
        System.out.println("getMatching");
        long idR = 4;
        MySqlRelationDao instance = new MySqlRelationDao();
        long expResult = 0L;
        List<Relation> result = instance.getMatching(idR);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class MySqlRelationDao.
     */
    @Test
    public void testDelete() {
        System.out.println("deleteRelation");
        
        MySqlRelationDao instance = new MySqlRelationDao();
               
        List<Relation> relations = instance.getAll();
        int pocetPred = relations.size();
        
        instance.delete(4); 
        List<Relation> relations2 = instance.getAll();
        assertEquals(pocetPred-3, relations2.size());
    }
    
}
