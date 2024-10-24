package com.models;
import java.sql.Timestamp;

public class InventoryOrder {
	private int id;
	private double totalPrice;
	private String status; 
	private int shippingId;
	private Timestamp createdAt;
	
	public InventoryOrder() {
		super();
	}

	public InventoryOrder(int id, double totalPrice, String status, int shippingId, Timestamp createdAt) {
		super();
		this.id = id;
		this.totalPrice = totalPrice;
		this.status = status;
		this.shippingId = shippingId;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getShippingId() {
		return shippingId;
	}

	public void setShippingId(int shippingId) {
		this.shippingId = shippingId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "InventoryOrder [id=" + id + ", totalPrice=" + totalPrice + ", status=" + status + ", shippingId="
				+ shippingId + ", createdAt=" + createdAt + "]";
	}
	
	
	
	

}
