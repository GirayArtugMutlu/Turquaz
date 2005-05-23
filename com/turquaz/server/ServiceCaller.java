/*
 * Created on May 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import com.turquaz.common.HttpServiceRequest;
import com.turquaz.common.HttpServiceResponse;
import com.turquaz.common.ServiceRequest;
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
	public static HttpServiceResponse CallService(HttpServiceRequest request)
	{
		try
		{
			List requestList = request.getRequestList();
			HashMap resultMap = new HashMap();
			for (int k = 0; k < requestList.size(); k++)
			{
				ServiceRequest serviceRequest = (ServiceRequest) requestList.get(k);
				Object serviceResult=ServiceCaller.CallService(serviceRequest.getServiceName(), serviceRequest.getArgMap());
				resultMap.put(serviceRequest.getServiceName(),serviceResult);
			}
			return new HttpServiceResponse(resultMap);
		}
		catch (Exception ex)
		{
			return new HttpServiceResponse(ex);
		}
	}

	private static Object CallService(String serviceName, HashMap argMap) throws Exception
	{
		TurqService service = ServiceList.getService(serviceName);
		if (service == null)
		{
			throw new TurquazException("No such service is available: " + serviceName);
		}
		Class cls = Class.forName(service.getClassName());
		Class[] classList = null;
		Object[] argList = null;
		if (argMap != null)
		{
			classList = new Class[]{argMap.getClass()};
			argList = new Object[]{argMap};
		}
		Method method = cls.getMethod(service.getMethodName(), classList);
		Object retVal = method.invoke(null, argList);
		return retVal;
	}
}