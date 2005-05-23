/*
 * Created on May 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.client;

import com.turquaz.common.HttpServiceRequest;
import com.turquaz.common.HttpServiceResponse;
import com.turquaz.server.ServiceCaller;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Services
{
	
	public static Object CallService(HttpServiceRequest request)throws Throwable
	{
		HttpServiceResponse response=ServiceCaller.CallService(request);
		if (response.isExceptionThrown())
			throw response.getThrowable();
		else
			return response.getResult();
	}
}
