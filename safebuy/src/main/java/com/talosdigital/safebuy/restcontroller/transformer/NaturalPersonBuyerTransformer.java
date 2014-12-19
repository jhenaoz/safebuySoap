package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.NaturalPersonBuyer;
import com.talosdigital.safebuy.restcontroller.dto.ArtificialPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.NaturalPersonBuyerDto;

public class NaturalPersonBuyerTransformer {

	public static NaturalPersonBuyer toNaturalPersonBuyer(NaturalPersonBuyerDto buyerDto){
		NaturalPersonBuyer buyer = new NaturalPersonBuyer();
		buyer.setId(buyerDto.getId());
		buyer.setDocumentNumber(buyerDto.getDocumentNumber());
		buyer.setName(buyerDto.getName());
		buyer.setLastName(buyerDto.getLastName());
		buyer.setAge(buyerDto.getAge());
		buyer.setStore(StoreTransformer.toStore(buyerDto.getStoreDto()));
		return buyer;
	}
	
	public static NaturalPersonBuyerDto toNaturalPersonBuyerDto(NaturalPersonBuyer buyer){
		NaturalPersonBuyerDto buyerDto = new NaturalPersonBuyerDto();
		buyerDto.setId(buyer.getId());
		buyerDto.setDocumentNumber(buyer.getDocumentNumber());
		buyerDto.setName(buyer.getName());
		buyerDto.setLastName(buyer.getLastName());
		buyerDto.setAge(buyer.getAge());
		buyerDto.setStoreDto(StoreTransformer.toStoreDto(buyer.getStore()));
		return buyerDto;
	}
}
