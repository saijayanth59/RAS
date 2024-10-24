package com.models;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private int id;
	private String name;
	private double price;
	private String description;
	private String image;
	private boolean isVeg;
	private boolean availability;
	private List<ItemIngredient> itemIngredients;
	
	public Item() {
		super();
	}
	

	public List<ItemIngredient> getItemIngredients() {
		return itemIngredients;
	}



	public void addItemIngredient(ItemIngredient itemIngredient) {
		this.itemIngredients.add(itemIngredient);
	}




	public Item(int id, String name, double price, String description, String image, boolean isVeg,
			boolean availability) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.image = image;
		this.isVeg = isVeg;
		this.availability = availability;
		this.itemIngredients = new ArrayList<>();
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isVeg() {
		return isVeg;
	}

	public void setVeg(boolean isVeg) {
		this.isVeg = isVeg;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	

	

}
