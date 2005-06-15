package com.turquaz.cheque.ui;

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
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.ui.component.DatePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUICustomerChequeAddDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CLabel lblPortfolioNo;
	private CurrencyText curText;
	private CLabel lblBankAccount;
	private CCombo comboCurrencyType;
	private CLabel lblCurrency;
	private Text txtBankAccountNO;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;
	private CLabel lblAmount;
	private Text txtPaymentPlace;
	private CLabel lblPaymentPlace;
	private CLabel lblBankName;
	private Text txtDeptor;
	private CLabel lblDeptor;
	private DatePicker datePickValueDate;
	private CLabel lblDueDate;
	private Text txtBankBranch;
	private CLabel lblBankBranch;
	private Text txtBankName;
	private Text txtChequeNo;
	private CLabel lblChequeNo;
	private Text txtPortfoyNo;
	private HashMap chequeInfo = null;
	

	public CheUICustomerChequeAddDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public HashMap open(HashMap cheque)
	{
		this.chequeInfo = cheque;
		return open();
	}

	public HashMap open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.numColumns = 2;
			dialogShell.layout();
			dialogShell.setText(CheLangKeys.TITLE_CUSTOMER_CHEQUE_ADD); //$NON-NLS-1$
			dialogShell.pack();
			dialogShell.setSize(612, 337);
			{
				toolBar1 = new ToolBar(dialogShell, SWT.NONE);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.horizontalSpan = 2;
				toolBar1.setLayoutData(toolBar1LData);
				{
					toolSave = new ToolItem(toolBar1, SWT.NONE);
					toolSave.setText(EngLangCommonKeys.STR_SAVE); //$NON-NLS-1$
					toolSave.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
					toolSave.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							save();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(EngLangCommonKeys.STR_CANCEL); //$NON-NLS-1$
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
			{
				lblPortfolioNo = new CLabel(dialogShell, SWT.NONE);
				lblPortfolioNo.setText(CheLangKeys.STR_PORTFOLIO_NO); //$NON-NLS-1$
			}
			{
				txtPortfoyNo = new Text(dialogShell, SWT.NONE);
				GridData txtPortfoyNoLData = new GridData();
				txtPortfoyNoLData.widthHint = 150;
				txtPortfoyNoLData.heightHint = 17;
				txtPortfoyNo.setLayoutData(txtPortfoyNoLData);
			}
			{
				lblChequeNo = new CLabel(dialogShell, SWT.NONE);
				lblChequeNo.setText(CheLangKeys.STR_CHEQUE_NO); //$NON-NLS-1$
			}
			{
				txtChequeNo = new Text(dialogShell, SWT.NONE);
				GridData txtChequeNoLData = new GridData();
				txtChequeNoLData.widthHint = 150;
				txtChequeNoLData.heightHint = 17;
				txtChequeNo.setLayoutData(txtChequeNoLData);
			}
			{
				lblBankName = new CLabel(dialogShell, SWT.NONE);
				lblBankName.setText(CheLangKeys.STR_BANK_NAME); //$NON-NLS-1$
			}
			{
				txtBankName = new Text(dialogShell, SWT.NONE);
				GridData txtBankNameLData = new GridData();
				txtBankNameLData.widthHint = 150;
				txtBankNameLData.heightHint = 17;
				txtBankName.setLayoutData(txtBankNameLData);
			}
			{
				lblBankBranch = new CLabel(dialogShell, SWT.NONE);
				lblBankBranch.setText(CheLangKeys.STR_BANK_BRANCH); //$NON-NLS-1$
			}
			{
				txtBankBranch = new Text(dialogShell, SWT.NONE);
				GridData txtBankBranchLData = new GridData();
				txtBankBranchLData.widthHint = 150;
				txtBankBranchLData.heightHint = 17;
				txtBankBranch.setLayoutData(txtBankBranchLData);
			}
			//START >> lblBankAccount
			lblBankAccount = new CLabel(dialogShell, SWT.NONE);
			lblBankAccount.setText(CheLangKeys.STR_BANK_ACCOUNT_NO); //$NON-NLS-1$
			//END << lblBankAccount
			//START >> txtBankAccountNO
			txtBankAccountNO = new Text(dialogShell, SWT.NONE);
			GridData txtBankAccountNOLData = new GridData();
			txtBankAccountNOLData.widthHint = 150;
			txtBankAccountNOLData.heightHint = 17;
			txtBankAccountNO.setLayoutData(txtBankAccountNOLData);
			//END << txtBankAccountNO
			{
				lblDueDate = new CLabel(dialogShell, SWT.NONE);
				lblDueDate.setText(EngLangCommonKeys.STR_DUE_DATE); //$NON-NLS-1$
			}
			{
				datePickValueDate = new DatePicker(dialogShell, SWT.NONE);
				GridData datePickValueDateLData = new GridData();
				datePickValueDateLData.widthHint = 157;
				datePickValueDateLData.heightHint = 23;
				datePickValueDate.setLayoutData(datePickValueDateLData);
			}
			{
				lblDeptor = new CLabel(dialogShell, SWT.NONE);
				lblDeptor.setText(CheLangKeys.STR_DEPTOR); //$NON-NLS-1$
				GridData lblDeptorLData = new GridData();
				lblDeptorLData.widthHint = 42;
				lblDeptorLData.heightHint = 19;
				lblDeptor.setLayoutData(lblDeptorLData);
			}
			{
				txtDeptor = new Text(dialogShell, SWT.NONE);
				GridData txtDeptorLData = new GridData();
				txtDeptorLData.widthHint = 150;
				txtDeptorLData.heightHint = 17;
				txtDeptor.setLayoutData(txtDeptorLData);
			}
			{
				lblPaymentPlace = new CLabel(dialogShell, SWT.NONE);
				lblPaymentPlace.setText(CheLangKeys.STR_PAYMENT_PLACE); //$NON-NLS-1$
			}
			{
				txtPaymentPlace = new Text(dialogShell, SWT.NONE);
				GridData txtPaymentPlaceLData = new GridData();
				txtPaymentPlaceLData.widthHint = 150;
				txtPaymentPlaceLData.heightHint = 17;
				txtPaymentPlace.setLayoutData(txtPaymentPlaceLData);
			}
			{
				lblAmount = new CLabel(dialogShell, SWT.NONE);
				lblAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
			}
			{
				curText = new CurrencyText(dialogShell, SWT.NONE);
				GridData curTextLData = new GridData();
				curTextLData.widthHint = 150;
				curTextLData.heightHint = 17;
				curText.setLayoutData(curTextLData);
			}
			//START >> lblCurrency
			lblCurrency = new CLabel(dialogShell, SWT.NONE);
			lblCurrency.setText("Para Birimi");
			//END << lblCurrency
			//START >> comboCurrencyType
			comboCurrencyType = new CCombo(dialogShell, SWT.NONE);
			GridData comboCurrencyTypeLData = new GridData();
			comboCurrencyTypeLData.widthHint = 135;
			comboCurrencyTypeLData.heightHint = 17;
			comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
			//END << comboCurrencyType
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return chequeInfo;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return null;
		}
	}

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		fillCurrencyCombo();
		if (chequeInfo != null)
		{
			txtBankBranch.setText((String)chequeInfo.get(BankKeys.BANK_BRANCH_NAME));
			txtBankName.setText((String)chequeInfo.get(BankKeys.BANK_NAME));
			txtChequeNo.setText((String)chequeInfo.get(CheKeys.CHE_CHEQUE_NO));
			txtDeptor.setText((String)chequeInfo.get(CheKeys.CHE_DEBTOR));
			txtPaymentPlace.setText((String)chequeInfo.get(CheKeys.CHE_PAYMENT_PLACE));
			txtPortfoyNo.setText((String)chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO));
			datePickValueDate.setDate((Date)chequeInfo.get(EngKeys.DATE));
			curText.setText((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
			if (chequeInfo.get(BankKeys.BANK_ACCOUNT_NO) != null)
			{
				txtBankAccountNO.setText(chequeInfo.get(BankKeys.BANK_ACCOUNT_NO).toString());
			}
		}
	}

	public void fillCurrencyCombo()
	{
		try
		{
			HashBag currencyBag = (HashBag)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getCurrencies",null);
			HashMap currencies = (HashMap)currencyBag.get(EngKeys.CURRENCIES);
			
			for (int k = 0; k < currencies.size(); k++)
			{
					HashMap currencyMap=(HashMap)currencies.get(new Integer(k));

					String abbr=(String)currencyMap.get(EngKeys.CURRENCY_ABBR);
					comboCurrencyType.add(abbr);
					comboCurrencyType.setData(abbr,currencyMap.get(EngKeys.CURRENCY_ID));
				
					if (((Boolean)currencyMap.get(EngKeys.DEFAULT)).booleanValue())
					{
						comboCurrencyType.setText((String)currencyMap.get(EngKeys.CURRENCY_ABBR));
					}
				}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public boolean verifyFields()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			if (curText.getBigDecimalValue().equals(new BigDecimal(0)))
			{
				msg.setMessage("Tutar girmelisiniz!");
				msg.open();
				curText.setFocus();
				return false;
			}
			else if ( comboCurrencyType.getData(comboCurrencyType.getText()) == null)
			{
				msg.setMessage("Para birimi seçmelisiniz!");
				msg.open();
				comboCurrencyType.setFocus();
				return false;
			}
			
			return true;
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
			return false;
		}
	}

	public void save()
	{
		if (verifyFields())
		{
			if (chequeInfo == null)
			{
				chequeInfo = new HashMap();
			}
			chequeInfo.put(EngKeys.TYPE_ID,new Integer(EngBLCommon.CHEQUE_TYPE_CUSTOMER));
			chequeInfo.put(BankKeys.BANK_BRANCH_NAME,txtBankBranch.getText().trim());
			chequeInfo.put(BankKeys.BANK_NAME,txtBankName.getText().trim());
			chequeInfo.put(CheKeys.CHE_PORTFOLIO_NO,txtPortfoyNo.getText().trim());
			chequeInfo.put(CheKeys.CHE_CHEQUE_NO,txtChequeNo.getText().trim());
			chequeInfo.put(EngKeys.DATE,datePickValueDate.getDate());
			chequeInfo.put(CheKeys.CHE_DEBTOR,txtDeptor.getText().trim());
			chequeInfo.put(CheKeys.CHE_PAYMENT_PLACE,txtPaymentPlace.getText().trim());
			chequeInfo.put(EngKeys.TOTAL_AMOUNT,curText.getBigDecimalValue());
			chequeInfo.put(BankKeys.BANK_ACCOUNT_NO,txtBankAccountNO.getText().trim());
			// TODO Exchane Rate
			
			chequeInfo.put(EngKeys.CURRENCY_ID,EngBLClient.getBaseCurrencyId());
			chequeInfo.put(BankKeys.BANK_ID,new Integer(-1));
			
			dialogShell.close();
		}
	}
}