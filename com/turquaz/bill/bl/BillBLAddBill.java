
package com.turquaz.bill.bl;


import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;


import com.turquaz.accounting.bl.AccBLTransactionAdd;
import com.turquaz.accounting.dal.AccDALAccountAdd;
import com.turquaz.bill.dal.BillDALAddBill;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqModule;

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
				
			bill.setTurqBillConsignmentCommon(common);
			
			
			TurqEngineSequence seqDocId = new TurqEngineSequence();
			TurqModule module = new TurqModule();
			module.setModulesId(new Integer(7));
			seqDocId.setTurqModule(module);
			
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
			
			
			/**
			 * 1- Stok muhasebe kayitlarini gir.
			 * 2- Kdv muhasebe kayitlari
			 * 3- Ötv muhasebe kayitlari
			 * 4- Cari Hesap kay?d?
			 */

			AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
			
			
			Integer transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),2,7,bill.getTurqEngineSequence().getEngineSequencesId());
		    
			TurqAccountingTransaction accTrans = new TurqAccountingTransaction();
		    accTrans.setAccountingTransactionsId(transID);			
			
			TurqAccountingTransactionColumn transRow =null;
			TurqInventoryTransaction invTrans = null;
	        
			/**
			 *1- stoklarin muhasebe kay?tlarini yap
			 */
			Iterator it = getInventoryTransactions(bill).iterator();
	        
			while(it.hasNext()){
				
			invTrans = (TurqInventoryTransaction)it.next();
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdBuy());
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmount(invTrans.getTransactionsTotalPrice());
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			
	        }
			
			/**
			 * 2-Kdv hesabini gir
			 */
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(AccDALAccountAdd.getAccount("191"));
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmount(invTrans.getTransactionsVatAmount());
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			
			
			
			/**
			 *3- Ötv hesabini gir
			 */
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(AccDALAccountAdd.getAccount("193"));
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmount(invTrans.getTransactionsVatSpecialAmount());
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			/**
			 * Cari Kayd?n? Yap
			 *  
			 *
			 */
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getTurqAccountingAccount());
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(invTrans.getTransactionsCumilativePrice());
			transRow.setDeptAmount(new BigDecimal(0));
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			
			
			
			//Kapal? Fatura
			/**
			 * 1 -Cari Muhasebe hareketi isle
			 * 2- Kasa Muhasebe hareketi isle
			 */
			if(!bill.isIsOpen()){
				transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),1,7,bill.getTurqEngineSequence().getEngineSequencesId());
			    
				 accTrans = new TurqAccountingTransaction();
			    accTrans.setAccountingTransactionsId(transID);	
			    
			    
			    /**
			     * 1-Cari Muhasebe Satiri
			     */
			    
			    transRow = new TurqAccountingTransactionColumn();
				
				transRow.setTurqAccountingAccount(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getTurqAccountingAccount());
				transRow.setTurqAccountingTransaction(accTrans);
				transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(invTrans.getTransactionsCumilativePrice());
				
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
				
				dalBill.save(transRow);
				
				/**
				 * 2- Kasa Muhasebe Hareketi
				 */
				  transRow = new TurqAccountingTransactionColumn();
					
					transRow.setTurqAccountingAccount(AccDALAccountAdd.getAccount("100"));
					transRow.setTurqAccountingTransaction(accTrans);
					
					transRow.setCreditAmount(invTrans.getTransactionsCumilativePrice());
					transRow.setDeptAmount(new BigDecimal(0));
					
					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
					
					dalBill.save(transRow);
				
				
		 	  
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
	public Set getInventoryTransactions(TurqBill bill)throws Exception{
		try{
			
			return dalBill.getInvTransactions(bill);
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}


}
