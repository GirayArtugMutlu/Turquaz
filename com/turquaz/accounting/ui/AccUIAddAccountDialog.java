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
 * @author  Huseyin Ergun
 * @version  $Id$
 */
import org.apache.log4j.Logger;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingAccount;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUIAddAccountDialog extends org.eclipse.swt.widgets.Dialog
{
	private AccUIAddAccounts compAccountCard;
	private Shell dialogShell;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;
	TurqAccountingAccount acc = null;

	public AccUIAddAccountDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public void open(TurqAccountingAccount account)
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
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setText(Messages.getString("AccUIAddAccountDialog.1")); //$NON-NLS-1$
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.setSize(487, 336);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolSave = new ToolItem(toolBar1, SWT.NONE);
					toolSave.setText(Messages.getString("AccUIAddAccountDialog.0")); //$NON-NLS-1$
					toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolUpdateWidgetSelected(evt);
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("AccUIAddAccountDialog.2")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							dialogShell.close();
						}
					});
				}
			}
			compAccountCard = new AccUIAddAccounts(dialogShell, SWT.NULL);
			GridData compAccountCardLData = new GridData();
			compAccountCardLData.widthHint = 452;
			compAccountCardLData.heightHint = 125;
			compAccountCard.setLayoutData(compAccountCardLData);
			compAccountCard.getTxtAccAcountName().setBounds(101, 93, 220, 20);
			compAccountCard.getTxtAccAccountCode().setBounds(101, 45, 220, 20);
			compAccountCard.getTxtParentAccount().setBounds(101, 5, 220, 20);
			compAccountCard.layout();
			postInitGUI();
			compAccountCard.getTxtParentAccount().setText(account.getAccountCode());
			dialogShell.layout();
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

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public TurqAccountingAccount open()
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
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.setSize(487, 336);
			dialogShell.setText(getText());
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				{
					toolSave = new ToolItem(toolBar1, SWT.NONE);
					toolSave.setText(Messages.getString("AccUIAddAccountDialog.0")); //$NON-NLS-1$
					toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolUpdateWidgetSelected(evt);
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages.getString("AccUIAddAccountDialog.2")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							dialogShell.close();
						}
					});
				}
			}
			compAccountCard = new AccUIAddAccounts(dialogShell, SWT.NULL);
			GridData compAccountCardLData = new GridData();
			compAccountCardLData.widthHint = 452;
			compAccountCardLData.heightHint = 125;
			compAccountCard.setLayoutData(compAccountCardLData);
			compAccountCard.getTxtParentAccount().setBounds(101, 92, 234, 23);
			compAccountCard.layout();
			postInitGUI();
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return acc;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void setPermissions()
	{
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		toolSave.setEnabled(false);
		if (EngBLPermissions.getPermission(compAccountCard.getClass().getName()) == 2)
		{
			toolSave.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compAccountCard.getClass().getName()) == 3)
		{
			toolSave.setEnabled(true);
		}
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
		/*
		 * if(account.getTurqAccountingAccount().getAccountingAccountsId().intValue()==-1){ toolDelete.setEnabled(false);
		 * toolSave.setEnabled(false); }
		 */
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		try
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			if (compAccountCard.verifyFields(false, null))
			{
				acc = compAccountCard.saveAccount();
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
}