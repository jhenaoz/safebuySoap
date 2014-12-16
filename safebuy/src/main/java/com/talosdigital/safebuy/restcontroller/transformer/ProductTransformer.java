package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.Product;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;

public class ProductTransformer {

	public static Product toProduct(ProductDto productDto){
		Product product = new Product();
		if(productDto.getId() >= 0){
			product.setId(productDto.getId());
		}
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCategory(productDto.getCategory());
		product.setStockQuantity(productDto.getStockQuantity());
		product.setStore(StoreTransformer.toStore(productDto.getStoreDto()));
		
		return product;
	}
	
	public static ProductDto toProductDto(Product product){
		ProductDto productDto = new ProductDto();
		
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		productDto.setCategory(product.getCategory());
		productDto.setStockQuantity(product.getStockQuantity());
		productDto.setStoreDto(StoreTransformer.toStoreDto(product.getStore()));
		
		return productDto;
	}
}
