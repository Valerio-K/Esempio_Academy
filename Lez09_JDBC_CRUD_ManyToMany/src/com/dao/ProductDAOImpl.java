package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.ProductDTO;

public class ProductDAOImpl implements ProductDAO {
	
	@Override
	public void addProduct(String sql, Connection con, ProductDTO productDTO) throws ClassNotFoundException, SQLException {
		//sql = INSERT INTO product(name, origin) VALUES (?,?)
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setString(1, productDTO.getName());
		ps.setString(2, productDTO.getOrigin());
		
		ps.executeUpdate();
	}
}
