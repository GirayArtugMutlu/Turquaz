
package com.turquaz.bill.dal;


import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingTransaction;

import com.turquaz.engine.dal.TurqBill;


/**
 * @author onsel
 *
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
	public static void updateObject(Object obj)throws Exception{
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
	
	public static void deleteAccountingTransactions(int seq_id)throws Exception{
		try{
		    Session session = EngDALSessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    
		    Iterator iter = session.iterate("from TurqAccountingTransaction as trans where " +
					" trans.turqEngineSequence.id ="+seq_id);
		    
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
		    
	
	public static void deleteCurrentTransactions(int seq_id)throws Exception{
	try{
	    Session session = EngDALSessionFactory.openSession();
	    Transaction tx = session.beginTransaction();
	    
	    Iterator iter = session.iterate("from TurqCurrentTransaction as trans where " +
				" trans.turqEngineSequence.id ="+seq_id);
	    
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
	
	public static boolean canUpdateBill(TurqBill bill)throws Exception{
	  try{
	      Session session = EngDALSessionFactory.openSession();
			
			String query = "Select accTrans from TurqAccountingTransaction as accTrans where " +
					" accTrans.turqAccountingJournal.id <>-1" +
					" and accTrans.turqEngineSequence = :billEngineSeq";

			Query q = session.createQuery(query); 	
			q.setParameter("billEngineSeq",bill.getTurqEngineSequence());

			List list = q.list();
			
			if(list.size()==0){
			    return true;
			}
			else return false;
	      
	  }
	  catch(Exception ex){
	     
	   throw ex;
	 
	      
	  }
	 
	}
	
	public static void deleteObject(Object obj)throws Exception{
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
