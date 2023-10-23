package com.message;

public interface Message {
	
	public static final String opInsert = "Inserimento avvenuto con SUCCESSO!";
	public static final String opUpdate = "Aggiornamento avvenuto con SUCCESSO!";
	public static final String opDelete = "Cancellazione avvenuta con SUCCESSO!";
	public static final String opRead = "Lettura avvenuta con SUCCESSO!";
	
	public static final String errInsert = "ERRORE: Inserimento NON RIUSCITO!";
	public static final String errUpdate = "ERRORE: Aggiornamento NON RIUSCITO!";
	public static final String errDelete = "ERRORE: Cancellazione NON RIUSCITA!";
	public static final String errRead = "ERRORE: Lettura NON RIUSCITA!";
}
