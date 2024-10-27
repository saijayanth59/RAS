<%@page import="com.models.Ingredient"%>
<%@page import="com.repositories.IngredientRepoImpl"%>
<%@page import="com.db.DBConnect"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.*"%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="components/head_tag.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="components/header.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Edit Ingredient</h2>
        
        <% 
            int id = Integer.parseInt(request.getParameter("id"));
            IngredientRepoImpl ingredientRepo = new IngredientRepoImpl(DBConnect.connect());
            Ingredient ingredient = ingredientRepo.getIngredientById(id);
        %>

        <form action="updateIngredient" method="POST">
            <input type="hidden" name="id" value="<%= ingredient.getId() %>">
            <div class="form-group">
                <label for="ingredientName">Name:</label>
                <input type="text" class="form-control" id="ingredientName" name="name" required value="<%= ingredient.getName() %>" placeholder="Enter ingredient name">
            </div>
            <div class="form-group">
                <label for="ingredientQuantity">Quantity:</label>
                <input type="number" class="form-control" id="ingredientQuantity" name="quantity" required value="<%= ingredient.getQuantity() %>" placeholder="Enter quantity">
            </div>
            <div class="form-group">
                <label for="ingredientPrice">Price:</label>
                <input type="number" class="form-control" id="ingredientPrice" name="price" step="0.01" required value="<%= ingredient.getPrice() %>" placeholder="Enter price">
            </div>
            <button type="submit" class="btn btn-primary">Update Ingredient</button>
        </form>
    </div>

    <% DBConnect.destroy(); %>

    <%@ include file="components/script_tags.jsp" %>
</body>
</html>
