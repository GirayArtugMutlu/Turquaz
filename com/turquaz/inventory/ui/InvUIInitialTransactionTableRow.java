/*
 * Created on Mar 22, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;

/**
 * @author onsel TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class InvUIInitialTransactionTableRow implements ITableRow
{
	TurqInventoryTransaction invTrans = null;
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#canModify(int)
	 */
	public boolean canModify(int column_index)
	{
		if (column_index == 0 || column_index == 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getColor()
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getColumnText(int)
	 */
	public String getColumnText(int column_index)
	{
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (invTrans == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardInventoryCode();
				}
				break;
			case 1 : //inventory name
				if (invTrans == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardName();
				}
				break;
			case 2 : //Amount
			{
				if (invTrans == null)
				{
					result = "0";
				}
				else
				{
					result = cf.format(invTrans.getAmountIn());
				}
				break;
			}
			case 3 : //Price
				if (invTrans == null)
				{
					result = "0";
				}
				else
				{
					result = cf.format(invTrans.getTotalPriceInForeignCurrency());
				}
				break;
			default :
				result = "";
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getDBObject()
	 */
	public Object getDBObject()
	{
		return invTrans;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getRowIndex()
	 */
	public int getRowIndex()
	{
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getValue(int)
	 */
	public Object getValue(int column_index)
	{
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (invTrans == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardInventoryCode();
				}
				break;
			case 1 : //inventory name
				if (invTrans == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardName();
				}
				break;
			case 2 : //Amount
			{
				if (invTrans == null)
				{
					result = "0";
				}
				else
				{
					result = cf.format(invTrans.getAmountIn());
				}
				break;
			}
			case 3 : //Price
				if (invTrans == null)
				{
					result = "0";
				}
				else
				{
					result = cf.format(invTrans.getTotalPriceInForeignCurrency());
				}
				break;
			default :
				result = "";
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#modify(int, java.lang.Object)
	 */
	public void modify(int column_index, Object value)
	{
		switch (column_index)
		{
			case 0 : // inventory code
				break;
			case 1 : //inventory name
				break;
			case 2 : //Amount
			{
				if (invTrans == null)
				{
				}
				else
				{
					String formatted = value.toString();
					formatted = formatted.replaceAll("\\.", "");
					formatted = formatted.replaceAll(",", ".");
					if (formatted.equals(""))
					{
						formatted = "0";
					}
					invTrans.setAmountIn(new BigDecimal(formatted));
				}
				break;
			}
			case 3 : //Price
				if (invTrans == null)
				{
				}
				else
				{
					String formatted = value.toString();
					formatted = formatted.replaceAll("\\.", "");
					formatted = formatted.replaceAll(",", ".");
					if (formatted.equals(""))
					{
						formatted = "0";
					}
					invTrans.setTotalPriceInForeignCurrency(new BigDecimal(formatted));
				}
				break;
			default :
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#okToSave()
	 */
	public boolean okToSave()
	{
		if (invTrans == null)
		{
			return false;
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#setDBObject(java.lang.Object)
	 */
	public void setDBObject(Object obj)
	{
		if (obj instanceof TurqInventoryTransaction)
		{
			invTrans = (TurqInventoryTransaction) obj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#setRowIndex(int)
	 */
	public void setRowIndex(int index)
	{
		// TODO Auto-generated method stub
	}
}