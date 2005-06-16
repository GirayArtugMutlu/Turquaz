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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.dal.ConDALUpdateConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqConsignmentGroup;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.inventory.InvKeys;
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

	public static void updateConsignment(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqConsignment consignment=(TurqConsignment)argMap.get(ConsKeys.CONS);
			String docNo=(String)argMap.get(EngKeys.DOCUMENT_NO);
			String definition=(String)argMap.get(EngKeys.DEFINITION);
			//Boolean isPrinted=(Boolean)argMap.get(ConsKeys.CONS_IS_PRINTED);
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
			Boolean updateBills=(Boolean)argMap.get(ConsKeys.CONS_UPDATE_BILLS);
			
			
			Calendar cal = Calendar.getInstance();
			if (groups != null)
			{
				//		Update its groups
				Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
				while (it.hasNext())
				{
					EngDALCommon.deleteObject(it.next());
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
			InvBLSaveTransaction.saveInventoryTransactions(invTransactions, consignment.getTurqEngineSequence().getId(), type.intValue(),
					consignmentDate, definition, docNo, exchangeRate, curCard);
			consignment.setConsignmentsDate(consignmentDate);
			consignment.setConsignmentsDefinition(definition);
			consignment.setConsignmentsType(type.intValue());
			consignment.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			consignment.setLastModified(cal.getTime());
			consignment.setConsignmentDocumentNo(docNo);
			consignment.setTurqCurrencyExchangeRate(exchangeRate);
			consignment.setTurqCurrentCard(curCard);
			EngDALCommon.updateObject(consignment);
			
			if(updateBills.booleanValue())
			{
				updateConsignmentBills(consignment);
			}
			
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateConsignmentBills(TurqConsignment cons)throws Exception{
		
		ConDALUpdateConsignment.initiliazeConsignment(cons);
		Iterator it = cons.getTurqEngineSequence().getTurqBillInEngineSequences().iterator();
		if(it.hasNext())
		{			
			TurqBillInEngineSequence billEngSeq = (TurqBillInEngineSequence)it.next();
			BigDecimal results[] = BillBLAddBill.getTotalAndDiscountAmount(billEngSeq.getTurqBill());
			BillBLUpdateBill.deleteAccountingTransactions(billEngSeq.getTurqBill());
			BillBLUpdateBill.deleteCurrentTransactions(billEngSeq.getTurqBill());
			
            BillBLAddBill.saveCurrentTransaction(billEngSeq.getTurqBill(),results[0],results[1]);
			 
            EngDALCommon.initializeObject(billEngSeq.getTurqBill().getTurqEngineSequence(),"getTurqCashTransactions");
            TurqCashCard cashCard = null;
            Iterator it2 = billEngSeq.getTurqBill().getTurqEngineSequence().getTurqCashTransactions().iterator();
            while(it2.hasNext())
            {
               
              TurqCashTransaction cashTrans = (TurqCashTransaction)it2.next();
              EngDALCommon.initializeObject(cashTrans,"getTurqCashTransactionRows");
              Iterator it3 = cashTrans.getTurqCashTransactionRows().iterator();
              while(it3.hasNext())
              {
                  TurqCashTransactionRow transRow = (TurqCashTransactionRow)it3.next();
                  cashCard = transRow.getTurqCashCard();
                  
              }
                
                
            } 
            BillBLUpdateBill.deleteCashTransaction(billEngSeq.getTurqBill());
            BillBLAddBill.saveCashTransaction(billEngSeq.getTurqBill(),cashCard,results[0]);
            BillBLAddBill.saveAccountingTransaction(billEngSeq.getTurqBill(),cashCard,results[0]);			
		}
	}
	
	public static Integer deleteConsignment(TurqConsignment consignment) throws Exception
	{
		try
		{
			return deleteCons(consignment,false);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static Integer deleteConsignment(HashMap argMap) throws Exception
	{
		try
		{
			TurqConsignment consignment=(TurqConsignment)argMap.get(ConsKeys.CONS);
			return deleteCons(consignment,true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	private static Integer deleteCons(TurqConsignment consignment, boolean checkBill) throws Exception
	{
		try
		{
			if (checkBill)
			{
				if(consignment.getTurqEngineSequence().getTurqBillInEngineSequences().size()>0)
				{
					return new Integer(-1);
				}
			}
			Iterator it = consignment.getTurqConsignmentsInGroups().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			//			delete Inventory Transaction
			it = consignment.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it.hasNext())
			{
				EngDALCommon.deleteObject(it.next());
			}
			EngDALCommon.deleteObject(consignment);
			return new Integer(1);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqConsignment initiliazeConsignmentById(HashMap argMap) throws Exception
	{
		try
		{
			Integer consId=(Integer)argMap.get(ConsKeys.CONS_ID);
			return ConDALUpdateConsignment.initiliazeConsignmentById(consId);			
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
	
	public static void initiliazeConsignment(HashMap argMap) throws Exception
	{
		try
		{
			TurqConsignment cons=(TurqConsignment)argMap.get(ConsKeys.CONS);
			ConDALUpdateConsignment.initiliazeConsignment(cons);			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}