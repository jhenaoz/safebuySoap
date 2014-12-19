package com.talosdigital.safebuy.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.talosdigital.buyer.CreateBuyerRequest;
import com.talosdigital.buyer.CreateBuyerResponse;
import com.talosdigital.buyer.DeleteBuyerRequest;
import com.talosdigital.buyer.DeleteBuyerResponse;
import com.talosdigital.buyer.GetBuyerRequest;
import com.talosdigital.buyer.GetBuyerResponse;
import com.talosdigital.buyer.UpdateBuyerRequest;
import com.talosdigital.buyer.UpdateBuyerResponse;
import com.talosdigital.safebuy.model.Buyer;
import com.talosdigital.safebuy.persistence.dao.BuyerDao;

//@Endpoint
public class BuyerEndpoint {

//	private static final String NAMESPACE_URI = "http://talosdigital.com/buyer";
//	
//	@Autowired
//	public BuyerDao buyerDao;
//	
//	public BuyerEndpoint(){
//		
//	}
//	@PayloadRoot(namespace = NAMESPACE_URI ,localPart="getBuyerRequest")
//	@ResponsePayload
//	public GetBuyerResponse getBuyer(@RequestPayload GetBuyerRequest request){
//		GetBuyerResponse response = new GetBuyerResponse();
//		Buyer buyer = buyerDao.getSafeBuyer(request.getId());
//		response.setBuyer(BuyerTransformer.fromBuyer(buyer));
//		return response;
//	}
//	
//	@PayloadRoot(namespace = NAMESPACE_URI , localPart="deleteBuyerRequest")
//	@ResponsePayload
//	public DeleteBuyerResponse deleteBuyer(@RequestPayload DeleteBuyerRequest request){
//		DeleteBuyerResponse response = new DeleteBuyerResponse();
//		buyerDao.deleteSafeBuyer(request.getId());
//		response.setResponse(true);
//		return response;
//		
//	}
//	
//	
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart="updateBuyerRequest")
//	@ResponsePayload
//	public UpdateBuyerResponse updateBuyer(@RequestPayload UpdateBuyerRequest request){
//		UpdateBuyerResponse response = new UpdateBuyerResponse();
//		com.talosdigital.buyer.Buyer buyerSoap = request.getBuyer();
//		buyerDao.updateSafeBuyer(BuyerTransformer.fromSoapBuyer(buyerSoap));
//		response.setBuyer(buyerSoap);
//		return response;
//	}
//		
//	@PayloadRoot(namespace = NAMESPACE_URI, localPart="createBuyerRequest")
//	@ResponsePayload
//	public CreateBuyerResponse updateBuyer(@RequestPayload CreateBuyerRequest request){
//		CreateBuyerResponse response = new CreateBuyerResponse();
//		Buyer buyer = new Buyer();
//		buyer.setLastName(request.getLastname());
//		buyer.setName(request.getName());
//		//ERROR ACA!----
//		buyer = buyerDao.createSafeBuyer(buyer) ;
//		BuyerTransformer.fromBuyer(buyer) ;
//		if (buyer.getId()!= 0) {
//			response.setId(buyer.getId());
//			response.setResponse("Buyer Created");
//		}else {
//			response.setResponse("Problems with the creation");
//		}
//		return response;
//	}
}
