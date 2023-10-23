package com.business;

import java.util.Scanner;

public class Input {
	public static String insertInput() {
		try (Scanner myObj = new Scanner(System.in)) {
			System.out.println("Inserisci filtro: ");
			String input = myObj.nextLine();
			return input;
		}
	}
}
