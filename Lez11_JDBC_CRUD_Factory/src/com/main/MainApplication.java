package com.main;

import java.sql.SQLException;

import com.business.ChoiceResponse;
import com.business.ChoiceResponseI;
import com.enumeration.Choice;

public class MainApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		ChoiceResponseI response = new ChoiceResponse();
		response.choiceResponse(Choice.CUSTOMER).forEach(cursore -> System.out.println(cursore));
		response.choiceResponse(Choice.PRODUCT).forEach(cursore -> System.out.println(cursore));
	}
}