package com.ip.dfs;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.ip.dfs.common.Constant;
import com.ip.dfs.service.DFSService;

public class Test {
	static DFSService dfsService;
	static{
		
		try {
			dfsService = (DFSService)Naming.lookup("rmi://"+"127.0.0.1"+":"+"1100"+"/"+Constant.DFS_SERVICE_FACADE);
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			factory.setValidating(false);
			SAXParser saxParser = factory.newSAXParser();
			XMLReader xmlReader = saxParser.getXMLReader();
			
			xmlReader.setContentHandler(null);
			xmlReader.setErrorHandler(null);
			xmlReader.setDTDHandler(null);
			xmlReader.setEntityResolver(null);
			xmlReader.parse("");
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
