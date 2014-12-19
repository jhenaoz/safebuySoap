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

import com.talosdigital.safebuy.persistence.dao.PurchaseDao;
import com.talosdigital.safebuy.restcontroller.dto.PurchaseDto;
import com.talosdigital.safebuy.restcontroller.transformer.PurchaseTransformer;
import com.talosdigital.safebuy.model.Purchase;

@RestController
public class PurchaseRestController {
	
	@Autowired
	PurchaseDao purchaseDao;
	
	//TODO: change return type to List<PurchaseDto>
	@RequestMapping(
			value = "/rest/purchase/",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Purchase> getPurchaseList(){
		return purchaseDao.getPurchaseList();
	}
	
	@RequestMapping(
			value = "/rest/purchase/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public PurchaseDto getPurchase(@PathVariable("id") int id){
		return PurchaseTransformer.toPurchaseDto(purchaseDao.getPurchase(id));
	}
	
	@RequestMapping(
			value = "/rest/purchase/",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public PurchaseDto createPurchase(@RequestBody PurchaseDto purchaseDto){
		Purchase purchase = purchaseDao.createPurchase(PurchaseTransformer.toPurchase((PurchaseDto)purchaseDto));
		return PurchaseTransformer.toPurchaseDto(purchase);
	}
	
	@RequestMapping(
			value = "/rest/purchase/",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updatePurchase(@RequestBody PurchaseDto purchaseDto){
		purchaseDao.updatePurchase(PurchaseTransformer.toPurchase(purchaseDto));
	}
	
	@RequestMapping(
			value = "/rest/purchase/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void deletePurchase(@PathVariable("id") int id){
		purchaseDao.deletePurchase(id);
	}
}
