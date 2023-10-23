package com.sistemi.informativi;

//Studente è classe figlia di Persona, la estende
public class Studente extends Persona {
	
	public void studia() {
		System.out.println("studia");
	}
	
	/*
	 * override (è necessario riscrivere la stessa firma del metodo da sovrascrivere)
	 * tuttavia è necess specificare che è un override
	 */
	
	@Override //annotation (iniziale maiusc)
	public void dorme() {
		System.out.println("dorme poco se sotto esame");
	}
}
