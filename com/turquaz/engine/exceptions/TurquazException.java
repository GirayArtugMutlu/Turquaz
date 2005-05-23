/*
 * Created on Apr 26, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.exceptions;

import java.io.Serializable;
import com.turquaz.engine.lang.EngLangCommonKeys;

/**
 * @author Cem
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TurquazException extends Exception implements Serializable
{

	public final static String EX_BILL_DOC_NO=EngLangCommonKeys.MSG_BILL_NO_ALREADY_USED;  //$NON-NLS-1$
	public final static String EX_ACC_SUB_ACC=EngLangCommonKeys.MSG_CANNOT_DEFINE_SUBACCOUNT_AS_MAIN; //$NON-NLS-1$
	
	public TurquazException()
	{
		super();
	}

	/**
	 * @param message
	 */
	public TurquazException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public TurquazException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TurquazException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
