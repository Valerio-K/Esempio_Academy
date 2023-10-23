package com.message;

public interface Message {
	
	public static final String opInsert = "Inserimento avvenuto con SUCCESSO!\n";
	public static final String opUpdate = "Aggiornamento avvenuto con SUCCESSO!\n";
	public static final String opDelete = "Cancellazione avvenuta con SUCCESSO!\n";
	public static final String opRead = "Lettura avvenuta con SUCCESSO!\n";
	
	public static final String errInsert = "ERRORE: Inserimento NON RIUSCITO!";
	public static final String errUpdate = "ERRORE: Aggiornamento NON RIUSCITO!";
	public static final String errDelete = "ERRORE: Cancellazione NON RIUSCITA!";
	public static final String errRead = "ERRORE: Lettura NON RIUSCITA!";
	
	public static final String inputInsert = "Inserisci nome, cognome, data e luogo di nascita e indirizzo di residenza:";
	public static final String inputUpdateID = "Inserisci ID dell'iscritto da aggiornare:";
	public static final String inputUpdate = "Aggiorna nome, cognome, data e luogo di nascita e indirizzo di residenza:";
	public static final String inputDelete = "Inserisci ID dell'iscritto da eliminare:";
}