package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductDAO {

	ArrayList<Object> findPhoneProducts(Connection con, String find) throws SQLException, ClassNotFoundException;

	ArrayList<Object> findNameProducts(Connection con) throws SQLException;

}
