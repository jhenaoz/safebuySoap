package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;

public class BuyerTransformer {

	public static Buyer toBuyer(BuyerDto buyerDto){
		Buyer buyer = new Buyer();
		if (buyerDto.getName() != null) {
			buyer.setName(buyerDto.getName());
		}
		if (buyerDto.getLastName() != null) {
			buyer.setLastName(buyerDto.getLastName());
		}
		buyer.setId(buyerDto.getId());
		return buyer;
	}
	
	public static BuyerDto toBuyerDto(Buyer buyer){
		BuyerDto buyerDto = new BuyerDto();
		if (buyer.getName() != null) {
			buyerDto.setName(buyer.getName());
		}
		if (buyer.getLastName() != null) {
			buyerDto.setLastName(buyer.getLastName());
		}
		buyerDto.setId(buyer.getId());
		return buyerDto;
	}
	
}
