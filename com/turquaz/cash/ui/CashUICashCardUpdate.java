package com.turquaz.cash.ui;

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
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashCardUpdate;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqCashCard;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * *************************************
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
 * for this machine, so Jigloo or this code cannot be used legally
 * for any corporate or commercial purpose.
 * *************************************
 */
/**
 * @author onsel
 * @version $Id$
 */
public class CashUICashCardUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private CashUICashCardAdd compCashCard;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	TurqCashCard cashCard;

	public CashUICashCardUpdate(Shell parent, int style, TurqCashCard card)
	{
		super(parent, style);
		cashCard = card;
	}

	public void open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.setText(Messages.getString("CashUICashCardUpdate.5")); //$NON-NLS-1$
			dialogShell.setSize(563, 228);
			{
				coolBar1 = new CoolBar(dialogShell, SWT.NONE);
				GridData coolBar1LData = new GridData();
				coolBar1LData.heightHint = 40;
				coolBar1LData.grabExcessHorizontalSpace = true;
				coolBar1LData.horizontalAlignment = GridData.FILL;
				coolBar1.setLayoutData(coolBar1LData);
				{
					coolItem1 = new CoolItem(coolBar1, SWT.NONE);
					coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 41));
					coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 41));
					coolItem1.setSize(45, 41);
					{
						toolBar1 = new ToolBar(coolBar1, SWT.NONE);
						coolItem1.setControl(toolBar1);
						{
							toolUpdate = new ToolItem(toolBar1, SWT.NONE);
							toolUpdate.setText(Messages.getString("CashUICashCardUpdate.0")); //$NON-NLS-1$
							toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
							toolUpdate.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolUpdateSelected();
								}
							});
						}
						{
							toolDelete = new ToolItem(toolBar1, SWT.NONE);
							toolDelete.setText(Messages.getString("CashUICashCardUpdate.2")); //$NON-NLS-1$
							toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
							toolDelete.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolDeleteSelected();
								}
							});
						}
						{
							toolCancel = new ToolItem(toolBar1, SWT.NONE);
							toolCancel.setText(Messages.getString("CashUICashCardUpdate.4")); //$NON-NLS-1$
							toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
							toolCancel.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									toolCancelSelected();
								}
							});
						}
					}
				}
			}
			{
				compCashCard = new CashUICashCardAdd(dialogShell, SWT.NONE);
				GridData compCashCardLData = new GridData();
				compCashCardLData.widthHint = 521;
				compCashCardLData.heightHint = 126;
				compCashCard.setLayoutData(compCashCardLData);
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

	public void postInitGUI()
	{
		compCashCard.getTxtCardCode().setText(cashCard.getCashCardName());
		compCashCard.getTxtDefinition().setText(cashCard.getCashCardDefinition());
		compCashCard.getAccountPicker().setData(cashCard.getTurqAccountingAccount());
	}

	public void toolDeleteSelected()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.ICON_INFORMATION);
		try
		{
			CashBLCashCardUpdate.delete(cashCard);
			msg.setMessage(Messages.getString("CashUICashCardUpdate.1")); //$NON-NLS-1$
			msg.open();
			dialogShell.close();
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void toolCancelSelected()
	{
		dialogShell.close();
	}

	public void toolUpdateSelected()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.ICON_INFORMATION);
		try
		{
			if (compCashCard.verifyFields())
			{
				CashBLCashCardUpdate.updateCashCard(cashCard, compCashCard.getTxtCardCode().getText().trim(), compCashCard
						.getTxtDefinition().getText().trim(), (TurqAccountingAccount) compCashCard.getAccountPicker().getData());
				msg.setMessage(Messages.getString("CashUICashCardUpdate.3")); //$NON-NLS-1$
				msg.open();
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
}