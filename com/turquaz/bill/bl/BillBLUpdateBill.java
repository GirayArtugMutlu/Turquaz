package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

public class BillBLUpdateBill
{
	public static void deleteCurrentTransactions(TurqBill bill) throws Exception
	{
		try
		{
			BillDALUpdateBill.deleteCurrentTransactions(bill.getId().intValue());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteAccountingTransactions(TurqBill bill) throws Exception
	{
		try
		{
			BillDALUpdateBill.deleteAccountingTransactions(bill.getId().intValue());
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void deleteBillConsignment(TurqBill bill) throws Exception
	{
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		while (it.hasNext())
		{
			Iterator it2 = ((TurqBillInEngineSequence) it.next()).getTurqEngineSequence().getTurqConsignments().iterator();
			while (it2.hasNext())
			{
				TurqConsignment cons = (TurqConsignment) it2.next();
				ConBLUpdateConsignment.initiliazeConsignment(cons);
				ConBLUpdateConsignment.deleteConsignment(cons);
			}
		}
		EngDALSessionFactory.getSession().clear();
	}

	private static void deleteBillInEngineSequences(TurqBill bill) throws Exception
	{
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}

	private static boolean hasBillConsignments(TurqBill bill) throws Exception
	{
		boolean hasCons = false;
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		while (it.hasNext())
		{
			TurqBillInEngineSequence billEngSeq = (TurqBillInEngineSequence) it.next();
			TurqEngineSequence seq = billEngSeq.getTurqEngineSequence();
			EngDALCommon.initializeObject(seq, "getTurqConsignments");
			if (seq.getTurqConsignments().size() > 0)
			{
				hasCons = true;
			}
		}
		return hasCons;
	}
	
	private static void deleteInventoryTransactions(TurqBill bill)throws Exception
	{
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		if (it.hasNext())
		{
			TurqBillInEngineSequence billInSeq = (TurqBillInEngineSequence) it.next();
			
			EngDALCommon.initializeObject(billInSeq.getTurqEngineSequence(),"getTurqInventoryTransactions");
			Iterator itInvTrans = billInSeq.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			
			while (itInvTrans.hasNext())
			{
				EngDALCommon.deleteObject(itInvTrans.next());
			}			
		}
		
	}
    
    public static void deleteCashTransaction(TurqBill bill)throws Exception
    {
        if(bill.isIsOpen())
        {
            return;
        }
        else
        {
            EngDALCommon.initializeObject(bill.getTurqEngineSequence(),"getTurqCashTransactions");
            
            Iterator it = bill.getTurqEngineSequence().getTurqCashTransactions().iterator();
            while(it.hasNext())
            {
                CashBLCashTransactionUpdate.deleteOnlyCashTransaction((TurqCashTransaction)it.next());
            }
        }
        
    }

	public static void deleteBill(HashMap argMap) throws Exception
	{
		TurqBill bill=(TurqBill)argMap.get(BillKeys.BILL);
		Boolean deleteCons=(Boolean)argMap.get(BillKeys.BILL_DELETE_CONS);
		deleteAccountingTransactions(bill);
		deleteCurrentTransactions(bill);
        deleteCashTransaction(bill);
		deleteBillGroups(bill);
		if (hasBillConsignments(bill))
		{
			if (deleteCons.booleanValue())
			{
				deleteBillConsignment(bill);
			}
		}
		else
		{  
			deleteInventoryTransactions(bill);
		}
		deleteBillInEngineSequences(bill);
		
		EngDALCommon.deleteObject(bill);
	}

	/**
	 * @param bill
	 * @param docNo
	 * @param definition
	 * @param isPrinted
	 * @param isOpen
	 * @param billDate
	 * @param curCard
	 * @param discountAmount
	 * @param vatAmount
	 * @param specialVatAmount
	 * @param totalAmount
	 * @param type
	 * @param currentAccount
	 * @param dueDate
	 * @throws Exception
	 */
	public static int[] updateBill(HashMap argMap)
			throws Exception
	{
		try
		{
			TurqBill bill=(TurqBill)argMap.get(BillKeys.BILL);
			String billNo=(String)argMap.get(BillKeys.BILL_DOC_NO);
			String definition=(String)argMap.get(BillKeys.BILL_DEFINITION);
			Boolean isPrinted=(Boolean)argMap.get(BillKeys.BILL_IS_PRINTED);
			Date billDate=(Date)argMap.get(BillKeys.BILL_DATE);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqCurrentCard curCard=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
			Date dueDate=(Date)argMap.get(BillKeys.BILL_DUE_DATE);
			BigDecimal discountAmount=(BigDecimal)argMap.get(BillKeys.BILL_DISCOUNT_AMOUNT);			
			BigDecimal totalAmount=(BigDecimal)argMap.get(BillKeys.BILL_TOTAL_AMOUNT);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			List billGroups=(List)argMap.get(BillKeys.BILL_GROUPS);
			List invTransactions=(List)argMap.get(InvKeys.INV_TRANSACTIONS);			
			Integer billCheck=(Integer)argMap.get(BillKeys.BILL_CHECK);
			TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
            Boolean isOpen = (Boolean)argMap.get(BillKeys.BILL_IS_OPEN);
            
			int result[] = new int[2];
			updateBillInfo(bill, curCard, billDate, definition, billNo, isPrinted.booleanValue(), dueDate, type.intValue(),isOpen.booleanValue(), exchangeRate,billCheck);
			result[0] = updateInventoryTransactions(bill, invTransactions);
			updateBillGroups(bill, billGroups);
			//Update Transactions
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
            deleteCashTransaction(bill);
			BillBLAddBill.saveCurrentTransaction(bill, totalAmount, discountAmount);
			EngDALCommon.updateObject(bill);
			result[1] = BillBLAddBill.saveAccountingTransaction(bill,cashCard,totalAmount);
            BillBLAddBill.saveCashTransaction(bill,cashCard,totalAmount);
			return result;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static int updateInventoryTransactions(TurqBill bill, List invTransactions) throws Exception
	{
		try
		{
			Set billInEngSeqs = bill.getTurqBillInEngineSequences();
			if (billInEngSeqs.size() > 1)
			{
				return EngBLCommon.BILL_ERR_TOO_MANY_CONS;
			}
			else
			{
				Iterator it = billInEngSeqs.iterator();
				if (it.hasNext())
				{
					TurqBillInEngineSequence billInSeq = (TurqBillInEngineSequence) it.next();
					Iterator itInvTrans = billInSeq.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
					while (itInvTrans.hasNext())
					{
						EngDALCommon.deleteObject(itInvTrans.next());
					}
					InvBLSaveTransaction.saveInventoryTransactions(invTransactions, billInSeq.getTurqEngineSequence().getId(), bill
							.getBillsType(), bill.getBillsDate(), bill.getBillsDefinition(), bill.getBillDocumentNo(), bill
							.getTurqCurrencyExchangeRate(), bill.getTurqCurrentCard());
					return EngBLCommon.BILL_SAVED_SUCCESFULLY;
				}
				Logger logger = Logger.getLogger(BillBLUpdateBill.class);
				logger.debug("Something went wrong: BillBLUpdateBill line: 154");
				return EngBLCommon.BILL_ERR_OTHER;
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	private static void updateBillInfo(TurqBill bill, TurqCurrentCard curCard, Date billDate, String definition, String billDocNo,
			boolean isPrinted, Date dueDate, int type, boolean isOpen, TurqCurrencyExchangeRate exRate, Integer billCheck) throws Exception
	{
		
		BillBLAddBill.checkBillDocNo(billDocNo,billCheck,type,curCard.getId(),bill.getId());
		bill.setBillDocumentNo(billDocNo);
		bill.setBillsDate(billDate);
		bill.setBillsDefinition(definition);
		bill.setBillsPrinted(isPrinted);
		bill.setDueDate(dueDate);
		bill.setBillsType(type);
		bill.setIsOpen(isOpen);
		bill.setTurqCurrentCard(curCard);
		bill.setUpdatedBy(System.getProperty("user"));
		Calendar cal = Calendar.getInstance();
		bill.setLastModified(cal.getTime());
		bill.setTurqCurrencyExchangeRate(exRate);
	}

	private static void updateBillGroups(TurqBill bill, List billGroups) throws Exception
	{
		deleteBillGroups(bill);
		for (int i = 0; i < billGroups.size(); i++)
		{
			BillBLAddBill.registerGroup((TurqBillGroup) billGroups.get(i), bill.getId());
		}
	}

	private static void deleteBillGroups(TurqBill bill) throws Exception
	{
		Iterator it = bill.getTurqBillInGroups().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
		}
	}
}