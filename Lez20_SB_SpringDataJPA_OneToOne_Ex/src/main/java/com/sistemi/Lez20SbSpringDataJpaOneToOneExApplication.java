package com.sistemi;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistemi.entity.Bancomat;
import com.sistemi.entity.Person;
import com.sistemi.service.PersonBancomatServiceI;

@SpringBootApplication
public class Lez20SbSpringDataJpaOneToOneExApplication implements CommandLineRunner {
	
	@Autowired
	PersonBancomatServiceI serv;
	
	public static void main(String[] args) {
		SpringApplication.run(Lez20SbSpringDataJpaOneToOneExApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person person1 = new Person("AAA111","Mario",30);
		Person person2 = new Person("BBB222","Luigi",22);
		Person person3 = new Person("CCC333","Sandro",44);
		Person person4 = new Person("AAA111","Franco",15);
		
		serv.insertUpdatePerson(person1);
		serv.insertUpdatePerson(person2);
		serv.insertUpdatePerson(person3);
		serv.insertUpdatePerson(person4); //Update
		
		Bancomat bancomat1 = new Bancomat("111","Unicredit",Date.valueOf("2030-07-23"), person4);
		Bancomat bancomat2 = new Bancomat("222","Poste",Date.valueOf("2027-01-01"), person2);
		Bancomat bancomat3 = new Bancomat("333","MontePaschiSiena",Date.valueOf("2024-04-11"), person3);
		
		serv.insertUpdateBancomat(bancomat1);
		serv.insertUpdateBancomat(bancomat2);
		serv.insertUpdateBancomat(bancomat3);
		
//		serv.findAllPerson();
//		serv.findAllBancomat();
		
		serv.findBancomatByPerson(new Person("CCC333","",0));
		serv.findPersonByBancomat(bancomat2);
		
		serv.deletePerson("BBB222");
		serv.deleteBancomat("111");
	}

}
