package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public class ReviewDAOImpl implements ReviewDAO {

	@Override
	public void addReview(String sql, Connection con, ConnectionManagerI conMan, ReviewDTO reviewDTO) throws ClassNotFoundException, SQLException {		
		// sql = INSERT INTO review(location,course_id) VALUES(?,?)
		PreparedStatement ps = conMan.getPreparedStatement(sql, con);
		ps.setString(1, reviewDTO.getLocation());
		ps.setInt(2, reviewDTO.getCourseID());
		
		ps.executeUpdate();
	}
	
	@Override
	public ArrayList<ReviewVO> findReviewLocationsByCourse(String sql, Connection con, ConnectionManagerI conMan, int courseID) throws ClassNotFoundException, SQLException {
		ArrayList<ReviewVO> reviews = new ArrayList<>();
		ReviewVO reviewVO = null;
		
		//sql = "SELECT review.location FROM review,course WHERE review.course_id=course.id AND course.id=?"
		
		PreparedStatement ps = conMan.getPreparedStatement(sql, con);
		ps.setInt(1, courseID);
		
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			reviewVO = new ReviewVO(0,rs.getString("location"),0);
			reviews.add(reviewVO);
		}
		return reviews;
	}
}