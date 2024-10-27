<%@page import="com.models.CustomerOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.CustomerOrderRepoImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="components/head_tag.jsp" %>
  <body>
    
    <%@ include file="components/header.jsp" %>
    
        <div class="container mt-5">
            <h2 class="text-center mb-4">Customer Orders</h2>
           
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Order ID</th>
                        <th>Number of Items</th>
                        <th>Total Price</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        CustomerOrderRepoImpl orderRepo = new CustomerOrderRepoImpl(DBConnect.connect()); 
                        List<CustomerOrder> orders = orderRepo.getAllCustomerOrders();
                        for (CustomerOrder order : orders) {
                            String rowClass = "table-warning"; // Default color for "Pending"
                            if ("Complete".equalsIgnoreCase(order.getStatus())) {
                                rowClass = "table-success"; // Green for "Complete"
                            }
                    %>
                    <tr class="<%= rowClass %>">
                        <td><%= order.getId() %></td>
                        <td><%= order.getNoOfItems() %></td>
                        <td>₹<%= order.getTotalPrice() %></td>
                        <td><%= order.getStatus() %></td>
                        <td>
                            <a class="btn btn-primary btn-sm mx-1" href="view_customer_order.jsp?id=<%= order.getId() %>">View</a>
                            <form class="d-inline" action="deleteOrder" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="<%= order.getId() %>">
                                <input type="submit" class="btn btn-danger btn-sm" value="Delete">
                            </form>
                        </td>
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
           
<% DBConnect.destroy(); %>

	<%@ include file="components/script_tags.jsp" %>

  </body>
</html>
