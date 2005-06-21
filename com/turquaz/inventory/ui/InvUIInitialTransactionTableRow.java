/*
 * Created on Mar 22, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.inventory.InvKeys;

/**
 * @author onsel 
 */
public class InvUIInitialTransactionTableRow implements ITableRow
{
	HashMap invTrans = null;
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
		HashMap invCard=null;
		if (invTrans != null)
		{
			invCard =(HashMap)invTrans.get(InvKeys.INV_CARD);
		}
		switch (column_index)
		{
			case 0 : // inventory code
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = (String) invCard.get(InvKeys.INV_CARD_CODE);
				}
				break;
			case 1 : //inventory name
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = (String)invCard.get(InvKeys.INV_CARD_NAME);
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
					result = cf.format(invTrans.get(InvKeys.INV_AMOUNT_IN));
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
					result = cf.format((BigDecimal)invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
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
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#getValue(int)
	 */
	public Object getValue(int column_index)
	{
		HashMap invCard=null;
		if (invTrans != null)
		{
			invCard =(HashMap)invTrans.get(InvKeys.INV_CARD);
		}
		
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = (String)invCard.get(InvKeys.INV_CARD_CODE);
				}
				break;
			case 1 : //inventory name
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result =(String) invCard.get(InvKeys.INV_CARD_NAME);
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
					result = cf.format((BigDecimal)invTrans.get(InvKeys.INV_AMOUNT_IN));
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
					result = cf.format((BigDecimal)invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
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
					invTrans.put(InvKeys.INV_AMOUNT_IN,new BigDecimal(formatted));
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
					invTrans.put(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY,new BigDecimal(formatted));
                    //invTrans.setTotalPrice(new BigDecimal(formatted));
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
		if (obj instanceof HashMap)
		{
			invTrans = (HashMap) obj;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.turquaz.engine.ui.viewers.ITableRow#setRowIndex(int)
	 */
	public void setRowIndex(int index)
	{
		
	}
}