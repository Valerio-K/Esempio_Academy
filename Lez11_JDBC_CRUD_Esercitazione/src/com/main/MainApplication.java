package com.main;

import java.sql.SQLException;

import com.business.ChoiceResponseI;
import com.business.Input;
import com.enumeration.Choice;
import com.business.ChoiceResponse;

public class MainApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ChoiceResponseI response = new ChoiceResponse();
		System.out.print("PRODUCT NAMES:\n");
		response.choiceResponse(Choice.NAMEPRODUCT, null).forEach(cursore -> System.out.println(cursore));
		System.out.print("\n");
	    
		String input = Input.insertInput();
		
		System.out.print("\n");
		System.out.print("PRODUCT "+ input +":\n");
		response.choiceResponse(Choice.PHONEPRODUCT, "%"+ input +"%").forEach(cursore -> System.out.println(cursore));
	}
}