package com.melnyk.parser;


import com.melnyk.comparator.GemComparator;
import com.melnyk.filechecker.ExtensionChecker;
import com.melnyk.model.Gem;
import com.melnyk.parser.dom.DOMParserUser;
import com.melnyk.parser.sax.SAXParserUser;
import com.melnyk.parser.stax.StAXReader;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class Parser {

  public static void main(String[] args) {
    File xml = new File("src\\main\\resources\\xml\\gem.xml");
    File xsd = new File("src\\main\\resources\\xml\\gemXSD.xsd");

    if (checkIfXML(xml) && checkIfXSD(xsd)) {
//            SAX
      printList(SAXParserUser.parseGems(xml, xsd), "SAX: sorted by transparency");

//            StAX
      printList(StAXReader.parseGems(xml, xsd), "StAX: sorted by transparency");

//            DOM
      printList(DOMParserUser.getGemList(xml, xsd), "DOM: sorted by transparency");
    }
  }

  private static boolean checkIfXSD(File xsd) {
    return ExtensionChecker.isXSD(xsd);
  }

  private static boolean checkIfXML(File xml) {
    return ExtensionChecker.isXML(xml);
  }

  private static void printList(List<Gem> gems, String parserName) {
    Collections.sort(gems, new GemComparator());
    System.out.println(parserName);
    for (Gem gem : gems) {
      System.out.println(gem);
    }
  }

}
