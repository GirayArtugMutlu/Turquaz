
package com.turquaz.bill.bl;


import java.util.Calendar;
import java.util.Date;

import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;

import com.turquaz.engine.dal.TurqEngineSequence;


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
	public Integer saveBill(String docNo, String definition, boolean isPrinted,
			                Date billsDate,  TurqConsignment cons,
								   int type, boolean isOpen)throws Exception {
		try{			
			TurqBill bill = new TurqBill();
			bill.setBillsDate(billsDate);
			bill.setBillsDefinition(definition);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsType(type);				
			TurqCompany company = new TurqCompany();	
			company.setCompaniesId(Integer.valueOf(System.getProperty("company")));
			bill.setTurqCompany(company);
			bill.setCreatedBy(System.getProperty("user"));
			bill.setUpdatedBy(System.getProperty("user"));
			bill.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bill.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			bill.setIsOpen(isOpen);
			
			TurqBillConsignmentCommon common = cons.getTurqBillConsignmentCommon();
			common.setBillDocumentNo(docNo);
			dalBill.save(common);
			
			bill.setTurqBillConsignmentCommon(common);
			
			
			TurqEngineSequence seqDocId = new TurqEngineSequence();
			
			dalBill.save(seqDocId);
			
			bill.setTurqEngineSequence(seqDocId);
		
			
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
	
    TurqBillConsignmentCommon common= bill.getTurqBillConsignmentCommon();
	CurBLCurrentTransactionAdd curBLTrans = new CurBLCurrentTransactionAdd();
	
	
	//Al?? Faturas? 
	if(bill.getBillsType()==0){
		curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),bill.getBillsDate(),common.getBillDocumentNo(),true,common.getTotalAmount(),common.getDiscountAmount(),1,bill.getTurqEngineSequence().getEngineSequencesId());
		
		//Kapal? Fatura
		if(!bill.isIsOpen()){
	 	  curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),bill.getBillsDate(),common.getBillDocumentNo(),false,common.getTotalAmount(),common.getDiscountAmount(),4,bill.getTurqEngineSequence().getEngineSequencesId());
		}	  
	 
	}
	
	//Sat?? Faturas?	
	else if(bill.getBillsType()==1){
		curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),bill.getBillsDate(),common.getBillDocumentNo(),false,common.getTotalAmount(),common.getDiscountAmount(),1,bill.getTurqEngineSequence().getEngineSequencesId());
		
		//Kapal? Fatura
		if(!bill.isIsOpen()){
	 	  curBLTrans.saveCurrentTransaction(common.getTurqCurrentCard(),bill.getBillsDate(),common.getBillDocumentNo(),true,common.getTotalAmount(),common.getDiscountAmount(),4,bill.getTurqEngineSequence().getEngineSequencesId());
		}	
	}
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	
	
	}
	public void saveAccountingTransaction(TurqBill bill)throws Exception{
		try	{
	    
		TurqBillConsignmentCommon common= bill.getTurqBillConsignmentCommon();
		
		
		//Al?? Faturas? 
		if(bill.getBillsType()==0){

			AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
			
			Integer transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),2,7,bill.getTurqEngineSequence().getEngineSequencesId());
			
			TurqAccountingTransactionColumn transRow = new TurqAccountingTransactionColumn();
	
			
			
			//Kapal? Fatura
			if(!bill.isIsOpen()){
			
				
		 	  
			}
		}
		
		
		//Sat?? Faturas?	
		else if(bill.getBillsType()==1){
			  if(!bill.isIsOpen()){
			  	
			  
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
