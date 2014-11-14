package com.talosdigital.safebuy.persistence.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.talosdigital.safebuy.model.Store;
import com.talosdigital.safebuy.persistence.util.PersistenceService;

/**
 * This Class is a DAO from buyer Table
 * @author jhenaoz 16/Oct/2014
 * @version 
 */
@Repository
public class StoreDao {

	@Autowired
	private PersistenceService persistence;
	
	/**
	 * This method retrieve all the stores in the database
	 * @return List, with all the stores present.
	 */
	public List<Store> getStoreList(){
		return persistence.executeQuery(Store.class, "SELECT s FROM Store s");
	}
	
	public Store getStore(int id){
		return persistence.findById(Store.class, id);
	}
	
	public Store createStore(Store store){
		
		Store createdStore = persistence.save(store);
		return createdStore;
	}
	
	public Store updateStore(Store store){
		return persistence.update(store);
	}
	
	public void deleteStore(int id){
		persistence.remove(persistence.findById(Store.class, id));
	}
	
}
