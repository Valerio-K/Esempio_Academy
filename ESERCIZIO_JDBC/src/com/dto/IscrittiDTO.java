package com.dto;

import java.io.Serializable;

import com.bean.BirthDate;

public class IscrittiDTO implements Serializable {

	private static final long serialVersionUID = 3648353733551128155L;
	
	private String firstName;
	private String lastName;
	private BirthDate birthDate;
	private String address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public BirthDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(BirthDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getAddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	
	protected IscrittiDTO() {}
	
	public IscrittiDTO(String firstName, String lastName, BirthDate birthDate, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
	}
}
