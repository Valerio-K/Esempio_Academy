package com.bean;  //perché creo un JavaBean

public class Corso {
	
	private String codice;
	private String titolo;
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
	public String getSede() {
		return sede;
	}
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	//Costruttore in visibilità protected (come consigliato)
	protected Corso() {
		
	}
	
	public Corso(String codice, String titolo, String sede) {
		this.codice = codice;
		this.titolo = titolo;
		this.sede = sede;
	}
	
	@Override
	public String toString() {
		return "Corso [codice=" + codice + ", titolo=" + titolo + ", sede=" + sede + "]";
	}
	
	
}
