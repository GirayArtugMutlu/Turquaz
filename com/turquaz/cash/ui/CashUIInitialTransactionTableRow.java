
package com.turquaz.cash.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group             */
/*                                                                      */
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.                                  */
/*                                                                      */
/* This program is distributed in the hope that it will be useful,      */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of       */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the        */
/* GNU General Public License for more details.                         */
/************************************************************************/
/**
 * @author Onsel
 * @version $Id$
 */

import java.math.BigDecimal;
import java.util.HashMap;

import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.CashKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

public class CashUIInitialTransactionTableRow implements ITableRow
{
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
    HashMap transRowInfo = new HashMap();
    
	public CashUIInitialTransactionTableRow()
	{
        transRowInfo.put(EngKeys.DEPT_AMOUNT,new BigDecimal(0));
        transRowInfo.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
		
	}

	public boolean canModify(int column_index)
	{
		if (column_index == 2 || column_index == 3)
		{
			return true;
		}
		return false;
	}

	public Color getColor()
	{
		if (okToSave())
		{
			return SWTResourceManager.getColor(198, 255, 198);
		}
		else
		{
			return SWTResourceManager.getColor(255, 198, 198);
		}
	}

	public String getColumnText(int column_index)
	{
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (okToSave())
				{
					result = transRowInfo.get(CashKeys.CASH_CARD_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = transRowInfo.get(EngKeys.DEFINITION).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 2 :
				result = cf.format(transRowInfo.get(EngKeys.DEPT_AMOUNT));
				break;
			case 3 :
				result = cf.format(transRowInfo.get(EngKeys.CREDIT_AMOUNT));
				break;
			default :
		}
		return result;
	}

	public Object getDBObject()
	{
		return transRowInfo;
	}

	public int getRowIndex()
	{
		return 0;
	}

	public Object getValue(int column_index)
	{
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (okToSave())
				{
					result = transRowInfo.get(CashKeys.CASH_CARD_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = transRowInfo.get(EngKeys.DEFINITION).toString();
				}
				else
				{
					result = "";
				}
				break;
		
			case 2 :
				result = cf.format(transRowInfo.get(EngKeys.DEPT_AMOUNT));
				break;
			case 3 :
				result = cf.format(transRowInfo.get(EngKeys.CREDIT_AMOUNT));
				break;
			default :
		}
		return result;
	}

	public void modify(int column_index, Object value)
	{
		String formatted = "";
		switch (column_index)
		{
			case 0 :
				break;
			case 1 :
				break;
			case 2 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
                transRowInfo.put(EngKeys.DEPT_AMOUNT,new BigDecimal(formatted));         
				break;
			case 3 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
                transRowInfo.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(formatted));
				break;
			default :
		}
	}

	public boolean okToSave()
	{
		if (transRowInfo.get(CashKeys.CASH_CARD_ID) == null)
		{
			return false;
		}
		return true;
	}

	public void setDBObject(Object obj)
	{
		if (obj instanceof HashMap)
		{
			transRowInfo = (HashMap) obj;
		}
	}

	public void setRowIndex(int index)
	{
	}
	int columnTypes[] = null;

	public int getColumnType(int index)
	{
		if (columnTypes == null)
		{
			return TurquazTableSorter.COLUMN_TYPE_STRING;
		}
		else
			return columnTypes[index];
	}

	public void setColumnTypes(int[] types)
	{
		columnTypes = types;
	}
	
	
}
