/*
 * Created on Mar 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.viewers;

import org.eclipse.swt.graphics.Color;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class SearchTableRow implements ITableRow
{
	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getColumnText(int)
	 */
	
	String itemText[] = null;
	Object dbObject = null;
	
	public SearchTableRow(String []text, Object data)
	{
		itemText = text;
		dbObject = data;
	}
	
	public String getColumnText(int column_index)
	{
		return itemText[column_index];
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getValue(int)
	 */
	public Object getValue(int column_index)
	{
		return itemText[column_index];
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#modify(int, java.lang.Object)
	 */
	public void modify(int column_index, Object value)
	{
     itemText[column_index] = value.toString();
		
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getColor()
	 */
	public Color getColor()
	{
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#canModify(int)
	 */
	public boolean canModify(int column_index)
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#setRowIndex(int)
	 */
	public void setRowIndex(int index)
	{
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getRowIndex()
	 */
	public int getRowIndex()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#okToSave()
	 */
	public boolean okToSave()
	{
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getDBObject()
	 */
	public Object getDBObject()
	{
		
		return dbObject;
		
	}

	/* (non-Javadoc)
	 * @see com.turquaz.engine.ui.viewers.ITableRow#setDBObject(java.lang.Object)
	 */
	public void setDBObject(Object obj)
	{
		dbObject = obj;
	}
}
