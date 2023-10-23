package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.ReviewDTO;
import com.vo.ReviewVO;

public interface ReviewDAO {
	
	public void addReview(String sql, Connection con, ReviewDTO reviewDTO) throws ClassNotFoundException, SQLException;
	
	public ArrayList<ReviewVO> findReviewLocationsByCourse(String sql, Connection con, int courseID) throws ClassNotFoundException, SQLException;
}
