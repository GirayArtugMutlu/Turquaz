package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSaveTransaction;

public class BillBLUpdateBill
{
	public static HashBag getBillInfo(HashMap argMap)throws Exception
	{
		Integer billId =(Integer)argMap.get(BillKeys.BILL_ID);
		TurqBill bill =(TurqBill)EngDALSessionFactory.getSession().load(TurqBill.class,billId);
		
		HashBag billInfo = new HashBag();
		billInfo.put(BillKeys.BILL_TYPE,new Integer(bill.getBillsType()));
		billInfo.put(CurKeys.CUR_CURRENT_NAME,bill.getTurqCurrentCard().getCardsName());
		billInfo.put(CurKeys.CUR_CURRENT_CODE,bill.getTurqCurrentCard().getCardsCurrentCode());
		billInfo.put(BillKeys.BILL_DOC_NO,bill.getBillDocumentNo());
		billInfo.put(BillKeys.BILL_DATE,bill.getBillsDate());
		billInfo.put(BillKeys.BILL_DUE_DATE,bill.getDueDate());
		billInfo.put(BillKeys.BILL_DEFINITION,bill.getBillsDefinition());
		billInfo.put(BillKeys.BILL_IS_OPEN,new Boolean(bill.isIsOpen()));
		
		 if(!bill.isIsOpen())
         {
             Iterator it = bill.getTurqEngineSequence().getTurqCashTransactions().iterator();
             if(it.hasNext())
             {
                 TurqCashTransaction cashTrans = (TurqCashTransaction)it.next();
                 Iterator it2 = cashTrans.getTurqCashTransactionRows().iterator();
                 while(it2.hasNext())
                 {
                     TurqCashTransactionRow transRow = (TurqCashTransactionRow)it2.next();
                     billInfo.put(CashKeys.CASH_CARD_NAME,transRow.getTurqCashCard().getCashCardName());                     
                 }
                 
             }
             
         }
		 
		 Date consDate = new Date();
		 String consDocumentNo="";
		 billInfo.put(InvKeys.INV_TRANSACTIONS,new HashMap());
		 
		 //Now inv transactions
		 Iterator it = bill.getTurqBillInEngineSequences().iterator();
		
			while (it.hasNext())
			{
				TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
				Iterator it2 = billInEng.getTurqEngineSequence().getTurqConsignments().iterator();
				if (it2.hasNext())
				{
					TurqConsignment cons = (TurqConsignment) it2.next();
					consDate = cons.getConsignmentsDate();
									
					if (!cons.getConsignmentDocumentNo().equals("")) //$NON-NLS-1$
						consDocumentNo +="[" + cons.getConsignmentDocumentNo() + "]"; //$NON-NLS-1$ //$NON-NLS-2$
				}
				
				Iterator it3 = billInEng.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
				int i=0;
				TurqInventoryTransaction invTrans;
				while (it3.hasNext())
				{
					invTrans = (TurqInventoryTransaction) it3.next();
					
					HashMap invCard = new HashMap();
					invCard.put(InvKeys.INV_CARD_ID,invTrans.getTurqInventoryCard().getId());
					invCard.put(InvKeys.INV_CARD_NAME,invTrans.getTurqInventoryCard().getCardName());
					invCard.put(InvKeys.INV_CARD_CODE,invTrans.getTurqInventoryCard().getCardInventoryCode());
					
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_TRANS_ID,invTrans.getId());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_CARD,invCard);				
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_AMOUNT_IN,invTrans.getAmountIn());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_AMOUNT_OUT,invTrans.getAmountOut());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_UNIT_PRICE_IN_FOREIGN_CURRENCY,invTrans.getUnitPriceInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_TOTAL_PRICE_IN_FOREIGN_CURRENCY,invTrans.getTotalPriceInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_VAT_RATE,invTrans.getVatRate());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_VAT_AMOUNT_IN_FOREIGN_CURRENCY,invTrans.getVatAmountInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_VAT_SPECIAL_RATE,invTrans.getVatSpecialRate());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_VAT_SPECIAL_AMOUNT_IN_FOREIGN_CURRENCY,invTrans.getVatSpecialAmountInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_VAT_SPECIAL_UNIT_PRICE_IN_FOREIGN_CURRENCY,invTrans.getVatSpecialUnitPriceInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_CUMILATIVE_PRICE_IN_FOREIGN_CURRENCY,invTrans.getCumilativePriceInForeignCurrency());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_DISCOUNT_RATE,invTrans.getDiscountRate());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_TRANS_TYPE_ID,invTrans.getTurqInventoryTransactionType().getId());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_DISCOUNT_AMOUNT_IN_FOREIGN_CURRENCY,invTrans.getDiscountAmountInForeignCurrency());
					
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_UNIT_NAME,invTrans.getTurqInventoryUnit().getUnitsName());	
				    
					HashMap unitMap = new HashMap();
					unitMap.put(InvKeys.INV_UNIT_NAME,invTrans.getTurqInventoryUnit().getUnitsName());
					unitMap.put(InvKeys.INV_UNIT_ID,invTrans.getTurqInventoryUnit().getId());
					billInfo.put(InvKeys.INV_TRANSACTIONS,i,InvKeys.INV_UNIT,unitMap);
					
					i++;
					
				}
			}
			
			billInfo.put(ConsKeys.CONS_DOC_NO,consDocumentNo);
			billInfo.put(ConsKeys.CONS_DATE,consDate);
			
			billInfo.put(BillKeys.BILL_GROUPS,new HashMap());
			TurqBillInGroup billInGroup;
			Iterator gIt= bill.getTurqBillInGroups().iterator();
			int i=0;
			while(gIt.hasNext())
			{
				billInGroup = (TurqBillInGroup)gIt.next();
				billInfo.put(BillKeys.BILL_GROUP,i,AdmKeys.ADM_GROUP_ID,billInGroup.getTurqBillGroup().getId());
								
				i++;
			}
			
			billInfo.put(BillKeys.BILL_CAN_UPDATE,BillDALUpdateBill.canUpdateBill(billId));
			
		
		return billInfo;
		
		
		
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
		Integer billId=(Integer)argMap.get(BillKeys.BILL_ID);
		
		TurqBill bill =(TurqBill)EngDALSessionFactory.getSession().load(TurqBill.class,billId);
		
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
	public static HashBag updateBill(HashMap argMap)
			throws Exception
	{
		try
		{
			Integer billId =(Integer)argMap.get(BillKeys.BILL_ID);
			
			TurqBill bill=(TurqBill)EngDALSessionFactory.getSession().load(TurqBill.class,billId);
		    
			
			String billNo=(String)argMap.get(BillKeys.BILL_DOC_NO);
			String definition=(String)argMap.get(BillKeys.BILL_DEFINITION);
			Boolean isPrinted=(Boolean)argMap.get(BillKeys.BILL_IS_PRINTED);
			Date billDate=(Date)argMap.get(BillKeys.BILL_DATE);
			Integer type=(Integer)argMap.get(EngKeys.TYPE);
			
			Integer curCardId = (Integer)argMap.get(CurKeys.CUR_CARD_ID);
			TurqCurrentCard curCard=null;
			if(curCardId!=null)
			{
				curCard=(TurqCurrentCard)EngDALSessionFactory.getSession().load(TurqCurrentCard.class,curCardId);
			};
			
			
			Date dueDate=(Date)argMap.get(BillKeys.BILL_DUE_DATE);
			BigDecimal discountAmount=(BigDecimal)argMap.get(BillKeys.BILL_DISCOUNT_AMOUNT);			
			BigDecimal totalAmount=(BigDecimal)argMap.get(BillKeys.BILL_TOTAL_AMOUNT);
			
			Integer currencyId=(Integer)argMap.get(EngKeys.CURRENCY_ID);
			TurqCurrencyExchangeRate exchangeRate =EngDALCommon.getCurrencyExchangeRate(currencyId,billDate);			
			
			List billGroups=(List)argMap.get(BillKeys.BILL_GROUPS);
			List invTransactions=(List)argMap.get(InvKeys.INV_TRANSACTIONS);			
			Integer billCheck=(Integer)argMap.get(BillKeys.BILL_CHECK);
			TurqCashCard cashCard = (TurqCashCard)argMap.get(CashKeys.CASH_CARD);
            Boolean isOpen = (Boolean)argMap.get(BillKeys.BILL_IS_OPEN);
            
			
			HashBag resultBag = new HashBag();
			
			updateBillInfo(bill, curCard, billDate, definition, billNo, isPrinted.booleanValue(), dueDate, type.intValue(),isOpen.booleanValue(), exchangeRate,billCheck);
			
			int invTransResult = updateInventoryTransactions(bill, invTransactions);
			resultBag.put(BillKeys.BILL_INV_TRANS_UPDATE_RESULT,new Integer(invTransResult));
			
			updateBillGroups(bill, billGroups);
			//Update Transactions
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
            deleteCashTransaction(bill);
			BillBLAddBill.saveCurrentTransaction(bill, totalAmount, discountAmount);
			EngDALCommon.updateObject(bill);
			
			int accUpdateResult = BillBLAddBill.saveAccountingTransaction(bill,cashCard,totalAmount);
            resultBag.put(BillKeys.BILL_ACC_UPDATE_RESULT,new Integer(accUpdateResult));
			
			BillBLAddBill.saveCashTransaction(bill,cashCard,totalAmount);
			return resultBag;
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
			BillBLAddBill.registerGroup((Integer) billGroups.get(i), bill.getId());
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