<%@page import="com.models.CustomerOrder"%>
<%@page import="com.models.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.CustomerOrderRepoImpl"%>
<%@page import="com.repositories.OrderItemRepoImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="components/head_tag.jsp" %>
  <body>

    <%@ include file="components/header.jsp" %>
    
    <div class="container mt-5">
        <h2 class="text-center mb-4">Order Details</h2>
        
        <%
            int orderId = Integer.parseInt(request.getParameter("id"));

            CustomerOrderRepoImpl orderRepo = new CustomerOrderRepoImpl(DBConnect.connect());
            OrderItemRepoImpl orderItemRepo = new OrderItemRepoImpl(DBConnect.connect());
            CustomerOrder order = orderRepo.getCustomerOrderById(orderId);
            List<OrderItem> orderItems = orderItemRepo.getOrderItemsByOrderId(orderId);
        %>

        <div class="card mb-4">
            <div class="card-body">
                <h5 class="card-title">Order ID: <%= order.getId() %></h5>
                <p class="card-text">Status: <%= order.getStatus() %></p>
                <p class="card-text">Total Price: ₹<%= order.getTotalPrice() %></p>
            </div>
        </div>

        <h3 class="text-center mb-4">Order Items</h3>
        
        <table class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Item Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Total Price</th>
                </tr>
            </thead>
            <tbody>
                <% for (OrderItem item : orderItems) { %>
                <tr>
                    <td><%= item.getItemId()%></td>
                    <td><%= item.getQuantity() %></td>
                    <td>₹<%= item.getPrice()%></td>
                    <td>₹<%= item.getQuantity() * item.getPrice() %></td>
                </tr>
                <% } %>
            </tbody>
        </table>
        
        <div class="text-center mt-4">
        <a class="btn btn-success btn-sm mx-1" href="edit_order.jsp?id=<%= order.getId() %>">Update status</a>
            <a href="customer_orders.jsp" class="btn btn-sm btn-primary">Back to Orders</a>
        </div>
        
        <% DBConnect.destroy(); %>
    </div>

    <%@ include file="components/script_tags.jsp" %>
  </body>
</html>
