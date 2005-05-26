/*
 * Created on May 23, 2005 TODO To change the template for this generated file go to Window - Preferences - Java - Code Style - Code
 * Templates
 */
package com.turquaz.common;

import java.io.Serializable;

/**
 * @author Cem 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code Templates
 */
public class HttpServiceResponse implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Throwable throwable;
	private Object result;

	public HttpServiceResponse(Throwable throwable)
	{
		this.throwable = throwable;
	}

	public HttpServiceResponse(Object result)
	{
		this.result = result;
	}

	public Throwable getThrowable()
	{
		return throwable;
	}

	public void setThrowable(Throwable throwable)
	{
		this.throwable = throwable;
	}

	public Object getResult()
	{
		return result;
	}

	public void setResult(Object result)
	{
		this.result = result;
	}

	public boolean isExceptionThrown()
	{
		if (throwable != null)
			return true;
		return false;
	}

	public HttpServiceResponse()
	{
		super();
		// TODO Auto-generated constructor stub
	}
}