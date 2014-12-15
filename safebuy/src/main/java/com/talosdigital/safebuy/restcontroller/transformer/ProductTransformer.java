package com.talosdigital.safebuy.restcontroller.transformer;

import com.talosdigital.safebuy.model.Product;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;

public class ProductTransformer {

	public static Product toProduct(ProductDto productDto){
		Product product = new Product();
		
		product.setNit(productDto.getNit());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
		product.setCategory(productDto.getCategory());
		product.setStockQuantity(productDto.getStockQuantity());
		
		return product;
	}
	
	public static ProductDto toProductDto(Product product){
		ProductDto productDto = new ProductDto();
		
		productDto.setNit(productDto.getNit());
		productDto.setName(productDto.getName());
		productDto.setPrice(productDto.getPrice());
		productDto.setCategory(productDto.getCategory());
		productDto.setStockQuantity(productDto.getStockQuantity());
		
		return productDto;
	}
}
