package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Generazione di un Oggetto a partire dalla Classe Person
		 */
		Person p1 = new Person(); //tramite costruttore
		p1.firstName="Mario";
		p1.lastName="Rossi";
		p1.age=23;
		
		System.out.println(p1.firstName+" "+p1.lastName+", "+p1.age+" anni");
		
		/*
		 * ISTRUZIONI PER IL GARBAGE COLLECTOR (GC):
		 * Il GC capisce che l'Oggetto referenziato da p1
		 * è 'eligible for destruction'
		 */
		p1=null;
		System.gc(); //forzo il GC ad eliminare lo spazio di memoria precedente
			//ormai il GC è implementato in 4 algoritmi e non serve più forzare il null

		Person p2 = new Person(); //alloca un altro spazio di memoria, referenziato da p2
		p2.firstName="Drago";
	}	//in questo punto viene deallocato lo spazio di memoria del metodo nello stack 

}
