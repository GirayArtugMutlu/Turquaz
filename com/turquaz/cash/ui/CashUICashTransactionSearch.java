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

/**
* @author  Onsel
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.engine.bl.EngBLCashCards;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.cash.ui.comp.CashCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
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
public class CashUICashTransactionSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite{
   
	private Composite compSearchPanel;
	private CLabel lblCashCard;
	private CLabel lblEndDate;
	private TableColumn tableColumnTotal;
	private TableColumn tableColumnType;
	private TableColumn tableColumnCashCard;
	private TableColumn tableColumnDate;
	private DatePicker datePickerEnd;
	private DatePicker datePickerStart;
	private CLabel lblStartDate;
	private CashCardPicker txtCashCard;
	private Table tableCashTransactions;
	CashBLCashTransactionSearch blSearch = new CashBLCashTransactionSearch();
	private Calendar cal=Calendar.getInstance();

	

	public CashUICashTransactionSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(627, 377);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanelLData.heightHint = 97;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanelLayout.numColumns = 2;
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
                    lblCashCard.setText(Messages.getString("CashUICashTransactionSearch.0")); //$NON-NLS-1$
                    GridData lblCashCardLData = new GridData();
                    lblCashCardLData.widthHint = 59;
                    lblCashCardLData.heightHint = 18;
                    lblCashCard.setLayoutData(lblCashCardLData);
                }
                {
                    txtCashCard = new CashCardPicker(compSearchPanel, SWT.NONE);
                    GridData txtCashCardLData = new GridData();
                    txtCashCardLData.widthHint = 144;
                    txtCashCardLData.heightHint = 17;
                    txtCashCard.setLayoutData(txtCashCardLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText(Messages.getString("CashUICashTransactionSearch.1")); //$NON-NLS-1$
                }
                {
                    datePickerStart = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePickerStartLData = new GridData();
                    datePickerStartLData.widthHint = 122;
                    datePickerStartLData.heightHint = 21;
                    datePickerStart.setLayoutData(datePickerStartLData);
                }
                {
                    lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblEndDate.setText(Messages.getString("CashUICashTransactionSearch.2")); //$NON-NLS-1$
                }
                {
                    datePickerEnd = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePickerEndLData = new GridData();
                    datePickerEndLData.widthHint = 125;
                    datePickerEndLData.heightHint = 21;
                    datePickerEnd.setLayoutData(datePickerEndLData);
                }
            }
            {
                tableCashTransactions = new Table(this, SWT.FULL_SELECTION);
                GridData tableCashTransactionsLData = new GridData();
                tableCashTransactions.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                        
                    tableMouseDoubleClick();
                    }
                });
                tableCashTransactions.setHeaderVisible(true);
                tableCashTransactions.setLinesVisible(true);
                tableCashTransactionsLData.grabExcessVerticalSpace = true;
                tableCashTransactionsLData.grabExcessHorizontalSpace = true;
                tableCashTransactionsLData.horizontalAlignment = GridData.FILL;
                tableCashTransactionsLData.verticalAlignment = GridData.FILL;
                tableCashTransactions.setLayoutData(tableCashTransactionsLData);
                {
                    tableColumnDate = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnDate.setText(Messages.getString("CashUICashTransactionSearch.3")); //$NON-NLS-1$
                    tableColumnDate.setWidth(95);
                }
                {
                    tableColumnCashCard = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnCashCard.setText(Messages.getString("CashUICashTransactionSearch.4")); //$NON-NLS-1$
                    tableColumnCashCard.setWidth(100);
                }
                {
                    tableColumnType = new TableColumn(
                        tableCashTransactions,
                        SWT.NONE);
                    tableColumnType.setText(Messages.getString("CashUICashTransactionSearch.5")); //$NON-NLS-1$
                    tableColumnType.setWidth(95);
                }
                {
                    tableColumnTotal = new TableColumn(tableCashTransactions, SWT.RIGHT);
                    tableColumnTotal.setWidth(103);
                    tableColumnTotal.setText(Messages.getString("CashUICashTransactionSearch.6")); //$NON-NLS-1$
                }
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    
		//datePickerStart.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR),0,1);
		datePickerStart.setDate(cal.getTime());

	}
	
	
	 public void delete() {
	        // TODO Auto-generated method stub

	    }
	    public void exportToExcel() {
	       EngBLUtils.Export2Excel(tableCashTransactions);

	    }
	    public void printTable() {
	       EngBLUtils.printTable(tableCashTransactions,Messages.getString("CashUICashTransactionSearch.8")); //$NON-NLS-1$

	    }
	    
	    public void search() {
	        try{
	           
	            tableCashTransactions.removeAll();
	            
	          List list = blSearch.searchCashTransactions(txtCashCard.getTurqCashCard(),datePickerStart.getDate(),datePickerEnd.getDate());	
	          
	          Object[] row ;
	          TableItem item;
	          BigDecimal deptAmount = new BigDecimal(0);
	          BigDecimal creditAmount = new BigDecimal(0);
	          BigDecimal amount;
	          String cardName;
	          Date transDate = null;
	          String type;
	          Integer id;
	          for(int i = 0;i<list.size();i++){
	              
	              row = (Object[])list.get(i);
	              item = new TableItem(tableCashTransactions,SWT.NULL);
	              id = (Integer)row[0];
	              item.setData(id);
	              
	              
	              cardName = row[1].toString();
	              type = row[2].toString();
	              
	              if(row[3]!=null){
	                  deptAmount = (BigDecimal)row[3];
	                  
	              }
	              if(row[4]!=null){
	                  creditAmount =(BigDecimal) row[4];
	              }
	              
	              transDate = (Date)row[5];
	              
	              amount = creditAmount;
	              if(deptAmount.compareTo(new BigDecimal(0))==1){
	                  amount = deptAmount;
	                  
	              }
	              
	              TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	              item.setText(new String[]{
	                      		
	                      DatePicker.formatter.format(transDate),
	                      cardName,
	                      type,
	                      cf.format(amount)
	                      
	                      
	              });
	              
	              
	              
	          }
	          
	          
	          
	          
	          
	          
	          
	          
	          }
	        catch(Exception ex){
	            ex.printStackTrace();
	        }
	    }
	public void tableMouseDoubleClick(){
	
	    try{
	    	
	        TableItem selection[] = tableCashTransactions.getSelection();
	        
	        if(selection.length>0){
	        
	            TableItem item = selection[0];
	           
	            Integer id = (Integer)item.getData();
	            
	            TurqCashTransaction cashTrans = blSearch.initializeCashTransaction(id);
	            
	            
	            if(cashTrans.getTurqEngineSequence().getTurqModule().getModulesId().intValue()!=EngBLCommon.MODULE_CASH){	                
	            	EngUICommon.showMessageBox(this.getShell(),Messages.getString("CashUICashTransactionSearch.7")); //$NON-NLS-1$
	                return;
	            }
	            
	            boolean updated=false;
	            if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_COLLECT)
	            {
	               updated= new CashUICashCollectTransactionUpdate(this.getShell(),SWT.NULL,cashTrans).open();
	                
	            }
	            else if(cashTrans.getTurqCashTransactionType().getCashTransactionTypesId().intValue()==EngBLCommon.CASH_CURRENT_PAYMENT){
	                
	                updated=new CashUICashPaymentTransactionUpdate(this.getShell(),SWT.NULL,cashTrans).open();
	                
	                
	            }
	            if (updated)
	            	search();
	            
	            
	            
	        }    
	        
	        
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    
	    }
	}

}
