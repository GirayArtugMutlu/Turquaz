/*
 * Created on May 23, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.common;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServiceRequest implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serviceName;
	private HashMap argMap;
	
	public HashMap getArgMap()
	{
		return argMap;
	}
	public void setArgMap(HashMap argMap)
	{
		this.argMap = argMap;
	}
	public String getServiceName()
	{
		return serviceName;
	}
	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}
	public ServiceRequest(String serviceName,HashMap argMap)
	{
		super();
		this.serviceName=serviceName;
		this.argMap=argMap;
	}
	public ServiceRequest(String serviceName)
	{
		super();
		this.serviceName = serviceName;
		this.argMap=null;
	}
}
