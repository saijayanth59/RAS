<%@page import="com.repositories.ItemRepoImpl"%>
<%@page import="com.models.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>

<div>
  <strong>Select Ingredients:</strong>
  <select id="multiple-checkboxes" name="items" multiple="multiple" class="form-select">
                    <% 
                        ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect());
                        List<Item> items = itemRepo.getItemsByAvailability(true);
                        for (Item item : items) {
                    %>
                    <option value="<%= item.getId() %>"><%= item.getName() %></option>
                    <% } DBConnect.destroy(); %>
  </select>
  <div id="ingredient-inputs" class="mt-3"></div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"/>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/js/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.13/css/bootstrap-multiselect.css"/>

<script>
  $(document).ready(function () {
    $("#multiple-checkboxes").multiselect({
      includeSelectAllOption: true,
    });

    $("#multiple-checkboxes").change(function () {
      $("#ingredient-inputs").empty();

      const selectedOptions = $(this).find(":selected");

      selectedOptions.each(function () {
        const ingredientId = $(this).val();
        const ingredientName = $(this).text();
        
        const label = $("<label>").text(ingredientName);
        const input = $("<input>").attr({
          type: "number",
          name: ingredientId, 
          required: true,
          placeholder: "Enter quantity",
          class: "form-control mb-2",
          step: "1",  
          min: "1",
          max: "5"
        });

        const div = $("<div>").addClass("mb-3").append(label, input);

        $("#ingredient-inputs").append(div);
      });
    });
  });
</script>
