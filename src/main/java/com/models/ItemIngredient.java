package com.models;

public class ItemIngredient {
	private int id;
	private int itemId;
	private int ingredientId;
	private double quantity;
	
	public ItemIngredient() {
		super();
	}
	
	public ItemIngredient(int id, int item_id, int ingredient_id, double quantity) {
		super();
		this.id = id;
		this.itemId = item_id;
		this.ingredientId = ingredient_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int item_id) {
		this.itemId = item_id;
	}

	public int getIngredientId() {
		return ingredientId;
	}

	public void setIngredientId(int ingredient_id) {
		this.ingredientId = ingredient_id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemIngredient [id=" + id + ", item_id=" + itemId + ", ingredient_id=" + ingredientId + ", quantity="
				+ quantity + "]";
	}
	
	
	

}
