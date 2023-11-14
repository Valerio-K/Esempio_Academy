package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Tweet implements Serializable {
	private static final long serialVersionUID = -8942527918482817193L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Column(name="hash_tag")
	@Size(min = 1,max = 12)
	private String hashTag;
	private String message;
	@Column(name="is_tagged")
	private Boolean isTagged;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHashTag() {
		return hashTag;
	}
	public void setHashTag(String hashTag) {
		this.hashTag = hashTag;
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
	
	protected Tweet() {}
	public Tweet(Integer id, @Size(min = 1, max = 12) String hashTag, String message, Boolean isTagged) {
		super();
		this.id = id;
		this.hashTag = hashTag;
		this.message = message;
		this.isTagged = isTagged;
	}
	public Tweet(@Size(min = 1, max = 12) String hashTag, String message, Boolean isTagged) {
		super();
		this.hashTag = hashTag;
		this.message = message;
		this.isTagged = isTagged;
	}
}