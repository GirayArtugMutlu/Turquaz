/*
 * Created on May 18, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.server;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Service
{
	private String serviceName;
	private String className;
	private String methodName;
	
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}
	public String getMethodName()
	{
		return methodName;
	}
	public void setMethodName(String methodName)
	{
		this.methodName = methodName;
	}
	public String getServiceName()
	{
		return serviceName;
	}
	public void setServiceName(String serviceName)
	{
		this.serviceName = serviceName;
	}
	public Service(String serviceName,String className, String methodName)
	{
		this.serviceName=serviceName;
		this.className=className;
		this.methodName=methodName;
	}
	
}
