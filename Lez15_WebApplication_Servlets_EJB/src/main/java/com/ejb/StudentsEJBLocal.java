package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentsEJBLocal {

	String readStudents(HttpServletRequest req) throws SQLException, ClassNotFoundException;

}
