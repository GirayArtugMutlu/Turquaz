/*
 * Created on Mar 29, 2005
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.tx;

import java.lang.reflect.Method;
import java.util.HashMap;
import com.turquaz.engine.dal.EngDALSessionFactory;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

/**
 * @author Cem
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngTXCommon
{
	public static Object doSelectTX(String myClass, String myMethod, HashMap argMap)throws Exception
	{
		Session session=null;
		Transaction tx=null;
		try
		{			
			session=EngDALSessionFactory.openSession();	
			tx=session.beginTransaction();
			Class cls=Class.forName(myClass);
			Class[] classList=null;
			Object[] argList=null;
			if (argMap != null)
			{
				classList=new Class[]{argMap.getClass()};
				argList=new Object[]{argMap};
			}
			Method method=cls.getMethod(myMethod,classList);
			Object retVal=method.invoke(null,argList);
			tx.commit();
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
	
	public static Object doTransactionTX(String myClass, String myMethod, HashMap argMap)throws Exception
	{
		Session session=null;
		Transaction tx=null;
		try
		{			
			session=EngDALSessionFactory.openSession();
			tx=session.beginTransaction();
			Class cls=Class.forName(myClass);
			Class[] classList=null;
			Object[] argList=null;
			if (argMap != null)
			{
				classList=new Class[]{argMap.getClass()};
				argList=new Object[]{argMap};
			}
			Method method=cls.getMethod(myMethod,classList);
			Object retVal=method.invoke(null,argList);
			tx.commit();
			return retVal;
		}
		catch(Exception ex)
		{
			if (tx != null){
				tx.rollback();
			}
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
}
