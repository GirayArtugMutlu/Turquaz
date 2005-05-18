/*
 * Created on May 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.server;

import java.util.HashMap;
import java.util.List;
import com.turquaz.engine.dal.EngDALCommon;
import com.turquaz.engine.dal.TurqService;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServiceList
{
	private static HashMap serviceMap;
	
	public static void InitializeServices()
	{
		try
		{
			serviceMap=new HashMap();
			List services=getServices();
			for(int k=0; k<services.size(); k++)
			{
				TurqService service=(TurqService)services.get(k);
				serviceMap.put(service.getServiceName(),service);
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static List getServices() throws Exception
	{
		return EngDALCommon.getServices();
	}
	
	public static TurqService getService(String serviceName)
	{
		return (TurqService)serviceMap.get(serviceName);
	}
}
