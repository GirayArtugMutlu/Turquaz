
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
		
		String query = "Select consignment from TurqConsignment as consignment where" + //$NON-NLS-1$
				" consignment.turqCompany.companiesId ="+System.getProperty("company")+ //$NON-NLS-1$ //$NON-NLS-2$
				" and consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
				" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$
				" and consignment.consignmentsType ="+type + //$NON-NLS-1$
				" and consignment.consignmentsId <> -1 "; //$NON-NLS-1$
		
		
		if (curCard!=null){
			query +=" and consignment.turqCurrentCard = :curCard"; //$NON-NLS-1$
		}
		query += " order by consignment.consignmentsDate"; //$NON-NLS-1$
		
		Query q = session.createQuery(query); 	
		
		q.setParameter("startDate",startDate); //$NON-NLS-1$
		q.setParameter("endDate",endDate); //$NON-NLS-1$
		
		if (curCard!=null){
			q.setParameter("curCard",curCard); //$NON-NLS-1$
		}
		
		
		
		List list = q.list();
		
		TurqConsignment cons;
		for(int i=0;i<list.size();i++){
			
		cons= (TurqConsignment)list.get(i);
		Hibernate.initialize(cons.getTurqConsignmentsInGroups());
		Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
			
		}
		
		session.close();
		return list;
		
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	
	//?rsaliyeden faturalstirma da kullaniliyo..
	public List chooseConsignments(TurqCurrentCard curCard, Date startDate, Date endDate, int type)
	throws Exception {
	try{
		Session session = EngDALSessionFactory.openSession();
		
		String query = "Select consignment from TurqConsignment as consignment where" + //$NON-NLS-1$
				" consignment.turqCompany.companiesId ="+System.getProperty("company")+ //$NON-NLS-1$ //$NON-NLS-2$
				" and consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
				" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$
				" and consignment.consignmentsType ="+type + //$NON-NLS-1$
				" and consignment.consignmentsId <> -1 "+ //$NON-NLS-1$
				" and consignment.turqBillConsignmentCommon.turqBills.size=0"; //$NON-NLS-1$
		
		
		if (curCard!=null){
			query +=" and consignment.turqCurrentCard = :curCard"; //$NON-NLS-1$
		}
		query += " order by consignment.consignmentsDate"; //$NON-NLS-1$
		
		Query q = session.createQuery(query); 	
		
		q.setParameter("startDate",startDate); //$NON-NLS-1$
		q.setParameter("endDate",endDate); //$NON-NLS-1$
		
		if (curCard!=null){
			q.setParameter("curCard",curCard); //$NON-NLS-1$
		}
		
		
		
		List list = q.list();
		
		TurqConsignment cons;
		for(int i=0;i<list.size();i++){
			
		cons= (TurqConsignment)list.get(i);
		Hibernate.initialize(cons.getTurqConsignmentsInGroups());
		Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
			
		}
		
		session.close();
		return list;
		
		
		
	}
	catch(Exception ex){
		throw ex;
	}
	}
	

}
