package com.turquaz.engine.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.engine.lang.EngLangCommonKeys;

public class EngUICommon
{
	public static boolean okToDelete(Shell parent, String message)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.YES | SWT.NO | SWT.ICON_QUESTION);
		msg2.setMessage(message);
		if (msg2.open() == SWT.YES)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean okToDelete(Shell parent)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.YES | SWT.NO | SWT.ICON_QUESTION);
		msg2.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY);
		if (msg2.open() == SWT.YES)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void showMessageBox(Shell parent, String message)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.NULL);
		msg2.setMessage(message);
		msg2.open();
	}

	public static void showMessageBox(Shell parent, String message, int style)
	{
		MessageBox msg2 = new MessageBox(parent, style);
		msg2.setMessage(message);
		msg2.open();
	}

	public static void showSavedSuccesfullyMessage(Shell parent)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.ICON_INFORMATION);
		msg2.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); 
		msg2.open();
	}
	
	public static void showDeletedSuccesfullyMessage(Shell parent)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.ICON_INFORMATION);
		msg2.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); 
		msg2.open();
	}
	
	public static void showUpdatedSuccesfullyMessage(Shell parent)
	{
		MessageBox msg2 = new MessageBox(parent, SWT.ICON_INFORMATION);
		msg2.setMessage(EngLangCommonKeys.MSG_UPDATED_SUCCESS); 
		msg2.open();
	}

	public static void centreWindow(Shell shell)
	{
		Rectangle displayRect;
		try
		{
			displayRect = shell.getMonitor().getClientArea();
		}
		catch (NoSuchMethodError e)
		{
			displayRect = shell.getDisplay().getClientArea();
		}
		Rectangle shellRect = shell.getBounds();
		int x = (displayRect.width - shellRect.width) / 2;
		int y = (displayRect.height - shellRect.height) / 2;
		shell.setLocation(x, y);
	}
}