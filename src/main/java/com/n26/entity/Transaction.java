package com.n26.entity;

import java.io.Serializable;

public class Transaction implements Serializable {
	
	private double amount;
	private Long timeStamp;
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

}
