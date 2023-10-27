package com.sistemi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Book;
import com.sistemi.repository.BookRepository;

@Service
public class BookService implements BookServiceI {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${message.save.success}")
	private String saveSuccess;
	@Value("${message.save.fail}")
	private String saveFail;
	@Value("${message.delete.success}")
	private String deleteSuccess;
	@Value("${message.delete.fail}")
	private String deleteFail;
	@Value("${message.read.fail}")
	private String readFail;
	
	@Autowired
	BookRepository repo;

	@Override
	public void saveOrUpdateBook(Book book) {
		if (book != null && repo.save(book).getIsbn() == book.getIsbn()) {
			log.info(saveSuccess);
		} else {
			log.info(saveFail);
		}
	}

	@Override
	public void deleteBook(long isbn) {
		if(repo.existsById(isbn)) {
			repo.deleteById(isbn);
			log.info(deleteSuccess);
		} else {
			log.info(deleteFail);
		}
	}

	@Override
	public void findAllBooks() {
		List<Book> books = repo.findAll();
		if(!books.isEmpty()) {
			books.forEach(book->log.info(book.toString()));
		} else {
			log.info(readFail);
		}
	}
	
	@Override
	public void findByGenre(String genre) {
		List<Book> books = repo.findByGenre(genre);
		if(!books.isEmpty()) {
			books.forEach(book->log.info(book.toString()));
		} else {
			log.info(readFail);
		}
	}
}