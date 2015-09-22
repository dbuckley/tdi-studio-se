package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class SoqlCondition extends com.sforce.soap.partner.SoqlWhereCondition implements ISoqlCondition{

    /**
     * Constructor
     */
    public SoqlCondition() {}

    /**
     * element : field of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo field__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","field","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean field__is_set = false;

    private java.lang.String field;

    @Override
    public java.lang.String getField() {
      return field;
    }

    @Override
    public void setField(java.lang.String field) {
      this.field = field;
      field__is_set = true;
    }

    protected void setField(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, field__typeInfo)) {
        setField(__typeMapper.readString(__in, field__typeInfo, java.lang.String.class));
      }
    }

    /**
     * element : operator of type {urn:partner.soap.sforce.com}soqlOperator
     * java type: com.sforce.soap.partner.SoqlOperator
     */
    private static final com.sforce.ws.bind.TypeInfo operator__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","operator","urn:partner.soap.sforce.com","soqlOperator",1,1,true);

    private boolean operator__is_set = false;

    private com.sforce.soap.partner.SoqlOperator operator;

    @Override
    public com.sforce.soap.partner.SoqlOperator getOperator() {
      return operator;
    }

    @Override
    public void setOperator(com.sforce.soap.partner.SoqlOperator operator) {
      this.operator = operator;
      operator__is_set = true;
    }

    protected void setOperator(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, operator__typeInfo)) {
        setOperator((com.sforce.soap.partner.SoqlOperator)__typeMapper.readObject(__in, operator__typeInfo, com.sforce.soap.partner.SoqlOperator.class));
      }
    }

    /**
     * element : values of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String[]
     */
    private static final com.sforce.ws.bind.TypeInfo values__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","values","http://www.w3.org/2001/XMLSchema","string",1,-1,true);

    private boolean values__is_set = false;

    private java.lang.String[] values = new java.lang.String[0];

    @Override
    public java.lang.String[] getValues() {
      return values;
    }

    @Override
    public void setValues(java.lang.String[] values) {
      this.values = castArray(java.lang.String.class, values);
      values__is_set = true;
    }

    protected void setValues(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, values__typeInfo)) {
        setValues((java.lang.String[])__typeMapper.readObject(__in, values__typeInfo, java.lang.String[].class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      __typeMapper.writeXsiType(__out, "urn:partner.soap.sforce.com", "SoqlCondition");
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       super.writeFields(__out, __typeMapper);
       __typeMapper.writeString(__out, field__typeInfo, field, field__is_set);
       __typeMapper.writeObject(__out, operator__typeInfo, operator, operator__is_set);
       __typeMapper.writeObject(__out, values__typeInfo, values, values__is_set);
    }

    @Override
    public void load(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __typeMapper.consumeStartTag(__in);
      loadFields(__in, __typeMapper);
      __typeMapper.consumeEndTag(__in);
    }

    protected void loadFields(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
        super.loadFields(__in, __typeMapper);
        setField(__in, __typeMapper);
        setOperator(__in, __typeMapper);
        setValues(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[SoqlCondition ");
      sb.append(super.toString());sb.append(" field='").append(com.sforce.ws.util.Verbose.toString(field)).append("'\n");
      sb.append(" operator='").append(com.sforce.ws.util.Verbose.toString(operator)).append("'\n");
      sb.append(" values='").append(com.sforce.ws.util.Verbose.toString(values)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private <T,U> T[] castArray(Class<T> clazz, U[] array) {
        if (array == null) {
            return null;
        }
        T[] retVal = (T[]) java.lang.reflect.Array.newInstance(clazz, array.length);
        for (int i=0; i < array.length; i++) {
            retVal[i] = (T)array[i];
        }

        return retVal;
	}
}
