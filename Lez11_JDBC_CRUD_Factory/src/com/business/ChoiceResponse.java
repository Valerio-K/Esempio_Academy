package com.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.enumeration.Choice;
import com.singleton.DAOSingleton;

public class ChoiceResponse implements ChoiceResponseI{
	
	@Override
	public ArrayList<Object> choiceResponse(Choice choice) throws ClassNotFoundException, SQLException {
		
		ArrayList<Object> objects = null;
		switch (choice) {
			
		case CUSTOMER:
			objects = DAOSingleton.getCustomerDAO().findAllCustomers(DAOSingleton.getSingletonConnection());
			break;
			
		case PRODUCT:
			objects = DAOSingleton.getProductDAO().findAllProducts(DAOSingleton.getSingletonConnection());
			break;
		}
		return objects;
	}
}
