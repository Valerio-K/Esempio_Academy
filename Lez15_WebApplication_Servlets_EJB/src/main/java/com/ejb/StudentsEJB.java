package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.Singleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@Stateless
public class StudentsEJB implements StudentsEJBLocal {
	
	@Override
	public String readStudents(HttpServletRequest request) throws SQLException, ClassNotFoundException {
		
		String page = Page.error;
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		ArrayList<StudentVO> students = new ArrayList<>();
		students = studentDAO.readStudent(SqlScript.sqlRead, con);
		
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {
			ConnectionManager.closeConnection(con);
		}
		if (!students.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsListKey, students);
			page = Page.students;
		}
		return page;
	}
}
