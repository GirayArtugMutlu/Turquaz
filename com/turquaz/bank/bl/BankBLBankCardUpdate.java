/*
 * Created on 15.Eki.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.bank.bl;

import java.util.Calendar;

import com.turquaz.bank.dal.BankDALBankCardUpdate;
import com.turquaz.engine.dal.TurqBanksCard;

/**
 * @author Ceday
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BankBLBankCardUpdate {
	public BankBLBankCardUpdate(){
		
	}
	
	private BankDALBankCardUpdate bankDALBankCardUpdate=new BankDALBankCardUpdate();
	private Calendar cal=Calendar.getInstance();
	
	
	/**
	 * 
	 * @param bankName String
	 * @param bankBranchName String
	 * @param bankAccountNo String
	 * @param aCard TurqBanksCard
	 */
	
	public void updateBankCard(String bankName, String bankBranchName, String bankAccountNo, TurqBanksCard aCard)
	throws Exception{
		try{
			aCard.setBankName(bankName);
			aCard.setBankBranchName(bankBranchName);
			aCard.setBankAccountNo(bankAccountNo);	
			aCard.setUpdatedBy(System.getProperty("user"));
			aCard.setLastModified(new java.sql.Date(cal.getTime().getTime()));
			bankDALBankCardUpdate.updateObject(aCard);
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * 
	 * @param obj Serializable object
	 */
	
	public void deleteObject(Object obj)throws Exception{
 		try{
			
 			bankDALBankCardUpdate.deleteObject(obj);
 			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
