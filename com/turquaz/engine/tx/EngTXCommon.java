/*
 * Created on Mar 29, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.tx;

import java.lang.reflect.Method;
import com.turquaz.engine.dal.EngDALSessionFactory;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngTXCommon
{
	public static Object searchTX(String myClass, String myMethod, Object[] argList)throws Exception
	{
		Session session=null;
		try
		{			
			session=EngDALSessionFactory.openSession2();
			Class cls=Class.forName(myClass);
			Class[] classList=null;
			if (argList != null)
			{
				classList=new Class[argList.length];
				for(int k=0; k<argList.length; k++)
				{
					classList[k]=argList[k].getClass();
				}
			}
			Method method=cls.getMethod(myMethod,classList);
			Object retVal=method.invoke(null,argList);
			return retVal;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		finally
		{
			if (session != null)
			{
				session.close();
			}
		}
	}
	
	public static Object doTransactionTX(String myClass, String myMethod, Object[] argList)throws Exception
	{
		Session session=null;
		Transaction tx=null;
		try
		{			
			session=EngDALSessionFactory.openSession2();
			tx=session.beginTransaction();
			Class cls=Class.forName(myClass);
			Class[] classList=null;
			if (argList != null)
			{
				classList=new Class[argList.length];
				for(int k=0; k<argList.length; k++)
				{
					classList[k]=argList[k].getClass();
				}
			}
			Method method=cls.getMethod(myMethod,classList);
			Object retVal=method.invoke(null,argList);
			return retVal;
		}
		catch(Exception ex)
		{
			throw ex;
		}
		finally
		{
			if (tx != null)
			{
				tx.commit();
			}
			if (session != null)
			{
				session.close();
			}
		}
	}
}
