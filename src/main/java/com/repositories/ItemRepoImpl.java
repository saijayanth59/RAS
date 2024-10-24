package com.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.models.Item;

public class ItemRepoImpl implements ItemRepo{
	
	private Connection connection;
	
	public ItemRepoImpl(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public boolean addItem(Item item) throws SQLException {
	    String query = "INSERT INTO item (name, price, description, image, is_veg) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, item.getName());
	        stmt.setDouble(2, item.getPrice());
	        stmt.setString(3, item.getDescription());
	        
	        if (item.getImage() != null) {
	            stmt.setString(4, item.getImage());
	        } else {
	            stmt.setNull(4, java.sql.Types.VARCHAR);
	        }
	        
	        stmt.setBoolean(5, item.isVeg());


	        int affectedRows = stmt.executeUpdate();
	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int itemId = generatedKeys.getInt(1);

	                    ItemIngredientRepoImpl itemIngredientRepo = new ItemIngredientRepoImpl(connection);
	                    return itemIngredientRepo.addItemIngredients(itemId, item.getItemIngredients());
	                }
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
		return false;
	}


	@Override
	public boolean updateItem(Item item) throws SQLException {
	    String query = "UPDATE item SET name = ?, price = ?, description = ?, image = ?, is_veg = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, item.getName());
	        stmt.setDouble(2, item.getPrice());
	        stmt.setString(3, item.getDescription());
	        
	        if (item.getImage() != null) {
	            stmt.setString(4, item.getImage());
	        } else {
	            stmt.setNull(4, java.sql.Types.VARCHAR);
	        }
	        
	        stmt.setBoolean(5, item.isVeg());
	        stmt.setInt(6, item.getId());

	        int affectedRows = stmt.executeUpdate();
	        
	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int itemId = generatedKeys.getInt(1);

	                    ItemIngredientRepoImpl itemIngredientRepo = new ItemIngredientRepoImpl(connection);
	                    return itemIngredientRepo.updateItemIngredients(itemId, item.getItemIngredients());
	                }
	            }
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	}
		return false;
}


	@Override
	public boolean updateAvailability(int itemId, boolean availability) throws SQLException {
	    String query = "UPDATE item SET availability = ? WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setBoolean(1, availability); 
	        stmt.setInt(2, itemId); 
	        
	        int rowsAffected = stmt.executeUpdate(); 
	        
	        return rowsAffected > 0;
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        throw e; 
	    }
	}

	@Override
	public Item getItemById(int itemId) throws SQLException {
	    String query = "SELECT * FROM item WHERE id = ?";
	    Item item = null; 

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, itemId); 
	        
	        ResultSet rs = stmt.executeQuery();
	        	
	        if (rs.next()) { 
	        	item = new Item();
	            item.setId(rs.getInt("id")); 
	            item.setName(rs.getString("name")); 
	            item.setPrice(rs.getDouble("price")); 
	            item.setDescription(rs.getString("description"));
	            item.setImage(rs.getString("image")); 
	            item.setAvailability(rs.getBoolean("availability")); 
	            item.setVeg(rs.getBoolean("is_veg"));
	        }
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        throw e; 
	    }

	    return item; 
	}


	@Override
	public boolean deleteById(int itemId) throws SQLException {
	    String query = "DELETE FROM item WHERE id = ?";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, itemId); 
	        
	        int rowsAffected = stmt.executeUpdate(); 
	        
	        return rowsAffected > 0; 
	        
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        throw e; 
	    }
	}


	@Override
	public List<Item> getAllItems() throws SQLException {
	    List<Item> items = new ArrayList<>(); 
	    String query = "SELECT * FROM item"; 

	    try (PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) { 
	            Item item = new Item();
	            item.setId(rs.getInt("id")); 
	            item.setName(rs.getString("name")); 
	            item.setPrice(rs.getDouble("price")); 
	            item.setDescription(rs.getString("description")); 
	            item.setImage(rs.getString("image")); 
	            item.setAvailability(rs.getBoolean("availability"));
	            item.setVeg(rs.getBoolean("is_veg"));
	            
	            items.add(item); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	        throw e; 
	    }

	    return items; 
	}

	

	@Override
	public List<Item> getItemsByAvailability(boolean availability) throws SQLException {
		
		String sql = "SELECT * FROM item WHERE availability = ?";
		List<Item> items = new ArrayList<>();
		
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setBoolean(1, availability);
	        ResultSet rs = stmt.executeQuery();

	        while (rs.next()) { 
	        	
	             Item item = new Item();
	             item.setId(rs.getInt("id")); 
	             item.setName(rs.getString("name")); 
	             item.setPrice(rs.getDouble("price")); 
	             item.setDescription(rs.getString("description")); 
	             item.setImage(rs.getString("image")); 
	             item.setAvailability(rs.getBoolean("availability")); 
	             item.setVeg(rs.getBoolean("is_veg"));
	             items.add(item);
	         }
			
		} catch (SQLException e) {
	        e.printStackTrace(); 
	        throw e; 
	    }
		
		return items;
	}

}
