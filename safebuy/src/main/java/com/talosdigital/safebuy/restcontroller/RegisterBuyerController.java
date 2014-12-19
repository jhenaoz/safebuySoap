package com.talosdigital.safebuy.restcontroller;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;
import com.talosdigital.safebuy.restcontroller.dto.BuyerDto;
import com.talosdigital.safebuy.util.MessageType;
import com.talosdigital.safebuy.util.ResponseMessage;
//@Controller
public class RegisterBuyerController {

//	@Autowired
//	private BuyerDao buyerDao;
//	
//	@RequestMapping("/registerBuyer.html")
//	public ModelAndView getPage() {
//		return new ModelAndView("/pages/registerBuyer.jsp");
//	}
//
//	@RequestMapping("/registerBuyerAction.html")
//	public ModelAndView submitForm(
//			@RequestParam String user,
//			@RequestParam String name,
//			@RequestParam String lastName,
//			@RequestParam String birthDay,
//			@RequestParam String email,
//			@RequestParam(required = false, defaultValue = "false") Boolean receiveNotification)
//			throws ParseException {
//		if (StringUtils.isEmpty(user)) {
//			return ResponseMessage.createMessage(
//					"El Nombre de usuario no puede estar vacio",
//					MessageType.error);
//		}
//		if (StringUtils.isEmpty(name)) {
//			return ResponseMessage.createMessage(
//					"El Nombre no puede estar vacio", MessageType.error);
//		}
//		if (StringUtils.isEmpty(lastName)) {
//			return ResponseMessage.createMessage(
//					"El Apellido no puede estar vacio", MessageType.error);
//		}
//		if (StringUtils.isEmpty(birthDay)) {
//			return ResponseMessage.createMessage(
//					"El cumpleanos no puede estar vacio", MessageType.error);
//		}
//		if (StringUtils.isEmpty(email)) {
//			return ResponseMessage.createMessage(
//					"El Email no puede estar vacio", MessageType.error);
//		}
//		BuyerDto buyerDto = new BuyerDto();
//		buyerDto.setName(name.toLowerCase());
//		buyerDto.setLastName(lastName.toLowerCase());
//		
//		List<Buyer> existingBuyersWithId = buyerDao.existingBuyerWithId(name);
//		
//		if (CollectionUtils.isNotEmpty(existingBuyersWithId)) {
//			return ResponseMessage.createMessage(
//					"El usuario comprador ya existe: " + user,
//					MessageType.error);
//		}
//		
//		buyerDao.createSafeBuyer(BuyerTransformer.toBuyer(buyerDto));
//		return ResponseMessage.createMessage("Comprador Creado",
//				MessageType.success);
//	}
}
