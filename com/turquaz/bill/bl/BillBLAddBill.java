
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
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqBillGroup;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.dal.TurqModule;

import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.ui.component.DatePicker;

public class BillBLAddBill {
	BillDALAddBill dalBill = new BillDALAddBill();
	Calendar cal = Calendar.getInstance();
	public BillBLAddBill(){
		
	}
	public Integer saveBill(String docNo, String definition, boolean isPrinted,
			                Date billsDate,  TurqConsignment cons,
								   int type, boolean isOpen, Object currentAccount)throws Exception {
		try{			
			TurqBill bill = new TurqBill();
			bill.setBillsDate(billsDate);
			bill.setBillsDefinition(definition);
			bill.setBillsPrinted(isPrinted);
			bill.setBillsType(type);			

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
			saveAccountingTransaction(bill,currentAccount);
			
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
	public void saveAccountingTransaction(TurqBill bill, Object currentAccount)throws Exception{
		try	{
	    
		TurqBillConsignmentCommon common= bill.getTurqBillConsignmentCommon();		
		
		//Al?? Faturas? 
		if(bill.getBillsType()==0){
		    
		/**
		  * 1- Stok muhasebe kayitlarini gir.
		  * 2- Kdv muhasebe kayitlari
		  * 3- Cari Hesap kay?d?
		  * 4- ?skonto..
		 */

			AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
			
			
			Integer transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),2,7,bill.getTurqEngineSequence().getEngineSequencesId(),"fatura "+DatePicker.formatter.format(bill.getBillsDate()) +" " + common.getBillDocumentNo());
		    
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
			
			//mal bedeli
			transRow.setDeptAmount(invTrans.getTransactionsTotalPrice().add(invTrans.getTransactionsVatSpecialAmount()));
			
			
			
			// set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			
			dalBill.save(transRow);
			
			/**
			 * 2-Kdv hesabini gir
			 */
			if (!common.getVatAmount().equals(new BigDecimal(0))){
				transRow = new TurqAccountingTransactionColumn();
			
				transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdVat());
				transRow.setTurqAccountingTransaction(accTrans);
			
				transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(common.getVatAmount());
			
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fat."+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
				dalBill.save(transRow);
			}
			
			/**
			 * OTV Hesabini gir. 
			 */
			if (!common.getSpecialVatAmount().equals(new BigDecimal(0))){
				transRow = new TurqAccountingTransactionColumn();
			
		
				transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdSpecialVat());
				transRow.setTurqAccountingTransaction(accTrans);
			
				transRow.setCreditAmount(new BigDecimal(0));
				transRow.setDeptAmount(common.getSpecialVatAmount());
			
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fat."+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
				dalBill.save(transRow);
			}
						
			
	        }
			
		
			
			/**
			 * 3-Cari Kayd?n? Yap
			 *  
			 *
			 */
			
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getTurqAccountingAccount());
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(common.getTotalAmount());
			transRow.setDeptAmount(new BigDecimal(0));
		
//			 set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			dalBill.save(transRow);
			
			/**
			 * 4- iskontoyu save et
			 */
			
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(AccDALAccountAdd.getAccount("649"));
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(common.getDiscountAmount());
			transRow.setDeptAmount(new BigDecimal(0));
		
//			 set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
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
				transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),1,7,bill.getTurqEngineSequence().getEngineSequencesId(),"fatura "+DatePicker.formatter.format(bill.getBillsDate()) +" " + common.getBillDocumentNo());
			    
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
				
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
				
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
				
				dalBill.save(transRow);
				
				/**
				 * 2- Kasa Muhasebe Hareketi
				 */
				  transRow = new TurqAccountingTransactionColumn();
					
				  	
					transRow.setTurqAccountingAccount((TurqAccountingAccount)currentAccount);
					transRow.setTurqAccountingTransaction(accTrans);
					
					transRow.setCreditAmount(invTrans.getTransactionsCumilativePrice());
					transRow.setDeptAmount(new BigDecimal(0));
					
//					 set Transaction Row Definition
					transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
					
					
					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
					
					dalBill.save(transRow);
				
				
		 	  
			}
		}
		
		
		//Sat?? Faturas?	
		else if(bill.getBillsType()==1){
			
			
			
			/**
			 * 1- Stok muhasebe kayitlarini gir.
			 * 2- Kdv muhasebe kayitlari
			 * 3- Ötv muhasebe kayitlari
			 * 4- Cari Hesap kay?d?
			 * 5- iskonto kaydi
			 */

			AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
			
			
			Integer transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),2,7,bill.getTurqEngineSequence().getEngineSequencesId(),"fatura "+DatePicker.formatter.format(bill.getBillsDate()) +" " + common.getBillDocumentNo());
		    
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
			
			transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdSell());
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(invTrans.getTransactionsTotalPrice());
			transRow.setDeptAmount(new BigDecimal(0));
			
//			 set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			/**
			 * 2-Kdv hesabini gir
			 */
			if (!common.getVatAmount().equals(new BigDecimal(0))){
				transRow = new TurqAccountingTransactionColumn();
			
				//391 olarak degistir
				transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdVatSell());
				transRow.setTurqAccountingTransaction(accTrans);
				transRow.setCreditAmount(common.getVatAmount());
				transRow.setDeptAmount(new BigDecimal(0));
			
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
				dalBill.save(transRow);
			}

			
			
			/**
			 *3- Ötv hesabini gir
			 */
			if (!common.getSpecialVatAmount().equals(new BigDecimal(0))){
				transRow = new TurqAccountingTransactionColumn();
			
				//360 olarak degistir
				transRow.setTurqAccountingAccount(invTrans.getTurqInventoryCard().getTurqAccountingAccountByAccountingAccountsIdSpecialVatSell());
				transRow.setTurqAccountingTransaction(accTrans);
			
				transRow.setCreditAmount(common.getSpecialVatAmount());
				transRow.setDeptAmount(new BigDecimal(0));
			
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
				dalBill.save(transRow);
			}
	        }
			
			
			
			/**
			 * 4- Cari Kayd?n? Yap
			 *  
			 *
			 */
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getTurqAccountingAccount());
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmount(common.getTotalAmount());
			
//			 set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
			transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
			
			dalBill.save(transRow);
			
			/**
			 * 5- iskonto Kayd?
			 */
			transRow = new TurqAccountingTransactionColumn();
			
			transRow.setTurqAccountingAccount(AccDALAccountAdd.getAccount("611"));
			transRow.setTurqAccountingTransaction(accTrans);
			
			transRow.setCreditAmount(new BigDecimal(0));
			transRow.setDeptAmount(common.getDiscountAmount());
			
//			 set Transaction Row Definition
			transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
			
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
				transID=blAcc.saveAccTransaction(bill.getBillsDate(),common.getBillDocumentNo(),0,7,bill.getTurqEngineSequence().getEngineSequencesId(),"fatura "+DatePicker.formatter.format(bill.getBillsDate()) +" " + common.getBillDocumentNo());
			    
				 accTrans = new TurqAccountingTransaction();
			    accTrans.setAccountingTransactionsId(transID);	
			    
			    
			    /**
			     * 1-Cari Muhasebe Satiri
			     */
			    
			    transRow = new TurqAccountingTransactionColumn();
				
				transRow.setTurqAccountingAccount(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getTurqAccountingAccount());
				transRow.setTurqAccountingTransaction(accTrans);
				transRow.setCreditAmount(invTrans.getTransactionsCumilativePrice());
				transRow.setDeptAmount(new BigDecimal(0));
				
//				 set Transaction Row Definition
				transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
				
				transRow.setCreatedBy(System.getProperty("user"));
				transRow.setUpdatedBy(System.getProperty("user"));
				transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
				transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
				
				dalBill.save(transRow);
				
				/**
				 * 2- Kasa Muhasebe Hareketi
				 */
				  transRow = new TurqAccountingTransactionColumn();
					
					transRow.setTurqAccountingAccount((TurqAccountingAccount)currentAccount);
					transRow.setTurqAccountingTransaction(accTrans);
					
					transRow.setCreditAmount(new BigDecimal(0));
					transRow.setDeptAmount(invTrans.getTransactionsCumilativePrice());
					
//					 set Transaction Row Definition
					transRow.setTransactionDefinition("Fatura "+bill.getTurqBillConsignmentCommon().getBillDocumentNo()+" "+DatePicker.formatter.format(bill.getBillsDate()));
					
					transRow.setCreatedBy(System.getProperty("user"));
					transRow.setUpdatedBy(System.getProperty("user"));
					transRow.setLastModified(new java.sql.Date(cal.getTime().getTime()));
					transRow.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
					
					dalBill.save(transRow);
				
				
		 	  
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
