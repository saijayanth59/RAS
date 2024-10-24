package com.models;
import java.sql.Timestamp;

public class ShippingSchedule {
	private int id;
	private int regularInterval;
	private Timestamp prevDate;
	private Timestamp nextTriggerDate;
	
	public ShippingSchedule() {
		super();
	}

	public ShippingSchedule(int id, int regularInterval, Timestamp prevDate, Timestamp nextTriggerDate) {
		super();
		this.id = id;
		this.regularInterval = regularInterval;
		this.prevDate = prevDate;
		this.nextTriggerDate = nextTriggerDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRegularInterval() {
		return regularInterval;
	}

	public void setRegularInterval(int regularInterval) {
		this.regularInterval = regularInterval;
	}

	public Timestamp getPrevDate() {
		return prevDate;
	}

	public void setPrevDate(Timestamp prevDate) {
		this.prevDate = prevDate;
	}

	public Timestamp getNextTriggerDate() {
		return nextTriggerDate;
	}

	public void setNextTriggerDate(Timestamp nextTriggerDate) {
		this.nextTriggerDate = nextTriggerDate;
	}

	@Override
	public String toString() {
		return "ShippingSchedule [id=" + id + ", regularInterval=" + regularInterval + ", prevDate=" + prevDate
				+ ", nextTriggerDate=" + nextTriggerDate + "]";
	}

	

}
