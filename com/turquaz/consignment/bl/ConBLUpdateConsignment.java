package com.turquaz.consignment.bl;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

/**
 * @author Huseyin Ergun
 * @version
 */
public class ConBLUpdateConsignment
{
	public ConBLUpdateConsignment()
	{
	}

	/**
	 * @param consignment
	 * @param docNo
	 * @param definition
	 * @param consignmentDate
	 * @param curCard
	 * @param discountAmount
	 * @param billDocNo
	 * @param vatAmount
	 * @param specialVatAmount
	 * @param totalAmount
	 * @param type
	 * @param exRate
	 * @throws Exception
	 */
	public static void updateConsignment(TurqConsignment consignment, String docNo, String definition, Date consignmentDate,
			TurqCurrentCard curCard, BigDecimal discountAmount, String billDocNo, BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, TurqCurrencyExchangeRate exRate, List invTransactions, List groups) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			if (groups != null)
			{
				//		Update its groups
				Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
				while (it.hasNext())
				{
					deleteObject(it.next());
				}
				if (groups != null)
				{
					for (int i = 0; i < groups.size(); i++)
					{
						ConBLAddConsignment.registerGroup((TurqConsignmentGroup) groups.get(i), consignment);
					}
				}
			}
			//Update Inventory Transactions
			Iterator it2 = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it2.hasNext())
			{
				EngDALCommon.deleteObject(it2.next());
			}
			for (int i = 0; i < invTransactions.size(); i++)
			{
				TurqInventoryTransaction invTrans = (TurqInventoryTransaction) invTransactions.get(i);
				ConBLAddConsignment.saveConsignmentRow(invTrans, consignment.getId(), type);
			}
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsType(type);
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			TurqBillConsignmentCommon common = consignment.getTurqBillConsignmentCommon();
			common.setBillDocumentNo(billDocNo);
			common.setCharges(new BigDecimal(0));
			common.setChargesInForeignCurrency(new BigDecimal(0));
			common.setTotalAmount(totalAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			common.setTotalAmountInForeignCurrency(totalAmount);
			common.setDiscountAmount(discountAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			common.setDiscountAmountInForeignCurrency(discountAmount);
			common.setVatAmount(vatAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			common.setVatAmountInForeignCurrency(vatAmount);
			common.setSpecialVatAmount(specialVatAmount.multiply(exRate.getExchangeRatio()).setScale(2, EngBLCommon.ROUNDING_METHOD));
			common.setSpecialVatAmountInForeignCurrency(specialVatAmount);
			common.setDiscountRate(0);
			common.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			common.setTurqCurrentCard(curCard);
			common.setConsignmentDocumentNo(docNo);
			EngDALCommon.updateObject(common);
			EngDALCommon.updateObject(consignment);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteConsignment(TurqConsignment consignment) throws Exception
	{
		try
		{
			//	      delete Consignment Group
			initiliazeConsignment(consignment);
			Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
			while (it.hasNext())
			{
				deleteObject(it.next());
			}
			//			delete Inventory Transaction
			it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it.hasNext())
			{
				deleteObject(it.next());
			}
			Object o = consignment.getTurqBillConsignmentCommon();
			deleteObject(consignment);
			deleteObject(o);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteObject(Object obj) throws Exception
	{
		try
		{
			EngDALCommon.deleteObject(obj);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initiliazeConsignment(TurqConsignment cons) throws Exception
	{
		try
		{
			ConDALUpdateConsignment.initiliazeConsignment(cons);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}