package com.talosdigital.safebuy.soap;

import com.talosdigital.safebuy.model.Buyer;

public class BuyerTransformer {

	public static com.talosdigital.buyer.Buyer fromBuyer(Buyer buyer){
		com.talosdigital.buyer.Buyer buyerSoap = new com.talosdigital.buyer.Buyer();
		buyerSoap.setId(buyer.getId());
		buyerSoap.setLastname(buyer.getLastName());
		buyerSoap.setName(buyer.getName());
		return buyerSoap;
	}
	
	public static Buyer fromSoapBuyer(com.talosdigital.buyer.Buyer soapBuyer){
		Buyer buyer = new Buyer();
		buyer.setId(soapBuyer.getId());
		buyer.setLastName(soapBuyer.getLastname());
		buyer.setName(soapBuyer.getName());
		return buyer;
	}
}
