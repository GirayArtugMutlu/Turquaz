package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.consignment.bl.ConBLAddConsignment;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;

import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.bl.InvBLCardSearch;

public class BillBLAddBill {

	public BillBLAddBill() {

	}
	
	//Bill from Bill
	public static TurqBill saveBillFromBill(String consignemtDocNo, String definition,
						boolean isPrinted, Date billsDate,int type,
						boolean isOpen, TurqCurrentCard currentCard,
						TurqAccountingAccount cashAccount,
						Date dueDate,BigDecimal discountAmount, String billDocNo,
						BigDecimal vatAmount, BigDecimal specialVatAmount,
						BigDecimal totalAmount,TurqCurrencyExchangeRate exRate,
						List billGroups,List invTransactions )throws Exception{
		
		ConBLAddConsignment blConsAdd = new ConBLAddConsignment();
	
		// First Save Consignment
		TurqConsignment cons = blConsAdd.saveConsignment(consignemtDocNo,definition,isPrinted,billsDate,currentCard,discountAmount,billDocNo,vatAmount,specialVatAmount,totalAmount,type,exRate,invTransactions,null);
	

	
		TurqBill bill = registerBill(billDocNo,definition,isPrinted,billsDate,cons,type,isOpen,cashAccount,dueDate);
	
		//Then Save Bill Groups
		saveBillGroups(bill.getId(),billGroups);
		return bill;
	
	}
	
	public static void saveBillGroups(Integer billId,List billGroups)throws Exception
	{
		for(int i=0;i<billGroups.size();i++)
		{
			TurqBillGroup group = (TurqBillGroup)billGroups.get(i);
			registerGroup(group,billId);
			
		}	
	}
	
	/****************************************************************************/
	//B?ll from consignment
    public static TurqBill saveBillFromCons(String docNo, String definition,
			boolean isPrinted, Date billsDate, TurqConsignment cons, int type,
			boolean isOpen, TurqAccountingAccount cashAccount, Date dueDate,List billGroups)
			throws Exception {
    	try
		{
		
    		// Save Bill 
		
    		TurqBill bill = registerBill(docNo,definition,isPrinted,billsDate,cons,type,isOpen,cashAccount,dueDate);
		
    		//Then Save Bill Groups
    		saveBillGroups(bill.getId(),billGroups);
		
    		return bill;

		}
    	catch (Exception ex)
		{
    		throw ex;
		}
    }
	/*****************************************************************************/
	/**
	 * 
	 * @param docNo
	 * @param definition
	 * @param isPrinted
	 * @param billsDate
	 * @param cons
	 * @param type
	 * @param isOpen
	 * @param currentAccount
	 * @param dueDate
	 * @return
	 * @throws Exception
	 */
	private static TurqBill registerBill(String docNo, String definition,
				boolean isPrinted, Date billsDate, TurqConsignment cons, int type,
				boolean isOpen, TurqAccountingAccount cashAccount, Date dueDate)
				throws Exception {
		try 
		{
			
			TurqBill bill = new TurqBill();
			bill.setBillsDate(billsDate);
			bill.setBillsDefinition(definition);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsType(type);

			bill.setCreatedBy(System.getProperty("user"));
			bill.setUpdatedBy(System.getProperty("user"));
			
			Calendar cal=Calendar.getInstance();
			bill.setLastModified(cal.getTime());
			bill.setCreationDate(cal.getTime());
			bill.setIsOpen(isOpen);
			bill.setDueDate(dueDate);

			TurqBillConsignmentCommon common = cons
					.getTurqBillConsignmentCommon();
			common.setBillDocumentNo(docNo);

			bill.setTurqBillConsignmentCommon(common);

			TurqEngineSequence seqDocId = cons.getTurqEngineSequence();
			/*
			 * TODO Incelenmesi gerek TurqModule module = new TurqModule();
			 * module.setModulesId(new Integer(7));
			 * seqDocId.setTurqModule(module);
			 * 
			 * dalBill.save(seqDocId);
			 */
			bill.setTurqEngineSequence(seqDocId);

			EngDALCommon.saveObject(bill);

			saveCurrentTransaction(bill);
			saveAccountingTransaction(bill, cashAccount);

			return bill;

		} 
		catch (Exception ex) {
			throw ex;
		}
	}
/**
 * 
 * @param bill
 * @throws Exception
 */
	public static void saveCurrentTransaction(TurqBill bill) throws Exception {
		try {

			TurqBillConsignmentCommon common = bill
					.getTurqBillConsignmentCommon();
			String curTransDef = DatePicker.formatter.format(bill
					.getBillsDate())
					+ " " + common.getBillDocumentNo() + " Ref. Fatura";

			//Al?? Faturas?
			if (bill.getBillsType() == 0) {
//	          TODO current trans exRate
				CurBLCurrentTransactionAdd.saveCurrentTransaction(common.getTurqCurrentCard(),
						bill.getBillsDate(), common.getBillDocumentNo(), true,
						common.getTotalAmount(), common.getDiscountAmount(), 1,
						bill.getTurqEngineSequence().getId(),
						curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				if (!bill.isIsOpen()) {
//		          TODO current trans exRate
					CurBLCurrentTransactionAdd
							.saveCurrentTransaction(
									common.getTurqCurrentCard(), bill
											.getBillsDate(), common
											.getBillDocumentNo(), false, common
											.getTotalAmount(), common
											.getDiscountAmount(), 4, bill
											.getTurqEngineSequence()
											.getId(),
									curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());
				}

			}

			//Sat?? Faturas?
			else if (bill.getBillsType() == 1) {
//	          TODO current trans exRate
				CurBLCurrentTransactionAdd.saveCurrentTransaction(common.getTurqCurrentCard(),
						bill.getBillsDate(), common.getBillDocumentNo(), false,
						common.getTotalAmount(), common.getDiscountAmount(), 1,
						bill.getTurqEngineSequence().getId(),
						curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());

				//Kapal? Fatura
				if (!bill.isIsOpen()) {
//		          TODO current trans exRate
					CurBLCurrentTransactionAdd.saveCurrentTransaction(common
							.getTurqCurrentCard(), bill.getBillsDate(), common
							.getBillDocumentNo(), true,
							common.getTotalAmount(),
							common.getDiscountAmount(), 4, bill
									.getTurqEngineSequence()
									.getId(), curTransDef,EngBLCommon.getBaseCurrencyExchangeRate());
				}
			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	/**
	 * 
	 * @param bill
	 * @param currentAccount
	 * @throws Exception
	 */
	
	public static void prepareAccountsForAccountingIntgretion(TurqBill bill, TurqAccountingAccount cashAccount, Map creditAccounts, Map deptAccounts)throws Exception
	{
	
		creditAccounts.clear();
		deptAccounts.clear();
		
		TurqBillConsignmentCommon common = bill
		.getTurqBillConsignmentCommon();
		
		Map invRows = null ;
		Map currentRows = null;
		
		int INV_ACCOUNT =-1;
		int INV_VAT_ACCOUNT =-1;
		int INV_SPEC_VAT_ACCOUNT = -1;
		int INV_DISCOUNT_ACCOUNT = -1;
		String discountAccount ="";
		
		
		//Alis Faturasi
		if (bill.getBillsType() == EngBLCommon.BILL_TRANS_TYPE_BUY) 
		{
			invRows = deptAccounts;
			currentRows = creditAccounts;
			
			INV_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_BUY;
			INV_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_VAT_BUY;
			INV_SPEC_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_SPEC_VAT_BUY;
			INV_DISCOUNT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_DISCOUNT_BUY;
			discountAccount = "649";
			
			
			
		}
		//Satis Faturasi
		else if(bill.getBillsType() == EngBLCommon.BILL_TRANS_TYPE_SELL)
		{
			invRows = creditAccounts;
			currentRows = deptAccounts;
			
			INV_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_SELL;
			INV_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_VAT_SELL;
			INV_SPEC_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_SPEC_VAT_SELL;
			INV_DISCOUNT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_DISCOUNT_SELL;
			discountAccount ="611";
			
		}
		
		TurqInventoryTransaction invTrans = null;
		
		Iterator it = getInventoryTransactions(bill).iterator();
		BigDecimal totals = new BigDecimal(0);
	
		while (it.hasNext()) {		
			
			/*
			 * Inventory Rows
			 */
			
			invTrans = (TurqInventoryTransaction)it.next();
			
			TurqAccountingAccount buyAccount=InvBLCardSearch.getInventoryAccount(invTrans
					.getTurqInventoryCard().getId(),INV_ACCOUNT);
	
			
				if(!invRows.containsKey(buyAccount.getId()))
				{						
					invRows.put(buyAccount.getId(),new ArrayList());						
				}
				
	     
	       List ls = (List)invRows.get(buyAccount.getId());
	       ls.add(invTrans.getTransactionsTotalPrice());
	       invRows.put(buyAccount.getId(),ls);
	      
	       /*
	        * VAT ROWs
	        */
	       
	       TurqAccountingAccount buyVATAccount =InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
				INV_VAT_ACCOUNT);
	       
	       if(!invRows.containsKey(buyVATAccount.getId()))
			{						
				invRows.put(buyVATAccount.getId(),new ArrayList());						
			}
			
           List vatList = (List)invRows.get(buyVATAccount.getId());
           vatList.add(invTrans.getTransactionsVatAmount());
	     
	       invRows.put(buyVATAccount.getId(),vatList);
			
	
		   /*
		    * Special VAT Rows
		    */
	       
	       TurqAccountingAccount specialVATBuyAccount=InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
				INV_SPEC_VAT_ACCOUNT);
	       
	       if(!invRows.containsKey(specialVATBuyAccount.getId()))
			{						
				invRows.put(specialVATBuyAccount.getId(),new ArrayList());						
			}
	       
	       List specVatList = (List)invRows.get(specialVATBuyAccount.getId());
	       specVatList.add(invTrans.getTransactionsVatSpecialAmount());
	     
	       invRows.put(specialVATBuyAccount.getId(),specVatList);
			
	       
	       /*
	        * DiscountRows
	        * 
	        */
	      
	       TurqAccountingAccount discountBuyAccount=InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
				INV_DISCOUNT_ACCOUNT);
	       if(discountBuyAccount==null)
	       {
	       	discountBuyAccount = AccDALAccountAdd.getAccount(discountAccount);
	       }
	       
	    
	       
	       if(!currentRows.containsKey(discountBuyAccount.getId()))
	       {
	       	currentRows.put(discountBuyAccount.getId(),new ArrayList());
	       }
	       
	       List discountList = (List)currentRows.get(discountBuyAccount.getId());
	       discountList.add(invTrans.getTransactionsDiscount());
	       currentRows.put(discountBuyAccount.getId(),discountList);
	      	       
	   }	
		
		/*
		 * Cari Kayitlari
		 * 
		 * 		
		 */
		
		
		TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(bill
				.getTurqBillConsignmentCommon().getTurqCurrentCard(),EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
		
		
		List curList = (List)currentRows.get(curAccount.getId());
		if(curList == null)
		{
			curList = new ArrayList();
			
		}		
		curList.add(common.getTotalAmount());
		currentRows.put(curAccount.getId(),curList);
		
		
		//Kapali Fatura 
		
		if (!bill.isIsOpen()&&cashAccount!=null) {
		
			List list = (List)invRows.get(curAccount.getId());
				if(list == null)
				{
					list = new ArrayList();
				}
		
			list.add(common.getTotalAmount());
			invRows.put(curAccount.getId(),list);
		
		/*********************************************************/
			
			list = (List)currentRows.get(cashAccount.getId());
			if(list==null)
			{
			 list = new ArrayList();	
			}
		    list.add(common.getTotalAmount());	
			currentRows.put(cashAccount.getId(),list);
			
		}		
		
		
		
		
	}
	
	public static void saveAccountingTransaction(TurqBill bill, TurqAccountingAccount cashAccount) throws Exception
	{
		
		Map creditAccounts = new HashMap();
		Map deptAccounts = new HashMap();
		TurqBillConsignmentCommon common = bill.getTurqBillConsignmentCommon();

		String billDefinition = "FT "
		
		+ bill.getTurqBillConsignmentCommon().getBillDocumentNo()
		+ " "
		+ bill.getTurqBillConsignmentCommon().getTurqCurrentCard()
				.getCardsName();
		
		
		prepareAccountsForAccountingIntgretion(bill,cashAccount,creditAccounts, deptAccounts);
		
		/**
		 * TODO exRate
		 */
		boolean isSaved = AccBLTransactionAdd.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(), 2,EngBLCommon.MODULE_BILL,bill.getTurqEngineSequence().getId(),billDefinition,EngBLCommon.getBaseCurrencyExchangeRate(),creditAccounts,deptAccounts,true);
		
		
	}
	
	
	
	/**
	 * 
	 * @param grp
	 * @param billId
	 * @throws Exception
	 */
	public static void registerGroup(TurqBillGroup grp, Integer billId)
			throws Exception {
		try {
			TurqBillInGroup cardGroup = new TurqBillInGroup();
			TurqBill card = new TurqBill();
			card.setId(billId);
			cardGroup.setTurqBill(card);
			cardGroup.setTurqBillGroup(grp);

			cardGroup.setCreatedBy(System.getProperty("user"));
			cardGroup.setUpdatedBy(System.getProperty("user"));
			
			Calendar cal=Calendar.getInstance();
			cardGroup.setLastModified(cal.getTime());
			cardGroup.setCreationDate(cal.getTime());

			EngDALCommon.saveObject(cardGroup);

		} catch (Exception ex) {
			throw ex;
		}

	}

	public static Set getInventoryTransactions(TurqBill bill) throws Exception {
		try {

			return BillDALAddBill.getInvTransactions(bill);

		} catch (Exception ex) {
			throw ex;
		}
	}

}