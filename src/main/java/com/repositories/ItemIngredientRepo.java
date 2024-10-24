package com.repositories;

import java.sql.SQLException;
import java.util.List;

import com.models.Ingredient;
import com.models.ItemIngredient;

public interface ItemIngredientRepo {
    boolean addItemIngredients(int itemId, List<ItemIngredient> itemIngredients) throws SQLException; 
    
    boolean updateItemIngredients(int itemId, List<ItemIngredient> itemIngredients) throws SQLException;
         
    List<Ingredient> getIngredientsByItemId(int itemId) throws SQLException; 
}


