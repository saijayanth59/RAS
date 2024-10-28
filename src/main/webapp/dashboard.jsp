<%@page import="java.util.List"%>
<%@page import="com.models.CustomerOrder"%>
<%@page import="com.models.OrderItem"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.CustomerOrderRepoImpl"%>
<%@page import="com.repositories.ItemRepoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <%@ include file="components/head_tag.jsp" %>
    <title>Statistics</title>
  </head>
  <body>
    <%@ include file="components/header.jsp" %>
    
    <div class="container mt-5">
      <h2 class="text-center mb-4">Statistics Overview</h2>
      
      <%
   
        CustomerOrderRepoImpl orderRepo = new CustomerOrderRepoImpl(DBConnect.connect());
        ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
        

        int totalOrders = orderRepo.getTotalOrders();
        double totalRevenue = orderRepo.getTotalRevenue();
        List<CustomerOrder> pendingOrders = orderRepo.getCustomerOrdersByStatus("pending");
        List<CustomerOrder> completedOrders = orderRepo.getCustomerOrdersByStatus("completed");
 
      %>
      
      <!-- Summary Cards -->
      <div class="row text-center mb-4">
        <div class="col-md-3">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Total Orders</h5>
              <p class="card-text"><%= totalOrders %></p>
            </div>
          </div>
        </div>
        
        <div class="col-md-3">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Total Revenue</h5>
              <p class="card-text">₹<%= totalRevenue %></p>
            </div>
          </div>
        </div>
        
        <div class="col-md-3">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Pending Orders</h5>
              <p class="card-text"><%= pendingOrders.size() %></p>
            </div>
          </div>
        </div>
        
        <div class="col-md-3">
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Completed Orders</h5>
              <p class="card-text"><%= completedOrders.size()  %></p>
            </div>
          </div>
        </div>
      </div>


      
      <% DBConnect.destroy(); %>
    </div>

    <%@ include file="components/script_tags.jsp" %>
  </body>
</html>
