/*
 * Created on Oct 22, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.io.*;
import org.xml.sax.InputSource;
import java.util.List;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.*;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLXmlParser {
	
	  Document myDocument;
	  Map treeInfo = null;
	
	  public EngBLXmlParser(String myFile) {
		try {
		  SAXBuilder myBuilder = new SAXBuilder();
		  InputSource input = new InputSource(new FileReader(myFile));
		  myDocument = myBuilder.build(input);
		  createMap();
		 
		}
		catch (Exception e) {
		  e.printStackTrace();
		}

	  }
	  
	  
	  public Map createMap(){
	  
	
	  treeInfo = new HashMap();
	  
	  Element root = myDocument.getRootElement();
	  List items = root.getChildren("treeitem");
	  
      String text ="";
      String className ="";
     
      for(int i=0;i<items.size();i++){
      	Element info =(Element)items.get(i);
      	
      	text = info.getAttributeValue("text");
      	className = info.getAttributeValue("class"); 
	 	treeInfo.put(text,className);   
      }
	  
	  return treeInfo;
	  
	  
	  
	  }
	  


}
