package com.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainApplication {
	
	/*
	 * Un'applicazione del genere, cambiando opportunamente driver,
	 * funzionerebbe anche per Oracle.
	 * Ad eccezione del .jar configurato, che cambia come il driver
	 * a seconda del tipo di database scelto.
	 */
	private static final String dbDriver="com.mysql.cj.jdbc.Driver";
	private static final String dbUrl="jdbc:mysql://localhost:3306/corso";
	private static final String dbUser="root";
	private static final String dbPass="";
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1.= Apertura Connessione
		
		// 1.1= indicazione del driver di connessione
		//invochiamo un metodo static sulla classe Class di JDBC
		Class.forName(dbDriver);
		
		// 1.2= indicazione di url, username, password
		Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		
		// 2.= CRUD
		
		// 2.1= INSERT
		
		//script SQL anonimo
		String sqlInsert = "INSERT into student(first_name,last_name,age) VALUES (?,?,?)";
		PreparedStatement psInsert = con.prepareStatement(sqlInsert);
		
		//concretizzazione dei placeholder
		psInsert.setString(1, "Valerio");
		psInsert.setString(2, "Cappa");
		psInsert.setInt(3, 25);
		//sto eseguendo in SQL
		 //INSERT into student(first_name,last_name,age) VALUES ('Valerio','Capparella',25)
		
		//Sincronizzazione dell'operazione implementata precedentemente
		psInsert.executeUpdate();
		
		// 2.2= UPDATE
		String sqlUpdate="UPDATE student SET age=? WHERE id=?";
		PreparedStatement psUpdate = con.prepareStatement(sqlUpdate);
		
		psUpdate.setInt(1, 26);
		psUpdate.setInt(2, 2);
		
		psUpdate.executeUpdate();
		
		//2.3= DELETE
		String sqlDelete="DELETE from student WHERE id=?";
		PreparedStatement psDelete = con.prepareStatement(sqlDelete);
		
		psDelete.setInt(1, 5);
		
		psDelete.executeUpdate();
		
		//2.4= READ
		Statement stmt = con.createStatement(); //importarla da java.sql
		
		//in questo caso usando Statement posso evitare i placeholder
		String sqlRead="SELECT * from student";
		ResultSet rs = stmt.executeQuery(sqlRead);
		
		while(rs.next()) {
			System.out.println(rs.getInt("id") + ": "
					+ rs.getString("first_name") + " "
					+ rs.getString("last_name") + ", età="
					+ rs.getInt("age"));
		}
		
		con.close(); //superfluo dato che finisce il main
	}
}
