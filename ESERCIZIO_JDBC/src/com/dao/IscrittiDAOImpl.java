package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.BirthDate;
import com.connection.ConnectionManager;
import com.dto.IscrittiDTO;
import com.sql.SqlScript;
import com.vo.IscrittiVO;

public class IscrittiDAOImpl implements IscrittiDAO {
	
	@Override
	public int insertIscritti(Connection con, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlInsert, con);
		
		ps.setString(1, iscrittiDTO.getFirstName());
		ps.setString(2, iscrittiDTO.getLastName());
		ps.setInt(3, iscrittiDTO.getBirthDate().getBirthDay());
		ps.setInt(4, iscrittiDTO.getBirthDate().getBirthMonth());
		ps.setInt(5, iscrittiDTO.getBirthDate().getBirthYear());
		ps.setString(6, iscrittiDTO.getBirthDate().getBirthPlace());
		ps.setString(7, iscrittiDTO.getAddress());
		
		return ps.executeUpdate();
	}
	
	@Override
	public int updateIscritti(Connection con, int id, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlUpdate, con);
		
		ps.setString(1, iscrittiDTO.getFirstName());
		ps.setString(2, iscrittiDTO.getLastName());
		ps.setInt(3, iscrittiDTO.getBirthDate().getBirthDay());
		ps.setInt(4, iscrittiDTO.getBirthDate().getBirthMonth());
		ps.setInt(5, iscrittiDTO.getBirthDate().getBirthYear());
		ps.setString(6, iscrittiDTO.getBirthDate().getBirthPlace());
		ps.setString(7, iscrittiDTO.getAddress());
		ps.setInt(8, id);
		
		return ps.executeUpdate();
	}
	
	@Override
	public int deleteIscritti(Connection con, int id) throws ClassNotFoundException, SQLException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlDelete, con);
		ps.setInt(1, id);
		
		return ps.executeUpdate();
	}
	
	@Override
	public ArrayList<Object> readIscritti(Connection con) throws SQLException {
		ArrayList<Object> iscritti = new ArrayList<>();
		IscrittiVO iscrittiVO = null;
		ResultSet rs = ConnectionManager.getResultSet(SqlScript.sqlReadAll, con);
		
		while(rs.next()) {
			iscrittiVO = new IscrittiVO(rs.getInt("id"),
					rs.getString("first_name"),rs.getString("last_name"),
					new BirthDate(rs.getInt("birth_day"),rs.getInt("birth_month"),rs.getInt("birth_year"),rs.getString("birth_place")),rs.getString("address"));
			iscritti.add(iscrittiVO);
		} 
		return iscritti;
	}
}
