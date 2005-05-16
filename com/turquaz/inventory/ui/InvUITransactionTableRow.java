package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.EngModulePrefs;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqInventoryTransactionType;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
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
		calculateFields();
	}
     int transType = 0;
	Integer unit_index = new Integer(-1);
	String unit_text = "";
	String units[];
	TurqInventoryCardUnit cardUnits[];
	TurqInventoryUnit base_unit;
	int base_unit_index = -1;
	SaveTableViewer tableViewer;
	BigDecimal transAmount = new BigDecimal(0);
	BigDecimal transAmountinBaseUnit = new BigDecimal(0);
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	TurkishCurrencyFormat cf4 = new TurkishCurrencyFormat(4);

	/*
	 * type 0 = Buy type 1 = Sell
	 */
	public InvUITransactionTableRow(int type, SaveTableViewer viewer)
	{
		this.tableViewer = viewer;
		this.rowList = viewer.getRowList();
		this.transType = type;
		invTrans.setAmountIn(new BigDecimal(0));
		invTrans.setAmountOut(new BigDecimal(0));
		invTrans.setUnitPriceInForeignCurrency(new BigDecimal(0));
		invTrans.setTotalPriceInForeignCurrency(new BigDecimal(0));
		invTrans.setVatRate(new BigDecimal(0));
		invTrans.setVatAmountInForeignCurrency(new BigDecimal(0));
		invTrans.setVatSpecialRate(new BigDecimal(0));
		invTrans.setVatSpecialAmountInForeignCurrency(new BigDecimal(0));
		invTrans.setVatSpecialUnitPriceInForeignCurrency(new BigDecimal(0));
		invTrans.setCumilativePriceInForeignCurrency(new BigDecimal(0));
		invTrans.setDiscountRate(new BigDecimal(0));
		invTrans.setDiscountAmountInForeignCurrency(new BigDecimal(0));
		TurqInventoryTransactionType transType = new TurqInventoryTransactionType();
		transType.setId(new Integer(EngBLCommon.INV_TRANS_BUY_SELL));
		invTrans.setTurqInventoryTransactionType(transType);
	}

	/**
	 * 0 - Stok Kodu 1 - Stok Cinsi //cant modify 2 - Miktar 3 - Birim 4 - Temel Birim Miktar? //cant modify 5 - Tamel Birimi //cant modify
	 * 6 - Birim Fiyat? 7 - Toplam Tutar //cant modify 8 - iskonto % 9 - ?skonto sonrasi toplam 10 - Kdv % 11 - Kdv Tutari //cantModify 12 -
	 * Ötv % 13 - Ötv Tutari //cant Modify 14 - Sat?r Toplam? //cant Modify 1
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
				if (transType == EngBLCommon.COMMON_BUY_INT || transType == EngBLCommon.COMMON_RETURN_SELL_INT)
				{
					result = cf.format(invTrans.getAmountIn());
				}
				else
				{
					result = cf.format(invTrans.getAmountOut());
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
				result = cf4.format(invTrans.getUnitPriceInForeignCurrency());
				break;
			case 7 : // total Price
				result = cf.format(invTrans.getTotalPriceInForeignCurrency());
				break;
			case 8 : // discount %
				result = cf4.format(invTrans.getDiscountRate());
				break;
			case 9 : // Amount after discount
				result = cf.format(invTrans.getTotalPriceInForeignCurrency().subtract(invTrans.getDiscountAmountInForeignCurrency()));
				break;
			case 10 : // VAT percent
				result = invTrans.getVatRate() + "";
				break;
			case 11 : // VAT total
				result = cf.format(invTrans.getVatAmountInForeignCurrency());
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
						result = cf4.format(invTrans.getVatSpecialUnitPriceInForeignCurrency());
					else
						result = cf4.format(invTrans.getVatSpecialRate());
				}
				break;
			case 13 : // Specail VAT Total
				result = cf.format(invTrans.getVatSpecialAmountInForeignCurrency());
				break;
			case 14 : //Cumulative Price
				result = cf.format(invTrans.getCumilativePriceInForeignCurrency());
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
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD,invCard);
			EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCard",argMap);
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
					transAmount = transAmount.divide(cardUnits[i].getCardUnitsFactor(), 2, EngBLCommon.ROUNDING_METHOD);
				}
			}
			unit_text = invTrans.getTurqInventoryUnit().getUnitsName();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	public void fillDefaults(TurqInventoryCard invCard)
	{
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD,invCard);
			EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCard",argMap);
			//KDV Yuzdesi
			//TODO invCard->getCardVat should be decimal
			invTrans.setVatRate(new BigDecimal(invCard.getCardVat()));
			//ÖTV Yuzdesi
			invTrans.setVatSpecialRate(new BigDecimal(invCard.getCardSpecialVat()));
			invTrans.setVatSpecialUnitPriceInForeignCurrency(invCard.getCardSpecialVatEach());
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
			//TODO INVCARD discount should be decimal
			invTrans.setDiscountRate(new BigDecimal(invCard.getCardDiscount()));
			invTrans.setDiscountAmountInForeignCurrency(invTrans.getTotalPriceInForeignCurrency().multiply(invTrans.getDiscountRate())
					.divide(new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
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
            EngBLLogger.log(this.getClass(),ex);
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
				if (transType == EngBLCommon.COMMON_BUY_INT || transType == EngBLCommon.COMMON_RETURN_SELL_INT)
				{
					result = cf.format(invTrans.getAmountIn());
				}
				else
				{
					result = cf.format(invTrans.getAmountOut());
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
				result = cf4.format(invTrans.getUnitPriceInForeignCurrency());
				break;
			case 7 : // total Price
				result = cf.format(invTrans.getTotalPriceInForeignCurrency());
				break;
			case 8 : // Discount percent
				result = cf4.format(invTrans.getDiscountRate());
				break;
			case 9 : // Amount after discount
				result = cf.format(invTrans.getTotalPriceInForeignCurrency().subtract(invTrans.getDiscountAmountInForeignCurrency()));
				break;
			case 10 : // VAT percent
				result = invTrans.getVatRate() + "";
				break;
			case 11 : // VAT total
				result = cf.format(invTrans.getVatAmountInForeignCurrency());
				break;
			case 12 : // Special VAT percent
				if (invTrans.getTurqInventoryCard() == null)
				{
					result = "0";
					break;
				}
				if (invTrans.getTurqInventoryCard().isSpecVatForEach())
					result = cf4.format(invTrans.getVatSpecialUnitPriceInForeignCurrency());
				else
					result = invTrans.getVatSpecialRate().toString();
				break;
			case 13 : // Specail VAT Total
				result = cf.format(invTrans.getVatSpecialAmountInForeignCurrency());
				break;
			case 14 : //Cumulative Price
				result = cf.format(invTrans.getCumilativePriceInForeignCurrency().toString());
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
						if (invTrans.getTurqInventoryCard() == null)
						{
							invTrans.setTurqInventoryCard(invCard);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
						else if (invTrans.getTurqInventoryCard().getId().intValue() != invCard.getId().intValue())
						{
							invTrans.setTurqInventoryCard(invCard);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
					}
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(this.getClass(),ex);
				}
				break;
			case 1 :
				try
				{
					TurqInventoryCard invCard = EngBLInventoryCards.getInvFromCardName(value.toString().trim());
					if (invCard != null)
					{
						if (invTrans.getTurqInventoryCard() == null)
						{
							invTrans.setTurqInventoryCard(invCard);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
						else if (invTrans.getTurqInventoryCard().getId().intValue() != invCard.getId().intValue())
						{
							invTrans.setTurqInventoryCard(invCard);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
					}
				}
				catch (Exception ex)
				{
                    EngBLLogger.log(this.getClass(),ex);
				}
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
				invTrans.setUnitPriceInForeignCurrency(new BigDecimal(formatted));
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
				invTrans.setDiscountRate(new BigDecimal(formatted).setScale(2, EngBLCommon.ROUNDING_METHOD));
				break;
			case 9 : // Amount after discount
				formatted = value.toString();
				formatted = formatted.replaceAll("\\.", "");
				formatted = formatted.replaceAll(",", ".");
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				BigDecimal bdValue = new BigDecimal(formatted).setScale(2, EngBLCommon.ROUNDING_METHOD);
				BigDecimal discAmount = new BigDecimal(0);
				discAmount = invTrans.getTotalPriceInForeignCurrency().subtract(bdValue).setScale(2, EngBLCommon.ROUNDING_METHOD);
				invTrans.setDiscountAmountInForeignCurrency(discAmount);
				invTrans.setDiscountRate(discAmount.divide(invTrans.getTotalPriceInForeignCurrency(), 6, EngBLCommon.ROUNDING_METHOD)
						.multiply(new BigDecimal(100)));
				break;
			case 10 : // VAT percent
				formatted = value.toString();
				if (formatted.equals(""))
				{
					formatted = "0";
				}
				invTrans.setVatRate(new BigDecimal(formatted));
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
						invTrans.setVatSpecialUnitPriceInForeignCurrency(new BigDecimal(formatted));
					else
						invTrans.setVatSpecialRate(new BigDecimal(formatted));
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
					EngBLCommon.ROUNDING_METHOD);
			invTrans.setTotalPriceInForeignCurrency(invTrans.getUnitPriceInForeignCurrency().multiply(transAmountinBaseUnit).setScale(2,
					EngBLCommon.ROUNDING_METHOD));
			invTrans.setDiscountAmountInForeignCurrency(invTrans.getTotalPriceInForeignCurrency().multiply(invTrans.getDiscountRate())
					.divide(new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
			BigDecimal totalPriceAfterDiscount = invTrans.getTotalPriceInForeignCurrency().subtract(
					invTrans.getDiscountAmountInForeignCurrency()).setScale(2, EngBLCommon.ROUNDING_METHOD);
		
            if (transType == EngBLCommon.COMMON_BUY_INT||transType ==EngBLCommon.COMMON_RETURN_SELL_INT)
			{
				invTrans.setAmountIn(transAmountinBaseUnit);
			}
			else
			{
				invTrans.setAmountOut(transAmountinBaseUnit);
			}
			if (invTrans.getTurqInventoryCard().isSpecVatForEach())
			{
				BigDecimal vatSpecialAmount = invTrans.getVatSpecialUnitPriceInForeignCurrency().multiply(transAmountinBaseUnit)
						.setScale(2, EngBLCommon.ROUNDING_METHOD);
				invTrans.setVatSpecialAmountInForeignCurrency(vatSpecialAmount);
			}
			else
			{
				invTrans.setVatSpecialAmountInForeignCurrency(totalPriceAfterDiscount.multiply(invTrans.getVatSpecialRate()).divide(
						new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
			}
			BigDecimal totalPriceAfterDiscountAddedSpecVAT = totalPriceAfterDiscount
					.add(invTrans.getVatSpecialAmountInForeignCurrency());
			invTrans.setVatAmountInForeignCurrency(totalPriceAfterDiscountAddedSpecVAT.multiply(invTrans.getVatRate()).divide(
					new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
			invTrans.setCumilativePriceInForeignCurrency(totalPriceAfterDiscount.add(invTrans.getVatSpecialAmountInForeignCurrency())
					.add(invTrans.getVatAmountInForeignCurrency()));
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
		if ( column_index == 4 || column_index == 5 || column_index == 7 || column_index == 11 || column_index == 13
				|| column_index == 14)
		{
			return false;
		}
        if(column_index==1)
        {
            String useName = EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,EngBLCommon.BILL_CONFIG_CHECK_USE_INVENTORY_NAME);
            if(useName==null)
            {
                return false;
            }
            if(useName.equals("true"))
            {
                return true;
            }
            else
            {
                return false;
            }
            
            
            
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
			if (transType == EngBLCommon.COMMON_BUY_INT || transType == EngBLCommon.COMMON_RETURN_SELL_INT)
			{
				transAmount = invTrans.getAmountIn();
			}
			else
			{
				transAmount = invTrans.getAmountOut();
			}
			fillAfterSetDB();
			calculateFields();
		}
	}

	public void updateComboBoxEditor()
	{
		try
		{
			ComboBoxCellEditor editor = (ComboBoxCellEditor) tableViewer.getViewer().getCellEditors()[3];
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
            EngBLLogger.log(this.getClass(),ex);
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