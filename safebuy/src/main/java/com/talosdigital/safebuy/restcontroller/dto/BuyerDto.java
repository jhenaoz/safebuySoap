package com.talosdigital.safebuy.restcontroller.dto;

import com.talosdigital.safebuy.model.Store;

public class BuyerDto {

	private int id;
	private String name;
	private String lastName;
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
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
