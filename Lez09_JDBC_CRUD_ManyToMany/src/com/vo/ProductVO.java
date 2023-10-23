package com.vo;

import java.io.Serializable;

public class ProductVO implements Serializable {
	
	private static final long serialVersionUID = 614160745544668806L;
	
	private int id;
	private String name;
	private String origin;
	
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
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	protected ProductVO() {
		
	}
	
	public ProductVO(int id, String name, String origin) {
		super();
		this.id = id;
		this.name = name;
		this.origin = origin;
	}
	
	@Override
	public String toString() {
		return "ProductVO [id=" + id + ", name=" + name + ", origin=" + origin + "]";
	}
	
}
