
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
import java.util.Iterator;
import java.util.List;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqEngineSequence;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

/**
 * 
 * @author onsel
 * @version $Id$
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
    
    public void deleteAccountingTransaction(TurqCashTransaction cashTrans)throws Exception{
        try{
            Session session = EngDALSessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            
            session.refresh(cashTrans);
            
            Iterator it = cashTrans.getTurqEngineSequence().getTurqAccountingTransactions().iterator();
            while(it.hasNext()){
                
              TurqAccountingTransaction accTran =(TurqAccountingTransaction)it.next();
              Iterator it2 = accTran.getTurqAccountingTransactionColumns().iterator();
              while(it2.hasNext()){
                  session.delete(it2.next());
                  
              }
              session.delete(accTran);
              
            }
            
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
    public List searchCashTransaction(TurqCashCard cashCard, Date startdate, Date endDate, String definition)throws Exception{
        try{
            
            Session session = EngDALSessionFactory.openSession();
            
            String query = "select distinct cashTrans.cashTransactionsId," +
            		" cashTrans.turqCashTransactionType.cashTransationTypeName, sum(transRow.deptAmount),sum(transRow.creditAmount),cashTrans.transactionDate, cashTrans.transactionDefinition from TurqCashTransaction as cashTrans" +
            		" left join cashTrans.turqCashTransactionRows as transRow " +
            		" where cashTrans.transactionDate >= :startDate and cashTrans.transactionDate <= :endDate " ;
            		
            
             if(cashCard!=null){
                 query+=" and transRow.turqCashCard = :cashCard ";
             }
             if(!definition.equals(""))
             {
             	query+=" and cashTrans.transactionDefinition like '"+definition+"%'";
             }
            		
            query +=" group by cashTrans.cashTransactionsId, cashTrans.turqCashTransactionType.cashTransationTypeName, cashTrans.transactionDate,cashTrans.transactionDefinition";
            query += " order by cashTrans.transactionDate";
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
    public TurqCashTransaction initiliazeCashTrans(Integer id)throws Exception{
        try{
            Session session = EngDALSessionFactory.openSession();
            
            TurqCashTransaction cashTrans =(TurqCashTransaction)session.load(TurqCashTransaction.class, id);
            
            if(cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqCashTransactionType().getId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
                Hibernate.initialize(cashTrans.getTurqEngineSequence().getTurqCurrentTransactions());
            }
                
            Hibernate.initialize(cashTrans.getTurqCashTransactionRows());
            Hibernate.initialize(cashTrans.getTurqEngineSequence().getTurqAccountingTransactions());
            
            session.close();
            return cashTrans;
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    public void initiliazeCashTrans(TurqCashTransaction cashTrans)throws Exception{
        try{
            
            Session session = EngDALSessionFactory.openSession();
            
            session.refresh(cashTrans);
       
           
                
            Hibernate.initialize(cashTrans.getTurqCashTransactionRows()); 
            
            session.close();
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
        
    }
    public TurqCurrentCard getCurrentCard (TurqEngineSequence seq)throws Exception{
        try{
            Session session = EngDALSessionFactory.openSession();
            session.refresh(seq);
            Hibernate.initialize(seq.getTurqCurrentTransactions());
            
            Iterator it = seq.getTurqCurrentTransactions().iterator();
            
            if(it.hasNext()){
                
            TurqCurrentTransaction curTrans = (TurqCurrentTransaction)it.next();
            session.close();
            return curTrans.getTurqCurrentCard();
            
            
            }
            
            session.close();
            return null;
            
            
            
        }
        catch(Exception ex){
            throw ex;
        }
        
    }
    public static List getTransactions(TurqCashCard cashCard, Date startDate, Date endDate)throws Exception{
        try{
            Session session = EngDALSessionFactory.openSession();
          
            
            String query = "select trans.cashTransactionsId, trans.transactionDate, trans.transactionDefinition," +
            		" transRow.deptAmount,transRow.creditAmount, trans.turqCashTransactionType.cashTransationTypeName" +
            		" from TurqCashTransaction as trans left join trans.turqCashTransactionRows as transRow " +
            		" where transRow.turqCashCard = :cashCard" +
            		" and trans.transactionDate >= :startDate and trans.transactionDate<= :endDate" +
            		
            		" order by trans.cashTransactionsId,trans.transactionDate";

          
            Query q = session.createQuery(query);
            q.setParameter("cashCard",cashCard);
            q.setParameter("startDate",startDate);
            q.setParameter("endDate",endDate);
            
            List ls = q.list();
            session.close();
            return ls;
            
        }
        catch(Exception ex){
            throw ex;
        }
    }

    //Devreden Toplam
    public static List getDeferredTotal(TurqCashCard cashCard, Date endDate) throws Exception
    {
        try{
            Session session = EngDALSessionFactory.openSession();
           
            String query = "Select sum(row.deptAmount),sum(row.creditAmount)" +
            		" from TurqCashTransactionRow as row where row.turqCashTransaction.transactionDate < :endDate" +
            		" and row.turqCashCard = :cashCard" +
            		" group by row.turqCashCard";
            
            Query q = session.createQuery(query);
            q.setParameter("endDate",endDate);
            q.setParameter("cashCard",cashCard);
            List ls = q.list();
            
            session.close();
            return ls;
            
            
            
            
        }
        catch(Exception ex)
        {
            throw ex;
        }
        
        
    }
    

}
