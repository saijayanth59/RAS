<header class="p-3 mb-3 border-bottom">
  <div class="container">
    <div
      class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
    >
      <ul
        class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"
      >
        <li>
          <a href="" class="nav-link px-2 link-secondary"
            >Home</a
          >
        </li>
        <li>
          <a href="" class="nav-link px-2 link-dark"
            >Add item</a
          >
        </li>
        <li>
          <a href="" class="nav-link px-2 link-dark"
            >Add ingredient</a
          >
        </li>
        <li class="nav-item dropdown">
          <span
            class="nav-link dropdown-toggle"
            role="button"
            data-bs-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            Process Order
          </span>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="">Item</a>
            <a class="dropdown-item" href=""
              >Ingredient</a
            >
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href=""
              >Inventory</a
            >
          </div>
        </li>
        <li>
          <a href="{% url 'view-orders' %}" class="nav-link px-2 link-dark"
            >Order History</a
          >
        </li>
        <li>
          <a
            href=""
            class="nav-link px-2 link-dark"
            >New Inventory order</a
          >
        </li>
      </ul>
      </div>
    </div>
  </div>
</header>

<script
  src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
  integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
  crossorigin="anonymous"
></script>
<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"
  integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V"
  crossorigin="anonymous"
></script>
