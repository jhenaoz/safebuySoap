package com.talosdigital.safebuy.model;

import java.io.Serializable; 

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "BUYER")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "buyer_type")
public abstract class Buyer implements Serializable{

	/** */
	private static final long serialVersionUID = 8706438939162046811L;

	@Id
	@SequenceGenerator(name="webuser_idwebuser_seq", sequenceName="webuser_idwebuser_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="webuser_idwebuser_seq")
	@Column(name = "id", updatable=false)
	private int id;

	@Column(name="name", updatable=true, insertable=true)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Store store; // many-to-one

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		
		this.store = store;
	}
	
	@Override
	public boolean equals(Object obj){
		Buyer buyer = (Buyer)obj;
		if (buyer.getId() == this.getId()) {
			return true;
		}else{
			return false;
		}
	}

	
}
