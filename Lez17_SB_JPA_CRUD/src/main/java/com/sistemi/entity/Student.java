package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="Student.readStudents", query="SELECT s FROM Student s"),
	@NamedQuery(name="Student.readStudentByLastName", query="SELECT s FROM Student s WHERE s.lastName=:lastName")
})
@Entity
public class Student implements Serializable {
	
	private static final long serialVersionUID = -1588532061608162375L;
	
	@Id	//PK
	@GeneratedValue(strategy=GenerationType.IDENTITY)	//AI
	private int id;
	
	@Column(name="first_name", length=50)
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	//non specificando è default
	private int age;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	protected Student() {} //serve ad Hibernate
	
	public Student(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public Student(int id, String firstName, String lastName, int age) {
		this.id=id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", " + firstName + " " + lastName + ", age=" + age + "]";
	}
	
}
