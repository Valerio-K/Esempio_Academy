package com.sistemi.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sistemi.entity.Course;
import com.sistemi.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CourseStudentRepository implements CourseStudentRepositoryI {
	
	@PersistenceContext
    private EntityManager em;

	@Override
	public void insertCourse(Course course) {
		em.persist(course);
	}

	@Override
	public void insertStudent(Student student) {
		em.persist(student);
	}

	@Override
	public List<Student> readStudentsByCourse(int courseID) {
		return em.find(Course.class, courseID).getStudents();
	}

	@Override
	public List<Course> readCoursesByStudent(int studentID) {
		return em.find(Student.class, studentID).getCourses();
	}

}
