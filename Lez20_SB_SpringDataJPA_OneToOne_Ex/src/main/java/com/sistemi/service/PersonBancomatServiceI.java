package com.sistemi.service;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;

public interface PersonBancomatServiceI {
	
	public void insertUpdatePerson(Person person);
	
	public void deletePerson(String fiscalCode);
	
	public void insertUpdateBancomat(Bancomat bancomat);
	
	public void deleteBancomat(String codeNumber);
	
	public void findAllPerson();
	
	public void findAllBancomat();

	void findPersonByBancomat(Bancomat bancomat);

	void findBancomatByPerson(Person person);
}
