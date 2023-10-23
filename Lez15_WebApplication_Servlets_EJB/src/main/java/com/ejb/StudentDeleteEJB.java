package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.page.Page;
import com.singleton.Singleton;
import com.sql.SqlScript;

@Stateless
public class StudentDeleteEJB implements StudentDeleteEJBLocal {
	
	@Override
	public String deleteStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = Page.error;
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		
		String id = request.getParameter("id");
		
		int nRowsDeleted = studentDAO.removeStudent(SqlScript.sqlDelete, con, Integer.parseInt(id));
		
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {
			ConnectionManager.closeConnection(con);
		}
		if (nRowsDeleted>0) {
			page = Page.studentsUrl;
		}
		return page;
	}
}
