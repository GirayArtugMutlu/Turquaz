
package com.turquaz.consignment.dal;

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
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
				" and consignment.consignmentsType ="+type +"" +
				" order by consignment.consignmentsDate";
		
		
		if (curCard!=null){
			query +=" and bankCard.turqCurrentCard = :curCard";
		}
		
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
	

}
