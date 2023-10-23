package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.IscrittiDAO;
import com.dao.IscrittiDAOImpl;

public class Singleton {
	
	private static IscrittiDAO iscrittiDAO;
	private static Connection con;
	
	public static IscrittiDAO getIscrittiDAO() {
    	
        if (iscrittiDAO == null) {
        	iscrittiDAO = new IscrittiDAOImpl();
        }
        return iscrittiDAO;
    }
	
	public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
    	
        if (con == null) {
        	con = ConnectionManager.getConnection();
        }
        return con;
    }

}
