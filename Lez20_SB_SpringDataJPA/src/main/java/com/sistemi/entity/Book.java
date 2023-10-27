package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book implements Serializable {
	
	private static final long serialVersionUID = 7138580845713018144L;
	
	@Id
	private long isbn;
	private String title;
	private String genre;
	
	public long getIsbn() {
		return isbn;
	}
	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	protected Book() {}
			
	public Book(long isbn, String title, String genre) {
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", genre=" + genre + "]";
	}
}
