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
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqInventoryGroup;

public class InvDALCardAdd
{
	public static TurqCurrency getCurrency(String abbrev) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqCurrency as currency " + "where currency.currenciesAbbreviation =:abbrev";
			Query q = session.createQuery(query);
			q.setParameter("abbrev", abbrev);
			List list = q.list();
			if (list.size() == 0)
			{
				throw new Exception("No such abbreviation");
			}
			else
			{
				return ((TurqCurrency) list.get(0));
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getParentInventoryGroups() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqInventoryGroup as invGroup " + " where invGroup.turqInventoryGroup.id = -1 and"
					+ " invGroup.id <> -1";
			Query q = session.createQuery(query);
			List list = q.list();
			for (int i = 0; i < list.size(); i++)
			{
				TurqInventoryGroup invGroup = (TurqInventoryGroup) list.get(i);
				Hibernate.initialize(invGroup.getTurqInventoryGroups());
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getAllInventoryUnits() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqInventoryUnit as invUnit ";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getInventoryUnits(Integer invCardId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select cardUnit.turqInventoryUnit from TurqInventoryCardUnit cardUnit"
					+ "	where cardUnit.turqInventoryCard.id ="+ invCardId;
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}