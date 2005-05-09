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
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewBillTransTotal;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillDALSearchBill
{
	public static List searchBill(TurqCurrentCard curCard, String docNo, Date startDate, Date endDate, int type) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bill.id, bill.billsDate, bill.billDocumentNo,"
					+ " bill.turqCurrentCard.cardsCurrentCode, bill.turqCurrentCard.cardsName,"
					+ " billview.totalprice, billview.vatamount, billview.specialvatamount, bill.turqCurrencyExchangeRate.turqCurrencyByExchangeCurrencyId.currenciesAbbreviation,"
					+ " billview.discountamount from TurqBill as bill,TurqViewBillTransTotal as billview" + " where"
					+ " billview.billsId = bill.id and bill.billsDate >= :startDate" + " and bill.billsDate <= :endDate"
					+ " and bill.id <> -1 ";
			;
			if (type != EngBLCommon.COMMON_ALL_INT)
			{
				query += " and bill.billsType =" + type;
			}
			if (!docNo.equals(""))
			{
				query += " and bill.billDocumentNo like '" + docNo + "%'";
			}
			if (curCard != null)
			{
				query += " and bill.turqCurrentCard = :curCard";
			}
			query += " order by bill.billsDate, bill.billDocumentNo";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			if (curCard != null)
			{
				q.setParameter("curCard", curCard);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqBill initializeBillById(Integer billId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bill from TurqBill as bill" + " where bill.id=" + billId; //$NON-NLS-1$
			Query q = session.createQuery(query);
			List list = q.list();
			TurqBill bill=null;
			if (list.size()!=0)
			{
				bill=(TurqBill)list.get(0);
				Hibernate.initialize(bill.getTurqBillInGroups());
				Hibernate.initialize(bill.getTurqBillInEngineSequences());
				Iterator it = bill.getTurqBillInEngineSequences().iterator();
				while (it.hasNext())
				{
					TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
					Hibernate.initialize(billInEng.getTurqEngineSequence().getTurqConsignments());
					Hibernate.initialize(billInEng.getTurqEngineSequence().getTurqInventoryTransactions());
                    Hibernate.initialize(bill.getTurqEngineSequence().getTurqCashTransactions());
                    Iterator it2 = bill.getTurqEngineSequence().getTurqCashTransactions().iterator();
                    while(it2.hasNext())
                    {
                        TurqCashTransaction cashTrans = (TurqCashTransaction)it2.next();
                        Hibernate.initialize(cashTrans.getTurqCashTransactionRows());
                    }
				}
				
			}
			return bill;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static void initializeBill(TurqBill bill) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(bill);
			Hibernate.initialize(bill.getTurqBillInGroups());
			Hibernate.initialize(bill.getTurqBillInEngineSequences());
			Iterator it = bill.getTurqBillInEngineSequences().iterator();
			while (it.hasNext())
			{
				TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
				Hibernate.initialize(billInEng.getTurqEngineSequence().getTurqConsignments());
				Hibernate.initialize(billInEng.getTurqEngineSequence().getTurqInventoryTransactions());
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static List getBillInfo(TurqBill bill) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query="Select invTrans.id, cardUnit.cardUnitsFactor, invTrans.turqInventoryCard.cardInventoryCode," +
					" invTrans.turqInventoryCard.cardName, invTrans.turqInventoryUnit.unitsName," +
					((bill.getBillsType() == EngBLCommon.COMMON_BUY_INT || bill.getBillsType() ==EngBLCommon.COMMON_RETURN_SELL_INT)
							? "invTrans.amountIn ," : "invTrans.amountOut ,")+
					" invTrans.unitPriceInForeignCurrency,invTrans.totalPriceInForeignCurrency," +
					" invTrans.turqInventoryWarehous.warehousesName,invTrans.vatRate"+
					" from TurqInventoryTransaction invTrans" +
					" left join invTrans.turqInventoryCard.turqInventoryCardUnits as cardUnit," +
					" TurqBill bill left join bill.turqBillInEngineSequences as billIn" +
					" where invTrans.turqEngineSequence.id=billIn.turqEngineSequence.id" +
					" and bill.id="+bill.getId()+
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
	
	public static TurqViewBillTransTotal getBillView(Integer billId) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select billview from TurqViewBillTransTotal as billview" +
					" where billview.billsId=" + billId;
			Query q = session.createQuery(query);
			List list = q.list();
			
			return (TurqViewBillTransTotal) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List searchBillAdvanced(TurqCurrentCard curCardStart, TurqCurrentCard curCardEnd, Date startDate, Date endDate,
			Date dueDateStart, Date dueDateEnd, BigDecimal minValue, BigDecimal maxValue, String docNoStart, String docNoEnd, int type)
			throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "Select bill.id, bill.billsDate, bill.billDocumentNo,"
					+ " bill.turqCurrentCard.cardsCurrentCode, bill.turqCurrentCard.cardsName,"
					+ " billview.totalprice, billview.vatamount, billview.specialvatamount,bill.turqCurrencyExchangeRate.turqCurrencyByExchangeCurrencyId.currenciesAbbreviation"
					+ " from TurqBill as bill, TurqViewBillTransTotal as billview" + " where" + " bill.billsDate >= :startDate"
					+ " and bill.billsDate <= :endDate" + " and bill.id <> -1 " + " and bill.dueDate >= :dueDateStart"
					+ " and bill.dueDate <= :dueDateEnd" + " and bill.id=billview.billsId ";
			if (curCardStart != null && curCardEnd != null)
			{
				query += " and bill.turqCurrentCard.cardsCurrentCode >= '" + curCardStart.getCardsCurrentCode() + "'";
				query += " and bill.turqCurrentCard.cardsCurrentCode <= '" + curCardEnd.getCardsCurrentCode() + "'";
			}
			else if (curCardStart != null)
			{
				query += " and bill.turqCurrentCard = :curCardStart";
			}
			else if (curCardEnd != null)
			{
				query += " and bill.turqCurrentCard = :curCardEnd";
			}
			if (minValue.doubleValue() > 0)
			{
				query += " and billview.totalamount >=" + minValue;
			}
			if (maxValue.doubleValue() > 0)
			{
				query += " and billview.totalamount <=" + maxValue;
			}
			if (!docNoStart.equals("") && !docNoEnd.equals(""))
			{
				query += " and bill.billDocumentNo >= '" + docNoStart + "'";
				query += " and bill.billDocumentNo <= '" + docNoEnd + "'";
			}
			else if (!docNoStart.equals(""))
			{
				query += " and bill.billDocumentNo like '" + docNoStart + "%'";
			}
			else if (!docNoEnd.equals(""))
			{
				query += " and bill.billDocumentNo like '" + docNoEnd + "%'";
			}
			if (type != EngBLCommon.COMMON_ALL_INT)
			{
				query += " and bill.billsType =" + type;
			}
			query += " order by bill.billsDate";
			Query q = session.createQuery(query);
			q.setParameter("startDate", startDate);
			q.setParameter("endDate", endDate);
			q.setParameter("dueDateEnd", dueDateEnd);
			q.setParameter("dueDateStart", dueDateStart);
			if (curCardStart != null && curCardEnd != null)
			{
			}
			else if (curCardStart != null)
			{
				q.setParameter("curCardStart", curCardStart);
			}
			else if (curCardEnd != null)
			{
				q.setParameter("curCardEnd", curCardEnd);
			}
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}