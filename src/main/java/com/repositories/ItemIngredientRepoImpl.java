package com.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.models.Ingredient;

public class ItemIngredientRepoImpl implements ItemIngredientRepo{
	
	private Connection connection;
	
	public ItemIngredientRepoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public boolean addItemIngredient(int itemId, List<Ingredient> ingredients) throws SQLException {
	    String query = "INSERT INTO item_ingredient (item_id, ingredient_id, quantity) VALUES (?, ?, ?)";

	    connection.setAutoCommit(false);
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        for (Ingredient ingredient : ingredients) {
	            stmt.setInt(1, itemId);
	            stmt.setInt(2, ingredient.getId());
	            stmt.setDouble(3, ingredient.getQuantity());
	            stmt.addBatch(); 
	        }
	        stmt.executeBatch(); 
	        connection.commit();
	        return true;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        connection.rollback();
	        throw e;
	        
	    } finally {
	        connection.setAutoCommit(true);
	    }
	}
	

	@Override
	public boolean updateItemIngredient(int itemId, List<Ingredient> ingredients) throws SQLException {
	    String updateQuery = "UPDATE item_ingredient SET quantity = ? WHERE item_id = ? AND ingredient_id = ?";

	    connection.setAutoCommit(false);

	    try (PreparedStatement updateStmt = connection.prepareStatement(updateQuery)) {

	        for (Ingredient ingredient : ingredients) {
	            updateStmt.setDouble(1, ingredient.getQuantity());
	            updateStmt.setInt(2, itemId);
	            updateStmt.setInt(3, ingredient.getId());
	            updateStmt.addBatch(); 
	        }

	        connection.commit();
	        return true;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        connection.rollback();
	        throw e;
	        
	    } finally {
	        connection.setAutoCommit(true);
	    }
	}


	@Override
	public boolean deleteItemIngredient(int itemId, int ingredientId) throws SQLException {
	    String query = "DELETE FROM item_ingredient WHERE item_id = ? AND ingredient_id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, itemId);
	        stmt.setInt(2, ingredientId);

	        int affectedRows = stmt.executeUpdate();
	        
	        return affectedRows > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;  
	    }
	}

	@Override
	public List<Ingredient> getIngredientsByItemId(int itemId) throws SQLException {
	    String query = "SELECT i.id, i.name, ii.quantity, i.price " +
	                   "FROM item_ingredient ii " +
	                   "JOIN ingredient i ON ii.ingredient_id = i.id " +
	                   "WHERE ii.item_id = ?";
	    
	    List<Ingredient> ingredients = new ArrayList<>();
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, itemId);
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Ingredient ingredient = new Ingredient();
	            ingredient.setId(rs.getInt("id"));
	            ingredient.setName(rs.getString("name"));
	            ingredient.setQuantity(rs.getDouble("quantity"));
	            ingredient.setPrice(rs.getDouble("price"));
	            
	            ingredients.add(ingredient);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	    
	    return ingredients;
	}


}
