package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public interface ILoginResult  {

      /**
       * element : metadataServerUrl of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getMetadataServerUrl();

      public void setMetadataServerUrl(java.lang.String metadataServerUrl);

      /**
       * element : passwordExpired of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: boolean
       */

      public boolean getPasswordExpired();

      public boolean isPasswordExpired();

      public void setPasswordExpired(boolean passwordExpired);

      /**
       * element : sandbox of type {http://www.w3.org/2001/XMLSchema}boolean
       * java type: boolean
       */

      public boolean getSandbox();

      public boolean isSandbox();

      public void setSandbox(boolean sandbox);

      /**
       * element : serverUrl of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getServerUrl();

      public void setServerUrl(java.lang.String serverUrl);

      /**
       * element : sessionId of type {http://www.w3.org/2001/XMLSchema}string
       * java type: java.lang.String
       */

      public java.lang.String getSessionId();

      public void setSessionId(java.lang.String sessionId);

      /**
       * element : userId of type {urn:partner.soap.sforce.com}ID
       * java type: java.lang.String
       */

      public java.lang.String getUserId();

      public void setUserId(java.lang.String userId);

      /**
       * element : userInfo of type {urn:partner.soap.sforce.com}GetUserInfoResult
       * java type: com.sforce.soap.partner.GetUserInfoResult
       */

      public com.sforce.soap.partner.IGetUserInfoResult getUserInfo();

      public void setUserInfo(com.sforce.soap.partner.IGetUserInfoResult userInfo);


}
