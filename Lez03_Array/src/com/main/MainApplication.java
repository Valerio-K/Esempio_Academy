package com.main;

import com.bean.Academy;
import com.bean.Corso;

public class MainApplication {

	public static void main(String[] args) {
		/*
		 * PRIMA modalità di inizializzazione di array
		 */
		int arrayInt[] = new int [3]; //le parentesi quadre specificano che si tratta di array, e non di singolo valore
		//al momento arrayInt è riempito da tre 0
		
		arrayInt[0]=23;
		arrayInt[1]=5;
		arrayInt[2]=23;
		
		System.out.println(arrayInt[1]);
		
		for (int i=0; i<arrayInt.length; i++) {
			System.out.println(arrayInt[i]);
		}
		
		/*
		 * SECONDA modalità di inizializzazione di array
		 */
		int arrayNew[] = {55,2,52};
		
		//la var i ha scope locale, quindi tra for divers non si infastidiscono
		for (int i=0; i<arrayNew.length; i++) {
			System.out.println("Contenuto arrayInt[" + i + "]: " + arrayNew[i]);
		}
		
		
		/*
		 * Array di reference ad oggetti
		 * la reference corsi nello stack punta ad un array nel'heap riempito da reference ad oggetti che non
		 *  puntano a niente
		 */
		Corso corsi[] = new Corso[3];
		corsi[0] = new Corso("3a","MAT","Roma"); //qui creo l'oggetto (nell'heap) puntato dalla reference in posizione 0 dell'array (sempre nell'heap)
		corsi[1] = new Corso("3b","FIS","Milano");
		corsi[2] = new Corso("3c","INF","Napoli");
		
		for (Corso corso : corsi) {
			System.out.println(corso.toString());
		}
		
		/*
		 * Possiamo sfruttare il polimorfismo per rispettare l'omogeneità dell'array
		 * Ogni classe è infatti figlia di Object
		 */
		
		Object arrayCA[] = new Object[2];
		arrayCA[0]=new Corso("2a","JAVA SE","Roma");
		arrayCA[1]=new Academy("2b","JAVA EE","2000€","Roma");
		
		for (Object object : arrayCA) {
			System.out.println(object.toString());
		}
	}

}
