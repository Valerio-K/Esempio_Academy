package com.vo;

import java.io.Serializable;

public class LibroVO implements Serializable {
	
	private static final long serialVersionUID = -2575296872958745563L;
	
	private int id;
	private String titolo;
	private String autore;
	private int pubblicazione;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	public LibroVO(int id, String titolo, String autore, int pubblicazione) {
		this.id = id;
		this.titolo = titolo;
		this.autore = autore;
		this.pubblicazione = pubblicazione;
	}
	
	@Override
	public String toString() {
		return "[id: " + id + ", titolo=" + titolo + ", autore=" + autore + ", pubblicazione=" + pubblicazione
				+ "]";
	}
}
