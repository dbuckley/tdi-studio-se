package com.sforce.soap.partner;

/**
 * Generated by ComplexTypeCodeGenerator.java. Please do not edit.
 */
public class FieldDiff implements com.sforce.ws.bind.XMLizable , IFieldDiff{

    /**
     * Constructor
     */
    public FieldDiff() {}

    /**
     * element : difference of type {urn:partner.soap.sforce.com}differenceType
     * java type: com.sforce.soap.partner.DifferenceType
     */
    private static final com.sforce.ws.bind.TypeInfo difference__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","difference","urn:partner.soap.sforce.com","differenceType",1,1,true);

    private boolean difference__is_set = false;

    private com.sforce.soap.partner.DifferenceType difference;

    @Override
    public com.sforce.soap.partner.DifferenceType getDifference() {
      return difference;
    }

    @Override
    public void setDifference(com.sforce.soap.partner.DifferenceType difference) {
      this.difference = difference;
      difference__is_set = true;
    }

    protected void setDifference(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, difference__typeInfo)) {
        setDifference((com.sforce.soap.partner.DifferenceType)__typeMapper.readObject(__in, difference__typeInfo, com.sforce.soap.partner.DifferenceType.class));
      }
    }

    /**
     * element : name of type {http://www.w3.org/2001/XMLSchema}string
     * java type: java.lang.String
     */
    private static final com.sforce.ws.bind.TypeInfo name__typeInfo =
      new com.sforce.ws.bind.TypeInfo("urn:partner.soap.sforce.com","name","http://www.w3.org/2001/XMLSchema","string",1,1,true);

    private boolean name__is_set = false;

    private java.lang.String name;

    @Override
    public java.lang.String getName() {
      return name;
    }

    @Override
    public void setName(java.lang.String name) {
      this.name = name;
      name__is_set = true;
    }

    protected void setName(com.sforce.ws.parser.XmlInputStream __in,
        com.sforce.ws.bind.TypeMapper __typeMapper) throws java.io.IOException, com.sforce.ws.ConnectionException {
      __in.peekTag();
      if (__typeMapper.verifyElement(__in, name__typeInfo)) {
        setName(__typeMapper.readString(__in, name__typeInfo, java.lang.String.class));
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
       __typeMapper.writeObject(__out, difference__typeInfo, difference, difference__is_set);
       __typeMapper.writeString(__out, name__typeInfo, name, name__is_set);
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
        setDifference(__in, __typeMapper);
        setName(__in, __typeMapper);
    }

    @Override
    public String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder();
      sb.append("[FieldDiff ");
      sb.append(" difference='").append(com.sforce.ws.util.Verbose.toString(difference)).append("'\n");
      sb.append(" name='").append(com.sforce.ws.util.Verbose.toString(name)).append("'\n");
      sb.append("]\n");
      return sb.toString();
    }

}
