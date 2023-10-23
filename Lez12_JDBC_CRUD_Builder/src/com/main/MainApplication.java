package com.main;

import com.dto.AcademyDTO;

import java.sql.SQLException;

import com.dao.*;

public class MainApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		AcademyDTO academyDTO = new AcademyDTO.AcademyDTOBuilder("1028B", "Milano").build();
		AcademyDAO academyDAO = new AcademyDAOImpl();
		academyDAO.addAcademy(academyDTO);
	}

}
