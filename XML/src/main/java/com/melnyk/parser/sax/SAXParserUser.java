package com.melnyk.parser.sax;

import com.melnyk.model.Gem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class SAXParserUser {

  private static SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

  public static List<Gem> parseGems(File xml, File xsd) {
    List<Gem> gems = new ArrayList<>();
    try {
      saxParserFactory.setSchema(SAXValidator.createSchema(xsd));

      SAXParser saxParser = saxParserFactory.newSAXParser();
      SAXHandler saxHandler = new SAXHandler();
      saxParser.parse(xml, saxHandler);

      gems = saxHandler.getGems();
    } catch (SAXException | ParserConfigurationException | IOException ex) {
      ex.printStackTrace();
    }
    return gems;
  }
}
