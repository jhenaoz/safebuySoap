package com.talosdigital.safebuy.restcontroller.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PurchaseDto {
	
	private int id;
	
	private StoreDto store;
	
	private ArrayList<ProductDto> products;
	
	private BuyerDto buyer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StoreDto getStore() {
		return store;
	}

	public void setStore(StoreDto store) {
		this.store = store;
	}

	public ArrayList<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<ProductDto> products) {
		this.products = products;
	}
	
	public void addProduct(ProductDto product){
		products.add(product);
	}

	public BuyerDto getBuyer() {
		return buyer;
	}

	public void setBuyer(BuyerDto buyer) {
		this.buyer = buyer;
	}
	
	
}
