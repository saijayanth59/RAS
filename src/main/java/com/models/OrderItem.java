package com.models;

public class OrderItem {
	private int id;
	private int orderId;
	private int itemId;
	private int quantity;
	private double price;
	
	public OrderItem() {
		super();
	}
	
	public OrderItem(int id, int orderId, int itemId, int quantity, double price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	
	
}
