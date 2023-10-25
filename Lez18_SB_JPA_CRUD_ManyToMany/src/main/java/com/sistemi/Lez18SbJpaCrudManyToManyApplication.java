package com.sistemi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Course;
import com.sistemi.entity.Student;
import com.sistemi.repository.CourseStudentRepository;

@SpringBootApplication
public class Lez18SbJpaCrudManyToManyApplication implements CommandLineRunner {
	
	@Autowired
	private CourseStudentRepository repo;
	public static void main(String[] args) {
		SpringApplication.run(Lez18SbJpaCrudManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student1 = new Student("Mario", "Rossi", 23);
		Student student2 = new Student("Luigi", "Bianchi", 30);
		
		List<Student> studentsCourse1 = new ArrayList<>();
		studentsCourse1.add(student1);
		List<Student> studentsCourse2 = new ArrayList<>();
		studentsCourse2.add(student1);
		studentsCourse2.add(student2);
		
		Course course1 = new Course("JavaSE","Java base");
		Course course2 = new Course("JavaEE","Java avanzato");
		
		List<Course> coursesStudent1 = new ArrayList<>();
		coursesStudent1.add(course1);
		coursesStudent1.add(course2);
		List<Course> coursesStudent2 = new ArrayList<>();
		coursesStudent2.add(course1);
		
		course1.setStudents(studentsCourse1);
		course2.setStudents(studentsCourse2);
		student1.setCourses(coursesStudent1);
		student2.setCourses(coursesStudent2);
		
		repo.insertCourse(course1);
		repo.insertCourse(course2);
		repo.insertStudent(student1);
		repo.insertStudent(student2);
		
		repo.readCoursesByStudent(1).forEach(course->System.out.println(course.toString()));
		repo.readStudentsByCourse(2).forEach(student->System.out.println(student.toString()));
	}

}
