package com.sistemi.informativi;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * in questo caso la JVM alloca l'oggetto nell'heap già con il valore da noi assegnato
		 * in un'unica operaz computaz
		 */
		//1 operaz comput
		Person p1 = new Person("Giacomo","Pucci",27);
		
		Person p2 = new Person("Giacomo","Pucci",27);
		
		//= -> operat di assegnazione
		//== -> operat di eguaglianza
		if (p1==p2) {
			System.out.println("p1 e p2 sono uguali fra loro");
		}
		else {
			System.out.println("p1 e p2 sono diversi fra loro");
		}
		//oggetti uguali ma reference diverse perché puntano a due spazi di memoria diversi, ma con stessi valori (oggetti uguali
		
		/*
		 * Assegnazione di reference
		 * Stiamo assegnando la reference p1 alla reference p2
		 * Nella JVM le due reference puntano allo stesso spazio di memoria
		 */
		p1=p2;
		
		if (p1==p2) {
			System.out.println("Dopo assegnazione, p1 e p2 sono uguali fra loro");
		}
		else {
			System.out.println("Dopo assegnazione, p1 e p2 sono diversi fra loro");
		}
		
		//6 operaz comput
		System.out.println(p1.getFirstName()+" "+p1.getLastName()+", "+p1.getAge()+" anni");
		
		System.out.println(p1.toString()); //evito l'uso dei get e semplifico operaz computaz
	}

}
