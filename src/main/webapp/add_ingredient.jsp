<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.models.Ingredient"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.IngredientRepoImpl"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="components/head_tag.jsp" %>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <%@ include file="components/header.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Add Ingredient</h2>
        <form action="addIngredient" method="POST">
            <div class="form-group">
                <label for="ingredientName">Name:</label>
                <input type="text" class="form-control" id="ingredientName" name="name" required placeholder="Enter ingredient name">
            </div>
            <div class="form-group">
                <label for="ingredientQuantity">Quantity:</label>
                <input type="number" class="form-control" id="ingredientQuantity" name="quantity" required placeholder="Enter quantity">
            </div>
            <div class="form-group">
                <label for="ingredientPrice">Price:</label>
                <input type="number" class="form-control" id="ingredientPrice" name="price" step="0.01" required placeholder="Enter price">
            </div>
            <button type="submit" class="btn btn-primary">Add Ingredient</button>
        </form>
    </div>

    <%@ include file="components/script_tags.jsp" %>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
