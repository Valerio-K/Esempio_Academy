package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.sql.SqlScript;
import com.vo.ProductVO;

public class ProductDAOImpl implements ProductDAO {
	
	@Override
	public ArrayList<Object> findNameProducts(Connection con) throws SQLException {
		ArrayList<Object> products = new ArrayList<>();
		ProductVO productVO = null;
		ResultSet rs = ConnectionManager.getResultSet(SqlScript.sqlFindNameProducts, con);
		
		while(rs.next()) {
			productVO = new ProductVO(0,rs.getString("name"),null);
			products.add(productVO.getName());
		} 
		return products;
	}
	
	@Override
	public ArrayList<Object> findPhoneProducts(Connection con, String find) throws SQLException, ClassNotFoundException {
		ArrayList<Object> products = new ArrayList<>();
		ProductVO productVO = null;
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlFindPhoneProducts, con);
		ps.setString(1, find);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			productVO = new ProductVO(0,rs.getString("name"),null);
			products.add(productVO.getName());
		} 
		return products;
	}
}
