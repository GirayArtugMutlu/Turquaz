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
/**
 * @author  Onsel
 * @version  $Id$
 */
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashCardAdd;
import org.eclipse.swt.widgets.MessageBox;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.CashAccountPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.SecureComposite;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashUICashCardAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblCardName;
	private CLabel lblCardDefinition;
	private Text txtDefinition;
	private CashAccountPicker accountPicker;
	private CLabel lblAccountingCode;
	private Text txtCardCode;

	public CashUICashCardAdd(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(539, 251);
			{
				lblCardName = new CLabel(this, SWT.NONE);
				lblCardName.setText(Messages.getString("CashUICashCardAdd.0")); //$NON-NLS-1$
			}
			{
				txtCardCode = new Text(this, SWT.NONE);
				GridData txtCardCodeLData = new GridData();
				txtCardCodeLData.widthHint = 155;
				txtCardCodeLData.heightHint = 15;
				txtCardCode.setLayoutData(txtCardCodeLData);
			}
			{
				lblCardDefinition = new CLabel(this, SWT.NONE);
				lblCardDefinition.setText(Messages.getString("CashUICashCardAdd.1")); //$NON-NLS-1$
			}
			{
				txtDefinition = new Text(this, SWT.NONE);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 390;
				txtDefinitionLData.heightHint = 15;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			{
				lblAccountingCode = new CLabel(this, SWT.NONE);
				lblAccountingCode.setText(Messages.getString("CashUICashCardAdd.2")); //$NON-NLS-1$
			}
			{
				accountPicker = new CashAccountPicker(this, SWT.NONE);
				GridData accountPickerLData = new GridData();
				accountPicker.setSize(161, 15);
				accountPickerLData.widthHint = 161;
				accountPickerLData.heightHint = 15;
				accountPicker.setLayoutData(accountPickerLData);
			}
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void newForm()
	{
		CashUICashCardAdd curCard = new CashUICashCardAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void save()
	{
		MessageBox msg = new MessageBox(getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_NAME,txtCardCode.getText().trim());
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText().trim());
				argMap.put(AccKeys.ACC_ACCOUNT,(TurqAccountingAccount) accountPicker.getData());
				EngTXCommon.doTransactionTX(CashBLCashCardAdd.class.getName(),"saveCashCard",argMap);
				
				msg.setMessage(Messages.getString("CashUICashCardAdd.3")); //$NON-NLS-1$
				msg.open();
				EngBLCashCards.RefreshContentAsistantMap();
				newForm();
			}
		}
		catch (Exception ex)
		{
			msg.setMessage(ex.getMessage());
			msg.open();
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (txtCardCode.getText().trim().equals("")) { //$NON-NLS-1$
			msg.setMessage(Messages.getString("CashUICashCardAdd.5")); //$NON-NLS-1$
			msg.open();
			txtCardCode.setFocus();
			return false;
		}
		else if (accountPicker.getData() == null)
		{
			msg.setMessage(Messages.getString("CashUICashCardAdd.6")); //$NON-NLS-1$
			msg.open();
			accountPicker.setFocus();
			return false;
		}
		return true;
	}

	public CashAccountPicker getAccountPicker()
	{
		return accountPicker;
	}

	public void setAccountPicker(CashAccountPicker accountPicker)
	{
		this.accountPicker = accountPicker;
	}

	public Text getTxtCardCode()
	{
		return txtCardCode;
	}

	public void setTxtCardCode(Text txtCardCode)
	{
		this.txtCardCode = txtCardCode;
	}

	public Text getTxtDefinition()
	{
		return txtDefinition;
	}

	public void setTxtDefinition(Text txtDefinition)
	{
		this.txtDefinition = txtDefinition;
	}
}