
package com.turquaz.bill.dal;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class BillDALSearchBill {
	public BillDALSearchBill(){
		
		
	}
	public List searchBill(TurqCurrentCard curCard,String docNo, Date startDate, Date endDate, int type)
	throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "Select bill.id, bill.billsDate, billcons.billDocumentNo," +
				" curCard.cardsCurrentCode, curCard.cardsName," +
				" billcons.totalAmount, billcons.vatAmount, billcons.specialVatAmount" +
				" from TurqBill as bill, bill.turqBillConsignmentCommon as billcons," +
				" bill.turqBillConsignmentCommon.turqCurrentCard as curCard" +
				" where" +
				" bill.billsDate >= :startDate" +
				" and bill.billsDate <= :endDate" +				
				" and bill.id <> -1 ";
		
			if (type != EngBLCommon.COMMON_ALL_INT)
			{
				query += " and bill.billsType ="+type;
			}
				
			if (!docNo.equals(""))
			{
				query +=" and bill.turqBillConsignmentCommon.billDocumentNo like '"+docNo+"%'";
			}
		
			if (curCard!=null)
			{
				query +=" and bill.turqBillConsignmentCommon.turqCurrentCard = :curCard"; 
			}
			query += " order by bill.billsDate, bill.turqBillConsignmentCommon.billDocumentNo";
		
			Query q = session.createQuery(query); 	
		
			q.setParameter("startDate",startDate);
			q.setParameter("endDate",endDate);
		
			if (curCard!=null)
			{
				q.setParameter("curCard",curCard);
			}
		
		
		
			List list = q.list();
			session.close();
			return list;
		
		
		
		}
		catch(Exception ex)
		{
		throw ex;
		}
	}
	
	
	public static TurqBill getBillByBillId(Integer billId) throws Exception
	{
		try {
			Session session = EngDALSessionFactory.openSession();

			String query = "Select bill from TurqBill as bill" +
					" where bill.id="+billId; //$NON-NLS-1$


			Query q = session.createQuery(query);

			List list = q.list();

			session.close();
			return (TurqBill)list.get(0);

		} 
		catch (Exception ex) 
		{
			throw ex;
		}
	}
	
	
	
	public List searchBillAdvanced(TurqCurrentCard curCardStart,
			TurqCurrentCard curCardEnd, Date startDate, Date endDate,
			Date dueDateStart, Date dueDateEnd, BigDecimal minValue,
			BigDecimal maxValue,String docNoStart, String docNoEnd,
			int type)
	throws Exception 
	{
		try
		{
			Session session = EngDALSessionFactory.openSession();
		
			String query = "Select bill.id, bill.billsDate, billcons.billDocumentNo," +
				" curCard.cardsCurrentCode, curCard.cardsName," +
				" billcons.totalAmount, billcons.vatAmount, billcons.specialVatAmount" +
				" from TurqBill as bill, bill.turqBillConsignmentCommon as billcons," +
				" bill.turqBillConsignmentCommon.turqCurrentCard as curCard" +
				" where" +
				" bill.billsDate >= :startDate" +
				" and bill.billsDate <= :endDate" +
				" and bill.id <> -1 "+
				" and bill.dueDate >= :dueDateStart"+
				" and bill.dueDate <= :dueDateEnd";
		
			if (curCardStart != null && curCardEnd != null)
			{
				query +=" and bill.turqBillConsignmentCommon.turqCurrentCard.cardsCurrentCode >= '"+curCardStart.getCardsCurrentCode()+"'";
				query +=" and bill.turqBillConsignmentCommon.turqCurrentCard.cardsCurrentCode <= '"+curCardEnd.getCardsCurrentCode()+"'";
			}
			else if (curCardStart != null)
			{
				query +=" and bill.turqBillConsignmentCommon.turqCurrentCard = :curCardStart";
			}
			else if (curCardEnd != null)
			{
				query +=" and bill.turqBillConsignmentCommon.turqCurrentCard = :curCardEnd";
			}
		
			if (minValue.doubleValue() > 0)
			{
				query +=" and bill.turqBillConsignmentCommon.totalAmount >="+minValue;
			}
		
			if (maxValue.doubleValue() > 0)
			{
				query +=" and bill.turqBillConsignmentCommon.totalAmount <="+maxValue;
			}
		
			if (!docNoStart.equals("") && !docNoEnd.equals(""))
			{
				query+=" and bill.turqBillConsignmentCommon.billDocumentNo >= '"+docNoStart+"'";
				query+=" and bill.turqBillConsignmentCommon.billDocumentNo <= '"+docNoEnd+"'";
			}
			else if (!docNoStart.equals(""))
			{
				query+=" and bill.turqBillConsignmentCommon.billDocumentNo like '"+docNoStart+"%'";
			}
			else if (!docNoEnd.equals(""))
			{
				query+=" and bill.turqBillConsignmentCommon.billDocumentNo like '"+docNoEnd+"%'";
			}
		
			if (type != EngBLCommon.COMMON_ALL_INT)
			{
				query +=" and bill.billsType ="+type;
			}
		
			query += " order by bill.billsDate";
		
			Query q = session.createQuery(query); 	
		
			q.setParameter("startDate",startDate);
			q.setParameter("endDate",endDate);
			q.setParameter("dueDateEnd",dueDateEnd);
			q.setParameter("dueDateStart",dueDateStart);
		
			if (curCardStart != null && curCardEnd != null)
			{			
			}
			else if (curCardStart!=null)
			{
				q.setParameter("curCardStart",curCardStart);
			}
			else if (curCardEnd != null)
			{
				q.setParameter("curCardEnd",curCardEnd);
			}
		
		
		
			List list = q.list();
			session.close();
			return list;	
		
		}
		catch(Exception ex)
		{
			throw ex;
		}
	}
	
	public void initializeBill(TurqBill bill)throws Exception{
	    try{
	    	Session session = EngDALSessionFactory.openSession();
			
			session.refresh(bill);
			
			Hibernate.initialize(bill.getTurqBillInGroups());
			Hibernate.initialize(bill.getTurqBillConsignmentCommon().getTurqConsignments());
			
			Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
			if(it.hasNext()){
				TurqConsignment cons = (TurqConsignment)it.next();
				Hibernate.initialize(cons.getTurqEngineSequence().getTurqInventoryTransactions());
				
			}			
			
			
			session.close();
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        throw ex;
	    }
	}

}
