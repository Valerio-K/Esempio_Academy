package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.StudentDTO;
import com.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO {
	
	@Override
	public int addStudent(String sql, Connection con, StudentDTO studentDTO) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		
		return ps.executeUpdate();
	}
	
	@Override
	public int updateStudent(String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		
		ps.setString(1, studentDTO.getFirstName());
		ps.setString(2, studentDTO.getLastName());
		ps.setInt(3, studentDTO.getAge());
		ps.setInt(4, id);
		
		return ps.executeUpdate();
	}
	
	@Override
	public int removeStudent(String sql, Connection con, int id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, id);
		
		return ps.executeUpdate();
	}
	
	@Override
	public ArrayList<StudentVO> readStudent(String sql, Connection con) throws SQLException {
		
		ArrayList<StudentVO> students = new ArrayList<>();
		StudentVO studentVO = null;
		ResultSet rs = ConnectionManager.getResultSet(sql, con);
		
		while(rs.next()) {
			studentVO = new StudentVO
					(rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age"));
			students.add(studentVO);
		}
		
		return students;
	}
	
	@Override
	public StudentVO readOneStudent(String sql, Connection con, int id) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql, con);
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		StudentVO studentVO = null;
		
		if (rs.next()) {
			studentVO = new StudentVO(rs.getInt("id"),
					rs.getString("first_name"),
					rs.getString("last_name"),
					rs.getInt("age"));
		}
		return studentVO;
	}
}
