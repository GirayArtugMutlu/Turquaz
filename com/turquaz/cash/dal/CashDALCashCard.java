
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

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            
            if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT
                    ||cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT ){
                
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
            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
        
            
            String query = "SELECT cashTrans.transaction_date, cashCard.cash_card_name, cashTrans.transaction_definition, totals.dept, totals.credit " +
            		" FROM turq_cash_transactions cashTrans " +
            		" LEFT JOIN (Select sum(row.dept_amount) as dept, sum(row.credit_amount) as credit, row.cash_transactions_id as transId" +
            		" FROM turq_cash_transaction_rows row group by row.cash_transactions_id ) totals " +
            		" ON  totals.transId = cashTrans.cash_transactions_id," +
            		" turq_cash_cards cashCard" +
            		" where cashTrans.cash_cards_id ="+cashCard.getCashCardsId().intValue()+
            		" and cashTrans.transaction_date >= '"+frmt.format(startDate)+"' and " +
            		" cashTrans.transaction_date <= '"+frmt.format(endDate)+"' " +
            		" and cashTrans.cash_cards_id = cashCard.cash_cards_id";
          

            Statement stmt = session.connection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            Object [] result;
            List ls = new ArrayList();
            
            while(rs.next()){
                result = new Object[5];
                result[0] = rs.getObject(1);
                result[1] = rs.getObject(2);
                result[2] = rs.getObject(3);
                result[3] = rs.getObject(4);
                result[4] = rs.getObject(5);
                 ls.add(result);             
            }
         
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
            		" and row.turqCashTransaction.turqCashCard = :cashCard" +
            		" group by row.turqCashTransaction.turqCashCard";
            
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
