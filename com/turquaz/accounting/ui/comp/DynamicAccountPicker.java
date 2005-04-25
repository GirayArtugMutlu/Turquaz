package com.turquaz.accounting.ui.comp;

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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.ui.AccUIStaticAccountsDialog;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingAccount;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a for-profit company or business) then you should purchase a license - please visit www.cloudgarden.com for details.
 */
public class DynamicAccountPicker extends org.eclipse.swt.widgets.Composite
{
	private Button button1;
	private Text text1;
	private String filter = "";

	public DynamicAccountPicker(Composite parent, int style)
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
			text1 = new Text(this, SWT.LEFT);
			button1 = new Button(this, SWT.PUSH | SWT.CENTER | SWT.BORDER);
			this.setSize(new org.eclipse.swt.graphics.Point(397, 22));
			this.setEnabled(true);
			GridData text1LData = new GridData();
			text1LData.verticalAlignment = GridData.FILL;
			text1LData.horizontalAlignment = GridData.FILL;
			text1LData.widthHint = -1;
			text1LData.heightHint = -1;
			text1LData.horizontalIndent = 0;
			text1LData.horizontalSpan = 1;
			text1LData.verticalSpan = 1;
			text1LData.grabExcessHorizontalSpace = true;
			text1LData.grabExcessVerticalSpace = true;
			text1.setLayoutData(text1LData);
			text1.setEditable(true);
			text1.setSize(new org.eclipse.swt.graphics.Point(358, 22));
			text1.setEnabled(false);
			final Color text1background = new Color(Display.getDefault(), 255, 255, 255);
			text1.setBackground(text1background);
			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.FILL;
			button1LData.horizontalAlignment = GridData.BEGINNING;
			button1LData.widthHint = 29;
			button1LData.heightHint = -1;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("...");
			button1.setSize(new org.eclipse.swt.graphics.Point(29, 18));
			button1.addMouseListener(new MouseAdapter()
			{
				public void mouseUp(MouseEvent evt)
				{
					button1MouseUp(evt);
				}
			});
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
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
					text1background.dispose();
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
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
	}

	public void setData(Object obj)
	{
		super.setData(obj);
		if (obj != null)
		{
			TurqAccountingAccount account = (TurqAccountingAccount) obj;
			text1.setText(account.getAccountCode() + "-" + account.getAccountName());
		}
		else
		{
			text1.setText("");
		}
	}

	/** Auto-generated event handler method */
	protected void button1MouseUp(MouseEvent evt)
	{
		Object[] obj = new AccUIStaticAccountsDialog(this.getShell(), SWT.NULL).showDialog(filter);
		if (obj[0] != null)
		{
			this.setData(obj[1]);
			text1.setText(obj[0].toString());
		}
	}

	/**
	 * @return Returns the filter.
	 */
	public String getFilter()
	{
		return filter;
	}

	/**
	 * @param filter
	 *             The filter to set.
	 */
	public void setFilter(String filter)
	{
		this.filter = filter;
	}
}