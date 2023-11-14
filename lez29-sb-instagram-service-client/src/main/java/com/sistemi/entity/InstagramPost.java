package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Table(name="instagram_post")
@Entity
public class InstagramPost implements Serializable {
	private static final long serialVersionUID = 4797774343108366941L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@Size(min = 1,max = 18)
	private String message;
	@Column(name="is_storie")
	private Boolean isStorie;
	@Column(name="is_reel")
	private Boolean isReel;
	
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
	public Boolean getIsStorie() {
		return isStorie;
	}
	public void setIsStorie(Boolean isStorie) {
		this.isStorie = isStorie;
	}
	public Boolean getIsReel() {
		return isReel;
	}
	public void setIsReel(Boolean isReel) {
		this.isReel = isReel;
	}
	
	protected InstagramPost() {}
	public InstagramPost(Integer id, String message, Boolean isStorie, Boolean isReel) {
		super();
		this.id = id;
		this.message = message;
		this.isStorie = isStorie;
		this.isReel = isReel;
	}
	public InstagramPost(String message, Boolean isStorie, Boolean isReel) {
		super();
		this.message = message;
		this.isStorie = isStorie;
		this.isReel = isReel;
	}	
}
