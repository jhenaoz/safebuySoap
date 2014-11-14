package com.talosdigital.safebuy.integration.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import com.talosdigital.safebuy.config.Properties;
import com.talosdigital.safebuy.integration.test.util.BuyerUtil;
import com.talosdigital.safebuy.integration.test.util.SoapUtil;

//@SuppressWarnings("restriction")
public class BuyerIntegrationTest {

	ArrayList<Integer> buyers;
	SOAPConnection soapConection ;
	
	@Before
	public void init() throws UnsupportedOperationException, SOAPException  {
		buyers = new ArrayList<Integer>();
		SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		soapConection = soapConnectionFactory.createConnection();
		
	}

	@Test
	public void createBuyer() throws SOAPException, IOException, JAXBException  {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
				
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("gs", Properties.NAMESPACE ) ;
		
		/*
		<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
						  xmlns:gs="http://talosdigital.com/buyer">
		   <soapenv:Header/>
		   <soapenv:Body>
		      <gs:createBuyerRequest>
		         <gs:name>Carlos</gs:name>
		         <gs:lastname>henao</gs:lastname>
		      </gs:createBuyerRequest>
		   </soapenv:Body>
		</soapenv:Envelope>
 		*/
		
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElement = soapBody.addChildElement("createBuyerRequest" , "gs") ;
		SOAPElement name = soapBodyElement.addChildElement("name" , "gs");
		SOAPElement lastname = soapBodyElement.addChildElement("lastname" , "gs");
		name.addTextNode("Juan David");
		lastname.addTextNode("Henao Zapata");
		
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", "");
		
		soapMessage.saveChanges();
		
		System.out.println("REQUEST SOAP MESSAGE :");
		soapMessage.writeTo(System.out);
		System.out.println();
		SOAPMessage soapResponse = soapConection.call(soapMessage, Properties.URL);
		System.out.println("SOAP RESPONSE MESSAGE");
		Document document = soapResponse.getSOAPBody().extractContentAsDocument();
		soapResponse.writeTo(System.out);
		String id = SoapUtil.getElement("ns2:id", document);
		String response = SoapUtil.getElement("ns2:response", document);
		
		assertTrue(Integer.parseInt(id) != 0);
		assertTrue(response.equals("Buyer Created"));
		buyers.add(Integer.parseInt(id));
	}

	@Test
	public void retrieveBuyer() throws SOAPException, IOException {
		//Create a buyer, created with id -1
		String buyerName = "Juan";
		String buyerLastName = "Henao"; 
		BuyerUtil.createBuyer(buyerLastName, buyerLastName);
		
		//Search for buyer with id -1, with a soap service
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("gs", Properties.NAMESPACE ) ;		
		
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElement = soapBody.addChildElement("getBuyerRequest" , "gs") ;
		SOAPElement soapBodyElement1 = soapBodyElement.addChildElement("id" , "gs");
		soapBodyElement1.addTextNode("-1"); 
		
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", "");
		soapMessage.saveChanges();
		SOAPMessage soapResponse = soapConection.call(soapMessage, Properties.URL);
		Document document = soapResponse.getSOAPBody().extractContentAsDocument();
		int id = Integer.parseInt(SoapUtil.getElement("ns2:id", document));
		String name = SoapUtil.getElement("ns2:name", document);
		String lastName = SoapUtil.getElement("ns2:lastName", document);
		
		//delete the record for leave the database in the original state.
		deleteBuyer(-1);
		
		//assert the params of the created object
		assertEquals(-1, id);
		assertEquals(buyerName, name);
		assertEquals(buyerLastName, lastName);
		
		
	}

	public void deleteBuyer(int id) throws SOAPException, IOException{
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();
				
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("gs", Properties.NAMESPACE ) ;
		
		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElement = soapBody.addChildElement("deleteBuyerRequest" , "gs") ;
		SOAPElement soapBodyElement1 = soapBodyElement.addChildElement("id" , "gs");
		soapBodyElement1.addTextNode("" + id); 
		
		MimeHeaders headers = soapMessage.getMimeHeaders();
		headers.addHeader("SOAPAction", "");
		
		soapMessage.saveChanges();
		
		System.out.println("REQUEST SOAP MESSAGE :");
		soapMessage.writeTo(System.out);
		System.out.println();
		SOAPMessage soapResponse = soapConection.call(soapMessage, Properties.URL);
		System.out.println("SOAP RESPONSE MESSAGE");
		soapResponse.writeTo(System.out);		 
	}
	
	@After
	public void cleanAll() throws SOAPException, IOException {
		for (Integer integer : buyers) {
			deleteBuyer(integer);
		}
	}

}
