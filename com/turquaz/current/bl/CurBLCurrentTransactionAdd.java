/*
 * Created on Oct 26, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import com.turquaz.current.dal.CurDALCurrentCardUpdate;
import com.turquaz.current.dal.CurDALCurrentTransactionAdd;
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
	
	public void saveCurrentTransaction(TurqCurrentCard curCard,java.util.Date transDate, String documentNo,
									BigDecimal totalDept, BigDecimal totalCredit,BigDecimal totalDiscount,
									int type) throws Exception{
		try{
		TurqCurrency currency = new TurqCurrency();
        currency.setCurrenciesId(new Integer(1));
        
        TurqCurrentTransactionType transType = new TurqCurrentTransactionType();
        transType.setCurrentTransactionTypesId(new Integer(type));
        
		
		TurqCurrentTransaction curTrans = new TurqCurrentTransaction();
		curTrans.setTransactionsDate(transDate);
		curTrans.setTransactionsDocumentNo(documentNo);
		curTrans.setTurqCurrentCard(curCard);
		curTrans.setTransactionsTotalCredit(totalCredit);
		curTrans.setTransactionsTotalDept(totalDept);
		curTrans.setTransactionsTotalDiscount(totalDiscount);
		curTrans.setTurqCurrency(currency);
		curTrans.setTurqCurrentTransactionType(transType);		
		
		curTrans.setCreatedBy(System.getProperty("user"));
		curTrans.setUpdatedBy(System.getProperty("user"));
		curTrans.setLastModified(new java.sql.Date(cal.getTime().getTime()));
		curTrans.setCreationDate(new java.sql.Date(cal.getTime().getTime()));
        dalCurrentTrans.saveObject(curTrans);
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	public List getCurrentCards() throws Exception {
		try{
			
			return dalCurrentTrans.getCurrentCards();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	
	
	
	
}
