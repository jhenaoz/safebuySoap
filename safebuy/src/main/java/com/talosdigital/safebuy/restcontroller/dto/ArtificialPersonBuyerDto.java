package com.talosdigital.safebuy.restcontroller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ArtificialPersonBuyerDto {
	
	private int id;
	
	private String name;
	
	private String nit;
	
	private int employees;
	
	private StoreDto storeDto;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
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

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}
}
