package com.turquaz.bank.dal;

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

/**
 * @author Ceday
 * @version $Id$
 */

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransactionBill;



public class BankDALCommon {

	public BankDALCommon() {
	}

	public static void saveObject(Object obj) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {

			throw ex;

		}
	}
	public static void updateObject(Object obj) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.update(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {

			throw ex;

		}
	}
	public static void deleteObject(Object obj) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			Transaction tx = session.beginTransaction();

			session.delete(obj);
			session.flush();
			tx.commit();
			session.close();

		} catch (Exception ex) {

			throw ex;

		}
	}
	public static List searchBankTransactions(TurqBanksCard bankCard, String docNo, Date startDate, Date endDate)throws Exception {
	    try{
	    
	        
	        
	        Session session = EngDALSessionFactory.openSession();
	        String query = "select bankTrans.banksTransactionBillsId, bankTrans.turqBanksCard.bankCode, " +
    		" bankTrans.turqBanksTransactionType.transactionTypeName, sum(transRow.deptAmount),sum(transRow.creditAmount),bankTrans.transactionBillDate, bankTrans.transactionBillNo from TurqBanksTransactionBill as bankTrans " +
    		" left join bankTrans.turqBanksTransactions as transRow " +
    		" where bankTrans.transactionBillDate >= :startDate and bankTrans.transactionBillDate <= :endDate" +
    		" and bankTrans.transactionBillNo like '"+docNo+"%'" ;
    
     if(bankCard!=null){
         query+=" and bankTrans.turqBanksCard = :bankCard ";
     }
    		
    query +=" group by bankTrans.banksTransactionBillsId, bankTrans.turqBanksCard.bankCode,bankTrans.turqBanksTransactionType.transactionTypeName, bankTrans.transactionBillDate, bankTrans.transactionBillNo";
    query += " order by bankTrans";
	        
	       Query q = session.createQuery(query); 
	 if(bankCard!=null){
	     q.setParameter("bankCard",bankCard);
	   }
			
			q.setParameter("startDate",startDate);
			q.setParameter("endDate",endDate);
			
			List list = q.list();
			session.close();
			return list;
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	public static TurqBanksTransactionBill initializeTransaction(Integer transId)throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
	        TurqBanksTransactionBill trans = (TurqBanksTransactionBill)session.load(TurqBanksTransactionBill.class,transId);
	         
	        Hibernate.initialize(trans.getTurqBanksTransactions());
	        Hibernate.initialize(trans.getTurqEngineSequence().getTurqCurrentTransactions());
	        Hibernate.initialize(trans.getTurqEngineSequence().getTurqAccountingTransactions());
	        session.close();
	        return trans;
	        
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	public static void initializeTransaction(TurqBanksTransactionBill trans)throws Exception{
	    try{
	        Session session = EngDALSessionFactory.openSession();
	        
	        session.refresh(trans);
	        Hibernate.initialize(trans.getTurqBanksTransactions());
	        Hibernate.initialize(trans.getTurqEngineSequence().getTurqCurrentTransactions());
	        Hibernate.initialize(trans.getTurqEngineSequence().getTurqAccountingTransactions());
	        session.close();
	  
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}
	 public static List getTransactions(TurqBanksCard bankCard, Date startDate, Date endDate)throws Exception{
	        try{
	            Session session = EngDALSessionFactory.openSession();
	            SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
	        
	            
	            String query = "SELECT bankTrans.transaction_bill_date, bankCard.bank_code, bankTrans.transaction_bill_definition, totals.dept, totals.credit " +
	            		" FROM turq_banks_transaction_bills bankTrans " +
	            		" LEFT JOIN (Select sum(row.dept_amount) as dept, sum(row.credit_amount) as credit, row.bank_transactions_bills_id as transId" +
	            		" FROM turq_banks_transactions row group by row.bank_transactions_bills_id ) totals " +
	            		" ON  totals.transId = bankTrans.banks_transaction_bills_id," +
	            		" turq_banks_cards bankCard" +
	            		" where bankTrans.banks_cards_id ="+bankCard.getBanksCardsId().intValue()+
	            		" and bankTrans.transaction_bill_date >= '"+frmt.format(startDate)+"' and " +
	            		" bankTrans.transaction_bill_date <= '"+frmt.format(endDate)+"' " +
	            		" and bankTrans.banks_cards_id = bankCard.banks_cards_id";
	          
	            System.out.println(query);

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
	    public static List getDeferredTotal(TurqBanksCard cashCard, Date endDate) throws Exception
	    {
	        try{
	            Session session = EngDALSessionFactory.openSession();
	           
	            String query = "Select sum(row.deptAmount),sum(row.creditAmount)" +
	            		" from TurqBanksTransaction as row where row.turqBanksTransactionBill.transactionBillDate < :endDate" +
	            		" and row.turqBanksTransactionBill.turqBanksCard = :cashCard" +
	            		" group by row.turqBanksTransactionBill.turqBanksCard";
	            
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