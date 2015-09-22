package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class DescribeQuickActionListResult implements com.sforce.ws.bind.XMLizable , IDescribeQuickActionListResult{

    /**
     * Constructor
     */
    public DescribeQuickActionListResult() {}

    /**
     * element : quickActionListItems of type {urn:partner.soap.sforce.com}DescribeQuickActionListItemResult
     * java type: com.sforce.soap.partner.DescribeQuickActionListItemResult[]
     */
    private static final com.sforce.ws.bind.TypeInfo quickActionListItems__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","quickActionListItems","urn:partner.soap.sforce.com","DescribeQuickActionListItemResult",0,-1,true);

    private boolean quickActionListItems__is_set = false;

    private com.sforce.soap.partner.DescribeQuickActionListItemResult[] quickActionListItems = new com.sforce.soap.partner.DescribeQuickActionListItemResult[0];

    @Override
    public com.sforce.soap.partner.DescribeQuickActionListItemResult[] getQuickActionListItems() {
      return quickActionListItems;
    }

    @Override
    public void setQuickActionListItems(com.sforce.soap.partner.IDescribeQuickActionListItemResult[] quickActionListItems) {
      this.quickActionListItems = castArray(com.sforce.soap.partner.DescribeQuickActionListItemResult.class, quickActionListItems);
      quickActionListItems__is_set = true;
    }

    protected void setQuickActionListItems(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.isElement(__in, quickActionListItems__typeInfo)) {
        setQuickActionListItems((com.sforce.soap.partner.DescribeQuickActionListItemResult[])__typeMapper.readObject(__in, quickActionListItems__typeInfo, com.sforce.soap.partner.DescribeQuickActionListItemResult[].class));
      }
    }

    /**
     */
    @Override
    public void write(javax.xml.namespace.QName __element,
        com.sforce.ws.parser.XmlOutputStream __out, com.sforce.ws.bind.TypeMapper __typeMapper)
        throws java.io.IOException {
      __out.writeStartTag(__element.getNamespaceURI(), __element.getLocalPart());
      writeFields(__out, __typeMapper);
      __out.writeEndTag(__element.getNamespaceURI(), __element.getLocalPart());
    }

    protected void writeFields(com.sforce.ws.parser.XmlOutputStream __out,
         com.sforce.ws.bind.TypeMapper __typeMapper)
         throws java.io.IOException {
       __typeMapper.writeObject(__out, quickActionListItems__typeInfo, quickActionListItems, quickActionListItems__is_set);
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
        setQuickActionListItems(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[DescribeQuickActionListResult ");
      sb.append(" quickActionListItems='").append(com.sforce.ws.util.Verbose.toString(quickActionListItems)).append("'\n");
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
