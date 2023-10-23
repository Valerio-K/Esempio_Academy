package com.aziende;

public abstract class Azienda {
	
	/*
	 * Tale classe astratta funge da indice applicativo
	 * Per elencare i metodi utilizzati nei successivi figli
	 */
	public abstract void produce();
	
	public abstract void assume();
	
	public void fattura() {
		System.out.println("fattura con IVA al 22%");
	}
	
}
