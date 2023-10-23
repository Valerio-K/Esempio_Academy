package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ejb.StudentRegistrationEJBLocal;

@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/* Dependency Injection di Java EE
	 * per implem del pattern IoC */
	@EJB
	private StudentRegistrationEJBLocal ejb;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			response.sendRedirect(ejb.addStudent(request));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		} 
	}
}
