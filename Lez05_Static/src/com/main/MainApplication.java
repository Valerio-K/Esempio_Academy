package com.main;

import com.business.Contatore;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contatore cont = new Contatore();
		cont.contatore();
		Contatore cont1 = new Contatore();
		cont1.contatore();
		/*
		 * per una var di istanza non sarebbe successo ciò
		 * essendo static, salva il valore
		 * Non ho una copia per ogni istanza della classe,
		 * ma una locaz di memoria condivisa da tutte le istanze
		 * della stessa classe
		 */
		
		Contatore.contatoreNew();
		/*
		 * posso farlo perché è un metodo static,
		 * non serve istanziare un oggetto.
		 */
	}

}
