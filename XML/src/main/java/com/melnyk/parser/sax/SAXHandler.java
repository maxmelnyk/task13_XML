package com.melnyk.parser.sax;


import com.melnyk.model.Gem;
import com.melnyk.model.VisualParameters;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {

  private List<Gem> gems = new ArrayList<>();
  private Gem gem = null;
  private VisualParameters visualParameters = null;

  private boolean bName = false;
  private boolean bPreciousness = false;
  private boolean bOrigin = false;
  private boolean bParameters = false;
  private boolean bColor = false;
  private boolean bTransparency = false;
  private boolean bWayOfCutting = false;
  private boolean bValue = false;

  public List<Gem> getGems() {
    return this.gems;
  }

  public void startElement(String uri, String localName, String qName, Attributes attributes) {
    if (qName.equalsIgnoreCase("gem")) {
      String gemID = attributes.getValue("gemID");
      gem = new Gem();
      gem.setGemID(Integer.parseInt(gemID));
    } else if (qName.equalsIgnoreCase("name")) {
      bName = true;
    } else if (qName.equalsIgnoreCase("preciousness")) {
      bPreciousness = true;
    } else if (qName.equalsIgnoreCase("origin")) {
      bOrigin = true;
    } else if (qName.equalsIgnoreCase("visualParameters")) {
      bParameters = true;
    } else if (qName.equalsIgnoreCase("color")) {
      bColor = true;
    } else if (qName.equalsIgnoreCase("transparency")) {
      bTransparency = true;
    } else if (qName.equalsIgnoreCase("wayOfCutting")) {
      bWayOfCutting = true;
    } else if (qName.equalsIgnoreCase("value")) {
      bValue = true;
    }
  }

  public void endElement(String uri, String localName, String qName) {
    if (qName.equalsIgnoreCase("gem")) {
      gems.add(gem);
    }
  }

  public void characters(char[] ch, int start, int length) {
    if (bName) {
      gem.setName(new String(ch, start, length));
      bName = false;
    } else if (bPreciousness) {
      gem.setPreciousness(new String(ch, start, length));
      bPreciousness = false;
    } else if (bOrigin) {
      gem.setOrigin(new String(ch, start, length));
      bOrigin = false;
    } else if (bParameters) {
      visualParameters = new VisualParameters();
      bParameters = false;
    } else if (bColor) {
      visualParameters.setColor(new String(ch, start, length));
      bColor = false;
    } else if (bTransparency) {
      visualParameters
          .setTransparency(Double.parseDouble(new String(ch, start, length)));
      bTransparency = false;
    } else if (bWayOfCutting) {
      visualParameters
          .setWayOfCutting(Integer.parseInt(new String(ch, start, length)));
      gem.setVisualParameters(visualParameters);
      bWayOfCutting = false;
    } else if (bValue) {
      gem.setValue(Integer.parseInt(new String(ch, start, length)));
      bValue = false;
    }
  }
}

