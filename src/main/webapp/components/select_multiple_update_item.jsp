<%@page import="com.models.Ingredient"%>
<%@page import="com.repositories.ItemIngredientRepoImpl"%>
<%@page import="com.models.ItemIngredient"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>

<div class="form-group">
    <strong>Select Ingredients:</strong>
    <select id="multiple-checkboxes" name="ingredients" multiple="multiple" class="form-control">
        <% 
        ItemIngredientRepoImpl itemIngredientRepo = new ItemIngredientRepoImpl(DBConnect.connect());
        List<Ingredient> ingredients = itemIngredientRepo.getIngredientsByItemId(id);
        for (Ingredient ingredient : ingredients) { 
        %>
            <option value="<%= ingredient.getId() %>" selected><%= ingredient.getName() %></option>
        <% } 
        DBConnect.destroy();
        %>
    </select>

    <div id="ingredient-inputs" style="margin: 2rem;">
        <% for (Ingredient ingredient : ingredients) { %>
            <div class="input-group mb-3">
                <span class="input-group-text"><%= ingredient.getName() %> :</span>
                <input type="text" class="form-control" name="<%= ingredient.getId() %>" placeholder="Enter Quantity" value="<%= ingredient.getQuantity() %>">
            </div>
        <% } %>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css" />

<script type="text/javascript">
    $(document).ready(function() {
        $('#multiple-checkboxes').multiselect({
            nonSelectedText: 'Select Ingredients',
            enableFiltering: true,
            enableCaseInsensitiveFiltering: true,
            buttonWidth: '100%',
            includeSelectAllOption: true,
            selectAllText: 'Select All',
            filterPlaceholder: 'Search...',
            onChange: function(option, checked) {
                // Handle change event if necessary
            }
        });
    });
</script>
