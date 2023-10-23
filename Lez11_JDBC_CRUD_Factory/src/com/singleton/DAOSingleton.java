package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.CustomerDAO;
import com.dao.CustomerDAOImpl;
import com.dao.ProductDAO;
import com.dao.ProductDAOImpl;

public class DAOSingleton {
	private static CustomerDAO customerDAO;
	private static ProductDAO productDAO;
	private static Connection con;

    public static CustomerDAO getCustomerDAO() {
    	
        if (customerDAO == null) {
        	customerDAO = new CustomerDAOImpl();
        }
        return customerDAO;
    }
    
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
