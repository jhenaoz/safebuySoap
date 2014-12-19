package com.talosdigital.safebuy.restcontroller.dto;

public class NaturalPersonBuyerDto {
	
	private String lastName;
	private int age;
	private int documentNumber;
	private int id;
	private String name;
	private StoreDto storeDto;
	
	public StoreDto getStoreDto() {
		return storeDto;
	}
	
	public void setStoreDto(StoreDto storeDto) {
		this.storeDto = storeDto;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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
