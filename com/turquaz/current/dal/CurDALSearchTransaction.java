
package com.turquaz.current.dal;
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

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransactionType;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CurDALSearchTransaction {
	
	public CurDALSearchTransaction(){
		
	}
	public List searchTransaction(TurqCurrentCard curCard, TurqCurrentTransactionType type,
			String docNo , Date startDate, Date endDate)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			
			String query = "Select transaction from TurqCurrentTransaction as transaction where" +
			" transaction.transactionsDocumentNo like '"+docNo+"%'"+
			" and transaction.transactionsDate >= :startDate " +
			" and transaction.transactionsDate <= :endDate";
			
			if (curCard!=null){
				query +=" and transaction.turqCurrentCard = :curCard";
			}
			if(type!=null){
				query += " and transaction.turqCurrentTransactionType = :type";
			}
			
			Query q = session.createQuery(query); 	
			q.setParameter("startDate",startDate);
			q.setParameter("endDate",endDate);
			
			if (curCard!=null){
				q.setParameter("curCard",curCard);
			}
			if(type!=null){
				q.setParameter("type", type);
			}
			List list = q.list();
			session.close();
			return list;
			
			
			
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	
	public List getCurrentTransactions(TurqCurrentCard curCard, Date startDate, Date endDate)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			
			String query = "Select transaction from TurqCurrentTransaction as transaction where" +
			" transaction.turqCurrentCard= :curCard";
			
			if (startDate != null && endDate != null)
			{
				query+=" and transaction.transactionsDate >= :startDate " +
				" and transaction.transactionsDate <= :endDate";
			}
			Query q = session.createQuery(query); 
			if (startDate != null && endDate != null)
			{
				q.setParameter("startDate",startDate);
				q.setParameter("endDate",endDate);
			}
			q.setParameter("curCard",curCard);
			
			List list = q.list();
			session.close();
			return list;		
			
			
		}
		catch(Exception ex){
			throw ex;
		}
		
		
	}
	public List getCurrentBalances(TurqCurrentCard curCard, Date endDate) throws Exception {
	    try{
	        
	    	Session session = EngDALSessionFactory.openSession(); 
	    	String query = "Select sum(transaction.transactionsTotalDept),sum(transaction.transactionsTotalCredit) from TurqCurrentTransaction as transaction where" +
			" transaction.turqCurrentCard= :curCard and" +
			" transaction.transactionsDate < :endDate";
	    
	    	Query q = session.createQuery(query); 
	    	
	    	q.setParameter("curCard",curCard);
	    	q.setParameter("endDate",endDate);
	    	
	    	List list = q.list();
	    	session.close();
	    	return list;
	    	
	        
	    }
	    catch(Exception ex){
	        
	        throw ex;
	    }
	    
	    
	    
	    
	}
	public List getInitialTransactions()throws Exception {
	    try{
	        
	        Session session = EngDALSessionFactory.openSession();
	        String query = "Select curTrans from TurqCurrentTransaction as curTrans " +
	        		" where curTrans.turqCurrentTransactionType.currentTransactionTypesId = "+EngBLCommon.CURRENT_TRANS_INITIAL+
	        		" order by curTrans.turqCurrentCard.cardsCurrentCode";
	        
	    	Query q = session.createQuery(query); 
	        List list = q.list();
	    	session.close();
	    	return list;
	    	
	        
	    }
	    catch(Exception ex){
	        
	        throw ex;
	    }
	}
	
	
	

}
