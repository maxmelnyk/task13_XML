package com.melnyk.parser.dom;

import com.melnyk.model.Gem;
import com.melnyk.model.VisualParameters;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMDocReader {

  public List<Gem> readDoc(Document doc) {
    doc.getDocumentElement().normalize();
    List<Gem> gems = new ArrayList<>();

    NodeList nodeList = doc.getElementsByTagName("gem");

    for (int i = 0; i < nodeList.getLength(); i++) {
      Gem gem = new Gem();
      VisualParameters parameters;

      Node node = nodeList.item(i);
      if (node.getNodeType() == Node.ELEMENT_NODE) {
        Element element = (Element) node;

        gem.setGemID(Integer.parseInt(element.getAttribute("gemID")));
        gem.setName(
            element.getElementsByTagName("name").item(0).getTextContent());
        gem.setPreciousness(element.getElementsByTagName("preciousness").item(0).getTextContent());
        gem.setOrigin(
            element.getElementsByTagName("origin").item(0).getTextContent());
        gem.setValue(Integer.parseInt(
            element.getElementsByTagName("value").item(0).getTextContent()));

        parameters = getParameters(element.getElementsByTagName("visualParameters"));

        gem.setVisualParameters(parameters);
        gems.add(gem);
      }
    }
    return gems;
  }

  private VisualParameters getParameters(NodeList nodes) {
    VisualParameters parameters = new VisualParameters();
    if (nodes.item(0).getNodeType() == Node.ELEMENT_NODE) {
      Element element = (Element) nodes.item(0);
      parameters.setColor(
          element.getElementsByTagName("color").item(0).getTextContent());
      parameters.setTransparency(Double.parseDouble(
          element.getElementsByTagName("transparency").item(0)
              .getTextContent()));
      parameters.setWayOfCutting(Integer.parseInt(
          element.getElementsByTagName("wayOfCutting").item(0)
              .getTextContent()));
    }
    return parameters;
  }
}
