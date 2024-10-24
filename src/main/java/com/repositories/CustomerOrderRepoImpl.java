package com.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.models.CustomerOrder;
import com.models.OrderItem;

public class CustomerOrderRepoImpl implements CustomerOrderRepo{
	
	private Connection connection;

	public CustomerOrderRepoImpl(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean addCustomerOrder(CustomerOrder order) throws SQLException {
	    String query = "INSERT INTO customer_order (customer_id, no_of_items, status, total_price) VALUES (?, ?, ?, ?)";
	    
	    try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
	        stmt.setInt(1, order.getCustomerId());
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteCustomerOrder(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCustomerOrderStatus(int orderId, String status) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
