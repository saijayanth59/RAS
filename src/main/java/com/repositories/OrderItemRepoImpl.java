package com.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.OrderItem;

public class OrderItemRepoImpl implements OrderItemRepo{
	
	private Connection connection;
	
	public OrderItemRepoImpl(Connection connection) {
		super();
		this.connection = connection;
	}


	@Override
	public boolean addOrderItems(int orderId, List<OrderItem> orderItems) throws SQLException {
	    String query = "INSERT INTO order_item (order_id, item_id, quantity, price) VALUES (?, ?, ?, ?)";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {

	        for (OrderItem item : orderItems) {
	            stmt.setInt(1, orderId); 
	            stmt.setInt(2, item.getItemId()); 
	            stmt.setInt(3, item.getQuantity()); 
	            stmt.setDouble(4, item.getPrice()); 

	            stmt.addBatch(); 
	        }

	        int[] results = stmt.executeBatch();
	        
//	        for (int result : results) {
//	            if (result == PreparedStatement.EXECUTE_FAILED) {
//	                return false; // If any insert failed, return false
//	            }
//	        }
	        
	        return true; 
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; // Propagate the exception
	    }
	}


	@Override
	public List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException {
	    String query = "SELECT * FROM order_item WHERE order_id = ?";
	    List<OrderItem> orderItems = new ArrayList<>();
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, orderId);

	        try (ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                OrderItem item = new OrderItem();
	                item.setId(rs.getInt("id"));
	                item.setOrderId(rs.getInt("order_id"));
	                item.setItemId(rs.getInt("item_id"));
	                item.setQuantity(rs.getInt("quantity"));
	                item.setPrice(rs.getDouble("price"));
	                orderItems.add(item);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }
	   
	    return orderItems;
	}


}
