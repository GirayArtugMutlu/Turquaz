/*
 * Created on Oct 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;

import java.util.Calendar;
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionAdd;

import com.turquaz.current.dal.CurDALCurrentTransactionAdd;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLCurrentTransactionAdd {

	private CurDALCurrentTransactionAdd dalCurrentTrans=new CurDALCurrentTransactionAdd();	
	private Calendar cal=Calendar.getInstance();
	public CurBLCurrentTransactionAdd(){
		
	}
	
	
	/**
	 * 
	 * @param curCard
	 * @param transDate
	 * @param documentNo
	 * @param isCredit  Kasa Hareketi Tipini belirler
	 * @param amount 
	 * @param totalDiscount
	 * @param type    Hareketin tipi (nakit, fatura v.s.)
	 * @param account  Kasa muhasebe hesabi 
	 * @throws Exception
	 */
	public void saveCurrentCashTransaction(TurqCurrentCard curCard,java.util.Date transDate, String documentNo,
									boolean isCredit,BigDecimal amount, BigDecimal totalDiscount,
									int type, TurqAccountingAccount account) throws Exception{
		try{
		//Accounting Integration 
        //Eger bir Nakit hareketi ise Muhasebe kaydini yap
		//Daha sonra cari hareketi ekle
		//Nakit hareketi degilse hic birsey yapma.
        if(type == 4){
          
        	
          TurqAccountingTransactionColumn transRowCash = new TurqAccountingTransactionColumn();
          TurqAccountingTransactionColumn transRowCurrent = new TurqAccountingTransactionColumn();
          
          //Kasa muhasebe kodunu girelim
          transRowCash.setTurqAccountingAccount(account);
		
          int accTransactionType = 1; //0-Tahsil, 1-Tediye, 2-Mahsup
    		
		  
		  //Cari Karta para verildiginde
		  //Kasaya alacak hareketi 
		  //Cari kartin satici muhasebe hesabina borc hareketi 
    		if(isCredit){
    			
    			accTransactionType = 1;	    			
    			transRowCash.setCreditAmount(amount);
    			transRowCash.setDeptAmount(new BigDecimal(0));
    			transRowCurrent.setCreditAmount(new BigDecimal(0));
    			transRowCurrent.setDeptAmount(amount);
    			
    			//cari sat?c? muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(curCard.getTurqAccountingAccountByAccountingCodeIdSupplier());
    	   			
    		}
    	   //Cari Karttan para tahsil edildiginde
  		   //Kasaya borc hareketi 
  		   //Cari kartin alici muhasebe hesabina alacak hareketi 
    		else 
    		{
    			accTransactionType = 0;
    			transRowCash.setCreditAmount(new BigDecimal(0));
    			transRowCash.setDeptAmount(amount);
    			transRowCurrent.setCreditAmount(amount);
    			transRowCurrent.setDeptAmount(new BigDecimal(0));
    			
    			
    			//cari alici muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(curCard.getTurqAccountingAccountByAccountingCodeIdCustomer());
    			
    		
    		}
        
        
          AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
        
         //4-Cari modulu id si.. 
         Integer transId = blAcc.saveAccTransaction(transDate,documentNo,accTransactionType,4);
         
         //fis kalemlerini de ekleyelim.. 
         saveAccountingCashTransactionRows(curCard,isCredit,amount,account,transId);           
      
         
         
        //Simdi Cari Hareketi Kaydedebiliriz. 
        
 		
 		TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
 		
 		curTrans.setTransactionsDate(transDate);
 		curTrans.setTransactionsDocumentNo(documentNo);
 		curTrans.setTurqCurrentCard(curCard);
 	    
		
 		TurqAccountingTransaction accTrans = new TurqAccountingTransaction();
 		accTrans.setAccountingTransactionsId(transId);
 		curTrans.setTurqAccountingTransaction(accTrans);
 		 		
		
 		if(isCredit){		
 			curTrans.setTransactionsTotalCredit(amount);
 			curTrans.setTransactionsTotalDept(new BigDecimal(0));	
 			
 		}
 		else 
 		{
 			curTrans.setTransactionsTotalCredit(new BigDecimal(0));
 			curTrans.setTransactionsTotalDept(amount);
 		
 		}
 		
 		
 		TurqCurrency currency = new TurqCurrency();
        currency.setCurrenciesId(new Integer(1));
         
        TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
        transType.setCurrentTransactionTypesId(new Integer(type));
 		
 		curTrans.setTransactionsTotalDiscount(totalDiscount);
 		curTrans.setTurqCurrency(currency);
 		curTrans.setTurqCurrentTransactionType(transType);		
 		
 		curTrans.setCreatedBy(System.getProperty("user"));
 		curTrans.setUpdatedBy(System.getProperty("user"));
 		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
 		curTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
         
 		
 		
 		
 		
 		dalCurrentTrans.saveObject(curTrans);
                 
        }
             
        
        
		}
		catch(Exception ex){
			throw ex;
		}
	}
	/**
	 * Nakit Muhasebe fisi kalemlerini kaydet
	 * 
	 * @param curCard
	 * @param transDate
	 * @param isCredit
	 * @param amount
	 * @param account "cari karttaki muhasebe hesabina karsilik gelecek muhasebe kodu" 
	 * @param AccTransId Accounting transaction id
	 */
	public void saveAccountingCashTransactionRows(TurqCurrentCard curCard, 
			boolean isCredit,BigDecimal amount,TurqAccountingAccount account,
			Integer AccTransId){
	  try{
			   
        	
          TurqAccountingTransactionColumn transRowCash = new TurqAccountingTransactionColumn();
          TurqAccountingTransactionColumn transRowCurrent = new TurqAccountingTransactionColumn();
          
          //Kasa muhasebe kodunu girelim
          transRowCash.setTurqAccountingAccount(account);
    	
          //Cari Karta para verildiginde
		  //Kasaya alacak hareketi 
		  //Cari kartin satici muhasebe hesabina borc hareketi 
    		if(isCredit){
    		   			
    			transRowCash.setCreditAmount(amount);
    			transRowCash.setDeptAmount(new BigDecimal(0));
    			transRowCurrent.setCreditAmount(new BigDecimal(0));
    			transRowCurrent.setDeptAmount(amount);
    			
    			//cari sat?c? muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(curCard.getTurqAccountingAccountByAccountingCodeIdSupplier());
    	   			
    		}
    	   //Cari Karttan para tahsil edildiginde
  		   //Kasaya borc hareketi 
  		   //Cari kartin alici muhasebe hesabina alacak hareketi 
    		else 
    		{
    			transRowCash.setCreditAmount(new BigDecimal(0));
    			transRowCash.setDeptAmount(amount);
    			transRowCurrent.setCreditAmount(amount);
    			transRowCurrent.setDeptAmount(new BigDecimal(0));
    			
    			
    			//cari alici muhasebe kodunu da girelim
    			transRowCurrent.setTurqAccountingAccount(curCard.getTurqAccountingAccountByAccountingCodeIdCustomer());
    			
    		
    		}
        
        
         AccBLTransactionAdd blAcc = new AccBLTransactionAdd();
           
         
         //fis kalemlerini de ekleyelim.. 
         blAcc.saveAccTransactionRow(transRowCash,AccTransId);
         blAcc.saveAccTransactionRow(transRowCurrent,AccTransId);
       
		}
		catch(Exception ex){
			
		}
		
	}

	
	
	/**
	 * 
	 * @return butun cari kartlar listesi
	 * @throws Exception
	 */
	public List getCurrentCards() throws Exception {
		try{
			
			return dalCurrentTrans.getCurrentCards();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public List getCurrentTransactionTypes() throws Exception {
		try{
			
			return dalCurrentTrans.getTransactionTypes();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	
	
	
	
}
