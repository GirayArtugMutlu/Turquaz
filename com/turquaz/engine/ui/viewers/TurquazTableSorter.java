package com.turquaz.engine.ui.viewers;

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
 * @author Onsel
 * @version $Id$
 */
import java.math.BigDecimal;
import java.util.Date;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import com.turquaz.engine.ui.component.DatePicker;

public class TurquazTableSorter extends ViewerSorter
{
	public final static int COLUMN_TYPE_STRING = 0;
	public final static int COLUMN_TYPE_INT = 1;
	public final static int COLUMN_TYPE_DATE = 2;
	public final static int COLUMN_TYPE_DECIMAL = 3;
	private boolean ascending = false;
	int columnIndex;
	int columnType;

	public TurquazTableSorter(int creteria, int type)
	{
		super();
		this.columnIndex = creteria;
		columnType = type;
	}

	public boolean getAscending()
	{
		return ascending;
	}

	public void setAscending(boolean ascending)
	{
		this.ascending = ascending;
	}

	public int compare(Viewer arg0, Object arg1, Object arg2)
	{
		try
		{
			ITableRow row1;
			ITableRow row2;
			if (ascending)
			{
				row1 = (ITableRow) arg1;
				row2 = (ITableRow) arg2;
				if (row1.getDBObject() == null && row2.getDBObject() == null)
					return 0;
				else if (row1.getDBObject() == null)
					return 1;
				else if (row2.getDBObject() == null)
					return -1;
			}
			else
			{
				row2 = (ITableRow) arg1;
				row1 = (ITableRow) arg2;
				if (row1.getDBObject() == null && row2.getDBObject() == null)
					return 0;
				else if (row1.getDBObject() == null)
					return -1;
				else if (row2.getDBObject() == null)
					return 1;
			}
			if (columnType == TurquazTableSorter.COLUMN_TYPE_STRING)
			{
				return collator.compare(row1.getColumnText(columnIndex), row2.getColumnText(columnIndex));
			}
			else if (columnType == TurquazTableSorter.COLUMN_TYPE_INT)
			{
				Integer num1 = new Integer(row1.getColumnText(columnIndex));
				Integer num2 = new Integer(row2.getColumnText(columnIndex));
				return num1.compareTo(num2);
			}
			else if (columnType == TurquazTableSorter.COLUMN_TYPE_DECIMAL)
			{
				String num1str = row1.getColumnText(columnIndex);
				String num2str = row2.getColumnText(columnIndex);
				BigDecimal dec1;
				BigDecimal dec2;
				num1str = num1str.replaceAll("\\.", "");
				num1str = num1str.replaceAll(",", ".");
				if (num1str.equals(""))
				{
					num1str = "0";
				}
				dec1 = new BigDecimal(num1str);
				num2str = num2str.replaceAll("\\.", "");
				num2str = num2str.replaceAll(",", ".");
				if (num2str.equals(""))
				{
					num2str = "0";
				}
				dec2 = new BigDecimal(num2str);
				return dec1.compareTo(dec2);
			}
			else if (columnType == TurquazTableSorter.COLUMN_TYPE_DATE)
			{
				String num1str = row1.getColumnText(columnIndex);
				String num2str = row2.getColumnText(columnIndex);
				Date date1 = DatePicker.formatter.parse(num1str);
				Date date2 = DatePicker.formatter.parse(num2str);
				return date1.compareTo(date2);
			}
			else
			{
				return 0;
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return 0;
		}
	}
}