package com.facade;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.dao.*;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.sql.SqlScript;
import com.vo.ReviewVO;

public class FacadeDAOImpl {
	private CourseDAO courseDAO = null;
	private ReviewDAO reviewDAO = null;
	
	public void addCourse(Connection con, ConnectionManagerI conMan, CourseDTO courseDTO) throws ClassNotFoundException, SQLException {
		if (courseDAO==null) {
			courseDAO = new CourseDAOImpl();
		}
		courseDAO.addCourse(SqlScript.sqlCourseInsert, con, conMan, courseDTO);
	}
	
	public int findCourseMaxID(Connection con, ConnectionManagerI conMan) throws SQLException {
		if (courseDAO==null) {
			courseDAO = new CourseDAOImpl();
		}
		return courseDAO.findCourseMaxID(SqlScript.sqlCourseMaxID, con, conMan);
	}
	
	public void addReview(Connection con, ConnectionManagerI conMan, ReviewDTO reviewDTO) throws ClassNotFoundException, SQLException{
		if (reviewDAO==null) {
			reviewDAO = new ReviewDAOImpl();
		}
		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, conMan, reviewDTO);
	}
	
	public ArrayList<ReviewVO> findReviewLocationsByCourse(Connection con, ConnectionManagerI conMan, int courseID) throws ClassNotFoundException, SQLException{
		if (reviewDAO==null) {
			reviewDAO = new ReviewDAOImpl();
		}
		return reviewDAO.findReviewLocationsByCourse(SqlScript.sqlReviewLocationByCourse, con, conMan, courseID);
	}

}
