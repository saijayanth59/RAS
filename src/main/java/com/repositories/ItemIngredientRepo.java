package com.repositories;

import java.sql.SQLException;
import java.util.List;

import com.models.Ingredient;

public interface ItemIngredientRepo {
    boolean addItemIngredient(int itemId, List<Ingredient> ingredients) throws SQLException; 
    
    boolean updateItemIngredient(int itemId, List<Ingredient> ingredients) throws SQLException;
    
    boolean deleteItemIngredient(int itemId, int ingredientId) throws SQLException; 
    
    List<Ingredient> getIngredientsByItemId(int itemId) throws SQLException; 
}


