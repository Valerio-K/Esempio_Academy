package com.bean;

import java.io.Serializable;

public class CustomerProduct implements Serializable {
	
	private static final long serialVersionUID = -5521803481007779486L;
	
	private int customerID;
	private int productID;
	
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	protected CustomerProduct() {
		
	}
	
	public CustomerProduct(int customerID, int productID) {
		this.customerID = customerID;
		this.productID = productID;
	}
	
	@Override
	public String toString() {
		return "CustomerProduct [customerID=" + customerID + ", productID=" + productID + "]";
	}
	
}