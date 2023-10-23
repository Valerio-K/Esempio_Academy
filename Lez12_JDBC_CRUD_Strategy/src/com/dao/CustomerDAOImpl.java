package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.sql.SqlScript;
import com.vo.CustomerVO;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public ArrayList<Object> findAllCustomers(Connection con) throws SQLException {
		ArrayList<Object> customers = new ArrayList<>();
		CustomerVO customerVO = null;
		ResultSet rs = ConnectionManager.getResultSet(SqlScript.sqlFindCustomers, con);
		
		while (rs.next()) {
			customerVO = new CustomerVO(
					rs.getInt("id"),
					rs.getString("name"),
					rs.getString("country"));
			customers.add(customerVO);
		}
		return customers;
	}

}
