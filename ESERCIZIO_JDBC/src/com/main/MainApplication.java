package com.main;

import java.sql.SQLException;

import com.business.ChoiceResponse;
import com.business.ChoiceResponseI;
import com.business.Input;
import com.enumeration.Choice;
import com.message.Message;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ChoiceResponseI response = new ChoiceResponse();
		
		//Inserimento
		response.choiceResponse(Choice.INSERT, 0, Input.InputDTO(Message.inputInsert));
		
		//Aggiornamento dopo lettura
		response.choiceResponse(Choice.FINDALL, 0, null);
		response.choiceResponse(Choice.UPDATE, Input.InputID(Message.inputUpdateID), Input.InputDTO(Message.inputUpdate));
		
		//Cancellazione dopo lettura
		response.choiceResponse(Choice.FINDALL, 0, null);
		response.choiceResponse(Choice.DELETE, Input.InputID(Message.inputDelete), null);
		response.choiceResponse(Choice.FINDALL, 0, null);
		
		//Ricerca dopo lettura
//		response.choiceResponse(Choice.FINDALL, 0, null);
//		response.choiceResponse(Choice.FINDSEARCH, 0, null);
		
	}
}
