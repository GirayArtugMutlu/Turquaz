package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;

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
			Iterator it2=((TurqBillInEngineSequence)it.next()).getTurqEngineSequence().getTurqConsignments().iterator();
			while(it2.hasNext())
			{
				TurqConsignment cons = (TurqConsignment) it2.next();
				ConBLUpdateConsignment.initiliazeConsignment(cons);
				ConBLUpdateConsignment.deleteConsignment(cons);
			}
		}
	}

	public static void deleteBill(TurqBill bill,boolean deleteCons) throws Exception
	{
		deleteAccountingTransactions(bill);
		deleteCurrentTransactions(bill);
		deleteBillGroups(bill);
		EngDALCommon.deleteObject(bill);
		if(deleteCons)
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
	public static void updateBill(TurqBill bill, String billNo, String consNo, String definition, boolean isPrinted, boolean isOpen,
			Date billDate, TurqCurrentCard curCard, BigDecimal discountAmount, BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, TurqAccountingAccount cashAccount, Date dueDate, List invTransactions, List groups,
			TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		try
		{
			updateBillConsignments(bill, consNo, definition, billDate, curCard, discountAmount, billNo, vatAmount, specialVatAmount,
					totalAmount, type, exchangeRate, invTransactions);
			updateBillGroups(bill, groups);
			//Update Transactions
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
			//XXX update methods should be re-written..
			//BillBLAddBill.saveCurrentTransaction(bill);
			//BillBLAddBill.saveAccountingTransaction(bill, cashAccount);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void updateBillInfo(TurqBill bill, Date billDate, String definition, boolean isPrinted, Date dueDate, int type,
			boolean isOpen) throws Exception
	{
		bill.setBillsDate(billDate);
		bill.setBillsDefinition(definition);
		bill.setBillsPrinted(isPrinted);
		bill.setDueDate(dueDate);
		bill.setBillsType(type);
		bill.setIsOpen(isOpen);
		bill.setUpdatedBy(System.getProperty("user"));
		Calendar cal = Calendar.getInstance();
		bill.setLastModified(cal.getTime());
		EngDALCommon.updateObject(bill);
	}

	public static void updateBillConsignments(TurqBill bill, String consNo, String definition, Date billDate, TurqCurrentCard curCard,
			BigDecimal discountAmount, String billNo, BigDecimal vatAmount, BigDecimal specialVatAmount, BigDecimal totalAmount,
			int type, TurqCurrencyExchangeRate exchangeRate, List invTransactions) throws Exception
	{
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		while (it.hasNext())
		{
			Iterator it2=((TurqBillInEngineSequence)it.next()).getTurqEngineSequence().getTurqConsignments().iterator();
			while (it2.hasNext())
			{
				TurqConsignment cons = (TurqConsignment) it.next();
				ConBLUpdateConsignment.updateConsignment(cons, consNo, definition, billDate, curCard, 
						type, exchangeRate, invTransactions, null);
			}
		}
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