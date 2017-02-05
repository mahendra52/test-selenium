package com.cleartrip.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Xmlreader {

	@Test
	
	public static void gettingData() throws ParserConfigurationException, SAXException, IOException{
		
		File file=new File("I:\\selinum\\POM\\src\\com\\cleartrip\\testdata\\TestData.xml");
		DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dFactory.newDocumentBuilder();
		Document document=dBuilder.parse(file);
		
		NodeList nList=document.getElementsByTagName("book");
		for(int i=0;i<nList.getLength();i++){
         Node node=nList.item(i);
         Element element=(Element) node.getAttributes();
         
	/*	DocumentBuilderFactory dFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder=dFactory.newDocumentBuilder();
		Document document=dBuilder.parse(file);
		Element element=document.getDocumentElement();
		//System.out.println("element is" +element);
		NodeList nlist=document.getElementsByTagName("book");
		for(int i=0;i<nlist.getLength();i++){
			Node node=nlist.item(i);
			System.out.println(node.getTextContent());*/
			
		}
		
		
	}
	
	
}
