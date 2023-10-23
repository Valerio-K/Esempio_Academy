package com.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.enumeration.Choice;
import com.singleton.DAOSingleton;

public class ChoiceResponse implements ChoiceResponseI{
	
	@Override
	public ArrayList<Object> choiceResponse(Choice choice, String find) throws ClassNotFoundException, SQLException {
		
		ArrayList<Object> objects = null;
		switch (choice) {
			
		case PHONEPRODUCT:
			objects = DAOSingleton.getProductDAO().findPhoneProducts(DAOSingleton.getSingletonConnection(), find);
			break;
		
		case NAMEPRODUCT:
			objects = DAOSingleton.getProductDAO().findNameProducts(DAOSingleton.getSingletonConnection());
			break;
		}
		return objects;
	}
}
