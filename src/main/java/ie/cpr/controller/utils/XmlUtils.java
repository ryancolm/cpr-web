package ie.cpr.controller.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * Created by colm.ryan on 01/09/2014.
 */
public class XmlUtils {

  public XmlUtils(){}


  public static void main(String[] args) throws Exception {

    XmlUtils xmlUtils = new XmlUtils();
    
  }

  public Document getXmlDocument(String xml) throws Exception {
    DocumentBuilderFactory dbf =
        DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xml));

    Document document = db.parse(is);
    //deletePerson(doc, "Person 3");
    printXML(document);

    describeElement(document);
    return document;
  }

  public static void describeElement(Document doc) {
    System.out.println("describeElement");

    // <person>
   // NodeList nodes = doc.getElementsByTagName(elementName);

    NodeList nodes = doc.getChildNodes();
    System.out.println("number of nodes " + nodes.getLength());

    for (int i = 0; i < nodes.getLength(); i++) {
      Element element = (Element)nodes.item(i);


      NodeList childNodes = element.getElementsByTagName("objTrainPositions");
      System.out.println("number of child nodes " + childNodes.getLength());

      for (int x = 0; x < childNodes.getLength(); x++) {
        Element childElement = (Element)childNodes.item(i);
        System.out.println(childElement.getTagName());
      }

      // <name>
      System.out.println(element.getTagName());

      Element name = (Element)element.getElementsByTagName("name").item(0);



//      String pName = name.getTextContent();
//      if (pName.equals(elementName)) {
//        element.getParentNode().removeChild(element);
//      }
    }
  }

  public static void printXML(Document doc)
      throws TransformerException {
    System.out.println("printing the xml from the doc");

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);

    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);
  }

  public String removeVersionString(String xml){
    return xml.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();

  }

  public NodeList getChildNodes(Document document , int elementIndex, String tagName) {
    NodeList immediateChildren = document.getChildNodes();
    Element element = (Element)immediateChildren.item(elementIndex);
    NodeList childNodes = element.getElementsByTagName(tagName);
    return childNodes;
  }

  public Document createDocument(NodeList nodes) {
    Document newXmlDocument = null;
    try {
      newXmlDocument = DocumentBuilderFactory.newInstance()
          .newDocumentBuilder().newDocument();

      Element root = newXmlDocument.createElement("root");
      newXmlDocument.appendChild(root);
      for (int i = 0; i < nodes.getLength(); i++) {
        Node node = nodes.item(i);
        Node copyNode = newXmlDocument.importNode(node, true);
        root.appendChild(copyNode);
      }
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    return newXmlDocument;
  }

  public String getXML(Document doc)
      throws TransformerException {
    System.out.println("printing the xml from the doc");

    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");

    StreamResult result = new StreamResult(new StringWriter());
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);

    String xmlString = result.getWriter().toString();
    System.out.println(xmlString);
    return xmlString;
  }





}
