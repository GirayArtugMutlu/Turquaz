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
import java.util.HashMap;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;
import com.cloudgarden.resource.SWTResourceManager;

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
public class AccUIAddAccounts extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * @return Returns the txtAccAccountCode.
	 */
	public Text getTxtAccAccountCode()
	{
		return txtAccAccountCode;
	}

	/**
	 * @return Returns the txtAccAcountName.
	 */
	public Text getTxtAccAcountName()
	{
		return txtAccAcountName;
	}

	/**
	 * @return Returns the txtParentAccount.
	 */
	public Text getTxtParentAccount()
	{
		return txtParentAccount;
	}
	private CLabel lblAccountCode;
	private Text txtAccAcountName;
	private CLabel lblAccountName;
	private CTabItem cTabItem1;
	private CTabFolder TabFolderAccounts;
	private Composite compAccounting;
	private Text txtParentAccount;
	private CLabel lblParentAccount;
	private Text txtAccAccountCode;

	public AccUIAddAccounts(Composite parent, int style)
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
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			this.setSize(441, 149);
			//START >>  TabFolderAccounts
			TabFolderAccounts = new CTabFolder(this, SWT.NONE);
			//START >>  cTabItem1
			cTabItem1 = new CTabItem(TabFolderAccounts, SWT.NONE);
			cTabItem1.setText("Hesap Bilgileri");
			//START >>  compAccounting
			compAccounting = new Composite(TabFolderAccounts, SWT.NONE);
			cTabItem1.setControl(compAccounting);
			GridLayout compAccountingLayout = new GridLayout();
			GridData compAccountingLData = new GridData();
			compAccountingLData.horizontalAlignment = GridData.FILL;
			compAccountingLData.verticalAlignment = GridData.FILL;
			compAccounting.setLayoutData(compAccountingLData);
			compAccountingLayout.numColumns = 2;
			compAccounting.setLayout(compAccountingLayout);
			{
				lblParentAccount = new CLabel(compAccounting, SWT.NONE);
				GridData cLabel2LData = new GridData();
				lblParentAccount.setText(AccLangKeys.STR_PARENT_ACCOUNT);
				lblParentAccount.setLayoutData(cLabel2LData);
			}
			{
				txtParentAccount = new Text(compAccounting, SWT.NONE);
				GridData txtParentAccountLData = new GridData();
				txtParentAccount.addModifyListener(new ModifyListener()
				{
					public void modifyText(ModifyEvent evt)
					{
						try
						{
							HashMap accountMap=EngBLAccountingAccounts.getAccount(txtParentAccount
									.getText().trim());
							if (accountMap !=null)
							{
								txtParentAccount.setData(accountMap.get(AccKeys.ACC_ACCOUNT_ID));
							}
							if (txtParentAccount.getData() != null)
							{
								if (((Integer) txtParentAccount.getData()).intValue() != -1)
									txtAccAccountCode.setText(txtParentAccount.getText().trim() + " ");
							}
							else
							{
								txtAccAccountCode.setText("");
							}
						}
						catch (Exception ex)
						{
							EngBLLogger.log(this.getClass(), ex, getShell());
						}
					}
				});
				txtParentAccountLData.widthHint = 200;
				txtParentAccountLData.heightHint = 17;
				txtParentAccount.setLayoutData(txtParentAccountLData);
				txtParentAccount.setEnabled(true);
			}
			{
				lblAccountCode = new CLabel(compAccounting, SWT.NONE);
				lblAccountCode.setSize(new org.eclipse.swt.graphics.Point(83, 17));
				GridData cLabel1LData = new GridData();
				lblAccountCode.setText(AccLangKeys.STR_ACCOUNT_CODE);
				cLabel1LData.widthHint = 83;
				cLabel1LData.heightHint = 17;
				lblAccountCode.setLayoutData(cLabel1LData);
			}
			{
				txtAccAccountCode = new Text(compAccounting, SWT.NONE);
				GridData txtAccAccountCodeLData = new GridData();
				txtAccAccountCodeLData.widthHint = 200;
				txtAccAccountCodeLData.heightHint = 17;
				txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			}
			//START >>  lblAccountName
			lblAccountName = new CLabel(compAccounting, SWT.NONE);
			lblAccountName.setText("Hesap Ad\u0131");
			//END <<  lblAccountName
			{
				txtAccAcountName = new Text(compAccounting, SWT.NONE);
				GridData txtAccAcountNameLData = new GridData();
				txtAccAcountNameLData.widthHint = 200;
				txtAccAcountNameLData.heightHint = 17;
				txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			}
			//END <<  compAccounting
			TabFolderAccounts.setSelection(0);
			GridData TabFolderAccountsLData = new GridData();
			TabFolderAccountsLData.grabExcessHorizontalSpace = true;
			TabFolderAccountsLData.grabExcessVerticalSpace = true;
			TabFolderAccountsLData.horizontalAlignment = GridData.FILL;
			TabFolderAccountsLData.verticalAlignment = GridData.FILL;
			TabFolderAccounts.setLayoutData(TabFolderAccountsLData);
			//END <<  cTabItem1
			//END <<  TabFolderAccounts
			final Color txtAccAccountCodebackground = new Color(Display.getDefault(), 255, 255, 255);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 20;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
					txtAccAccountCodebackground.dispose();
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
			EngBLLogger.log(this.getClass(), e, getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}
	/** Add your post-init code in here */
	TextContentAssistSubjectAdapter adapter;
	TurquazContentAssistant asistant;

	public void postInitGUI()
	{
		adapter = new TextContentAssistSubjectAdapter(txtParentAccount);
		asistant = new TurquazContentAssistant(adapter, 0);
	}

	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			boolean valid = false;
			if (txtAccAccountCode.getText().trim().equals(""))
			{
				msg.setMessage(AccLangKeys.MSG_PLEASE_FILL_ACCOUNT_CODE);
				msg.open();
				this.txtAccAccountCode.setFocus();
				return false;
			}
			else if (txtParentAccount.getData() == null)
			{
				msg.setMessage(AccLangKeys.MSG_PLEASE_ENTER_PARENT_ACCOUNT);
				msg.open();
				this.txtParentAccount.setFocus();
				return false;
			}
			Integer parentId = (Integer) txtParentAccount.getData();
			if (parentId.intValue() != -1)
			{
				if (!txtAccAccountCode.getText().startsWith(txtParentAccount.getText().trim()))
				{
					msg.setMessage(AccLangKeys.MSG_ACCOUNT_CODE_SHOULD_START_WITH_PARENT_ACCOUNT);
					msg.open();
					txtAccAccountCode.setText(txtParentAccount.getText().trim().concat(" "));
					txtAccAccountCode.setFocus();
					txtAccAccountCode.setSelection(txtParentAccount.getText().trim().length() + 1);
					return false;
				}
			}
			return true;
		}
		catch (Exception ex)
		{
			return false;
		}
	}

	public void clearFields()
	{
		txtAccAccountCode.setText(""); //$NON-NLS-1$
		txtAccAcountName.setText(""); //$NON-NLS-1$
		txtParentAccount.setFocus();
		txtParentAccount.setSelection(txtParentAccount.getText().length());
	}

	public Integer saveAccount()
	{
		try
		{
			String accountName = txtAccAcountName.getText().trim();
			String accountCode = txtAccAccountCode.getText().trim();
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_NAME, accountName);
			argMap.put(AccKeys.ACC_ACCOUNT_CODE, accountCode);
			argMap.put(AccKeys.ACC_PARENT_ID, txtParentAccount.getData());
			Integer accountId = (Integer) EngTXCommon.doTransactionTX(AccBLAccountAdd.class.getName(),
					"saveAccount", argMap);
			EngUICommon.showSavedSuccesfullyMessage(getShell());
			clearFields();
			return accountId;
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getShell());
			return null;
		}
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				Integer parentId = (Integer) txtParentAccount.getData();
				String accountName = txtAccAcountName.getText().trim();
				String accountCode = txtAccAccountCode.getText().trim();
				
				HashMap argMap = new HashMap();
				argMap.put(AccKeys.ACC_ACCOUNT_NAME, accountName);
				argMap.put(AccKeys.ACC_ACCOUNT_CODE, accountCode);
				argMap.put(AccKeys.ACC_PARENT_ID, parentId);
				EngTXCommon.doTransactionTX(AccBLAccountAdd.class.getName(), "saveAccount", argMap);
				clearFields();
			}
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getShell());
		}
	}

	public void search()
	{
	}

	public void delete()
	{
	}

	public void newForm()
	{
		clearFields();
	}
}