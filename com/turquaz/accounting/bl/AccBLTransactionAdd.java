
package com.turquaz.accounting.bl;
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
* @author  Ehad Karacam
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.turquaz.accounting.dal.AccDALTransactionAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqAccountingJournal;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqAccountingTransactionType;

import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.dal.TurqEngineSequence;

import com.turquaz.engine.dal.TurqModule;

public class AccBLTransactionAdd {
	private AccDALTransactionAdd dalTransAdd = new AccDALTransactionAdd();
	Calendar cal = Calendar.getInstance();
	
	public AccBLTransactionAdd(){
		
	}
	
	
	//Muhasebe fisi kalemlerini kaydet
	public void saveAccTransactionRow(TurqAccountingTransactionColumn transRow,
			Integer transID, TurqCurrencyExchangeRate exchangeRate)
	throws Exception
	{
		try
		{
			if(transRow.getCreditAmount().compareTo(new BigDecimal(0))<1 
					&& transRow.getDeptAmount().compareTo(new BigDecimal(0))<1)
			{
				return;
			}
			TurqAccountingTransaction trans = new TurqAccountingTransaction();
			trans.setId(transID);
		
			transRow.setTurqAccountingTransaction(trans);			
			
			transRow.setRowsCreditInBaseCurrency(transRow.getCreditAmount());
			transRow.setRowsDeptInBaseCurrency(transRow.getDeptAmount());
			transRow.setTurqCurrencyExchangeRate(exchangeRate);
			transRow.setRowsCreditInBaseCurrency(transRow.getCreditAmount().multiply(exchangeRate.getExchangeRatio()));
			transRow.setRowsDeptInBaseCurrency(transRow.getDeptAmount().multiply(exchangeRate.getExchangeRatio()));


			transRow.setCreatedBy(System.getProperty("user"));
			transRow.setUpdatedBy(System.getProperty("user"));
		
			transRow.setLastModified(new java.sql.Date( cal.getTime().getTime()));
			transRow.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
			dalTransAdd.save(transRow);
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
   
	
   public Integer saveAccTransaction(Date date, String documentNo,int type,int moduleId,Integer docSeqId, String definition) throws Exception
	{
		try{
			
		TurqEngineSequence docSeq =new TurqEngineSequence();	
		
		if(docSeqId==null){
			
			TurqModule module = new TurqModule();
			module.setId(new Integer(EngBLCommon.MODULE_ACCOUNTING));
			docSeq.setTurqModule(module);
			dalTransAdd.save(docSeq);
		}
		else
		{
			docSeq.setId(docSeqId);
			
		}
		
		
		TurqAccountingTransaction trans = new TurqAccountingTransaction();
		 trans.setTurqEngineSequence(docSeq);
		
		
		trans.setTransactionDocumentNo(documentNo);
		trans.setTransactionDescription(definition);
		trans.setTransactionsDate(new java.sql.Date(date.getTime()));
		
		/**
		 * TODO Will Change in next version
		 * TODO trans exhangeRate issue
		 */
		trans.setTurqCurrencyExchangeRate(EngBLCommon.getBaseCurrencyExchangeRate());
		
		//Hangi modulde kaydedildigi
		TurqModule module = new TurqModule();
		module.setId(new Integer(moduleId));
		trans.setTurqModule(module);
		
		//Muhasebelestirilmemis.. o zaman yevmiye kaydi -1
		TurqAccountingJournal journal = new TurqAccountingJournal();
		journal.setId(new Integer(-1))	;
		trans.setTurqAccountingJournal(journal);
		
		//Fis tip
		TurqAccountingTransactionType transType =new TurqAccountingTransactionType();
		transType.setId(new Integer(type));	
		trans.setTurqAccountingTransactionType(transType);
		
		trans.setCreatedBy(System.getProperty("user"));
		trans.setUpdatedBy(System.getProperty("user"));
		
		trans.setLastModified(new java.sql.Date( cal.getTime().getTime()));
		trans.setCreationDate(new java.sql.Date( cal.getTime().getTime()));
		trans.setTransactionDescription(definition);
		
	
		dalTransAdd.save(trans);
			
		
			
		return trans.getId();
			
			
		}
		catch(Exception ex){
			throw ex;
		}
	
	
	}
	

}
