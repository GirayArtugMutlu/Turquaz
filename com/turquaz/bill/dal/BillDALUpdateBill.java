
package com.turquaz.bill.dal;


import java.util.Iterator;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;

import com.turquaz.engine.dal.TurqBill;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillDALUpdateBill {

	public BillDALUpdateBill(){
		
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
	public void updateObject(Object obj)throws Exception{
		try{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(obj);
		session.flush();
		tx.commit();
		session.close();
		
		}
		catch(Exception ex){
			throw ex;
		}
	}
	
	
	
	public void updateBill(TurqBill obj)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(obj);
		
			session.flush();
			tx.commit();
			session.close();
			
			}
			catch(Exception ex){
				throw ex;
			}
		
	}
	
	public void deleteAccountingTransactions(int seq_id)throws Exception{
		try{
		    Session session = EngDALSessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    
		    Iterator iter = session.iterate("from TurqAccountingTransaction as trans where " +
					" trans.turqEngineSequence.engineSequencesId ="+seq_id);
		    
			while(iter.hasNext()){
			    TurqAccountingTransaction trans = (TurqAccountingTransaction)iter.next();
			    Iterator it = trans.getTurqAccountingTransactionColumns().iterator();
			    while(it.hasNext()){
			        session.delete(it.next());
			    }
			    session.delete(trans);
			    
			
			}
			
			
			
			session.flush();
			tx.commit();
			session.close();
		    
		    
		}
		catch(Exception ex){
		    throw ex;
		}
	}
		    
	
	public void deleteCurrentTransactions(int seq_id)throws Exception{
	try{
	    Session session = EngDALSessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    Iterator iter = session.iterate("from TurqCurrentTransaction as trans where " +
				" trans.turqEngineSequence.engineSequencesId ="+seq_id);
	    
		while(iter.hasNext()){
		    session.delete(iter.next());
		}
		session.flush();
		tx.commit();
		session.close();	    
	    
	}
	catch(Exception ex){
	    throw ex;
	}
	    
	    
	    
	}	
	public void deleteObject(Object obj)throws Exception{
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

}
