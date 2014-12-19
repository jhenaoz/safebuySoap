package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.ArtificialPersonBuyer;
import com.talosdigital.safebuy.model.NaturalPersonBuyer;
import com.talosdigital.safebuy.model.Purchase;
import com.talosdigital.safebuy.restcontroller.dto.ArtificialPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.NaturalPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.PurchaseDto;

public class PurchaseTransformer {

	public static PurchaseDto toPurchaseDto(Purchase purchase) {
		PurchaseDto purchaseDto = new PurchaseDto();
		purchaseDto.setId(purchase.getId());
		purchaseDto.setProducts(ProductTransformer.toProductDtoList(purchase.getProducts()));
		purchaseDto.setStore(StoreTransformer.toStoreDto(purchase.getStore()));
		if(purchase.getBuyer() instanceof NaturalPersonBuyer){
			purchaseDto.setNaturalPersonBuyer(NaturalPersonBuyerTransformer.toNaturalPersonBuyerDto((NaturalPersonBuyer) purchase.getBuyer()));
		}
		else {
			purchaseDto.setArtificialPersonBuyer(ArtificialPersonBuyerTransformer.toArtificialPersonBuyerDto((ArtificialPersonBuyer) purchase.getBuyer()));
		}
		purchaseDto.setDate(purchase.getDate());
		purchaseDto.setValue(purchase.getValue());
		return purchaseDto;
	}

	public static Purchase toPurchase(PurchaseDto purchaseDto){
		Purchase purchase = new Purchase();
		purchase.setId(purchaseDto.getId());
		purchase.setProducts(ProductTransformer.toProductList(purchaseDto.getProducts()));
		purchase.setStore(StoreTransformer.toStore(purchaseDto.getStore()));
		if(purchaseDto.getNaturalPersonBuyer() != null){
			purchase.setBuyer(NaturalPersonBuyerTransformer.toNaturalPersonBuyer(purchaseDto.getNaturalPersonBuyer()));
		}
		else{
			purchase.setBuyer(ArtificialPersonBuyerTransformer.toArtificialPersonBuyer(purchaseDto.getArtificialPersonBuyer()));
		}
		return purchase;
	}
}
