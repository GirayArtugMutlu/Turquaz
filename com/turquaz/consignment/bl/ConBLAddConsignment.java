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
import java.util.List;
import com.turquaz.consignment.dal.ConDALAddConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqModule;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class ConBLAddConsignment
{
	public ConBLAddConsignment()
	{
	}

	/**
	 * @param docNo
	 * @param definition
	 * @param isPrinted
	 * @param consignmentDate
	 * @param curCard
	 * @param discountAmount
	 * @param billDocNo
	 * @param vatAmount
	 * @param specialVatAmount
	 * @param totalAmount
	 * @param type
	 * @param exRate
	 * @return
	 * @throws Exception
	 */
	public static TurqConsignment saveConsignment(String docNo, String definition, boolean isPrinted, Date consignmentDate,
			TurqCurrentCard curCard, BigDecimal discountAmount, String billDocNo, BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, TurqCurrencyExchangeRate exRate, List invTransactions, List groups) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqConsignment consignment = new TurqConsignment();
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsPrinted(isPrinted);
			consignment.setConsignmentsType(type);
			consignment.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			consignment.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			TurqEngineSequence seq = new TurqEngineSequence();
			TurqModule module = new TurqModule();
			module.setId(new Integer(6));
			seq.setTurqModule(module);
			EngDALCommon.saveObject(seq);
			consignment.setTurqEngineSequence(seq);
			TurqBillConsignmentCommon common = new TurqBillConsignmentCommon();
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
			common.setConsignmentDocumentNo(docNo);
			common.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			common.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			common.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			common.setTurqCurrentCard(curCard);
			common.setTurqCurrencyExchangeRate(exRate);
			EngDALCommon.saveObject(common);
			consignment.setTurqBillConsignmentCommon(common);
			EngDALCommon.saveObject(consignment);
			// Then Save Inventory Transactions
			for (int i = 0; i < invTransactions.size(); i++)
			{
				TurqInventoryTransaction invTrans = (TurqInventoryTransaction) invTransactions.get(i);
				saveConsignmentRow(invTrans, consignment.getId(), type);
			}
			if (groups != null)
			{
				for (int i = 0; i < groups.size(); i++)
				{
					TurqConsignmentGroup consGroup = (TurqConsignmentGroup) groups.get(i);
					registerGroup(consGroup, consignment);
				}
			}
			return consignment;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @param invTrans
	 * @param consID
	 * @param consType
	 * @throws Exception
	 */
	public static void saveConsignmentRow(TurqInventoryTransaction invTrans, Integer consID, int consType) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqConsignment cons = ConDALAddConsignment.loadConsignment(consID);
			invTrans.setTurqEngineSequence(cons.getTurqEngineSequence());
			invTrans.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			invTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			invTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			invTrans.setTransactionsDate(cons.getConsignmentsDate());
			//Al??
			// total amount in ve total amount ayni girilmisti
			// bir tanesi sifir yapmak gerek
			if (consType == 0)
			{
				invTrans.setTransactionsTotalAmountOut(new BigDecimal(0));
			}
			//	Sat??
			else
			{
				invTrans.setTransactionsAmountIn(new BigDecimal(0));
			}
			EngDALCommon.saveObject(invTrans);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void registerGroup(TurqConsignmentGroup grp, TurqConsignment cons) throws Exception
	{
		try
		{
			Calendar cal = Calendar.getInstance();
			TurqConsignmentsInGroup cardGroup = new TurqConsignmentsInGroup();
			TurqConsignmentGroup group = (TurqConsignmentGroup) grp;
			cardGroup.setTurqConsignment(cons);
			cardGroup.setTurqConsignmentGroup(group);
			cardGroup.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cardGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			cardGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			EngDALCommon.saveObject(cardGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}