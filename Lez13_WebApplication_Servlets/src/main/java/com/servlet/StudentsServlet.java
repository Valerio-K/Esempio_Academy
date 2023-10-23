package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

@WebServlet("/students")
public class StudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con = null;
		StudentDAO studentDAO = DAOSingleton.getStudentDAO();
		ArrayList<StudentVO> students = new ArrayList<>();
		HttpSession session = null;
		
		try {
			con = DAOSingleton.getSingletonConnection();
			students = studentDAO.readStudent(SqlScript.sqlRead, con);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		if (!students.isEmpty()) {
			session = request.getSession();
			session.setAttribute("students", students);
			response.sendRedirect("students.jsp");
		}
		else {
			response.sendRedirect("error.html");
		}				
	}
}
