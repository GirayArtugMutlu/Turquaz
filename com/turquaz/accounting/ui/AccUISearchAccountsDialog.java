package com.turquaz.accounting.ui;

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
import org.eclipse.swt.widgets.Display;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import com.turquaz.accounting.bl.AccBLAccountAdd;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUISearchAccountsDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite composite1;
	private Table tableResults;
	private CLabel lblAccountCode;
	private TableColumn tableColumnBalance;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDept;
	private TableColumn tableColumnAccountName;
	private TableColumn tableColumnAccCode;
	private Tree accountTree;
	private AccBLAccountAdd blAccount;
	Object returnObj[] = new Object[2];

	public AccUISearchAccountsDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public void open()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}

			dialogShell.setText(getText());
			dialogShell.setSize(new org.eclipse.swt.graphics.Point(387, 260));
			final Color composite1background = new Color(Display.getDefault(), 255, 255, 255);
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
					composite1background.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 387, 260);
			dialogShell.setSize(593, 438);
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 90;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					lblAccountCode = new CLabel(composite1, SWT.NONE);
					lblAccountCode.setText("Hesap Kodu");
				}
			}
			{
				GridData tableResultsLData = new GridData();
				tableResultsLData.grabExcessHorizontalSpace = true;
				tableResultsLData.horizontalAlignment = GridData.FILL;
				tableResultsLData.grabExcessVerticalSpace = true;
				tableResultsLData.verticalAlignment = GridData.FILL;
				tableResults = new Table(dialogShell, SWT.NONE);
				tableResults.setLayoutData(tableResultsLData);
				tableResults.setHeaderVisible(true);
				tableResults.setLinesVisible(true);
				{
					tableColumnAccCode = new TableColumn(tableResults, SWT.NONE);
					tableColumnAccCode.setText("Hesap Kodu");
					tableColumnAccCode.setWidth(100);
				}
				{
					tableColumnAccountName = new TableColumn(
						tableResults,
						SWT.NONE);
					tableColumnAccountName.setText("Hesap Ad\u0131");
					tableColumnAccountName.setWidth(111);
				}
				{
					tableColumnDept = new TableColumn(tableResults, SWT.NONE);
					tableColumnDept.setText("Toplam Borç");
					tableColumnDept.setWidth(115);
				}
				{
					tableColumnCredit = new TableColumn(tableResults, SWT.NONE);
					tableColumnCredit.setText("Toplam Alacak");
					tableColumnCredit.setWidth(100);
				}
				{
					tableColumnBalance = new TableColumn(tableResults, SWT.NONE);
					tableColumnBalance.setText("Bakiye");
					tableColumnBalance.setWidth(100);
				}
			}
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
		
	}

}