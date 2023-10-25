package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Course;
import com.sistemi.entity.Student;

public interface CourseStudentRepositoryI {
	
	public void insertCourse(Course course);
	
	public void insertStudent(Student student);
	
	public List<Student> readStudentsByCourse(int courseID);
	
	public List<Course> readCoursesByStudent(int studentID);
}
