/* Created on Mar 9, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui;

import java.util.HashMap;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.accounting.AccKeys;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;

public class InvUIInvAccountingAccTableRow implements ITableRow
{
	String formatted = "";
	TableRowList rowList;
	int row_index = 0;
	private HashMap invAccRow = new HashMap();

	public InvUIInvAccountingAccTableRow(TableRowList rowList, HashMap typeMap)
	{
		super();
		this.rowList = rowList;
		this.invAccRow.put(InvKeys.INV_ACC_TYPE,typeMap);
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
		if (invAccRow.get(AccKeys.ACC_ACCOUNT) == null)
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
		if (column_index == 0)
		{
			return false;
		}
		return true;
	}

	public String getColumnText(int column_index)
	{
		TurkishCurrencyFormat df = new TurkishCurrencyFormat();
		String result = "";
		switch (column_index)
		{
			case 0 :
				HashMap invAccTypeMap=(HashMap)invAccRow.get(InvKeys.INV_ACC_TYPE);
				if ( invAccTypeMap != null)
					result =(String) invAccTypeMap.get(InvKeys.INV_ACC_TYPE_DEFINITION);
				break;
			case 1 :
				HashMap accMap=(HashMap)invAccRow.get(AccKeys.ACC_ACCOUNT);
				if (accMap != null)
					result =(String)accMap.get(AccKeys.ACC_ACCOUNT_CODE);
				break;
			default :
				result = "";
		}
		return result;
	}

	public Object getValue(int column_index)
	{
		Object result = null;
		switch (column_index)
		{
			case 0 :
				HashMap invAccTypeMap=(HashMap)invAccRow.get(InvKeys.INV_ACC_TYPE);
				if ( invAccTypeMap != null)
					result =(String) invAccTypeMap.get(InvKeys.INV_ACC_TYPE_DEFINITION);
				else
					result = "";
				break;
			case 1 :
				HashMap accMap=(HashMap)invAccRow.get(AccKeys.ACC_ACCOUNT);
				if (accMap != null)
					result =(String)accMap.get(AccKeys.ACC_ACCOUNT_CODE);
				else
					result = "";
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
			case 0 :
				HashMap invAccType = (HashMap) value;
				invAccRow.put(InvKeys.INV_ACC_TYPE,invAccType);
				break;
			case 1 : //Hesap Kodu
				try
				{
					HashMap accountMap = EngBLAccountingAccounts.getAccount(value.toString().trim());
					invAccRow.put(AccKeys.ACC_ACCOUNT,accountMap);
				}
				catch (Exception ex)
				{

                    EngBLLogger.log(this.getClass(),ex);;
				}
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
		return invAccRow;
	}

	public void setDBObject(Object transRow)
	{
		this.invAccRow = (HashMap) transRow;
	}

	public boolean okToSave()
	{
		if (invAccRow.get(AccKeys.ACC_ACCOUNT) == null)
		{
			return false;
		}
		else
		{
			return true;
		}
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