package com.turquaz.bank.bl;

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
 * @author Onsel Armagan
 * @version $Id$
 */
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBankAccountingAccount;
import com.turquaz.engine.dal.TurqBankAccountingType;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class BankBLBankCardAdd
{
	public BankBLBankCardAdd()
	{
	}

	public static void saveBankCard(String bankName, String bankBranchName, String bankAccountNo, TurqCurrency currency,
			String definition, String bankCode, Map accountingAccounts) throws Exception
	{
		Session session = EngDALSessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try
		{
			TurqBanksCard bankCard = registerBankCard(session, bankName, bankBranchName, bankAccountNo, currency, definition, bankCode);
			saveBankAccountingAccounts(session, bankCard, accountingAccounts);
			session.flush();
			tx.commit();
			session.close();
		}
		catch (Exception ex)
		{
			if (tx != null)
				tx.rollback();
			if (session != null)
				session.close();
			throw ex;
		}
	}

	public static TurqBanksCard registerBankCard(Session session, String bankName, String bankBranchName, String bankAccountNo,
			TurqCurrency currency, String definition, String bankCode) throws Exception
	{
		TurqBanksCard bankCard = new TurqBanksCard();
		bankCard.setBankName(bankName);
		bankCard.setBankBranchName(bankBranchName);
		bankCard.setBankAccountNo(bankAccountNo);
		bankCard.setTurqCurrency(currency);
		bankCard.setBankDefinition(definition);
		bankCard.setBankCode(bankCode);
		bankCard.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
		bankCard.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
		Calendar cal = Calendar.getInstance();
		bankCard.setLastModified(cal.getTime());
		bankCard.setCreationDate(cal.getTime());
		EngDALCommon.saveObject(session, bankCard);
		return bankCard;
	}

	public static void saveBankAccountingAccounts(Session session, TurqBanksCard bankCard, Map accounts) throws Exception
	{
		Iterator it = accounts.keySet().iterator();
		while (it.hasNext())
		{
			Integer type = (Integer) it.next();
			if (accounts.get(type) != null)
			{
				TurqBankAccountingAccount bankAccount = new TurqBankAccountingAccount();
				bankAccount.setCreatedBy(System.getProperty("user")); //$NON-NLS-1$
				bankAccount.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				Calendar cal = Calendar.getInstance();
				bankAccount.setLastModified(cal.getTime());
				bankAccount.setCreationDate(cal.getTime());
				bankAccount.setTurqBanksCard(bankCard);
				bankAccount.setTurqAccountingAccount((TurqAccountingAccount) accounts.get(type));
				TurqBankAccountingType accType = new TurqBankAccountingType();
				accType.setId(type);
				bankAccount.setTurqBankAccountingType(accType);
				EngDALCommon.saveObject(session, bankAccount);
			}
		}
	}
}