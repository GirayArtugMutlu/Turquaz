/*
 * Created on Oct 19, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.accounting.dal;
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
* @author  Onsel Armagan
* @version  $Id$
*/

import java.util.Date;
import java.util.List;


import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionType;



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
* @author  Onsel Armagan
* @version  $Id$
*/
public class AccDALTransactionSearch {
	
	public AccDALTransactionSearch()
	{
			
	}
	
	public List getTransactionTypes()throws Exception{
		
		try{
			Session session = EngDALSessionFactory.openSession();
			
			String query = "select distinct transType from TurqAccountingTransactionType as transType";
			Query q = session.createQuery(query); 
			List list = q.list();
			session.close();
			
			return list;
			
			
		}
		catch(Exception ex){
			throw ex;
			
		}
		
		
		
		
	}
	
	public List searchTransaction(String docNo,Object type,Object startDate, Object endDate)throws Exception {
    try{
    	Session session = EngDALSessionFactory.openSession();
		
    	String query ="select accTrans from TurqAccountingTransaction as accTrans "+
    				  "where accTrans.transactionDocumentNo like '"+docNo+"%' ";
    	
		if(startDate!=null){
		
		query += " and accTrans.transactionsDate >= :startDate";
		}
		
		if(endDate !=null){
		query += " and accTrans.transactionsDate <= :endDate";	
		}
    	
		if(type!=null){
			query += " and accTrans.turqAccountingTransactionType= :transType";
		}
    	
		Query q = session.createQuery(query); 
		
		if(startDate!=null){
			Date date = (Date)startDate;
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			q.setParameter("startDate",sqlDate);
			}
			
		if(endDate !=null){
				Date date = (Date)endDate;
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());
				q.setParameter("endDate",sqlDate);
		}
	    	
		if(type!=null){
			TurqAccountingTransactionType transType = (TurqAccountingTransactionType)type;
			q.setParameter("transType",transType);
			
		}
			
		List list = q.list();
		for (int i =0;i<list.size();i++){
			
		TurqAccountingTransaction accTrans = (TurqAccountingTransaction)list.get(i);
		Hibernate.initialize(accTrans.getTurqAccountingTransactionColumns());
			
		}
		
		session.close();
		
		return list;
	
		
	}
	catch(Exception ex){
		throw ex;
	}
	
	
	}
	public void removeTransactionRows(TurqAccountingTransaction transaction)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			
			Transaction tr = session.beginTransaction();
			
			session.delete("select row from TurqAccountingTransactionColumn as row where" +
					" row.turqAccountingTransaction.accountingTransactionsId ="+transaction.getAccountingTransactionsId().intValue());
		
			session.flush();
			tr.commit();
			
			session.close();
			
			
			
		}
		catch(Exception ex){
			throw ex;
			
		}
		
	}
	public List searchTransactionRows(TurqAccountingTransaction trans, boolean isCredit)throws Exception{
		try{
		
			Session session = EngDALSessionFactory.openSession();
			
			String query = "select transRow from TurqAccountingTransactionColumn as transRow" +
					" where transRow.turqAccountingTransaction = :trans" ;
			
			//Tahsil Fisi		
			if(isCredit){
				query += " and transRow.creditAmount > 0";
			}
			//Tediye Fisi
			else {
			     query += " and transRow.deptAmount > 0";
			}
			
			Query q = session.createQuery(query); 
			q.setParameter("trans",trans);
			List list = q.list();
			session.close();
			
			return list;	
			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	

}
