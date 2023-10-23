package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.bean.CustomerProduct;

public interface CustomerProductDAO {

	void addCustomerProduct(String sql, Connection con, CustomerProduct customerProduct)
			throws ClassNotFoundException, SQLException;

	int findMaxID(String sql, Connection con) throws SQLException;

}
