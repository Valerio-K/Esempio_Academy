package com.aziende;

public class AziendaMeccanica extends Azienda {
	
	@Override
	public void produce() {
		System.out.println("produce pezzi meccanici");
	}
	
	@Override
	public void assume() {
		System.out.println("assume esperti meccanici");
	}
	
	//@Override
	//public void fattura() {
	//	System.out.println("fattura con IVA al 22%");
	//}
}
