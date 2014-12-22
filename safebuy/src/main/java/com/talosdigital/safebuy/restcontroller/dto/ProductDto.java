package com.talosdigital.safebuy.restcontroller.dto;

import java.util.HashMap;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.talosdigital.safebuy.model.Category;

@JsonSerialize
public class ProductDto {

	private int id = -1;

	private String name;

	private Category category;
	
	private float price;
	
	private int stockQuantity;
	
	private StoreDto storeDto;
	
	private HashMap<String, String> properties;

	public int getId() {
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public StoreDto getStoreDto() {
		return storeDto;
	}

	public void setStoreDto(StoreDto storeDto) {
		this.storeDto = storeDto;
	}
	
	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
}
