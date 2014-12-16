package com.talosdigital.safebuy.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.model.Product;
import com.talosdigital.safebuy.persistence.util.PersistenceService;

@Repository
public class ProductDao {

	@Autowired
	private PersistenceService persistence;
	
	public List<Product> getProductList(){
		return persistence.executeQuery(Product.class, "SELECT p FROM Product p");
	}
	
	//TODO: Test this.
	public List<Product> getProductListForStore(int storeId){
		return persistence.executeQuery(
				Product.class,
				"SELECT p FROM Product p WHERE store EQUALS " + storeId);
	}

	public Product getProduct(int id){
		return persistence.findById(Product.class, id);
	}
	
	public Product createProduct(Product product){
		return persistence.save(product);
	}
	
	public void updateProduct(Product product){
		persistence.update(product);
	}
	
	public void deleteProduct(int id){
		Product p = persistence.findById(Product.class, id);
		persistence.remove(p);
	}
}
