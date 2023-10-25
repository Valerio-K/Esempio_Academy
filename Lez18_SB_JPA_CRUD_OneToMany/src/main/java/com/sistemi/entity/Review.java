package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Review implements Serializable {

	private static final long serialVersionUID = -2143201067562971162L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String location;
	
	@ManyToOne
	private Course course;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	protected Review() {}
	
	public Review(String location, Course course) {
		this.location = location;
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", location=" + location + ", course=" + course + "]";
	}
}
