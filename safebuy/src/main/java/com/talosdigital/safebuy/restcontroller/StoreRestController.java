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
import org.springframework.web.servlet.ModelAndView;

import com.talosdigital.safebuy.model.Store;
import com.talosdigital.safebuy.persistence.dao.StoreDao;
import com.talosdigital.safebuy.restcontroller.dto.StoreDto;
import com.talosdigital.safebuy.restcontroller.transformer.StoreTransformer;

@RestController
public class StoreRestController {

	@Autowired
	private StoreDao storedao;
	
	@RequestMapping("/store.html")
	public ModelAndView getPage(){
		return new ModelAndView("/pages/indexstore.jsp");
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Store> getStoreList() {
		return storedao.getStoreList();
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public StoreDto getStore(@PathVariable("id") int id) {
		return StoreTransformer.toStoreDto(storedao.getStore(id));
	}
	
	@RequestMapping(value = "/rest/store", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public StoreDto createStore(@RequestBody StoreDto storeDto) {
		Store createdStore = storedao.createStore(StoreTransformer.toStore(storeDto));
		return StoreTransformer.toStoreDto(createdStore);
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public StoreDto updateStore(@RequestBody StoreDto storeDto, @PathVariable("id") int id) {
		Store store = StoreTransformer.toStore(storeDto);
		store.setId(id);
		store = storedao.updateStore(store);
		return StoreTransformer.toStoreDto(store);
	}
	
	@RequestMapping(value = "/rest/store/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteStore(@PathVariable("id") int id) {
		storedao.deleteStore(id);
	}

}
