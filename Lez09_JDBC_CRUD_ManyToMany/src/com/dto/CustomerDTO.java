package com.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {
	
	private static final long serialVersionUID = 7859421796941966955L;
	
	private String name;
	private String country;
	
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
	
	protected CustomerDTO() {
		
	}
	
	public CustomerDTO(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}
}
