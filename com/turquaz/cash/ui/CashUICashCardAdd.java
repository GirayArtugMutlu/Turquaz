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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashCardAdd;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.CashAccountPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Composite;

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
	private Composite compCardInfo;
	private CTabItem cTabItem1;
	private CTabFolder TabFolderCardInfo;
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
			this.setSize(527, 147);
			//START >>  TabFolderCardInfo
			TabFolderCardInfo = new CTabFolder(this, SWT.NONE);
			//START >>  cTabItem1
			cTabItem1 = new CTabItem(TabFolderCardInfo, SWT.NONE);
			cTabItem1.setText(CashLangKeys.STR_CASH_CARD_INFO);
			//START >>  compCardInfo
			compCardInfo = new Composite(TabFolderCardInfo, SWT.NONE);
			GridLayout compCardInfoLayout = new GridLayout();
			compCardInfoLayout.numColumns = 2;
			compCardInfo.setLayout(compCardInfoLayout);
			cTabItem1.setControl(compCardInfo);
			{
				lblCardName = new CLabel(compCardInfo, SWT.NONE);
				lblCardName.setText(CashLangKeys.STR_CASH_CODE);
			}
			{
				txtCardCode = new Text(compCardInfo, SWT.NONE);
				GridData txtCardCodeLData = new GridData();
				txtCardCodeLData.widthHint = 150;
				txtCardCodeLData.heightHint = 17;
				txtCardCode.setLayoutData(txtCardCodeLData);
			}
			{
				lblAccountingCode = new CLabel(compCardInfo, SWT.NONE);
				lblAccountingCode.setText(AccLangKeys.STR_ACCOUNTING_ACCOUNT);
			}
			{
				accountPicker = new CashAccountPicker(compCardInfo, SWT.NONE);
				GridData accountPickerLData = new GridData();
				accountPickerLData.widthHint = 157;
				accountPickerLData.heightHint = 17;
				accountPicker.setLayoutData(accountPickerLData);
			}
			{
				lblCardDefinition = new CLabel(compCardInfo, SWT.NONE);
				lblCardDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
			}
			{
				txtDefinition = new Text(compCardInfo, SWT.WRAP | SWT.V_SCROLL);
				GridData txtDefinitionLData = new GridData();
				txtDefinitionLData.widthHint = 315;
				txtDefinitionLData.heightHint = 37;
				txtDefinition.setLayoutData(txtDefinitionLData);
			}
			//END <<  compCardInfo
			TabFolderCardInfo.setSelection(0);
			GridData TabFolderCardInfoLData = new GridData();
			TabFolderCardInfoLData.grabExcessHorizontalSpace = true;
			TabFolderCardInfoLData.grabExcessVerticalSpace = true;
			TabFolderCardInfoLData.horizontalAlignment = GridData.FILL;
			TabFolderCardInfoLData.verticalAlignment = GridData.FILL;
			TabFolderCardInfo.setLayoutData(TabFolderCardInfoLData);
			//END <<  cTabItem1
			//END <<  TabFolderCardInfo
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
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
		try
		{
			if (verifyFields())
			{
				
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_NAME,txtCardCode.getText().trim());
				argMap.put(EngKeys.DEFINITION, txtDefinition.getText().trim());
				argMap.put(AccKeys.ACC_ACCOUNT,(TurqAccountingAccount) accountPicker.getData());
				EngTXCommon.doTransactionTX(CashBLCashCardAdd.class.getName(),"saveCashCard",argMap);	
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		if (txtCardCode.getText().trim().equals(""))
		{ 
			EngUICommon.showMessageBox(getShell(),CashLangKeys.MSG_ENTER_CASH_CODE,SWT.ICON_WARNING);
			txtCardCode.setFocus();
			return false;
		}
		else if (accountPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(),AccLangKeys.MSG_SELECT_ACCOUNTING_ACCOUNT,SWT.ICON_WARNING);
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