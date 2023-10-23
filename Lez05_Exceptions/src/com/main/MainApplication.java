package com.main;

import com.business.GestioneEccezioni;
import com.exception.EtaException;

public class MainApplication {
	
	public static void main(String[] args) throws EtaException {
		
		/*
		 * Esempio di UNCHECKED EXCEPTION, dunque RunTimeException API (non serve try-catch, ma per provarlo)
		 */
//		Operazione operazione = new Operazione();
//		//se avessimo voluto controllarla:
//		try {
//			operazione.divisione(7, 0);
//		}
//		catch(Exception ex) {
//			ex.printStackTrace(); //questo modulo ci stampa l'eccezione (che avremmo visto comunque essendo unchecked)
//		}
		GestioneEccezioni gestioneEccezioni = new GestioneEccezioni();
		gestioneEccezioni.verificaEta(15);
		//viene stampato un messaggio di eccezione personalizzato da noi
	}
}
