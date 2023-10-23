package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

import com.singleton.DAOSingleton;

public class CustomerStrategy implements Strategy {

	@Override
	public ArrayList<Object> findAllObject() throws ClassNotFoundException, SQLException {
		return DAOSingleton.getCustomerDAO().findAllCustomers(DAOSingleton.getSingletonConnection());
	}

}