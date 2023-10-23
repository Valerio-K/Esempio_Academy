package com.bean;

public class Academy {
	
	private String codice;
	private String titolo;
	private String fondo;
	private String sede;
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getFondo() {
		return fondo;
	}
	public void setFondo(String fondo) {
		this.fondo = fondo;
	}
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	protected Academy() {
		
	}
	
	public Academy(String codice, String titolo, String fondo, String sede) {
		super();
		this.codice = codice;
		this.titolo = titolo;
		this.fondo = fondo;
		this.sede = sede;
	}
	
	@Override
	public String toString() {
		return "Academy [codice=" + codice + ", titolo=" + titolo + ", fondo=" + fondo + ", sede=" + sede + "]";
	}
	
}
