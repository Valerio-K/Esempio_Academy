package com.main;

import com.docenti.*; //importo tutto il pacchetto tanto uso tutte le classi al suo interno

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Docente docente = new Docente();  //non posso istanziarla perché è un'interfaccia
		DocenteJava docenteJava = new DocenteJava();
		docenteJava.spiegaLinguaggio();  //con ctrl+mb2 accedo al metodo concreto quindi anche al corpo, non garantisco loose coupling
		docenteJava.spiegaFramework();
		docenteJava.spiegaArchitettura();
		docenteJava.spiegaSintassi();
		
		DocenteMicrosoft docenteMicrosoft = new DocenteMicrosoft();
		docenteMicrosoft.spiegaLinguaggio();
		docenteMicrosoft.spiegaFramework();
		docenteMicrosoft.spiegaArchitettura();		
		
		/*
		 * Posso istanziare una classe concreta tipizzando la reference come un'interfaccia (POLIMORFISMO)
		 *  l'oggetto istanziato è una classe concreta (legit) ma il tipo della reference è interfaccia
		 * Tale principio si applica per garantire la riservatezza dei metodi (se uso ctrl+mb2 sul metodo
		 *  mi porta al metodo astratto senza poter vedere il corpo), è il pattern loose coupling
		 */
		Docente docenteJava1 = new DocenteJava();
		docenteJava1.spiegaLinguaggio();  //posso usare questo metodo senza accederne al corpo (pattern LOOSE COUPLING)
		//docenteJava1.spiegaSintassi();  //non posso usare questo metodo perché è aggiunto dalla classe figlio
	}

}
