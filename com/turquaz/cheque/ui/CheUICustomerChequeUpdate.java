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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.cheque.bl.CheBLUpdateCheque;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeRoll;
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
	TurqChequeCheque cheque = null;
	boolean isUpdated = false;

	public CheUICustomerChequeUpdate(Shell parent, int style, TurqChequeCheque cheque)
	{
		super(parent, style);
		this.cheque = cheque;
	}

	public boolean open()
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
			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.numColumns = 2;
			dialogShell.layout();
			dialogShell.setText(Messages.getString("CheUICustomerChequeAddDialog.3")); //$NON-NLS-1$
			dialogShell.pack();
			dialogShell.setText(Messages.getString("CheUICustomerChequeAddDialog.1")); //$NON-NLS-1$
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
					toolSave.setText(Messages.getString("CheUICustomerChequeAddDialog.0")); //$NON-NLS-1$
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
				toolDelete.setText(Messages.getString("CheUICustomerChequeUpdate.0")); //$NON-NLS-1$
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
					toolCancel.setText("Kapat"); //$NON-NLS-1$
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
			cTabItem1.setText(Messages.getString("CheUICustomerChequeUpdate.1")); //$NON-NLS-1$
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
				lblPortfolioNo.setText(Messages.getString("CheUICustomerChequeAddDialog.4")); //$NON-NLS-1$
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
				lblChequeNo.setText(Messages.getString("CheUICustomerChequeAddDialog.5")); //$NON-NLS-1$
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
				lblBankName.setText(Messages.getString("CheUICustomerChequeAddDialog.6")); //$NON-NLS-1$
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
				lblBankBranch.setText(Messages.getString("CheUICustomerChequeAddDialog.7")); //$NON-NLS-1$
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
			lblBankAccount.setText(Messages.getString("CheUICustomerChequeAddDialog.12")); //$NON-NLS-1$
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
				lblDueDate.setText(Messages.getString("CheUICustomerChequeAddDialog.8")); //$NON-NLS-1$
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
				lblDeptor.setText(Messages.getString("CheUICustomerChequeAddDialog.9")); //$NON-NLS-1$
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
				lblPaymentPlace.setText(Messages.getString("CheUICustomerChequeAddDialog.10")); //$NON-NLS-1$
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
				lblAmount.setText(Messages.getString("CheUICustomerChequeAddDialog.11")); //$NON-NLS-1$
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
			tabItemHistory.setText(Messages.getString("CheUICustomerChequeUpdate.3")); //$NON-NLS-1$
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
			tableColumnDate.setText(Messages.getString("CheUICustomerChequeUpdate.4")); //$NON-NLS-1$
			tableColumnDate.setWidth(100);
			//END << tableColumnDate
			//START >> tableColumnType
			tableColumnType = new TableColumn(tableHistory, SWT.NONE);
			tableColumnType.setText(Messages.getString("CheUICustomerChequeUpdate.5")); //$NON-NLS-1$
			tableColumnType.setWidth(70);
			//END << tableColumnType
			//START >> tableColumnBankCode
			tableColumnBankCode = new TableColumn(tableHistory, SWT.NONE);
			tableColumnBankCode.setText(Messages.getString("CheUICustomerChequeUpdate.6")); //$NON-NLS-1$
			tableColumnBankCode.setWidth(100);
			//END << tableColumnBankCode
			//START >> tableColumnCurrentCode
			tableColumnCurrentCode = new TableColumn(tableHistory, SWT.NONE);
			tableColumnCurrentCode.setText(Messages.getString("CheUICustomerChequeUpdate.7")); //$NON-NLS-1$
			tableColumnCurrentCode.setWidth(100);
			//END << tableColumnCurrentCode
			//END << tableHistory
			//END << compHistory
			tabFolder.setSelection(0);
			//END << tabItemHistory
			//END << tabFolder
			postInitGUI();
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
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			return false;
		}
	}

	public void postInitGUI()
	{
		try
		{
			EngUICommon.centreWindow(dialogShell);
			if (cheque != null)
			{
				txtBankBranch.setText(cheque.getBankBranchName());
				txtBankName.setText(cheque.getBankName());
				txtChequeNo.setText(cheque.getChequesNo());
				txtDeptor.setText(cheque.getChequesDebtor());
				txtPaymentPlace.setText(cheque.getChequesPaymentPlace());
				txtPortfoyNo.setText(cheque.getChequesPortfolioNo());
				datePickValueDate.setDate(cheque.getChequesDueDate());
				curText.setText(cheque.getChequesAmount());
				if (cheque.getBankAccountNo() != null)
				{
					txtBankAccountNO.setText(cheque.getBankAccountNo());
				}
				FillHistory();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void FillHistory()
	{
		try
		{
			//HISTORY
			tableHistory.removeAll();
			
			HashMap argMap = new HashMap();
			argMap.put(CheKeys.CHE_CHEQUE,cheque);
			List history = (List)EngTXCommon.doSelectTX(CheBLSearchCheques.class.getName(),"getChequeHistory",argMap);
			TableItem item;
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			for (int k = 0; k < history.size(); k++)
			{
				TurqChequeRoll cheqRoll = (TurqChequeRoll) history.get(k);
				item = new TableItem(tableHistory, SWT.NULL);
				item.setText(new String[]{
						dateFormat.format(cheqRoll.getChequeRollsDate()),
						cheqRoll.getTurqChequeTransactionType().getTransactionTypsName(),
						((cheqRoll.getTurqBanksCard().getId().intValue() == -1) ? "" : cheqRoll.getTurqBanksCard().getBankCode()), //$NON-NLS-1$
						((cheqRoll.getTurqCurrentCard().getId().intValue() == -1)
								? "" : cheqRoll.getTurqCurrentCard().getCardsCurrentCode())}); //$NON-NLS-1$
				item.setData(cheqRoll.getId());
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void update()
	{
		try
		{
			cheque.setBankBranchName(txtBankBranch.getText().trim());
			cheque.setBankName(txtBankName.getText().trim());
			cheque.setChequesPortfolioNo(txtPortfoyNo.getText().trim());
			cheque.setChequesNo(txtChequeNo.getText().trim());
			cheque.setChequesDueDate(datePickValueDate.getDate());
			cheque.setChequesValueDate(datePickValueDate.getDate());
			cheque.setChequesDebtor(txtDeptor.getText().trim());
			cheque.setChequesPaymentPlace(txtPaymentPlace.getText().trim());
			cheque.setChequesAmount(curText.getBigDecimalValue());
			cheque.setBankAccountNo(txtBankAccountNO.getText().trim());
			cheque.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
			cheque.setLastModified(Calendar.getInstance().getTime());
			//        TODO cheq trans exRate
			
			HashMap argMap = new HashMap();
			argMap.put(CheKeys.CHE_CHEQUE,cheque);
			argMap.put(EngKeys.EXCHANGE_RATE, EngBLCommon.getBaseCurrencyExchangeRate());
			
			EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"updateCheque",argMap);
			EngUICommon.showSavedSuccesfullyMessage(getParent());
			isUpdated = true;
			dialogShell.close();
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
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
				argMap.put(CheKeys.CHE_CHEQUE,cheque);
				argMap.put(EngKeys.EXCHANGE_RATE, EngBLCommon.getBaseCurrencyExchangeRate());
				
				EngTXCommon.doTransactionTX(CheBLUpdateCheque.class.getName(),"deleteCheque",argMap);
				
				
				EngUICommon.showMessageBox(getParent(), Messages.getString("CheUICustomerChequeUpdate.2"), SWT.ICON_INFORMATION); //$NON-NLS-1$
				isUpdated = true;
				dialogShell.close();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	private void tableHistoryMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem[] selection = tableHistory.getSelection();
			if (selection.length > 0)
			{
				Integer rollId = (Integer) selection[0].getData();
				boolean isUpdatedRoll = CheUIChequeRollSearch.rollUpdate(rollId, this.getParent());
				if (isUpdatedRoll)
				{
					FillHistory();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
}