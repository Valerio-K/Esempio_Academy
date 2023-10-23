package com.facade;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.LibroDTO;
import com.vo.LibroVO;

public interface LibreriaFacadeI {

	int aggiungiLibro(LibroDTO libroDTO) throws ClassNotFoundException, SQLException;

	ArrayList<LibroVO> listaLibri() throws SQLException, ClassNotFoundException;

	ArrayList<LibroVO> ricercaLibro(String find) throws SQLException, ClassNotFoundException;

}
