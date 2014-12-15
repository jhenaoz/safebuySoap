package com.talosdigital.safebuy.restcontroller.dto;

import com.talosdigital.safebuy.model.Category;

public class ProductDto {

	private int nit;

	private String name;

	private Category category;
	
	private float price;
	
	private int stockQuantity;

	public int getNit() {
		return nit;
	}
	
	public void setNit(int nit){
		this.nit = nit;
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
}
