package com.talosdigital.safebuy.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.talosdigital.safebuy.persistence.types.HStoreUserType;

@Entity
@Table(name = "PRODUCT")
@TypeDef(name="hstore", typeClass = HStoreUserType.class)
public class Product implements Serializable{
	
	private static final long serialVersionUID = 5362509841185006232L;

	@Id
	@SequenceGenerator(name="webproduct_idwebproduct_seq", sequenceName="webproduct_idwebproduct_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="webproduct_idwebproduct_seq")
	@Column(name = "id", updatable=false)
	private int id;

	@Column(name="name", updatable=true, insertable=true)
	private String name;

	@Column(name="category", updatable=true, insertable=true)
	private Category category;
	
	@Column(name="price", updatable=true, insertable=true)
	private float price;
	
	@Column(name="stock_quantity", updatable=true, insertable=true)
	private int stockQuantity;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Store store;
	
	@Type(type = "hstore")
	private HashMap<String, String> properties;
	
	public HashMap<String, String> getProperties() {
		return properties;
	}

	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}

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
