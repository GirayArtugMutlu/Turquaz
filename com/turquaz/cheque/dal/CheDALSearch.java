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

import java.util.Date;
import java.util.List;

import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewChequeStatus;

public class CheDALSearch {

	public static List searchChequeRoll(String rollNo, Date startDate,
			Date endDate, TurqChequeTransactionType type) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();

			String query = "select chequeRoll.id, " +
					" chequeRoll.chequeRollsDate, chequeRoll.chequeRollNo," +
					" chequeRoll.turqChequeTransactionType.transactionTypsName," +
					" chequeRoll.turqCurrentCard.cardsName, chequeRoll.turqBanksCard.bankCode," +
					" chequeRoll.turqCurrentCard.id,chequeRoll.turqBanksCard.id," +
					" sum(chequesInRolls.turqChequeCheque.chequesAmount)" +
					" from TurqChequeRoll as chequeRoll" +
					" left join chequeRoll.turqChequeChequeInRolls as chequesInRolls "
					+ "where chequeRoll.chequeRollsDate >= :startDate and chequeRoll.chequeRollsDate <=:endDate "
					+ "and chequeRoll.chequeRollNo like '" + rollNo + "%'";

			if (type != null) {

				query += " and chequeRoll.turqChequeTransactionType = :type ";

			}

		

			query += " group by chequeRoll.id,chequeRoll.chequeRollsDate, chequeRoll.chequeRollNo," +
					" chequeRoll.turqChequeTransactionType.transactionTypsName," +
					" chequeRoll.turqCurrentCard.cardsName, chequeRoll.turqBanksCard.bankCode," +
					" chequeRoll.turqCurrentCard.id,chequeRoll.turqBanksCard.id";
			query += " order by chequeRoll.chequeRollsDate ";
			Query q = session.createQuery(query);

			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$

			if (type != null) {

				q.setParameter("type", type);

			}

			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public static List getChequeHistory(TurqChequeCheque cheque) throws Exception {
		try 
		{
			Session session = EngDALSessionFactory.openSession();
			String query="select cheqInRoll.turqChequeRoll from TurqChequeChequeInRoll cheqInRoll" +
					" where cheqInRoll.turqChequeCheque.id="+cheque.getId()+
					" order by cheqInRoll.turqChequeRoll.chequeRollsDate";
			Query q = session.createQuery(query);
			List list = q.list();
			session.close();
			return list;

		} 
		catch (Exception ex) {
			throw ex;
		}
	}
	
	

	public static List getTransactionTypes() throws Exception {
		try {
			Session session = EngDALSessionFactory.openSession();
			Query q = session
					.createQuery("select transType from TurqChequeTransactionType as transType");
			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}
	}

	//Portfoydeki ceklerin listesini getir.
	public static List getChequesInPortfolio() throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			TurqViewChequeStatus chequeStatus = null;

			String query = "Select cheque from TurqChequeCheque as cheque, TurqViewChequeStatus as chequeStatus, TurqCurrentCard currentCard "
					+ "where cheque.id = chequeStatus.chequeChequesId "
					+ " and currentCard.id =  chequeStatus.currentCardsId "
					+ " and (chequeStatus.chequeTransactionTypesId ="+ EngBLCommon.CHEQUE_TRANS_IN
					+" or chequeStatus.chequeTransactionTypesId ="+ EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY+")";

			Query q = session.createQuery(query);

			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}

	}
	
	//	Portfoydeki ceklerin listesini getir.
	public static List getChequesGivenToCurrent() throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			TurqViewChequeStatus chequeStatus = null;

			String query = "Select cheque from TurqChequeCheque as cheque, TurqViewChequeStatus as chequeStatus, TurqCurrentCard currentCard "
					+ "where cheque.id = chequeStatus.chequeChequesId "
					+ " and currentCard.id =  chequeStatus.currentCardsId "
					+ " and chequeStatus.chequeTransactionTypesId ="+ EngBLCommon.CHEQUE_TRANS_OUT_CURRENT
					+ " and cheque.chequesType = "+EngBLCommon.CHEQUE_TYPE_CUSTOMER;
		

			Query q = session.createQuery(query);

			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}

	}

// Bankadaki ceklerin listesini getir.
	public static List getChequesInBank() throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			TurqViewChequeStatus chequeStatus = null;

			String query = "Select cheque, currentCard.cardsName from TurqChequeCheque as cheque, TurqViewChequeStatus as chequeStatus, TurqCurrentCard currentCard "
					+ "where cheque.id = chequeStatus.chequeChequesId "
					+ " and currentCard.id =  chequeStatus.currentCardsId "
					+ " and chequeStatus.chequeTransactionTypesId ="
					+ EngBLCommon.CHEQUE_TRANS_OUT_BANK;

			Query q = session.createQuery(query);

			List list = q.list();
			session.close();
			return list;

		} catch (Exception ex) {
			throw ex;
		}

	}

	
	/**
	 * 
	 * @param portfoyNo
	 * @param curCard
	 * @param status
	 * @param startEnterDate
	 * @param endEnterDate
	 * @param startDueDate
	 * @param endDueDate
	 * @return
	 * @throws Exception
	 */
	public static List searchCheque(String portfoyNo, TurqCurrentCard curCard,
			Integer status, Date startEnterDate, Date endEnterDate,
			Date startDueDate, Date endDueDate) throws Exception {
		try {

			Session session = EngDALSessionFactory.openSession();
			TurqViewChequeStatus chequeStatus = null;

			String query = "Select cheque.id, cheque.chequesPortfolioNo,chequeInRolls.turqChequeRoll.chequeRollsDate,"
					+ " chequeInRolls.turqChequeRoll.turqCurrentCard.cardsName, cheque.chequesDueDate,status.chequeTransactionTypesId,"
					+ " cheque.chequesAmount"
					+ " from TurqChequeCheque as cheque"
					+ " left join cheque.turqChequeChequeInRolls as chequeInRolls ,"
					+ " TurqViewChequeStatus as status "
					+ " where cheque.chequesPortfolioNo like '"
					+ portfoyNo
					+ "%'"
					+ " and cheque.chequesDueDate >= :startDueDate "
					+ " and cheque.chequesDueDate <= :endDueDate "
					+ " and chequeInRolls.turqChequeRoll.chequeRollsDate >= :startEnterDate"
					+ " and chequeInRolls.turqChequeRoll.chequeRollsDate <= :endEnterDate"
					+ " and chequeInRolls.turqChequeRoll.turqChequeTransactionType.id ="
					+ EngBLCommon.CHEQUE_TRANS_IN
					+ " and status.chequeChequesId = cheque.id ";

			if (curCard != null) {
				query += " and chequeInRolls.turqChequeRoll.turqCurrentCard = :curCard";
			}
			if (status != null) {
				query += " and status.transactionTypesParent = "
						+ status.intValue();
			}

			Query q = session.createQuery(query);
			q.setParameter("startDueDate", startDueDate);
			q.setParameter("endDueDate", endDueDate);
			q.setParameter("startEnterDate", startEnterDate);
			q.setParameter("endEnterDate", endEnterDate);

			if (curCard != null) {
				q.setParameter("curCard", curCard);
			}

			List list = q.list();
			session.close();
			return list;
		} catch (Exception ex) {
			throw ex;
		}
	}

	public static List searchOwnCheques(TurqCurrentCard curCard,TurqBanksCard bankCard,
			 Date startEnterDate, Date endEnterDate,
			Date startDueDate, Date endDueDate) throws Exception {
		try {

			/**
			 * TODO Bankaya teminata cek verilmesi dusunulmeden Cheque_trans_out_current kullanildi.
			 */
			Session session = EngDALSessionFactory.openSession();
			TurqViewChequeStatus chequeStatus = null;

			String query = "Select cheque.id, chequeInRolls.turqChequeRoll.chequeRollsDate,"
					+ " chequeInRolls.turqChequeRoll.turqCurrentCard.cardsName, cheque.chequesDueDate,status.chequeTransactionTypesId,"
					+ " cheque.chequesAmount, cheque.turqBanksCard.bankCode, cheque.chequesNo "
					+ " from TurqChequeCheque as cheque"
					+ " left join cheque.turqChequeChequeInRolls as chequeInRolls ,"
					+ " TurqViewChequeStatus as status "
					+ " where"
					+ " cheque.chequesDueDate >= :startDueDate " 
					+ " and cheque.chequesType ="+EngBLCommon.CHEQUE_TYPE_OWN
					+ " and cheque.chequesDueDate <= :endDueDate "
					+ " and chequeInRolls.turqChequeRoll.chequeRollsDate >= :startEnterDate"
					+ " and chequeInRolls.turqChequeRoll.chequeRollsDate <= :endEnterDate"
					+ " and chequeInRolls.turqChequeRoll.turqChequeTransactionType.id ="
					+ EngBLCommon.CHEQUE_TRANS_OUT_CURRENT
					+ " and status.chequeChequesId = cheque.id ";

			if (curCard != null) {
				query += " and chequeInRolls.turqChequeRoll.turqCurrentCard = :curCard";
			}
			if(bankCard !=null ){
				query += " and cheque.turqBanksCard = :bankCard";
			}
			

			Query q = session.createQuery(query);
			q.setParameter("startDueDate", startDueDate);
			q.setParameter("endDueDate", endDueDate);
			q.setParameter("startEnterDate", startEnterDate);
			q.setParameter("endEnterDate", endEnterDate);

			if (curCard != null) {
				q.setParameter("curCard", curCard);
			}
			if(bankCard !=null ){
				q.setParameter("bankCard",bankCard);
			}

			List list = q.list();
			session.close();
			return list;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public static TurqBanksCard getBankOfCustomerCheque(TurqChequeCheque cheque)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			TurqChequeChequeInRoll cv;
			TurqChequeRoll asd;
			
			String query = "Select chequeRoll.turqChequeRoll.turqBanksCard from TurqChequeChequeInRoll as chequeRoll" +
					" where chequeRoll.turqChequeCheque = :cheque and " +
					" chequeRoll.turqChequeRoll.turqChequeTransactionType.id ="+EngBLCommon.CHEQUE_TRANS_OUT_BANK;

			Query q = session.createQuery(query);
			q.setParameter("cheque",cheque);
			List list = q.list();
			session.close();
			if(list.size()>0)
			{
				return (TurqBanksCard)list.get(0);
			}
			 return null;
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static TurqCurrentCard getCurrentCardOfCustomerCheque(TurqChequeCheque cheque)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			TurqChequeChequeInRoll cv;
			TurqChequeRoll asd;
			
			String query = "Select chequeRoll.turqChequeRoll.turqCurrentCard from TurqChequeChequeInRoll as chequeRoll" +
					" where chequeRoll.turqChequeCheque = :cheque and " +
					" chequeRoll.turqChequeRoll.turqChequeTransactionType.id ="+EngBLCommon.CHEQUE_TRANS_IN;

			Query q = session.createQuery(query);
			q.setParameter("cheque",cheque);
			List list = q.list();
			session.close();
			if(list.size()>0)
			{
				return (TurqCurrentCard)list.get(0);
			}
			 return null;
			
		}
		catch(Exception ex){
			throw ex;
		}
	}
	public static TurqAccountingAccount getChequeRollAccountingAccount(TurqChequeCheque cheque, int rollType)throws Exception{
		try{
			Session session = EngDALSessionFactory.openSession();
			
			String query = "Select chequeRoll.turqChequeRollAccountingAccount.turqAccountingAccount from TurqChequeRoll as chequeRoll " +
					" left join chequeRoll.turqChequeChequeInRolls chequeInRoll " +
					" where chequeInRoll.turqChequeCheque = :cheque " +
					" and chequeRoll.turqChequeTransactionType.id ="+rollType;
			
			Query q = session.createQuery(query);
			q.setParameter("cheque",cheque);
			List list = q.list();
			session.close();
			if(list.size()>0)
			{
				return (TurqAccountingAccount)list.get(0);
			}
			 return null;
			
			
			
		}
		catch(Exception ex)
		{
			throw ex;
		}
		
	}
	
	
}