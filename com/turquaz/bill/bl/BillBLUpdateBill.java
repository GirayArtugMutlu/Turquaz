package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.bill.dal.BillDALUpdateBill;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqCurrentCard;


public class BillBLUpdateBill {
	private Calendar cal = Calendar.getInstance();

	private BillDALUpdateBill dalBill = new BillDALUpdateBill();
	private BillBLAddBill blAddBill = new BillBLAddBill();

	public BillBLUpdateBill() {

	}

	public void deleteCurrentTransactions(TurqBill bill)throws Exception{
	    try{
	        
	    dalBill.deleteCurrentTransactions(bill.getTurqEngineSequence().getEngineSequencesId().intValue());    
	    
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	public void deleteAccountingTransactions(TurqBill bill)throws Exception{
	    try{
	        
	       dalBill.deleteAccountingTransactions(bill.getTurqEngineSequence().getEngineSequencesId().intValue()); 
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	
	
	public void updateBill(TurqBill bill,String docNo, String definition, boolean isPrinted,
			boolean isOpen, Date billDate, TurqCurrentCard curCard, 
			BigDecimal discountAmount,
			BigDecimal vatAmount, BigDecimal specialVatAmount,
			BigDecimal totalAmount, int type, Object currentAccount,Date dueDate) throws Exception {
		try {		
			bill.setBillsDate(billDate);
			bill.setBillsDefinition(definition);
		
			bill.setBillsPrinted(isPrinted);
		    bill.setDueDate(dueDate);
			bill.setBillsType(type);
            bill.setIsOpen(isOpen);
			
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			
			TurqBillConsignmentCommon common =bill.getTurqBillConsignmentCommon();
			
			common.setDiscountAmount(new BigDecimal(0));
			common.setCharges(new BigDecimal(0));
			common.setDiscountAmount(discountAmount);
			common.setBillDocumentNo(docNo);
			common.setTotalAmount(totalAmount);
			common.setVatAmount(vatAmount);
			common.setSpecialVatAmount(specialVatAmount);
			common.setTurqCurrentCard(curCard);

	    	common.setUpdatedBy(System.getProperty("user"));
		    common.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			
		    
		   
			dalBill.updateObject(common);

			dalBill.updateBill(bill);
			
			//Update Transactions
			
			deleteAccountingTransactions(bill);
			deleteCurrentTransactions(bill);
			
			blAddBill.saveCurrentTransaction(bill);
			blAddBill.saveAccountingTransaction(bill,currentAccount);
			
			
			
			

		} catch (Exception ex) {
			throw ex;
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