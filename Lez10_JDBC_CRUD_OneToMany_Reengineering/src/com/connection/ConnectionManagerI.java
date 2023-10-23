package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ConnectionManagerI {
	public Connection getConnection() throws ClassNotFoundException, SQLException;
	
	//Inizializz di un oggetto PreparedSatement e restituz dello stesso
	public PreparedStatement getPreparedStatement(String sql, Connection con) throws ClassNotFoundException, SQLException;
	
	//Inizializz di un ResultSet già contenente la Query
	public ResultSet getResultSet(String sql, Connection con) throws SQLException;
	
	//Chiusura della connessione
	public void closeConnection(Connection con) throws SQLException;
}
