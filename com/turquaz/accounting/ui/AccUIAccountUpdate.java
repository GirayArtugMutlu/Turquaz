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

import java.math.BigDecimal;


import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.SWT;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

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
public class AccUIAccountUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;

	private TurqAccountingAccount account;
	private TableColumn tableColCredit;
	private TableColumn tableColumnCreditRemain;
	private TableColumn tableColumnDeptRemain;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private TableItem tableItemTotal;
	private TableColumn tableColumnDebit;
	private TableColumn tableColDefinition;
	private Table tableAccBalance;
	private Group groupAccountBalance;
	private AccUIAddAccounts compAccountCard;
	private BigDecimal[] totals;

	AccBLAccountUpdate blAccount = new AccBLAccountUpdate();
   
	boolean updateOccured = false;
	
	public AccUIAccountUpdate(Shell parent, int style, TurqAccountingAccount acc, BigDecimal[] total) {
		super(parent, style);
		account = acc;
		totals=total;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will
	 * disappear.
	 */
	public boolean open() {
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

			dialogShell.setText(Messages.getString("AccUIAccountUpdate.3")); //$NON-NLS-1$

			dialogShell.setSize(487, 336);


			GridLayout dialogShellLayout = new GridLayout(1, true);
			
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.setLayout(dialogShellLayout);
            {
                toolBarTop = new ToolBar(dialogShell, SWT.SHADOW_OUT);
                {
                    toolUpdate = new ToolItem(toolBarTop, SWT.NONE);
                    toolUpdate.setEnabled(true);
                    toolUpdate.setText(Messages
                        .getString("AccUIAccountUpdate.0")); //$NON-NLS-1$
                    toolUpdate.setImage(SWTResourceManager
                        .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolUpdate.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            toolUpdateWidgetSelected(evt);
                        }
                    });
                }
                {
                    toolDelete = new ToolItem(toolBarTop, SWT.NONE);
                    toolDelete.setEnabled(true);
                    toolDelete.setText(Messages
                        .getString("AccUIAccountUpdate.6")); //$NON-NLS-1$

                    toolDelete.setImage(SWTResourceManager
                        .getImage("icons/Delete16.gif")); //$NON-NLS-1$
                    toolDelete.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            toolDeleteWidgetSelected(evt);
                        }
                    });
                }
                {
                    toolCancel = new ToolItem(toolBarTop, SWT.NONE);
                    toolCancel.setText(Messages
                        .getString("AccUIAccountUpdate.10")); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager
                        .getImage("icons/cancel.jpg")); //$NON-NLS-1$
                    toolCancel.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            updateOccured = false;
                            dialogShell.close();
                        }
                    });
                }
            }
			{
				compAccountCard = new AccUIAddAccounts(dialogShell, SWT.NONE);
				GridData compAccountCardLData = new GridData();
				compAccountCardLData.widthHint = 464;
				compAccountCardLData.heightHint = 112;
				compAccountCard.setLayoutData(compAccountCardLData);
				compAccountCard.getTxtAccAccountCode().setBounds(101, 51, 200, 17);
				compAccountCard.getTxtParentAccount().setBounds(101, 5, 200, 17);
				compAccountCard.getTxtAccAcountName().setBounds(101, 95, 200, 17);
			}
			{
				groupAccountBalance = new Group(dialogShell, SWT.NONE);
				GridLayout groupAccountBalanceLayout = new GridLayout();
				GridData groupAccountBalanceLData = new GridData();
				groupAccountBalanceLData.verticalAlignment = GridData.FILL;
				groupAccountBalanceLData.horizontalAlignment = GridData.FILL;
				groupAccountBalanceLData.grabExcessHorizontalSpace = true;
				groupAccountBalanceLData.grabExcessVerticalSpace = true;
				groupAccountBalance.setLayoutData(groupAccountBalanceLData);
				groupAccountBalance.setText(Messages
					.getString("AccUIAccountUpdate.7")); //$NON-NLS-1$
				groupAccountBalance.setSize(new org.eclipse.swt.graphics.Point(
					471,
					111));
				groupAccountBalance.setLayout(groupAccountBalanceLayout);
				{
					tableAccBalance = new Table(groupAccountBalance, SWT.NONE);
					GridData tableAccBalanceLData = new GridData();
					tableAccBalance.setHeaderVisible(true);
					tableAccBalance.setLinesVisible(true);
					tableAccBalanceLData.horizontalAlignment = GridData.FILL;
					tableAccBalanceLData.grabExcessHorizontalSpace = true;
					tableAccBalanceLData.verticalAlignment = GridData.FILL;
					tableAccBalanceLData.grabExcessVerticalSpace = true;
					tableAccBalance.setLayoutData(tableAccBalanceLData);
					{
						tableColDefinition = new TableColumn(
							tableAccBalance,
							SWT.NONE);
						tableColDefinition.setWidth(61);
					}
					{
						tableColumnDebit = new TableColumn(
							tableAccBalance,
							SWT.RIGHT
							);
						tableColumnDebit.setText(Messages
							.getString("AccUIAccountUpdate.1")); //$NON-NLS-1$
						tableColumnDebit.setWidth(90);
					}
					{
						tableColCredit = new TableColumn(
							tableAccBalance,
							SWT.RIGHT);
						tableColCredit.setText(Messages
							.getString("AccUIAccountUpdate.2")); //$NON-NLS-1$
						tableColCredit.setWidth(90);
					}
					{
						tableItemTotal = new TableItem(
							tableAccBalance,
							SWT.NONE);
						
					}
					{
						tableColumnDeptRemain = new TableColumn(
							tableAccBalance,
							SWT.RIGHT);
						tableColumnDeptRemain.setText(Messages.getString("AccUIAccountUpdate.5")); //$NON-NLS-1$
						tableColumnDeptRemain.setWidth(90);
					}
					{
						tableColumnCreditRemain = new TableColumn(
							tableAccBalance,
							SWT.RIGHT);
						tableColumnCreditRemain.setText(Messages.getString("AccUIAccountUpdate.8")); //$NON-NLS-1$
						tableColumnCreditRemain.setWidth(90);
					}
				}
				groupAccountBalance.layout();
			}

			dialogShell.layout();
			
			Rectangle bounds = dialogShell.computeTrim(0, 0, 487, 301);
			//dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		
			return updateOccured;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI() {
	}

	/** Add your post-init code in here */
	public void postInitGUI() {

		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);

		if (EngBLPermissions
				.getPermission(compAccountCard.getClass().getName()) == 2) {
			toolUpdate.setEnabled(true);
		} else if (EngBLPermissions.getPermission(compAccountCard.getClass()
				.getName()) == 3) {
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}

		compAccountCard.getTxtParentAccount().setText(
				account.getTurqAccountingAccountByParentAccount().getAccountCode());
		compAccountCard.getTxtAccAccountCode().setText(account.getAccountCode());
		compAccountCard.getTxtAccAcountName().setText(account.getAccountName());

		fillBalances();

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
		 * toolDelete.setEnabled(false); toolUpdate.setEnabled(false);
		 *  }
		 */

	}

	public void fillBalances() {
		try {
			
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			BigDecimal credit = totals[0];
			BigDecimal dept = totals[1];
			BigDecimal balance=credit.subtract(dept);
			
			tableItemTotal.setText(new String[] { Messages.getString("AccUIAccountUpdate.4"), //$NON-NLS-1$
					cf.format(dept), cf.format(credit),
					(balance.doubleValue() <= 0) ? cf.format(balance.abs()):"0", //$NON-NLS-1$
					(balance.doubleValue() > 0)? cf.format(balance) : "0"}); //$NON-NLS-1$
			/*
			List list = blAccount.getTotalDeptAndCredit(account);
			
			if (list.size() > 0) 
			{
				Object[] sums = (Object[]) list.get(0);
				if (sums[0] != null)
				{
					TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
					BigDecimal credit = (BigDecimal) sums[1];
					BigDecimal dept = (BigDecimal) sums[0];
					BigDecimal balance = credit.subtract(dept);
					tableItemTotal.setText(new String[] { Messages.getString("AccUIAccountUpdate.4"), //$NON-NLS-1$
							cf.format(dept), cf.format(credit),
							(balance.doubleValue() <= 0) ? cf.format(balance.abs()):"0", //$NON-NLS-1$
							(balance.doubleValue() > 0)? cf.format(balance) : "0"}); //$NON-NLS-1$

				}

			}*/

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt) {
		try {
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);

			if (compAccountCard.verifyFields(true,account)) {
				AccBLAccountUpdate
						.updateAccount(account, compAccountCard
								.getTxtAccAcountName().getText().trim(),
								compAccountCard.getTxtAccAccountCode()
										.getText().trim(), compAccountCard
										.getTxtParentAccount().getData());
				msg.setMessage(Messages.getString("AccUIAccountUpdate.14")); //$NON-NLS-1$
				msg.open();
				updateOccured = true;
				compAccountCard.asistant.refreshContentAssistant(0);
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
				AccBLAccountUpdate.deleteAccount(account);
				msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
				msg.open();
				EngBLAccountingAccounts.RefreshContentAsistantMap();
				updateOccured = true;
				this.dialogShell.close();
				this.dialogShell.dispose();
			}

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}