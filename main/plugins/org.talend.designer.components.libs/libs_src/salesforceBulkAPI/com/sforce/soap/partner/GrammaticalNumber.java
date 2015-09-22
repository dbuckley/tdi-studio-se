package com.sforce.soap.partner;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum GrammaticalNumber {


  
	/**
	 * Enumeration  : Singular
	 */
	Singular("Singular"),

  
	/**
	 * Enumeration  : Plural
	 */
	Plural("Plural"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (GrammaticalNumber e : EnumSet.allOf(GrammaticalNumber.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private GrammaticalNumber(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}
