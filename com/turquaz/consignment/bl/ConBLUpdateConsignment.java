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
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

/**
 * @author Huseyin Ergun
 * @version
 */
public class ConBLUpdateConsignment
{
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
			TurqCurrentCard curCard, int type, TurqCurrencyExchangeRate exchangeRate, List invTransactions, List groups) throws Exception
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
			InvBLSaveTransaction.saveInventoryTransactions(invTransactions,consignment.getTurqEngineSequence().getId(),type,consignmentDate,definition,docNo,exchangeRate);
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsType(type);
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(cal.getTime());
			consignment.setConsignmentDocumentNo(docNo);
			consignment.setTurqCurrencyExchangeRate(exchangeRate);
			consignment.setTurqCurrentCard(curCard);
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
			deleteObject(consignment);
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