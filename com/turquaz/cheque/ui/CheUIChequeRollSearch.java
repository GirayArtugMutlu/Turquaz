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
import java.util.List;

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

import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchChequeRoll;
import com.turquaz.cheque.bl.CheBLUpdateChequeRoll;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqChequeTransactionType;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder,
 * which is free for non-commercial use. If Jigloo is being used commercially
 * (ie, by a corporation, company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo. Please visit
 * www.cloudgarden.com for details. Use of Jigloo implies acceptance of these
 * licensing terms. ************************************* A COMMERCIAL LICENSE
 * HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be
 * used legally for any corporate or commercial purpose.
 * *************************************
 */
public class CheUIChequeRollSearch extends org.eclipse.swt.widgets.Composite
		implements SearchComposite {

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

	public CheUIChequeRollSearch(org.eclipse.swt.widgets.Composite parent,
			int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
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
					lblRollNo.setText(Messages
							.getString("CheUIChequeRollSearch.0")); //$NON-NLS-1$
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
					lblStartDate.setText(Messages
							.getString("CheUIChequeRollSearch.1")); //$NON-NLS-1$
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
					lblEndDate.setText(Messages
							.getString("CheUIChequeRollSearch.2")); //$NON-NLS-1$
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
					lblType.setText(Messages
							.getString("CheUIChequeRollSearch.3")); //$NON-NLS-1$
				}
				{
					comboRollType = new CCombo(compSearchPanel, SWT.NONE);
					GridData comboRollTypeLData = new GridData();
					comboRollType.setText(Messages
							.getString("CheUIChequeRollSearch.4")); //$NON-NLS-1$
					comboRollTypeLData.widthHint = 92;
					comboRollTypeLData.heightHint = 14;
					comboRollType.setLayoutData(comboRollTypeLData);
				}
			}
			{
				tableChequeRolls = new Table(this, SWT.FULL_SELECTION);
				GridData tableChequeRollsLData = new GridData();
				tableChequeRolls.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
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
					tableColumnDate = new TableColumn(tableChequeRolls,
							SWT.NONE);
					tableColumnDate.setText(Messages
							.getString("CheUIChequeRollSearch.5")); //$NON-NLS-1$
					tableColumnDate.setWidth(76);
				}
				{
					tableColumnRolNo = new TableColumn(tableChequeRolls,
							SWT.NONE);
					tableColumnRolNo.setText(Messages
							.getString("CheUIChequeRollSearch.6")); //$NON-NLS-1$
					tableColumnRolNo.setWidth(88);
				}
				{
					tableColumnType = new TableColumn(tableChequeRolls,
							SWT.NONE);
					tableColumnType.setText(Messages
							.getString("CheUIChequeRollSearch.7")); //$NON-NLS-1$
					tableColumnType.setWidth(75);
				}
				{
					tableColumnOwner = new TableColumn(tableChequeRolls,
							SWT.NONE);
					tableColumnOwner.setText(Messages
							.getString("CheUIChequeRollSearch.8")); //$NON-NLS-1$
					tableColumnOwner.setWidth(102);
				}
				//START >>  tableColumnAmount
				tableColumnAmount = new TableColumn(tableChequeRolls, SWT.RIGHT);
				tableColumnAmount.setText(Messages.getString("CheUIChequeRollSearch.10")); //$NON-NLS-1$
				tableColumnAmount.setWidth(100);
				//END <<  tableColumnAmount
			}
			postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void postInitGUI() {
		try {
			comboRollType.add(Messages.getString("CheUIChequeRollSearch.9")); //$NON-NLS-1$
			List ls = CheBLSearchChequeRoll.getTransactionTypes();
			for (int i = 0; i < ls.size(); i++) {
				TurqChequeTransactionType type = (TurqChequeTransactionType) ls
						.get(i);
				comboRollType.add(type.getTransactionTypsName());
				comboRollType.setData(type.getTransactionTypsName(), type);

			}
			
			dateEndDate.setLastDayOfYear();
			dateStartDate.setFirstDayOfYear();
			

		} catch (Exception ex) {

			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), ex.getMessage().toString(),
					SWT.ICON_ERROR);
		}

	}

	public void tableMouseDoubleClick() {
		try {
			TableItem selection[] = tableChequeRolls.getSelection();
			if (selection.length > 0) {
				Integer rollId = (Integer) selection[0].getData();
				boolean isUpdated=rollUpdate(rollId, this.getShell());
				if (isUpdated)
				{
						search();
				}
			}
		} 
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}

	}

	public static boolean rollUpdate(Integer rollId, Shell updateShell)
	{
		try
		{
			if (rollId != null)
			{
				boolean isUpdated = false;
				TurqChequeRoll roll = CheBLUpdateChequeRoll
						.initializeChequeRoll(rollId);

				if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_IN) {
					isUpdated = new CheUIChequeInPayrollUpdate(updateShell,
							SWT.NULL, roll).open();
				} else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_OUT_CURRENT) {
					isUpdated = new CheUIChequeOutPayrollCurrentUpdate(
							updateShell, SWT.NULL, roll).open();
				} else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_OUT_BANK) {
					isUpdated = new CheUIChequeOutPayrollBankUpdate(
							updateShell, SWT.NULL, roll).open();
				}
				else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_BANK) {
					isUpdated = new CheUIChequeCollectFromBankUpdate(
							updateShell, SWT.NULL, roll).open();
				}
				else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_COLLECT_FROM_CURRENT) {
					isUpdated = new CheUIChequeCollectUpdate(
							updateShell, SWT.NULL, roll).open();
				}
				else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_BANK) {
					isUpdated = new CheUIReturnFromBankRollUpdate(
							updateShell, SWT.NULL, roll).open();
				}
				else if (roll.getTurqChequeTransactionType()
						.getId().intValue() == EngBLCommon.CHEQUE_TRANS_RETURN_FROM_CURRENT) {
					isUpdated = new CheUIReturnFromCurrentUpdate(
							updateShell, SWT.NULL, roll).open();
				}
				
				return isUpdated;
			}
			else
				return false;

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return true;
		}
	}
	
	public void delete()
	{
		
	}

	public void exportToExcel() {
		EngBLUtils.Export2Excel(tableChequeRolls);

	}

	public void printTable() {
		 EngBLUtils.printTable(tableChequeRolls,Messages.getString("CheUIChequeRollSearch.11"));   //$NON-NLS-1$
		   

	}

	public void search() {
		try {
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			tableChequeRolls.removeAll();
			List ls = CheBLSearchChequeRoll.searchChequeRoll(txtRollNo
					.getText().trim(), dateStartDate.getDate(), dateEndDate
					.getDate(), (TurqChequeTransactionType) comboRollType
					.getData(comboRollType.getText().trim()));
			TableItem item;
			Object[] roll;
			String owner = ""; //$NON-NLS-1$
			
			BigDecimal total = new BigDecimal(0);
			
			
			for (int i = 0; i < ls.size(); i++) {

				roll = (Object[]) ls.get(i);
				item = new TableItem(tableChequeRolls, SWT.NULL);

				Integer rollId = (Integer) roll[0];
				Date cheqRollDate = (Date) roll[1];
				String cheqRollNo = (String) roll[2];
				String transTypeName = (String) roll[3];
				String cardName = (String) roll[4];
				String bankCode = (String) roll[5];
				Integer curCardId = (Integer) roll[6];
				Integer bankCardId = (Integer) roll[7];

				item.setData(rollId);

				if (curCardId.intValue() != -1) {
					owner = cardName;

				} else if (bankCardId.intValue() != -1) {
					owner = bankCode;
				}

				item.setText(new String[] {
						DatePicker.formatter.format(cheqRollDate), cheqRollNo,
						transTypeName, owner,cf.format(roll[8]) });
				
				total = total.add((BigDecimal)roll[8]);
				

			}
			item = new TableItem(tableChequeRolls, SWT.NULL);
			item = new TableItem(tableChequeRolls, SWT.NULL);
			item.setText(new String[] {
					"", "",
					"","Toplam",cf.format(total) });
			


		} catch (Exception ex) {
			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), ex.getMessage(),
					SWT.ICON_ERROR);
		}

	}
}