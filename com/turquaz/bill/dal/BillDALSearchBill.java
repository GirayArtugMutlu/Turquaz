
package com.turquaz.bill.dal;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillDALSearchBill {
	public BillDALSearchBill(){
		
		
	}
	public List searchBill(TurqCurrentCard curCard, Date startDate, Date endDate, int type)
	throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		
		String query = "Select bill from TurqBill as bill where" +
				" bill.turqCompany.companiesId ="+System.getProperty("company")+
				" and bill.billsDate >= :startDate" +
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
		
		TurqBill bill;
		for(int i=0;i<list.size();i++){
			
		bill= (TurqBill)list.get(i);
		Hibernate.initialize(bill.getTurqBillInGroups());
		Hibernate.initialize(bill.getTurqEngineSequence().getTurqConsignments());
		Iterator it = bill.getTurqEngineSequence().getTurqConsignments().iterator();
		if(it.hasNext()){
			TurqConsignment cons = (TurqConsignment)it.next();
			Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
		}
	   
	}
		
		session.close();
		return list;
		
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	}

}
