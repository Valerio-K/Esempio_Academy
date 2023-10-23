package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.bean.Azienda;

public class MainApplication {
	
	public static void main(String[] args) {
		
		/*
		 * Inizializzazione di un ArrayList le cui locaz di memoria contengono reference di tipo Azienda
		 * Uso la forma GENERICS <> per tipizzare la struttura
		 */
		ArrayList <Azienda> aziende = new ArrayList<>(); //usare <> da entrambi i lati, a dx non serve ri-specificare
		//sto notificando la JVM di allocare spazio per un ArrayList ma senza specificare quante allocazioni
		
		//istanzio gli oggetti da inserire nell'ArrayList, poi uso il metodo add
		Azienda azienda1 = new Azienda("1028G","Company1","Roma",34);
		Azienda azienda2 = new Azienda("1028H","Company2","Milano",42);
		
		aziende.add(azienda1);
		aziende.add(azienda2);
		
		//uso il for each per stampare i valori nell'ArrayList
		for (Azienda azienda : aziende) {
			System.out.println(azienda.toString());
		}
		
		/*
		 * La JVM, consapevole che non possono essere inseriti dei tipi primitivi in un ArrayList,
		 * effettua l'AUTOBOXING ovvero la conversione implicita ad un Oggetto Wrapper di tipi primitivi
		 */
		ArrayList<Integer> numeri = new ArrayList<>();
		numeri.add(8);
		numeri.add(7);
		numeri.add(2);
		
		for (Integer numero : numeri) {
			System.out.println("ArrayList numeri: " + numero.toString());
		}
		
		ArrayList<String> giorni = new ArrayList<>();
		giorni.add("lunedì");
		giorni.add("martedì");
		giorni.add("mercoledì");
		giorni.add("giovedì");
		giorni.add("venerdì");
		giorni.add("sabato");
		giorni.add("domenica");
		giorni.add("lunedì");
		
		//for each costrutto
		for (Object oggetto : giorni) {
			System.out.println("ArrayList giorni (for): " + oggetto.toString());
		}
		
		//metodo forEach, disponibile per ogni Collection (approccia il paradigma funzionale, da Java8)
		giorni.forEach(giorno -> System.out.println("ArrayList giorni.forEach: " + giorno));
		
		
		/*
		 * HashSet: allo stesso modo dell'ArrayList ma non ammette duplicati e non è indicizzato e ordinato
		 * essendo non ordinato, nell'heap viene allocata in maniera casuale i valori aggiunti
		 * quando viene stampato un HashSet, i valori all'interno escono casuali, ma sempre allo stesso ordine
		 */
		HashSet<String> giorniSet = new HashSet<>();
		giorniSet.add("lunedì");
		giorniSet.add("martedì");
		giorniSet.add("mercoledì");
		giorniSet.add("giovedì");
		giorniSet.add("venerdì");
		giorniSet.add("sabato");
		giorniSet.add("domenica");
		giorniSet.add("lunedì");
		
		giorniSet.forEach(giorno -> System.out.println("HashSet giorniSet: " + giorno));
		
		/*
		 * HashMap: utilizza un generics <> differente, a doppio parametro (key, value)
		 * inoltre usa il metodo put(key, value) per inserire gli elementi
		 * Posso inserire due valori con stessa chiave ma facendolo sovrascrivo il valore già presente con l'ultimo
		 */
		HashMap<String,Azienda> aziendeMap = new HashMap<>();
		//Azienda aziendaMap1 = new Azienda("2028G","Company1","Roma",23);
		//Azienda aziendaMap2 = new Azienda("2028H","Company2","Milano",51);
		
		aziendeMap.put("Key1", new Azienda("2028G","Company1","Roma",23));
		aziendeMap.put("Key2", new Azienda("2028H","Company2","Milano",51));
		
		aziendeMap.forEach((key, value) -> 
		System.out.println("HashMap aziendeMap.forEach: Chiave=" + key + ", Valore=" + value));
		System.out.println(aziendeMap.get("Key1")); //stampa il contenuto dell'oggetto associato alla key ricercata in aziendeMap
		
		
		/*
		 * Esempio di conversione da struttura dati statica Array a 
		 * struttura dati dinamica ArrayList
		 */
		Integer arrayInt[] = new Integer[2];
		arrayInt[0]=3;
		arrayInt[1]=5;
		
		List<Integer> integerList = Arrays.asList(arrayInt);
		integerList.forEach(i -> System.out.println("Array to ArrayList: " + i));
		
	}
}
