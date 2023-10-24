package com.sistemi.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Student;
import com.sistemi.repository.StudentRepositoryI;

@Service
public class StudentService implements StudentServiceI {
	
	@Value("${message.insert.success}")
    private String insertSuccess;
	@Value("${message.insert.fail}")
    private String insertFail;
	@Value("${message.update.success}")
    private String updateSuccess;
	@Value("${message.update.fail}")
    private String updateFail;
    @Value("${message.delete.success}")
    private String deleteSuccess;
	@Value("${message.delete.fail}")
    private String deleteFail;
	@Value("${message.read.fail}")
    private String readFail;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired //Dependency Injection di Spring
	private StudentRepositoryI studentRepo;

	@Override
	public void insertStudent(Student student) {
		/* invocazione metodo Repository e controllo */
		try {
			studentRepo.insertStudent(student);
			log.info(insertSuccess);
		} catch(IllegalArgumentException ex) {
			log.info(insertFail);
		}
	}

	@Override
	public void updateStudent(Student student) {
		try {
			studentRepo.updateStudent(student);
			log.info(updateSuccess);
		} catch(IllegalArgumentException ex) {
			log.info(updateFail);
		}
	}

	@Override
	public void deleteStudent(int id) {
		try {
			studentRepo.deleteStudent(id);
			log.info(deleteSuccess);
		} catch(IllegalArgumentException ex) {
			log.info(deleteFail);
			
		}
	}

	@Override
	public void readStudents() {
		List<Student> students = new ArrayList<>();
		students = studentRepo.readStudents();
		if(!students.isEmpty()) {
			students.forEach(student->log.info(student.toString()));
		} else {
			log.info(readFail);
		}
	}

	@Override
	public void readStudentByLastName(String lastName) {
		List<Student> students = new ArrayList<>();
		students = studentRepo.readStudentByLastName(lastName);
		if(!students.isEmpty()) {
			students.forEach(student->log.info(student.toString()));
		} else {
			log.info(readFail);
		}
	}
}
