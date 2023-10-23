package com.singleton;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

public class DAOSingleton {
	private static StudentDAO studentDAO;
	private static Connection con;

    public static StudentDAO getStudentDAO() {
    	
        if (studentDAO == null) {
        	studentDAO = new StudentDAOImpl();
        }
        return studentDAO;
    }
    
    public static Connection getSingletonConnection() throws ClassNotFoundException, SQLException {
    	
        if (con == null || con.isClosed()) {
        	con = ConnectionManager.getConnection();
        }
        return con;
    }
}
