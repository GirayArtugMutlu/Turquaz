
package com.turquaz.consignment.dal;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ConDALSearchConsignment {
	public ConDALSearchConsignment(){
		
	}
	
	public List searchConsignments(TurqCurrentCard curCard, Date startDate, Date endDate, int type)
	throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		
		String query = "Select consignment from TurqConsignment as consignment where" +
				" consignment.turqCompany.companiesId ="+System.getProperty("company")+
				" and consignment.consignmentsDate >= :startDate" +
				" and consignment.consignmentsDate <= :endDate" +
				" and consignment.consignmentsType ="+type +"";
		
		
		if (curCard!=null){
			query +=" and consignment.turqCurrentCard = :curCard";
		}
		query += " order by consignment.consignmentsDate";
		
		Query q = session.createQuery(query); 	
		
		q.setParameter("startDate",startDate);
		q.setParameter("endDate",endDate);
		
		if (curCard!=null){
			q.setParameter("curCard",curCard);
		}
		
		
		
		List list = q.list();
		
		TurqConsignment cons;
		for(int i=0;i<list.size();i++){
			
		cons= (TurqConsignment)list.get(i);
		Hibernate.initialize(cons.getTurqConsignmentsInGroups());
		Hibernate.initialize(cons.getTurqInventoryTransactions());
			
		}
		
		session.close();
		return list;
		
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	

}
