package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionAdd;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLAddConsignment;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.exceptions.TurquazException;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

public class BillBLAddBill
{
	//Bill from Bill
	public static Integer saveBillFromBill(HashMap argMap)
			throws Exception
	{
		TurqBill bill=(TurqBill)argMap.get(BillKeys.BILL);
		String definition=(String)argMap.get(BillKeys.BILL_DEFINITION);
		Boolean isPrinted=(Boolean)argMap.get(BillKeys.BILL_IS_PRINTED);
		Date billsDate=(Date)argMap.get(BillKeys.BILL_DATE);
		Integer type=(Integer)argMap.get(EngKeys.TYPE);
		TurqCurrentCard currentCard=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
		Date dueDate=(Date)argMap.get(BillKeys.BILL_DUE_DATE);
		Date consDate = (Date)argMap.get(ConsKeys.CONS_DATE);
		String consDocNo = (String)argMap.get(ConsKeys.CONS_DOC_NO);
		BigDecimal discountAmount=(BigDecimal)argMap.get(BillKeys.BILL_DISCOUNT_AMOUNT);
		String billDocNo=(String)argMap.get(BillKeys.BILL_DOC_NO);
		BigDecimal totalAmount=(BigDecimal)argMap.get(BillKeys.BILL_TOTAL_AMOUNT);
		TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
		List billGroups=(List)argMap.get(BillKeys.BILL_GROUPS);
		List invTransactions=(List)argMap.get(InvKeys.INV_TRANSACTIONS);
		Boolean saveCons = (Boolean)argMap.get(BillKeys.BILL_SAVE_CONS);
		Integer billCheck=(Integer)argMap.get(BillKeys.BILL_CHECK);
		Boolean isOpen = (Boolean)argMap.get(BillKeys.BILL_IS_OPEN);
        TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
        
        
		registerBill(bill,billDocNo, definition, isPrinted.booleanValue(), billsDate, type.intValue(), dueDate, currentCard, exchangeRate,billCheck,isOpen.booleanValue());
		TurqEngineSequence engSeq = EngBLCommon.saveEngineSequence(EngBLCommon.MODULE_BILL);
		TurqBillInEngineSequence billInEng = new TurqBillInEngineSequence();
		billInEng.setTurqEngineSequence(engSeq);
		billInEng.setTurqBill(bill);
		EngDALCommon.saveObject(billInEng);
		InvBLSaveTransaction.saveInventoryTransactions(invTransactions, engSeq.getId(), type.intValue(), billsDate, definition, billDocNo,
				exchangeRate, currentCard);
		saveCurrentTransaction(bill, totalAmount, discountAmount);
		saveBillGroups(bill.getId(), billGroups);
		if(consDocNo!=null&&consDate!=null&&saveCons.booleanValue())
		{
			ConBLAddConsignment.saveConsignmentFromBill(consDocNo,billDocNo,definition,isPrinted,consDate,type,currentCard,exchangeRate,engSeq);
		}		
        System.out.println(totalAmount);
        saveCashTransaction(bill,cashCard,totalAmount);
       
        int result = saveAccountingTransaction(bill,cashCard,totalAmount);
             
        
		
        return new Integer(result);		
	}

	private static void saveBillGroups(Integer billId, List billGroups) throws Exception
	{
		for (int i = 0; i < billGroups.size(); i++)
		{
			TurqBillGroup group = (TurqBillGroup) billGroups.get(i);
			registerGroup(group, billId);
		}
	}

	/** ************************************************************************* */
	//B?ll from consignment
	public static TurqBill saveBillFromCons(HashMap argMap) throws TurquazException,Exception
	{
		try
		{			
			String docNo=(String)argMap.get(BillKeys.BILL_DOC_NO);
			String definition=(String)argMap.get(BillKeys.BILL_DEFINITION);
			Boolean isPrinted=(Boolean)argMap.get(BillKeys.BILL_IS_PRINTED);
			Date billsDate=(Date)argMap.get(BillKeys.BILL_DATE);
			List consList=(List)argMap.get(BillKeys.BILL_CONS_LIST);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			TurqCurrentCard currentCard=(TurqCurrentCard)argMap.get(EngKeys.CURRENT_CARD);
			Date dueDate=(Date)argMap.get(BillKeys.BILL_DUE_DATE);
			BigDecimal discountAmount=(BigDecimal)argMap.get(BillKeys.BILL_DISCOUNT_AMOUNT);
			BigDecimal totalAmount=(BigDecimal)argMap.get(BillKeys.BILL_TOTAL_AMOUNT);
			TurqCurrencyExchangeRate exchangeRate=(TurqCurrencyExchangeRate)argMap.get(EngKeys.EXCHANGE_RATE);
			List billGroups=(List)argMap.get(BillKeys.BILL_GROUPS);
			Integer billCheck=(Integer)argMap.get(BillKeys.BILL_CHECK);
            TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
            
			// Save Bill
			TurqBill  bill  = new TurqBill();
			registerBill(bill,docNo, definition, isPrinted.booleanValue(), billsDate, type.intValue(), dueDate, currentCard, exchangeRate,billCheck,true);
			//Then Save Bill Groups
			for (int i = 0; i < consList.size(); i++)
			{
				Integer consId = (Integer) consList.get(i);
				TurqConsignment cons = ConBLSearchConsignment.getConsignmentByConsId(consId);
				TurqBillInEngineSequence billInEng = new TurqBillInEngineSequence();
				billInEng.setTurqBill(bill);
				billInEng.setTurqEngineSequence(cons.getTurqEngineSequence());
				EngDALCommon.saveObject(billInEng);
			}
			saveBillGroups(bill.getId(), billGroups);
			saveCurrentTransaction(bill, totalAmount, discountAmount);
			saveAccountingTransaction(bill,cashCard, totalAmount);
			return bill;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/** ************************************************************************** */
	/**
	 * @param docNo
	 * @param definition
	 * @param isPrinted
	 * @param billsDate
	 * @param type
	 * @param isOpen
	 * @param currentAccount
	 * @param dueDate
	 * @return
	 * @throws Exception
	 */
	private static TurqBill registerBill(TurqBill bill,String docNo, String definition, boolean isPrinted, Date billsDate, int type, Date dueDate,
			TurqCurrentCard curCard, TurqCurrencyExchangeRate exchangeRate,Integer billCheck,boolean isOpen) throws Exception
	{
		try
		{
			checkBillDocNo(docNo,billCheck,type,curCard.getId(),null);
			bill.setBillsDate(billsDate);
			bill.setBillsDefinition(definition);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsType(type);
			bill.setCreatedBy(System.getProperty("user"));
			bill.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
			bill.setLastModified(cal.getTime());
			bill.setCreationDate(cal.getTime());
			bill.setIsOpen(isOpen);
			bill.setDueDate(dueDate);
			bill.setBillDocumentNo(docNo);
			bill.setTurqCurrentCard(curCard);
			bill.setTurqCurrencyExchangeRate(exchangeRate);
			bill.setTurqEngineSequence(EngBLCommon.saveEngineSequence(EngBLCommon.MODULE_BILL));
			EngDALCommon.saveObject(bill);
			return bill;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
    private static void saveCashTransaction(TurqBill bill,TurqCashCard cashCard,BigDecimal totalAmount)throws Exception
    {
        if(bill.isIsOpen())
        {
            return;           
        }
        
        int type = EngBLCommon.CASH_BILL_COLLECT;
        
        if(bill.getBillsType()==EngBLCommon.BILL_TRANS_TYPE_BUY)
        {
            type = EngBLCommon.CASH_BILL_PAYMENT;
        }
        
        List totals = new ArrayList();
        totals.add(totalAmount);
        TurqAccountingAccount account = new TurqAccountingAccount();
        account.setId(new Integer(-1));
        
        CashBLCashTransactionAdd.saveCashTransaction(cashCard,bill.getTurqEngineSequence(),type,bill.getBillsDate(),"FT. NO:"+bill.getBillDocumentNo(),bill.getBillDocumentNo(),totals,account,bill.getTurqCurrencyExchangeRate());
        
        
        
        
        
        
        
    }
    
	public static void checkBillDocNo(String docNo,Integer billCheck,int type,Integer curCardId, Integer billId) throws Exception
	{
		int billCheckValue=billCheck.intValue();
		boolean checkBuyBill=false;
		boolean checkSellBill=false;
		if ( (billCheckValue & EngBLCommon.CHECK_BUY_BILL) != 0)
		{
			checkBuyBill=true;
		}
		if ( (billCheckValue & EngBLCommon.CHECK_SELL_BILL) != 0)
		{
			checkSellBill=true;
		}
		if (type==EngBLCommon.COMMON_BUY_INT)
		{
			if (checkBuyBill)
			{
				boolean existBillNo=BillDALAddBill.existBillNo(docNo,curCardId,type,billId);
				if (existBillNo)
				{
					throw new TurquazException(TurquazException.EX_BILL_DOC_NO);
				}
				System.out.println("buy"+existBillNo);
			}
		}
		else
		{
			if (checkSellBill)
			{
				boolean existBillNo=BillDALAddBill.existBillNo(docNo,type,billId);
				if (existBillNo)
				{
					throw new TurquazException(TurquazException.EX_BILL_DOC_NO);
				}	
				System.out.println("sell"+existBillNo);
			}
		}
	}

	/**
	 * @param bill
	 * @throws Exception
	 */
	public static void saveCurrentTransaction(TurqBill bill, BigDecimal totalAmount, BigDecimal discountAmount) throws Exception
	{
		try
		{
			TurqEngineSequence engSeq = bill.getTurqEngineSequence();
			String curTransDef = DatePicker.formatter.format(bill.getBillsDate()) + " " + bill.getBillDocumentNo() + " Ref. Fatura";
			//Al?? Faturas?
			if (bill.getBillsType() == 0)
			{
				CurBLCurrentTransactionAdd.saveCurrentTransaction(bill.getTurqCurrentCard(), bill.getBillsDate(), bill
						.getBillDocumentNo(), true, totalAmount, discountAmount, 1, engSeq.getId(), curTransDef, bill
						.getTurqCurrencyExchangeRate());
				//Kapal? Fatura
				if (!bill.isIsOpen())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(bill.getTurqCurrentCard(), bill.getBillsDate(), bill
							.getBillDocumentNo(), false, totalAmount, discountAmount, 4, engSeq.getId(), curTransDef, bill
							.getTurqCurrencyExchangeRate());
				}
			}
			//Sat?? Faturas?
			else if (bill.getBillsType() == 1)
			{
				CurBLCurrentTransactionAdd.saveCurrentTransaction(bill.getTurqCurrentCard(), bill.getBillsDate(), bill
						.getBillDocumentNo(), false, totalAmount, discountAmount, 1, engSeq.getId(), curTransDef, bill
						.getTurqCurrencyExchangeRate());
				//Kapal? Fatura
				if (!bill.isIsOpen())
				{
					CurBLCurrentTransactionAdd.saveCurrentTransaction(bill.getTurqCurrentCard(), bill.getBillsDate(), bill
							.getBillDocumentNo(), true, totalAmount, discountAmount, 4, engSeq.getId(), curTransDef, bill
							.getTurqCurrencyExchangeRate());
				}
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @param bill
	 * @param currentAccount
	 * @throws Exception
	 */
	private static int prepareAccountsForAccountingIntgretion(TurqBill bill, Map creditAccounts, Map deptAccounts) throws Exception
	{
		try
		{
			creditAccounts.clear();
			deptAccounts.clear();
			Map invRows = null;
			Map currentRows = null;
			int INV_ACCOUNT = -1;
			int INV_VAT_ACCOUNT = -1;
			int INV_SPEC_VAT_ACCOUNT = -1;
			int INV_DISCOUNT_ACCOUNT = -1;
			String discountAccount = "";
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
			else if (bill.getBillsType() == EngBLCommon.BILL_TRANS_TYPE_SELL)
			{
				invRows = creditAccounts;
				currentRows = deptAccounts;
				INV_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_SELL;
				INV_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_VAT_SELL;
				INV_SPEC_VAT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_SPEC_VAT_SELL;
				INV_DISCOUNT_ACCOUNT = EngBLCommon.INVENTORY_ACCOUNT_TYPE_DISCOUNT_SELL;
				discountAccount = "611";
			}
			TurqInventoryTransaction invTrans = null;
			EngDALCommon.initializeObject(bill, "getTurqBillInEngineSequences");
			Iterator it = bill.getTurqBillInEngineSequences().iterator();
			BigDecimal totals = new BigDecimal(0);
			while (it.hasNext())
			{
				TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
				EngDALCommon.initializeObject(billInEng.getTurqEngineSequence(), "getTurqInventoryTransactions");
				Iterator it2 = billInEng.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
				while (it2.hasNext())
				{
					invTrans = (TurqInventoryTransaction) it2.next();
					TurqAccountingAccount buyAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
							INV_ACCOUNT);
					if (buyAccount == null)
					{
						return -1; //error
					}
					if (!invRows.containsKey(buyAccount.getId()))
					{
						invRows.put(buyAccount.getId(), new ArrayList());
					}
					List ls = (List) invRows.get(buyAccount.getId());
					ls.add(invTrans.getTotalPriceInForeignCurrency());
					totals = totals.add(invTrans.getTotalPriceInForeignCurrency());
					invRows.put(buyAccount.getId(), ls);
					/*
					 * VAT ROWs
					 */
					TurqAccountingAccount buyVATAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
							INV_VAT_ACCOUNT);
					if (buyVATAccount == null)
					{
						return -1;
					}
					if (!invRows.containsKey(buyVATAccount.getId()))
					{
						invRows.put(buyVATAccount.getId(), new ArrayList());
					}
					List vatList = (List) invRows.get(buyVATAccount.getId());
					vatList.add(invTrans.getVatAmountInForeignCurrency());
					totals = totals.add(invTrans.getVatAmountInForeignCurrency());
					invRows.put(buyVATAccount.getId(), vatList);
					/*
					 * Special VAT Rows
					 */
					TurqAccountingAccount specialVATBuyAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard()
							.getId(), INV_SPEC_VAT_ACCOUNT);
					if (specialVATBuyAccount == null)
					{
						return -1;
					}
					if (!invRows.containsKey(specialVATBuyAccount.getId()))
					{
						invRows.put(specialVATBuyAccount.getId(), new ArrayList());
					}
					List specVatList = (List) invRows.get(specialVATBuyAccount.getId());
					specVatList.add(invTrans.getVatSpecialAmountInForeignCurrency());
					totals = totals.add(invTrans.getVatSpecialAmountInForeignCurrency());
					invRows.put(specialVATBuyAccount.getId(), specVatList);
					/*
					 * DiscountRows
					 */
					TurqAccountingAccount discountBuyAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard()
							.getId(), INV_DISCOUNT_ACCOUNT);
					if (discountBuyAccount == null)
					{
						discountBuyAccount = AccDALAccountAdd.getAccount(discountAccount);
					}
					if (!currentRows.containsKey(discountBuyAccount.getId()))
					{
						currentRows.put(discountBuyAccount.getId(), new ArrayList());
					}
					List discountList = (List) currentRows.get(discountBuyAccount.getId());
					discountList.add(invTrans.getDiscountAmount());
					totals = totals.subtract(invTrans.getDiscountAmount());
					currentRows.put(discountBuyAccount.getId(), discountList);
				}
			}
			/*
			 * Cari Kayitlari
			 */
			TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(bill.getTurqCurrentCard(),
					EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
			if (curAccount == null)
			{
				return -1;
			}
			List curList = (List) currentRows.get(curAccount.getId());
			if (curList == null)
			{
				curList = new ArrayList();
			}
			curList.add(totals);
			currentRows.put(curAccount.getId(), curList);
			return 1;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static BigDecimal[] getTotalAndDiscountAmount(TurqBill bill)throws Exception
	{
		BigDecimal returnValues[] = new BigDecimal[2];
		returnValues[0] = new BigDecimal(0);
		returnValues[1] = new BigDecimal(0);
		
		TurqInventoryTransaction invTrans = null;
		EngDALCommon.initializeObject(bill, "getTurqBillInEngineSequences");
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		BigDecimal totals = new BigDecimal(0);
		while (it.hasNext())
		{
			TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
			EngDALCommon.initializeObject(billInEng.getTurqEngineSequence(), "getTurqInventoryTransactions");
			Iterator it2 = billInEng.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it2.hasNext())
			{
				invTrans = (TurqInventoryTransaction) it2.next();
				
				totals = totals.add(invTrans.getTotalPriceInForeignCurrency());
			
				/*
				 * VAT ROWs
				 */
			
				totals = totals.add(invTrans.getVatAmountInForeignCurrency());
			
				/*
				 * Special VAT Rows
				 */
				
				totals = totals.add(invTrans.getVatSpecialAmountInForeignCurrency());
				
				/*
				 * DiscountRows
				 */
				returnValues[1]= invTrans.getDiscountAmount();
				totals = totals.subtract(invTrans.getDiscountAmount());
			}
		}
		returnValues[0]= totals;
		return returnValues;
		
	}

	public static int saveAccountingTransaction(TurqBill bill, TurqCashCard cashCard, BigDecimal totalAmount) throws Exception
	{
		Map creditAccounts = new HashMap();
		Map deptAccounts = new HashMap();
		String billDefinition = "FT " + bill.getBillDocumentNo() + " " + bill.getTurqCurrentCard().getCardsName();
		int saved = prepareAccountsForAccountingIntgretion(bill, creditAccounts, deptAccounts);
     
        if(!bill.isIsOpen())
        {
            
            TurqAccountingAccount cashAccount = null;
            if(cashCard != null)
            {
                cashAccount = cashCard.getTurqAccountingAccount();
            }
            TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(bill.getTurqCurrentCard(),
                    EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
            
            if(cashAccount == null||curAccount == null)
            {
                
            }
            else
            {
            if(bill.getBillsType()==EngBLCommon.BILL_TRANS_TYPE_BUY)
            {
                List creditList = (List)creditAccounts.get(cashAccount.getId());
                if(creditList == null)
                {
                    creditList = new ArrayList();
                }
                creditList.add(totalAmount);
                creditAccounts.put(cashAccount.getId(),creditList);
                
                List deptList = (List)deptAccounts.get(curAccount.getId());
                if(deptList == null)
                {
                    deptList = new ArrayList();
                }
                deptList.add(totalAmount);
                deptAccounts.put(curAccount.getId(),deptList);                
            }
            else 
            {
                List creditList = (List)creditAccounts.get(curAccount.getId());
                if(creditList == null)
                {
                    creditList = new ArrayList();
                }
                creditList.add(totalAmount);
                creditAccounts.put(curAccount.getId(),creditList);
                
                List deptList = (List)deptAccounts.get(cashAccount.getId());
                if(deptList == null)
                {
                    deptList = new ArrayList();
                }
                deptList.add(totalAmount);
                deptAccounts.put(cashAccount.getId(),deptList);                
            }
            
            }
        
        }
        
        
        if (saved == 1)
		{
			boolean isSaved = AccBLTransactionAdd.saveAccTransaction(bill.getBillsDate(), bill.getBillDocumentNo(), 2,
					EngBLCommon.MODULE_BILL, bill.getTurqEngineSequence().getId(), billDefinition, bill.getTurqCurrencyExchangeRate(),
					creditAccounts, deptAccounts, true);
		}
		return saved;
	}

	/**
	 * @param grp
	 * @param billId
	 * @throws Exception
	 */
	public static void registerGroup(TurqBillGroup grp, Integer billId) throws Exception
	{
		try
		{
			TurqBillInGroup cardGroup = new TurqBillInGroup();
			TurqBill card = new TurqBill();
			card.setId(billId);
			cardGroup.setTurqBill(card);
			cardGroup.setTurqBillGroup(grp);
			cardGroup.setCreatedBy(System.getProperty("user"));
			cardGroup.setUpdatedBy(System.getProperty("user"));
			Calendar cal = Calendar.getInstance();
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