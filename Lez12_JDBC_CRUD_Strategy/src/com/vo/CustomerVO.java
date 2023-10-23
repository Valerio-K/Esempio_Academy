package com.vo;

import java.io.Serializable;

public class CustomerVO implements Serializable {
	
	private static final long serialVersionUID = -3337233735798586662L;
	
	private int id;
	private String name;
	private String country;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	protected CustomerVO() {
		
	}
	
	public CustomerVO(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Customer: [id=" + id + ", name=" + name + ", country=" + country + "]";
	}
	
	
}
