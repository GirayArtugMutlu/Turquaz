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
import java.util.HashMap;
import java.util.List;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class ConBLAddConsignment
{
	public static TurqConsignment saveConsignment(HashMap argMap)
			throws Exception
	{
		try
		{
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			Boolean isPrinted=(Boolean)argMap.get(ConsKeys.CONS_IS_PRINTED);
			Date consignmentDate=(Date)argMap.get(ConsKeys.CONS_DATE);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			};
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			List groups=(List)argMap.get(ConsKeys.CONS_GROUPS);
			List invTransactions=(List)argMap.get(InvKeys.INV_TRANSACTIONS);
			
			Calendar cal = Calendar.getInstance();
			TurqConsignment consignment = new TurqConsignment();
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsPrinted(isPrinted.booleanValue());
			consignment.setConsignmentsType(type.intValue());
			consignment.setTurqCurrentCard(curCard);
			consignment.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(cal.getTime());
			consignment.setCreationDate(cal.getTime());
			TurqEngineSequence engSeq = EngBLServer.saveEngineSequence(EngBLCommon.MODULE_CONSIGNMENT);
			consignment.setTurqEngineSequence(engSeq);
			consignment.setConsignmentDocumentNo(docNo);
			consignment.setTurqCurrencyExchangeRate(exchangeRate);
			consignment.setBillDocumentNo("");
			EngDALCommon.saveObject(consignment);
			// Then Save Inventory Transactions
			InvBLSaveTransaction.saveInventoryTransactions(invTransactions, engSeq.getId(), type.intValue(), consignmentDate, definition, docNo,
					exchangeRate, curCard);
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
	
	public static void saveConsignmentFromBill(String docNo,String billDocNo, String definition,Boolean isPrinted,Date consignmentDate,Integer type,TurqCurrentCard curCard, TurqCurrencyExchangeRate exRate, TurqEngineSequence engSeq)throws Exception
	{
		Calendar cal = Calendar.getInstance();
		TurqConsignment consignment = new TurqConsignment();
		consignment.setConsignmentsDate(consignmentDate);
		consignment.setConsignmentsDefinition(definition);
		consignment.setConsignmentsPrinted(isPrinted.booleanValue());
		consignment.setConsignmentsType(type.intValue());
		consignment.setTurqCurrentCard(curCard);
		consignment.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		consignment.setLastModified(cal.getTime());
		consignment.setCreationDate(cal.getTime());
		consignment.setTurqEngineSequence(engSeq);
		consignment.setConsignmentDocumentNo(docNo);
		consignment.setTurqCurrencyExchangeRate(exRate);
		consignment.setBillDocumentNo(billDocNo);
		EngDALCommon.saveObject(consignment);
		
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
			cardGroup.setLastModified(cal.getTime());
			cardGroup.setCreationDate(cal.getTime());
			EngDALCommon.saveObject(cardGroup);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}