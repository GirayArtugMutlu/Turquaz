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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.bl.EngBLLogger;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class TextWithButton extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Object data;
	private Button button1;
	private Text text1;

	public TextWithButton(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(276, 34);
			this.setEnabled(true);
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			{
				text1 = new Text(this, SWT.NONE);
				text1.setSize(new org.eclipse.swt.graphics.Point(240, 32));
				GridData text1LData = new GridData();
				text1.setBackground(SWTResourceManager.getColor(211, 255, 255));
				text1.setEnabled(false);
				text1LData.verticalAlignment = GridData.FILL;
				text1LData.horizontalAlignment = GridData.FILL;
				text1LData.grabExcessHorizontalSpace = true;
				text1LData.grabExcessVerticalSpace = true;
				text1.setLayoutData(text1LData);
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.CENTER);
				button1.setText("...");
				GridData button1LData = new GridData();
				button1LData.verticalAlignment = GridData.FILL;
				button1LData.widthHint = 33;
				button1.setLayoutData(button1LData);
			}
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
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
	}

	public String getText()
	{
		return text1.getText();
	}

	public void setText(String arg)
	{
		text1.setText(arg);
	}

	public void setData(Object obj)
	{
		data = obj;
	}

	public Object getData()
	{
		return data;
	}

	public void addMouseListener(MouseAdapter adapter)
	{
		button1.addMouseListener(adapter);
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
	}

	void onResize()
	{
		Rectangle area = getClientArea();
		this.setBounds(0, 0, area.width, area.height);
	}

	void onFocusIn()
	{
		text1.setFocus();
	}

	void onMouseUp()
	{
	}
}