package com.sforce.soap.partner;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum WebLinkPosition {


  
	/**
	 * Enumeration  : fullScreen
	 */
	fullScreen("fullScreen"),

  
	/**
	 * Enumeration  : none
	 */
	none("none"),

  
	/**
	 * Enumeration  : topLeft
	 */
	topLeft("topLeft"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (WebLinkPosition e : EnumSet.allOf(WebLinkPosition.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private WebLinkPosition(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}
