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
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLProfitAnalysis;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUIProfitAnalysis extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Table tableInvTotals;
	private TableColumn tableColumnTotalAmountOut;
	private TableColumn tableColumnInvCardName;
	private TableColumn tableColumnProfit;
	private TableColumn tableColumnPriceOut;
	private TableColumn tableColumnCostOut;
	private TableColumn tableColumnTotalAmount;
	private TableColumn tableColumnAvgPrice;
	private TableColumn tableColumnInvCard;
	private SearchTableViewer tableViewer = null;

	public InvUIProfitAnalysis(org.eclipse.swt.widgets.Composite parent, int style)
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
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.verticalSpacing = 0;
			this.setSize(586, 211);
			{
				tableInvTotals = new Table(this, SWT.NONE);
				GridData tableInvTotalsLData = new GridData();
				tableInvTotals.setLinesVisible(true);
				tableInvTotals.setHeaderVisible(true);
				tableInvTotalsLData.grabExcessHorizontalSpace = true;
				tableInvTotalsLData.grabExcessVerticalSpace = true;
				tableInvTotalsLData.horizontalAlignment = GridData.FILL;
				tableInvTotalsLData.verticalAlignment = GridData.FILL;
				tableInvTotals.setLayoutData(tableInvTotalsLData);
				{
					tableColumnInvCard = new TableColumn(tableInvTotals, SWT.NONE);
					tableColumnInvCard.setText(Messages.getString("InvUIProfitAnalysis.0")); //$NON-NLS-1$
					tableColumnInvCard.setWidth(100);
				}
				//START >> tableColumnInvCardName
				tableColumnInvCardName = new TableColumn(tableInvTotals, SWT.NONE);
				tableColumnInvCardName.setText("Stok Cinsi");
				tableColumnInvCardName.setWidth(100);
				//END << tableColumnInvCardName
				{
					tableColumnTotalAmount = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnTotalAmount.setText(Messages.getString("InvUIProfitAnalysis.1")); //$NON-NLS-1$
					tableColumnTotalAmount.setWidth(73);
				}
				{
					tableColumnAvgPrice = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnAvgPrice.setText(Messages.getString("InvUIProfitAnalysis.2")); //$NON-NLS-1$
					tableColumnAvgPrice.setWidth(97);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnTotalAmountOut.setText(Messages.getString("InvUIProfitAnalysis.3")); //$NON-NLS-1$
					tableColumnTotalAmountOut.setWidth(77);
				}
				{
					tableColumnCostOut = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnCostOut.setText(Messages.getString("InvUIProfitAnalysis.4")); //$NON-NLS-1$
					tableColumnCostOut.setWidth(82);
				}
				{
					tableColumnPriceOut = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnPriceOut.setText(Messages.getString("InvUIProfitAnalysis.5")); //$NON-NLS-1$
					tableColumnPriceOut.setWidth(75);
				}
				{
					tableColumnProfit = new TableColumn(tableInvTotals, SWT.RIGHT);
					tableColumnProfit.setText(Messages.getString("InvUIProfitAnalysis.6")); //$NON-NLS-1$
					tableColumnProfit.setWidth(75);
				}
			}
			this.layout();
			PostInitGui();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void PostInitGui()
	{
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[8];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableInvTotals, columnTypes, true);
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			List ls = (List)EngTXCommon.doSingleTX(InvBLProfitAnalysis.class.getName(),"getTransactionTotals",null);
			BigDecimal amountNow;
			BigDecimal avgPrice;
			BigDecimal amountOut;
			BigDecimal amountIn;
			BigDecimal totalCost;
			BigDecimal totalPrice;
			BigDecimal totalProfit;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			Object[] result;
			for (int i = 0; i < ls.size(); i++)
			{
				amountNow = new BigDecimal(0);
				avgPrice = new BigDecimal(0);
				amountOut = new BigDecimal(0);
				totalCost = new BigDecimal(0);
				totalPrice = new BigDecimal(0);
				totalProfit = new BigDecimal(0);
				amountIn = new BigDecimal(0);
				result = (Object[]) ls.get(i);
				String invCardCode = (String) result[0];
				String invCardName = (String) result[1];
				BigDecimal inAmount = (BigDecimal) result[2];
				BigDecimal outAmount = (BigDecimal) result[3];
				BigDecimal inPrice = (BigDecimal) result[4];
				BigDecimal outPrice = (BigDecimal) result[5];
				if (inAmount != null && outAmount != null)
				{
					amountNow = inAmount.subtract(outAmount);
				}
				else
				{
					if (inAmount != null)
					{
						amountNow = inAmount;
					}
					else if (outAmount != null)
					{
						amountNow = outAmount.negate();
					}
				}
				if (inAmount != null)
				{
					avgPrice = inPrice.divide(inAmount, 2, BigDecimal.ROUND_HALF_UP);
				}
				if (outAmount != null)
				{
					amountOut = outAmount;
				}
				if (inAmount != null)
				{
					amountIn = inAmount;
				}
				totalCost = avgPrice.multiply(amountOut);
				if (outPrice != null)
				{
					totalPrice = outPrice;
				}
				totalProfit = totalPrice.subtract(totalCost);
				tableViewer.addRow(new String[]{invCardCode, invCardName, cf.format(amountIn), cf.format(avgPrice),
						cf.format(amountOut), cf.format(totalCost), cf.format(totalPrice), cf.format(totalProfit)}, invCardCode);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableInvTotals);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInvTotals, Messages.getString("InvUIProfitAnalysis.7")); //$NON-NLS-1$
	}
}