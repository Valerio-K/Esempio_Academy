package com.main;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApplication {
	
	public static void main(String[] args) {
		/* Inizializz di uno Stream from scratch */
		
		Stream<String> colori = Stream.of("Giallo","Blu","Rosso","Verde","Rosso");
		//colori.forEach(colore -> System.out.println("Stream colori: " + colore));
		
		Stream<String> coloriUnivoci = colori.distinct().sorted(); //toglie i duplicati
		//coloriUnivoci.forEach(colore -> System.out.println("Stream coloriUnivoci: " + colore));
		
		Stream<String> coloreGiallo = coloriUnivoci.filter(colore -> colore.equals("Giallo"));
		coloreGiallo.forEach(colore -> System.out.println("Stream coloreGiallo: " + colore));
		
		/* Inizializz di uno Stream di Integer from scratch */
		Stream<Integer> numeri = Stream.of(9,8,4,6);
		Stream<Integer> numeriDoppi = numeri.map(numero -> (numero*2));
		numeriDoppi.forEach(numero -> System.out.println("Stream numeriDoppi: " + numero));
		
		/* Conversione in Stream */
		ArrayList<String> corsi = new ArrayList<>();
		corsi.add("Java");
		corsi.add("Spring");
		Stream<String> corsiStream = corsi.stream();
		corsiStream.forEach(corso -> System.out.println("Stream ArrayList: " + corso));
		
		Integer arrayInteger [] = {2,14};
		Stream<Integer> StreamInteger = Stream.of(arrayInteger);
		StreamInteger.forEach(i -> System.out.println("Stream array: " + i));
		
		IntStream rangeStream = IntStream.range(1, 5);
		rangeStream.forEach(i -> System.out.println("Stream IntStream: " + i));
		
		
	}
	
}