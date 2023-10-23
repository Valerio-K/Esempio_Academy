package com.business;

import com.exception.*;

public class GestioneEccezioni {
	
	public void verificaEta(int eta) throws EtaException {
		if (eta<18) {
			throw new EtaException("Eta inferiore a 18!");
			/*
			 * Esiste un'assioma Java secondo cui se un metodo invoca un altro metodo il quale lancia una eccezione
			 * tramite "throw" deve a sua volta lanciare la stessa eccezione
			 * In questo caso il metodo verificaEta sta lanciando un costruttore tramite throw, dunque bisogna
			 * aggiungere "throws EtaException" nel metodo invocante
			 */
		}
		
		else {
			System.out.println("Richiesta accettata");
		}
	}
}
