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
import java.util.Date;
import java.util.List;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewInvPriceTotal;

public class ConDALSearchConsignment
{
	public static List searchConsignments(TurqCurrentCard curCard, Date startDate, Date endDate, int type, String docNo) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select consignment.id," + " consignment.consignmentsDate, consignment.turqCurrentCard.cardsCurrentCode,"
					+ " consignment.turqCurrentCard.cardsName, consignment.consignmentDocumentNo,"
					+ " view.totalprice, view.vatamount, view.specialvatamount" + " from TurqViewInvPriceTotal view,"
					+ " TurqConsignment as consignment" + " where consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
					" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$					
					" and consignment.id <> -1 " + //$NON-NLS-1$
					" and consignment.turqEngineSequence.id=view.engineSequencesId"
					+ " and consignment.consignmentDocumentNo like '" + docNo + "%'"; //$NON-NLS-1$		
			if (type != EngBLCommon.COMMON_ALL_INT)
				query += " and consignment.consignmentsType =" + type; //$NON-NLS-1$
			if (curCard != null)
			{
				query += " and consignment.turqCurrentCard = :curCard"; //$NON-NLS-1$
			}
			query += " order by consignment.consignmentsDate"; //$NON-NLS-1$
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$
			if (curCard != null)
			{
				q.setParameter("curCard", curCard); //$NON-NLS-1$
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	//?rsaliyeden faturalstirma da kullaniliyo..
	public static List chooseConsignments(TurqCurrentCard curCard, Date startDate, Date endDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select consignment.id," + " consignment.consignmentsDate, consignment.turqCurrentCard.cardsCurrentCode,"
					+ " consignment.turqCurrentCard.cardsName, consignment.consignmentDocumentNo,"
					+ " view.totalprice, view.vatamount, view.specialvatamount,consignment.consignmentsType " + " from TurqViewInvPriceTotal view,"
					+ " TurqConsignment as consignment" + " where consignment.consignmentsDate >= :startDate" + //$NON-NLS-1$
					" and consignment.consignmentsDate <= :endDate" + //$NON-NLS-1$					
					" and consignment.id <> -1 " + //$NON-NLS-1$
					" and consignment.turqEngineSequence.id=view.engineSequencesId"+
					" and consignment.turqEngineSequence.turqBillInEngineSequences.size=0";
			if (curCard != null)
			{
				query += " and consignment.turqCurrentCard = :curCard"; //$NON-NLS-1$
			}
			query += " order by consignment.consignmentsDate"; //$NON-NLS-1$
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate); //$NON-NLS-1$
			q.setParameter("endDate", endDate); //$NON-NLS-1$
			if (curCard != null)
			{
				q.setParameter("curCard", curCard); //$NON-NLS-1$
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqViewInvPriceTotal getViewInvTotal(Integer engSeqId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invPriceView from TurqViewInvPriceTotal as invPriceView" +
					" where invPriceView.engineSequencesId="+engSeqId;
			Query q = session.createQuery(query);
			List list = q.list();
		
			return (TurqViewInvPriceTotal) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getConsignmentInfo(TurqConsignment cons)throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select invTrans.id, cardUnit.cardUnitsFactor, invTrans.turqInventoryCard.cardInventoryCode," +
					" invTrans.turqInventoryCard.cardName, invTrans.turqInventoryUnit.unitsName," +
					((cons.getConsignmentsType() == EngBLCommon.CONSIGNMENT_TRANS_TYPE_BUY)
							? "invTrans.amountIn ," : "invTrans.amountOut ,")+
					" invTrans.unitPriceInForeignCurrency,invTrans.totalPriceInForeignCurrency"+
					" from TurqInventoryTransaction invTrans" +
					" left join invTrans.turqInventoryCard.turqInventoryCardUnits as cardUnit," +
					" TurqConsignment cons " +
					" where cons.turqEngineSequence.id=invTrans.turqEngineSequence.id" +
					" and cons.id="+cons.getId()+
					" and cardUnit.turqInventoryUnit=invTrans.turqInventoryUnit";			
			Query q = session.createQuery(query);
			List list = q.list();
		
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}		
	}
	
	public static TurqConsignment getConsignmentByConsId(Integer consId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select cons from TurqConsignment where cons.id="+consId.intValue();
			Query q = session.createQuery(query);
			List list = q.list();		
			return (TurqConsignment)list.get(0);
			
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}