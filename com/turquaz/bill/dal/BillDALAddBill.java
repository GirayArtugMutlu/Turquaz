
package com.turquaz.bill.dal;

import java.util.Iterator;
import java.util.Set;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillDALAddBill {
	public BillDALAddBill(){
		
	}
	public void save(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public void delete(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public Set getInvTransactions(TurqBill bill)throws Exception{
		try{
		
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.load(bill,bill.getBillsId());
		
	    Hibernate.initialize(bill.getTurqBillConsignmentCommon().getTurqConsignments());
			
		Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();	
		if(it.hasNext()){
			
		  TurqConsignment cons = (TurqConsignment)it.next();	
		
		  Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
		  
		  session.flush();
		  tx.commit();
		  session.close();
		
		  return cons.getTurqEngineSequence().getTurqInventoryTransactions();
		}
		else 
			return null;
		
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
}
