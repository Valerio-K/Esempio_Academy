package com.vo;

import java.io.Serializable;

public class ReviewVO implements Serializable {
	
	private static final long serialVersionUID = 3688220441024622344L;
	
	private int id;
	private String location;
	private int courseID;
	
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
	public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	
	protected ReviewVO() {
		
	}
	
	//Costruttore Custom apposito per la necessità
	public ReviewVO(String location) {
		this.location = location;
	}
	
	public ReviewVO(int id, String location, int courseID) {
		super();
		this.id = id;
		this.location = location;
		this.courseID = courseID;
	}
	
	@Override
	public String toString() {
		return "ReviewVO [id=" + id + ", location=" + location + ", courseID=" + courseID + "]";
	}
	
}
