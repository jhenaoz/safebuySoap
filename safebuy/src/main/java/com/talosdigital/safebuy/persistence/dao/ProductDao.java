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
	
	//TODO: Get products by store id. There are no products outside a store.
	public List<Product> getProductList(){
		return persistence.executeQuery(Product.class, "SELECT p FROM Product p");
	}

	//TODO: Get products by store id. There are no products outside a store.
	public Product getProduct(int nit){
		return persistence.findById(Product.class, nit);
	}
	
	public Product createProduct(Product product){
		return persistence.save(product);
	}
	
	public void updateProduct(Product product){
		persistence.update(product);
	}
	
	public void deleteProduct(int nit){
		Product p = persistence.findById(Product.class, nit);
		persistence.remove(p);
	}
}
