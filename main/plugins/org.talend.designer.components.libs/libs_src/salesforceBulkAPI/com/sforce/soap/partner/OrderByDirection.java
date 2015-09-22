package com.sforce.soap.partner;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum OrderByDirection {


  
	/**
	 * Enumeration  : ascending
	 */
	ascending("ascending"),

  
	/**
	 * Enumeration  : descending
	 */
	descending("descending"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (OrderByDirection e : EnumSet.allOf(OrderByDirection.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private OrderByDirection(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}
