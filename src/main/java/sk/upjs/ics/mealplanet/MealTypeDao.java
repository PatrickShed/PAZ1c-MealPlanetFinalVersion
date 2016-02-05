/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

import java.util.List;

/**
 *
 * @author Patrik
 */
public interface MealTypeDao {
    
    public List<String> getAllNames();
    
    public List<MealType> getAll();
    
}
