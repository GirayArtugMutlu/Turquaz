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
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;

public class InvDALWarehouseUpdate
{
	public static boolean hasTransaction(Integer warehouseId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select transactions.id from TurqInventoryTransaction as transactions "
					+ "where transactions.turqInventoryWarehous.id ="+warehouseId;
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size() > 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}