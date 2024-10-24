<%@page import="com.models.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.repositories.ItemRepoImpl"%>

<div class="container">
  <h2 class="text-center">Menu Items</h2>
  <div class="album py-5 bg-light">
    <div class="container">
      <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
        <% ItemRepoImpl itemRepo = new ItemRepoImpl(DBConnect.connect()); 
           List<Item> items = itemRepo.getAllItems();
           for (Item item: items){
        %>
        <div class="col">
          <div class="card shadow-sm">
            <img
              src=<%= item.getImage() %>
              class="card-img-top"
              alt="..."
              style="width: 100%; height: 200px; object-fit: cover;"
            />

            <div class="card-body">
              <h3 class="card-title"><%=item.getName() %></h3>
              <h5>Price: <%=item.getPrice() %></h5>
              <p class="card-text" style="height: 60px; overflow: hidden; text-overflow: ellipsis;">
                <%=item.getDescription() %>
              </p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button
                    type="button"
                    class="btn btn-sm btn-outline-secondary"
                  >
                    View
                  </button>
                  <button
                    type="button"
                    class="btn btn-sm btn-outline-secondary"
                  >
                    Order
                  </button>
                </div>
                <small class="text-muted">20 mins</small>
              </div>
            </div>
          </div>
        </div>
        <% } %>
      </div>
    </div>
  </div>
</div>
