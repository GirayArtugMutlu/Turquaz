package com.turquaz.engine.ui.component;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
/**
 * @author onsel
 */
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class NumericText extends Composite
{
	private Text text;
	public int textLimit;

	public NumericText(Composite arg0, int arg1)
	{
		super(arg0, SWT.NONE);
		text = new Text(this, arg1);
		addListener(SWT.Resize, new Listener()
		{
			public void handleEvent(Event e)
			{
				onResize();
			}
		});
		addListener(SWT.FocusIn, new Listener()
		{
			public void handleEvent(Event e)
			{
				onFocusIn();
			}
		});
		text.addVerifyListener(new VerifyListener()
		{
			public void verifyText(VerifyEvent evt)
			{
				text3VerifyText(evt);
			}
		});
	}

	protected void text3VerifyText(VerifyEvent evt)
	{
		Text control = (Text) evt.widget;
		String textcontrol = control.getText();
		String newText = textcontrol.substring(0, evt.start) + evt.text + textcontrol.substring(evt.end);
		Pattern pattern = Pattern.compile("[0-9]{0,9}");
		Matcher m = pattern.matcher(newText);
		// ONLY NUMERICAL VALUES ARE ACCEPTED .
		if (!m.matches())
		{
			evt.doit = false;
		}
	}

	public int getIntValue()
	{
		if (text.getText().trim().length() == 0)
		{
			return 0;
		}
		try
		{
			int a = Integer.parseInt(text.getText().trim());
			return a;
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return 0;
		}
	}
	
	public Integer getIntegerValue()
	{
		return new Integer(getIntValue());
	}

	public void addModifyListener(ModifyListener listener)
	{
		text.addModifyListener(listener);
	}

	public void setTextLimit(int a)
	{
		textLimit = a;
		text.setTextLimit(a);
	}

	public int getTextLimit()
	{
		return textLimit;
	}

	public void setText(int a)
	{
		text.setText(a + "");
	}

	public Point computeSize(int wHint, int hHint, boolean arg)
	{
		return text.computeSize(wHint, hHint, arg);
	}

	public Rectangle computeTrim(int x, int y, int width, int height)
	{
		return text.computeTrim(x, y, width, height);
	}

	void onResize()
	{
		Rectangle area = getClientArea();
		text.setBounds(0, 0, area.width, area.height);
	}

	void onFocusIn()
	{
		text.setFocus();
	}
}