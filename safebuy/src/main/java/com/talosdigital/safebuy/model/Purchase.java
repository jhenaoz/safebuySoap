package com.talosdigital.safebuy.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "PURCHASE")
public class Purchase {

	@Id
	@SequenceGenerator(
			name = "webpurchase_idwebpurchase_seq",
			sequenceName = "webpurchase_idwebpurchase_seq",
			allocationSize = 1)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "webpurchase_idwebpurchase_seq")
	@Column(name = "id", updatable = false)
	private int id;

	@Column(name = "store", nullable = false)
	private Store store;

	// Delete orphan is true by default using @ElementCollection and fetch type
	// is LAZY.
	@ElementCollection
	@CollectionTable(
			name = "purchased_product",
			joinColumns = @JoinColumn(name = "purchase_id"))
	private List<Product> products;
	
	@OneToOne(fetch = FetchType.LAZY)
	@Column(name = "buyer", nullable = false)
	private Buyer buyer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
}
