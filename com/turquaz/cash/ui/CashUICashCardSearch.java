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
import java.util.HashMap;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.ui.comp.AccountPickerLeaf;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.cash.CashKeys;
import com.turquaz.cash.bl.CashBLCashCardSearch;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.CashLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;

/**
 * @author onsel
 * @version $Id$
 */
public class CashUICashCardSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite composite1;
	private CLabel lblCardCode;
	private CLabel lblAccountCode;
	private TableColumn tableColumnAccount;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnCashCode;
	private Table tableCashCards;
	private AccountPickerLeaf accountPicker;
	private Text txtCardCode;
	private SearchTableViewer tableViewer = null;

	public CashUICashCardSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(528, 232);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 68;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1Layout.numColumns = 2;
				composite1.setLayout(composite1Layout);
				{
					lblCardCode = new CLabel(composite1, SWT.NONE);
					lblCardCode.setText(CashLangKeys.STR_CASH_CARD);
				}
				{
					txtCardCode = new Text(composite1, SWT.NONE);
					GridData txtCardCodeLData = new GridData();
					txtCardCodeLData.widthHint = 150;
					txtCardCodeLData.heightHint = 17;
					txtCardCode.setLayoutData(txtCardCodeLData);
				}
				{
					lblAccountCode = new CLabel(composite1, SWT.NONE);
					lblAccountCode.setText(AccLangKeys.STR_ACCOUNTING_ACCOUNT);
					lblAccountCode.setSize(-1, 19);
				}
				{
					accountPicker = new AccountPickerLeaf(composite1, SWT.NONE);
					GridData accountPickerLData = new GridData();
					accountPickerLData.widthHint = 157;
					accountPickerLData.heightHint = 17;
					accountPicker.setLayoutData(accountPickerLData);
				}
			}
			{
				tableCashCards = new Table(this, SWT.FULL_SELECTION);
				GridData tableCashCardsLData = new GridData();
				tableCashCards.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						treeMouseDoubleClick();
					}
				});
				tableCashCards.setLinesVisible(true);
				tableCashCards.setHeaderVisible(true);
				tableCashCardsLData.grabExcessHorizontalSpace = true;
				tableCashCardsLData.grabExcessVerticalSpace = true;
				tableCashCardsLData.horizontalAlignment = GridData.FILL;
				tableCashCardsLData.verticalAlignment = GridData.FILL;
				tableCashCards.setLayoutData(tableCashCardsLData);
				{
					tableColumnCashCode = new TableColumn(tableCashCards, SWT.NONE);
					tableColumnCashCode.setText(CashLangKeys.STR_CASH_CODE);
					tableColumnCashCode.setWidth(101);
				}
				{
					tableColumnDefinition = new TableColumn(tableCashCards, SWT.NONE);
					tableColumnDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION);
					tableColumnDefinition.setWidth(100);
				}
				{
					tableColumnAccount = new TableColumn(tableCashCards, SWT.NONE);
					tableColumnAccount.setText(AccLangKeys.STR_ACCOUNTING_ACCOUNT);
					tableColumnAccount.setWidth(125);
				}
			}
			createTableViewer();
			this.layout();
			PostInitGui();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void PostInitGui()
	{
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[3];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		tableViewer = new SearchTableViewer(tableCashCards, columnTypes, true);
	}

	public void delete()
	{
		// TODO should be implemented..
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCashCards, CashLangKeys.STR_CASH_CARDS);
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			HashMap argMap = new HashMap();
			argMap.put(AccKeys.ACC_ACCOUNT_CODE_ID, accountPicker.getData());
			argMap.put(CashKeys.CASH_CARD_NAME,txtCardCode.getText().trim());
			
			HashBag result  =(HashBag)EngTXCommon.doSelectTX(CashBLCashCardSearch.class.getName(),"searchCashCard",argMap);			
			HashMap cards = (HashMap)result.get(CashKeys.CASH_CARDS);
			
            for (int i = 0; i < cards.size(); i++)
			{
				HashMap cardInfo = (HashMap) cards.get(new Integer(i));
                
				tableViewer.addRow(new String[]{cardInfo.get(CashKeys.CASH_CARD_NAME).toString(), cardInfo.get(EngKeys.DEFINITION).toString(),
						cardInfo.get(AccKeys.ACC_ACCOUNT_CODE).toString()}, cardInfo.get(CashKeys.CASH_CARD_NAME));
			}
            
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void treeMouseDoubleClick()
	{
		TableItem selection[] = tableCashCards.getSelection();
		if (selection.length > 0)
		{
			TableItem item = selection[0];
			ITableRow row = (ITableRow) item.getData();
			new CashUICashCardUpdate(this.getShell(), SWT.NULL, (String) row.getDBObject()).open();
			search();
		}
	}
}