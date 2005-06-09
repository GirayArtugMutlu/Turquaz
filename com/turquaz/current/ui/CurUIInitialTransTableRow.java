package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

public class CurUIInitialTransTableRow implements ITableRow
{
	HashMap curTransInfo = new HashMap();
	
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	public CurUIInitialTransTableRow()
	{
		try
		{
			curTransInfo.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
			curTransInfo.put(EngKeys.DEPT_AMOUNT,new BigDecimal(0));
			curTransInfo.put(EngKeys.CURRENCY_ID,EngBLCommon.getBaseCurrencyId());
		   	
			
		}
		catch (Exception ex)
		{
			Logger log = Logger.getLogger(CurUIInitialTransaction.class.getClass());
		}
	}

	public boolean canModify(int column_index)
	{
		if (column_index == 0)
		{
			return false;
		}
		return true;
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
					result =  curTransInfo.get(CurKeys.CUR_CURRENT_NAME) + " {" + curTransInfo.get(CurKeys.CUR_CURRENT_CODE) 
					+ "}";
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				result = cf.format(curTransInfo.get(EngKeys.DEPT_AMOUNT));
				break;
			case 2 :
				result = cf.format(curTransInfo.get(EngKeys.CREDIT_AMOUNT));
				break;
			default :
		}
		return result;
	}

	public Object getDBObject()
	{
		return curTransInfo;
	}

	public int getRowIndex()
	{
		return 0;
	}

	public Object getValue(int column_index)
	{
		Object result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (okToSave())
				{
					result = curTransInfo.get(CurKeys.CUR_CURRENT_NAME) + " {" + curTransInfo.get(CurKeys.CUR_CURRENT_CODE) 
							+ "}";
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				result = cf.format(curTransInfo.get(EngKeys.DEPT_AMOUNT));
				break;
			case 2 :
				result = cf.format(curTransInfo.get(EngKeys.CREDIT_AMOUNT));
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
			case 0 : // inventory code
				break;
			case 1 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				curTransInfo.put(EngKeys.DEPT_AMOUNT,new BigDecimal(formatted));
			
				break;
			case 2 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				curTransInfo.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(formatted));
				
				break;
			default :
		}
	}

	public boolean okToSave()
	{
		if (curTransInfo.get(CurKeys.CUR_CARD_ID) == null)
		{
			return false;
		}
		return true;
	}

	public void setDBObject(Object obj)
	{
		if (obj instanceof HashMap)
		{
			curTransInfo = (HashMap) obj;
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