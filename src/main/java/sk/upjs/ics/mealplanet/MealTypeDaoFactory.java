/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.upjs.ics.mealplanet;

/**
 *
 * @author Patrik
 */
public enum MealTypeDaoFactory {
    
    INSTANCE;
    
    public MealTypeDao getMealTypeDao() {
        return new MySqlMealTypeDao();
    }
    
}
