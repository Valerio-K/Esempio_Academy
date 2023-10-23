package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;

public class DAOSingleton {
	private static ProductDAO productDAO;
	private static Connection con;
    
    public static ProductDAO getProductDAO() {
    	
        if (productDAO == null) {
        	productDAO = new ProductDAOImpl();
        }
        return productDAO;
    }
    
    public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
    	
        if (con == null) {
        	con = ConnectionManager.getConnection();
        }
        return con;
    }
}
