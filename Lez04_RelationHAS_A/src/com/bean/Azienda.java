package com.bean;

public class Azienda {
	
	/*
	 * Ad esempio posso esprimere una di queste variabili (sedeLegale) come altro tipo di classe
	 * La classe Azienda HAS-A info complessa di un tipo Object costruito tramite un'altra Classe
	 */
	private String partitaIva;
	private String ragioneSociale;
	private Indirizzo sedeLegale; //qui sono in relazione HAS-A con Indirizzo
	
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public Indirizzo getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(Indirizzo sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	
	protected Azienda() {
		
	}
	
	public Azienda(String partitaIva, String ragioneSociale, Indirizzo sedeLegale) {
		this.partitaIva = partitaIva;
		this.ragioneSociale = ragioneSociale;
		this.sedeLegale = sedeLegale;
	}
	
	@Override
	public String toString() {
		return "Azienda [partita Iva=" + partitaIva + ", ragione Sociale=" + ragioneSociale + ", sede Legale=" + sedeLegale
				+ "]";
	}
	
}
