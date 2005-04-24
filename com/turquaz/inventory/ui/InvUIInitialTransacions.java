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
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSearchTransaction;

public class InvUIInitialTransacions extends org.eclipse.swt.widgets.Composite
{
	private Table tableInitialTransactions;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnPrice;
	private TableColumn tableColumnAmount;
	SaveTableViewer tableViewer = null;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		InvUIInitialTransacions inst = new InvUIInitialTransacions(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

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
			tableColumnInvCode.setText("Stok Kodu");
			tableColumnInvCode.setWidth(106);
			//END << tableColumnInvCode
			//START >> tableColumnInvName
			tableColumnInvName = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnInvName.setText("Stok Ad\u0131");
			tableColumnInvName.setWidth(105);
			//END << tableColumnInvName
			//START >> tableColumnAmount
			tableColumnAmount = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnAmount.setText("Miktar");
			tableColumnAmount.setWidth(104);
			//END << tableColumnAmount
			//START >> tableColumnPrice
			tableColumnPrice = new TableColumn(tableInitialTransactions, SWT.NONE);
			tableColumnPrice.setText("Tutar\u0131");
			tableColumnPrice.setWidth(106);
			//END << tableColumnPrice
			//END << tableInitialTransactions
			this.layout();
			postInitGui();
		}
		catch (Exception e)
		{
			e.printStackTrace();
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
			List ls = (List)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getInitialTransactions",null);
			for (int i = 0; i < ls.size(); i++)
			{
				InvUIInitialTransactionTableRow tableRow = new InvUIInitialTransactionTableRow();
				tableRow.setDBObject(ls.get(i));
				tableViewer.addRow(tableRow);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
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
					EngTXCommon.doTransactionTX(EngBLCommon.class.getName(),"update",argMap);
				}
				catch (Exception ex)
				{
					Logger loger = Logger.getLogger(this.getClass());
					loger.error("Exception Caught", ex);
					ex.printStackTrace();
				}
			}
		});
	}
}