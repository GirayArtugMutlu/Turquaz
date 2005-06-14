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
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.bank.BankKeys;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.bl.CheBLSearchChequeRoll;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CheLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUIChequeRollSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite compSearchPanel;
	private Table tableChequeRolls;
	private TableColumn tableColumnDate;
	private CLabel lblEndDate;
	private CLabel lblType;
	private TableColumn tableColumnAmount;
	private CCombo comboRollType;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private TableColumn tableColumnOwner;
	private TableColumn tableColumnType;
	private TableColumn tableColumnRolNo;
	private SearchTableViewer tableViewer = null;

	public CheUIChequeRollSearch(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(663, 336);
			{
				compSearchPanel = new Composite(this, SWT.NONE);
				GridLayout compSearchPanelLayout = new GridLayout();
				GridData compSearchPanelLData = new GridData();
				compSearchPanelLData.grabExcessHorizontalSpace = true;
				compSearchPanelLData.horizontalAlignment = GridData.FILL;
				compSearchPanelLData.heightHint = 121;
				compSearchPanel.setLayoutData(compSearchPanelLData);
				compSearchPanelLayout.numColumns = 2;
				compSearchPanel.setLayout(compSearchPanelLayout);
				{
					lblRollNo = new CLabel(compSearchPanel, SWT.NONE);
					lblRollNo.setText(CheLangKeys.STR_ROLL_NO); //$NON-NLS-1$
				}
				{
					txtRollNo = new Text(compSearchPanel, SWT.NONE);
					GridData txtRollNoLData = new GridData();
					txtRollNoLData.widthHint = 110;
					txtRollNoLData.heightHint = 15;
					txtRollNo.setLayoutData(txtRollNoLData);
				}
				{
					lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePicker1LData = new GridData();
					datePicker1LData.widthHint = 116;
					datePicker1LData.heightHint = 22;
					dateStartDate.setLayoutData(datePicker1LData);
				}
				{
					lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 115;
					dateEndDateLData.heightHint = 20;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(compSearchPanel, SWT.NONE);
					lblType.setText(CheLangKeys.STR_ROLL_TYPE); //$NON-NLS-1$
				}
				{
					comboRollType = new CCombo(compSearchPanel, SWT.NONE);
					GridData comboRollTypeLData = new GridData();
					comboRollType.setText(EngLangCommonKeys.STR_ALL); //$NON-NLS-1$
					comboRollTypeLData.widthHint = 92;
					comboRollTypeLData.heightHint = 14;
					comboRollType.setLayoutData(comboRollTypeLData);
				}
			}
			{
				tableChequeRolls = new Table(this, SWT.FULL_SELECTION);
				GridData tableChequeRollsLData = new GridData();
				tableChequeRolls.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableMouseDoubleClick();
					}
				});
				tableChequeRolls.setLinesVisible(true);
				tableChequeRolls.setHeaderVisible(true);
				tableChequeRollsLData.grabExcessHorizontalSpace = true;
				tableChequeRollsLData.horizontalAlignment = GridData.FILL;
				tableChequeRollsLData.grabExcessVerticalSpace = true;
				tableChequeRollsLData.verticalAlignment = GridData.FILL;
				tableChequeRolls.setLayoutData(tableChequeRollsLData);
				{
					tableColumnDate = new TableColumn(tableChequeRolls, SWT.NONE);
					tableColumnDate.setText(CheLangKeys.STR_ROLL_DATE); //$NON-NLS-1$
					tableColumnDate.setWidth(76);
				}
				{
					tableColumnRolNo = new TableColumn(tableChequeRolls, SWT.NONE);
					tableColumnRolNo.setText(CheLangKeys.STR_ROLL_NO); //$NON-NLS-1$
					tableColumnRolNo.setWidth(88);
				}
				{
					tableColumnType = new TableColumn(tableChequeRolls, SWT.NONE);
					tableColumnType.setText(CheLangKeys.STR_ROLL_TYPE); //$NON-NLS-1$
					tableColumnType.setWidth(75);
				}
				{
					tableColumnOwner = new TableColumn(tableChequeRolls, SWT.NONE);
					tableColumnOwner.setText(CheLangKeys.STR_ROLL_OWNER); //$NON-NLS-1$
					tableColumnOwner.setWidth(102);
				}
				//START >> tableColumnAmount
				tableColumnAmount = new TableColumn(tableChequeRolls, SWT.RIGHT);
				tableColumnAmount.setText(EngLangCommonKeys.STR_TOTALPRICE); //$NON-NLS-1$
				tableColumnAmount.setWidth(100);
				//END << tableColumnAmount
			}
			postInitGUI();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGUI()
	{
		try
		{
			comboRollType.add(EngLangCommonKeys.STR_ALL); //$NON-NLS-1$
			HashBag typeBag =(HashBag)EngTXCommon.doSelectTX(CheBLSearchChequeRoll.class.getName(),"getTransactionTypes",null);
			
			HashMap typeList = (HashMap)typeBag.get(EngKeys.TYPES);
			
			
			
			for (int i = 0; i < typeList.size(); i++)
			{
				HashMap typeInfo = (HashMap) typeList.get(new Integer(i));
				comboRollType.add(typeInfo.get(EngKeys.TYPE_NAME).toString());
				comboRollType.setData(typeInfo.get(EngKeys.TYPE_NAME).toString(), typeInfo.get(EngKeys.TYPE_ID));
			}
			dateEndDate.setLastDayOfYear();
			dateStartDate.setFirstDayOfYear();
			createTableViewer();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem selection[] = tableChequeRolls.getSelection();
			if (selection.length > 0)
			{
				Integer data[] = (Integer[]) ((ITableRow) selection[0].getData()).getDBObject();
				boolean isUpdated = rollUpdate(data[0],data[1], this.getShell());
				if (isUpdated)
				{
					search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public static boolean rollUpdate(Integer rollId,Integer typeId, Shell updateShell) throws Exception
	{
		try
		{
			if (rollId != null)
			{
				boolean isUpdated = false;
				
				
				if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_IN.intValue())
				{
					isUpdated = new CheUIChequeInPayrollUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT.intValue())
				{
					isUpdated = new CheUIChequeOutPayrollCurrentUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_OUT_BANK.intValue())
				{
					isUpdated = new CheUIChequeOutPayrollBankUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK
						.intValue())
				{
					isUpdated = new CheUIChequeCollectFromBankUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT
						.intValue())
				{
					isUpdated = new CheUIChequeCollectUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK_TO_PORTFOY
						.intValue())
				{
					isUpdated = new CheUIReturnFromBankRollUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_TO_CURRENT
						.intValue())
				{
					isUpdated = new CheUIReturnFromCurrentUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT
						.intValue())
				{
					isUpdated = new CheUIReturnFromGivenChequesUpdate(updateShell, SWT.NULL, rollId).open();
				}
				else if (typeId.intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_OF_OWN_CHEQUE.intValue())
				{
					isUpdated = new CheUIOwnChequeCollectUpdate(updateShell, SWT.NULL, rollId).open();
				}
				return isUpdated;
			}
			else
				return false;
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableChequeRolls, columnTypes, true);
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
		EngBLUtils.printTable(tableChequeRolls, CheLangKeys.STR_ROLLS); //$NON-NLS-1$
	}

	public void search()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableViewer.removeAll();
			
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.DOCUMENT_NO,txtRollNo.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(CheKeys.CHE_TRANS_TYPE,comboRollType.getData(comboRollType.getText().trim()));
			
			HashBag infoBag = (HashBag)EngTXCommon.doSelectTX(CheBLSearchChequeRoll.class.getName(),"searchChequeRoll",argMap );
			HashMap rollList = (HashMap)infoBag.get(CheKeys.CHE_CHEQUE_ROLLS);
			
			
			
			
			
			HashMap rollInfo;
			String owner = ""; //$NON-NLS-1$
			BigDecimal total = new BigDecimal(0);
			for (int i = 0; i < rollList.size(); i++)
			{
				rollInfo = (HashMap) rollList.get(new Integer(i));
				
				Integer rollId = (Integer) rollInfo.get(CheKeys.CHE_CHEQUE_ROLL_ID);
				Date cheqRollDate = (Date) rollInfo.get(EngKeys.DATE);
				String cheqRollNo = (String) rollInfo.get(EngKeys.DOCUMENT_NO);
				String transTypeName = (String)rollInfo.get(EngKeys.TYPE_NAME);
				String cardName = (String) rollInfo.get(CurKeys.CUR_CURRENT_NAME);
				String bankCode = (String) rollInfo.get(BankKeys.BANK_CODE);
				Integer curCardId = (Integer) rollInfo.get(CurKeys.CUR_CARD_ID);
				Integer bankCardId = (Integer) rollInfo.get(BankKeys.BANK_ID);
				BigDecimal chequeAmount = (BigDecimal)rollInfo.get(EngKeys.TOTAL_AMOUNT);
				Integer typeId = (Integer)rollInfo.get(EngKeys.TYPE_ID);
				if (curCardId.intValue() != -1)
				{
					owner = cardName;
				}
				else if (bankCardId.intValue() != -1)
				{
					owner = bankCode;
				}
				Integer[]data =new Integer[]{rollId,typeId};
				tableViewer.addRow(new String[]{DatePicker.formatter.format(cheqRollDate), cheqRollNo, transTypeName, owner,
						cf.format(chequeAmount)}, data);
				total = total.add((BigDecimal) chequeAmount);
			}
			tableViewer.addRow(new String[]{"", "", "", "", ""}, null);
			tableViewer.addRow(new String[]{"", "", "", "Toplam", cf.format(total)}, null);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}