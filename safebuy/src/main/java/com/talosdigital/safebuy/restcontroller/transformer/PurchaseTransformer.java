package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.Purchase;
import com.talosdigital.safebuy.restcontroller.dto.PurchaseDto;

public class PurchaseTransformer {

	public static PurchaseDto toPurchaseDto(Purchase purchase) {
		PurchaseDto purchaseDto = new PurchaseDto();
		purchaseDto.setId(purchase.getId());
		purchaseDto.setProducts(ProductTransformer.toProductDtoList(purchase.getProducts()));
		purchaseDto.setStore(StoreTransformer.toStoreDto(purchase.getStore()));
		purchaseDto.setBuyer(BuyerTransformer.toBuyerDto(purchase.getBuyer()));
		
		return purchaseDto;
	}

	public static Purchase toPurchase(PurchaseDto purchaseDto){
		Purchase purchase = new Purchase();
		purchase.setId(purchaseDto.getId());
		purchase.setProducts(ProductTransformer.toProductList(purchaseDto.getProducts()));
		purchase.setStore(StoreTransformer.toStore(purchaseDto.getStore()));
		purchase.setBuyer(BuyerTransformer.toBuyer(purchaseDto.getBuyer()));
		
		return purchase;
	}
}
