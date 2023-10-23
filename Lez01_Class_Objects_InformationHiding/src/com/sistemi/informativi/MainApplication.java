package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p1 = new Person();
		
		//p1.firstName="Mario"; dà errore perché ho reso le var private
		
		//MODIFICA STATO OGGETTO
		/*
		 * Nel momento in cui viene invocato un metodo, la JVM alloca uno
		 * spazio fisico dentro lo stack (che comporta una operaz computaz)
		 * Dopo che termina l'esecuz del metodo, lo spazio fisico viene dealloc
		 * (comportando un'altra operaz computaz)
		 */
		p1.setFirstName("Giulio");
		p1.setLastName("Verdi");
		p1.setAge(29);
		//tale processo aumenta il numero di operaz computazionali, tuttavia è molto usato
		
		System.out.println(p1.getFirstName()+" "+p1.getLastName()+", "+p1.getAge()+" anni");
	}

}
