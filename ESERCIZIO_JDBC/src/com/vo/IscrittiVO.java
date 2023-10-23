package com.vo;

import java.io.Serializable;

import com.bean.BirthDate;

public class IscrittiVO implements Serializable {
	
	private static final long serialVersionUID = 9149165794304073110L;
	
	private int id;
	private String firstName;
	private String lastName;
	private BirthDate birthDate;
	private String address;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	
	protected IscrittiVO() {}
	
	public IscrittiVO(int id, String firstName, String lastName, BirthDate birthDate, String address) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "[" + id + ": " + firstName + " " + lastName + " " + birthDate
				+ ", residente a " + address + "]";
	}
}
