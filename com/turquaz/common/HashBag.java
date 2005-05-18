/*
 * Created on May 17, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.common;

import java.sql.ResultSet;
import java.util.HashMap;


/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HashBag
{
	private HashMap content;
	
	public HashBag()
	{
		content=new HashMap();
	}
	
	public void put(Object key, Object value)
	{
		content.put(key,value);
	}
	
	public void put(Object key, int row, Object value)
	{
		HashMap keyMap=(HashMap)content.get(key);
		if (keyMap==null)
		{
			keyMap=new HashMap();
		}
		keyMap.put(new Integer(row),value);
		content.put(key,keyMap);
	}
	
	public void put(Object key, int rowInt, int columnInt, Object value)
	{
		HashMap keyMap=(HashMap)content.get(key);
		HashMap rowMap;
		Integer row=new Integer(rowInt);
		Integer column=new Integer(columnInt);
		if (keyMap==null)
		{
			keyMap=new HashMap();
			rowMap=new HashMap();
			rowMap.put(column, value);
		}
		else
		{
			rowMap=(HashMap)keyMap.get(row);
			if (rowMap==null)
			{
				rowMap=new HashMap();
			}
			rowMap.put(column, value);
		}
		keyMap.put(row,rowMap);		
		content.put(key,keyMap);
	}
	
	public void put(Object key, int rowInt, String column, Object value)
	{
		HashMap keyMap=(HashMap)content.get(key);
		HashMap rowMap;
		Integer row=new Integer(rowInt);
		if (keyMap==null)
		{
			keyMap=new HashMap();
			rowMap=new HashMap();
			rowMap.put(column, value);
		}
		else
		{
			rowMap=(HashMap)keyMap.get(row);
			if (rowMap==null)
			{
				rowMap=new HashMap();
			}
			rowMap.put(column, value);
		}
		keyMap.put(row,rowMap);	
		content.put(key,keyMap);
	}
	
	public void put(Object key, ResultSet rs, int length) throws Exception
	{
		HashMap keyMap=new HashMap();
		int row=0;
		while(rs.next())
		{
			HashMap rowMap=new HashMap();
			for(int k=0; k<length; k++)
			{
				rowMap.put(new Integer(k),rs.getObject(k));
			}
			keyMap.put(new Integer(row),rowMap);		
			row++;
		}
		content.put(key,keyMap);
	}
	
	public void put(Object key, ResultSet rs, String[] columnNames) throws Exception
	{
		HashMap keyMap=new HashMap();
		int row=0;
		while(rs.next())
		{
			HashMap rowMap=new HashMap();
			for(int k=0; k<columnNames.length; k++)
			{
				rowMap.put(columnNames[k],rs.getObject(columnNames[k]));
			}
			keyMap.put(new Integer(row),rowMap);		
			row++;
		}
		content.put(key,keyMap);
	}
	
	public Object get(Object key)
	{
		return content.get(key);
	}
	
	public int size()
	{
		return content.size();
	}
}
