package com.talosdigital.safebuy.restcontroller.dto;

public abstract class BuyerDto {

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
}
