
package com.turquaz.bill.dal;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;


public class BillDALSearchBill {
	public BillDALSearchBill(){
		
		
	}
	public List searchBill(TurqCurrentCard curCard, Date startDate, Date endDate, int type)
	throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		
		String query = "Select bill from TurqBill as bill" +
				" where" +
				" bill.billsDate >= :startDate" +
				" and bill.billsDate <= :endDate" +
				" and bill.billsType ="+type +""+
				" and bill.billsId <> -1 ";
		
		
		if (curCard!=null){
		    query +=" and bill.turqBillConsignmentCommon.turqCurrentCard = :curCard"; 
		}
		query += " order by bill.billsDate";
		
		Query q = session.createQuery(query); 	
		
		q.setParameter("startDate",startDate);
		q.setParameter("endDate",endDate);
		
		if (curCard!=null){
			q.setParameter("curCard",curCard);
		}
		
		
		
		List list = q.list();
	    session.close();
		return list;
		
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	
	public void initializeBill(TurqBill bill)throws Exception{
	    try{
	    	Session session = EngDALSessionFactory.openSession();
			
			session.refresh(bill);
			
			Hibernate.initialize(bill.getTurqBillInGroups());
			Hibernate.initialize(bill.getTurqBillConsignmentCommon().getTurqConsignments());
			
			Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
			if(it.hasNext()){
				TurqConsignment cons = (TurqConsignment)it.next();
				Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
				
			}			
			
			
			session.close();
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}

}
