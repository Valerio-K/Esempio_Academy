package com.business;

import java.sql.SQLException;
import java.util.ArrayList;

import com.enumeration.Choice;

public interface ChoiceResponseI {

	ArrayList<Object> choiceResponse(Choice choice, String find) throws ClassNotFoundException, SQLException;

}
