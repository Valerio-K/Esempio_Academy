package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.dao.ReviewDAO;
import com.dao.ReviewDAOImpl;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.sql.SqlScript;
import com.vo.ReviewVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();
		
		/*
		 * Vogliamo inserire un record a course, poi due record a review 
		 * collegate ad esso.
		 */
		CourseDAO courseDAO = new CourseDAOImpl();
		CourseDTO courseDTO = new CourseDTO("React","Front-End Framework");
		courseDAO.addCourse(SqlScript.sqlCourseInsert, con, courseDTO);
		int maxCourseID = courseDAO.findCourseMaxID(SqlScript.sqlCourseMaxID, con);
		
		ReviewDAO reviewDAO = new ReviewDAOImpl();
		ReviewDTO reviewDTO1 = new ReviewDTO("Dublin",maxCourseID);
		ReviewDTO reviewDTO2 = new ReviewDTO("Madrid",maxCourseID);
		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO1);
		reviewDAO.addReview(SqlScript.sqlReviewInsert, con, reviewDTO2);
		
		ArrayList<ReviewVO> reviews = reviewDAO.findReviewLocationsByCourse(SqlScript.sqlReviewLocationByCourse, con, maxCourseID);
		reviews.forEach(location -> System.out.println(location.getLocation()));
	}

}
