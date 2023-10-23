package com.dto;

import java.io.Serializable;

public class LibroDTO implements Serializable {
	
	private static final long serialVersionUID = -8884716036024884569L;
	
	private String titolo;
	private String autore;
	private int pubblicazione;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public int getPubblicazione() {
		return pubblicazione;
	}
	public void setPubblicazione(int pubblicazione) {
		this.pubblicazione = pubblicazione;
	}
	
	public LibroDTO(String titolo, String autore, int pubblicazione) {
		this.titolo = titolo;
		this.autore = autore;
		this.pubblicazione = pubblicazione;
	}
}
