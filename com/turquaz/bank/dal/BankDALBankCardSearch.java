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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBankAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;

public class BankDALBankCardSearch
{
	public BankDALBankCardSearch()
	{
	}

	public static List searchBankCards(String bankName, String bankBranchName, String bankAccountNo, Integer currency)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankCard.id," + " bankCard.bankName, bankCard.bankBranchName,"
					+ " bankCard.bankAccountNo,turqCur.currenciesAbbreviation,"
					+ " bankCard.bankDefinition , bankCard.bankCode from TurqBanksCard as bankCard," + " bankCard.turqCurrency as turqCur where" + //$NON-NLS-1$
					" bankCard.bankName like '" + bankName + "%' and bankCard.bankBranchName like '" + bankBranchName + "%' " + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
					" and bankCard.bankAccountNo like '" + bankAccountNo + "%'" + " and bankCard.id <> -1"; //$NON-NLS-1$ //$NON-NLS-2$
			if (currency != null)
			{
				query += " and bankCard.turqCurrency.id = :currency"; //$NON-NLS-1$
			}
			Query q = session.createQuery(query);
			if (currency != null)
			{
				q.setParameter("currency", currency); //$NON-NLS-1$
			}
			List list = q.list();
			
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static List searchBankCardsWithCode(String bankName, String bankCode)
	throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankCard.id, bankCard.bankCode, bankCard.bankName, bankCard.bankBranchName,"
			+ " bankCard.bankAccountNo,turqCur.currenciesAbbreviation,"
			+ " bankCard.bankDefinition  from TurqBanksCard as bankCard , bankCard.turqCurrency as turqCur where" + //$NON-NLS-1$
			" bankCard.bankName like '" + bankName + "%' and bankCard.bankCode like '" + bankCode + "%' " + //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			" and bankCard.id <> -1"; //$NON-NLS-1$ //$NON-NLS-2$
	
			Query q = session.createQuery(query);
			List list = q.list();
	
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
}

	public static TurqBanksCard initializeBankCardById(Integer bankId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankCard from TurqBanksCard as bankCard" + " where bankCard.id=" + bankId; //$NON-NLS-1$
			Query q = session.createQuery(query);
			List list = q.list();
			TurqBanksCard bankCard=null;
			if (list.size()!=0)
			{
				bankCard=(TurqBanksCard)list.get(0);
				Hibernate.initialize(bankCard.getTurqBankAccountingAccounts());
			}
			return bankCard;
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getBankCards() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankCard from TurqBanksCard as bankCard" + " where bankCard.id <> -1";
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getBankCardsAndAccounts() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankCard.id, bankCard.accounting_accounts_id from turq_banks_cards bankCard "
					+ " where bankCard.id <> -1";
			Statement stmt = session.connection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List list = new ArrayList();
			while (rs.next())
			{
				Object[] result = new Object[2];
				result[0] = rs.getString(1);
				result[1] = rs.getString(2);
				list.add(result);
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getBankAccountingAccount(TurqBanksCard bankCard, Integer type) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.clear();
			session.refresh(bankCard);
		
			Iterator it = bankCard.getTurqBankAccountingAccounts().iterator();
			while (it.hasNext())
			{
				TurqBankAccountingAccount curAccount = (TurqBankAccountingAccount) it.next();
				if (curAccount.getTurqBankAccountingType().getId().intValue() == type.intValue())
				{
					return curAccount.getTurqAccountingAccount();
				}
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}