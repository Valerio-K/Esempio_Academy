package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Course;
import com.sistemi.entity.Review;

public interface CourseReviewRepositoryI {

	void insertCourse(Course course);

	void insertReview(Review review);

	List<Review> readReviewsByCourse(int courseID);

}
