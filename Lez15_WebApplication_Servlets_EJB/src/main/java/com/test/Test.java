package com.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.Singleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

class Test {

	@org.junit.jupiter.api.Test
	void test1() throws ClassNotFoundException, SQLException {
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		StudentDTO studentDTO = new StudentDTO("Mario","Bianchi",34);
		int nRowsInserted = studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO);
		assertEquals(nRowsInserted,1);  //tramite import static
	}
	
	@org.junit.jupiter.api.Test
	void test2() throws ClassNotFoundException, SQLException {
		ArrayList<StudentVO> students = new ArrayList<>();
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		students = studentDAO.readStudent(SqlScript.sqlRead, con);
		assertEquals(students.size(),13);
	}
}
