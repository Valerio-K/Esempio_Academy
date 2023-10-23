package com.main;

public class MainApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Trattando String come literal (assegnaz diretta), in ogni caso le reference referenziano locaz di memoria
		 * (non Oggetti) che vengono inserite in un'area speciale dell'heap, detta String Constant Pool.
		 * Ciò consente di consmare meno memoria rispetto all'utilizzo di String come Classic Object (con uso di costruttore)
		 * 
		 * Se due reference (literal) vengono assegnate allo stesso valore, in ogni caso vengono create
		 * due locaz di memoria diff
		 * 
		 */
		String s1 = "hello";
		String s2 = "hello";
		
		System.out.println(s1);
		System.out.println(s2);
		/*
		 * Nel caso in cui viene applicato alle String (literal) un metodo che coinvolge il valore di due locaz
		 * di memoria differenti dentro SCP viene creata una nuova locazione di memoria con un nuovo valore.
		 * Se String è usato come literal, è IMMUTABLE
		 */
		s1.concat(s2); //non cambia la locazione di s1
		String s3 = s1.concat(s2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

}
