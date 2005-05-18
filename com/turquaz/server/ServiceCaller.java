/*
 * Created on May 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import com.turquaz.engine.dal.TurqService;
import com.turquaz.engine.exceptions.TurquazException;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServiceCaller
{
	public static Object CallService(String serviceName,HashMap argMap)throws Exception
	{
		TurqService service=ServiceList.getService(serviceName);
		if (service==null)
		{
			throw new TurquazException("No such service is available");
		}
		Class cls=Class.forName(service.getClassName());
		Class[] classList=null;
		Object[] argList=null;
		if (argMap != null)
		{
			classList=new Class[]{argMap.getClass()};
			argList=new Object[]{argMap};
		}
		Method method=cls.getMethod(service.getMethodName(),classList);
		Object retVal=method.invoke(null,argList);
		return retVal;
	}
}
