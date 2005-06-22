package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.swt.graphics.Color;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngModulePrefs;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLInventoryCards;
import com.turquaz.engine.bl.EngBLLogger;
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
	HashMap invTrans = new HashMap();
	TableRowList rowList;
	int row_index = 0;
	int transType = 0;
	Integer unit_index = new Integer(-1);
	String unit_text = "";
	String units[];
	HashMap[] cardUnits;
	HashMap base_unit;
	int base_unit_index = -1;
	SaveTableViewer tableViewer;
	BigDecimal transAmount = new BigDecimal(0);
	BigDecimal transAmountinBaseUnit = new BigDecimal(0);
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	TurkishCurrencyFormat cf4 = new TurkishCurrencyFormat(4);

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

	/*
	 * type 0 = Buy type 1 = Sell
	 */
	public InvUITransactionTableRow(int type, SaveTableViewer viewer)
	{
		this.tableViewer = viewer;
		this.rowList = viewer.getRowList();
		this.transType = type;
		invTrans.put(InvKeys.INV_AMOUNT_IN, new BigDecimal(0));
		invTrans.put(InvKeys.INV_AMOUNT_OUT, new BigDecimal(0));
		invTrans.put(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_VAT_RATE, new BigDecimal(0));
		invTrans.put(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_VAT_SPECIAL_RATE, new BigDecimal(0));
		invTrans.put(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_DISCOUNT_RATE, new BigDecimal(0));
		invTrans.put(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY, new BigDecimal(0));
		invTrans.put(InvKeys.INV_TRANS_TYPE_ID, new Integer(EngBLCommon.INV_TRANS_BUY_SELL));
	}

	/**
	 * 0 - Stok Kodu 1 - Stok Cinsi //cant modify 2 - Miktar 3 - Birim 4 - Temel Birim Miktar? //cant modify 5 - Tamel Birimi //cant modify
	 * 6 - Birim Fiyat? 7 - Toplam Tutar //cant modify 8 - iskonto % 9 - ?skonto sonrasi toplam 10 - Kdv % 11 - Kdv Tutari //cantModify 12 -
	 * Ötv % 13 - Ötv Tutari //cant Modify 14 - Sat?r Toplam? //cant Modify 1
	 */
	public String getColumnText(int column_index)
	{
		String result = "";
		HashMap invCard = (HashMap) invTrans.get(InvKeys.INV_CARD);
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
					result = (String) invCard.get(InvKeys.INV_CARD_NAME);
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
				if (transType == EngBLCommon.COMMON_BUY_INT
						|| transType == EngBLCommon.COMMON_RETURN_SELL_INT)
				{
					result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_IN));
				}
				else
				{
					result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_OUT));
				}
				break;
			case 5 : //Base Unit
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = (String) base_unit.get(InvKeys.INV_UNIT_NAME);
				}
				break;
			case 6 : //Unit Price
				result = cf4.format((BigDecimal) invTrans.get(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY));
				break;
			case 7 : // total Price
				result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
				break;
			case 8 : // discount %
				result = cf4.format((BigDecimal) invTrans.get(InvKeys.INV_DISCOUNT_RATE));
				break;
			case 9 : // Amount after discount
				result = cf
						.format(((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY))
								.subtract((BigDecimal) invTrans
										.get(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY)));
				break;
			case 10 : // VAT percent
				result = invTrans.get(InvKeys.INV_VAT_RATE).toString();
				break;
			case 11 : // VAT total
				result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY));
				break;
			case 12 : // Special VAT percent
				if (invCard == null)
				{
					result = "0";
				}
				else
				{
					Boolean isSpec = (Boolean) invCard.get(InvKeys.INV_IS_SPEC_VAT_FOR_EACH);
					if (isSpec.booleanValue())
						result = cf4.format((BigDecimal) invTrans
								.get(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY));
					else
						result = cf4.format((BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_RATE));
				}
				break;
			case 13 : // Specail VAT Total
				result = cf.format((BigDecimal) invTrans
						.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY));
				break;
			case 14 : //Cumulative Price
				result = cf.format((BigDecimal) invTrans
						.get(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY));
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
			HashMap invCard = (HashMap) invTrans.get(InvKeys.INV_CARD);
			HashMap argMap = new HashMap();
			argMap.put(InvKeys.INV_CARD_ID, invCard.get(InvKeys.INV_CARD_ID));
			HashBag cardBag = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
					"initializeInventoryCard", argMap);
			invTrans.put(InvKeys.INV_CARD,cardBag.getContent());
			
			//Birimleri doldur
			List unit_list = new ArrayList();
			HashMap cardUnitsMap = (HashMap) cardBag.get(InvKeys.INV_CARD_UNITS);
			for (int k = 0; k < cardUnitsMap.size(); k++)
			{
				HashMap cardUnit = (HashMap) cardUnitsMap.get(new Integer(k));
				unit_list.add(cardUnit);
				if (((BigDecimal) cardUnit.get(InvKeys.INV_CARD_UNIT_FACTOR)).compareTo(new BigDecimal(1)) == 0)
				{
					base_unit = (HashMap) cardUnit.get(InvKeys.INV_UNIT);
				}
			}
			cardUnits = new HashMap[unit_list.size()];
			units = new String[unit_list.size()];
			unit_list.toArray(cardUnits);
			for (int i = 0; i < unit_list.size(); i++)
			{
				HashMap unitMap = (HashMap) cardUnits[i].get(InvKeys.INV_UNIT);
				units[i] = (String) unitMap.get(InvKeys.INV_UNIT_NAME);
			
				if (base_unit.get(InvKeys.INV_UNIT_ID).equals(unitMap.get(InvKeys.INV_UNIT_ID)))
				{
					base_unit_index = i;
				}
				
				HashMap transUnit = (HashMap)invTrans.get(InvKeys.INV_UNIT);
				
				System.out.println(unitMap.get(InvKeys.INV_UNIT_ID)+" "+transUnit.get(InvKeys.INV_UNIT_ID));
				if (unitMap.get(InvKeys.INV_UNIT_ID).equals(transUnit.get(InvKeys.INV_UNIT_ID)))
				{
					unit_index = new Integer(i);
					transAmount = transAmount.divide((BigDecimal) cardUnits[i]
							.get(InvKeys.INV_CARD_UNIT_FACTOR), 2, EngBLCommon.ROUNDING_METHOD);
				}
			}
			System.out.println(base_unit_index);
			System.out.println(unit_index);
			
			HashMap unitMap = (HashMap) invTrans.get(InvKeys.INV_UNIT);
			unit_text = (String) unitMap.get(InvKeys.INV_UNIT_NAME);
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex);
		}
	}

	public void fillDefaults(HashMap invCard)
	{
		try
		{
			HashMap argMap = new HashMap();
			argMap.put(InvKeys.INV_CARD_ID, invCard.get(InvKeys.INV_CARD_ID));
			HashBag cardBag = (HashBag) EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),
					"initializeInventoryCard", argMap);

			invTrans.put(InvKeys.INV_CARD,cardBag.getContent());
			
			//KDV Yuzdesi
			invTrans.put(InvKeys.INV_VAT_RATE, (BigDecimal) cardBag.get(InvKeys.INV_VAT_RATE));
			//ÖTV Yuzdesi
			invTrans
					.put(InvKeys.INV_VAT_SPECIAL_RATE, (BigDecimal) cardBag.get(InvKeys.INV_VAT_SPECIAL_RATE));
			invTrans.put(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY, (BigDecimal) cardBag
					.get(InvKeys.INV_SPECIAL_VAT_FOR_EACH));
			//Birimleri doldur
			List unit_list = new ArrayList();
			HashMap cardUnitsMap = (HashMap) cardBag.get(InvKeys.INV_CARD_UNITS);
			for (int k = 0; k < cardUnitsMap.size(); k++)
			{
				HashMap cardUnit = (HashMap) cardUnitsMap.get(new Integer(k));
				unit_list.add(cardUnit);
				if (((BigDecimal) cardUnit.get(InvKeys.INV_CARD_UNIT_FACTOR)).compareTo(new BigDecimal(1)) == 0)
				{
					base_unit = (HashMap) cardUnit.get(InvKeys.INV_UNIT);
				}
			}
			BigDecimal discountRate = (BigDecimal) cardBag.get(InvKeys.INV_DISCOUNT_RATE);
			invTrans.put(InvKeys.INV_DISCOUNT_RATE, discountRate);
			BigDecimal totalPriceInFC = (BigDecimal) invTrans
					.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY);
			invTrans.put(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY, (totalPriceInFC).multiply(
					discountRate).divide(new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
			invTrans.put(InvKeys.INV_UNIT, base_unit);
			cardUnits = new HashMap[unit_list.size()];
			units = new String[unit_list.size()];
			unit_list.toArray(cardUnits);
			for (int i = 0; i < unit_list.size(); i++)
			{
				HashMap unitMap = (HashMap) cardUnits[i].get(InvKeys.INV_UNIT);
				units[i] = (String) unitMap.get(InvKeys.INV_UNIT_NAME);
				if (base_unit == unitMap)
				{
					base_unit_index = i;
				}
			}
			unit_index = new Integer(base_unit_index);
			unit_text = (String) base_unit.get(InvKeys.INV_UNIT_NAME);
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex);
		}
	}

	public Object getValue(int column_index)
	{
		Object result = "";
		HashMap invCard = (HashMap) invTrans.get(InvKeys.INV_CARD);
		switch (column_index)
		{
			case 0 : // inventory code
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = invCard.get(InvKeys.INV_CARD_CODE);
				}
				break;
			case 1 : //inventory name
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = invCard.get(InvKeys.INV_CARD_NAME);
				}
				break;
			case 2 : //Amount
				result = cf.format(transAmount);
				break;
			case 3 : //Unit
				result = unit_index;
				break;
			case 4 : //amount in base units
				if (transType == EngBLCommon.COMMON_BUY_INT
						|| transType == EngBLCommon.COMMON_RETURN_SELL_INT)
				{
					result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_IN));
				}
				else
				{
					result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_OUT));
				}
				break;
			case 5 : //Base Unit
				if (invCard == null)
				{
					result = "";
				}
				else
				{
					result = base_unit.get(InvKeys.INV_UNIT_NAME);
				}
				break;
			case 6 : //Unit Price
				result = cf4.format((BigDecimal) invTrans.get(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY));
				break;
			case 7 : // total Price
				result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY));
				break;
			case 8 : // Discount percent
				result = cf4.format((BigDecimal) invTrans.get(InvKeys.INV_DISCOUNT_RATE));
				break;
			case 9 : // Amount after discount
				result = cf
						.format(((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY))
								.subtract((BigDecimal) invTrans
										.get(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY)));
				break;
			case 10 : // VAT percent
				result = ((BigDecimal) invTrans.get(InvKeys.INV_VAT_RATE)).toString();
				break;
			case 11 : // VAT total
				result = cf.format((BigDecimal) invTrans.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY));
				break;
			case 12 : // Special VAT percent
				if (invCard == null)
				{
					result = "0";
					break;
				}
				Boolean isSpec = (Boolean) invCard.get(InvKeys.INV_IS_SPEC_VAT_FOR_EACH);
				if (isSpec.booleanValue())
					result = cf4.format((BigDecimal) invTrans
							.get(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY));
				else
					result = ((BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_RATE)).toString();
				break;
			case 13 : // Specail VAT Total
				result = cf.format((BigDecimal) invTrans
						.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY));
				break;
			case 14 : //Cumulative Price
				result = cf.format((BigDecimal) invTrans
						.get(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY));
				break;
			default :
				result = "";
		}
		return result;
	}

	public void modify(int column_index, Object value)
	{
		try
		{
			String formatted = "";
			HashMap invCard = (HashMap) invTrans.get(InvKeys.INV_CARD);
			HashMap card;
			switch (column_index)
			{
				case 0 : // inventory code
					card = EngBLInventoryCards.getInvCard(value.toString().trim());
					if (card != null)
					{
						if (invCard == null)
						{
							invTrans.put(InvKeys.INV_CARD, card);
							fillDefaults(card);
							updateComboBoxEditor();
						}
						else if (((Integer) invCard.get(InvKeys.INV_CARD_ID)).intValue() != ((Integer) card
								.get(InvKeys.INV_CARD_ID)).intValue())
						{
							invTrans.put(InvKeys.INV_CARD, card);
							fillDefaults(card);
							updateComboBoxEditor();
						}
					}
					break;
				case 1 :
					card = EngBLInventoryCards.getInvFromCardName(value.toString().trim());
					if (card != null)
					{
						if (invCard == null)
						{
							invTrans.put(InvKeys.INV_CARD, card);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
						else if (((Integer) invCard.get(InvKeys.INV_CARD_ID)).intValue() != ((Integer) card
								.get(InvKeys.INV_CARD_ID)).intValue())
						{
							invTrans.put(InvKeys.INV_CARD, card);
							fillDefaults(invCard);
							updateComboBoxEditor();
						}
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
						invTrans
								.put(InvKeys.INV_UNIT, cardUnits[unit_index.intValue()].get(InvKeys.INV_UNIT));
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
					invTrans.put(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY, new BigDecimal(formatted));
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
					invTrans.put(InvKeys.INV_DISCOUNT_RATE, new BigDecimal(formatted).setScale(2,
							EngBLCommon.ROUNDING_METHOD));
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
					discAmount = ((BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY))
							.subtract(bdValue).setScale(2, EngBLCommon.ROUNDING_METHOD);
					invTrans.put(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY, discAmount);
					invTrans.put(InvKeys.INV_DISCOUNT_RATE, discAmount.divide(
							(BigDecimal) invTrans.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY), 6,
							EngBLCommon.ROUNDING_METHOD).multiply(new BigDecimal(100)));
					break;
				case 10 : // VAT percent
					formatted = value.toString();
					if (formatted.equals(""))
					{
						formatted = "0";
					}
					invTrans.put(InvKeys.INV_VAT_RATE, new BigDecimal(formatted));
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
					if (invCard != null)
					{
						Boolean isSpec = (Boolean) invCard.get(InvKeys.INV_IS_SPEC_VAT_FOR_EACH);
						if (isSpec.booleanValue())
							invTrans.put(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY,
									new BigDecimal(formatted));
						else
							invTrans.put(InvKeys.INV_VAT_SPECIAL_RATE, new BigDecimal(formatted));
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
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex);
		}
	}

	public void calculateFields()
	{
		HashMap invCard = (HashMap) invTrans.get(InvKeys.INV_CARD);
		if (invCard != null)
		{
			
			transAmountinBaseUnit = transAmount.multiply(
					(BigDecimal) cardUnits[unit_index.intValue()].get(InvKeys.INV_CARD_UNIT_FACTOR))
					.setScale(2, EngBLCommon.ROUNDING_METHOD);
			invTrans.put(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY, ((BigDecimal) invTrans
					.get(InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY)).multiply(transAmountinBaseUnit)
					.setScale(2, EngBLCommon.ROUNDING_METHOD));
			invTrans.put(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY, ((BigDecimal) invTrans
					.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY)).multiply(
					(BigDecimal) invTrans.get(InvKeys.INV_DISCOUNT_RATE)).divide(new BigDecimal(100), 2,
					EngBLCommon.ROUNDING_METHOD));
			BigDecimal totalPriceAfterDiscount = ((BigDecimal) invTrans
					.get(InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY)).subtract(
					(BigDecimal) invTrans.get(InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY)).setScale(2,
					EngBLCommon.ROUNDING_METHOD);
			if (transType == EngBLCommon.COMMON_BUY_INT || transType == EngBLCommon.COMMON_RETURN_SELL_INT)
			{
				invTrans.put(InvKeys.INV_AMOUNT_IN, transAmountinBaseUnit);
			}
			else
			{
				invTrans.put(InvKeys.INV_AMOUNT_OUT, transAmountinBaseUnit);
			}
			Boolean isSpec = (Boolean) invCard.get(InvKeys.INV_IS_SPEC_VAT_FOR_EACH);
			if (isSpec.booleanValue())
			{
				BigDecimal vatSpecialAmount = ((BigDecimal) invTrans
						.get(InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY)).multiply(
						transAmountinBaseUnit).setScale(2, EngBLCommon.ROUNDING_METHOD);
				invTrans.put(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY, vatSpecialAmount);
			}
			else
			{
				invTrans.put(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY, totalPriceAfterDiscount
						.multiply((BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_RATE)).divide(
								new BigDecimal(100), 2, EngBLCommon.ROUNDING_METHOD));
			}
			BigDecimal totalPriceAfterDiscountAddedSpecVAT = totalPriceAfterDiscount
					.add((BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY));
			invTrans.put(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY, totalPriceAfterDiscountAddedSpecVAT
					.multiply((BigDecimal) invTrans.get(InvKeys.INV_VAT_RATE)).divide(new BigDecimal(100), 2,
							EngBLCommon.ROUNDING_METHOD));
			invTrans.put(InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY, totalPriceAfterDiscount.add(
					(BigDecimal) invTrans.get(InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY)).add(
					(BigDecimal) invTrans.get(InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY)));
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
		if (column_index == 4 || column_index == 5 || column_index == 7 || column_index == 11
				|| column_index == 13 || column_index == 14)
		{
			return false;
		}
		if (column_index == 1)
		{
			String useName = EngModulePrefs.getProperty(EngBLCommon.BILL_CONFIG,
					EngBLCommon.BILL_CONFIG_CHECK_USE_INVENTORY_NAME);
			if (useName == null)
			{
				return false;
			}
			if (useName.equals("true"))
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
		if (invTrans.get(InvKeys.INV_CARD) == null)
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
		if (obj instanceof HashMap)
		{
			invTrans = (HashMap) obj;
			if (transType == EngBLCommon.COMMON_BUY_INT || transType == EngBLCommon.COMMON_RETURN_SELL_INT)
			{
				transAmount = (BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_IN);
			}
			else
			{
				transAmount = (BigDecimal) invTrans.get(InvKeys.INV_AMOUNT_OUT);
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
			EngBLLogger.log(this.getClass(), ex);
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