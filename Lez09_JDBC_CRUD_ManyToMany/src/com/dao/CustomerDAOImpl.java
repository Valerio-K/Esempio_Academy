package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.CustomerDTO;
import com.vo.CustomerVO;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Override
	public void addCustomer(String sql, Connection con, CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
		//sql = INSERT INTO customer(name, country) VALUES (?,?)
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setString(1, customerDTO.getName());
		ps.setString(2, customerDTO.getCountry());
		
		ps.executeUpdate();
	}
	
	@Override
	public ArrayList<CustomerVO> findCustomersNameByProduct (String sql, Connection con, int productID) throws ClassNotFoundException, SQLException {
		ArrayList<CustomerVO> customers = new ArrayList<>();
		CustomerVO customerVO = null;
		
		//sql = "SELECT customer.name FROM customer LEFT JOIN customer_product
			//ON customer.id=customer_product.customer_id
			//WHERE customer_product.product_id=?"
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, productID);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			customerVO = new CustomerVO(0,rs.getString("name"),null);
			customers.add(customerVO);
		}
		return customers;
	}
}
