
package com.turquaz.bank.bl;
/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

/**
* @author  Ceday
* @version  $Id$
*/


import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.bank.dal.BankDALBankCardUpdate;
import com.turquaz.bank.dal.BankDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;


public class BankBLBankCardUpdate {
	public BankBLBankCardUpdate(){
		
	}
	
	private BankDALBankCardUpdate bankDALBankCardUpdate=new BankDALBankCardUpdate();
	
	
	public static void updateBankCard(TurqBanksCard bankCard,String bankName,
			String bankBranchName, String bankAccountNo,TurqCurrency currency,
			String definition, String bankCode, Map accountingAccounts)throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			updateBankCardInfo(session,bankCard,bankName,bankBranchName,
					bankAccountNo,currency,definition,bankCode);
			if(!checkInitialTransaction(session,bankCard))
			{			
				//TODO Transaction save should use SESSION!
			   BankBLTransactionAdd.saveInitialBankTransaction(bankCard);			    
			}
			updateBankAccountingAccounts(session,bankCard,accountingAccounts);	
			session.flush();
			tx.commit();
			session.close();
			
		}
		catch(Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	}

	public static void updateBankCardInfo(Session session, TurqBanksCard bankCard,
			String bankName, String bankBranchName, String bankAccountNo,
			TurqCurrency currency, String definition, String bankCode)throws Exception
	{
		bankCard.setBankName(bankName);
		bankCard.setBankBranchName(bankBranchName);
		bankCard.setBankAccountNo(bankAccountNo);	
		bankCard.setTurqCurrency(currency);
		bankCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		Calendar cal=Calendar.getInstance();
		bankCard.setLastModified(cal.getTime());
		bankCard.setBankDefinition(definition);
		bankCard.setBankCode(bankCode);		
		BankDALBankCardUpdate.updateObject(session,bankCard);		
	}
	
	
	public static boolean checkInitialTransaction(Session session, TurqBanksCard bankCard) throws Exception{
	   try
	   {
	       return BankDALCommon.checkInitialTransaction(session,bankCard);
	   }
	   catch(Exception ex)
	   {
	       throw ex;
	   }    
	}
	
	public static void updateBankAccountingAccounts(Session session,
			TurqBanksCard curCard, Map accounts)throws Exception
	{
		
		Iterator it = curCard.getTurqBankAccountingAccounts().iterator();
		while(it.hasNext())
		{
			//TODO SESSION
			BankDALCommon.deleteObject(it.next());
		}
		
		BankBLBankCardAdd.saveBankAccountingAccounts(session,curCard,accounts);	
	}
	
	
	public boolean hasTransaction(TurqBanksCard bankCard)throws Exception {
		
		return bankDALBankCardUpdate.hasTransaction(bankCard);
		
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
	/**
	 * 
	 * @param obj Serializable object
	 */
	
	public void deleteBankCard(TurqBanksCard bankCard)throws Exception{
 		try{
 			
 			Iterator it = bankCard.getTurqBankAccountingAccounts().iterator();
 			while(it.hasNext())
 			{
 				deleteObject(it.next());
 				
 			}
 			
 			bankDALBankCardUpdate.deleteInitialTransaction(bankCard);
 			
 			bankDALBankCardUpdate.deleteObject(bankCard);
 			
		}
		catch(Exception ex){
			throw ex;
		}
		
	}

}
