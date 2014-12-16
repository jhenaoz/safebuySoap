package com.talosdigital.safebuy.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.model.Purchase;
import com.talosdigital.safebuy.persistence.util.PersistenceService;

@Repository
public class PurchaseDao {
	
	@Autowired
	private PersistenceService persistenceService;

	public List<Purchase> getPurchaseList(){
		return null;
	}
}
