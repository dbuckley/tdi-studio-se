package com.sforce.soap.partner;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated by SimpleTypeCodeGenerator.java. Please do not edit.
 */
public enum ReportChartSize {


  
	/**
	 * Enumeration  : SMALL
	 */
	SMALL("SMALL"),

  
	/**
	 * Enumeration  : MEDIUM
	 */
	MEDIUM("MEDIUM"),

  
	/**
	 * Enumeration  : LARGE
	 */
	LARGE("LARGE"),

;

	public static Map<String, String> valuesToEnums;

	static {
   		valuesToEnums = new HashMap<String, String>();
   		for (ReportChartSize e : EnumSet.allOf(ReportChartSize.class)) {
   			valuesToEnums.put(e.toString(), e.name());
   		}
   	}

   	private String value;

   	private ReportChartSize(String value) {
   		this.value = value;
   	}

   	@Override
   	public String toString() {
   		return value;
   	}
}
