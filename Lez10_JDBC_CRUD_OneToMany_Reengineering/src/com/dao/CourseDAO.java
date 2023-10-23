package com.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.connection.ConnectionManagerI;
import com.dto.CourseDTO;

public interface CourseDAO {
	
	public void addCourse(String sql, Connection con, ConnectionManagerI conMan, CourseDTO courseDTO) throws ClassNotFoundException, SQLException;
	
	public int findCourseMaxID(String sql, Connection con, ConnectionManagerI conMan) throws SQLException;
}
