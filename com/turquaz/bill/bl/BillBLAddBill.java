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
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

public class BillBLAddBill
{
	//Bill from Bill
	public static TurqBill saveBillFromBill(String consignemtDocNo, String definition, boolean isPrinted, Date billsDate, int type,
			boolean isOpen, TurqCurrentCard currentCard, TurqAccountingAccount cashAccount, Date dueDate, BigDecimal discountAmount,
			String billDocNo, BigDecimal totalVat, BigDecimal specialVat, BigDecimal totalAmount, TurqCurrencyExchangeRate exchangeRate,
			List billGroups, List invTransactions) throws Exception
	{
		TurqBill bill = registerBill(billDocNo, definition, isPrinted, billsDate, type, isOpen, dueDate, currentCard, exchangeRate);
		TurqEngineSequence engSeq = EngBLCommon.saveEngineSequence(EngBLCommon.MODULE_BILL);
		TurqBillInEngineSequence billInEng = new TurqBillInEngineSequence();
		billInEng.setTurqEngineSequence(engSeq);
		billInEng.setTurqBill(bill);
		EngDALCommon.saveObject(billInEng);
		InvBLSaveTransaction.saveInventoryTransactions(invTransactions, engSeq.getId(), type, billsDate, definition, billDocNo,
				exchangeRate, currentCard);
		saveCurrentTransaction(bill, engSeq, totalAmount, discountAmount);
		saveAccountingTransaction(bill, engSeq, cashAccount, totalAmount);
		saveBillGroups(bill.getId(), billGroups);
		return bill;
	}

	public static void saveBillGroups(Integer billId, List billGroups) throws Exception
	{
		for (int i = 0; i < billGroups.size(); i++)
		{
			TurqBillGroup group = (TurqBillGroup) billGroups.get(i);
			registerGroup(group, billId);
		}
	}

	/** ************************************************************************* */
	//B?ll from consignment
	public static TurqBill saveBillFromCons(String docNo, String definition, boolean isPrinted, Date billsDate, TurqConsignment cons,
			int type, boolean isOpen, TurqAccountingAccount cashAccount, Date dueDate, List billGroups) throws Exception
	{
		try
		{
			// Save Bill
			TurqBill bill = registerBill(docNo, definition, isPrinted, billsDate, type, isOpen, dueDate, cons.getTurqCurrentCard(), cons
					.getTurqCurrencyExchangeRate());
			//Then Save Bill Groups
			saveBillGroups(bill.getId(), billGroups);
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
	private static TurqBill registerBill(String docNo, String definition, boolean isPrinted, Date billsDate, int type, boolean isOpen,
			Date dueDate, TurqCurrentCard curCard, TurqCurrencyExchangeRate exchangeRate) throws Exception
	{
		try
		{
			TurqBill bill = new TurqBill();
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
			EngDALCommon.saveObject(bill);
			return bill;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	/**
	 * @param bill
	 * @throws Exception
	 */
	public static void saveCurrentTransaction(TurqBill bill, TurqEngineSequence engSeq, BigDecimal totalAmount, BigDecimal discountAmount)
			throws Exception
	{
		try
		{
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
	public static void prepareAccountsForAccountingIntgretion(TurqBill bill, TurqAccountingAccount cashAccount, Map creditAccounts,
			Map deptAccounts, BigDecimal totalAmount) throws Exception
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
				if (!invRows.containsKey(buyAccount.getId()))
				{
					invRows.put(buyAccount.getId(), new ArrayList());
				}
				List ls = (List) invRows.get(buyAccount.getId());
				ls.add(invTrans.getTotalPriceInForeignCurrency());
				invRows.put(buyAccount.getId(), ls);
				/*
				 * VAT ROWs
				 */
				TurqAccountingAccount buyVATAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
						INV_VAT_ACCOUNT);
				if (!invRows.containsKey(buyVATAccount.getId()))
				{
					invRows.put(buyVATAccount.getId(), new ArrayList());
				}
				List vatList = (List) invRows.get(buyVATAccount.getId());
				vatList.add(invTrans.getVatAmountInForeignCurrency());
				invRows.put(buyVATAccount.getId(), vatList);
				/*
				 * Special VAT Rows
				 */
				TurqAccountingAccount specialVATBuyAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard()
						.getId(), INV_SPEC_VAT_ACCOUNT);
				if (!invRows.containsKey(specialVATBuyAccount.getId()))
				{
					invRows.put(specialVATBuyAccount.getId(), new ArrayList());
				}
				List specVatList = (List) invRows.get(specialVATBuyAccount.getId());
				specVatList.add(invTrans.getVatSpecialAmountInForeignCurrency());
				invRows.put(specialVATBuyAccount.getId(), specVatList);
				/*
				 * DiscountRows
				 */
				TurqAccountingAccount discountBuyAccount = InvBLCardSearch.getInventoryAccount(invTrans.getTurqInventoryCard().getId(),
						INV_DISCOUNT_ACCOUNT);
				if (discountBuyAccount == null)
				{
					discountBuyAccount = AccDALAccountAdd.getAccount(discountAccount);
				}
				if (!currentRows.containsKey(discountBuyAccount.getId()))
				{
					currentRows.put(discountBuyAccount.getId(), new ArrayList());
				}
				List discountList = (List) currentRows.get(discountBuyAccount.getId());
				discountList.add(invTrans.getDiscountRate());
				currentRows.put(discountBuyAccount.getId(), discountList);
			}
		}
		/*
		 * Cari Kayitlari
		 */
		TurqAccountingAccount curAccount = CurBLCurrentCardSearch.getCurrentAccountingAccount(bill.getTurqCurrentCard(),
				EngBLCommon.CURRENT_ACC_TYPE_GENERAL);
		List curList = (List) currentRows.get(curAccount.getId());
		if (curList == null)
		{
			curList = new ArrayList();
		}
		curList.add(totalAmount);
		currentRows.put(curAccount.getId(), curList);
		//Kapali Fatura
		if (!bill.isIsOpen() && cashAccount != null)
		{
			List list = (List) invRows.get(curAccount.getId());
			if (list == null)
			{
				list = new ArrayList();
			}
			list.add(totalAmount);
			invRows.put(curAccount.getId(), list);
			/** ****************************************************** */
			list = (List) currentRows.get(cashAccount.getId());
			if (list == null)
			{
				list = new ArrayList();
			}
			list.add(totalAmount);
			currentRows.put(cashAccount.getId(), list);
		}
	}

	public static void saveAccountingTransaction(TurqBill bill, TurqEngineSequence engSeq, TurqAccountingAccount cashAccount,
			BigDecimal totalAmount) throws Exception
	{
		Map creditAccounts = new HashMap();
		Map deptAccounts = new HashMap();
		String billDefinition = "FT " + bill.getBillDocumentNo() + " " + bill.getTurqCurrentCard().getCardsName();
		prepareAccountsForAccountingIntgretion(bill, cashAccount, creditAccounts, deptAccounts, totalAmount);
		boolean isSaved = AccBLTransactionAdd.saveAccTransaction(bill.getBillsDate(), bill.getBillDocumentNo(), 2,
				EngBLCommon.MODULE_BILL, engSeq.getId(), billDefinition, bill.getTurqCurrencyExchangeRate(), creditAccounts,
				deptAccounts, true);
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

	public static Set getInventoryTransactions(TurqBill bill) throws Exception
	{
		try
		{
			return BillDALAddBill.getInvTransactions(bill);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}