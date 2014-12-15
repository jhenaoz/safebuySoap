package com.talosdigital.safebuy.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.talosdigital.safebuy.model.Product;
import com.talosdigital.safebuy.persistence.dao.ProductDao;
import com.talosdigital.safebuy.restcontroller.dto.ProductDto;
import com.talosdigital.safebuy.restcontroller.transformer.ProductTransformer;

@RestController
public class ProductRestController {

	@Autowired
	private ProductDao productDao;
	
	// TODO: Get products with store id.
	@RequestMapping(value = "/rest/product",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getProductList(){
		return productDao.getProductList();
	}

	// TODO: Get products with store id.
	@RequestMapping(value = "/rest/product/{nit}",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product getProductByNit(@PathVariable("nit") int nit){
		return productDao.getProduct(nit);
	}
	
	@RequestMapping(value = "/rest/product",
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ProductDto createProduct(@RequestBody ProductDto productDto) {
		Product product = productDao.createProduct(ProductTransformer.toProduct(productDto));
		return ProductTransformer.toProductDto(product);
	}
	
	@RequestMapping(value = "/rest/product/",
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateProduct(@RequestBody ProductDto productDto){
		productDao.updateProduct(ProductTransformer.toProduct(productDto));
	}
	
	//TODO: Get the store's id too.
	@RequestMapping(value = "/rest/product/{nit}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable("nit") int nit){
		productDao.deleteProduct(nit);
	}
}
