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
import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqBanksTransactionBill;

public class BankDALBankCardUpdate
{
	public BankDALBankCardUpdate()
	{
	}

	public static Boolean hasTransaction(TurqBanksCard bankCard) throws Exception
	{
		try
		{
			if (bankCard == null)
			{
				return new Boolean(true);
			}
			Session session = EngDALSessionFactory.getSession();
			session.refresh(bankCard);
			String query = " Select count(bankTrans.id) from TurqBanksTransaction as bankTrans where "
					+ " bankTrans.turqBanksCard = :bankCard and bankTrans.turqBanksTransactionBill.turqBanksTransactionType.id <> "
					+ EngBLCommon.BANK_TRANS_INITIAL;
			Query q = session.createQuery(query);
			q.setParameter("bankCard", bankCard);
			List ls = q.list();
		
			if (ls.size() == 0)
			{
				return new Boolean(true);
			}
			Integer count = (Integer) ls.get(0);
			if (count.intValue() == 0)
			{
				return new Boolean(false);
			}
			return new Boolean(true);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteInitialTransaction(TurqBanksCard bankCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bankTransBill from TurqBanksTransactionBill as bankTransBill "
					+ " left join bankTransBill.turqBanksTransactions as bankTrans"
					+ " where bankTransBill.turqBanksTransactionType.id = " + EngBLCommon.BANK_TRANS_INITIAL
					+ " and bankTrans.turqBanksCard = :bankCard ";
			Query q = session.createQuery(query);
			q.setParameter("bankCard", bankCard);
			List list = q.list();
			for (int i = 0; i < list.size(); i++)
			{
				TurqBanksTransactionBill transBill = (TurqBanksTransactionBill) list.get(i);
				BankDALCommon.initializeTransaction(transBill);
				BankBLTransactionUpdate.deleteTransaction(transBill);
			}
			session.flush();
		
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}