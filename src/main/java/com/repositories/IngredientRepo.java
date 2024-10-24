package com.repositories;

import java.sql.SQLException;
import com.models.Ingredient;
import java.util.List;

public interface IngredientRepo {

    boolean addIngredient(Ingredient ingredient) throws SQLException;

    boolean updateIngredient(Ingredient ingredient) throws SQLException;

    boolean deleteIngredient(int ingredientId) throws SQLException;

    Ingredient getIngredientById(int ingredientId) throws SQLException;

    List<Ingredient> getAllIngredients() throws SQLException;
}
