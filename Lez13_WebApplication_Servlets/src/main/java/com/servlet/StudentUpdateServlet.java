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
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;

@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		int nRowsUpdated = 0;
		
		String id = request.getParameter("id");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, Integer.parseInt(age));
		StudentDAO studentDAO = DAOSingleton.getStudentDAO();
		
		try {
			con = DAOSingleton.getSingletonConnection();
			nRowsUpdated = studentDAO.updateStudent(SqlScript.sqlUpdate, con, studentDTO, Integer.parseInt(id));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(nRowsUpdated>0) {
			response.sendRedirect("students");
		}
		else {
			response.sendRedirect("error.html");
		}
	}
}
