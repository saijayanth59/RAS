package com.models;

public class InventoryOrderIngredient {
	private int id;
	private int inventoryOrderId;
	private int ingredientId;
	private double quantity;
	private double price;
	
	public InventoryOrderIngredient() {
		super();
	}

	public InventoryOrderIngredient(int id, int inventoryOrderId, int ingredientId, double quantity, double price) {
		super();
		this.id = id;
		this.inventoryOrderId = inventoryOrderId;
		this.ingredientId = ingredientId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInventoryOrderId() {
		return inventoryOrderId;
	}

	public void setInventoryOrderId(int inventoryOrderId) {
		this.inventoryOrderId = inventoryOrderId;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredientId) {
		this.ingredientId = ingredientId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InventoryOrderIngredient [id=" + id + ", inventoryOrderId=" + inventoryOrderId + ", ingredientId="
				+ ingredientId + ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
}
