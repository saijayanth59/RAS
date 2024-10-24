package com.models;

public class ItemIngredient {
	private int id;
	private int item_id;
	private int ingredient_id;
	private double quantity;
	
	public ItemIngredient() {
		super();
	}
	
	public ItemIngredient(int id, int item_id, int ingredient_id, double quantity) {
		super();
		this.id = id;
		this.item_id = item_id;
		this.ingredient_id = ingredient_id;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getIngredient_id() {
		return ingredient_id;
	}

	public void setIngredient_id(int ingredient_id) {
		this.ingredient_id = ingredient_id;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "ItemIngredient [id=" + id + ", item_id=" + item_id + ", ingredient_id=" + ingredient_id + ", quantity="
				+ quantity + "]";
	}
	
	
	

}
