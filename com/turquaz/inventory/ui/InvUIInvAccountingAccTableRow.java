/* Created on Mar 9, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui;

/**
 * @author Cem Window - Preferences - Java - Code Style - Code Templates
 */
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryAccountingType;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class InvUIInvAccountingAccTableRow implements ITableRow
{
	String formatted = "";
	TableRowList rowList;
	int row_index = 0;
	private TurqInventoryAccountingAccount invAccRow = new TurqInventoryAccountingAccount();

	public InvUIInvAccountingAccTableRow(TableRowList rowList, TurqInventoryAccountingType type)
	{
		super();
		this.rowList = rowList;
		this.invAccRow.setTurqInventoryAccountingType(type);
	}

	public InvUIInvAccountingAccTableRow(TableRowList rowList, TurqInventoryAccountingAccount invAcc)
	{
		super();
		this.rowList = rowList;
		this.invAccRow = invAcc;
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
		if (invAccRow.getTurqAccountingAccount() == null)
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
				if (invAccRow.getTurqInventoryAccountingType() != null)
					result = invAccRow.getTurqInventoryAccountingType().getDefinition();
				break;
			case 1 :
				if (invAccRow.getTurqAccountingAccount() != null)
					result = invAccRow.getTurqAccountingAccount().getAccountCode();
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
				if (invAccRow.getTurqInventoryAccountingType() != null)
				{
					result = invAccRow.getTurqInventoryAccountingType().getDefinition();
				}
				else
					result = "";
				break;
			case 1 :
				if (invAccRow.getTurqAccountingAccount() != null)
				{
					result = invAccRow.getTurqAccountingAccount().getAccountCode();
				}
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
				TurqInventoryAccountingType invAccType = (TurqInventoryAccountingType) value;
				invAccRow.setTurqInventoryAccountingType(invAccType);
				break;
			case 1 : //Hesap Kodu
				try
				{
					TurqAccountingAccount account = EngBLAccountingAccounts.getAccount(value.toString().trim());
					if (account != null)
					{
						invAccRow.setTurqAccountingAccount(account);
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
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
		this.invAccRow = (TurqInventoryAccountingAccount) transRow;
	}

	public boolean okToSave()
	{
		if (invAccRow.getTurqAccountingAccount() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}