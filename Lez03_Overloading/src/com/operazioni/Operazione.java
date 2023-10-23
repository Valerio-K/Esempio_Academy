package com.operazioni;

public class Operazione {
	
	public int somma(int x, int y) {
		return x+y; //keyword return per il ritorno del valore voluto dal metodo
	}
	
	/*
	 * OVERLOADING di metodo (polimorfismo di metodo), bisogna cambiare ALMENO la lista dei parametri
	 * è possibile anche cambiare il tipo ei parametri (es: da int a byte)
	 */
	public int somma(int x, int y, int z) {
		return x+y+z;
	}
	
	public double somma(double x, double y) {
		return x+y;
	}
}
