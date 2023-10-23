package com.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.*;
import com.dto.StudentDTO;
import com.message.Message;
import com.sql.SqlScript;
import com.vo.StudentVO;

public class CrudCheck {
	
	public static void checkCrud(String sql, Connection con, StudentDTO studentDTO, int id) throws ClassNotFoundException, SQLException {
		
		StudentDAO studentDAO = new StudentDAOImpl();
		switch (sql.charAt(0)) {
		
		case 'i': case 'I':
			if(studentDAO.addStudent(sql, con, studentDTO)>0) {
				System.out.println(Message.opInsert);
			}
			else {
				System.out.println(Message.errInsert);
			}
		break;
			
		case 'u': case 'U':
			if(studentDAO.updateStudent(sql, con, studentDTO, id)>0) {
				System.out.println(Message.opUpdate);
			}
			else {
				System.out.println(Message.errUpdate);
			}
		break;
			
		case 'd': case 'D':
			if(studentDAO.removeStudent(sql, con, id)>0) {
				System.out.println(Message.opDelete);
			}
			else {
				System.out.println(Message.errDelete);
			}
		break;
		}
	}
	
	public static void checkRead(String sql, Connection con) throws SQLException {
		
		StudentDAO studentDAO = new StudentDAOImpl();
		ArrayList<StudentVO> students = studentDAO.readStudent(SqlScript.sqlRead, con);
		
		if (students != null && !students.isEmpty()) {
			students.forEach(student -> System.out.println(student));
			System.out.println(Message.opRead);
		}
		else {
			System.out.println(Message.errRead);
		}
	}
}