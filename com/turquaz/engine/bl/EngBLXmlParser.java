/*
 * Created on Oct 22, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Onsel Armagan
* @version  $Id$
*/
import java.io.*;
import org.xml.sax.InputSource;
import java.util.List;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;


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
