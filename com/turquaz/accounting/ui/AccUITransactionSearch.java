package com.turquaz.accounting.ui;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;

import com.cloudgarden.resource.SWTResourceManager;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.accounting.bl.AccBLTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqAccountingTransactionType;


import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

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
public class AccUITransactionSearch extends  Composite implements SearchComposite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}


	private TableColumn tableColumnTotalAmount;
	private TableColumn tableColumnDate;
	private TableColumn tableColumnDocumentNo;
	private TableColumn tableColumnTransType;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CCombo comboTransType;
	private CLabel lblTransactionType;
	private TableColumn tableColumnDefinition;
	private Text txtDocumentNo;
	private CLabel lblDocumentNo;
	private Table tableTransactions;
	private Composite compAccTransactionSearch;
	private AccBLTransactionSearch blTransSearch = new AccBLTransactionSearch();
	private Calendar cal=Calendar.getInstance();
	public AccUITransactionSearch(Composite parent, int style) {
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

			{
				compAccTransactionSearch = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 84;
				composite1LData.grabExcessHorizontalSpace = true;
				compAccTransactionSearch.setLayoutData(composite1LData);
				compAccTransactionSearch.setLayout(composite1Layout);
				{
					lblDocumentNo = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblDocumentNoLData = new GridData();
					lblDocumentNoLData.widthHint = 99;
					lblDocumentNoLData.heightHint = 24;
					lblDocumentNo.setLayoutData(lblDocumentNoLData);
					lblDocumentNo.setText(Messages
						.getString("AccUITransactionSearch.0")); //$NON-NLS-1$
					lblDocumentNo.setSize(new org.eclipse.swt.graphics.Point(
						99,
						24));
				}
				{
					txtDocumentNo = new Text(compAccTransactionSearch, SWT.NONE);
					GridData txtDocumentNoLData = new GridData();
					txtDocumentNoLData.widthHint = 135;
					txtDocumentNoLData.heightHint = 17;
					txtDocumentNo.setLayoutData(txtDocumentNoLData);
					txtDocumentNo.setSize(new org.eclipse.swt.graphics.Point(
						141,
						17));
				}
				{
					lblTransactionType = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblTransactionTypeLData = new GridData();
					lblTransactionTypeLData.widthHint = 100;
					lblTransactionTypeLData.heightHint = 20;
					lblTransactionType.setLayoutData(lblTransactionTypeLData);
					lblTransactionType.setText(Messages
						.getString("AccUITransactionSearch.1")); //$NON-NLS-1$
					lblTransactionType
						.setSize(new org.eclipse.swt.graphics.Point(100, 20));
				}
				{
					comboTransType = new CCombo(compAccTransactionSearch, SWT.READ_ONLY);
					GridData comboTransTypeLData = new GridData();
					comboTransTypeLData.widthHint = 99;
					comboTransTypeLData.heightHint = 19;
					comboTransType.setLayoutData(comboTransTypeLData);
					comboTransType.setText(Messages
						.getString("AccUITransactionSearch.2")); //$NON-NLS-1$
					comboTransType.setBackground(SWTResourceManager.getColor(
						255,
						255,
						255));
					comboTransType.setEditable(false);
					comboTransType.setSize(new org.eclipse.swt.graphics.Point(
						121,
						19));
				}
				{
					lblStartDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblStartDateLData = new GridData();
					lblStartDate.setLayoutData(lblStartDateLData);
					lblStartDate.setText(Messages
						.getString("AccUITransactionSearch.3")); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 174;
					dateStartDateLData.heightHint = 24;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.setSize(new org.eclipse.swt.graphics.Point(
						174,
						24));
					dateStartDate.layout();
				}
				{
					lblEndDate = new CLabel(compAccTransactionSearch, SWT.NONE);
					GridData lblEndDateLData = new GridData();
					lblEndDate.setLayoutData(lblEndDateLData);
					lblEndDate.setText(Messages
						.getString("AccUITransactionSearch.4")); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(compAccTransactionSearch, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 173;
					dateEndDateLData.heightHint = 25;
					dateEndDate.setLayoutData(dateEndDateLData);
					dateEndDate.setSize(new org.eclipse.swt.graphics.Point(
						173,
						25));
					dateEndDate.layout();
				}
				compAccTransactionSearch.layout();
			}
			tableTransactions = new Table(this,SWT.MULTI| SWT.FULL_SELECTION);
			{
				tableColumnDate = new TableColumn(tableTransactions, SWT.NONE);
				tableColumnDate.setText(Messages
					.getString("AccUITransactionSearch.7")); //$NON-NLS-1$
				tableColumnDate.setWidth(118);
			}
			tableColumnDocumentNo = new TableColumn(tableTransactions,SWT.NULL);
			tableColumnTransType = new TableColumn(tableTransactions,SWT.NULL);
			tableColumnTotalAmount = new TableColumn(tableTransactions,SWT.RIGHT);
	
			this.setSize(new org.eclipse.swt.graphics.Point(646,513));

			GridData tableTransactionsLData = new GridData();
			tableTransactionsLData.verticalAlignment = GridData.FILL;
			tableTransactionsLData.horizontalAlignment = GridData.FILL;
			tableTransactionsLData.grabExcessHorizontalSpace = true;
			tableTransactionsLData.grabExcessVerticalSpace = true;
			tableTransactions.setLayoutData(tableTransactionsLData);
			tableTransactions.setHeaderVisible(true);
			tableTransactions.setLinesVisible(true);
			
			tableTransactions.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableTransactionsMouseDoubleClick(evt);
				}
			});
	
			tableColumnTransType.setText(Messages.getString("AccUITransactionSearch.1")); //$NON-NLS-1$
			tableColumnTransType.setWidth(130);
	
			tableColumnDocumentNo.setText(Messages.getString("AccUITransactionSearch.0")); //$NON-NLS-1$
			tableColumnDocumentNo.setWidth(126);

			tableColumnTotalAmount.setText(Messages.getString("AccUITransactionSearch.8")); //$NON-NLS-1$
			tableColumnTotalAmount.setWidth(118);
			{
				tableColumnDefinition = new TableColumn(
					tableTransactions,
					SWT.NONE);
				tableColumnDefinition.setText(Messages.getString("AccUITransactionSearch.5")); //$NON-NLS-1$
				tableColumnDefinition.setWidth(150);
			}
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
				}
			});
	
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
	dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
	fillCombo();
	
	
	}
	public void fillCombo(){
	try{
	
	comboTransType.add(" "); //$NON-NLS-1$
	List list = blTransSearch.getTransactionTypes();
	
	TurqAccountingTransactionType transType;
	for(int i=0;i<list.size();i++)
	{
       
       transType = (TurqAccountingTransactionType)list.get(i);
       comboTransType.add(transType.getTypesName());
       comboTransType.setData(transType.getTypesName(),transType);  	
	
	}
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	
	
	}
	
	
	public void save(){
	
	}
	public void delete(){   
	    
	   MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
	    
	   TableItem items[] = tableTransactions.getSelection();
	   if(items.length>0){
	   TurqAccountingTransaction accTrans = (TurqAccountingTransaction)items[0].getData();
		
	   int status=0;
	   
	   /*Check if it has a journal entry*/
		if(accTrans.getTurqAccountingJournal().getAccountingJournalId().intValue()!=-1){
			status =1;
		    
	   }	
		/* Check if it is entered from accountingmodule
		 * 
		 */
		//1- Muhasebe Modulu
	   else	if(accTrans.getTurqModule().getModulesId().intValue()!=1){
		  status = 2;	
		    
		}
	   
	   if(status ==2){
	       msg.setMessage(Messages.getString("AccUITransactionSearch.6")); //$NON-NLS-1$
	       msg.open();
	       return;
	   }
	   if(status==1){
	       msg.setMessage(Messages.getString("AccUITransactionSearch.9")); //$NON-NLS-1$
	       msg.open();
	       return;
	   }
	   
	     
	    AccBLTransactionUpdate blUpdate = new AccBLTransactionUpdate();
		MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
		try {
			msg2.setMessage(Messages.getString("AccUITransactionSearch.10")); //$NON-NLS-1$
			int result = msg2.open();

			if (result == SWT.OK) {
			     
			    blUpdate.initiliazeTransactionRows(accTrans);
			    
			    Iterator it = accTrans.getTurqAccountingTransactionColumns().iterator();
			    while(it.hasNext()){
			        EngBLCommon.delete(it.next());
			    }
			    EngBLCommon.delete(accTrans);
			    
				msg.setMessage(Messages.getString("AccUIAccountUpdate.16")); //$NON-NLS-1$
				msg.open();
				search();
				
			}

		} catch (Exception ex) {
			MessageBox msg3 = new MessageBox(this.getShell(), SWT.ICON_WARNING);
			msg3.setMessage(Messages.getString("AccUIAccountingPlan.5")); //$NON-NLS-1$
			msg3.open();
			
			ex.printStackTrace();

		
	}
	   }
	
	}
	public void search(){
	try{
	tableTransactions.removeAll();
	
	List result = blTransSearch.searchAccTransaction(txtDocumentNo.getText().trim(),
												comboTransType.getData(comboTransType.getText()),
												dateStartDate.getData(),dateEndDate.getData());
	
	TableItem item;
	
	int listSize = result.size();
	TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
	for(int i =0; i<listSize;i++){
		
		TurqAccountingTransaction accTrans = (TurqAccountingTransaction)result.get(i);
		
		item = new TableItem(tableTransactions,SWT.NULL);
		item.setData(accTrans);	
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
		BigDecimal total = new BigDecimal(0);
	  	Iterator it = accTrans.getTurqAccountingTransactionColumns().iterator();
	  	while(it.hasNext()){
	  		TurqAccountingTransactionColumn transColumn = (TurqAccountingTransactionColumn)it.next();
	  		total = total.add(transColumn.getCreditAmount());
	  	}
		
		String transDate =formatter.format(accTrans.getTransactionsDate());
		item.setText(new String[]{transDate,accTrans.getTransactionDocumentNo(),accTrans.getTurqAccountingTransactionType().getTypesName(),
					cf.format(total),accTrans.getTransactionDescription()}); //$NON-NLS-1$
	
	}
	
	
	
	
	
	
	
	}
	catch(Exception ex){
	
	ex.printStackTrace();
		
	}
	
	
	
	
	
	
	}
	
	public void newForm(){
	
	}
	public void printTable(){
	    EngBLUtils.printTable(tableTransactions,Messages.getString("AccUITransactionSearch.11")); //$NON-NLS-1$
	    
	}

	/** Auto-generated event handler method */
	protected void tableTransactionsMouseDoubleClick(MouseEvent evt){
		
    TableItem selection[] = tableTransactions.getSelection();
    
    if(selection.length>0){
    
    TurqAccountingTransaction accTrans = (TurqAccountingTransaction)selection[0].getData();
    
    int type =accTrans.getTurqAccountingTransactionType().getAccountingTransactionTypesId().intValue();
    if(type==2){
    boolean updated=new AccUITransactionUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
    if (updated)
    	search();
    
    }
    else if(type==1){
    new AccUITransactionPaymentUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
    search();
    }
    else if(type==0) {
    	new AccUITransactionCollectUpdateDialog(this.getShell(),SWT.NULL,accTrans).open();
        search();
    
    }
    
    
    
    }



	}
	
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableTransactions);
		
	 }
		
	
	
}
