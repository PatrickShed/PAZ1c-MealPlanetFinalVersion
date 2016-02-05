package sk.upjs.ics.mealplanet;

import java.util.List;

public interface IngredientDao {

    public void addIngredient(Ingredient ingredient);
    
    public List<Ingredient> getAllOrdered();
}
