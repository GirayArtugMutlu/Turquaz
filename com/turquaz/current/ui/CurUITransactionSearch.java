package com.turquaz.current.ui;

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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import com.turquaz.bank.BankKeys;
import com.turquaz.bank.ui.BankUISearchMoneyTransaction;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.ui.BillUIBillSearch;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.ui.CashUICashTransactionSearch;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.ui.CheUIChequeRollSearch;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;
import com.turquaz.current.ui.comp.CurrentPicker;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUITransactionSearch extends Composite implements SearchComposite
{
	private CLabel lblCurrentCard;
	private CLabel lblTransactionGroup;
	private Table tableCurrentTransactions;
	private TableColumn tableColumnCurrentName;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private TableColumn tableColumn;
	private CurrentPicker txtCurCard;
	private TableColumn tableColumnDocNo;
	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnTransGroup;
	private TableColumn tableColumnCurrentCode;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CCombo comboTransactionGroup;
	private Composite composite1;
	private Calendar cal = Calendar.getInstance();
	private SearchTableViewer tableViewer = null;

	public CurUITransactionSearch(Composite parent, int style)
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
			this.setSize(771, 402);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 85;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD); //$NON-NLS-1$
					lblCurrentCard.setSize(new org.eclipse.swt.graphics.Point(85, 20));
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 85;
					lblCurrentCardLData.heightHint = 20;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 150;
					txtCurCardLData.heightHint = 17;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblTransactionGroup = new CLabel(composite1, SWT.NONE);
					lblTransactionGroup.setText(CurLangKeys.STR_TRANSACTION_GROUP); //$NON-NLS-1$
					lblTransactionGroup.setSize(new org.eclipse.swt.graphics.Point(105, 18));
					GridData lblTransactionGroupLData = new GridData();
					lblTransactionGroupLData.widthHint = 105;
					lblTransactionGroupLData.heightHint = 18;
					lblTransactionGroup.setLayoutData(lblTransactionGroupLData);
				}
				{
					comboTransactionGroup = new CCombo(composite1, SWT.NONE);
					GridData comboTransactionGroupLData = new GridData();
					comboTransactionGroupLData.widthHint = 120;
					comboTransactionGroupLData.heightHint = 17;
					comboTransactionGroup.setLayoutData(comboTransactionGroupLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 98;
					lblStartDateLData.heightHint = 19;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 150;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 94;
					lblEndDateLData.heightHint = 18;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					dateEndDate.setSize(new org.eclipse.swt.graphics.Point(142, 22));
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 150;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblDefinition = new CLabel(composite1, SWT.NONE);
					lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
				}
				{
					txtDefinition = new Text(composite1, SWT.WRAP | SWT.V_SCROLL);
					GridData txtDefinitionLData = new GridData();
					txtDefinitionLData.widthHint = 385;
					txtDefinitionLData.heightHint = 19;
					txtDefinitionLData.horizontalSpan = 3;
					txtDefinition.setLayoutData(txtDefinitionLData);
				}
			}
			{
				tableCurrentTransactions = new Table(this, SWT.FULL_SELECTION);
				tableCurrentTransactions.setHeaderVisible(true);
				tableCurrentTransactions.setLinesVisible(true);
				GridData tableCurrentTransactionsLData = new GridData();
				tableCurrentTransactions.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableCurrentTransactionsMouseDoubleClick(evt);
					}
				});
				tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
				tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
				tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
				{
					tableColumnTransDate = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnTransDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
					tableColumnTransDate.setWidth(98);
				}
				{
					tableColumnDocNo = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO); //$NON-NLS-1$
					tableColumnDocNo.setWidth(85);
				}
				{
					tableColumnCurrentCode = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE); //$NON-NLS-1$
					tableColumnCurrentCode.setWidth(82);
				}
				//START >> tableColumnCurrentName
				tableColumnCurrentName = new TableColumn(tableCurrentTransactions, SWT.NONE);
				tableColumnCurrentName.setText("Cari Ad\u0131");
				tableColumnCurrentName.setWidth(122);
				//END << tableColumnCurrentName
				{
					tableColumnTransGroup = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnTransGroup.setText(CurLangKeys.STR_TRANSACTION_GROUP); //$NON-NLS-1$
					tableColumnTransGroup.setWidth(95);
				}
				{
					tableColumn = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumn.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
					tableColumn.setWidth(100);
				}
				{
					tableColumnDebit = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
					tableColumnDebit.setText(EngLangCommonKeys.STR_DEPT); //$NON-NLS-1$
					tableColumnDebit.setWidth(62);
				}
				{
					tableColumnCredit = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
					tableColumnCredit.setText(EngLangCommonKeys.STR_CREDIT); //$NON-NLS-1$
					tableColumnCredit.setWidth(68);
				}
			}
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		fillComboTypes();
		createTableViewer();
	}

	public void fillComboTypes()
	{
		try
		{
			
			HashBag resultBag =(HashBag)EngTXCommon.doSelectTX(CurBLCurrentTransactionAdd.class.getName(),"getCurrentTransactionTypes",null);
					
			HashMap types = (HashMap)resultBag.get(EngKeys.TYPES);
			
			
			comboTransactionGroup.add("Hepsi");
			comboTransactionGroup.setData("Hepsi", null);
			for (int i = 0; i < types.size(); i++)
			{
				
				HashMap typeInfo = (HashMap) types.get(new Integer(i));
				comboTransactionGroup.add(typeInfo.get(EngKeys.TYPE_NAME).toString());
				comboTransactionGroup.setData(typeInfo.get(EngKeys.TYPE_NAME).toString(), typeInfo.get(EngKeys.TYPE_ID));
			}
			comboTransactionGroup.setText("Hepsi");
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void save()
	{
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalCredit = new BigDecimal(0);
			
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CARD_ID,txtCurCard.getCardId());
			argMap.put(EngKeys.TYPE_ID,comboTransactionGroup.getData(comboTransactionGroup.getText()));
			argMap.put(EngKeys.DOCUMENT_NO,"");
			argMap.put(EngKeys.DEFINITION,txtDefinition.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			
			
			HashBag resultBag = (HashBag)EngTXCommon.doSelectTX(CurBLSearchTransaction.class.getName(),"searchCurrentTransaction",argMap); 
			HashMap transactions = (HashMap)resultBag.get(CurKeys.CUR_TRANSACTIONS);
						
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < transactions.size(); i++)
			{
				HashMap transInfo = (HashMap)transactions.get(new Integer(i));
				Integer transId = (Integer) transInfo.get(CurKeys.CUR_TRANSACTION_ID);
				Integer typeId =(Integer) transInfo.get(EngKeys.TYPE_ID);
				Integer rowData[]=new Integer[]{
					transId,typeId	
				};
				
				Date transDate = (Date) transInfo.get(EngKeys.DATE);
				String transDocNo = (String)  transInfo.get(EngKeys.DOCUMENT_NO);
				String curCardCode = (String)  transInfo.get(CurKeys.CUR_CURRENT_CODE);
				String curCardName = (String)  transInfo.get(CurKeys.CUR_CURRENT_NAME);
				String transTypeName = (String)  transInfo.get(EngKeys.TYPE_NAME);
				String transDefinition = (String) transInfo.get(EngKeys.DEFINITION);
				BigDecimal transTotalDept = (BigDecimal)transInfo.get(EngKeys.DEPT_AMOUNT);
				BigDecimal transTotalCredit = (BigDecimal)transInfo.get(EngKeys.CREDIT_AMOUNT);
				tableViewer.addRow(new String[]{DatePicker.formatter.format(transDate), transDocNo, curCardCode, curCardName,
						transTypeName, transDefinition, cf.format(transTotalDept), cf.format(transTotalCredit)}, rowData);
				totalDept = totalDept.add(transTotalDept);
				totalCredit = totalCredit.add(transTotalCredit);
			}
			tableViewer.addRow(new String[]{"", "", "", "", "", "", "", ""}, null);
			tableViewer.addRow(new String[]{"", "", "", "", "", "---TOPLAM---", cf.format(totalDept), cf.format(totalCredit)}, null);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[8];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCurrentTransactions, columnTypes, true);
	}

	public void delete()
	{
		//TODO should be implemented..
	}

	public void newForm()
	{
	}

	/** Auto-generated event handler method */
	protected void tableCurrentTransactionsMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem items[] = tableCurrentTransactions.getSelection();
			if (items.length > 0)
			{
				boolean updated = false;
				Integer[] rowData = (Integer[]) ((ITableRow) items[0].getData()).getDBObject();
				Integer transId = rowData[0];
				int type = rowData[1].intValue();
				if (transId != null)
				{
					
					HashMap argMap = new HashMap();
					argMap.put(EngKeys.TRANS_ID,transId);
				
					
					if (type == EngBLCommon.CURRENT_TRANS_OTHERS)
					{
						
						updated = new CurUIVoucherUpdate(this.getShell(), SWT.NULL, transId).open();
					}
					else if (type == EngBLCommon.CURRENT_TRANS_BANK)
					{
						HashBag transInfo = (HashBag)EngTXCommon.doSelectTX(CurBLSearchTransaction.class.getName(),"getBankTransaction",argMap);
						Integer bankTransId =(Integer) transInfo.get(BankKeys.BANK_TRANS_BILL_ID);
						Integer transTypeId = (Integer)transInfo.get(EngKeys.TYPE_ID);
					
						if (bankTransId != null)
						{
							updated = BankUISearchMoneyTransaction.updateTransaction(bankTransId,transTypeId, getShell());
						}
					}
					else if (type == EngBLCommon.CURRENT_TRANS_BILL)
					{
						HashBag result = (HashBag)EngTXCommon.doSelectTX( CurBLSearchTransaction.class.getName(),"getBillofCurrentTrans",argMap);
						
						Integer bankTransId = (Integer)result.get(BillKeys.BILL_ID);
						if (bankTransId != null)
						{
							updated = BillUIBillSearch.updateBill(bankTransId, getShell());
						}
					}
					
					else if (type == EngBLCommon.CURRENT_TRANS_CHEQUE)
					{
						HashBag result = (HashBag)EngTXCommon.doSelectTX(CurBLSearchTransaction.class.getName(),"getCheqeuTransaction",argMap);
						Integer bankTransId =(Integer)result.get(CheKeys.CHE_CHEQUE_ROLL_ID);
						Integer typeId =(Integer)result.get(EngKeys.TYPE_ID);
						if (bankTransId != null)
						{
							updated = CheUIChequeRollSearch.rollUpdate(bankTransId,typeId, getShell());
						}
					}
					else if (type == EngBLCommon.CURRENT_TRANS_CASH)
					{
						HashBag result = (HashBag)EngTXCommon.doSelectTX(CurBLSearchTransaction.class.getName(),"getCashTransaction",argMap);
						Integer bankTransId = (Integer)result.get(CashKeys.CASH_TRANSACTION_ID);
						if (bankTransId != null)
						{
							updated = CashUICashTransactionSearch.updateCashTransaction(bankTransId, getShell());
						}
					}
					else if (type == EngBLCommon.CURRENT_TRANS_BETWEEN_ACCOUNTS)
					{
						
							updated =new CurUICurrentTransferUpdate(getShell(),SWT.NONE,transId).open();
						
					}
                    else if (type == EngBLCommon.CURRENT_TRANS_MULTIPLE_CREDIT)
                    {
                            updated =new CurUIMultipleCreditVoucherUpdate(getShell(),SWT.NONE,transId).open();
                        
                    }
                    else if (type == EngBLCommon.CURRENT_TRANS_MULTIPLE_DEPT)
                    {
                            updated =new CurUIMultipleDeptVoucherUpdate(getShell(),SWT.NONE,transId).open();
                        
                    }
					
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCurrentTransactions, CurLangKeys.STR_CURRENT_TRANSACTIONS); //$NON-NLS-1$
	}
}