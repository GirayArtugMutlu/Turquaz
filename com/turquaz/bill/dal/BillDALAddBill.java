package com.turquaz.bill.dal;

import java.util.Set;
import com.turquaz.engine.dal.TurqBill;

public class BillDALAddBill
{
	public BillDALAddBill()
	{
	}

	public static Set getInvTransactions(TurqBill bill) throws Exception
	{
		try
		{
			/*
			 * Session session = EngDALSessionFactory.openSession(); session.refresh(bill); //XXX initialize cons
			 * Hibernate.initialize(bill.getTurqBillInEngineSequences().getTurqConsignments()); Iterator it =
			 * bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator(); if (it.hasNext()) { TurqConsignment cons =
			 * (TurqConsignment) it.next(); Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
			 * session.close(); return cons.getTurqEngineSequence().getTurqInventoryTransactions(); } else session.close();
			 */
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}