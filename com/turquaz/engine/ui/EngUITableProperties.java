/*
 * Created on Mar 21, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.xml.sax.InputSource;

import com.turquaz.engine.bl.EngBLLogger;

/**
 * @author onsel 
 */
public class EngUITableProperties
{
	public Document tableDoc;
	static EngUITableProperties _instance;

	public EngUITableProperties() throws Exception
	{
		
		File prop_dir = new File(System.getProperty("user.home")+"/.turquaz");
		if(!prop_dir.exists())
		{
			prop_dir.mkdir();
		}
		
		
		File file = new File(System.getProperty("user.home")+"/.turquaz/table_props.xml");
		if (!file.exists())
		{
			XMLOutputter outputter = new XMLOutputter();
			OutputStream output = null;
			output = new FileOutputStream(System.getProperty("user.home")+"/.turquaz/table_props.xml"); //$NON-NLS-1$
			Element root = new Element("props");
			outputter.output(root, output);
			output.close();
		}
		SAXBuilder myBuilder = new SAXBuilder();
		InputSource input = new InputSource(System.getProperty("user.home")+"/.turquaz/table_props.xml");
		tableDoc = myBuilder.build(input);
		if (!tableDoc.hasRootElement())
		{
			Element root = new Element("props");
			tableDoc.setRootElement(root);
		}
	}

	public static Map getTableWidthMap(String tableName) throws Exception
	{
		Map columnWidths = new HashMap();
		if (_instance == null)
		{
			_instance = new EngUITableProperties();
		}
		Element root = _instance.tableDoc.getRootElement();
		Element table = root.getChild(tableName);
		if (table == null)
		{
			return null;
		}
		List children = table.getChildren("column");
		Iterator it = children.iterator();
		while (it.hasNext())
		{
			Element child = (Element) it.next();
			String index = child.getAttributeValue("index");
			String width = child.getAttributeValue("width");
			columnWidths.put(index, width);
		}
		return columnWidths;
	}

	public static void setTableWidthMap(String tableName, Map widths) throws Exception
	{
		if (_instance == null)
		{
			_instance = new EngUITableProperties();
		}
		Element root = _instance.tableDoc.getRootElement();
		Element table = root.getChild(tableName);
		if (table == null)
		{
			table = new Element(tableName);
			root.addContent(table);
		}
		else
		{
			table.removeChildren("column");
		}
		Iterator it = widths.keySet().iterator();
		while (it.hasNext())
		{
			String index = it.next().toString();
			String width = widths.get(index).toString();
			Element child = new Element("column");
			child.setAttribute("index", index);
			child.setAttribute("width", width);
			table.addContent(child);
		}
	}

	public static void saveToFile()
	{
		try
		{
			if (_instance == null)
			{
				_instance = new EngUITableProperties();
			}
			Format format = Format.getPrettyFormat();
			XMLOutputter outputter = new XMLOutputter(format);
			OutputStream output = null;
			output = new FileOutputStream(System.getProperty("user.home")+"/.turquaz/table_props.xml"); //$NON-NLS-1$
			outputter.output(_instance.tableDoc, output);
			output.close();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngUITableProperties.class,ex);
		}
	}
}