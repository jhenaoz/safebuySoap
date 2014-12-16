package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;

public class BuyerTransformer {

	public static Buyer toBuyer(BuyerDto buyerDto){
		Buyer buyer = new Buyer();
		buyer.setName(buyerDto.getName());
		buyer.setLastName(buyerDto.getLastName());
		buyer.setId(buyerDto.getId());
		buyer.setStore(StoreTransformer.toStore(buyerDto.getStoreDto()));
		return buyer;
	}
	
	public static BuyerDto toBuyerDto(Buyer buyer){
		BuyerDto buyerDto = new BuyerDto();
		buyerDto.setName(buyer.getName());
		buyerDto.setLastName(buyer.getLastName());
		buyerDto.setId(buyer.getId());
		buyerDto.setStoreDto(StoreTransformer.toStoreDto(buyer.getStore()));
		return buyerDto;
	}
	
}
