package com.strategy;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Strategy {
	ArrayList<Object> findAllObject() throws ClassNotFoundException, SQLException;
}
