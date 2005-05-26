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
import java.util.Calendar;
import java.util.HashMap;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.bl.CheBLUpdateCheque;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.lang.BankLangKeys;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.ui.component.DatePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabItem;
import com.turquaz.bank.ui.comp.BankCardPicker;
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
public class CheUIOwnChequeUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CurrencyText curText;
	private Composite compCheq;
	private CTabItem cTabItem1;
	private CTabFolder tabFolder;
	private ToolItem toolDelete;
	private Text txtChequeNo;
	private CLabel lblChequeNo;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;
	private CLabel lblAmount;
	private Text txtPaymentPlace;
	private CLabel lblPaymentPlace;
	private CLabel lblBankName;
	private DatePicker datePickValueDate;
	private CLabel lblDueDate;
	private BankCardPicker bankPicker;
	TurqChequeCheque cheque = null;
	boolean isUpdated = false;

	public CheUIOwnChequeUpdate(Shell parent, int style, TurqChequeCheque cheque)
	{
		super(parent, style);
		this.cheque = cheque;
	}

	public boolean open()
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
			
			dialogShell.setText(CheLangKeys.TITLE_OWN_CHEQUE_UPDATE); //$NON-NLS-1$
			dialogShell.setSize(507, 303);
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
							update();
						}
					});
				}
				//START >> toolDelete
				toolDelete = new ToolItem(toolBar1, SWT.NONE);
				toolDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
				toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
				toolDelete.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						toolDeleteWidgetSelected(evt);
					}
				});
				//END << toolDelete
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
			//START >> tabFolder
			tabFolder = new CTabFolder(dialogShell, SWT.NONE);
			//START >> cTabItem1
			cTabItem1 = new CTabItem(tabFolder, SWT.NONE);
			cTabItem1.setText(CheLangKeys.STR_CHEQUE_INFO); //$NON-NLS-1$
			//START >> compCheq
			compCheq = new Composite(tabFolder, SWT.NONE);
			GridLayout compCheqLayout = new GridLayout();
			compCheqLayout.numColumns = 2;
			compCheq.setLayout(compCheqLayout);
			cTabItem1.setControl(compCheq);
			{
				lblChequeNo = new CLabel(compCheq, SWT.NONE);
				lblChequeNo.setText(CheLangKeys.STR_CHEQUE_NO); //$NON-NLS-1$
				GridData lblChequeNoLData = new GridData();
				lblChequeNoLData.widthHint = 71;
				lblChequeNoLData.heightHint = 19;
				lblChequeNo.setLayoutData(lblChequeNoLData);
			}
			{
				txtChequeNo = new Text(compCheq, SWT.NONE);
				GridData txtChequeNoLData = new GridData();
				txtChequeNoLData.widthHint = 150;
				txtChequeNoLData.heightHint = 17;
				txtChequeNo.setLayoutData(txtChequeNoLData);
			}
			{
				lblBankName = new CLabel(compCheq, SWT.NONE);
				lblBankName.setText(BankLangKeys.STR_BANK_CARD); //$NON-NLS-1$
			}
			{
				bankPicker = new BankCardPicker(compCheq, SWT.NONE);
				GridData txtBankNameLData = new GridData();
				txtBankNameLData.widthHint = 157;
				txtBankNameLData.heightHint = 17;
				bankPicker.setLayoutData(txtBankNameLData);
			}
			{
				lblDueDate = new CLabel(compCheq, SWT.NONE);
				lblDueDate.setText(CheLangKeys.STR_DUE_DATE); //$NON-NLS-1$
			}
			{
				datePickValueDate = new DatePicker(compCheq, SWT.NONE);
				GridData datePickValueDateLData = new GridData();
				datePickValueDateLData.widthHint = 157;
				datePickValueDateLData.heightHint = 23;
				datePickValueDate.setLayoutData(datePickValueDateLData);
			}
			{
				lblPaymentPlace = new CLabel(compCheq, SWT.NONE);
				lblPaymentPlace.setText(CheLangKeys.STR_PAYMENT_PLACE); //$NON-NLS-1$
			}
			{
				txtPaymentPlace = new Text(compCheq, SWT.NONE);
				GridData txtPaymentPlaceLData = new GridData();
				txtPaymentPlaceLData.widthHint = 150;
				txtPaymentPlaceLData.heightHint = 17;
				txtPaymentPlace.setLayoutData(txtPaymentPlaceLData);
			}
			{
				lblAmount = new CLabel(compCheq, SWT.NONE);
				lblAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
			}
			{
				curText = new CurrencyText(compCheq, SWT.NONE);
				GridData curTextLData = new GridData();
				curTextLData.widthHint = 150;
				curTextLData.heightHint = 17;
				curText.setLayoutData(curTextLData);
			}
			//END << compCheq
			tabFolder.setSelection(0);
			GridData tabFolderLData = new GridData();
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.grabExcessVerticalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolderLData.horizontalSpan = 2;
			tabFolder.setLayoutData(tabFolderLData);
			//END << cTabItem1
			//END << tabFolder
			postInitGUI();
            dialogShell.layout();
            dialogShell.pack();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
			return isUpdated;
		}
	}

	public void postInitGUI()
	{
		EngUICommon.centreWindow(dialogShell);
		if (cheque != null)
		{
			txtChequeNo.setText(cheque.getChequesNo());
			txtPaymentPlace.setText(cheque.getChequesPaymentPlace());
			datePickValueDate.setDate(cheque.getChequesDueDate());
			curText.setText(cheque.getChequesAmount());
			bankPicker.setText(cheque.getTurqBanksCard().getBankCode());
		}
	}

	public boolean verifyFields()
	{
		if (bankPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getParent(), BankLangKeys.MSG_SELECT_BANK_CARD, SWT.ICON_WARNING); //$NON-NLS-1$
			bankPicker.setFocus();
			return false;
		}
		else if (curText.getBigDecimalValue().compareTo(new BigDecimal(0)) < 1)
		{
			EngUICommon.showMessageBox(getParent(),EngLangCommonKeys.MSG_ENTER_AMOUNT, SWT.ICON_WARNING); //$NON-NLS-1$
			curText.setFocus();
			return false;
		}
		return true;
	}

	public void update()
	{
		try
		{
			if (verifyFields())
			{
				if (cheque == null)
				{
					cheque = new TurqChequeCheque();
				}
				/**
				 * 
				 */
				
				cheque.setBankBranchName(bankPicker.getBankBranchName());
				cheque.setBankName(bankPicker.getBankName());
				cheque.setChequesPortfolioNo(""); //$NON-NLS-1$
				cheque.setChequesNo(txtChequeNo.getText().trim());
				cheque.setChequesDueDate(datePickValueDate.getDate());
				cheque.setChequesValueDate(datePickValueDate.getDate());
				cheque.setChequesDebtor(CheLangKeys.STR_OWN_CHEQUE); //$NON-NLS-1$
				cheque.setChequesPaymentPlace(txtPaymentPlace.getText().trim());
				cheque.setChequesAmount(curText.getBigDecimalValue());
				cheque.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
				cheque.setLastModified(Calendar.getInstance().getTime());
				cheque.setChequesType(EngBLCommon.CHEQUE_TYPE_OWN);
				TurqBanksCard bankCard  = new TurqBanksCard();
				bankCard.setId(bankPicker.getBankId());
				cheque.setTurqBanksCard(bankCard);
				//        TODO cheq trans exRate
				
				
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE,cheque);
				argMap.put(EngKeys.EXCHANGE_RATE, EngBLCommon.getBaseCurrencyExchangeRate());
				
				EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"updateCheque",argMap);
					
				
				EngUICommon.showSavedSuccesfullyMessage(getParent());
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	private void toolDeleteWidgetSelected(SelectionEvent evt)
	{
		try
		{
			if (EngUICommon.okToDelete(getParent()))
			{
				//		          TODO cheq trans exRate
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE,cheque);
				argMap.put(EngKeys.EXCHANGE_RATE, EngBLCommon.getBaseCurrencyExchangeRate());
				
				EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"deleteCheque",argMap);
				
				
				EngUICommon.showMessageBox(getParent(), EngLangCommonKeys.MSG_DELETED_SUCCESS, SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}