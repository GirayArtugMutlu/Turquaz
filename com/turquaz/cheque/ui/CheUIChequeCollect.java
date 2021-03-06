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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Table;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.CurrencyTextAdvanced;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.bl.CheBLSaveChequeTransaction;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUIChequeCollect extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite compInfoPanel;
	private ToolBar toolBarButtons;
	private ToolItem toolItemAdd;
	private CurrencyTextAdvanced txtTotalAmount;
	private CLabel lblTotalAmount;
	private Composite compTotal;
	private CashCardPicker cashCardPcker;
	private Button btnSumTotals;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnPaymentPlace;
	private TableColumn tableColumnDeptor;
	private TableColumn tableColumnDueDaye;
	private TableColumn tableColumnNo;
	private CLabel lblCurrentCode;
	private DatePicker datePicker1;
	private CLabel lblRollDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private Table tableCheques;
	private ToolItem toolItemDelete;
	List cheques = new ArrayList();
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	public CheUIChequeCollect(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(666, 401);
			{
				compInfoPanel = new Composite(this, SWT.NONE);
				GridLayout compInfoPanelLayout = new GridLayout();
				GridData compInfoPanelLData = new GridData();
				compInfoPanelLData.grabExcessHorizontalSpace = true;
				compInfoPanelLData.horizontalAlignment = GridData.FILL;
				compInfoPanelLData.heightHint = 103;
				compInfoPanel.setLayoutData(compInfoPanelLData);
				compInfoPanelLayout.numColumns = 2;
				compInfoPanel.setLayout(compInfoPanelLayout);
				{
					lblRollNo = new CLabel(compInfoPanel, SWT.NONE);
					lblRollNo.setText(CheLangKeys.STR_ROLL_NO); //$NON-NLS-1$
				}
				{
					txtRollNo = new Text(compInfoPanel, SWT.NONE);
					GridData txtRollNoLData = new GridData();
					txtRollNoLData.widthHint = 150;
					txtRollNoLData.heightHint = 17;
					txtRollNo.setLayoutData(txtRollNoLData);
				}
				{
					lblRollDate = new CLabel(compInfoPanel, SWT.NONE);
					lblRollDate.setText(CheLangKeys.STR_ROLL_DATE); //$NON-NLS-1$
				}
				{
					datePicker1 = new DatePicker(compInfoPanel, SWT.NONE);
					GridData datePicker1LData = new GridData();
					datePicker1LData.widthHint = 157;
					datePicker1LData.heightHint = 23;
					datePicker1.setLayoutData(datePicker1LData);
				}
				{
					lblCurrentCode = new CLabel(compInfoPanel, SWT.NONE);
					lblCurrentCode.setText(CashLangKeys.STR_CASH_CARD); //$NON-NLS-1$
				}
				//START >> cashCardPcker
				cashCardPcker = new CashCardPicker(compInfoPanel, SWT.NONE);
				GridData cashCardPckerLData = new GridData();
				cashCardPckerLData.widthHint = 157;
				cashCardPckerLData.heightHint = 17;
				cashCardPcker.setLayoutData(cashCardPckerLData);
				//END << cashCardPcker
				{
					btnSumTotals = new Button(compInfoPanel, SWT.CHECK | SWT.LEFT);
					btnSumTotals.setText("Kasa Hareketleri Topla "); //$NON-NLS-1$
				}
			}
			{
				toolBarButtons = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
				GridData toolBarButtonsLData = new GridData();
				toolBarButtonsLData.horizontalAlignment = GridData.FILL;
				toolBarButtonsLData.grabExcessHorizontalSpace = true;
				toolBarButtons.setLayoutData(toolBarButtonsLData);
				{
					toolItemAdd = new ToolItem(toolBarButtons, SWT.NONE);
					toolItemAdd.setText(EngLangCommonKeys.STR_ADD); //$NON-NLS-1$
					toolItemAdd.setImage(SWTResourceManager.getImage("icons/plus.gif")); //$NON-NLS-1$
					toolItemAdd.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							addCheque();
						}
					});
				}
				{
					toolItemDelete = new ToolItem(toolBarButtons, SWT.NONE);
					toolItemDelete.setText(EngLangCommonKeys.STR_DELETE); //$NON-NLS-1$
					toolItemDelete.setImage(SWTResourceManager.getImage("icons/minus.gif")); //$NON-NLS-1$
					toolItemDelete.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							deleteTableRow();
						}
					});
				}
			}
			{
				tableCheques = new Table(this, SWT.FULL_SELECTION);
				tableCheques.setLinesVisible(true);
				tableCheques.setHeaderVisible(true);
				GridData tableChequesLData = new GridData();
				tableChequesLData.grabExcessHorizontalSpace = true;
				tableChequesLData.horizontalAlignment = GridData.FILL;
				tableChequesLData.verticalAlignment = GridData.FILL;
				tableChequesLData.grabExcessVerticalSpace = true;
				tableCheques.setLayoutData(tableChequesLData);
				{
					tableColumnNo = new TableColumn(tableCheques, SWT.NONE);
					tableColumnNo.setText(CheLangKeys.STR_PORTFOLIO_NO); //$NON-NLS-1$
					tableColumnNo.setWidth(59);
				}
				{
					tableColumnDueDaye = new TableColumn(tableCheques, SWT.NONE);
					tableColumnDueDaye.setText(EngLangCommonKeys.STR_DUE_DATE); //$NON-NLS-1$
					tableColumnDueDaye.setWidth(100);
				}
				{
					tableColumnPaymentPlace = new TableColumn(tableCheques, SWT.NONE);
					tableColumnPaymentPlace.setText(CheLangKeys.STR_PAYMENT_PLACE); //$NON-NLS-1$
					tableColumnPaymentPlace.setWidth(151);
				}
				{
					tableColumnDeptor = new TableColumn(tableCheques, SWT.NONE);
					tableColumnDeptor.setText(CheLangKeys.STR_DEPTOR); //$NON-NLS-1$
					tableColumnDeptor.setWidth(145);
				}
				{
					tableColumnAmount = new TableColumn(tableCheques, SWT.RIGHT);
					tableColumnAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
					tableColumnAmount.setWidth(100);
				}
			}
			//START >> compTotal
			compTotal = new Composite(this, SWT.NONE);
			GridLayout compTotalLayout = new GridLayout();
			compTotalLayout.numColumns = 2;
			GridData compTotalLData = new GridData();
			compTotal.setLayout(compTotalLayout);
			compTotalLData.horizontalAlignment = GridData.FILL;
			compTotalLData.heightHint = 29;
			compTotalLData.grabExcessHorizontalSpace = true;
			compTotal.setLayoutData(compTotalLData);
			//START >> lblTotalAmount
			lblTotalAmount = new CLabel(compTotal, SWT.NONE);
			lblTotalAmount.setText("Toplam Tutar : ");
			//END << lblTotalAmount
			//START >> txtTotalAmount
			txtTotalAmount = new CurrencyTextAdvanced(compTotal, SWT.NONE);
			GridData txtTotalAmountLData = new GridData();
			txtTotalAmountLData.widthHint = 150;
			txtTotalAmountLData.heightHint = 17;
			txtTotalAmount.setLayoutData(txtTotalAmountLData);
			//END << txtTotalAmount
			//END << compTotal
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void newForm()
	{
		CheUIChequeCollect curCard = new CheUIChequeCollect(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public boolean verifyFields()
	{
		if (cashCardPcker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(), CashLangKeys.MSG_SELECT_CASH_CARD, SWT.ICON_WARNING); //$NON-NLS-1$
			cashCardPcker.setFocus();
			return false;
		}
		else if (tableCheques.getItemCount() == 0)
		{
			EngUICommon.showMessageBox(getShell(), CheLangKeys.MSG_ENTER_AT_LEAST_ONE_CHEQUE, SWT.ICON_WARNING); //$NON-NLS-1$
			toolItemAdd.setSelection(true);
			return false;
		}
		return true;
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				
				HashMap argMap = new HashMap();
				argMap.put(CashKeys.CASH_CARD_ID,cashCardPcker.getCashCardId());
				argMap.put(EngKeys.DOCUMENT_NO,txtRollNo.getText().trim());
				argMap.put(EngKeys.DATE,datePicker1.getDate());
				argMap.put(CheKeys.CHE_CHEQUE_LIST,cheques);
				
				EngTXCommon.doTransactionTX(CheBLSaveChequeTransaction.class.getName(),"saveChequeCollect",argMap);
				EngUICommon.showMessageBox(getShell(), EngLangCommonKeys.MSG_SAVED_SUCCESS, SWT.ICON_INFORMATION); //$NON-NLS-1$
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void calculateTotal()
	{
		int count = tableCheques.getItemCount();
		BigDecimal totalAmount = new BigDecimal(0);
		for (int i = 0; i < count; i++)
		{
			HashMap chequeInfo = (HashMap) tableCheques.getItem(i).getData();
			totalAmount = totalAmount.add((BigDecimal)chequeInfo.get(EngKeys.TOTAL_AMOUNT));
		}
		txtTotalAmount.setBigDecimalValue(totalAmount);
	}

	public void deleteTableRow()
	{
		TableItem selection[] = tableCheques.getSelection();
		if (selection.length > 0)
		{
			if (EngUICommon.okToDelete(this.getShell()))
			{
				cheques.remove(selection[0].getData());
				selection[0].dispose();
				calculateTotal();
			}
		}
	}

	public void addCheque()
	{
		cheques = new CheUICustomerChequeChooseDialog(getShell(), SWT.NULL, cheques).open();
		fillTable();
	}

	
	public void fillTable()
	{
		tableCheques.removeAll();
		for (int i = 0; i < cheques.size(); i++)
		{
			TableItem item;
			HashMap chequeInfo = (HashMap) cheques.get(i);
			if (chequeInfo != null)
			{
				item = new TableItem(tableCheques, SWT.NULL);
				item.setData(chequeInfo);
				
				item.setText(new String[]{chequeInfo.get(CheKeys.CHE_PORTFOLIO_NO).toString(),
						DatePicker.formatter.format(chequeInfo.get(EngKeys.DATE)),
						chequeInfo.get(CheKeys.CHE_PAYMENT_PLACE).toString(),
						chequeInfo.get(CheKeys.CHE_DEBTOR).toString(),
						cf.format(chequeInfo.get(EngKeys.TOTAL_AMOUNT))});
			}
		}
		calculateTotal();
	}

	/**
	 * @return Returns the btnSumTotals.
	 */
	public Button getBtnSumTotals()
	{
		return btnSumTotals;
	}

	/**
	 * @param btnSumTotals
	 *             The btnSumTotals to set.
	 */
	public void setBtnSumTotals(Button btnSumTotals)
	{
		this.btnSumTotals = btnSumTotals;
	}

	/**
	 * @return Returns the toolItemAdd.
	 */
	public ToolItem getToolItemAdd()
	{
		return toolItemAdd;
	}

	/**
	 * @param toolItemAdd
	 *             The toolItemAdd to set.
	 */
	public void setToolItemAdd(ToolItem toolItemAdd)
	{
		this.toolItemAdd = toolItemAdd;
	}

	/**
	 * @return Returns the toolItemDelete.
	 */
	public ToolItem getToolItemDelete()
	{
		return toolItemDelete;
	}

	/**
	 * @param toolItemDelete
	 *             The toolItemDelete to set.
	 */
	public void setToolItemDelete(ToolItem toolItemDelete)
	{
		this.toolItemDelete = toolItemDelete;
	}

	public DatePicker getDatePicker1()
	{
		return datePicker1;
	}

	public void setDatePicker1(DatePicker datePicker1)
	{
		this.datePicker1 = datePicker1;
	}

	public Table getTableCheques()
	{
		return tableCheques;
	}

	public void setTableCheques(Table tableCheques)
	{
		this.tableCheques = tableCheques;
	}

	public Text getTxtRollNo()
	{
		return txtRollNo;
	}

	public void setTxtRollNo(Text txtRollNo)
	{
		this.txtRollNo = txtRollNo;
	}

	/**
	 * @return Returns the cashCardPcker.
	 */
	public CashCardPicker getCashCardPcker()
	{
		return cashCardPcker;
	}

	/**
	 * @param cashCardPcker
	 *             The cashCardPcker to set.
	 */
	public void setCashCardPcker(CashCardPicker cashCardPcker)
	{
		this.cashCardPcker = cashCardPcker;
	}
}