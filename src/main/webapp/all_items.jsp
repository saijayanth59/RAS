<%@page import="com.models.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.ItemRepoImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="components/head_tag.jsp" %>
  <body>
    
    <%@ include file="components/header.jsp" %>
    
          <div class="container mt-5">
            <h2 class="text-center mb-4">All Items</h2>
           
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Item Name</th>
                        <th>Price</th>
                        <th>Is Vegetarian</th>
                        <th>Availability</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect()); 
                        List<Item> items = itemRepo.getAllItems();
                        for (Item item : items) {
                    %>
                    <tr>
                        <td><%= item.getName() %></td>
                        <td>₹<%= item.getPrice() %></td>
                        <td><%= item.isVeg() ? "Yes" : "No" %></td>
                        <td>
                            <form class="d-inline" action="updateItemStatus" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="<%= item.getId() %>">
                                <input type="submit" class="btn btn-info btn-sm" value="Update">
                            </form>
                            <%= item.isAvailability() ? "Available" : "Unavailable" %>
                        </td>
                        <td>
                            <a class="btn btn-primary btn-sm mx-1" href="edit_item.jsp?id=<%= item.getId() %>">Edit</a>
                            <form class="d-inline" action="deleteItem" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="<%= item.getId() %>">
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