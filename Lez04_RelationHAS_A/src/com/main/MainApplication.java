package com.main;

import com.bean.*;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Indirizzo sedeLegale = new Indirizzo("Mario Bianchini",60,"00158","Roma","Italia");
		Azienda azienda = new Azienda("1034B","Company",sedeLegale);
		
		System.out.println(azienda.toString());
	}

}