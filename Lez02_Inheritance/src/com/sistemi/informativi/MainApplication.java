package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Persona persona = new Persona(); //che succede se scrivo Persona p1 = new Studente();? è polimorfismo
		persona.mangia();
		persona.dorme();
		
		Studente studente = new Studente();
		//invocazione metodi ereditati + aggiunti
		studente.mangia();
		studente.dorme(); //overridato
		studente.studia(); //aggiunto
		
		Dipendente dipendente = new Dipendente();
		dipendente.mangia(); //ereditato
		dipendente.dorme(); //overridato
		dipendente.lavora(); //aggiunto
		//Studente e Dipendente non sono legati tra loro
		
		StudenteLavoratore studentelavoratore = new StudenteLavoratore();
		studentelavoratore.mangia(); //ereditato in comune anche con il nonno
		studentelavoratore.dorme(); //ereditato l'override del padre
		studentelavoratore.studia(); //ereditato dal padre
		studentelavoratore.studialavora(); //aggiunto
	}

}
