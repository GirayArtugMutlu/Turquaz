package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.inventory.bl.InvBLCardSearch;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUITransactionTableRow implements ITableRow
{
	TurqInventoryTransaction invTrans = new TurqInventoryTransaction();
	TableRowList rowList;
	int row_index = 0;

	/**
	 * @return Returns the transType.
	 */
	public int getTransType()
	{
		return transType;
	}

	/**
	 * @param transType
	 *             The transType to set.
	 */
	public void setTransType(int transType)
	{
		this.transType = transType;
	}
	int transType = 0;
	Integer unit_index = new Integer(-1);
	String unit_text = "";
	String units[];
	TurqInventoryCardUnit cardUnits[];
	TurqInventoryUnit base_unit;
	int base_unit_index = -1;
	InvBLCardSearch blCardSearch = new InvBLCardSearch();
	TableViewer tableViewer;
	BigDecimal transAmount = new BigDecimal(0);
	BigDecimal transAmountinBaseUnit = new BigDecimal(0);
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	TurkishCurrencyFormat cf4 = new TurkishCurrencyFormat(4);

	/*
	 * type 0 = Buy type 1 = Sell
	 */
	public InvUITransactionTableRow(TableRowList rowList, int type, TableViewer viewer)
	{
		this.tableViewer = viewer;
		this.rowList = rowList;
		this.transType = type;
		invTrans.setTransactionsAmountIn(new BigDecimal(0));
		invTrans.setTransactionsTotalAmountOut(new BigDecimal(0));
		invTrans.setTransactionsUnitPrice(new BigDecimal(0));
		invTrans.setTransactionsTotalPrice(new BigDecimal(0));
		invTrans.setTransactionsVat(0);
		invTrans.setTransactionsVatAmount(new BigDecimal(0));
		invTrans.setTransactionsVatSpecial(new BigDecimal(0));
		invTrans.setTransactionsVatSpecialAmount(new BigDecimal(0));
		invTrans.setTransactionsVatSpecialEach(new BigDecimal(0));
		invTrans.setTransactionsCumilativePrice(new BigDecimal(0));
		invTrans.setTransactionsDiscount(new BigDecimal(0));
		invTrans.setTransactionsDiscountAmount(new BigDecimal(0));
		invTrans.setTransactionType(EngBLCommon.INVENTORY_TRANS_CONSIGNMENT);
	}

	/**
	 * 0 - Stok Kodu 1 - Stok Cinsi //cant modify 2 - Miktar 3 - Birim 4 - Temel Birim Miktar? //cant modify 5 - Tamel Birimi //cant modify
	 * 6 - Birim Fiyat? 7 - Toplam Tutar //cant modify 8 - iskonto % 9 - ?skonto sonrasi toplam 10 - Kdv % 11 - Kdv Tutari //cantModify 12 -
	 * �tv % 13 - �tv Tutari //cant Modify 14 - Sat?r Toplam? //cant Modify 1
	 */
	public String getColumnText(int column_index)
	{
		String result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardInventoryCode();
				}
				break;
			case 1 : //inventory name
				if (invTrans.getTurqInventoryCard() == null)
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
				result = cf.format(transAmount);
				break;
			}
			case 3 : //Unit
				result = unit_text;
				break;
			case 4 : //Amount in Base Unit
				if (transType == 0)
				{
					result = cf.format(invTrans.getTransactionsAmountIn());
				}
				else
				{
					result = cf.format(invTrans.getTransactionsTotalAmountOut());
				}
				break;
			case 5 : //Base Unit
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "";
				}
				else
				{
					result = base_unit.getUnitsName();
				}
				break;
			case 6 : //Unit Price
				result = cf4.format(invTrans.getTransactionsUnitPrice());
				break;
			case 7 : // total Price
				result = cf.format(invTrans.getTransactionsTotalPrice());
				break;
			case 8 : // discount %
				result = cf4.format(invTrans.getTransactionsDiscount());
				break;
			case 9 : // Amount after discount
				result = cf.format(invTrans.getTransactionsTotalPrice().subtract(invTrans.getTransactionsDiscountAmount()));
				break;
			case 10 : // VAT percent
				result = invTrans.getTransactionsVat() + "";
				break;
			case 11 : // VAT total
				result = cf.format(invTrans.getTransactionsVatAmount());
				break;
			case 12 : // Special VAT percent
				TurqInventoryCard invCard = invTrans.getTurqInventoryCard();
				if (invCard == null)
				{
					result = "0";
				}
				else
				{
					if (invTrans.getTurqInventoryCard().isSpecVatForEach())
						result = cf4.format(invTrans.getTransactionsVatSpecialEach());
					else
						result = cf4.format(invTrans.getTransactionsVatSpecial());
				}
				break;
			case 13 : // Specail VAT Total
				result = cf.format(invTrans.getTransactionsVatSpecialAmount());
				break;
			case 14 : //Cumulative Price
				result = cf.format(invTrans.getTransactionsCumilativePrice());
				break;
			default :
				result = "";
		}
		return result;
	}

	public void fillAfterSetDB()
	{
		try
		{
			TurqInventoryCard invCard = invTrans.getTurqInventoryCard();
			InvBLCardSearch.initializeInventoryCard(invCard);
			//Birimleri doldur
			List unit_list = new ArrayList();
			Set set = invCard.getTurqInventoryCardUnits();
			Iterator it = set.iterator();
			while (it.hasNext())
			{
				TurqInventoryCardUnit cardUnit = (TurqInventoryCardUnit) it.next();
				unit_list.add(cardUnit);
				if (cardUnit.getCardUnitsFactor().compareTo(new BigDecimal(1)) == 0)
				{
					base_unit = cardUnit.getTurqInventoryUnit();
				}
			}
			cardUnits = new TurqInventoryCardUnit[unit_list.size()];
			units = new String[unit_list.size()];
			unit_list.toArray(cardUnits);
			for (int i = 0; i < unit_list.size(); i++)
			{
				units[i] = cardUnits[i].getTurqInventoryUnit().getUnitsName();
				if (base_unit.equals(cardUnits[i].getTurqInventoryUnit()))
				{
					base_unit_index = i;
				}
				if (invTrans.getTurqInventoryUnit().equals(cardUnits[i].getTurqInventoryUnit()))
				{
					unit_index = new Integer(i);
					transAmount = transAmount.divide(cardUnits[i].getCardUnitsFactor(), 2, BigDecimal.ROUND_HALF_DOWN);
				}
			}
			unit_text = invTrans.getTurqInventoryUnit().getUnitsName();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void fillDefaults(TurqInventoryCard invCard)
	{
		try
		{
			InvBLCardSearch.initializeInventoryCard(invCard);
			//KDV Yuzdesi
			invTrans.setTransactionsVat(invCard.getCardVat());
			//�TV Yuzdesi
			invTrans.setTransactionsVatSpecial(new BigDecimal(invCard.getCardSpecialVat()));
			invTrans.setTransactionsVatSpecialEach(invCard.getCardSpecialVatEach());
			//Birimleri doldur
			List unit_list = new ArrayList();
			Set set = invCard.getTurqInventoryCardUnits();
			Iterator it = set.iterator();
			while (it.hasNext())
			{
				TurqInventoryCardUnit cardUnit = (TurqInventoryCardUnit) it.next();
				unit_list.add(cardUnit);
				if (cardUnit.getCardUnitsFactor().compareTo(new BigDecimal(1)) == 0)
				{
					base_unit = cardUnit.getTurqInventoryUnit();
				}
			}
			invTrans.setTransactionsDiscount(new BigDecimal(invCard.getCardDiscount()));
			invTrans.setTransactionsDiscountAmount(invTrans.getTransactionsTotalPrice().multiply(invTrans.getTransactionsDiscount())
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN));
			invTrans.setTurqInventoryUnit(base_unit);
			cardUnits = new TurqInventoryCardUnit[unit_list.size()];
			units = new String[unit_list.size()];
			unit_list.toArray(cardUnits);
			for (int i = 0; i < unit_list.size(); i++)
			{
				units[i] = cardUnits[i].getTurqInventoryUnit().getUnitsName();
				if (base_unit == cardUnits[i].getTurqInventoryUnit())
				{
					base_unit_index = i;
				}
			}
			unit_index = new Integer(base_unit_index);
			unit_text = base_unit.getUnitsName();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public Object getValue(int column_index)
	{
		Object result = "";
		switch (column_index)
		{
			case 0 : // inventory code
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardInventoryCode();
				}
				break;
			case 1 : //inventory name
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "";
				}
				else
				{
					result = invTrans.getTurqInventoryCard().getCardName();
				}
				break;
			case 2 : //Amount
				result = cf.format(transAmount);
				break;
			case 3 : //Unit
				result = unit_index;
				break;
			case 4 : //amount in base units
				if (transType == 0)
				{
					result = cf.format(invTrans.getTransactionsAmountIn());
				}
				else
				{
					result = cf.format(invTrans.getTransactionsTotalAmountOut());
				}
				break;
			case 5 : //Base Unit
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "";
				}
				else
				{
					result = base_unit.getUnitsName();
				}
				break;
			case 6 : //Unit Price
				result = cf4.format(invTrans.getTransactionsUnitPrice());
				break;
			case 7 : // total Price
				result = cf.format(invTrans.getTransactionsTotalPrice());
				break;
			case 8 : // Discount percent
				result = cf4.format(invTrans.getTransactionsDiscount());
				break;
			case 9 : // Amount after discount
				result = cf.format(invTrans.getTransactionsTotalPrice().subtract(invTrans.getTransactionsDiscountAmount()));
				break;
			case 10 : // VAT percent
				result = invTrans.getTransactionsVat() + "";
				break;
			case 11 : // VAT total
				result = cf.format(invTrans.getTransactionsVatAmount());
				break;
			case 12 : // Special VAT percent
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "0";
					break;
				}
				if (invTrans.getTurqInventoryCard().isSpecVatForEach())
					result = cf4.format(invTrans.getTransactionsVatSpecialEach());
				else
					result = invTrans.getTransactionsVatSpecial().toString();
				break;
			case 13 : // Specail VAT Total
				result = cf.format(invTrans.getTransactionsVatSpecialAmount());
				break;
			case 14 : //Cumulative Price
				result = cf.format(invTrans.getTransactionsCumilativePrice().toString());
				break;
			default :
				result = "";
		}
		return result;
	}

	public void modify(int column_index, Object value)
	{
		String formatted = "";
		switch (column_index)
		{
			case 0 : // inventory code
				try
				{
					TurqInventoryCard invCard = EngBLInventoryCards.getInvCard(value.toString().trim());
					if (invCard != null)
					{
						invTrans.setTurqInventoryCard(invCard);
						fillDefaults(invCard);
						updateComboBoxEditor();
					}
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
				break;
			case 1 : //inventory name
				break;
			case 2 : //Amount
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				transAmount = new BigDecimal(formatted);
				break;
			case 3 : //Unit
				if (((Integer) value).intValue() != -1)
				{
					unit_index = (Integer) value;
					unit_text = units[unit_index.intValue()];
					invTrans.setTurqInventoryUnit(cardUnits[unit_index.intValue()].getTurqInventoryUnit());
				}
				break;
			case 4 : //Base Unit Amount
				break;
			case 5 : //Base Unit
				break;
			case 6 : //Unit Price
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				invTrans.setTransactionsUnitPrice(new BigDecimal(formatted));
				break;
			case 7 : // total Price
				break;
			case 8 : // Discount %
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				invTrans.setTransactionsDiscount(new BigDecimal(formatted).setScale(2, BigDecimal.ROUND_HALF_DOWN));
				break;
			case 9 : // Amount after discount
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				BigDecimal bdValue = new BigDecimal(formatted).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				BigDecimal discAmount = new BigDecimal(0);
				discAmount = invTrans.getTransactionsTotalPrice().subtract(bdValue).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				invTrans.setTransactionsDiscountAmount(discAmount);
				invTrans.setTransactionsDiscount(discAmount.divide(invTrans.getTransactionsTotalPrice(), 6, BigDecimal.ROUND_HALF_UP)
						.multiply(new BigDecimal(100)));
				break;
			case 10 : // VAT percent
				formatted = value.toString();
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				invTrans.setTransactionsVat(Integer.parseInt(formatted));
				break;
			case 11 : // VAT total
				break;
			case 12 : // Special VAT percent
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				TurqInventoryCard invCard = invTrans.getTurqInventoryCard();
				if (invCard != null)
				{
					if (invCard.isSpecVatForEach())
						invTrans.setTransactionsVatSpecialEach(new BigDecimal(formatted));
					else
						invTrans.setTransactionsVatSpecial(new BigDecimal(formatted));
				}
				break;
			case 13 : // Specail VAT Total
				break;
			case 14 : //Cumulative Price
				break;
			default :
		}
		rowList.taskChanged(this);
		calculateFields();
	}

	public void calculateFields()
	{
		if (invTrans.getTurqInventoryCard() != null)
		{
			transAmountinBaseUnit = transAmount.multiply(cardUnits[unit_index.intValue()].getCardUnitsFactor()).setScale(2,
					BigDecimal.ROUND_HALF_DOWN);
			invTrans.setTransactionsTotalPrice(invTrans.getTransactionsUnitPrice().multiply(transAmountinBaseUnit).setScale(2,
					BigDecimal.ROUND_HALF_DOWN));
			invTrans.setTransactionsDiscountAmount(invTrans.getTransactionsTotalPrice().multiply(invTrans.getTransactionsDiscount())
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN));
			BigDecimal totalPriceAfterDiscount = invTrans.getTransactionsTotalPrice().subtract(invTrans.getTransactionsDiscountAmount())
					.setScale(2, BigDecimal.ROUND_HALF_DOWN);
			if (transType == 0)
			{
				invTrans.setTransactionsAmountIn(transAmountinBaseUnit);
			}
			else
			{
				invTrans.setTransactionsTotalAmountOut(transAmountinBaseUnit);
			}
			if (invTrans.getTurqInventoryCard().isSpecVatForEach())
			{
				BigDecimal vatSpecialAmount = invTrans.getTransactionsVatSpecialEach().multiply(transAmountinBaseUnit).setScale(2,
						BigDecimal.ROUND_HALF_DOWN);
				invTrans.setTransactionsVatSpecialAmount(vatSpecialAmount);
			}
			else
			{
				invTrans.setTransactionsVatSpecialAmount(totalPriceAfterDiscount.multiply(invTrans.getTransactionsVatSpecial()).divide(
						new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN));
			}
			BigDecimal totalPriceAfterDiscountAddedSpecVAT = totalPriceAfterDiscount.add(invTrans.getTransactionsVatSpecialAmount());
			invTrans.setTransactionsVatAmount(totalPriceAfterDiscountAddedSpecVAT
					.multiply(new BigDecimal(invTrans.getTransactionsVat()))
					.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_DOWN));
			invTrans.setTransactionsCumilativePrice(totalPriceAfterDiscount.add(invTrans.getTransactionsVatSpecialAmount()).add(
					invTrans.getTransactionsVatAmount()));
		}
	}

	public String[] getUnits()
	{
		return units;
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

	public boolean canModify(int column_index)
	{
		if (column_index == 1 || column_index == 4 || column_index == 5 || column_index == 7 || column_index == 11 || column_index == 13
				|| column_index == 14)
		{
			return false;
		}
		return true;
	}

	public void setRowIndex(int index)
	{
		row_index = index;
	}

	public int getRowIndex()
	{
		return row_index;
	}

	public boolean okToSave()
	{
		if (invTrans.getTurqInventoryCard() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	public Object getDBObject()
	{
		return invTrans;
	}

	public void setDBObject(Object obj)
	{
		if (obj instanceof TurqInventoryTransaction)
		{
			invTrans = (TurqInventoryTransaction) obj;
			if (transType == 0)
			{
				transAmount = invTrans.getTransactionsAmountIn();
			}
			else
			{
				transAmount = invTrans.getTransactionsTotalAmountOut();
			}
			fillAfterSetDB();
			calculateFields();
		}
	}

	public void updateComboBoxEditor()
	{
		try
		{
			ComboBoxCellEditor editor = (ComboBoxCellEditor) tableViewer.getCellEditors()[3];
			if (getUnits() != null)
			{
				editor.setItems(getUnits());
			}
			else
			{
				editor.setItems(new String[]{});
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
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
}