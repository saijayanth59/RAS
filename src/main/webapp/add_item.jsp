<div class="container text-center my-5">
  <form action="" method="POST">
    {% csrf_token %} {{form.as_p}} {% include 'base/select_multiple.html' %}
    <button type="submit">submit</button>
  </form>
</div>