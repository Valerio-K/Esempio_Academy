package com.main;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.connection.ConnectionManager;
import com.facade.FacadeDAOImpl;
import com.dto.CourseDTO;
import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ConnectionManagerI conMan = new ConnectionManager();
		Connection con = conMan.getConnection();
		
		/*
		 * Vogliamo inserire un record a course, poi due record a review 
		 * collegate ad esso.
		 */
		FacadeDAOImpl facadeDAO = new FacadeDAOImpl();
		CourseDTO courseDTO = new CourseDTO("React","Front-End Framework");
		facadeDAO.addCourse(con, conMan, courseDTO);
		int maxCourseID = facadeDAO.findCourseMaxID(con, conMan);
		
		ReviewDTO reviewDTO1 = new ReviewDTO("Dublin",maxCourseID);
		ReviewDTO reviewDTO2 = new ReviewDTO("Madrid",maxCourseID);
		facadeDAO.addReview(con, conMan, reviewDTO1);
		facadeDAO.addReview(con, conMan, reviewDTO2);
		
		ArrayList<ReviewVO> reviews = facadeDAO.findReviewLocationsByCourse(con, conMan, maxCourseID);
		reviews.forEach(location -> System.out.println(location.getLocation()));
		
		conMan.closeConnection(con);
	}

}
