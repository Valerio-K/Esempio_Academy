package com.sistemi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemi.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	/* Estendendo JpaRepository ereditiamo una serie di metodi che
	 * implementano intrinsecamente logiche di CRUD, tra i quali:
	 * 
	 * findAll----->>> ricerca di di tutte le Entity
	 * existsById --->>>> verifica esistenza chiave primaria
	 * deleteById --->>> cancellazione per chiave primaria
	 * save------>>>inserimento/aggiornamento
	 * findById----->>>>ricerca per chiave primaria
	 * 
	 * Tali metodi vengono overridati con l'Oggetto Book
	 * (di default sono generici) in quanto abbiamo tipizzato
	 * JpaRepository con tale Oggetto e quindi abbiamo abilitato
	 * il modulo Spring Data a "logicare" le CRUD secondo la
	 * nostra Entity
	 */
	
	public List<Book> findByGenre(String genre);
}
