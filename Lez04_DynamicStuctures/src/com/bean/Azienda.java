package com.bean;

public class Azienda {
	
	private String partitaIVA;
	private String ragioneSociale;
	private String sedeLegale;
	private int numDipendenti;
	
	public String getPartitaIVA() {
		return partitaIVA;
	}
	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}
	public String getRagioneSociale() {
		return ragioneSociale;
	}
	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}
	public String getSedeLegale() {
		return sedeLegale;
	}
	public void setSedeLegale(String sedeLegale) {
		this.sedeLegale = sedeLegale;
	}
	public int getNumDipendenti() {
		return numDipendenti;
	}
	public void setNumDipendenti(int numDipendenti) {
		this.numDipendenti = numDipendenti;
	}
	
	protected Azienda() {
		
	}
	
	public Azienda(String partitaIVA, String ragioneSociale, String sedeLegale, int numDipendenti) {
		//super();
		this.partitaIVA = partitaIVA;
		this.ragioneSociale = ragioneSociale;
		this.sedeLegale = sedeLegale;
		this.numDipendenti = numDipendenti;
	}
	
	@Override
	public String toString() {
		return "Azienda[partitaIVA=" + partitaIVA + ", ragioneSociale=" + ragioneSociale + ", sedeLegale=" + sedeLegale
				+ ", numDipendenti=" + numDipendenti + "]";
	}

}
