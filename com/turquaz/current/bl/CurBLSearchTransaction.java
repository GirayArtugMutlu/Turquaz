/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.accounting.dal.AccDALTransactionUpdate;
import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.current.dal.CurDALTransactionUpdate;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CurBLSearchTransaction {
	private CurDALSearchTransaction dalSearch = new CurDALSearchTransaction();
	private AccBLTransactionUpdate accDalUpdate = new AccBLTransactionUpdate();
	CurDALTransactionUpdate dalUpdate = new CurDALTransactionUpdate();
	AccBLTransactionSearch blAccSearch = new AccBLTransactionSearch();
	CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
	Calendar cal = Calendar.getInstance();
	public CurBLSearchTransaction(){
		
	}
	public List searchCurrentTransaction(Object curCard,
										Object type, String docNo, Date startDate,
										Date endDate)throws Exception {
		try{
		
		return 	dalSearch.searchTransaction((TurqCurrentCard)curCard,
											(TurqCurrentTransactionType)type,
											docNo,startDate, endDate);
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public void updateCurrentTransaction(TurqCurrentCard curCard,Date transDate,
			String documentNo,boolean isCredit,BigDecimal amount,
			TurqAccountingAccount account,TurqCurrentTransaction curTrans)throws Exception{
	try{
		
		curTrans.setTurqCurrentCard(curCard);
		curTrans.setTransactionsDate(transDate);
		curTrans.setTransactionsDocumentNo(documentNo);
		curTrans.setUpdatedBy(System.getProperty("user"));
 		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		
 		
		int accTransType;
		
		if(isCredit){
		
		accTransType =1;
		curTrans.setTransactionsTotalCredit(amount);	
		curTrans.setTransactionsTotalDept(new BigDecimal(0));
		
		}
		else{
		
		accTransType =0;	
		curTrans.setTransactionsTotalCredit(new BigDecimal(0));
		curTrans.setTransactionsTotalDept(amount);
		
		}

 		dalUpdate.updateObject(curTrans);
 		
    	accDalUpdate.updateTransaction(curTrans.getTurqAccountingTransaction(),documentNo,transDate,accTransType);		
		
//    	Remove transaction rows
		blAccSearch.removeTransactionRows(curTrans.getTurqAccountingTransaction());

//		Save new Transaction Rows		
		blTransAdd.saveAccountingCashTransactionRows(curCard,isCredit,amount,account,
				curTrans.getTurqAccountingTransaction().getAccountingTransactionsId());
				
			
	}
	catch(Exception ex){
		throw ex;
	}
		
		
		
	
	}
	
	

}
