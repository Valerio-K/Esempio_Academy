package com.sistemi.informativi;

public class Person {

	/*
	 * Dichiarare una var private all'interno di una classe
	 * vuol dire restringere la visibilità di tale var alla classe
	 * stessa in cui essa vive.
	 */
	private String firstName;
	private String lastName;
	private int age;
	
	// setter&getter methods
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
