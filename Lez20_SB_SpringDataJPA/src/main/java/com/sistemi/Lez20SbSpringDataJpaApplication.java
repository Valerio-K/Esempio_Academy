package com.sistemi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Book;
import com.sistemi.service.BookServiceI;

@SpringBootApplication
public class Lez20SbSpringDataJpaApplication implements CommandLineRunner {
	
	@Autowired
	private BookServiceI serv;
	
	public static void main(String[] args) {
		SpringApplication.run(Lez20SbSpringDataJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book(1111111111L, "Harry Potter 1", "Fantasy");
		Book book2 = new Book(2222222222L, "Romeo&Giulietta", "Romanzo");
		Book book3 = new Book(1111111111L, "Harry Potter 2", "Fantasy");
		Book book4 = new Book(4444444444L, "Amleto", "Romanzo");
		Book book5 = new Book(5555555555L, "Harry Potter 3", "Fantasy");
		serv.saveOrUpdateBook(book1);
		serv.saveOrUpdateBook(book2);
		serv.saveOrUpdateBook(book3); //update, stessa PK
		serv.saveOrUpdateBook(book4);
		serv.saveOrUpdateBook(book5);
		
		serv.deleteBook(4444444444L);
		serv.findByGenre("Fantasy");		
	}
}