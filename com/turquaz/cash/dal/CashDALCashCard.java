
package com.turquaz.cash.dal;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/

import java.util.Date;
import java.util.List;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

/**
 * 
 * @author onsel
 * @version Id: $$
 */

public class CashDALCashCard {
    
    public CashDALCashCard(){
        
    }
    
    public void save(Object obj)throws Exception {
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
    
    public void update(Object obj)throws Exception {
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
    
    public void delete(Object obj)throws Exception{
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
    
    public List searchCashCard(TurqAccountingAccount account, String name)throws Exception{
     try{
         Session session = EngDALSessionFactory.openSession();
         
         String query = "select cashCard from TurqCashCard as cashCard " +
         		" where cashCard.cashCardName like '"+name+"%' ";
         if(account !=null){
             query += " cashCard.turqAccountingAccount = :account";
         }
         
         Query q = session.createQuery(query);
        
         if(account !=null){
             q.setParameter("account",account);
         }
         
         List lst = q.list();
         
         session.close();
         return lst; 
        
     }
     catch(Exception ex){
         throw ex;
     }
        
    }
    public List searchCashTransaction(TurqCashCard cashCard, Date startdate, Date endDate)throws Exception{
        try{
            
            Session session = EngDALSessionFactory.openSession();
            
            String query = "select cashTrans.cashTransactionsId, cashTrans.turqCashCard.cashCardName, " +
            		" cashTrans.turqCashTransactionType.cashTransationTypeName, sum(transRow.deptAmount),sum(transRow.creditAmount),cashTrans.transactionDate from TurqCashTransaction as cashTrans " +
            		" left join cashTrans.turqCashTransactionRows as transRow " +
            		" where cashTrans.transactionDate >= :startDate and cashTrans.transactionDate <= :endDate " ;
            
             if(cashCard!=null){
                 query+=" and cashTrans.turqCashCard = :cashCard ";
             }
            		
            query +=" group by cashTrans.cashTransactionsId, cashTrans.turqCashCard.cashCardName, cashTrans.turqCashTransactionType.cashTransationTypeName, cashTrans.transactionDate";
            
            Query q = session.createQuery(query);
            q.setParameter("startDate",startdate);
            q.setParameter("endDate",endDate);
            
            if(cashCard!=null){
             q.setParameter("cashCard",cashCard);   
            }
            
            List lst = q.list();
            
            return lst;
            
            
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    

}
