package com.melnyk.parser.sax;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;

public class SAXValidator {

  public static Schema createSchema(File xsd) {
    Schema schema = null;
    try {
      String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
      SchemaFactory factory = SchemaFactory.newInstance(language);
      schema = factory.newSchema(xsd);
    } catch (SAXException ex) {
      ex.printStackTrace();
    }

    return schema;
  }
}
