
package com.turquaz.bill.dal;

import java.util.Iterator;
import java.util.Set;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;


public class BillDALAddBill {
	public BillDALAddBill(){
		
	}


	public static Set getInvTransactions(TurqBill bill)throws Exception{
		try{
		
		Session session = EngDALSessionFactory.openSession();

		session.refresh(bill);
		
	    Hibernate.initialize(bill.getTurqBillConsignmentCommon().getTurqConsignments());
			
		Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();	
		if(it.hasNext()){
			
		  TurqConsignment cons = (TurqConsignment)it.next();	
		
		  Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
		
		  
		  session.close();
		
		  return cons.getTurqEngineSequence().getTurqInventoryTransactions();
		}
		else 
			session.close();
			return null;
		
		
		}
		catch(Exception ex){
			throw ex;
		}
		
	}
}
