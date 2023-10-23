package com.sql;

public interface SqlScript {
	
	public String sqlCustomerInsert="INSERT INTO customer(name, country) VALUES (?,?)";
	public String sqlProductInsert="INSERT INTO product(name, origin) VALUES (?,?)";
	public String sqlCustomerProductInsert="INSERT INTO customer_product(customer_id, product_id) VALUES (?,?)";
	public String sqlCustomerMaxID="SELECT max(id) FROM customer";
	public String sqlProductMaxID="SELECT max(id) FROM product";
	public String sqlCustomersNameByProduct =
			"SELECT customer.name FROM customer LEFT JOIN customer_product ON customer.id=customer_product.customer_id WHERE customer_product.product_id=?";
}
