package app.weather.utilities;

import javax.xml.parsers.*;
import org.xml.sax.InputSource;
import org.w3c.dom.*;
import java.io.*;
import java.util.ArrayList;

public class ParseXMLString {

//  public static void main(String arg[]) {
//		String xmlRecords = "<?xml version=\"1.0\"?><NewDataSet><Table> <Country>United Kingdom</Country> <City>Belfast / Aldergrove Airport</City>"+
//"</Table><Table> <Country>United Kingdom</Country> <City>Belfast / Harbour</City></Table></NewDataSet>";
//
//    try {
//    	ArrayList<String> cityList = new ArrayList<String>();
//        DocumentBuilderFactory dbf =
//            DocumentBuilderFactory.newInstance();
//        DocumentBuilder db = dbf.newDocumentBuilder();
//        InputSource is = new InputSource();
//        is.setCharacterStream(new StringReader(xmlRecords));
//
//        Document doc = db.parse(is);
//        NodeList nodes = doc.getElementsByTagName("Table");
//
//        // iterate the employees
//        for (int i = 0; i < nodes.getLength(); i++) {
//           Element element = (Element) nodes.item(i);
//
//           NodeList name = element.getElementsByTagName("Country");
//           Element line = (Element) name.item(0);
//           System.out.println("Country: " + getCharacterDataFromElement(line));
//          
//           NodeList title = element.getElementsByTagName("City");
//           line = (Element) title.item(0);
//           System.out.println("City: " + getCharacterDataFromElement(line));
//           cityList.add(getCharacterDataFromElement(line));
//        }
//    }
//    catch (Exception e) {
//        e.printStackTrace();
//    }
//   
//    
//  }

  public static String getCharacterDataFromElement(Element e) {
    Node child = e.getFirstChild();
    if (child instanceof CharacterData) {
       CharacterData cd = (CharacterData) child;
       return cd.getData();
    }
    return "?";
  }
  
  public static ArrayList<String> getCityFromXML(String xmlRecords) {
	  ArrayList<String> cityList = new ArrayList<String>();
	  try {
	    	
	        DocumentBuilderFactory dbf =
	            DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        InputSource is = new InputSource();
	        is.setCharacterStream(new StringReader(xmlRecords));

	        Document doc = db.parse(is);
	        NodeList nodes = doc.getElementsByTagName("Table");

	        // iterate the employees
	        for (int i = 0; i < nodes.getLength(); i++) {
	           Element element = (Element) nodes.item(i);

	           NodeList name = element.getElementsByTagName("Country");
	           Element line = (Element) name.item(0);
	          
	           NodeList title = element.getElementsByTagName("City");
	           line = (Element) title.item(0);
	           cityList.add(getCharacterDataFromElement(line));
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	return cityList;
  }
}
