
package com.turquaz.cheque.dal;

import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;

public class CheDALSave {
  
    public static void save(Object obj)throws Exception {
        try{
            Session session = EngDALSessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.save(obj);
            
            tx.commit();
            session.flush();
            session.close();    
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    public static void saveOrUpdate(Object obj)throws Exception {
        try{
            Session session = EngDALSessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.saveOrUpdate(obj);
            
            tx.commit();
            session.flush();
            session.close();
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    
    public static void update(Object obj)throws Exception {
        try{
            
            Session session = EngDALSessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.update(obj);
            
            tx.commit();
            session.flush();
            session.close();
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
        
    }
    
    public static void delete(Object obj)throws Exception{
        try{
            
            Session session = EngDALSessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            session.delete(obj);
            tx.commit();
           session.flush();
            session.close();
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
    } 
}
