package com.main;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dao.LibreriaDAO;
import com.dto.LibroDTO;
import com.facade.LibreriaFacadeI;
import com.vo.LibroVO;

public class MainApplication {
	
	/* Creare APP con i seg requisiti:
	 * -oggetto di dominio: Libro;
	 * -Facade per gestione del libro (Libreria) - inserimento, lista, ricerca;
	 * -main con test delle funzioni;
	 * richiesta inizialmente output a video	*/
	public static void main(String[] args) {
		String ricerca = "ROMEO";
		
		LibroDTO libroDTO1 = new LibroDTO("Harry Potter e la pietra filosofale","J.K. Rowling",1998);
		LibroDTO libroDTO2 = new LibroDTO("Harry Potter e il calice di fuoco","J.K. Rowling",2004);
		LibroDTO libroDTO3 = new LibroDTO("Romeo e Giulietta","William Shakespear",1594);
		LibroDTO libroDTO4 = new LibroDTO("La Divina Commedia","Dante Alighieri",1321);
		
		LibreriaFacadeI libreria = new LibreriaDAO();
		try {
			libreria.aggiungiLibro(libroDTO1);
			libreria.aggiungiLibro(libroDTO2);
			libreria.aggiungiLibro(libroDTO3);
			libreria.aggiungiLibro(libroDTO4);
			
			System.out.println("Libri disponibili:");
			ArrayList<LibroVO> libri = libreria.listaLibri();
			libri.forEach(libro -> System.out.println(libro));
			
			System.out.println("Libri per ricerca = " +ricerca+":");
			ArrayList<LibroVO> libriTitolo = libreria.ricercaLibro("%"+ricerca+"%");
			libriTitolo.forEach(libro -> System.out.println(libro.getTitolo()));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
