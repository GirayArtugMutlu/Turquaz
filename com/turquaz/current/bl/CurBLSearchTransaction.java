/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.bl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.turquaz.current.dal.CurDALSearchTransaction;
import com.turquaz.engine.dal.TurqAccountingAccount;
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
	
	public void updateCurrentTransaction(TurqCurrentCard curCard,java.util.Date transDate,
			String documentNo,boolean isCredit,BigDecimal amount,
			TurqAccountingAccount account,TurqCurrentTransaction curTrans)throws Exception{
	try{
		
		curTrans.setTurqCurrentCard(curCard);
		curTrans.setTransactionsDate(transDate);
		curTrans.setTransactionsDocumentNo(documentNo);
		
		
		
		
		
			
			
			
			
	}
	catch(Exception ex){
		throw ex;
	}
		
		
		
	
	}
	
	

}
