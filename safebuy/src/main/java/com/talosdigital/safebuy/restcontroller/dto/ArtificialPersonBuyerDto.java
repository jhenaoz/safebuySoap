package com.talosdigital.safebuy.restcontroller.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ArtificialPersonBuyerDto extends BuyerDto {

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
