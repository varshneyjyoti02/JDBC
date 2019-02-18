package com.capgemini.beans;

public class Customer {
	private String name;
	private String mobileNumber;
	private double wallet;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	public Customer(String name, String mobileNumber, double wallet) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.wallet = wallet;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [name=" + name + ", mobileNumber=" + mobileNumber + ", wallet=" + wallet + "]";
	}
	
	
	
	
	
	
	
	
	
	
	

}
