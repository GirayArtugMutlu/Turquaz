package com.turquaz.bank.ui;

import java.math.BigDecimal;
import java.util.HashMap;

import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.BankKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

public class BankUIInitialTransactionTableRow implements ITableRow
{
	HashMap bankTrans = new HashMap();
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	public BankUIInitialTransactionTableRow()
	{
		bankTrans.put(EngKeys.DEPT_AMOUNT,new BigDecimal(0));
		bankTrans.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
	}

	public boolean canModify(int column_index)
	{
		if (column_index == 4 || column_index == 5)
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
					result = bankTrans.get(BankKeys.BANK_CODE).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 2 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_BRANCH_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 3 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_ACCOUNT_NO).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 4 :
				result = cf.format(bankTrans.get(EngKeys.DEPT_AMOUNT));
				break;
			case 5 :
				result = cf.format(bankTrans.get(EngKeys.CREDIT_AMOUNT));
				break;
			default :
		}
		return result;
	}

	public Object getDBObject()
	{
		return bankTrans;
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
					result = bankTrans.get(BankKeys.BANK_CODE).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 1 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 2 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_BRANCH_NAME).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 3 :
				if (okToSave())
				{
					result = bankTrans.get(BankKeys.BANK_ACCOUNT_NO).toString();
				}
				else
				{
					result = "";
				}
				break;
			case 4 :
				result = cf.format(bankTrans.get(EngKeys.DEPT_AMOUNT));
				break;
			case 5 :
				result = cf.format(bankTrans.get(EngKeys.CREDIT_AMOUNT));
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
				break;
			case 3 :
				break;
			case 4 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				bankTrans.put(EngKeys.DEPT_AMOUNT,new BigDecimal(formatted));
				break;
			case 5 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				bankTrans.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(formatted));
				break;
			default :
		}
	}

	public boolean okToSave()
	{
		if (bankTrans.get(BankKeys.BANK_TRANS_ID) == null)
		{
			return false;
		}
		return true;
	}

	public void setDBObject(Object obj)
	{
		if (obj instanceof HashMap)
		{
			bankTrans = (HashMap) obj;
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