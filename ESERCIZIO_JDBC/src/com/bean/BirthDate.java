package com.bean;

public class BirthDate {
	
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	private String birthPlace;
	
	public int getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(int birthDay) {
		this.birthDay = birthDay;
	}
	public int getBirthMonth() {
		return birthMonth;
	}
	public void setBirthMonth(int birthMonth) {
		this.birthMonth = birthMonth;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	
	public BirthDate(int birthDay, int birthMonth, int birthYear, String birthPlace) {
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.birthPlace = birthPlace;
	}
	@Override
	public String toString() {
		return "nato/a il " + birthDay + "/" + birthMonth + "/" + birthYear
				+ " a " + birthPlace;
	}
}
