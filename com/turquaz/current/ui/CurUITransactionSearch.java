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
import java.util.List;


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;

import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.widgets.Text;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.bl.CurBLSearchTransaction;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqCurrentTransactionType;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;



import org.eclipse.swt.widgets.MessageBox;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;



import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import org.eclipse.swt.SWT;

import com.turquaz.current.ui.comp.CurrentPicker;
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
public class CurUITransactionSearch extends Composite implements SearchComposite {

	private CurBLSearchTransaction blSearch = new CurBLSearchTransaction();
	private CurBLCurrentTransactionAdd blTransAdd = new CurBLCurrentTransactionAdd();
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
	private Calendar cal=Calendar.getInstance();
	public CurUITransactionSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
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
					lblCurrentCard.setText(Messages.getString("CurUITransactionSearch.0")); //$NON-NLS-1$
					lblCurrentCard.setSize(new org.eclipse.swt.graphics.Point(
						85,
						20));
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 85;
					lblCurrentCardLData.heightHint = 20;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 174;
					txtCurCardLData.heightHint = 20;
					txtCurCard.setLayoutData(txtCurCardLData);
									}
				{
					lblTransactionGroup = new CLabel(composite1, SWT.NONE);
					lblTransactionGroup.setText(Messages.getString("CurUITransactionSearch.1")); //$NON-NLS-1$
					lblTransactionGroup
						.setSize(new org.eclipse.swt.graphics.Point(105, 18));
					GridData lblTransactionGroupLData = new GridData();
					lblTransactionGroupLData.widthHint = 105;
					lblTransactionGroupLData.heightHint = 18;
					lblTransactionGroup.setLayoutData(lblTransactionGroupLData);
				}
				{
					comboTransactionGroup = new CCombo(composite1, SWT.NONE);
					comboTransactionGroup
						.setSize(new org.eclipse.swt.graphics.Point(117, 17));
					GridData comboTransactionGroupLData = new GridData();
					comboTransactionGroupLData.widthHint = 95;
					comboTransactionGroupLData.heightHint = 17;
					comboTransactionGroup.setLayoutData(comboTransactionGroupLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(Messages.getString("CurUITransactionSearch.3")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 98;
					lblStartDateLData.heightHint = 19;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					dateStartDate.setSize(new org.eclipse.swt.graphics.Point(
						145,
						22));
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 145;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(Messages.getString("CurUITransactionSearch.4")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 94;
					lblEndDateLData.heightHint = 18;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					dateEndDate.setSize(new org.eclipse.swt.graphics.Point(
						142,
						22));
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 142;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
                {
                    lblDefinition = new CLabel(composite1, SWT.NONE);
                    lblDefinition.setText(Messages.getString("CurUITransactionSearch.10")); //$NON-NLS-1$
                }
                {
                    txtDefinition = new Text(composite1, SWT.NONE);
                    GridData txtDefinitionLData = new GridData();
                    txtDefinitionLData.widthHint = 170;
                    txtDefinitionLData.heightHint = 18;
                    txtDefinition.setLayoutData(txtDefinitionLData);
                }
			}
			{
				tableCurrentTransactions = new Table(this, SWT.FULL_SELECTION);
				tableCurrentTransactions.setHeaderVisible(true);
				tableCurrentTransactions.setLinesVisible(true);
				GridData tableCurrentTransactionsLData = new GridData();
				tableCurrentTransactions.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableCurrentTransactionsMouseDoubleClick(evt);
					}
				});
				tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
				tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
				tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
				{
					tableColumnTransDate = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnTransDate.setText(Messages.getString("CurUITransactionSearch.9")); //$NON-NLS-1$
					tableColumnTransDate.setWidth(98);
				}
				{
					tableColumnDocNo = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnDocNo.setText(Messages.getString("CurUITransactionSearch.2")); //$NON-NLS-1$
					tableColumnDocNo.setWidth(85);
				}
				{
					tableColumnCurrentCode = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnCurrentCode.setText(Messages.getString("CurUITransactionSearch.5")); //$NON-NLS-1$
					tableColumnCurrentCode.setWidth(82);
				}
				//START >>  tableColumnCurrentName
				tableColumnCurrentName = new TableColumn(
					tableCurrentTransactions,
					SWT.NONE);
				tableColumnCurrentName.setText("Cari Ad\u0131");
				tableColumnCurrentName.setWidth(122);
				//END <<  tableColumnCurrentName
				{
					tableColumnTransGroup = new TableColumn(
						tableCurrentTransactions,
						SWT.NONE);
					tableColumnTransGroup.setText(Messages.getString("CurUITransactionSearch.6")); //$NON-NLS-1$
					tableColumnTransGroup.setWidth(95);
				}
                {
                    tableColumn = new TableColumn(
                        tableCurrentTransactions,
                        SWT.NONE);
                    tableColumn.setText(Messages.getString("CurUITransactionSearch.13")); //$NON-NLS-1$
                    tableColumn.setWidth(100);
                }
				{
					tableColumnDebit = new TableColumn(
						tableCurrentTransactions,
						SWT.RIGHT);
					tableColumnDebit.setText(Messages.getString("CurUITransactionSearch.7")); //$NON-NLS-1$
					tableColumnDebit.setWidth(62);
				}
				{
					tableColumnCredit = new TableColumn(
						tableCurrentTransactions,
						SWT.RIGHT);
					tableColumnCredit.setText(Messages.getString("CurUITransactionSearch.8")); //$NON-NLS-1$
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
	cal.set(cal.get(Calendar.YEAR),0,1);
	dateStartDate.setDate(cal.getTime());
	fillComboTypes();


	}


	public void fillComboTypes(){
	try{
	List list = blTransAdd.getCurrentTransactionTypes();
	TurqCurrentTransactionType type ;	
	comboTransactionGroup.add("Hepsi");
	comboTransactionGroup.setData("Hepsi",null);
	for(int i =0;i<list.size();i++){

	type = (TurqCurrentTransactionType)list.get(i);
	comboTransactionGroup.add(type.getTransactionTypeName());
	comboTransactionGroup.setData(type.getTransactionTypeName(),type);	
	
	}
	comboTransactionGroup.setText("Hepsi");
		}
	catch(Exception ex){
	ex.printStackTrace();
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(ex.getMessage());
	msg.open();
	}
}
	
	
	public void save(){
	
	
	}
	public void search()
	{
		try
		{
			tableCurrentTransactions.removeAll();
			BigDecimal totalDept = new BigDecimal(0);
			BigDecimal totalCredit = new BigDecimal(0);
	
			List results =blSearch.searchCurrentTransaction(txtCurCard.getData(),
									 comboTransactionGroup.getData(comboTransactionGroup.getText()),
									 "",txtDefinition.getText().trim(),dateStartDate.getDate(),dateEndDate.getDate()); //$NON-NLS-1$
	
			Object[] transaction;
			TableItem item;
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			for(int i=0;i<results.size();i++)
			{
	
				transaction = (Object[])results.get(i);
				item = new TableItem(tableCurrentTransactions,SWT.NULL);
	
	
				Integer transId=(Integer)transaction[0];
				Date transDate=(Date)transaction[1];
				String transDocNo=(String)transaction[2];
				String curCardCode=(String) transaction[3];
				String curCardName=(String) transaction[4];
				String transTypeName=(String) transaction[5];
				String transDefinition=(String)transaction[6];
				BigDecimal transTotalDept=(BigDecimal)transaction[7];
				BigDecimal transTotalCredit=(BigDecimal)transaction[8];
	
				item.setData(transId);
	
	
				item.setText(new String[]{
								DatePicker.formatter.format(transDate),
								transDocNo,
								curCardCode,
								curCardName,
							    transTypeName,
								transDefinition,
								cf.format(transTotalDept),
								cf.format(transTotalCredit)
								});
				totalDept = totalDept.add(transTotalDept);
				totalCredit = totalCredit.add(transTotalCredit);
	
			}
			item = new TableItem(tableCurrentTransactions,SWT.NULL);
			item = new TableItem(tableCurrentTransactions,SWT.NULL);
			item.setText(new String[]{"","","","","","---TOPLAM---",cf.format(totalDept),cf.format(totalCredit)});	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	
	}
	
	
	public void delete()
	{
	
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
			if(items.length >0)
			{
				Integer transId=(Integer)items[0].getData();
				if (transId!=null)
				{
					TurqCurrentTransaction trans = CurBLSearchTransaction.getCurTransByTransId(transId);
					//nakit hareketi ise izin ver
					if(trans.getTurqCurrentTransactionType().getId().intValue()==EngBLCommon.CURRENT_TRANS_OTHERS)
					{
						boolean updated=new CurUIVoucherUpdate(this.getShell(),SWT.NULL,trans).open();
						if (updated)
							search();
	
					}
					else
					{
						MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
						msg.setMessage(Messages.getString("CurUITransactionSearch.11"));  //$NON-NLS-1$
						msg.open();
					}
				}
			}
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableCurrentTransactions);
		
	}
	public void printTable(){
	    EngBLUtils.printTable(tableCurrentTransactions,Messages.getString("CurUITransactionSearch.12")); //$NON-NLS-1$
	    
	}
}
