package com.melnyk.parser.dom;

import com.melnyk.model.Gem;
import java.io.File;
import java.util.List;
import org.w3c.dom.Document;

public class DOMParserUser {

  public static List<Gem> getGemList(File xml, File xsd) {
    DOMDocCreator creator = new DOMDocCreator(xml);
    Document doc = creator.getDocument();

//        try {
//            DOMValidator.validate(DOMValidator.createSchema(xsd),doc);
//        }catch (IOException | SAXException ex){
//            ex.printStackTrace();
//        }

    DOMDocReader reader = new DOMDocReader();

    return reader.readDoc(doc);
  }
}
