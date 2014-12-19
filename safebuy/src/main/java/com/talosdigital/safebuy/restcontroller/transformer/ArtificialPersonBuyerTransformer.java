package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.ArtificialPersonBuyer;
import com.talosdigital.safebuy.restcontroller.dto.ArtificialPersonBuyerDto;

public class ArtificialPersonBuyerTransformer {
	
	public static ArtificialPersonBuyer toArtificialPersonBuyer(ArtificialPersonBuyerDto buyerDto){
		ArtificialPersonBuyer buyer = new ArtificialPersonBuyer();
		buyer.setId(buyerDto.getId());
		buyer.setNit(buyerDto.getNit());
		buyer.setName(buyerDto.getName());
		buyer.setStore(StoreTransformer.toStore(buyerDto.getStoreDto()));
		buyer.setEmployees(buyerDto.getEmployees());
		return buyer;
	}
	
	public static ArtificialPersonBuyerDto toArtificialPersonBuyerDto(ArtificialPersonBuyer buyer){
		ArtificialPersonBuyerDto buyerDto = new ArtificialPersonBuyerDto();
		buyerDto.setId(buyer.getId());
		buyerDto.setName(buyer.getName());
		buyerDto.setStoreDto(StoreTransformer.toStoreDto(buyer.getStore()));
		buyerDto.setEmployees(buyer.getEmployees());
		buyerDto.setNit(buyer.getNit());
		return buyerDto;
	}
}
