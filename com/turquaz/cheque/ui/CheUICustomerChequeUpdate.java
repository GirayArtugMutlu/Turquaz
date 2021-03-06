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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;

import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.cheque.bl.CheBLUpdateCheque;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.BankLangKeys;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.ui.component.DatePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CTabFolder;
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
public class CheUICustomerChequeUpdate extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private CLabel lblPortfolioNo;
	private CurrencyText curText;
	private TableColumn tableColumnCurrentCode;
	private TableColumn tableColumnBankCode;
	private TableColumn tableColumnType;
	private TableColumn tableColumnDate;
	private Table tableHistory;
	private Composite compHistory;
	private CTabItem tabItemHistory;
	private CTabItem cTabItem1;
	private CTabFolder tabFolder;
	private Composite compDialog;
	private CLabel lblBankAccount;
	private ToolItem toolDelete;
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
	Integer chequeId = null;
	boolean isUpdated = false;

	public CheUICustomerChequeUpdate(Shell parent, int style, Integer chequeId)
	{
		super(parent, style);
		this.chequeId = chequeId;
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
		
			dialogShell.setText(CheLangKeys.TITLE_CUSTOMER_CHEQUE_ENTRY); //$NON-NLS-1$
			dialogShell.setSize(581, 346);
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
			//START >> compDialog
			compDialog = new Composite(tabFolder, SWT.NONE);
			cTabItem1.setControl(compDialog);
			GridLayout compDialogLayout = new GridLayout();
			GridData compDialogLData = new GridData();
			compDialogLData.horizontalAlignment = GridData.FILL;
			compDialogLData.verticalAlignment = GridData.FILL;
			compDialogLData.grabExcessVerticalSpace = true;
			compDialogLData.grabExcessHorizontalSpace = true;
			compDialogLData.horizontalSpan = 2;
			compDialog.setLayoutData(compDialogLData);
			compDialogLayout.numColumns = 2;
			compDialog.setLayout(compDialogLayout);
			{
				lblPortfolioNo = new CLabel(compDialog, SWT.NONE);
				lblPortfolioNo.setText(CheLangKeys.STR_PORTFOLIO_NO); //$NON-NLS-1$
			}
			{
				txtPortfoyNo = new Text(compDialog, SWT.NONE);
				GridData txtPortfoyNoLData = new GridData();
				txtPortfoyNoLData.widthHint = 150;
				txtPortfoyNoLData.heightHint = 17;
				txtPortfoyNo.setLayoutData(txtPortfoyNoLData);
			}
			{
				lblChequeNo = new CLabel(compDialog, SWT.NONE);
				lblChequeNo.setText(CheLangKeys.STR_CHEQUE_NO); //$NON-NLS-1$
			}
			{
				txtChequeNo = new Text(compDialog, SWT.NONE);
				GridData txtChequeNoLData = new GridData();
				txtChequeNoLData.widthHint = 150;
				txtChequeNoLData.heightHint = 17;
				txtChequeNo.setLayoutData(txtChequeNoLData);
			}
			{
				lblBankName = new CLabel(compDialog, SWT.NONE);
				lblBankName.setText(CheLangKeys.STR_BANK_NAME); //$NON-NLS-1$
			}
			{
				txtBankName = new Text(compDialog, SWT.NONE);
				GridData txtBankNameLData = new GridData();
				txtBankNameLData.widthHint = 150;
				txtBankNameLData.heightHint = 17;
				txtBankName.setLayoutData(txtBankNameLData);
			}
			{
				lblBankBranch = new CLabel(compDialog, SWT.NONE);
				lblBankBranch.setText(CheLangKeys.STR_BANK_BRANCH); //$NON-NLS-1$
			}
			{
				txtBankBranch = new Text(compDialog, SWT.NONE);
				GridData txtBankBranchLData = new GridData();
				txtBankBranchLData.widthHint = 150;
				txtBankBranchLData.heightHint = 17;
				txtBankBranch.setLayoutData(txtBankBranchLData);
			}
			//START >> lblBankAccount
			lblBankAccount = new CLabel(compDialog, SWT.NONE);
			lblBankAccount.setText(CheLangKeys.STR_BANK_ACCOUNT_NO); //$NON-NLS-1$
			//END << lblBankAccount
			//START >> txtBankAccountNO
			txtBankAccountNO = new Text(compDialog, SWT.NONE);
			GridData txtBankAccountNOLData = new GridData();
			txtBankAccountNOLData.widthHint = 150;
			txtBankAccountNOLData.heightHint = 17;
			txtBankAccountNO.setLayoutData(txtBankAccountNOLData);
			//END << txtBankAccountNO
			{
				lblDueDate = new CLabel(compDialog, SWT.NONE);
				lblDueDate.setText(CheLangKeys.STR_DUE_DATE); //$NON-NLS-1$
			}
			{
				datePickValueDate = new DatePicker(compDialog, SWT.NONE);
				GridData datePickValueDateLData = new GridData();
				datePickValueDateLData.widthHint = 157;
				datePickValueDateLData.heightHint = 23;
				datePickValueDate.setLayoutData(datePickValueDateLData);
			}
			{
				lblDeptor = new CLabel(compDialog, SWT.NONE);
				lblDeptor.setText(CheLangKeys.STR_DEPTOR); //$NON-NLS-1$
				GridData lblDeptorLData = new GridData();
				lblDeptorLData.widthHint = 42;
				lblDeptorLData.heightHint = 19;
				lblDeptor.setLayoutData(lblDeptorLData);
			}
			{
				txtDeptor = new Text(compDialog, SWT.NONE);
				GridData txtDeptorLData = new GridData();
				txtDeptorLData.widthHint = 150;
				txtDeptorLData.heightHint = 17;
				txtDeptor.setLayoutData(txtDeptorLData);
			}
			{
				lblPaymentPlace = new CLabel(compDialog, SWT.NONE);
				lblPaymentPlace.setText(CheLangKeys.STR_PAYMENT_PLACE); //$NON-NLS-1$
			}
			{
				txtPaymentPlace = new Text(compDialog, SWT.NONE);
				GridData txtPaymentPlaceLData = new GridData();
				txtPaymentPlaceLData.widthHint = 150;
				txtPaymentPlaceLData.heightHint = 17;
				txtPaymentPlace.setLayoutData(txtPaymentPlaceLData);
			}
			{
				lblAmount = new CLabel(compDialog, SWT.NONE);
				lblAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
			}
			{
				curText = new CurrencyText(compDialog, SWT.NONE);
				GridData curTextLData = new GridData();
				curTextLData.widthHint = 150;
				curTextLData.heightHint = 17;
				curText.setLayoutData(curTextLData);
			}
			//END << compDialog
			GridData tabFolderLData = new GridData();
			tabFolderLData.grabExcessVerticalSpace = true;
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolderLData.horizontalSpan = 2;
			tabFolder.setLayoutData(tabFolderLData);
			//END << cTabItem1
			//START >> tabItemHistory
			tabItemHistory = new CTabItem(tabFolder, SWT.NONE);
			tabItemHistory.setText(CheLangKeys.STR_CHEQUE_HISTORY); //$NON-NLS-1$
			//START >> compHistory
			compHistory = new Composite(tabFolder, SWT.NONE);
			GridLayout compHistoryLayout = new GridLayout();
			compHistoryLayout.makeColumnsEqualWidth = true;
			compHistory.setLayout(compHistoryLayout);
			tabItemHistory.setControl(compHistory);
			//START >> tableHistory
			tableHistory = new Table(compHistory, SWT.NONE);
			GridData tableHistoryLData = new GridData();
			tableHistory.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableHistoryMouseDoubleClick(evt);
				}
			});
			tableHistory.setHeaderVisible(true);
			tableHistory.setLinesVisible(true);
			tableHistoryLData.grabExcessHorizontalSpace = true;
			tableHistoryLData.grabExcessVerticalSpace = true;
			tableHistoryLData.horizontalAlignment = GridData.FILL;
			tableHistoryLData.verticalAlignment = GridData.FILL;
			tableHistory.setLayoutData(tableHistoryLData);
			//START >> tableColumnDate
			tableColumnDate = new TableColumn(tableHistory, SWT.NONE);
			tableColumnDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
			tableColumnDate.setWidth(100);
			//END << tableColumnDate
			//START >> tableColumnType
			tableColumnType = new TableColumn(tableHistory, SWT.NONE);
			tableColumnType.setText(CheLangKeys.STR_ROLL_TYPE); //$NON-NLS-1$
			tableColumnType.setWidth(70);
			//END << tableColumnType
			//START >> tableColumnBankCode
			tableColumnBankCode = new TableColumn(tableHistory, SWT.NONE);
			tableColumnBankCode.setText(BankLangKeys.STR_BANK_CODE); //$NON-NLS-1$
			tableColumnBankCode.setWidth(100);
			//END << tableColumnBankCode
			//START >> tableColumnCurrentCode
			tableColumnCurrentCode = new TableColumn(tableHistory, SWT.NONE);
			tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE); //$NON-NLS-1$
			tableColumnCurrentCode.setWidth(100);
			//END << tableColumnCurrentCode
			//END << tableHistory
			//END << compHistory
			tabFolder.setSelection(0);
			//END << tabItemHistory
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
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getParent());
			return false;
		}
	}

	public void postInitGUI()
	{
		try
		{
			EngUICommon.centreWindow(dialogShell);
			
			if (chequeId != null)
			{
				
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ID,chequeId);
				HashBag chequeBag = (HashBag)EngTXCommon.doSelectTX(CheBLSearchCheques.class.getName(),"getChequeInfo",argMap);
				
				
				txtBankBranch.setText((String)chequeBag.get(BankKeys.BANK_BRANCH_NAME));
				txtBankName.setText((String)chequeBag.get(BankKeys.BANK_NAME));
				txtChequeNo.setText((String)chequeBag.get(CheKeys.CHE_CHEQUE_NO));
				txtDeptor.setText((String)chequeBag.get(CheKeys.CHE_DEBTOR));
				txtPaymentPlace.setText((String)chequeBag.get(CheKeys.CHE_PAYMENT_PLACE));
				txtPortfoyNo.setText((String)chequeBag.get(CheKeys.CHE_PORTFOLIO_NO));
				datePickValueDate.setDate((Date)chequeBag.get(CheKeys.CHE_DUE_DATE));
				curText.setText((BigDecimal)chequeBag.get(EngKeys.TOTAL_AMOUNT));
				
				if (chequeBag.get(BankKeys.BANK_ACCOUNT_NO) != null)
				{
					txtBankAccountNO.setText((String)chequeBag.get(BankKeys.BANK_ACCOUNT_NO) );
				}
				
				HashMap historyMap = (HashMap)chequeBag.get(CheKeys.CHE_CHEQUE_ROLLS);
				FillHistory(historyMap);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void FillHistory(HashMap chequeRolls)
	{
		try
		{
			//HISTORY
			tableHistory.removeAll();
			
			
			if(chequeRolls==null)
			{
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ID,chequeId);
				HashBag historyBag = (HashBag)EngTXCommon.doSelectTX(CheBLSearchCheques.class.getName(),"getChequeHistory",argMap);
				chequeRolls=(HashMap)historyBag.get(CheKeys.CHE_CHEQUE_ROLLS);
			
			}
			
			TableItem item;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			
			for (int k = 0; k < chequeRolls.size(); k++)
			{
				HashMap cheqRollInfo = (HashMap) chequeRolls.get(new Integer(k));
				
				
				item = new TableItem(tableHistory, SWT.NULL);
				
				item.setText(new String[]{
						dateFormat.format(cheqRollInfo.get(EngKeys.DATE)),
						(String)cheqRollInfo.get(EngKeys.TYPE_NAME),
						(String)cheqRollInfo.get(BankKeys.BANK_CODE),
						(String)cheqRollInfo.get(CurKeys.CUR_CURRENT_CODE)}); //$NON-NLS-1$
				
				
				item.setData(new Integer[]{(Integer)cheqRollInfo.get(CheKeys.CHE_CHEQUE_ROLL_ID),(Integer)cheqRollInfo.get(EngKeys.TYPE_ID)});
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void update()
	{
		try
		{
			
			HashMap argMap = new HashMap();
			
			argMap.put(BankKeys.BANK_BRANCH_NAME,txtBankBranch.getText().trim());
			argMap.put(BankKeys.BANK_NAME,txtBankName.getText().trim());
			argMap.put(CheKeys.CHE_PORTFOLIO_NO,txtPortfoyNo.getText().trim());
			argMap.put(CheKeys.CHE_CHEQUE_NO,txtChequeNo.getText().trim());
			argMap.put(CheKeys.CHE_DUE_DATE,datePickValueDate.getDate());
		
			argMap.put(CheKeys.CHE_DEBTOR,txtDeptor.getText().trim());
			argMap.put(CheKeys.CHE_PAYMENT_PLACE,txtPaymentPlace.getText().trim());
			argMap.put(EngKeys.TOTAL_AMOUNT,curText.getBigDecimalValue());
			argMap.put(BankKeys.BANK_ACCOUNT_NO,txtBankAccountNO.getText().trim());
			
			// TODO cheq trans exRate
			
			
			argMap.put(CheKeys.CHE_CHEQUE_ID,chequeId);
			
			
			EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"updateCheque",argMap);
			EngUICommon.showSavedSuccesfullyMessage(getParent());
			isUpdated = true;
			dialogShell.close();
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
				//	          TODO cheq trans exRate
				
				HashMap argMap = new HashMap();
				argMap.put(CheKeys.CHE_CHEQUE_ID,chequeId);
				
				EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"deleteCheque",argMap);
				
				
				EngUICommon.showMessageBox(getParent(), EngLangCommonKeys.MSG_DELETED_SUCCESS,SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	private void tableHistoryMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem[] selection = tableHistory.getSelection();
			if (selection.length > 0)
			{
				Integer data[] = (Integer[]) selection[0].getData();
				boolean isUpdatedRoll = CheUIChequeRollSearch.rollUpdate(data[0],data[1], this.getParent());
				if (isUpdatedRoll)
				{
					FillHistory(null);
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}