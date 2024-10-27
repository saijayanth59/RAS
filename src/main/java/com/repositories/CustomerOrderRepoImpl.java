package com.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.CustomerOrder;

public class CustomerOrderRepoImpl implements CustomerOrderRepo{
	
	private Connection connection;

	public CustomerOrderRepoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addCustomerOrder(CustomerOrder order) throws SQLException {
	    String query = "INSERT INTO customer_order (customer_id, no_of_items, status, total_price) VALUES (?, ?, ?, ?)";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
	    	stmt.setNull(1, java.sql.Types.INTEGER);
	        stmt.setInt(2, order.getNoOfItems());
	        stmt.setString(3, "pending");
	        stmt.setDouble(4, order.getTotalPrice());
	    	

	        int affectedRows = stmt.executeUpdate();

	        if (affectedRows > 0) {
	            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	                if (generatedKeys.next()) {
	                    int orderId = generatedKeys.getInt(1);

	                    OrderItemRepo orderItemRepo = new OrderItemRepoImpl(connection);
	                    return orderItemRepo.addOrderItems(orderId, order.getOrderItems());
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
	public CustomerOrder getCustomerOrderById(int orderId) throws SQLException {
	    String query = "SELECT * FROM customer_order WHERE id = ?";
	    CustomerOrder order = null;

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, orderId); 

	        try (ResultSet rs = stmt.executeQuery()) {

	            if (rs.next()) {
	                order = new CustomerOrder();
	                order.setId(rs.getInt("id"));
	                order.setCustomerId(rs.getInt("customer_id"));
	                order.setNoOfItems(rs.getInt("no_of_items"));
	                order.setStatus(rs.getString("status"));
	                order.setTotalPrice(rs.getDouble("total_price"));
	                
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }

	    return order;
	}



	@Override
	public List<CustomerOrder> getAllCustomerOrders() throws SQLException {
	    String query = "SELECT * FROM customer_order";
	    List<CustomerOrder> customerOrders = new ArrayList<>();
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            CustomerOrder order = new CustomerOrder();
	            order.setId(rs.getInt("id"));
	            order.setCustomerId(rs.getInt("customer_id"));
	            order.setNoOfItems(rs.getInt("no_of_items"));
	            order.setStatus(rs.getString("status"));
	            order.setTotalPrice(rs.getDouble("total_price"));

	            customerOrders.add(order);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }

	    return customerOrders;
	}


	@Override
	public List<CustomerOrder> getCustomerOrdersByCustomerId(int customerId) throws SQLException {
	    String query = "SELECT * FROM customer_order WHERE customer_id = ?";
	    List<CustomerOrder> customerOrders = new ArrayList<>();

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setInt(1, customerId);

	        try (ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                CustomerOrder order = new CustomerOrder();
	                order.setId(rs.getInt("id"));
	                order.setCustomerId(rs.getInt("customer_id"));
	                order.setNoOfItems(rs.getInt("no_of_items"));
	                order.setStatus(rs.getString("status"));
	                order.setTotalPrice(rs.getDouble("total_price"));

	                customerOrders.add(order);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }

	    return customerOrders;
	}


	@Override
	public List<CustomerOrder> getCustomerOrdersByStatus(String status) throws SQLException {
	    String query = "SELECT * FROM customer_order WHERE status = ?";
	    List<CustomerOrder> customerOrders = new ArrayList<>();

	    try (PreparedStatement stmt = connection.prepareStatement(query)) {
	        stmt.setString(1, status); 

	        try (ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	                CustomerOrder order = new CustomerOrder();
	                order.setId(rs.getInt("id"));
	                order.setCustomerId(rs.getInt("customer_id"));
	                order.setNoOfItems(rs.getInt("no_of_items"));
	                order.setStatus(rs.getString("status"));
	                order.setTotalPrice(rs.getDouble("total_price"));

	                customerOrders.add(order);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }

	    return customerOrders;
	    
	}


	@Override
	public boolean deleteCustomerOrder(int orderId) throws SQLException {
	    String deleteOrderItemsQuery = "DELETE FROM order_item WHERE order_id = ?";
	    String deleteOrderQuery = "DELETE FROM customer_order WHERE id = ?";

	    try {
	        connection.setAutoCommit(false);

	        try (PreparedStatement deleteOrderItemsStmt = connection.prepareStatement(deleteOrderItemsQuery)) {
	            deleteOrderItemsStmt.setInt(1, orderId);
	            deleteOrderItemsStmt.executeUpdate();
	        }

	        try (PreparedStatement deleteOrderStmt = connection.prepareStatement(deleteOrderQuery)) {
	            deleteOrderStmt.setInt(1, orderId);
	            int affectedRows = deleteOrderStmt.executeUpdate();
	            
	            if (affectedRows > 0) {
	                connection.commit();
	                return true;
	            } else {
	                connection.rollback();
	                return false; 
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        connection.rollback(); 
	        throw e; 
	        
	    } finally {
	        connection.setAutoCommit(true);
	    }
	}


//	pending updating the quantities of the items
	@Override
	public boolean updateCustomerOrderStatus(int orderId, String status) throws SQLException {
	    String updateStatusQuery = "UPDATE customer_order SET status = completed WHERE id = ?";

	    try (PreparedStatement stmt = connection.prepareStatement(updateStatusQuery)) {
	    	
	        stmt.setInt(1, orderId);
	        int affectedRows = stmt.executeUpdate();
	        return affectedRows > 0;
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw e; 
	    }
	}

}
