package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		int nRowsDeleted = 0;
		
		String id = request.getParameter("id");
		StudentDAO studentDAO = DAOSingleton.getStudentDAO();
		
		try {
			con=DAOSingleton.getSingletonConnection();
			nRowsDeleted = studentDAO.removeStudent(SqlScript.sqlDelete, con, Integer.parseInt(id));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(nRowsDeleted>0) {
			response.sendRedirect("students");
		}
		else {
			response.sendRedirect("error.html");
		}
	}
}
