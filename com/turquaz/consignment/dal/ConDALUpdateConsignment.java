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
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;

public class ConDALUpdateConsignment
{
	public ConDALUpdateConsignment()
	{
	}

	public static void initiliazeConsignment(TurqConsignment cons) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
			session.refresh(cons);
			Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
			Hibernate.initialize(cons.getTurqBillConsignmentCommon().getTurqBills());
			Hibernate.initialize(cons.getTurqConsignmentsInGroups());
			session.close();
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}