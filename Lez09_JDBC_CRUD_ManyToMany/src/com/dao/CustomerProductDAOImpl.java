package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.CustomerProduct;
import com.connection.ConnectionManager;

public class CustomerProductDAOImpl implements CustomerProductDAO {
	
	@Override
	public void addCustomerProduct(String sql, Connection con, CustomerProduct customerProduct) throws ClassNotFoundException, SQLException {
		//sql = INSERT INTO customer_product(customer_id, product_id) VALUES (?,?)
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
				
		ps.setInt(1, customerProduct.getCustomerID());
		ps.setInt(2, customerProduct.getProductID());
				
		ps.executeUpdate();
	}
	
	@Override
	public int findMaxID(String sql, Connection con) throws SQLException {
		int maxID = 0;
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		if (rs.next()) {
			maxID = rs.getInt(1);
		}
		return maxID;
	}
}