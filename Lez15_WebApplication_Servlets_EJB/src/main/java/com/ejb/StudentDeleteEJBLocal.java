package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentDeleteEJBLocal {

	public String deleteStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException;
}
