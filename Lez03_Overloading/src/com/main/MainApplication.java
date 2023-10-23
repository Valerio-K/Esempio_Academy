package com.main;

import com.operazioni.*;

public class MainApplication {
	
	public static void main(String[] args) {
		Operazione operazione = new Operazione();
		int somma1=operazione.somma(3, 4);
		int somma2=operazione.somma(5, 7, 10);
		double somma3=operazione.somma(54.5, 23);
		System.out.println(somma1);
		System.out.println(somma2);
		System.out.println(somma3);
		
	}

}
