package com.bean;

public class Indirizzo {
	
	private String via;
	private int numeroCivico;
	private String cap; //nonostante sia intero si preferisce il tipo String perchè molti iniziano per 00
	private String citta; //meglio non usare accenti o apostrofi
	private String nazione;
	
	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public int getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(int numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCittà() {
		return citta;
	}

	public void setCittà(String citta) {
		this.citta = citta;
	}

	public String getNazione() {
		return nazione;
	}

	public void setNazione(String nazione) {
		this.nazione = nazione;
	}

	protected Indirizzo() {
		
	}

	public Indirizzo(String via, int numeroCivico, String cap, String citta, String nazione) {
		this.via = via;
		this.numeroCivico = numeroCivico;
		this.cap = cap;
		this.citta = citta;
		this.nazione = nazione;
	}

	@Override
	public String toString() {
		return "via " + via + " " + numeroCivico + ", " + cap + ", " + citta
				+ ", " + nazione;
	}

}
