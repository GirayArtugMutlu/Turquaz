package com.turquaz.engine.test;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class TableRowImpl extends TurqAccountingTransactionColumn implements ITableRow
{
	String formatted = "";
	TableRowList rowList;
	int row_index = 0;

	public TableRowImpl(TableRowList rowList)
	{
		super();
		this.rowList = rowList;
		setTransactionDefinition("");
		setCreditAmount(new BigDecimal(0));
		setDeptAmount(new BigDecimal(0));
		setTransactionDefinition("");
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
		if (getTurqAccountingAccount() == null)
		{
			return SWTResourceManager.getColor(255, 198, 198);
		}
		return SWTResourceManager.getColor(198, 255, 198);
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
		String result = "";
		switch (column_index)
		{
			case 0 :
				if (getTurqAccountingAccount() != null)
					result = getTurqAccountingAccount().getAccountCode();
				break;
			case 1 :
				if (getTurqAccountingAccount() != null)
					result = getTurqAccountingAccount().getAccountName();
				break;
			case 3 :
				result = getDeptAmount().toString();
				break;
			case 4 :
				result = getCreditAmount().toString();
				break;
			case 2 :
				result = getTransactionDefinition();
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
				if (getTurqAccountingAccount() != null)
				{
					result = getTurqAccountingAccount().getAccountCode();
				}
				else
					result = "";
				break;
			case 1 :
				if (getTurqAccountingAccount() != null)
				{
					result = getTurqAccountingAccount().getAccountName();
				}
				else
					result = "";
				break;
			case 3 :
				result = getDeptAmount().toString();
				break;
			case 4 :
				result = getCreditAmount().toString();
				break;
			case 2 :
				result = getTransactionDefinition();
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
					TurqAccountingAccount account = EngBLAccountingAccounts.getAccount(value.toString().trim());
					if (account != null)
					{
						setTurqAccountingAccount(account);
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				break;
			case 1 :
				break;
			case 3 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				setDeptAmount(new BigDecimal(formatted));
				break;
			case 4 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				setCreditAmount(new BigDecimal(formatted));
				break;
			case 2 :
				setTransactionDefinition(value.toString());
				break;
		}
		rowList.taskChanged(this);
	}

	public boolean equals(Object other)
	{
		if (other instanceof TableRowImpl)
		{
			TableRowImpl row = (TableRowImpl) other;
			if (getRowIndex() == row.getRowIndex())
			{
				return true;
			}
			return false;
		}
		return false;
	}

	public boolean okToSave()
	{
		return true;
	}

	public Object getDBObject()
	{
		return this;
	}

	public void setDBObject(Object obj)
	{
	}
}