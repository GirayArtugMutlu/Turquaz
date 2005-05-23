/*
 * Created on May 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class HttpServiceRequest
{
	
	List requestList;
	/**
	 * @param requestList
	 */
	public HttpServiceRequest(List requestList)
	{
		super();
		this.requestList = requestList;
	}
	public List getRequestList()
	{
		return requestList;
	}
	public void setRequestList(List requestList)
	{
		this.requestList = requestList;
	}
	
	/**
	 * 
	 */
	public HttpServiceRequest()
	{
		super();
		requestList=new ArrayList();		
	}
	
	public void addServiceRequest(ServiceRequest serviceRequest)
	{
		requestList.add(serviceRequest);
	}
	
	public void addServiceRequest(String serviceName, HashMap argMap)
	{
		requestList.add(new ServiceRequest(serviceName,argMap));
	}
	
	public void addServiceRequest(String serviceName)
	{
		requestList.add(new ServiceRequest(serviceName));
	}
}
