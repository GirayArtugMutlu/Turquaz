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
 * @author Onsel
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
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransactionBill;

public class BankDALCommon
{
	public static List searchBankTransactions(String docNo, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select bankTrans.id, bankTrans.transactionBillDate,"
					+ " bankTrans.turqBanksTransactionType.transactionTypeName,"
					+ " bankTrans.transactionBillDefinition, bankTrans.transactionBillNo," +
					" sum(transRow.deptAmount),sum(transRow.creditAmount),bankTrans.turqBanksTransactionType.id"
					+ " from TurqBanksTransactionBill as bankTrans " + " left join bankTrans.turqBanksTransactions as transRow "
					+ " where bankTrans.transactionBillDate >= :startDate and bankTrans.transactionBillDate <= :endDate"
					+ " and bankTrans.transactionBillNo like '" + docNo + "%'";
			query += " group by bankTrans.id, bankTrans.transactionBillDate,"
					+ "bankTrans.turqBanksTransactionType.transactionTypeName,"
					+ "bankTrans.transactionBillDefinition, bankTrans.transactionBillNo,bankTrans.turqBanksTransactionType.id ";
			query += " order by bankTrans, bankTrans.transactionBillDate";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBanksTransactionBill initializeTransaction(Integer transId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			TurqBanksTransactionBill trans = (TurqBanksTransactionBill) session.load(TurqBanksTransactionBill.class, transId);
			Hibernate.initialize(trans.getTurqBanksTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqCurrentTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqAccountingTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqCashTransactions());
			
			return trans;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initializeTransaction(TurqBanksTransactionBill trans) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(trans);
			Hibernate.initialize(trans.getTurqBanksTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqCurrentTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqAccountingTransactions());
			Hibernate.initialize(trans.getTurqEngineSequence().getTurqCashTransactions());
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactions(TurqBanksCard bankCard, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			SimpleDateFormat frmt = new SimpleDateFormat("yyyy-MM-dd");
			String query = "SELECT bankTrans.transaction_bill_date,"
					+ " bankCard.bank_code, bankTrans.transaction_bill_definition,"
					+ " totals.dept, totals.credit, type.transaction_type_name,"
					+ " bankTrans.id ,type.id"
					+ " FROM turq_banks_transaction_bills bankTrans "
					+ " LEFT JOIN (Select row.banks_cards_id as banksId, row.dept_amount as dept, row.credit_amount as credit, row.bank_transactions_bills_id as transId"
					+ " FROM turq_banks_transactions as row ) totals " + " ON  totals.transId = bankTrans.id,"
					+ " turq_banks_cards bankCard ," + " turq_banks_transaction_types type" + " where totals.banksId ="
					+ bankCard.getId().intValue() + " and bankTrans.transaction_bill_date >= '" + frmt.format(startDate) + "' and "
					+ " bankTrans.transaction_bill_date <= '" + frmt.format(endDate) + "' " + " and totals.banksId = bankCard.id"
					+ " and type.id = bankTrans.banks_transaction_types_id" + " order by bankTrans.transaction_bill_date";
			Statement stmt = session.connection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Object[] result;
			List ls = new ArrayList();
			while (rs.next())
			{
				result = new Object[8];
				result[0] = rs.getObject(1);
				result[1] = rs.getObject(2);
				result[2] = rs.getObject(3);
				result[3] = rs.getObject(4);
				result[4] = rs.getObject(5);
				result[5] = rs.getObject(6);
				result[6] = rs.getObject(7);
				result[7]= rs.getObject(8);
				ls.add(result);
			}
			
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//Devreden Toplam
	public static List getDeferredTotal(TurqBanksCard cashCard, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select sum(row.deptAmount),sum(row.creditAmount)"
					+ " from TurqBanksTransaction as row where row.turqBanksTransactionBill.transactionBillDate < :endDate"
					+ " and row.turqBanksCard = :cashCard" + " group by row.turqBanksCard";
			Query q = session.createQuery(query);
			q.setParameter("endDate", endDate);
			q.setParameter("cashCard", cashCard);
			List ls = q.list();
			
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getBankInitialTransactions() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankTrans from TurqBanksTransaction as bankTrans "
					+ " where bankTrans.turqBanksTransactionBill.turqBanksTransactionType.id =" + EngBLCommon.BANK_TRANS_INITIAL;
			Query q = session.createQuery(query);
			List ls = q.list();
			return ls;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static boolean checkInitialTransaction( TurqBanksCard bankCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select bankTrans.id from TurqBanksTransaction as bankTrans "
					+ " where bankTrans.turqBanksCard = :bankCard and bankTrans.turqBanksTransactionBill.turqBanksTransactionType.id="
					+ EngBLCommon.BANK_TRANS_INITIAL;
			Query q = session.createQuery(query);
			q.setParameter("bankCard", bankCard);
			List ls = q.list();
			if (ls.size() == 0)
			{
				return false;
			}
			return true;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}