package com.turquaz.engine.dal;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.turquaz.engine.exceptions.TurquazException;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;

public class EngDALCommon
{
	
	public static List getServices() throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		String query = "Select service from TurqService as service";
		Query q = session.createQuery(query);
		List list = q.list();
		return list;		
	}
	
	public static TurqCurrencyExchangeRate getCurrencyExchangeRate(Integer currencyId, Date exchangeDate)throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		TurqCurrency currency=(TurqCurrency)session.load(TurqCurrency.class,currencyId);
		if (currency.isConstant())
		{
			String query = "Select exchangeRate from TurqCurrencyExchangeRate as exchangeRate where exchangeRate.turqCurrencyByExchangeCurrencyId.id="+currencyId;
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size() > 0)
			{
				return (TurqCurrencyExchangeRate)list.get(0);
			}
			else
			{
				throw new TurquazException("Inconsistent database error: constant currency must have a global exchangeRate");
			}
		}
		else
		{
			String query = "Select exchangeRate from TurqCurrencyExchangeRate as exchangeRate where turqCurrencyByExchangeCurrencyId.id="+currencyId+
						" and exchangeRate.exhangeRatesDate=:exchangeDate";
			Query q = session.createQuery(query);
			q.setParameter("exchangeDate",exchangeDate);
			List list = q.list();
			if (list.size() > 0)
			{
				return (TurqCurrencyExchangeRate)list.get(0);
			}
			else
			{
				return null;
			}
		}
	}
	
	public static List getCurrencies() throws Exception
	{ 
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqCurrency as currency where currency.id=1 ";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	
	public static TurqSetting getTurqSetting() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
		
			String query = "Select setting from TurqSetting as setting";
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size()==0)
				return null;
			else
				return (TurqSetting)list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void initializeObject(Object obj, String myMethod) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		session.refresh(obj);
		Class myClass = obj.getClass();
		Method method = myClass.getMethod(myMethod, null);
		Hibernate.initialize(method.invoke(obj, null));
	}

	public static TurqCurrencyExchangeRate getCurrencyExchangeRate(TurqCurrency baseCurrency, TurqCurrency exchangeCurrency,
			Date exchangeDate) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String query = "select exchangeRate from TurqCurrencyExchangeRate as exchangeRate"
					+ " where exchangeRate.turqCurrencyByBaseCurrencyId= :baseCurrency"
					+ " and exchangeRate.turqCurrencyByExchangeCurrencyId= :exchangeCurrency"
					+ " and exchangeRate.exhangeRatesDate ='" + df.format(exchangeDate) + "'";
			Query q = session.createQuery(query);
			q.setParameter("baseCurrency", baseCurrency);
			q.setParameter("exchangeCurrency", exchangeCurrency);
			List list = q.list();
			if (list.size() == 0)
				return null;
			else
				return (TurqCurrencyExchangeRate) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static boolean checkUserPass(String username, String pass) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqUser as user " + "where user.username ='" + username + "' and" + " user.usersPassword ='" + pass
					+ "'";
			Query q = session.createQuery(query);
			List list = q.list();
			if (list.size() == 1)
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

	public static List getGroups() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqGroup as group";
			Query q = session.createQuery(query);
			List list = q.list();
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static List getUsers() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "from TurqUser as group";
			Query q = session.createQuery(query);
			List list = q.list();
			for (int i = 0; i < list.size(); i++)
			{
				TurqUser invCard = (TurqUser) list.get(i);
				Hibernate.initialize(invCard.getTurqUserGroups());
				Hibernate.initialize(invCard.getTurqUserPermissions());
			}
			return list;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static void deleteObject(Object obj) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();
		
		session.delete(obj);
		session.flush();
	
	}


	public static void updateObject(Object obj) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();		
		session.update(obj);
		session.flush();		
	}

	

	public static void saveObject(Object obj) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();	
		session.save(obj);
		session.flush();
		
	}
	public static void saveOrUpdateObject(Object obj) throws Exception
	{
		Session session = EngDALSessionFactory.getSession();	
		session.saveOrUpdate(obj);
		session.flush();
		
	}

	public static Object[] getBankTransaction(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqBanksTransactionBills());
			Iterator it = seq.getTurqBanksTransactionBills().iterator();
			if (it.hasNext())
			{
				Object []data = new Object[2];
				
				data[0]= ((TurqBanksTransactionBill) it.next()).getId();
				data[1]=((TurqBanksTransactionBill) it.next()).getTurqBanksTransactionType().getId();
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Integer[] getCheqeuTransaction(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqChequeRolls());
			Iterator it = seq.getTurqChequeRolls().iterator();
			if (it.hasNext())
			{
				TurqChequeRoll roll =(TurqChequeRoll) it.next();
				Integer []data = new Integer[]{roll.getId(),roll.getTurqChequeTransactionType().getId()};
				
				return data;
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Integer getBill(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqBillInEngineSequences());
			Iterator it = seq.getTurqBillInEngineSequences().iterator();
			if (it.hasNext())
			{
				return ((TurqBillInEngineSequence) it.next()).getTurqBill().getId();
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
	public static Integer getBillOfCurrentTrans(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqBills());
			Iterator it = seq.getTurqBills().iterator();
			if (it.hasNext())
			{
				return ((TurqBill) it.next()).getId();
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static Integer getCashTransaction(TurqEngineSequence seq) throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			session.refresh(seq);
			Hibernate.initialize(seq.getTurqCashTransactions());
			Iterator it = seq.getTurqCashTransactions().iterator();
			if (it.hasNext())
			{
				return ((TurqCashTransaction) it.next()).getId();
			}
			return null;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrency getBaseCurrency() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select currency from TurqCurrency as currency" + " where currency.defaultCurrency=true";
			Query q = session.createQuery(query);
			List list = q.list();
	
			return (TurqCurrency) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public static TurqCurrencyExchangeRate getBaseCurrencyExchangeRate() throws Exception
	{
		try
		{
			Session session = EngDALSessionFactory.getSession();
			String query = "select exRate from TurqCurrencyExchangeRate as exRate" + " where exRate.id=-1";
			Query q = session.createQuery(query);
			List list = q.list();
			
			return (TurqCurrencyExchangeRate) list.get(0);
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}
}