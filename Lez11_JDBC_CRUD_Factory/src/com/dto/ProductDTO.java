package com.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1792755955431731417L;
	
	private String name;
	private String origin;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	protected ProductDTO() {
		
	}
	
	public ProductDTO(String name, String origin) {
		super();
		this.name = name;
		this.origin = origin;
	}
}
