package com.talosdigital.safebuy.restcontroller.dto;

public class NaturalPersonBuyerDto extends BuyerDto {
	
	private String lastName;
	private int age;
	private int documentNumber;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
