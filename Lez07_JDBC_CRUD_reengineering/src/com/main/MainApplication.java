package com.main;

import java.sql.Connection;
import java.sql.SQLException;

import com.business.CrudCheck;
import com.connection.ConnectionManager;
import com.dto.StudentDTO;
import com.sql.SqlScript;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = ConnectionManager.getConnection();		
		
		//1.= Richiesta di due INSERT sulla tabella student
		StudentDTO studentDTO1 = new StudentDTO("Peter","Parker",24);
		StudentDTO studentDTO2 = new StudentDTO("Tony","Stark",47);
		
		CrudCheck.checkCrud(SqlScript.sqlInsert, con, studentDTO1, 0);
		CrudCheck.checkCrud(SqlScript.sqlInsert, con, studentDTO2, 0);
		//FINE INSERT
		
		//1.= Richiesta di UPDATE sulla tabella student
		StudentDTO studentDTO3 = new StudentDTO("Mario","Rossi",30);
		
		CrudCheck.checkCrud(SqlScript.sqlUpdate, con, studentDTO3, 1);
		//FINE UPDATE
		
		//3.= Richiesta di DELETE sulla tabella student
		CrudCheck.checkCrud(SqlScript.sqlDelete, con, null, 3);
		//FINE DELETE
		
		//4.= Richiesta di READ
		CrudCheck.checkRead(SqlScript.sqlRead, con);
		//FINE READ
		
		ConnectionManager.closeConnection(con); //superfluo a fine main
	}
}
