/*
 * Created on Mar 1, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.bl;

import java.lang.reflect.Method;
import java.util.Comparator;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLHibernateComparer implements Comparator {
	
	private Integer compareId1, compareId2;
	
	public void initalize(Object o1, Object o2)
	{
		try
		{
			
			Class[] parttypes=new Class[0];
 			Object[] arglist=new Object[0];
 			
			Class cls1=o1.getClass();			
 			Method mh1=cls1.getMethod("getId",parttypes);	 
 			Object id1=mh1.invoke( o1,arglist);
 			compareId1=(Integer)id1;
 		
 			Class cls2=o2.getClass();
 			Method mh2=cls2.getMethod("getId",parttypes);	 		
 			Object id2=mh2.invoke( o2,arglist);
 			compareId2=(Integer)id2;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	 public int compare(Object o1, Object o2)
	 {
	 	try
		{

	 		initalize(o1,o2);
	 		return compareId1.compareTo(compareId2);
	 		
		}
	 	catch(Exception ex)
		{
	 		ex.printStackTrace();
		}
	 	return 1;
	 }
	 public boolean equals(Object obj)
	 {
	 	return compareId1.equals(compareId2);
	 }
	 
}
