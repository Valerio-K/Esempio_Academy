package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.page.Page;
import com.singleton.Singleton;
import com.sql.SqlScript;

@Stateless
public class StudentUpdateEJB implements StudentUpdateEJBLocal {
	
	@Override
	public String updateStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = Page.error;
		
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
		
		int nRowsUpdated = studentDAO.updateStudent(SqlScript.sqlUpdate, con, studentDTO, Integer.parseInt(id));
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {
			ConnectionManager.closeConnection(con);
		}
		if (nRowsUpdated>0) {
			page = Page.studentsUrl;
		}
		return page;
	}
}
