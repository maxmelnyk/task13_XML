package com.melnyk.parser.stax;

import com.melnyk.model.Gem;
import com.melnyk.model.VisualParameters;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXReader {

  public static List<Gem> parseGems(File xml, File xsd) {
    List<Gem> gems = new ArrayList<>();
    Gem gem = null;
    VisualParameters visualParameters = null;

    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    try {
      XMLEventReader xmlEventReader = xmlInputFactory.createXMLEventReader(new FileInputStream(xml));
      while (xmlEventReader.hasNext()) {
        XMLEvent xmlEvent = xmlEventReader.nextEvent();
        if (xmlEvent.isStartElement()) {
          StartElement startElement = xmlEvent.asStartElement();
          String name = startElement.getName().getLocalPart();
          switch (name) {
            case "gem":
              gem = new Gem();

              Attribute idAttr = startElement.getAttributeByName(new QName("gemID"));
              if (idAttr != null) {
                gem.setGemID(Integer.parseInt(idAttr.getValue()));
              }
              break;
            case "name":
              xmlEvent = xmlEventReader.nextEvent();
              assert gem != null;
              gem.setName(xmlEvent.asCharacters().getData());
              break;
            case "preciousness":
              xmlEvent = xmlEventReader.nextEvent();
              assert gem != null;
              gem.setPreciousness(xmlEvent.asCharacters().getData());
              break;
            case "origin":
              xmlEvent = xmlEventReader.nextEvent();
              assert gem != null;
              gem.setOrigin(xmlEvent.asCharacters().getData());
              break;
            case "visualParameters":
              xmlEvent = xmlEventReader.nextEvent();
              visualParameters = new VisualParameters();
              break;
            case "color":
              xmlEvent = xmlEventReader.nextEvent();
              assert visualParameters != null;
              visualParameters.setColor(xmlEvent.asCharacters().getData());
              break;
            case "transparency":
              xmlEvent = xmlEventReader.nextEvent();
              assert visualParameters != null;
              visualParameters.setTransparency(Double.parseDouble(xmlEvent.asCharacters().getData()));
              break;
            case "wayOfCutting":
              xmlEvent = xmlEventReader.nextEvent();
              assert visualParameters != null;
              visualParameters.setWayOfCutting(Integer.parseInt(xmlEvent.asCharacters().getData()));
              gem.setVisualParameters(visualParameters);
              break;
            case "value":
              xmlEvent = xmlEventReader.nextEvent();
              assert gem != null;
              gem.setValue(Integer.parseInt(xmlEvent.asCharacters().getData()));
              break;
          }
        }

        if (xmlEvent.isEndElement()) {
          EndElement endElement = xmlEvent.asEndElement();
          if (endElement.getName().getLocalPart().equals("gem")) {
            gems.add(gem);
          }
        }
      }
    } catch (FileNotFoundException | XMLStreamException e) {
      e.printStackTrace();
    }
    return gems;
  }
}
