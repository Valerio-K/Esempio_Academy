package com.business;

import java.sql.SQLException;

import com.dto.IscrittiDTO;
import com.enumeration.Choice;
import com.singleton.Singleton;

public class ChoiceResponse implements ChoiceResponseI {
	
	@Override
	public void choiceResponse(Choice choice, int id, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException {
		switch (choice) {
		
		case INSERT:
			CRUDCheck.checkCRUD(choice, Singleton.getSingletonConnection(), 0, iscrittiDTO);
			break;
			
		case UPDATE:
			CRUDCheck.checkCRUD(choice, Singleton.getSingletonConnection(), id, iscrittiDTO);
			break;
			
		case DELETE:
			CRUDCheck.checkCRUD(choice, Singleton.getSingletonConnection(), id, null);
			break;
			
		case FINDALL:
			System.out.println("Lista iscritti:");
			CRUDCheck.checkCRUD(choice, Singleton.getSingletonConnection(), 0, null);
			break;
		case FINDSEARCH:
			
			break;
		}
	}
}
