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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingAccount;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.SWT;

import com.cloudgarden.resource.SWTResourceManager;


/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class AccUIAddAccountDialog extends org.eclipse.swt.widgets.Dialog {

	private ToolItem toolSave;

	private ToolBar toolbarAccountUpdate;

	private CoolItem coolItem1;

	private CoolBar coolBar1;

	private AccUIAddAccounts compAccountCard;

	private Shell dialogShell;

	private TurqAccountingAccount account;

	private ToolItem toolCancel;

	AccBLAccountUpdate blAccount = new AccBLAccountUpdate();

	public AccUIAddAccountDialog(Shell parent, int style, TurqAccountingAccount acc) {
		super(parent, style);
		account = acc;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will
	 * disappear.
	 */
	public void open() {
		try {
			preInitGUI();

			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM
					| SWT.APPLICATION_MODAL);

			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}

			dialogShell.setText(getText());
			coolBar1 = new CoolBar(dialogShell, SWT.NULL);
			coolItem1 = new CoolItem(coolBar1, SWT.NULL);
			toolbarAccountUpdate = new ToolBar(coolBar1, SWT.NULL);
			toolSave = new ToolItem(toolbarAccountUpdate, SWT.NULL);
			compAccountCard = new AccUIAddAccounts(dialogShell, SWT.NULL);

			dialogShell.setSize(487, 336);

			GridData coolBar1LData = new GridData();
			coolBar1LData.verticalAlignment = GridData.CENTER;
			coolBar1LData.horizontalAlignment = GridData.FILL;
			coolBar1LData.widthHint = -1;
			coolBar1LData.heightHint = -1;
			coolBar1LData.horizontalIndent = 0;
			coolBar1LData.horizontalSpan = 1;
			coolBar1LData.verticalSpan = 1;
			coolBar1LData.grabExcessHorizontalSpace = false;
			coolBar1LData.grabExcessVerticalSpace = false;
			coolBar1.setLayoutData(coolBar1LData);

			coolItem1.setControl(toolbarAccountUpdate);
			coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(88,
					38));
			coolItem1
					.setMinimumSize(new org.eclipse.swt.graphics.Point(88, 38));

			toolSave.setText("Kaydet"); 
			toolSave.setToolTipText("Kaydet");
			toolSave.setImage(SWTResourceManager
					.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							toolUpdateWidgetSelected(evt);
						}
					});

			final org.eclipse.swt.graphics.Image toolDelete�mage = new org.eclipse.swt.graphics.Image(
					Display.getDefault(), getClass().getClassLoader()
							.getResourceAsStream("icons/delete_edit.gif")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolbarAccountUpdate, SWT.NONE);
				toolCancel.setText(Messages.getString("AccUIAccountUpdate.6")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogShell.close();
					}
				});
			}

			GridData compAccountCardLData = new GridData();
			compAccountCardLData.verticalAlignment = GridData.CENTER;
			compAccountCardLData.horizontalAlignment = GridData.BEGINNING;
			compAccountCardLData.widthHint = 452;
			compAccountCardLData.heightHint = 116;
			compAccountCardLData.horizontalIndent = 0;
			compAccountCardLData.horizontalSpan = 1;
			compAccountCardLData.verticalSpan = 1;
			compAccountCardLData.grabExcessHorizontalSpace = false;
			compAccountCardLData.grabExcessVerticalSpace = false;
			compAccountCard.setLayoutData(compAccountCardLData);
			compAccountCard
					.setSize(new org.eclipse.swt.graphics.Point(452, 116));
			compAccountCard.getTxtParentAccount().setBounds(101, 92, 234, 23);
			compAccountCard.layout();

			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			dialogShell.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					toolDelete�mage.dispose();
				}
			});
			Rectangle bounds = dialogShell.computeTrim(0, 0, 487, 301);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI() {
	}

	/** Add your post-init code in here */
	public void postInitGUI() {

		toolSave.setEnabled(false);


		if (EngBLPermissions
				.getPermission(compAccountCard.getClass().getName()) == 2) {
			toolSave.setEnabled(true);
		} else if (EngBLPermissions.getPermission(compAccountCard.getClass()
				.getName()) == 3) {
				toolSave.setEnabled(true);
		}

		compAccountCard.getTxtAccAccountCode()
				.setText(account.getAccountCode()+".");
		compAccountCard.getTxtParentAccount().setText(
				account.getAccountCode());
		

		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();

		int location_X = (parentLocation.x + parentSize.x) / 2
				- (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2
				- (dialogSize.y / 2);

		dialogShell.setLocation(location_X, location_Y);
		/*
		 * if(account.getTurqAccountingAccount().getAccountingAccountsId().intValue()==-1){
		 * toolDelete.setEnabled(false); toolSave.setEnabled(false);
		 *  }
		 */

	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt) {
		try {
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);

			if (compAccountCard.verifyFields()) {
				compAccountCard.save();
				
				this.dialogShell.close();

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt) {
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		MessageBox msg2 = new MessageBox(this.getParent(), SWT.OK | SWT.CANCEL);
		try {
			msg2.setMessage(Messages.getString("AccUIAccountUpdate.15")); //$NON-NLS-1$
			int result = msg2.open();

			if (result == SWT.OK) {
				blAccount.deleteAccount(account);
				msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
				msg.open();
				this.dialogShell.close();
				this.dialogShell.dispose();
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}