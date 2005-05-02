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
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.bill.ui.BillUIBillUpdateDialog;
import com.turquaz.consignment.ui.ConUIConsignmentUpdateDialog;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqEngineSequence;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLSearchTransaction;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for anycorporate or commercial purpose. *************************************
 */
public class InvUITransactionSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compInvTransactionSearch;
	private Table tableTransactions;
	private TableColumn tableColumnTotalAmountOut;
	private CLabel lblInvCard;
	private TableColumn tableColumnInventoryName;
	private TableColumn tableColumnTotalPriceIn;
	private TableColumn tableColumnInventoryCode;
	private InventoryPicker txtInvCard;
	private CCombo comboTransactionsType;
	private CurrentPicker txtCurCard;
	private CLabel lblType;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnTotalAmountIn;
	private TableColumn tableColumnTotalPriceOut;
	private TableColumn tableColumnTransactionDate;
	private Calendar cal = Calendar.getInstance();
	private SearchTableViewer tableViewer = null;

	public InvUITransactionSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(591, 344);
			{
				compInvTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 84;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				compInvTransactionSearch.setLayoutData(composite1LData);
				compInvTransactionSearch.setLayout(composite1Layout);
				//START >> lblInvCard
				lblInvCard = new CLabel(compInvTransactionSearch, SWT.NONE);
				lblInvCard.setText(InvLangKeys.STR_INV_CARD);
				//END << lblInvCard
				{
					txtInvCard = new InventoryPicker(compInvTransactionSearch, SWT.NONE);
					GridData textWithButton1LData = new GridData();
					textWithButton1LData.widthHint = 150;
					textWithButton1LData.heightHint = 17;
					txtInvCard.setLayoutData(textWithButton1LData);
				}
				{
					lblCurrentCard = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD);
				}
				{
					txtCurCard = new CurrentPicker(compInvTransactionSearch, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 150;
					txtCurCardLData.heightHint = 17;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblStartDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(compInvTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 150;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 89;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(compInvTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 150;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(compInvTransactionSearch, SWT.NONE);
					lblType.setText(EngLangCommonKeys.STR_TYPE);
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboTransactionsType = new CCombo(compInvTransactionSearch, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentTypeLData.widthHint = 127;
					comboConsignmentTypeLData.heightHint = 18;
					comboTransactionsType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			{
				tableTransactions = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				tableTransactions.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						showConsignment();
					}
				});
				tableTransactions.setHeaderVisible(true);
				tableTransactions.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableTransactions.setLayoutData(tableConsignmentsLData);
				{
					tableColumnTransactionDate = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnTransactionDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnTransactionDate.setWidth(88);
				}
				{
					tableColumnInventoryCode = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnInventoryCode.setText(InvLangKeys.STR_INV_CODE);
					tableColumnInventoryCode.setWidth(108);
				}
				{
					tableColumnInventoryName = new TableColumn(tableTransactions, SWT.NONE);
					tableColumnInventoryName.setText(InvLangKeys.STR_INV_NAME);
					tableColumnInventoryName.setWidth(100);
				}
				{
					tableColumnTotalAmountIn = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalAmountIn.setText(InvLangKeys.STR_AMOUNT_IN);
					tableColumnTotalAmountIn.setWidth(100);
				}
				{
					tableColumnTotalPriceIn = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceIn.setText(InvLangKeys.STR_PRICE_IN);
					tableColumnTotalPriceIn.setWidth(100);
				}
				{
					tableColumnTotalAmountOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalAmountOut.setText(InvLangKeys.STR_AMOUNT_OUT);
					tableColumnTotalAmountOut.setWidth(100);
				}
				{
					tableColumnTotalPriceOut = new TableColumn(tableTransactions, SWT.RIGHT);
					tableColumnTotalPriceOut.setText(InvLangKeys.STR_PRICE_OUT);
					tableColumnTotalPriceOut.setWidth(100);
				}
			}
			postInitGui();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void showConsignment()
	{
		try
		{
			TableItem items[] = tableTransactions.getSelection();
			if (items.length > 0)
			{
				Integer transId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (transId != null)
				{
					boolean updated = false;
					HashMap argMap=new HashMap();
					argMap.put(EngKeys.TRANS_ID,transId);
					TurqInventoryTransaction invTrans =(TurqInventoryTransaction)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getInvTransByTransId",argMap);
					TurqEngineSequence seq = invTrans.getTurqEngineSequence();
					argMap=new HashMap();
					argMap.put(EngKeys.ENG_SEQ,seq);
					TurqBill bill =(TurqBill)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getBill",argMap);
					TurqConsignment cons;
					argMap=new HashMap();
					argMap.put(EngKeys.ENG_SEQ,seq);
					if (bill != null)
					{
						updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, bill).open();
					}
					else if ((cons = (TurqConsignment)EngTXCommon.doSelectTX(InvBLSearchTransaction.class.getName(),"getConsignment",argMap)) != null)
					{
						updated = new ConUIConsignmentUpdateDialog(this.getShell(), SWT.NULL, cons).open();
					}
					else
					{
						//TODO Uretimten gelen stok hareketi. Uretim fisini acmali..
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

	public void postInitGui()
	{
		comboTransactionsType.add(EngBLCommon.COMMON_ALL_STRING);
		comboTransactionsType.add(EngBLCommon.COMMON_BUY_STRING);
		comboTransactionsType.add(EngBLCommon.COMMON_SELL_STRING);
		comboTransactionsType.setText(EngBLCommon.COMMON_ALL_STRING);
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		createTableViewer();
	}

	public void save()
	{
	}

	public void search()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableViewer.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
			{
				type = EngBLCommon.COMMON_BUY_INT;
			}
			else if (comboTransactionsType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
			{
				type = EngBLCommon.COMMON_SELL_INT;
			}
			HashMap argMap=new HashMap();
			argMap.put(EngKeys.CURRENT_CARD,txtCurCard.getData());
			argMap.put(InvKeys.INV_CARD,txtInvCard.getData());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.TYPE,new Integer(type));
			
			List list = (List)EngTXCommon.doTransactionTX(InvBLSearchTransaction.class.getName(),"searchTransactions",argMap);
			TurqInventoryTransaction transactions;
			for (int i = 0; i < list.size(); i++)
			{
				Object result[] = (Object[]) list.get(i);
				Integer transId = (Integer) result[0];
				Date transDate = (Date) result[1];
				BigDecimal inAmount = (BigDecimal) result[2];
				BigDecimal outAmount = (BigDecimal) result[3];
				BigDecimal totalPrice = (BigDecimal) result[4];
				String invCode = (String) result[5];
				String invName = (String) result[6];
				BigDecimal priceIn = new BigDecimal(0);
				BigDecimal priceOut = new BigDecimal(0);
				if (inAmount.doubleValue() == 0)
				{
					priceOut = totalPrice;
				}
				else
				{
					priceIn = totalPrice;
				}
				tableViewer.addRow(new String[]{DatePicker.formatter.format(transDate), invCode, invName, cf.format(inAmount) + "", //$NON-NLS-1$								
						cf.format(priceIn), cf.format(outAmount) + "", //$NON-NLS-1$
						cf.format(priceOut)}, transId);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[7];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableTransactions, columnTypes, true);
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableTransactions, InvLangKeys.STR_INV_TRANSACTIONS);
	}
}