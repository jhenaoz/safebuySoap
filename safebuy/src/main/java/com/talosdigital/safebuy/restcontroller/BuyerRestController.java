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

import com.talosdigital.safebuy.model.ArtificialPersonBuyer;
import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.model.NaturalPersonBuyer;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;
import com.talosdigital.safebuy.restcontroller.dto.ArtificialPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;
import com.talosdigital.safebuy.restcontroller.dto.NaturalPersonBuyerDto;
import com.talosdigital.safebuy.restcontroller.transformer.ArtificialPersonBuyerTransformer;
import com.talosdigital.safebuy.restcontroller.transformer.NaturalPersonBuyerTransformer;

@RestController
public class BuyerRestController {
	
	@Autowired
	private BuyerDao buyerdao;
	
	@RequestMapping("/hola.html")
	public ModelAndView getPage() {
		return new ModelAndView("/pages/index.jsp");
	}

	@RequestMapping(value = "/rest/buyer/",
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

	@RequestMapping(value = "/rest/buyer/natural/",
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public NaturalPersonBuyerDto createSafeBuyer(@RequestBody NaturalPersonBuyerDto buyerDto) {
		Buyer buyer = buyerdao.createSafeBuyer(NaturalPersonBuyerTransformer.toNaturalPersonBuyer(buyerDto));
		return NaturalPersonBuyerTransformer.toNaturalPersonBuyerDto((NaturalPersonBuyer) buyer);
	}
	
	@RequestMapping(value = "/rest/buyer/artificial/",
			method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ArtificialPersonBuyerDto createSafeBuyer(@RequestBody ArtificialPersonBuyerDto buyerDto) {
		Buyer buyer = buyerdao.createSafeBuyer(ArtificialPersonBuyerTransformer.toArtificialPersonBuyer(buyerDto));
		return ArtificialPersonBuyerTransformer.toArtificialPersonBuyerDto((ArtificialPersonBuyer) buyer);
	}

	@RequestMapping(value = "/rest/buyer/{id}",
			method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public void updateSafeBuyer(@RequestBody BuyerDto buyerDto,
			@PathVariable("id") int id) {
		buyerdao.updateSafeBuyer(buyerdao.getSafeBuyer(id));
	}

	@RequestMapping(value = "/rest/buyer/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public void deleteSafeBuyer(@PathVariable("id") int id) {
		buyerdao.deleteSafeBuyer(id);
	}
}
