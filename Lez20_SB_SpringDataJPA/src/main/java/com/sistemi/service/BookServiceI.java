package com.sistemi.service;

import com.sistemi.entity.Book;

public interface BookServiceI {
	
	public void saveOrUpdateBook(Book book);
	
	public void deleteBook(long isbn);
	
	public void findAllBooks();

	public void findByGenre(String genre);
}
