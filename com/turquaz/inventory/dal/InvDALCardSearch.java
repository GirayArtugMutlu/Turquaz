package com.turquaz.inventory.dal;

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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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
	public static List searchInventoryCards(String cardName, String cardCode, TurqInventoryGroup invGroup) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invView, invCard.cardInventoryCode, invCard.cardName, invCard.id from TurqViewInventoryTotal as invView,"
					+ " TurqInventoryCard as invCard"
					+ " where invCard.id = invView.inventoryCardsId and "
					+ " invCard.cardName like '" + cardName + "%' and invCard.cardInventoryCode like '" + cardCode + "%' ";
			if (invGroup != null)
			{
				query += "and :invGroup in (Select myGroup.turqInventoryGroup From invCard.turqInventoryCardGroups as myGroup)";
			}
			query += " order by invCard.cardInventoryCode";
			Query q = session.createQuery(query);
			if (invGroup != null)
			{
				q.setParameter("invGroup", invGroup);
			}
			q.setMaxResults(1000);
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
					+ " where invAcc.turqInventoryCard.id=" + invCardId.intValue() + " and invAcc.turqInventoryAccountingType="
					+ invAccTypeId;
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
			String query = "Select invAcc from TurqInventoryAccountingAccount as invAcc" + " where invAcc.turqInventoryCard.id="
					+ invCardId.intValue();
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchInventoryCardsAdvanced(String cardCodeStart, String cardCodeEnd, String cardNameStart, String cardNameEnd,
			TurqInventoryGroup invGroup) throws Exception
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
			q.setMaxResults(1000);
			List list = q.list();
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
			String query = "Select invCard from TurqInventoryCard as invCard " + " where invCard.cardInventoryCode = :cardCode";
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

	public static TurqViewInventoryAmountTotal getView(TurqInventoryCard invCard) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invView from TurqViewInventoryAmountTotal as invView" + " where  invView.inventoryCardsId ="
					+ invCard.getId();
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
					+ "invCard.accounting_accounts_id_special_vat_sell from turq_inventory_cards invCard " + " where invCard.id <> -1";
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