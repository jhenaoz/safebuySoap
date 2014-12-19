package com.talosdigital.safebuy.restcontroller.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class PurchaseDto {
	
	private int id;
	
	private StoreDto store;
	
	private List<ProductDto> products;
	
	private NaturalPersonBuyerDto naturalBuyer = null;
	
	private ArtificialPersonBuyerDto artificialBuyer = null;
	
	private Date date;
	
	private float value;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

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

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	
	public void addProduct(ProductDto product){
		products.add(product);
	}

	public BuyerDto getBuyer() {
		if(naturalBuyer != null){
			return naturalBuyer;
		}else{
			return artificialBuyer;
		}
	}

	public void setBuyer(BuyerDto buyer) {
		if(buyer instanceof NaturalPersonBuyerDto){
			naturalBuyer = (NaturalPersonBuyerDto)buyer;
		}else{
			artificialBuyer = (ArtificialPersonBuyerDto)buyer;
		}
	}
	
	
}
