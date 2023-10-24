package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Student;
import com.sistemi.service.StudentServiceI;

@SpringBootApplication
public class Lez17SbJpaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private StudentServiceI studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(Lez17SbJpaCrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//INSERT
		Student studentOne = new Student("Robert","DeNiro",81);
		Student studentTwo = new Student("Al","Pacino",78);
		Student studentThree = new Student("Brad","Pitt",61);
		
		studentService.insertStudent(studentOne);
		studentService.insertStudent(studentTwo);
		studentService.insertStudent(studentThree);
		
		//UPDATE
		Student studentToUpdate = new Student(3,"Brad","Pitt",60);
		studentService.updateStudent(studentToUpdate);
		
		//DELETE
		studentService.deleteStudent(2);
		
		//READ ALL
		studentService.readStudents();
		
		//READ LAST NAME
		studentService.readStudentByLastName("DeNiro");
	}

}
