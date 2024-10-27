<%@page import="com.models.Ingredient"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.IngredientRepoImpl"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="components/head_tag.jsp" %>
        
    </head>
    <body>
        <%@ include file="components/header.jsp" %>

        <div class="container mt-5">
            <h2 class="text-center mb-4">All Ingredients</h2>
           
            <table class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>Ingredient Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                        IngredientRepoImpl ingredientRepo = new IngredientRepoImpl(DBConnect.connect()); 
                        List<Ingredient> ingredients = ingredientRepo.getAllIngredients();
                        for (Ingredient ingredient : ingredients) {
                    %>
                    <tr>
                        <td><%= ingredient.getName() %></td>
                        <td><%= ingredient.getQuantity() %></td>
                        <td>₹<%= ingredient.getPrice() %></td>
                        <td>
                            <a class="btn btn-primary btn-sm mx-1" href="edit_ingredient.jsp?id=<%= ingredient.getId() %>">Edit</a>
                            <form class="d-inline" action="deleteIngredient" method="POST" style="display:inline;">
                                <input type="hidden" name="id" value="<%= ingredient.getId() %>">
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
tml>