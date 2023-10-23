package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.key.SessionKey;
import com.page.Page;
import com.singleton.Singleton;
import com.sql.SqlScript;

@Stateless
public class StudentRegistrationEJB implements StudentRegistrationEJBLocal {
	
	@Override
	public String addStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = Page.error;
		
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
		
		int nRowsInserted = studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO);
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {
			ConnectionManager.closeConnection(con);
		}
		if (nRowsInserted>0) {
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsDTOKey, studentDTO);
			page = Page.success;
		}
		return page;
	}
}
