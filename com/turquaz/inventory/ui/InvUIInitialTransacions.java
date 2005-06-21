package com.turquaz.inventory.ui;

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
 * @author onsel
 * @version $Id$
 */
import java.util.HashMap;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSearchTransaction;
import com.turquaz.inventory.bl.InvBLUpdateTransaction;


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
public class InvUIInitialTransacions extends org.eclipse.swt.widgets.Composite
{
	private Table tableInitialTransactions;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnPrice;
	private TableColumn tableColumnAmount;
	SaveTableViewer tableViewer = null;

	public InvUIInitialTransacions(org.eclipse.swt.widgets.Composite parent, int style)
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
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginHeight = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(534, 364);
			//START >> tableInitialTransactions
			tableInitialTransactions = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
			GridData tableInitialTransactionsLData = new GridData();
			tableInitialTransactions.setLinesVisible(true);
			tableInitialTransactions.setHeaderVisible(true);
			tableInitialTransactionsLData.grabExcessHorizontalSpace = true;
			tableInitialTransactionsLData.horizontalAlignment = GridData.FILL;
			tableInitialTransactionsLData.grabExcessVerticalSpace = true;
			tableInitialTransactionsLData.verticalAlignment = GridData.FILL;
			tableInitialTransactions.setLayoutData(tableInitialTransactionsLData);
			//START >> tableColumnInvCode
			tableColumnInvCode = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnInvCode.setText(InvLangKeys.STR_INV_CODE);
			tableColumnInvCode.setWidth(106);
			//END << tableColumnInvCode
			//START >> tableColumnInvName
			tableColumnInvName = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnInvName.setText(InvLangKeys.STR_INV_NAME);
			tableColumnInvName.setWidth(105);
			//END << tableColumnInvName
			//START >> tableColumnAmount
			tableColumnAmount = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnAmount.setText(EngLangCommonKeys.STR_AMOUNT);
			tableColumnAmount.setWidth(104);
			//END << tableColumnAmount
			//START >> tableColumnPrice
			tableColumnPrice = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnPrice.setText(EngLangCommonKeys.STR_TOTALPRICE);
			tableColumnPrice.setWidth(106);
			//END << tableColumnPrice
			//END << tableInitialTransactions
			this.layout();
			postInitGui();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGui()
	{
		createTableViewer();
		fillTable();
	}

	public void fillTable()
	{
		try
		{
			HashBag transBag = (HashBag)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getInitialTransactions",null);
			HashMap transList=(HashMap)transBag.get(InvKeys.INV_TRANSACTIONS);
			for (int i = 0; i < transList.size(); i++)
			{
				InvUIInitialTransactionTableRow tableRow = new InvUIInitialTransactionTableRow();
				tableRow.setDBObject(transList.get(new Integer(i)));
				tableViewer.addRow(tableRow);
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void createTableViewer()
	{
		CellEditor editors[] = new CellEditor[4];
		editors[0] = new TextCellEditor(tableInitialTransactions);
		editors[1] = new TextCellEditor(tableInitialTransactions);
		editors[2] = new CurrencyCellEditor(tableInitialTransactions, 2);
		editors[3] = new CurrencyCellEditor(tableInitialTransactions, 2);
		tableViewer = new SaveTableViewer(tableInitialTransactions, editors);
		tableViewer.addChangeListener(new ITableRowListViewer()
		{
			public void removeRow(ITableRow row)
			{
			}

			public void addRow(ITableRow row)
			{
			}

			public void updateRow(ITableRow row)
			{
				try
				{
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_TRANS,row.getDBObject());
					EngTXCommon.doTransactionTX(InvBLUpdateTransaction.class.getName(),"updateInitialTransaction",argMap);
				}
				catch (Exception ex)
				{

                    EngBLLogger.log(this.getClass(),ex,getShell());
				}
			}
		});
	}
}