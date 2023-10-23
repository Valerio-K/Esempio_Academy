package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connection.ConnectionManager;
import com.dto.CourseDTO;

public class CourseDAOImpl implements CourseDAO {

	@Override
	public void addCourse(String sql, Connection con, CourseDTO courseDTO) throws ClassNotFoundException, SQLException {
		//sql = INSERT INTO course(title,description) VALUES (?,?)
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setString(1, courseDTO.getTitle());
		ps.setString(2, courseDTO.getDescription());
		
		ps.executeUpdate();		
	}
	
	@Override
	public int findCourseMaxID(String sql, Connection con) throws SQLException {
		//sql = SELECT max(id) FROM course
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		int maxID = 0;
		if (rs.next()) {
			maxID = rs.getInt(1);
		}
		return maxID;
	}

}
