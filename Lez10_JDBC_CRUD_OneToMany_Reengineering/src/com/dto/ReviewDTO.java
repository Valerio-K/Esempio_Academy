package com.dto;

import java.io.Serializable;

public class ReviewDTO implements Serializable {
	
	private static final long serialVersionUID = -8001919657909503919L;
	
	private String location;
	private int courseID;
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	protected ReviewDTO() {
		
	}
	
	public ReviewDTO(String location, int courseID) {
		super();
		this.location = location;
		this.courseID = courseID;
	}
	
}
