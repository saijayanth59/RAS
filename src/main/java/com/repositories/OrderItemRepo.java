package com.repositories;

import java.sql.SQLException;
import java.util.List;
import com.models.Item;
import com.models.OrderItem;

public interface OrderItemRepo {

    
    boolean addOrderItems(int orderId, List<OrderItem> orderItems) throws SQLException;
    
    List<OrderItem> getOrderItemsByOrderId(int orderId) throws SQLException;
    
}
