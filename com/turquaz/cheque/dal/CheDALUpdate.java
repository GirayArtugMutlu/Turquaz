package com.turquaz.cheque.dal;

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
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeRoll;

public class CheDALUpdate
{
	public static TurqChequeCheque initCheque(Integer chequeId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			TurqChequeCheque cheque = (TurqChequeCheque) session.load(TurqChequeCheque.class, chequeId);
		
			return cheque;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initializeChequeRoll(TurqChequeRoll chequeRoll) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(chequeRoll);
			Hibernate.initialize(chequeRoll.getTurqChequeChequeInRolls());
			Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqCurrentTransactions());
			Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqBanksTransactionBills());
			Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqCashTransactions());
			Hibernate.initialize(chequeRoll.getTurqEngineSequence().getTurqAccountingTransactions());
			chequeRoll.getTurqChequeRollAccountingAccount();
		
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqChequeRoll initializeChequeRoll(Integer chequeRollId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			TurqChequeRoll cheqRoll = (TurqChequeRoll) session.load(TurqChequeRoll.class, chequeRollId);
		
			return cheqRoll;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initChequeRolls(TurqChequeCheque cheque) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(cheque);
			Hibernate.initialize(cheque.getTurqChequeChequeInRolls());
		
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}