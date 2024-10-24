package com.repositories;

import java.sql.SQLException;
import java.util.List;
import com.models.CustomerOrder;

public interface CustomerOrderRepo {
    
    boolean addCustomerOrder(CustomerOrder order) throws SQLException;
    
    List<CustomerOrder> getAllCustomerOrders() throws SQLException;

    List<CustomerOrder> getCustomerOrdersByStatus(String status) throws SQLException;
    
    List<CustomerOrder> getCustomerOrdersByCustomerId(int customerId) throws SQLException;


    boolean deleteCustomerOrder(int orderId) throws SQLException;

    boolean updateCustomerOrderStatus(int orderId, String status) throws SQLException;

	CustomerOrder getCustomerOrderById(int orderId) throws SQLException;
}
