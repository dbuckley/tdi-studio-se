package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface IPerformQuickActionResult  {

      /**
       * element : contextId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getContextId();

      public void setContextId(java.lang.String contextId);

      /**
       * element : created of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: boolean
       */

      public boolean getCreated();

      public boolean isCreated();

      public void setCreated(boolean created);

      /**
       * element : errors of type {urn:partner.soap.sforce.com}Error
       * java type: com.sforce.soap.partner.Error[]
       */

      public com.sforce.soap.partner.IError[] getErrors();

      public void setErrors(com.sforce.soap.partner.IError[] errors);

      /**
       * element : feedItemIds of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String[]
       */

      public java.lang.String[] getFeedItemIds();

      public void setFeedItemIds(java.lang.String[] feedItemIds);

      /**
       * element : ids of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String[]
       */

      public java.lang.String[] getIds();

      public void setIds(java.lang.String[] ids);

      /**
       * element : success of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: boolean
       */

      public boolean getSuccess();

      public boolean isSuccess();

      public void setSuccess(boolean success);


}
