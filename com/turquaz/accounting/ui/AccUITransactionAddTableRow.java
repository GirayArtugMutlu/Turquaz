package com.turquaz.accounting.ui;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;

public class AccUITransactionAddTableRow implements ITableRow
{
	String formatted = "";
	TableRowList rowList;
	int row_index = 0;
	private TurqAccountingTransactionColumn transRow = new TurqAccountingTransactionColumn();

	public AccUITransactionAddTableRow(TableRowList rowList)
	{
		super();
		this.rowList = rowList;
		transRow.setTransactionDefinition("");
		transRow.setCreditAmount(new BigDecimal(0));
		transRow.setDeptAmount(new BigDecimal(0));
		transRow.setTransactionDefinition("");
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
		if (transRow.getTurqAccountingAccount() == null)
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
		switch (column_index)
		{
			case 0 :
				if (transRow.getTurqAccountingAccount() != null)
					result = transRow.getTurqAccountingAccount().getAccountCode();
				break;
			case 1 :
				if (transRow.getTurqAccountingAccount() != null)
					result = transRow.getTurqAccountingAccount().getAccountName();
				break;
			case 3 :
				result = df.format(transRow.getDeptAmount());
				break;
			case 4 :
				result = df.format(transRow.getCreditAmount());
				break;
			case 2 :
				result = transRow.getTransactionDefinition();
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
				if (transRow.getTurqAccountingAccount() != null)
				{
					result = transRow.getTurqAccountingAccount().getAccountCode();
				}
				else
					result = "";
				break;
			case 1 :
				if (transRow.getTurqAccountingAccount() != null)
				{
					result = transRow.getTurqAccountingAccount().getAccountName();
				}
				else
					result = "";
				break;
			case 3 :
				result = transRow.getDeptAmount().toString();
				result = ((String) result).replaceAll("\\.", ",");
				break;
			case 4 :
				result = transRow.getCreditAmount().toString();
				result = ((String) result).replaceAll("\\.", ",");
				break;
			case 2 :
				result = transRow.getTransactionDefinition();
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
						transRow.setTurqAccountingAccount(account);
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
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				if (!formatted.equals("0"))
					transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(new BigDecimal(formatted));
				break;
			case 4 :
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				if (!formatted.equals("0"))
					transRow.setDeptAmount(new BigDecimal(0));
				transRow.setCreditAmount(new BigDecimal(formatted));
				break;
			case 2 :
				transRow.setTransactionDefinition(value.toString());
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
		return transRow;
	}

	public void setDBObject(Object transRow)
	{
		this.transRow = (TurqAccountingTransactionColumn) transRow;
	}

	public boolean okToSave()
	{
		if (transRow.getTurqAccountingAccount() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}