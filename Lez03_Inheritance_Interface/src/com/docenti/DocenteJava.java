package com.docenti;

public class DocenteJava implements Docente {

	@Override
	public void spiegaLinguaggio() {
		// TODO Auto-generated method stub
		System.out.println("Spiega Java");
	}

	@Override
	public void spiegaFramework() {
		// TODO Auto-generated method stub
		System.out.println("spiega Spring");
	}

	@Override
	public void spiegaArchitettura() {
		// TODO Auto-generated method stub
		System.out.println("spiega architettura Java Entrerprise");
	}
	
	public void spiegaSintassi() {
		System.out.println("spiega sintassi Java");
	}
}
