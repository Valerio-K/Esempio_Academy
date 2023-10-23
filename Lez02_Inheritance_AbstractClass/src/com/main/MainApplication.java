package com.main;

import com.aziende.*;  //importa il pacchetto intero
//import com.aziende.Azienda;  //importo una classe astratta che non uso nel main
//import com.aziende.AziendaMeccanica;  //importo una classe concreta che uso (ma la importo già con il pacchetto sopra)
//import com.aziende.AziendaInformatica;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Azienda azienda = new Azienda(); non posso istanziarla perché è abstract
		AziendaMeccanica aziendaMeccanica = new AziendaMeccanica();
		aziendaMeccanica.assume();
		aziendaMeccanica.produce();
		aziendaMeccanica.fattura();
		
		AziendaInformatica aziendaInformatica = new AziendaInformatica();
		aziendaInformatica.assume();
		aziendaInformatica.produce();
		aziendaInformatica.fattura();		
	}

}
