package com.turquaz.consignment.dal;

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
/** ********************************************************************* */
import java.util.Iterator;
import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;

public class ConDALUpdateConsignment
{
	public static TurqConsignment initiliazeConsignmentById(Integer consId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			
			String query = "Select consignment from TurqConsignment as consignment" + " where consignment.id=" + consId; //$NON-NLS-1$
			Query q = session.createQuery(query);
			List list = q.list();
			TurqConsignment cons=null;
			if (list.size()!=0)
			{
				cons=(TurqConsignment)list.get(0);
				Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
				Iterator it = cons.getTurqEngineSequence().getTurqBillInEngineSequences().iterator();
				Hibernate.initialize(cons.getTurqConsignmentsInGroups());
			}
			return cons;			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void initiliazeConsignment(TurqConsignment cons) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();	
			session.refresh(cons);
			Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
			Iterator it = cons.getTurqEngineSequence().getTurqBillInEngineSequences().iterator();
			Hibernate.initialize(cons.getTurqConsignmentsInGroups());
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}