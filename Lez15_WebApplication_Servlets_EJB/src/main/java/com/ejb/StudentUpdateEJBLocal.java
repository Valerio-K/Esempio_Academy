package com.ejb;

import java.sql.SQLException;

import javax.ejb.Local;
import javax.servlet.http.HttpServletRequest;

@Local
public interface StudentUpdateEJBLocal {

	public String updateStudent(HttpServletRequest request) throws ClassNotFoundException, SQLException;

}
