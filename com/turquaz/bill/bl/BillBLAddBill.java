
package com.turquaz.bill.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillBLAddBill {
	BillDALAddBill dalBill = new BillDALAddBill();
	Calendar cal = Calendar.getInstance();
	public BillBLAddBill(){
		
	}
	public Integer saveBill(String docNo, String definition, boolean isPrinted, Date consignmentDate,
								   TurqCurrentCard curCard, int discountRate,BigDecimal discountAmount,
								   TurqConsignment cons,BigDecimal vatAmount,BigDecimal specialVatAmount,
								   BigDecimal totalAmount,int type, boolean isOpen)throws Exception {
		try{			
			TurqBill bill = new TurqBill();
			bill.setBillsDiscountRate(discountRate);	
			bill.setBillsCharges(new BigDecimal(0));
			bill.setBillsDate(consignmentDate);
			bill.setBillsDefinition(definition);
			bill.setBillsDiscountAmount(discountAmount);
			bill.setBillDocumentNo(docNo);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsTotalAmount(totalAmount);
			bill.setBillsType(type);
			bill.setBillsVatAmount(vatAmount);
			bill.setBillsSpecialVatAmount(specialVatAmount);
			bill.setTurqConsignment(cons);
			bill.setTurqCurrentCard(curCard);					
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			bill.setTurqCompany(company);
			bill.setCreatedBy(System.getProperty("user"));
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bill.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			bill.setIsOpen(isOpen);
		
			
			dalBill.save(bill);
			
			saveCurrentTransaction(bill);
			saveAccountingTransaction(bill);
			
			return bill.getBillsId();
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
   
	
	public void saveCurrentTransaction(TurqBill bill)throws Exception{
	try	{
	
	CurBLCurrentTransactionAdd curBLTrans = new CurBLCurrentTransactionAdd();
	
	//Al?? Faturas? 
	if(bill.getBillsType()==0){
		curBLTrans.saveCurrentTransaction(bill.getTurqCurrentCard(),bill.getBillsDate(),bill.getBillDocumentNo(),true,bill.getBillsTotalAmount(),bill.getBillsDiscountAmount(),1);
		
		//Kapal? Fatura
		if(!bill.isIsOpen()){
	 	  curBLTrans.saveCurrentTransaction(bill.getTurqCurrentCard(),bill.getBillsDate(),bill.getBillDocumentNo(),false,bill.getBillsTotalAmount(),bill.getBillsDiscountAmount(),4);
		}	  
	 
	}
	
	//Sat?? Faturas?	
	else if(bill.getBillsType()==1){
		curBLTrans.saveCurrentTransaction(bill.getTurqCurrentCard(),bill.getBillsDate(),bill.getBillDocumentNo(),false,bill.getBillsTotalAmount(),bill.getBillsDiscountAmount(),1);
		
		//Kapal? Fatura
		if(!bill.isIsOpen()){
	 	  curBLTrans.saveCurrentTransaction(bill.getTurqCurrentCard(),bill.getBillsDate(),bill.getBillDocumentNo(),true,bill.getBillsTotalAmount(),bill.getBillsDiscountAmount(),4);
		}	
	}
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	
	
	}
	public void saveAccountingTransaction(TurqBill bill)throws Exception{
		try	{
		
		
		//Al?? Faturas? 
		if(bill.getBillsType()==0){
		  if(bill.isIsOpen()){
		  	
		  
		  }	  
		  else{
		  	
		  
		  }
		}
		
		
		//Sat?? Faturas?	
		else if(bill.getBillsType()==1){
			  if(bill.isIsOpen()){
			  	
			  
			  }
			  
			  else{
			  	
			  
			  }
			
		}
			
			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
		}
	public void registerGroup(TurqBillGroup grp, Integer conId)throws Exception{
	try{
		TurqBillInGroup cardGroup = new TurqBillInGroup();
		TurqBill card =new TurqBill();
		card.setBillsId(conId);
		cardGroup.setTurqBill(card);
		cardGroup.setTurqBillGroup(grp);

		cardGroup.setCreatedBy(System.getProperty("user"));
		cardGroup.setUpdatedBy(System.getProperty("user"));
		cardGroup.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		cardGroup.setCreationDate(new java.sql.Date(cal.getTime().getTime()));

		dalBill.save(cardGroup);
	
	}
	catch(Exception ex){
		throw ex;
	}
		
	}


}
