package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FacebookPost implements Serializable {
	private static final long serialVersionUID = -7450559412764246098L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String message;
	private Boolean isTagged;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Boolean getIsTagged() {
		return isTagged;
	}
	public void setIsTagged(Boolean isTagged) {
		this.isTagged = isTagged;
	}
	
	protected FacebookPost() {}
	public FacebookPost(Integer id, String message, Boolean isTagged) {
		this.id = id;
		this.message = message;
		this.isTagged = isTagged;
	}
	public FacebookPost(String message, Boolean isTagged) {
		this.message = message;
		this.isTagged = isTagged;
	}
}
