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

import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLAddBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.common.HashBag;
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
import com.turquaz.engine.dal.TurqConsignmentsInGroup;
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
            Integer consId = (Integer)argMap.get(ConsKeys.CONS_ID);
			TurqConsignment consignment=(TurqConsignment)EngDALSessionFactory.getSession().load(TurqConsignment.class,consId);
		
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
						ConBLAddConsignment.registerGroup((Integer) groups.get(i), consignment);
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
    public static Integer deleteConsignmentById(HashMap argMap) throws Exception
    {
        try
        {
            Integer consId=(Integer)argMap.get(ConsKeys.CONS_ID);
            TurqConsignment consignment = ConDALUpdateConsignment.initiliazeConsignmentById(consId);
            
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
    public static HashBag getConsignmentInfo(HashMap argMap) throws Exception
    {
        HashBag returnBag = new HashBag();
        
        try
        {
            Integer consId=(Integer)argMap.get(ConsKeys.CONS_ID);
            TurqConsignment cons= ConDALUpdateConsignment.initiliazeConsignmentById(consId);     
            
            Boolean hasBill = new Boolean(cons.getTurqEngineSequence().getTurqBillInEngineSequences().isEmpty());
            returnBag.put(ConsKeys.CONS_HAS_BILL,hasBill);
            returnBag.put(ConsKeys.CONS_ID,consId);
            returnBag.put(CurKeys.CUR_CURRENT_NAME,cons.getTurqCurrentCard().getCardsName());
            returnBag.put(CurKeys.CUR_CURRENT_CODE,cons.getTurqCurrentCard().getCardsCurrentCode());
            returnBag.put(EngKeys.DATE,cons.getConsignmentsDate());
            returnBag.put(EngKeys.DOCUMENT_NO,cons.getConsignmentDocumentNo());
            returnBag.put(EngKeys.DESCRIPTION,cons.getConsignmentsDefinition());
            returnBag.put(ConsKeys.CONS_BILL_DOC_NO,cons.getBillDocumentNo());

            Integer type = new Integer (cons.getConsignmentsType());
            returnBag.put(EngKeys.TYPE,type);
            returnBag.put(BillKeys.BILL_DOC_NO,cons.getBillDocumentNo());

            Iterator it = cons.getTurqEngineSequence().getTurqBillInEngineSequences().iterator();
            if(it.hasNext())
            {
                TurqBillInEngineSequence billEng = (TurqBillInEngineSequence)it.next();
                returnBag.put(BillKeys.BILL_DOC_NO,billEng.getTurqBill().getBillDocumentNo());
                returnBag.put(BillKeys.BILL_DATE,billEng.getTurqBill().getBillsDate());
            }
            
            TurqConsignmentsInGroup group;
            it = cons.getTurqConsignmentsInGroups().iterator();
            
            int i = 0;
            while (it.hasNext())
            {
                group = (TurqConsignmentsInGroup) it.next();
                group.getTurqConsignmentGroup();
              
                
                returnBag.put(ConsKeys.CONS_GROUPS,i,AdmKeys.ADM_GROUP_ID, group.getTurqConsignmentGroup().getId());
                i++;
            }
            
            
            
        }
        catch (Exception ex)
        {
            throw ex;
        }
        
        return returnBag;
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