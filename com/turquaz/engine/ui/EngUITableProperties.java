/*
 * Created on Mar 21, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngUITableProperties
{
	public Document tableDoc;
	static EngUITableProperties _instance;
	
	public EngUITableProperties()throws Exception
	{
		
		SAXBuilder myBuilder = new SAXBuilder();
		InputSource input = new InputSource("config/table_props.xml");
		tableDoc = myBuilder.build(input);	
		if(!tableDoc.hasRootElement())
		{
			Element root = new Element("props");
			tableDoc.setRootElement(root);
		}
		
	}	
	
	public static Map getTableWidthMap(String tableName)throws Exception
	{
		Map columnWidths = new HashMap();
		if(_instance == null)
		{
			_instance = new EngUITableProperties();
		}
		
		Element root = _instance.tableDoc.getRootElement();
	
		Element table = root.getChild(tableName);
		
		if(table == null)
		{
			return null;
		}
		
		List children = table.getChildren("column");
		Iterator it = children.iterator(); 
		while(it.hasNext())
		{			
		
			Element child = (Element)it.next();
			String index = child.getAttributeValue("index");
			String width = child.getAttributeValue("width");
			columnWidths.put(index,width);
			
		}
			
		
		return columnWidths;
		
	}
	
	public static void setTableWidthMap(String tableName,Map widths)throws Exception
	{
		if(_instance == null)
		{
			_instance = new EngUITableProperties();
		}
		
		Element root = _instance.tableDoc.getRootElement();
		
		Element table = root.getChild(tableName);
			
		if(table == null)
		{
			table = new Element(tableName);
			root.addContent(table);			
			
		}
		else
		{
			table.removeChildren("column");
		}
		Iterator it = widths.keySet().iterator();
		while(it.hasNext())
		{
			String index  = it.next().toString();
			String width  = widths.get(index).toString();
			Element child = new Element("column");
			child.setAttribute("index",index);
			child.setAttribute("width",width);
			table.addContent(child);			
			
		}
			
		
		
	}
	public static void saveToFile()
	{
		try{
		XMLOutputter outputter = new XMLOutputter();
		outputter.setExpandEmptyElements(true);
		outputter.setNewlines(false);	
		OutputStream output = null;
		output = new FileOutputStream("config/table_props.xml"); //$NON-NLS-1$
		outputter.output(_instance.tableDoc, output);
		output.close();	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	
}
