/*
 * Created on Oct 28, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.current.dal;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransactionType;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
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
	
	
	

}
