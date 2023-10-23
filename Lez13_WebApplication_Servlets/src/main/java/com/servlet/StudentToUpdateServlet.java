package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;
import com.vo.StudentVO;

@WebServlet("/toUpdate")
public class StudentToUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		HttpSession session = null;
		
		String id = request.getParameter("id");
		StudentDAO studentDAO = DAOSingleton.getStudentDAO();
		StudentVO studentVO = null;
		
		try {
			con=DAOSingleton.getSingletonConnection();
			studentVO = studentDAO.readOneStudent(SqlScript.sqlOneRead, con, Integer.parseInt(id));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(studentVO!= null) {
			session = request.getSession();
			session.setAttribute("studentVO", studentVO);
			response.sendRedirect("studentUpdate.jsp");
		}
		else {
			response.sendRedirect("error.html");
		}
	}
}
