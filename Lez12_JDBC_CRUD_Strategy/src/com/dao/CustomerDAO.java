package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDAO {

	ArrayList<Object> findAllCustomers(Connection con) throws SQLException;

}
