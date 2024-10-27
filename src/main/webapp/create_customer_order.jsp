<%@page import="com.models.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.ItemRepoImpl"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ include file="components/head_tag.jsp" %>
   
</head>
<body>
    <%@ include file="components/header.jsp" %>

    <div class="container mt-5">
        <h2 class="text-center mb-4">Create Customer Order</h2>
                <form action="createCustomerOrder" method="POST">
         
				<%@ include file="components/select_multiple_items.jsp" %>
          
            <button type="submit" class="btn btn-primary mt-3">Submit Order</button>
        </form>
    </div>


</body>
</html>
