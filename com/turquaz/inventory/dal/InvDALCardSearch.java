package com.turquaz.inventory.dal;

/** ********************************************************************* */
/* TURQUAZ: Higly Modular Accounting/ERP Program */
/* ============================================ */
/* Copyright (c) 2004 by Turquaz Software Development Group */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or */
/* (at your option) any later version. */
/* 																		*/
/* This program is distributed in the hope that it will be useful, */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the */
/* GNU General Public License for more details. */
/** ********************************************************************* */
/**
 * @author Onsel Armagan
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
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.dal.TurqInventoryGroup;

public class InvDALCardSearch
{
	public static List searchInventoryCards(String cardName, String cardCode, Integer groupId)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select  invCard, invView from TurqViewInventoryTotal as invView,"
					+ " TurqInventoryCard as invCard"
					+ " where invCard.id = invView.inventoryCardsId";
			if (!cardName.equals(""))
			{
				query += " and invCard.cardName like '"	+ cardName+ "%'";
			}
			if (!cardCode.equals(""))
			{
				query += " and invCard.cardInventoryCode like '"+ cardCode+ "%'";
			}
			if (groupId != null)
			{
				query += " and :groupId in (Select myGroup.turqInventoryGroup.id From invCard.turqInventoryCardGroups as myGroup)";
			}
			query += " order by invCard.cardInventoryCode";
			Query q = session.createQuery(query);
			if (groupId != null)
			{
				q.setParameter("groupId", groupId);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqAccountingAccount getInventoryAccount(Integer invCardId, int invAccTypeId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invAcc.turqAccountingAccount from TurqInventoryAccountingAccount as invAcc"
					+ " where invAcc.turqInventoryCard.id=" + invCardId.intValue()
					+ " and invAcc.turqInventoryAccountingType=" + invAccTypeId;
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size() == 0)
				return null;
			else
				return (TurqAccountingAccount) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInvAccountingAccs(Integer invCardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invAcc from TurqInventoryAccountingAccount as invAcc"
					+ " where invAcc.turqInventoryCard.id=" + invCardId.intValue();
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getInvCardPrices(Integer invCardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invPrice from TurqInventoryPrice as invPrice"
					+ " where invPrice.turqInventoryCard.id=" + invCardId.intValue();
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}
	
	public static List getInvCardGroups(Integer invCardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invCardGroup from TurqInventoryCardGroup as invCardGroup"
					+ " where invCardGroup.turqInventoryCard.id=" + invCardId.intValue();
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}

	public static List searchInventoryCardsAdvanced(String cardCodeStart, String cardCodeEnd, String cardNameStart,
			String cardNameEnd, TurqInventoryGroup invGroup) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invView, invCard.cardInventoryCode, invCard.cardName, invCard.id from TurqViewInventoryTotal as invView,"
					+ " TurqInventoryCard as invCard" + " where invCard.id = invView.inventoryCardsId";
			if (!cardNameStart.equals("") && !cardNameEnd.equals(""))
			{
				query += " and invCard.cardName >= '" + cardNameStart + "'";
				query += " and invCard.cardName <= '" + cardNameEnd + "'";
			}
			else if (!cardNameStart.equals(""))
			{
				query += " and invCard.cardName like '" + cardNameStart + "%'";
			}
			else if (!cardNameEnd.equals(""))
			{
				query += " and invCard.cardName like '" + cardNameEnd + "%'";
			}
			if (!cardCodeStart.equals("") && !cardCodeEnd.equals(""))
			{
				query += " and invCard.cardInventoryCode >= '" + cardCodeStart + "'";
				query += " and invCard.cardInventoryCode <= '" + cardCodeEnd + "'";
			}
			else if (!cardCodeStart.equals(""))
			{
				query += " and invCard.cardInventoryCode like '" + cardCodeStart + "%'";
			}
			else if (!cardCodeEnd.equals(""))
			{
				query += " and invCard.cardInventoryCode like '" + cardCodeEnd + "%'";
			}
			if (invGroup != null)
			{
				query += " and :invGroup in (Select myGroup.turqInventoryGroup From invCard.turqInventoryCardGroups as myGroup)";
			}
			query += " order by invCard.cardInventoryCode";
			Query q = session.createQuery(query);
			if (invGroup != null)
			{
				q.setParameter("invGroup", invGroup);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getTransactionTotalReport(String cardCodeStart, String cardCodeEnd, String cardNameStart,
			String cardNameEnd, Date startDate, Date endDate, String curCardStart, String curCardEnd,
			Integer invMainGroupId, Integer invSubGroupId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String query = "SELECT invCard.id, invCard.card_inventory_code, invCard.card_name, transin.transintotalamountin, "
					+ "transin.transintotalpricein, transout.transouttotalamountout, transout.transouttotalpriceout,"
					+ " transoverin.overintotalamountin, transoverin.overintotalpricein,"
					+ " transoverout.overouttotalamountout, transoverout.overouttotalpriceout";
			if (invMainGroupId != null)
			{
				query += ", gr2.id, gr2.groups_name ";
			}
			query += " FROM ";
			if (invMainGroupId != null)
			{
				query += " turq_inventory_groups gr2, turq_inventory_card_groups cardgr2,"
						+ " turq_inventory_cards invCard";
			}
			else
			{
				query += " turq_inventory_cards invCard";
			}
			query += " LEFT JOIN ( SELECT invTrans.inventory_cards_id,"
					+ " sum(invTrans.total_price) AS transintotalpricein, "
					+ " sum(invTrans.amount_in) AS transintotalamountin FROM turq_inventory_transactions invTrans,"
					+ " turq_inventory_cards invc, turq_current_cards curCard"
					+ " WHERE invTrans.amount_in <> 0 "
					+ " AND invTrans.transaction_type = 1"
					+ " and invTrans.inventory_cards_id=invc.id"
					+ " and invTrans.current_cards_id=curCard.id"
					+ " and invTrans.transactions_date >= '" + df.format(startDate) + "'"
					+ " and invTrans.transactions_date <= '" + df.format(endDate) + "'";
			if (!curCardStart.equals("") && !curCardEnd.equals(""))
			{
				query += " AND curCard.cards_current_code >= '" + curCardStart + "'";
				query += " AND curCard.cards_current_code <= '" + curCardEnd + "'";
			}
			else if (!curCardStart.equals(""))
			{
				query += " AND curCard.cards_current_code like '" + curCardStart + "%'";
			}
			query += " GROUP BY invTrans.inventory_cards_id) transin ON"
					+ " invCard.id = transin.inventory_cards_id"
					+ " LEFT JOIN ( SELECT invTrans.inventory_cards_id,"
					+ " sum(invTrans.total_price) AS transouttotalpriceout,"
					+ " sum(invTrans.amount_out) AS transouttotalamountout FROM turq_inventory_transactions invTrans,"
					+ " turq_inventory_cards invc, turq_current_cards curCard";
			query += " WHERE invTrans.transaction_type = 1 "
					+ " AND invTrans.amount_out <> 0"
					+ " and invTrans.inventory_cards_id=invc.id"
					+ " and invTrans.current_cards_id=curCard.id"
					+ " and invTrans.transactions_date >= '" + df.format(startDate) + "'"
					+ " and invTrans.transactions_date <= '" + df.format(endDate) + "'";
			if (!curCardStart.equals("") && !curCardEnd.equals(""))
			{
				query += " AND curCard.cards_current_code >= '" + curCardStart + "'";
				query += " AND curCard.cards_current_code <= '" + curCardEnd + "'";
			}
			else if (!curCardStart.equals(""))
			{
				query += " AND curCard.cards_current_code like '" + curCardStart + "%'";
			}
			query += " GROUP BY invTrans.inventory_cards_id) transout ON"
					+ " invCard.id = transout.inventory_cards_id"
					+ " LEFT JOIN ( SELECT invTrans.inventory_cards_id, "
					+ " sum(invTrans.total_price) AS overintotalpricein, "
					+ " sum(invTrans.amount_in) AS overintotalamountin FROM turq_inventory_transactions invTrans,"
					+ " turq_inventory_cards invc, turq_current_cards curCard";
			query += " WHERE invTrans.amount_in <> 0 "
					+ " AND invTrans.transaction_type = 0"
					+ " and invTrans.inventory_cards_id=invc.id"
					+ " and invTrans.current_cards_id=curCard.id";
			//" and turq_inventory_transactions.transactions_date >= '"+df.format(startDate)+"'"+
			//" and turq_inventory_transactions.transactions_date <= '"+df.format(endDate)+"'"
			if (!curCardStart.equals("") && !curCardEnd.equals(""))
			{
				query += " AND curCard.cards_current_code >= '" + curCardStart + "'";
				query += " AND curCard.cards_current_code <= '" + curCardEnd + "'";
			}
			else if (!curCardStart.equals(""))
			{
				query += " AND curCard.cards_current_code like '" + curCardStart + "%'";
			}
			query += " GROUP BY invTrans.inventory_cards_id) transoverin ON "
					+ " invCard.id = transoverin.inventory_cards_id"
					+ " LEFT JOIN ( SELECT invTrans.inventory_cards_id, "
					+ " sum(invTrans.total_price) AS overouttotalpriceout, "
					+ " sum(invTrans.amount_out) AS overouttotalamountout FROM turq_inventory_transactions invTrans,"
					+ " turq_inventory_cards invc, turq_current_cards curCard";
			query += " WHERE invTrans.transaction_type = 0 "
					+ " AND invTrans.amount_out <> 0"
					+ " and invTrans.inventory_cards_id=invc.id"
					+ " and invTrans.current_cards_id=curCard.id";
			//" and turq_inventory_transactions.transactions_date >= '"+df.format(startDate)+"'"+
			//" and turq_inventory_transactions.transactions_date <= '"+df.format(endDate)+"'";
			if (!curCardStart.equals("") && !curCardEnd.equals(""))
			{
				query += " AND curCard.cards_current_code >= '" + curCardStart + "'";
				query += " AND curCard.cards_current_code <= '" + curCardEnd + "'";
			}
			else if (!curCardStart.equals(""))
			{
				query += " AND curCard.cards_current_code like '" + curCardStart + "%'";
			}
			query += " GROUP BY invTrans.inventory_cards_id) transoverout ON"
					+ " invCard.id = transoverout.inventory_cards_id";
			boolean whereAdded = false;
			if (!cardCodeStart.equals("") && !cardCodeEnd.equals(""))
			{
				query += " where invCard.card_inventory_code >= '" + cardCodeStart + "'";
				query += " AND invCard.card_inventory_code <= '" + cardCodeEnd + "'";
				whereAdded = true;
			}
			else if (!cardCodeStart.equals(""))
			{
				if (whereAdded)
				{
					query += " AND invCard.card_inventory_code like '" + cardCodeStart + "%'";
				}
				else
				{
					query += " where invCard.card_inventory_code like '" + cardCodeStart + "%'";
					whereAdded = true;
				}
			}
			if (!cardNameStart.equals("") && !cardNameEnd.equals(""))
			{
				if (whereAdded)
				{
					query += " AND invCard.card_name >= '" + cardNameStart + "'";
					query += " AND invCard.card_name <= '" + cardNameEnd + "'";
				}
				else
				{
					query += " where invCard.card_name >= '" + cardNameStart + "'";
					query += " AND invCard.card_name <= '" + cardNameEnd + "'";
					whereAdded = true;
				}
			}
			else if (!cardNameStart.equals(""))
			{
				if (whereAdded)
				{
					query += " AND invCard.card_name like '" + cardNameStart + "%'";
				}
				else
				{
					query += " where invCard.card_name like '" + cardNameStart + "%'";
				}
			}
			if (invMainGroupId != null)
			{
				if (whereAdded)
				{
					query += " and gr2.id=cardgr2.inventory_groups_id and invCard.id=cardgr2.inventory_cards_id";
				}
				else
				{
					query += " where gr2.id=cardgr2.inventory_groups_id and invCard.id=cardgr2.inventory_cards_id";
					whereAdded = true;
				}
				if (invSubGroupId != null)
				{
					query += " and gr2.id=" + invSubGroupId.intValue();
				}
				else
				{
					query += " and gr2.parent_group=" + invMainGroupId.intValue();
				}
			}
			if (invMainGroupId != null)
			{
				query += " order by gr2.id";
			}
			else
			{
				query += " order by invCard.id";
			}
			Statement stmt = session.connection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List list = new ArrayList();
			boolean addGroup = invMainGroupId != null;
			while (rs.next())
			{
				Object[] result;
				if (addGroup)
					result = new Object[13];
				else
					result = new Object[11];
				result[0] = rs.getObject(1);
				result[1] = rs.getObject(2);
				result[2] = rs.getObject(3);
				result[3] = rs.getObject(4);
				result[4] = rs.getObject(5);
				result[5] = rs.getObject(6);
				result[6] = rs.getObject(7);
				result[7] = rs.getObject(8);
				result[8] = rs.getObject(9);
				result[9] = rs.getObject(10);
				result[10] = rs.getObject(11);
				if (addGroup)
				{
					result[11] = rs.getObject(12);
					result[12] = rs.getObject(13);
				}
				list.add(result);
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryCards() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invCard.cardInventoryCode,invCard.cardName from TurqInventoryCard as invCard"
					+ " order by invCard.cardInventoryCode";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllInvAccTypes() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invAccType from TurqInventoryAccountingType as invAccType";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard getInventoryCard(String cardCode) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invCard from TurqInventoryCard as invCard "
					+ " where invCard.cardInventoryCode = :cardCode";
			Query q = session.createQuery(query);
			q.setParameter("cardCode", cardCode);
			List list = q.list();
			if (list.size() > 0)
			{
				return (TurqInventoryCard) list.get(0);
			}
			else
			{
				return null;
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard getInventoryCardFromName(String cardName) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invCard from TurqInventoryCard as invCard " + " where invCard.cardName = :cardName";
			Query q = session.createQuery(query);
			q.setParameter("cardName", cardName);
			List list = q.list();
			if (list.size() > 0)
			{
				return (TurqInventoryCard) list.get(0);
			}
			else
			{
				return null;
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard initializeInventoryCard(Integer cardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			TurqInventoryCard invCard = (TurqInventoryCard) session.load(TurqInventoryCard.class, cardId);
			Hibernate.initialize(invCard.getTurqInventoryCardGroups());
			Hibernate.initialize(invCard.getTurqInventoryPrices());
			Hibernate.initialize(invCard.getTurqInventoryCardUnits());
			Hibernate.initialize(invCard.getTurqInventoryAccountingAccounts());
			return invCard;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqInventoryCard initializeInventoryCard(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(invCard);
			Hibernate.initialize(invCard.getTurqInventoryCardGroups());
			Hibernate.initialize(invCard.getTurqInventoryPrices());
			Hibernate.initialize(invCard.getTurqInventoryCardUnits());
			Hibernate.initialize(invCard.getTurqInventoryAccountingAccounts());
			return invCard;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqViewInventoryAmountTotal getView(Integer cardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invView from TurqViewInventoryAmountTotal as invView"
					+ " where  invView.inventoryCardsId =" + cardId;
			Query q = session.createQuery(query);
			List list = q.list();
			return (TurqViewInventoryAmountTotal) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryCardsAndAccounts() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invCard.id, invCard.accounting_accounts_id_buy,"
					+ " invCard.accounting_accounts_id_sell,invCard.accounting_accounts_id_vat,"
					+ "invCard.accounting_accounts_id_vat_sell, invCard.accounting_accounts_id_special_vat,"
					+ "invCard.accounting_accounts_id_special_vat_sell from turq_inventory_cards invCard "
					+ " where invCard.id <> -1";
			Statement stmt = session.connection().createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List list = new ArrayList();
			while (rs.next())
			{
				Object[] result = new Object[7];
				result[0] = rs.getString(1);
				result[1] = rs.getString(2);
				result[2] = rs.getString(3);
				result[3] = rs.getString(4);
				result[4] = rs.getString(5);
				result[5] = rs.getString(6);
				result[6] = rs.getString(7);
				list.add(result);
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}