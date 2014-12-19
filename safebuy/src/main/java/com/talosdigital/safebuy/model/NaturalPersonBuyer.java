package com.talosdigital.safebuy.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "natural_person_buyer")
@DiscriminatorValue("natural_person")
public class NaturalPersonBuyer extends Buyer{

	private static final long serialVersionUID = 1154763325905768213L;

	@Column(name="last_name", nullable = false)
	private String lastName;
	
	private int age;

	@Column(name="document_number", nullable = false)
	private int documentNumber;
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(int documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
