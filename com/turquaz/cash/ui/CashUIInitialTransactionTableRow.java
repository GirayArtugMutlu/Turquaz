/*
 * Created on Apr 11, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.cash.ui;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CashUIInitialTransactionTableRow implements ITableRow
{
	TurqCashTransactionRow cashTransRow = new TurqCashTransactionRow();
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	public CashUIInitialTransactionTableRow()
	{
		cashTransRow.setDeptAmount(new BigDecimal(0));
		cashTransRow.setCreditAmount(new BigDecimal(0));
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
					result = cashTransRow.getTurqCashCard().getCashCardName();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = cashTransRow.getTurqCashCard().getCashCardDefinition();
				}
				else
				{
					result = "";
				}
				break;
			case 2 :
				result = cf.format(cashTransRow.getDeptAmount());
				break;
			case 3 :
				result = cf.format(cashTransRow.getCreditAmount());
				break;
			default :
		}
		return result;
	}

	public Object getDBObject()
	{
		return cashTransRow;
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
					result = cashTransRow.getTurqCashCard().getCashCardName();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = cashTransRow.getTurqCashCard().getCashCardDefinition();
				}
				else
				{
					result = "";
				}
				break;
		
			case 2 :
				result = cf.format(cashTransRow.getDeptAmount());
				break;
			case 3 :
				result = cf.format(cashTransRow.getCreditAmount());
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
				cashTransRow.setDeptAmount(new BigDecimal(formatted));
				break;
			case 3 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				cashTransRow.setCreditAmount(new BigDecimal(formatted));
				break;
			default :
		}
	}

	public boolean okToSave()
	{
		if (cashTransRow.getTurqCashTransaction() == null)
		{
			return false;
		}
		return true;
	}

	public void setDBObject(Object obj)
	{
		if (obj instanceof TurqCashTransactionRow)
		{
			cashTransRow = (TurqCashTransactionRow) obj;
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
