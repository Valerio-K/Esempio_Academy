package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentRegistrationEJBLocal {

	public String addStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException;

}
