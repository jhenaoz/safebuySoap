package com.talosdigital.safebuy.restcontroller.transformer;

import java.util.ArrayList;

import com.talosdigital.safebuy.model.Product;
import com.talosdigital.safebuy.model.Purchase;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;
import com.talosdigital.safebuy.restcontroller.dto.PurchaseDto;

public class PurchaseTransformer {
	
	public static Purchase toPurchase(PurchaseDto purchaseDto){
		Purchase purchase = new Purchase();
		if(purchaseDto.getId()>=0){
			purchase.setId(purchaseDto.getId());
		}
		ArrayList<Product> products = new ArrayList<Product>();
		for(ProductDto productDto : purchaseDto.getProducts()){
			products.add(ProductTransformer.toProduct(productDto));
		}
		purchase.setProducts(products);
		purchase.setStore(StoreTransformer.toStore(purchaseDto.getStore()));
		purchase.setBuyer(BuyerTransformer.toBuyer(purchaseDto.getBuyer()));
		return purchase;
	}
	
	public static PurchaseDto toPurchaseDto(Purchase purchase){
		PurchaseDto purchaseDto = new PurchaseDto();
		purchaseDto.setId(purchase.getId());
		ArrayList<ProductDto> products = new ArrayList<ProductDto>();
		for(Product product : purchase.getProducts()){
			products.add(ProductTransformer.toProductDto(product));
		}
		purchaseDto.setProducts(products);
		purchaseDto.setStore(StoreTransformer.toStoreDto(purchase.getStore()));
		purchaseDto.setBuyer(BuyerTransformer.toBuyerDto(purchase.getBuyer()));
		return purchaseDto;
	}
}
