package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.ArtificialPersonBuyer;
import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.model.NaturalPersonBuyer;
import com.talosdigital.safebuy.restcontroller.dto.ArtificialPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.NaturalPersonBuyerDto;

public class BuyerTransformer {

	public static Buyer toBuyer(BuyerDto buyerDto){
		Buyer buyer;
		if(buyerDto instanceof NaturalPersonBuyerDto){
			buyer = toNaturalPersonBuyer((NaturalPersonBuyerDto)buyerDto);
		}
		else {
			buyer = toArtificialPersonBuyer((ArtificialPersonBuyerDto)buyerDto);
		}
		buyer.setName(buyerDto.getName());
		buyer.setId(buyerDto.getId());
		buyer.setStore(StoreTransformer.toStore(buyerDto.getStoreDto()));
		return buyer;
	}

	public static BuyerDto toBuyerDto(Buyer buyer){
		BuyerDto buyerDto;
		if(buyer instanceof NaturalPersonBuyer){
			buyerDto = toNaturalPersonBuyerDto((NaturalPersonBuyer)buyer);
		}
		else {
			buyerDto = toArtificialPersonBuyerDto((ArtificialPersonBuyer)buyer);
		}
		buyerDto.setName(buyer.getName());
		buyerDto.setId(buyer.getId());
		buyerDto.setStoreDto(StoreTransformer.toStoreDto(buyer.getStore()));
		return buyerDto;
	}

	private static BuyerDto toNaturalPersonBuyerDto(NaturalPersonBuyer buyer) {
		NaturalPersonBuyerDto buyerDto = new NaturalPersonBuyerDto();
		buyerDto.setDocumentNumber(buyer.getDocumentNumber());
		buyerDto.setLastName(buyer.getLastName());
		buyerDto.setAge(buyer.getAge());
		return buyerDto;
	}
	
	private static BuyerDto toArtificialPersonBuyerDto(ArtificialPersonBuyer buyer) {
		ArtificialPersonBuyerDto buyerDto = new ArtificialPersonBuyerDto();
		buyerDto.setNit(buyer.getNit());
		buyerDto.setEmployees(buyer.getEmployees());
		return buyerDto;
	}

	private static Buyer toNaturalPersonBuyer(NaturalPersonBuyerDto buyerDto) {
		NaturalPersonBuyer buyer = new NaturalPersonBuyer();
		buyer.setDocumentNumber(buyerDto.getDocumentNumber());
		buyer.setLastName(buyerDto.getLastName());
		buyer.setAge(buyerDto.getAge());
		return buyer;
	}

	private static Buyer toArtificialPersonBuyer(ArtificialPersonBuyerDto buyerDto) {
		ArtificialPersonBuyer buyer =  new ArtificialPersonBuyer();
		buyer.setNit(buyerDto.getNit());
		buyer.setEmployees(buyer.getEmployees());
		return buyer;
	}
}
