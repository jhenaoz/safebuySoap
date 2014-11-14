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

import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;
import com.talosdigital.safebuy.restcontroller.transformer.BuyerTransformer;

@RestController
public class BuyerRestController {
	
	@Autowired
	private BuyerDao buyerdao;
	
	@RequestMapping("/hola.html")
	public ModelAndView getPage() {
		return new ModelAndView("/pages/index.jsp");
	}

	@RequestMapping(value = "/rest/buyer",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Buyer> getSafeBuyerList() {
		return buyerdao.getSafeBuyerList();
	}
	
	@RequestMapping(value = "/rest/buyer/{id}",
			method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Buyer getSafeBuyer(@PathVariable("id") int id) {
		return buyerdao.getSafeBuyer(id);
	}

	@RequestMapping(value = "/rest/buyer",
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public BuyerDto createSafeBuyer(@RequestBody BuyerDto buyerDto) {
		Buyer buyer = buyerdao.createSafeBuyer(BuyerTransformer.toBuyer(buyerDto));
		return BuyerTransformer.toBuyerDto(buyer);
	}

	@RequestMapping(value = "/rest/buyer/{id}",
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateSafeBuyer(@RequestBody BuyerDto buyerDto,
			@PathVariable("id") int id) {
		buyerdao.updateSafeBuyer(BuyerTransformer.toBuyer(buyerDto));
	}

	@RequestMapping(value = "/rest/buyer/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSafeBuyer(@PathVariable("id") int id) {
		buyerdao.deleteSafeBuyer(id);
	}
}
