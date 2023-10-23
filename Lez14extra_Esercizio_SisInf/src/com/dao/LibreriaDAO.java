package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.connection.ConnectionManager;
import com.dto.LibroDTO;
import com.facade.LibreriaFacadeI;
import com.sql.SqlScript;
import com.vo.LibroVO;

public class LibreriaDAO implements LibreriaFacadeI {
	Connection con = null;
	@Override
	public int aggiungiLibro(LibroDTO libroDTO) throws ClassNotFoundException, SQLException {
		con = ConnectionManager.getConnection();
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlInsert, con);
		
		ps.setString(1, libroDTO.getTitolo());
		ps.setString(2, libroDTO.getAutore());
		ps.setInt(3, libroDTO.getPubblicazione());
		con=null;
		
		return ps.executeUpdate();
	}
	
	@Override
	public ArrayList<LibroVO> listaLibri() throws SQLException, ClassNotFoundException {
		con = ConnectionManager.getConnection();
		ArrayList<LibroVO> libri = new ArrayList<>();
		LibroVO libroVO = null;
		ResultSet rs = ConnectionManager.getResultSet(SqlScript.sqlReadAll, con);
		
		while(rs.next()) {
			libroVO = new LibroVO(
					rs.getInt("id"),
					rs.getString("titolo"),
					rs.getString("autore"),
					rs.getInt("pubblicazione"));
			libri.add(libroVO)
;		}
		con=null;
		
		return libri;
	}
	
	@Override
	public ArrayList<LibroVO> ricercaLibro(String find) throws SQLException, ClassNotFoundException {
		con = ConnectionManager.getConnection();
		ArrayList<LibroVO> libri = new ArrayList<>();
		LibroVO libroVO = null;
		
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlFindTitoloLibro, con);
		ps.setString(1, find);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			libroVO = new LibroVO(0,rs.getString("titolo"),null,0);
			libri.add(libroVO);
		}
		con=null;
		
		return libri;
	}
}
