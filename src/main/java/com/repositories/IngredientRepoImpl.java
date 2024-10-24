package com.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnect;
import com.models.Ingredient;

public class IngredientRepoImpl implements IngredientRepo{
	
	private Connection connection;

	public IngredientRepoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addIngredient(Ingredient ingredient) throws SQLException {
	    String query = "INSERT INTO ingredient (name, quantity, price) VALUES (?, ?, ?)";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, ingredient.getName());
	        stmt.setDouble(2, ingredient.getQuantity());
	        stmt.setDouble(3, ingredient.getPrice());

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	}

	@Override
	public boolean updateIngredient(Ingredient ingredient) throws SQLException {
	    String query = "UPDATE ingredient SET name = ?, quantity = ?, price = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, ingredient.getName());
	        stmt.setDouble(2, ingredient.getQuantity()); 
	        stmt.setDouble(3, ingredient.getPrice());
	        stmt.setInt(4, ingredient.getId());

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0;
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	}

	@Override
	public boolean deleteIngredient(int ingredientId) throws SQLException {
	    String query = "DELETE FROM ingredient WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, ingredientId); 

	        int rowsAffected = stmt.executeUpdate();
	        return rowsAffected > 0; 
	        
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }
	}

	@Override
	public Ingredient getIngredientById(int ingredientId) throws SQLException {
	    String query = "SELECT * FROM ingredient WHERE id = ?";
	    Ingredient ingredient = null; 
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, ingredientId);

	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            ingredient = new Ingredient();
	            ingredient.setId(rs.getInt("id"));
	            ingredient.setName(rs.getString("name"));
	            ingredient.setQuantity(rs.getDouble("quantity")); 
	            ingredient.setPrice(rs.getDouble("price")); 
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }
	    return ingredient; 
	}

	@Override
	public List<Ingredient> getAllIngredients() throws SQLException {
	    List<Ingredient> ingredientList = new ArrayList<>(); 
	    String query = "SELECT * FROM ingredient";

	    try (PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            Ingredient ingredient = new Ingredient();
	            ingredient.setId(rs.getInt("id"));
	            ingredient.setName(rs.getString("name"));
	            ingredient.setQuantity(rs.getDouble("quantity")); 
	            ingredient.setPrice(rs.getDouble("price"));
	            
	            ingredientList.add(ingredient);
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }

	    return ingredientList; 
	}

}
