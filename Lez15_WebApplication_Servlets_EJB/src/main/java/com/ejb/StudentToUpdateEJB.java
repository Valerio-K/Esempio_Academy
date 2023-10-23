package com.ejb;

import java.sql.Connection;
import java.sql.SQLException;

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
public class StudentToUpdateEJB implements StudentToUpdateEJBLocal {
	
	@Override
	public String readOneStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException {
		String page = Page.error;
		
		Connection con = Singleton.getSingletonConnection();
		StudentDAO studentDAO = Singleton.getStudentDAO();
		
		String id = request.getParameter("id");
		
		StudentVO studentVO = studentDAO.readOneStudent(SqlScript.sqlOneRead, con, Integer.parseInt(id));
		if (!(request.getRequestedSessionId()==null)  && !request.isRequestedSessionIdValid()) {
			ConnectionManager.closeConnection(con);
		}
		if(studentVO!= null) {
			HttpSession session = request.getSession();
			session.setAttribute(SessionKey.studentsVOKey, studentVO);
			page = Page.studentUpdate;
		}
		return page;
	}
}
