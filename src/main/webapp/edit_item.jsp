<%@page import="com.models.Item"%>
<%@page import="com.repositories.ItemRepoImpl"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="components/head_tag.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  
    <body>
        <%@ include file="components/header.jsp" %>

        <% int id = Integer.parseInt(request.getParameter("id")); 
           ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
           Item item = itemRepo.getItemById(id);
        %>

        <div class="container mt-5">
            <h2 class="text-center">Update Item</h2>
            <form action="updateItem" method="POST">
                <div class="form-group">
                    <label for="id">Id:</label>
                    <input type="number" name="id" class="form-control" value="<%= item.getId() %>" readonly>
                </div>
                
                <div class="form-group">
                    <label for="id_name">Name:</label>
                    <input type="text" name="name" maxlength="30" required id="id_name" class="form-control" value="<%= item.getName() %>">
                </div>

                <div class="form-group">
                    <label for="id_price">Price:</label>
                    <input type="number" name="price" step="any" required id="id_price" class="form-control" value="<%= item.getPrice() %>">
                </div>
                
                <div class="form-group">
                    <label for="id_description">Description:</label>
                    <input type="text" name="description" required id="id_description" class="form-control" value="<%= item.getDescription() %>">
                </div>

                <div class="form-group form-check">
                    <input type="checkbox" name="veg" id="id_veg" class="form-check-input" <%= item.isVeg() ? "checked" : "" %>>
                    <label class="form-check-label" for="id_veg">Veg</label>
                </div>

                <%@ include file="../components/select_multiple_update_item.jsp" %>

                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Submit</button>
                </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        
        <%@ include file="components/script_tags.jsp" %>
    </body>
</html>
