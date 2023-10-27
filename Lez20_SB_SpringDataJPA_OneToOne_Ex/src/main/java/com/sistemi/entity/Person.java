package com.sistemi.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 6104398134763766359L;
	
	@Id
	@Column(name="fiscal_code", length=16)
	private String fiscalCode;
	
	private String name;
	private int age;
	
	@OneToOne(mappedBy="person", cascade=CascadeType.ALL)
    private Bancomat bancomat;
	
	public String getFiscalCode() {
		return fiscalCode;
	}
	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	protected Person() {}
	
	public Person(String fiscalCode, String name, int age) {
		super();
		this.fiscalCode = fiscalCode;
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [fiscalCode=" + fiscalCode + ", name=" + name + ", age=" + age + "]";
	}
}
