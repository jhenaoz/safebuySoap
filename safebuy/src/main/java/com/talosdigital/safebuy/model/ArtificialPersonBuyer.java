package com.talosdigital.safebuy.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "artificial_person_buyer")
@DiscriminatorValue("artificial_person")
public class ArtificialPersonBuyer extends Buyer {

	private static final long serialVersionUID = 2170997373995204739L;

	@Column(nullable = false)
	private String nit;
	
	private int employees;

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public int getEmployees() {
		return employees;
	}

	public void setEmployees(int employees) {
		this.employees = employees;
	}
}
