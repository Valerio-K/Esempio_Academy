package com.business;

import java.sql.SQLException;

import com.dto.IscrittiDTO;
import com.enumeration.Choice;

public interface ChoiceResponseI {

	void choiceResponse(Choice choice, int id, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException;

}
