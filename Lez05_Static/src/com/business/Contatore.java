package com.business;

public class Contatore {
	
	private static int x; //è variabile di classe, non di istanza (ha static)
	
	public void contatore() {
		x=x+1;
		System.out.println("Valore di x: " + x);
	}
	
	//é metodo di classe (ha static)
	public static void contatoreNew() {
		x=x+1;
		System.out.println("Valore di x: " + x);
	}
	
}
