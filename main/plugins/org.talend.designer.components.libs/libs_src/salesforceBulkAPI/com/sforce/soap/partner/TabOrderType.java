package com.sforce.soap.partner;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum TabOrderType {


  
	/**
	 * Enumeration  : LeftToRight
	 */
	LeftToRight("LeftToRight"),

  
	/**
	 * Enumeration  : TopToBottom
	 */
	TopToBottom("TopToBottom"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (TabOrderType e : EnumSet.allOf(TabOrderType.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private TabOrderType(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}
