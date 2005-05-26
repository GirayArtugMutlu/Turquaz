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
import java.util.HashMap;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountUpdate;
import com.turquaz.accounting.ui.AccUIAddAccounts;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.layout.GridData;
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

public class AccUIAccountUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
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
	boolean updateOccured = false;
	private HashMap accountMap;
	private HashMap parentMap;

	public AccUIAccountUpdate(Shell parent, int style, HashMap accountMap,HashMap parentMap, BigDecimal[] total)
	{
		super(parent, style);
		this.accountMap=accountMap;
		this.parentMap=parentMap;
		totals = total;
	}

	/**
	 * Opens the Dialog Shell. Auto-generated code - any changes you make will disappear.
	 */
	public boolean open()
	{
		try
		{
			preInitGUI();
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setText(EngLangCommonKeys.STR_DELETE); 
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
					toolUpdate.setText(EngLangCommonKeys.STR_UPDATE); 
					toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); 
					toolUpdate.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolUpdateWidgetSelected(evt);
						}
					});
				}
				{
					toolDelete = new ToolItem(toolBarTop, SWT.NONE);
					toolDelete.setEnabled(true);
					toolDelete.setText(EngLangCommonKeys.STR_DELETE); 
					toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); 
					toolDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							toolDeleteWidgetSelected(evt);
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBarTop, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL); 
					toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); 
					toolCancel.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
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
				groupAccountBalance.setText(AccLangKeys.STR_BALANCES); 
				groupAccountBalance.setSize(new org.eclipse.swt.graphics.Point(471, 111));
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
						tableColDefinition = new TableColumn(tableAccBalance, SWT.NONE);
						tableColDefinition.setWidth(61);
					}
					{
						tableColumnDebit = new TableColumn(tableAccBalance, SWT.RIGHT);
						tableColumnDebit.setText(AccLangKeys.STR_DEBIT); 
						tableColumnDebit.setWidth(90);
					}
					{
						tableColCredit = new TableColumn(tableAccBalance, SWT.RIGHT);
						tableColCredit.setText(AccLangKeys.STR_CREDIT); 
						tableColCredit.setWidth(90);
					}
					{
						tableItemTotal = new TableItem(tableAccBalance, SWT.NONE);
					}
					{
						tableColumnDeptRemain = new TableColumn(tableAccBalance, SWT.RIGHT);
						tableColumnDeptRemain.setText(AccLangKeys.STR_BALANCE_DEBIT); 
						tableColumnDeptRemain.setWidth(90);
					}
					{
						tableColumnCreditRemain = new TableColumn(tableAccBalance, SWT.RIGHT);
						tableColumnCreditRemain.setText(AccLangKeys.STR_DEBIT_RECEIVE); 
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
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updateOccured;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return false;
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		if (EngBLPermissions.getPermission(compAccountCard.getClass().getName()) == 2)
		{
			toolUpdate.setEnabled(true);
		}
		else if (EngBLPermissions.getPermission(compAccountCard.getClass().getName()) == 3)
		{
			toolDelete.setEnabled(true);
			toolUpdate.setEnabled(true);
		}
		compAccountCard.getTxtParentAccount().setText((String)parentMap.get(AccKeys.ACC_ACCOUNT_CODE));
		compAccountCard.getTxtAccAccountCode().setText((String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE));
		compAccountCard.getTxtAccAcountName().setText((String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME));
		fillBalances();
		Point parentLocation = this.getParent().getLocation();
		Point parentSize = this.getParent().getSize();
		Point dialogSize = dialogShell.getSize();
		int location_X = (parentLocation.x + parentSize.x) / 2 - (dialogSize.x / 2);
		int location_Y = (parentLocation.y + parentSize.y) / 2 - (dialogSize.y / 2);
		dialogShell.setLocation(location_X, location_Y);
		/*
		 * if(account.getTurqAccountingAccount().getAccountingAccountsId().intValue()==-1){ toolDelete.setEnabled(false);
		 * toolUpdate.setEnabled(false); }
		 */
	}

	public void fillBalances()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal credit = totals[0];
			BigDecimal dept = totals[1];
			BigDecimal balance = credit.subtract(dept);
			tableItemTotal.setText(new String[]{EngLangCommonKeys.STR_TOTAL, 
					cf.format(dept), cf.format(credit), (balance.doubleValue() <= 0) ? cf.format(balance.abs()) : "0", //$NON-NLS-1$
					(balance.doubleValue() > 0) ? cf.format(balance) : "0"}); //$NON-NLS-1$
			/*
			 * List list = blAccount.getTotalDeptAndCredit(account); if (list.size() > 0) { Object[] sums = (Object[]) list.get(0); if
			 * (sums[0] != null) { TurkishCurrencyFormat cf=new TurkishCurrencyFormat(); BigDecimal credit = (BigDecimal) sums[1];
			 * BigDecimal dept = (BigDecimal) sums[0]; BigDecimal balance = credit.subtract(dept); tableItemTotal.setText(new String[] {
			 * Messages.getString("AccUIAccountUpdate.4"), //$NON-NLS-1$ cf.format(dept), cf.format(credit), (balance.doubleValue() <= 0) ?
			 * cf.format(balance.abs()):"0", //$NON-NLS-1$ (balance.doubleValue() > 0)? cf.format(balance) : "0"}); //$NON-NLS-1$ } }
			 */
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt)
	{
		try
		{
			Integer accountId=(Integer)accountMap.get(AccKeys.ACC_ACCOUNT_ID);
			if (compAccountCard.verifyFields())
			{
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_ACCOUNT_ID, accountId);
				argMap.put(AccKeys.ACC_ACCOUNT_NAME,compAccountCard.getTxtAccAcountName().getText().trim());
				argMap.put(AccKeys.ACC_ACCOUNT_CODE,compAccountCard.getTxtAccAccountCode().getText().trim());
				argMap.put(AccKeys.ACC_PARENT_ID,compAccountCard.getTxtParentAccount().getData());
				
				EngTXCommon.doSelectTX(AccBLAccountUpdate.class.getName(),"updateAccount",argMap);						
				EngUICommon.showUpdatedSuccesfullyMessage(getParent());
				updateOccured = true;
				this.dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			boolean okToDelete=EngUICommon.okToDelete(getParent());
			if (okToDelete)
			{
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_ACCOUNT_ID,accountMap.get(AccKeys.ACC_ACCOUNT_ID));
				EngTXCommon.doTransactionTX(AccBLAccountUpdate.class.getName(),"deleteAccount",argMap);				
				EngUICommon.showDeletedSuccesfullyMessage(getParent());
				updateOccured = true;
				this.dialogShell.close();
				this.dialogShell.dispose();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}