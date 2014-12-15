package com.talosdigital.safebuy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 5362509841185006232L;

	@Id
	@Column(name = "nit", updatable=false)
	private int nit;

	@Column(name="name", updatable=true, insertable=true)
	private String name;

	@Column(name="category", updatable=true, insertable=true)
	private Category category;
	
	@Column(name="price", updatable=true, insertable=true)
	private float price;
	
	@Column(name="stockQuantity", updatable=true, insertable=true)
	private int stockQuantity;

	@ManyToOne(optional = false)
	private Store store;

	public int getNit() {
		return nit;
	}
	
	public void setNit(int nit) {
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

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
}
