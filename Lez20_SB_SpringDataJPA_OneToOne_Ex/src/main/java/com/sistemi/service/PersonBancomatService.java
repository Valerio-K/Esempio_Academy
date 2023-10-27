package com.sistemi.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;
import com.sistemi.repository.BancomatRepository;
import com.sistemi.repository.PersonRepository;

@Service
public class PersonBancomatService implements PersonBancomatServiceI {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${message.save.success}")
	private String saveSuccess;
	@Value("${message.save.fail}")
	private String saveFail;
	@Value("${message.delete.success}")
	private String deleteSuccess;
	@Value("${message.delete.fail}")
	private String deleteFail;
	@Value("${message.read.fail}")
	private String readFail;
	
	@Autowired
	PersonRepository pRepo;
	@Autowired
	BancomatRepository bRepo;
	
	@Override
	public void insertUpdatePerson(Person person) {
		if (person != null && pRepo.save(person).getFiscalCode() == person.getFiscalCode()) {
			log.info(saveSuccess);
		} else {
			log.info(saveFail);
		}
	}

	@Override
	public void deletePerson(String fiscalCode) {
		if(pRepo.existsById(fiscalCode)) {
			pRepo.deleteById(fiscalCode);
			log.info(deleteSuccess);
		} else {
			log.info(deleteFail);
		}
	}

	@Override
	public void insertUpdateBancomat(Bancomat bancomat) {
		if (bancomat != null && bRepo.save(bancomat).getCodeNumber() == bancomat.getCodeNumber()) {
			log.info(saveSuccess);
		} else {
			log.info(saveFail);
		}
		
	}

	@Override
	public void deleteBancomat(String codeNumber) {
		if(bRepo.existsById(codeNumber)) {
			bRepo.deleteBancomat(codeNumber);
//			Bancomat bancomat = bRepo.findById(codeNumber).get();
//			bancomat.setPerson(null);
//			bRepo.save(bancomat);
//			bRepo.deleteById(codeNumber);
			log.info(deleteSuccess);
		} else {
			log.info(deleteFail);
		}
	}

	@Override
	public void findAllPerson() {
		List<Person> people = pRepo.findAll();
		if(!people.isEmpty()) {
			people.forEach(person->log.info(person.toString()));
		} else {
			log.info(readFail);
		}
	}

	@Override
	public void findAllBancomat() {
		List<Bancomat> bancomats = bRepo.findAll();
		if(!bancomats.isEmpty()) {
			bancomats.forEach(bancomat->log.info(bancomat.toString()));
		} else {
			log.info(readFail);
		}
	}

	@Override
	public void findPersonByBancomat(Bancomat bancomat) {
		Person person = pRepo.findByBancomat(bancomat);
		if(person != null) {
			log.info(person.toString());
		} else {
			log.info(readFail);
		}
	}

	@Override
	public void findBancomatByPerson(Person person) {
		Bancomat bancomat = bRepo.findByPerson(person);
		if(bancomat != null) {
			log.info(bancomat.toString());
		} else {
			log.info(readFail);
		}
	}
}
