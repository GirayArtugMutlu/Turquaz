package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqCurrentCard;


public class BillBLUpdateBill {
	private Calendar cal = Calendar.getInstance();
	

	private BillDALUpdateBill dalBill = new BillDALUpdateBill();
	private BillBLAddBill blAddBill = new BillBLAddBill();

	public BillBLUpdateBill() {

	}

	public void deleteCurrentTransactions(TurqBill bill)throws Exception{
	    try{
	        
	    dalBill.deleteCurrentTransactions(bill.getTurqEngineSequence().getId().intValue());    
	    
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	public void deleteAccountingTransactions(TurqBill bill)throws Exception{
	    try{
	        
	       dalBill.deleteAccountingTransactions(bill.getTurqEngineSequence().getId().intValue()); 
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	/**
	 * 
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
	public void updateBill(TurqBill bill,String billNo,String consNo, String definition, boolean isPrinted,
			boolean isOpen, Date billDate, TurqCurrentCard curCard, 
			BigDecimal discountAmount,
			BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, TurqAccountingAccount cashAccount,Date dueDate,
			List invTransactions, List groups, TurqCurrencyExchangeRate exRate) throws Exception {
		try {	
			
	
			//update its consignment
			
			Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
				
		   
			if(it.hasNext()){
			    
				TurqConsignment cons = (TurqConsignment)it.next();
			    ConBLUpdateConsignment.updateConsignment(cons,consNo,definition,billDate,curCard,discountAmount,billNo,vatAmount,specialVatAmount,totalAmount,type,exRate,invTransactions,null);
			
			}
			
			updateGroups(groups,bill);	
			
			
			//update bill first 
			
			
			bill.setBillsDate(billDate);
			bill.setBillsDefinition(definition);
		
			bill.setBillsPrinted(isPrinted);
		    bill.setDueDate(dueDate);
			bill.setBillsType(type);
            bill.setIsOpen(isOpen);
			
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
					   

			dalBill.updateBill(bill);
			
			//Update Transactions
			
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
			
			blAddBill.saveCurrentTransaction(bill);
			blAddBill.saveAccountingTransaction(bill,cashAccount);
			
			
			
			

		} catch (Exception ex) {
			throw ex;
		}
	}

	public void updateGroups(List billGroups, TurqBill bill)throws Exception{
		
		 Iterator it = bill.getTurqBillInGroups().iterator();
		    
		while(it.hasNext()){
		
			dalBill.deleteObject(it.next());
		
		}
		    
		    for(int i=0;i<billGroups.size();i++)
		    {
		    	blAddBill.registerGroup((TurqBillGroup)billGroups.get(i),bill.getId()); 
		    }
	}
	
	public void deleteObject(Object obj) throws Exception {
		try {

			dalBill.deleteObject(obj);

		} catch (Exception ex) {
			throw ex;

		}
	}
	public boolean canUpdateBill(TurqBill bill)throws Exception{
	    try{
	        
	        return dalBill.canUpdateBill(bill);
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}

}