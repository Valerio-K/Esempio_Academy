package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.ConnectionManager;
import com.dao.StudentDAO;
import com.dto.StudentDTO;
import com.singleton.DAOSingleton;
import com.sql.SqlScript;

@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		int nRowsInserted = 0;
		HttpSession session = null;
		
		String firstName = request.getParameter("firstName"); //il nome dell'input
		String lastName = request.getParameter("lastName");
		String age = request.getParameter("age");
		
		int ageInt = 0; //controllo corretto inserimento di age (int)
		try {
			ageInt = Integer.parseInt(age);
		} catch (NumberFormatException e) {
			@SuppressWarnings("unused")
			RequestDispatcher reqDispObj = getServletContext().getRequestDispatcher("/ContextRoot/home.jsp");
		}
		
		StudentDTO studentDTO = new StudentDTO(firstName, lastName, ageInt);
		StudentDAO studentDAO = DAOSingleton.getStudentDAO();
		
		try {
			con = DAOSingleton.getSingletonConnection();
			nRowsInserted = studentDAO.addStudent(SqlScript.sqlInsert, con, studentDTO);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		// Fine flusso di richiesta
		
		// Inizio flusso di risposta
		if(nRowsInserted>0 && ageInt!=0) {
			session = request.getSession();
			session.setAttribute("studentDTO", studentDTO);
			response.sendRedirect("success.jsp");
		}
		else {
			response.sendRedirect("error.html");
		}
	}
}
