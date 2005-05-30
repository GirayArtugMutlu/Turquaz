package com.turquaz.accounting.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;

public class AccUITransactionCollectTableRow implements ITableRow
{
	String formatted = "";
	TableRowList rowList;
	int columnTypes[] = null;
	int row_index = 0;
	private HashMap transRow=new HashMap();
	
	public AccUITransactionCollectTableRow(TableRowList rowList)
	{
		super();
		this.rowList = rowList;

		transRow.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(0));
		transRow.put(EngKeys.DEPT_AMOUNT,new BigDecimal(0));
		transRow.put(AccKeys.ACC_TRANS_ROW_DEFINITION,"");
	}

	public void setRowIndex(int a)
	{
		row_index = a;
	}

	public int getRowIndex()
	{
		return row_index;
	}

	public Color getColor()
	{
		if (transRow.get(AccKeys.ACC_ACCOUNT_ID) == null)
		{
			return SWTResourceManager.getColor(255, 198, 198);
		}
		else
		{
			return SWTResourceManager.getColor(198, 255, 198);
		}
	}

	public boolean canModify(int column_index)
	{
		if (column_index == 1)
		{
			return false;
		}
		return true;
	}

	public String getColumnText(int column_index)
	{
		TurkishCurrencyFormat df = new TurkishCurrencyFormat();
		String result = "";
		HashMap accountMap=(HashMap)transRow.get(AccKeys.ACC_ACCOUNT_ID);
		switch (column_index)
		{
			case 0 :
				if (accountMap != null)
				{
					result = (String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE);
				}
				break;
			case 1 :
				if (accountMap != null)
					result = (String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME);
				break;
			case 2 :
				result = (String)transRow.get(AccKeys.ACC_TRANS_ROW_DEFINITION);
				break;
			case 3 :
				result = df.format((BigDecimal)transRow.get(EngKeys.CREDIT_AMOUNT));
				break;

			default :
				result = "";
		}
		return result;
	}

	public Object getValue(int column_index)
	{
		Object result = null;
		HashMap accountMap=(HashMap)transRow.get(AccKeys.ACC_ACCOUNT_ID);
		switch (column_index)
		{
			case 0 :
				if (accountMap != null)
				{
					result =(String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE);
				}
				else
					result = "";
				break;
			case 1 :
				if (accountMap != null)
				{
					result = (String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME);
				}
				else
					result = "";
				break;
			case 2 :
				result = (String)transRow.get(AccKeys.ACC_TRANS_ROW_DEFINITION);
				break;
			case 3 :
				result = result =transRow.get(EngKeys.CREDIT_AMOUNT).toString();
				result = ((String) result).replaceAll("\\.", ",");
				break;

			default :
				result = "";
		}
		return result;
	}

	public void modify(int column_index, Object value)
	{
		switch (column_index)
		{
			case 0 : //Hesap Kodu
				try
				{
					HashMap accountMap = EngBLAccountingAccounts.getAccount(value.toString().trim());
					if (accountMap != null)
					{
						transRow.put(AccKeys.ACC_ACCOUNT_ID,accountMap);

					}
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(this.getClass(),ex);
				}
				break;
			case 1 :
				break;
			case 3 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				transRow.put(EngKeys.CREDIT_AMOUNT,new BigDecimal(formatted));
				break;
			case 2 :
				transRow.put(AccKeys.ACC_TRANS_ROW_DEFINITION,value.toString());
				break;
		}
		rowList.taskChanged(this);
	}

	public boolean equals(Object other)
	{
		if (other instanceof ITableRow)
		{
			ITableRow row = (ITableRow) other;
			if (getRowIndex() == row.getRowIndex())
			{
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	public Object getDBObject()
	{
        if(okToSave())
        {
            return transRow;
        }
        else
            return null;
	}

	public void setDBObject(Object transRow)
	{
		this.transRow = (HashMap) transRow;
	}

	public void setTransRow(HashMap transRow)
	{
		this.transRow = transRow;
	}

	public boolean okToSave()
	{
		if (transRow.get(AccKeys.ACC_ACCOUNT_ID) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

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