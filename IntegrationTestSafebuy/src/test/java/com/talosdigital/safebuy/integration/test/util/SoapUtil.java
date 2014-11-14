package com.talosdigital.safebuy.integration.test.util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SoapUtil {

	/**
	 * This method receive a property and search recursively into a document
	 * @param property, property to search in the document
	 * @param message, document object to search a specific property
	 * @return String value, the value of the property, if the property
	 * is not founded return null
	 */
	public static String  getElement(String property, Document message){
		Document document = message;
		NodeList list = document.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			String output = visitRecursively(list.item(i), property) ;
			if (output != null) {
				return output;
			}
		}
		return null;
	}

	private static String visitRecursively(Node node, String property) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node childNode = list.item(i);
			if (childNode.getNodeName().equals(property)) {
				return childNode.getTextContent();
			}
			visitRecursively(childNode, property);
		}
		return null;
	}

}
