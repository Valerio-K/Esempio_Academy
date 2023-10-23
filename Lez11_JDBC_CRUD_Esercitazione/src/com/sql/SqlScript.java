package com.sql;

public interface SqlScript {
	
	public String sqlFindPhoneProducts = "SELECT DISTINCT product.name FROM product WHERE product.name LIKE ?";
	public String sqlFindNameProducts = "SELECT product.name FROM product";
}
