package com.talosdigital.safebuy.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.model.Purchase;
import com.talosdigital.safebuy.persistence.util.PersistenceService;

@Repository
public class PurchaseDao {
	
	@Autowired
	private PersistenceService persistence;

	public List<Purchase> getPurchaseList(){
		return persistence.executeQuery(Purchase.class, "SELECT p FROM Purchase p");
	}
	
	public Purchase getPurchase(int id){
		return persistence.findById(Purchase.class, id);
	}
	
	public Purchase createPurchase(Purchase purchase){
		return persistence.save(purchase);
	}
	
	public void updatePurchase(Purchase purchase){
		persistence.update(purchase);
	}
	
	public void deletePurchase(int id){
		Purchase p = persistence.findById(Purchase.class, id);
		persistence.remove(p);
	}
}
