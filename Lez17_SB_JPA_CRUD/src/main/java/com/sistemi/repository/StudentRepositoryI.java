package com.sistemi.repository;

import java.util.List;

import com.sistemi.entity.Student;

public interface StudentRepositoryI {

	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);

	public List<Student> readStudents();

	public List<Student> readStudentByLastName(String lastName);

}
