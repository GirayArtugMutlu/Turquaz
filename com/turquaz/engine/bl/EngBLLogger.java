package com.turquaz.engine.bl;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class EngBLLogger {
	
	
	public static void log(Class cls,Exception ex)
	{
		Logger loger = Logger.getLogger(cls);
		loger.error("Exception Caught", ex);
		ex.printStackTrace();		
	}
	
	public static void log(Class cls,Exception ex,Shell shell)
	{
		
		MessageBox msg = new MessageBox(shell, SWT.NULL);
		msg.setMessage(ex.toString());
		msg.open();
	
		Logger loger = Logger.getLogger(cls);
        
		loger.error("Exception Caught", ex);
		ex.printStackTrace();
		
	}
	
	
	

}
