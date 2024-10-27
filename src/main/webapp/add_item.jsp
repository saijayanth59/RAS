<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ include file="components/head_tag.jsp" %>
<body>

<%@ include file="components/header.jsp" %>

<div class="container mt-5">
<h2 class="text-center">Add Item</h2>
  <form action="addItem" method="POST">
    <div class="mb-3">
      <label for="id_name" class="form-label">Name:</label>
      <input type="text" name="name" maxlength="30" required id="id_name" class="form-control">
    </div>

    <div class="mb-3">
      <label for="id_price" class="form-label">Price:</label>
      <input type="number" name="price" step="any" required id="id_price" class="form-control">
    </div>
    
    <div class="mb-3">
      <label for="id_description" class="form-label">Description:</label>
      <input type="text" name="description" required id="id_description" class="form-control">
    </div>
    
    <div class="form-check mb-3">
      <input type="checkbox" name="veg" id="id_veg" class="form-check-input">
      <label for="id_veg" class="form-check-label">Veg:</label>
    </div>
    
    <%@ include file="../components/select_multiple.jsp" %>
    
    <button type="submit" class="btn btn-primary">Submit</button>
  </form>
</div>

</body>
</html>