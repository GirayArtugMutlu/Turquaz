package com.turquaz.bank.ui;
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

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;

import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBanksTransactionBill;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.bank.bl.BankBLTransactionUpdate;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;

import com.turquaz.engine.ui.component.SearchComposite;

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
public class BankUISearchMoneyTransaction extends org.eclipse.swt.widgets.Composite implements SearchComposite {

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compSearch;
	private Table tableMoneyTrans;
	private TableColumn tableColumnDocNo;
	private TableColumn tableColumnType;
	private TableColumn tableColumnDate;
	private DatePicker dateEnd;
	private CLabel lblEndDate;
	private DatePicker dateStart;
	private CLabel lblStartDate;
	private Text txtDocNo;
	private CLabel lblDocNo;

	public BankUISearchMoneyTransaction(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(677, 401);
            {
                compSearch = new Composite(this, SWT.NONE);
                GridLayout compSearchLayout = new GridLayout();
                compSearchLayout.numColumns = 2;
                GridData compSearchLData = new GridData();
                compSearchLData.horizontalAlignment = GridData.FILL;
                compSearchLData.grabExcessHorizontalSpace = true;
                compSearchLData.heightHint = 114;
                compSearch.setLayoutData(compSearchLData);
                compSearch.setLayout(compSearchLayout);
                {
                    lblDocNo = new CLabel(compSearch, SWT.NONE);
                    lblDocNo.setText(Messages.getString("BankUISearchMoneyTransaction.0")); //$NON-NLS-1$
                }
                {
                    txtDocNo = new Text(compSearch, SWT.NONE);
                    GridData txtDocNoLData = new GridData();
                    txtDocNoLData.widthHint = 145;
                    txtDocNoLData.heightHint = 16;
                    txtDocNo.setLayoutData(txtDocNoLData);
                }
                {
                    lblStartDate = new CLabel(compSearch, SWT.NONE);
                    lblStartDate.setText(Messages.getString("BankUISearchMoneyTransaction.2")); //$NON-NLS-1$
                }
                {
                    dateStart = new DatePicker(compSearch, SWT.NONE);
                    GridData dateStartLData = new GridData();
                    dateStartLData.widthHint = 114;
                    dateStartLData.heightHint = 19;
                    dateStart.setLayoutData(dateStartLData);
                }
                {
                    lblEndDate = new CLabel(compSearch, SWT.NONE);
                    lblEndDate.setText(Messages.getString("BankUISearchMoneyTransaction.3")); //$NON-NLS-1$
                }
                {
                    dateEnd = new DatePicker(compSearch, SWT.NONE);
                    GridData dateEndLData = new GridData();
                    dateEndLData.widthHint = 112;
                    dateEndLData.heightHint = 17;
                    dateEnd.setLayoutData(dateEndLData);
                }
            }
            {
                tableMoneyTrans = new Table(this, SWT.FULL_SELECTION);
                GridData tableMoneyTransLData = new GridData();
                tableMoneyTrans.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                    tableMouseDoubleClick();   
                    
                    }
                });
                tableMoneyTrans.setHeaderVisible(true);
                tableMoneyTrans.setLinesVisible(true);
                tableMoneyTransLData.horizontalAlignment = GridData.FILL;
                tableMoneyTransLData.verticalAlignment = GridData.FILL;
                tableMoneyTransLData.grabExcessVerticalSpace = true;
                tableMoneyTrans.setLayoutData(tableMoneyTransLData);
                {
                    tableColumnDate = new TableColumn(tableMoneyTrans, SWT.NONE);
                    tableColumnDate.setText(Messages.getString("BankUISearchMoneyTransaction.4")); //$NON-NLS-1$
                    tableColumnDate.setWidth(82);
                }
                {
                    tableColumnDocNo = new TableColumn(
                        tableMoneyTrans,
                        SWT.NONE);
                    tableColumnDocNo.setWidth(75);
                    tableColumnDocNo.setText(Messages.getString("BankUISearchMoneyTransaction.5")); //$NON-NLS-1$
                }
                {
                    tableColumnType = new TableColumn(tableMoneyTrans, SWT.NONE);
                    tableColumnType.setText(Messages.getString("BankUISearchMoneyTransaction.7")); //$NON-NLS-1$
                    tableColumnType.setWidth(104);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void delete() {
        // TODO Auto-generated method stub

    }
    public void exportToExcel() {
        
        EngBLUtils.Export2Excel(tableMoneyTrans);
        

    }
    public void printTable() {
       
        EngBLUtils.printTable(tableMoneyTrans,Messages.getString("BankUISearchMoneyTransaction.10")); //$NON-NLS-1$

    }
    public void search() {
    try
    {
        tableMoneyTrans.removeAll();
        TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
        
        List ls = BankBLTransactionSearch.searchtransaction(txtDocNo.getText().trim(),dateStart.getDate(),dateEnd.getDate());
      
        Object []result;
        Integer transId;
        Date transDate;
        BigDecimal dept = new BigDecimal(0);
        BigDecimal credit = new BigDecimal(0);
        String docNo =""; //$NON-NLS-1$
        String bankCode;
        String transType;
        TableItem item ;
        
        for(int i=0;i<ls.size();i++){
            
            dept = new BigDecimal(0);
            credit = new BigDecimal(0);
            
            result = (Object[])ls.get(i);
            transId = (Integer)result[0];
          
            transType = result[1].toString();
          
            transDate = (Date)result[2];
            docNo = result[3].toString();
            
            item = new TableItem(tableMoneyTrans,SWT.NULL);
            item.setData(transId);
            item.setText(new String[]{
                    				  DatePicker.formatter.format(transDate),
                    				  docNo,
                    				  transType,
                    				});
            
            
        }
        
        
        
        
    }
    catch(Exception ex){
        ex.printStackTrace();
       EngUICommon.showMessageBox(getShell(),ex.getMessage(),SWT.ICON_ERROR);
    }

    }
    
    public void tableMouseDoubleClick(){
   try{
      TableItem selection[] =tableMoneyTrans.getSelection();
      if(selection.length>0){
          
        boolean isUpdated = false;
       TurqBanksTransactionBill transBill = BankBLTransactionUpdate.initializeTransaction((Integer)selection[0].getData()); 
       if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_RECIEVE_MONEY)
       {
         isUpdated  = new BankUIMoneyTransferInUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_SEND_MONEY)
       {
           isUpdated  = new BankUIMoneyTransferOutUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_CASH_DRAW)
       {
           isUpdated  = new BankUICashFromBankUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_CASH_DEPOSIT)
       {
           isUpdated  = new BankUICashToBankUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_OTHER_DEPOSIT)
       {
           isUpdated  = new BankUIOtherTransInUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_OTHER_DRAW)
       {
           isUpdated  = new BankUIOtherTransOutUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       
       else if(transBill.getTurqBanksTransactionType().getBankTransactionTypesId().intValue()==EngBLCommon.BANK_TRANS_BETWEEN_BANKS)
       {
           isUpdated  = new BankUITransferBetweenAccountsUpdate(getShell(),SWT.NULL,transBill).open();
           
       }
       
       
       if(isUpdated){
       search();
           
       }
       
       
      }
       
   }
   catch(Exception ex)
   {
       ex.printStackTrace();
       EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
   }
        
        
    }
}
