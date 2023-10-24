package com.sistemi.service;

import com.sistemi.entity.Student;

public interface StudentServiceI {
	
	public void insertStudent(Student student);

	public void updateStudent(Student student);

	public void deleteStudent(int id);

	public void readStudents();

	public void readStudentByLastName(String lastName);
}
