package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IPerformQuickActionRequest  {

      /**
       * element : contextId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getContextId();

      public void setContextId(java.lang.String contextId);

      /**
       * element : quickActionName of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getQuickActionName();

      public void setQuickActionName(java.lang.String quickActionName);

      /**
       * element : records of type {urn:sobject.partner.soap.sforce.com}sObject
       * java type: com.sforce.soap.partner.sobject.SObject[]
       */

      public com.sforce.soap.partner.sobject.ISObject[] getRecords();

      public void setRecords(com.sforce.soap.partner.sobject.ISObject[] records);


}
