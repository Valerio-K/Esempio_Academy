package com.exception;

public class EtaException extends Exception {
	private static final long serialVersionUID = 4958261726010705182L;

	public EtaException(String message) {
		super(message);  //parola chiave che consente di richiamare il costruttore della classe padre per poi eseguire il figlio
	}
	
	//quello che faremo in un altra classe sarà:
	//throw new EtaException("Eta non Corretta, Exception");
	
	/*
	 * try {
	 * 
	 * }
	 * 
	 * catch (EtaException ex) {
	 * ex.printStackTrace();
	 * }
	 */
}
