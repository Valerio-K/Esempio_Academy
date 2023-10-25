package com.sistemi.repository;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.entity.Course;
import com.sistemi.entity.Review;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseReviewRepository implements CourseReviewRepositoryI {
	
	@PersistenceContext
    private EntityManager em;
	
	@Override
	public void insertCourse(Course course) {
		em.persist(course);
	}
	
	@Override
	public void insertReview(Review review) {
		em.persist(review);
	}
	
	@Override
	public List<Review> readReviewsByCourse(int courseID) {
		Course course = em.find(Course.class, courseID);
		Hibernate.initialize(course.getReviews());
		return course.getReviews();
	}
}
