package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

public class BillBLUpdateBill 
{
	public BillBLUpdateBill()
	{
	}

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

	public static void deleteBillConsignment(TurqBill bill) throws Exception
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
	}

	public static void deleteBill(TurqBill bill, boolean deleteCons) throws Exception
	{
		deleteAccountingTransactions(bill);
		deleteCurrentTransactions(bill);
		deleteBillGroups(bill);
		EngDALCommon.deleteObject(bill);
		if (deleteCons)
		{
			deleteBillConsignment(bill);
		}
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
	public static void updateBill(TurqBill bill, String billNo, String consNo, String definition, boolean isPrinted, 
			Date billDate, TurqCurrentCard curCard, BigDecimal discountAmount, BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, Date dueDate, List invTransactions, List groups,
			TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		try
		{		
			
			updateBillInfo(bill,curCard,billDate,definition,billNo, isPrinted, dueDate,type,true,exchangeRate);
			
			updateInventoryTransactions(bill, invTransactions);
			
			updateBillGroups(bill, groups);
			//Update Transactions
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
			//XXX update methods should be re-written..
			BillBLAddBill.saveCurrentTransaction(bill,totalAmount, discountAmount);
			
			EngDALCommon.updateObject(bill);
			
			BillBLAddBill.saveAccountingTransaction(bill,totalAmount);
		
			
			
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static int updateInventoryTransactions(TurqBill bill, List invTransactions)throws Exception
	{
		try{
		Set billInEngSeqs = bill.getTurqBillInEngineSequences();
		if(billInEngSeqs.size()>1)
		{
			return EngBLCommon.BILL_ERR_TOO_MANY_CONS;
		}
		else
		{
			Iterator it = billInEngSeqs.iterator();
			if(it.hasNext())
			{
				TurqBillInEngineSequence billInSeq = (TurqBillInEngineSequence)it.next();
				Iterator itInvTrans = billInSeq.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
				while(itInvTrans.hasNext()){
					
					EngDALCommon.deleteObject(itInvTrans.next());
					
				}
				
				InvBLSaveTransaction.saveInventoryTransactions(invTransactions,billInSeq.getTurqEngineSequence().getId(),bill.getBillsType(),bill.getBillsDate(),bill.getBillsDefinition(),bill.getBillDocumentNo(),bill.getTurqCurrencyExchangeRate(),bill.getTurqCurrentCard());
				
				return EngBLCommon.BILL_SAVED_SUCCESFULLY;
							
			}
			
			
			Logger logger = Logger.getLogger(BillBLUpdateBill.class);
			logger.debug("Something went wrong: BillBLUpdateBill line: 154");
			return EngBLCommon.BILL_ERR_OTHER;
			
		}
		}
		catch(Exception ex)
		{
			throw ex;
		
		}
		
		
		
	}
	

	public static void updateBillInfo(TurqBill bill,TurqCurrentCard curCard, Date billDate, String definition,String billDocNo, boolean isPrinted, Date dueDate, int type,
			boolean isOpen,TurqCurrencyExchangeRate exRate) throws Exception
	{
		
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

	

	public static void updateBillGroups(TurqBill bill, List billGroups) throws Exception
	{
		deleteBillGroups(bill);
		for (int i = 0; i < billGroups.size(); i++)
		{
			BillBLAddBill.registerGroup((TurqBillGroup) billGroups.get(i), bill.getId());
		}
	}

	public static void deleteBillGroups(TurqBill bill) throws Exception
	{
		Iterator it = bill.getTurqBillInGroups().iterator();
		while (it.hasNext())
		{
			EngDALCommon.deleteObject(it.next());
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

	public static boolean canUpdateBill(TurqBill bill) throws Exception
	{
		try
		{
			return BillDALUpdateBill.canUpdateBill(bill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}