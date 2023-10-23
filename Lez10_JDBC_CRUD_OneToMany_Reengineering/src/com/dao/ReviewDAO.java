package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManagerI;
import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public interface ReviewDAO {
	
	public void addReview(String sql, Connection con, ConnectionManagerI conMan, ReviewDTO reviewDTO) throws ClassNotFoundException, SQLException;
	
	public ArrayList<ReviewVO> findReviewLocationsByCourse(String sql, Connection con, ConnectionManagerI conMan, int courseID) throws ClassNotFoundException, SQLException;
}
