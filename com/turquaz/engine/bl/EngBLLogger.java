package com.turquaz.engine.bl;

import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.engine.exceptions.TurquazException;

public class EngBLLogger {
	
	
	public static void log(Class cls,Exception ex)
	{
		Logger loger = Logger.getLogger(cls);
		loger.error("Exception Caught", ex);
		ex.printStackTrace();		
	}
	
	public static void log(Class cls,Exception ex,Shell shell)
	{
        ex.printStackTrace();
		MessageBox msg = new MessageBox(shell, SWT.NULL);
		if (ex.getMessage()== null)
		{
			if (ex.getCause()==null)
			{
				msg.setMessage(ex.toString());
			}
			else
			{
				if (ex.getCause().getMessage()==null)
					msg.setMessage(ex.getCause().toString());
				else
					msg.setMessage(ex.getCause().getMessage());
			}			
		}
		else
		{
			msg.setMessage(ex.getMessage());
		}
		msg.open();	
		if (ex instanceof TurquazException)
		{
		}
		else
		{
			Logger loger = Logger.getLogger(cls);        
			loger.error("Exception Caught", ex);
		}
		
		
	}
	
	
	

}
