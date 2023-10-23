package com.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.IscrittiDTO;

public interface IscrittiDAO {

	int insertIscritti(Connection con, IscrittiDTO IscrittiDTO) throws ClassNotFoundException, SQLException;

	int updateIscritti(Connection con, int id, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException;
	
	int deleteIscritti(Connection con, int id) throws ClassNotFoundException, SQLException;
	
	ArrayList<Object> readIscritti(Connection con) throws SQLException;

}
