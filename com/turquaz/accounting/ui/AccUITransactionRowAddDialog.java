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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.accounting.Messages;
import com.turquaz.accounting.ui.comp.AccountPicker;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.ui.component.CurrencyText;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AccUITransactionRowAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Button btnOk;
	private Button btnCancel;
	private CurrencyText decTextAmount;
	private CLabel lblTransactionDefinition;
	private Text txtTransactionDefinition;
	private CLabel lblAmount;
	private CLabel lbDeptOrCredit;
	private Composite composite1;
	private Label label1;
	private CCombo comboDeptOrCredit;
	private AccountPicker accountPicker;
	private CLabel lblAccount;
	private Shell dialogShell;
	private TurqAccountingTransactionColumn transactionRow;
	private int transactionType = 0;

	public AccUITransactionRowAddDialog(Shell parent, int style, int transType)
	{
		super(parent, style);
		transactionType = transType;
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
			dialogShell.setSize(369, 213);
			GridLayout dialogShellLayout = new GridLayout(2, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 2;
			dialogShellLayout.makeColumnsEqualWidth = false;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.setText(getText());
			lblAccount = new CLabel(dialogShell, SWT.NULL);
			accountPicker = new AccountPicker(dialogShell, SWT.NULL);
			lbDeptOrCredit = new CLabel(dialogShell, SWT.NULL);
			comboDeptOrCredit = new CCombo(dialogShell, SWT.READ_ONLY);
			lblAmount = new CLabel(dialogShell, SWT.NULL);
			decTextAmount = new CurrencyText(dialogShell, SWT.NULL);
			GridData lblAccountLData = new GridData();
			lblAccountLData.widthHint = 59;
			lblAccountLData.heightHint = 18;
			lblAccount.setLayoutData(lblAccountLData);
			lblAccount.setText(Messages.getString("AccUITransactionRowAddDialog.0")); //$NON-NLS-1$
			GridData accountPickerLData = new GridData();
			accountPickerLData.widthHint = 204;
			accountPickerLData.heightHint = 20;
			accountPicker.setLayoutData(accountPickerLData);
			accountPicker.layout();
			GridData lbDeptOrCreditLData = new GridData();
			lbDeptOrCreditLData.widthHint = 76;
			lbDeptOrCreditLData.heightHint = 18;
			lbDeptOrCredit.setLayoutData(lbDeptOrCreditLData);
			lbDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.1")); //$NON-NLS-1$
			GridData comboDeptOrCreditLData = new GridData();
			comboDeptOrCreditLData.verticalAlignment = GridData.CENTER;
			comboDeptOrCreditLData.horizontalAlignment = GridData.BEGINNING;
			comboDeptOrCreditLData.widthHint = 71;
			comboDeptOrCreditLData.heightHint = 17;
			comboDeptOrCreditLData.horizontalIndent = 0;
			comboDeptOrCreditLData.horizontalSpan = 1;
			comboDeptOrCreditLData.verticalSpan = 1;
			comboDeptOrCreditLData.grabExcessHorizontalSpace = false;
			comboDeptOrCreditLData.grabExcessVerticalSpace = false;
			comboDeptOrCredit.setLayoutData(comboDeptOrCreditLData);
			comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
			comboDeptOrCredit.setBackground(SWTResourceManager.getColor(255, 255, 255));
			comboDeptOrCredit.setSize(new org.eclipse.swt.graphics.Point(71, 17));
			GridData lblAmountLData = new GridData();
			lblAmountLData.widthHint = 62;
			lblAmountLData.heightHint = 19;
			lblAmount.setLayoutData(lblAmountLData);
			lblAmount.setText(Messages.getString("AccUITransactionRowAddDialog.3")); //$NON-NLS-1$
			GridData decTextAmountLData = new GridData();
			decTextAmountLData.widthHint = 155;
			decTextAmountLData.heightHint = 19;
			decTextAmount.setLayoutData(decTextAmountLData);
			{
				lblTransactionDefinition = new CLabel(dialogShell, SWT.NONE);
				lblTransactionDefinition.setText(Messages.getString("AccUITransactionRowAddDialog.2")); //$NON-NLS-1$
			}
			{
				txtTransactionDefinition = new Text(dialogShell, SWT.MULTI | SWT.V_SCROLL);
				GridData txtTransactionDefinitionLData = new GridData();
				txtTransactionDefinition.setTextLimit(250);
				txtTransactionDefinitionLData.heightHint = 22;
				txtTransactionDefinitionLData.horizontalAlignment = GridData.FILL;
				txtTransactionDefinition.setLayoutData(txtTransactionDefinitionLData);
			}
			{
				label1 = new Label(dialogShell, SWT.SEPARATOR | SWT.HORIZONTAL);
				label1.setText("label1"); //$NON-NLS-1$
				GridData label1LData = new GridData();
				label1LData.horizontalSpan = 2;
				label1LData.horizontalAlignment = GridData.FILL;
				label1LData.grabExcessHorizontalSpace = true;
				label1.setLayoutData(label1LData);
			}
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.widthHint = 140;
				composite1LData.heightHint = 59;
				composite1LData.horizontalAlignment = GridData.END;
				composite1LData.horizontalSpan = 2;
				composite1.setLayoutData(composite1LData);
				composite1Layout.makeColumnsEqualWidth = true;
				composite1Layout.numColumns = 2;
				composite1.setLayout(composite1Layout);
				{
					btnOk = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnOkLData = new GridData();
					btnOkLData.horizontalAlignment = GridData.END;
					btnOkLData.verticalSpan = 2;
					btnOkLData.grabExcessHorizontalSpace = true;
					btnOkLData.grabExcessVerticalSpace = true;
					btnOkLData.widthHint = 62;
					btnOkLData.heightHint = 34;
					btnOk.setLayoutData(btnOkLData);
					btnOk.setText(Messages.getString("AccUITransactionRowAddDialog.5")); //$NON-NLS-1$
					btnOk.setImage(SWTResourceManager.getImage("icons/Ok24.gif")); //$NON-NLS-1$
					btnOk.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnOkMouseUp(evt);
						}
					});
				}
				{
					btnCancel = new Button(composite1, SWT.PUSH | SWT.CENTER);
					GridData btnCancelLData = new GridData();
					btnCancelLData.widthHint = 61;
					btnCancelLData.heightHint = 33;
					btnCancelLData.verticalSpan = 2;
					btnCancelLData.grabExcessVerticalSpace = true;
					btnCancel.setLayoutData(btnCancelLData);
					btnCancel.setText(Messages.getString("AccUITransactionRowAddDialog.4")); //$NON-NLS-1$
					btnCancel.setImage(SWTResourceManager.getImage("icons/Cancel24.gif")); //$NON-NLS-1$
					btnCancel.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnCancelMouseUp(evt);
						}
					});
				}
			}
			dialogShell.addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
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
		transactionRow = null;
		if (transactionType == 2)
		{
			comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
			comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
			comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
		}
		else if (transactionType == 1)
		{
			comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.6")); //$NON-NLS-1$
			comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.10")); //$NON-NLS-1$
		}
		else if (transactionType == 0)
		{
			comboDeptOrCredit.setText(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
			comboDeptOrCredit.add(Messages.getString("AccUITransactionRowAddDialog.7")); //$NON-NLS-1$
		}
	}

	public Object showDialog()
	{
		this.open();
		return transactionRow;
	}

	boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
		if (accountPicker.getData() == null)
		{
			msg.setMessage(Messages.getString("AccUITransactionRowAddDialog.13")); //$NON-NLS-1$
			msg.open();
			accountPicker.setFocus();
			return false;
		}
		else if (decTextAmount.getBigDecimalValue().toString().equals("0")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("AccUITransactionRowAddDialog.15")); //$NON-NLS-1$
			msg.open();
			decTextAmount.setFocus();
			return false;
		}
		return true;
	}

	/** Auto-generated event handler method */
	protected void btnOkMouseUp(MouseEvent evt)
	{
		if (verifyFields())
		{
			transactionRow = new TurqAccountingTransactionColumn();
			transactionRow.setTurqAccountingAccount((TurqAccountingAccount) accountPicker.getData());
			transactionRow.setTransactionDefinition(txtTransactionDefinition.getText().trim());
			if (comboDeptOrCredit.getText().equals(Messages.getString("AccUITransactionRowAddDialog.6"))) { //$NON-NLS-1$
				transactionRow.setCreditAmount(new BigDecimal(0));
				transactionRow.setDeptAmount(decTextAmount.getBigDecimalValue());
			}
			else
			{
				transactionRow.setDeptAmount(new BigDecimal(0));
				transactionRow.setCreditAmount(decTextAmount.getBigDecimalValue());
			}
			this.dialogShell.dispose();
		}
	}

	/** Auto-generated event handler method */
	protected void btnCancelMouseUp(MouseEvent evt)
	{
		this.dialogShell.dispose();
	}
}