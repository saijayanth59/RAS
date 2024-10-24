package com.models;

public class CustomerOrder {
	private int id;
	private int customerId;
	private int noOfItems;
	private String status;
	private double totalPrice;
	
	public CustomerOrder() {
		super();
	}
	
	

	public CustomerOrder(int id, int customerId, int noOfItems, String status, double totalPrice) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.noOfItems = noOfItems;
		this.status = status;
		this.totalPrice = totalPrice;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}



	@Override
	public String toString() {
		return "CustomerOrder [id=" + id + ", customerId=" + customerId + ", noOfItems=" + noOfItems + ", status="
				+ status + ", totalPrice=" + totalPrice + "]";
	}


	
	
	
	
	

}
