package com.business;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.IscrittiDTO;
import com.enumeration.Choice;
import com.message.Message;
import com.singleton.Singleton;

public class CRUDCheck {
	
	public static void checkCRUD(Choice choice, Connection con, int id, IscrittiDTO iscrittiDTO) throws ClassNotFoundException, SQLException {
		
		switch(choice) {
		
		case INSERT:
			if(Singleton.getIscrittiDAO().insertIscritti(con, iscrittiDTO)>0) {
				System.out.println(Message.opInsert);
			}
			else {
				System.out.println(Message.errInsert);
			}
			break;
			
		case UPDATE:
			if(Singleton.getIscrittiDAO().updateIscritti(con, id, iscrittiDTO)>0) {
				System.out.println(Message.opUpdate);
			}
			else {
				System.out.println(Message.errUpdate);
			}
			break;
			
		case DELETE:
			if(Singleton.getIscrittiDAO().deleteIscritti(con, id)>0) {
				System.out.println(Message.opDelete);
			}
			else {
				System.out.println(Message.errDelete);
			}
			break;
			
		case FINDALL:
			ArrayList<Object> iscritti = Singleton.getIscrittiDAO().readIscritti(con);
			
			if (iscritti != null && !iscritti.isEmpty()) {
				iscritti.forEach(iscritto -> System.out.println(iscritto));
//				System.out.println(Message.opRead);
			}
			else {
				System.out.println(Message.errRead);
			}
			break;
		case FINDSEARCH:
			
			break;
		}
	}
}
