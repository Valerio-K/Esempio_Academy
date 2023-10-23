package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;

public class Singleton {
	
	private static Connection con;
	
	public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
    	
        if (con == null) {
        	con = ConnectionManager.getConnection();
        }
        return con;
    }

}
