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
* @author  Cem Dayanik
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.layout.GridLayout;

import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CLabel;
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
public class CashUICashCardDailyAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite {
	private Composite compSearchPanel;
	private CLabel lblCashCard;
	private TableColumn tableColumnPayment;
	private TableColumn tableColumnCollect;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnCashCode;
	private TableColumn tableColumnDate;
	private Table tableCashTrans;
	private DatePicker datePicker;
	private CLabel lblStartDate;
	private CashCardPicker cashCardPicker;

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }


	

	public CashUICashCardDailyAbstract(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(631, 395);
            {
                compSearchPanel = new Composite(this, SWT.NONE);
                GridLayout compSearchPanelLayout = new GridLayout();
                compSearchPanelLayout.numColumns = 2;
                GridData compSearchPanelLData = new GridData();
                compSearchPanelLData.heightHint = 84;
                compSearchPanelLData.grabExcessHorizontalSpace = true;
                compSearchPanelLData.horizontalAlignment = GridData.FILL;
                compSearchPanel.setLayoutData(compSearchPanelLData);
                compSearchPanel.setLayout(compSearchPanelLayout);
                {
                    lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
                    lblCashCard.setText(Messages.getString("CashUICashCardAbstract.0")); //$NON-NLS-1$
                }
                {
                    cashCardPicker = new CashCardPicker(
                        compSearchPanel,
                        SWT.NONE);
                    GridData cashCardPickerLData = new GridData();
                    cashCardPickerLData.widthHint = 249;
                    cashCardPickerLData.heightHint = 20;
                    cashCardPicker.setLayoutData(cashCardPickerLData);
                }
                {
                    lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
                    lblStartDate.setText("Tarih"); //$NON-NLS-1$
                }
                {
                    datePicker = new DatePicker(compSearchPanel, SWT.NONE);
                    GridData datePickerLData = new GridData();
                    datePickerLData.widthHint = 119;
                    datePickerLData.heightHint = 19;
                    datePicker.setLayoutData(datePickerLData);
                }
            }
            {
                tableCashTrans = new Table(this, SWT.NONE);
                GridData tableCashTransLData = new GridData();
                tableCashTrans.setHeaderVisible(true);
                tableCashTrans.setLinesVisible(true);
                tableCashTransLData.grabExcessHorizontalSpace = true;
                tableCashTransLData.horizontalAlignment = GridData.FILL;
                tableCashTransLData.grabExcessVerticalSpace = true;
                tableCashTransLData.verticalAlignment = GridData.FILL;
                tableCashTrans.setLayoutData(tableCashTransLData);
                {
                    tableColumnDate = new TableColumn(tableCashTrans, SWT.NONE);
                    tableColumnDate.setText(Messages.getString("CashUICashCardAbstract.3")); //$NON-NLS-1$
                    tableColumnDate.setWidth(67);
                }
                {
                    tableColumnCashCode = new TableColumn(
                        tableCashTrans,
                        SWT.NONE);
                    tableColumnCashCode.setText(Messages.getString("CashUICashCardAbstract.4")); //$NON-NLS-1$
                    tableColumnCashCode.setWidth(100);
                }
                {
                    tableColumnDefinition = new TableColumn(
                        tableCashTrans,
                        SWT.NONE);
                    tableColumnDefinition.setText(Messages.getString("CashUICashCardAbstract.5")); //$NON-NLS-1$
                    tableColumnDefinition.setWidth(208);
                }
                {
                    tableColumnCollect = new TableColumn(tableCashTrans, SWT.RIGHT);
                    tableColumnCollect.setText(Messages.getString("CashUICashCardDailyAbstract.0")); //$NON-NLS-1$
                    tableColumnCollect.setWidth(100);
                }
                {
                    tableColumnPayment = new TableColumn(tableCashTrans, SWT.RIGHT);
                    tableColumnPayment.setText(Messages.getString("CashUICashCardDailyAbstract.1")); //$NON-NLS-1$
                    tableColumnPayment.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public boolean verifyFields()
	{
	    if(cashCardPicker.getData()==null)
	    {
	        EngUICommon.showMessageBox(getShell(),Messages.getString("CashUICashCardAbstract.8")); //$NON-NLS-1$
	        cashCardPicker.setFocus();
	        return false;
	    }
	    return true;
	    
	}
	
    public void delete() {
        

    }
    public void exportToExcel() {
       EngBLUtils.Export2Excel(tableCashTrans);

    }
    public void printTable() {
        EngBLUtils.printTable(tableCashTrans,Messages.getString("CashUICashCardAbstract.9"));  //$NON-NLS-1$

    }
    public void search() {
     
     if(verifyFields())
     {
     try{
     tableCashTrans.removeAll();
      TurkishCurrencyFormat cf = new TurkishCurrencyFormat();   
      TableItem item = new TableItem(tableCashTrans,SWT.NULL);   
      
      BigDecimal total_dept=new BigDecimal(0);
      BigDecimal total_credit = new BigDecimal(0);
      BigDecimal deferred_dept = new BigDecimal(0);
      BigDecimal deferred_credit = new BigDecimal(0);
      
      List deferred = CashBLCashTransactionSearch.getDeferredTotal((TurqCashCard)cashCardPicker.getData(),datePicker.getDate());
      
      if(deferred.size()!=0){
          
          Object[] amounts = (Object[])deferred.get(0);          
          item.setText(new String[]{
                  "","",Messages.getString("CashUICashCardAbstract.12"),cf.format(amounts[0]),cf.format(amounts[1]) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
          			});
          deferred_dept = deferred_dept.add((BigDecimal)amounts[0]);
          deferred_credit = deferred_credit.add((BigDecimal)amounts[1]);
          
      }
      else
      {
          item.setText(new String[]{
                  "","",Messages.getString("CashUICashCardAbstract.15"),cf.format(0),cf.format(0) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
          			});
      }
         
       List ls = CashBLCashTransactionSearch.getTransactions((TurqCashCard)cashCardPicker.getData(),datePicker.getDate(),datePicker.getDate());
     
   
       BigDecimal credit;
       BigDecimal dept;
       for(int i =0; i<ls.size();i++)
       {
           credit = new BigDecimal(0);
           dept = new BigDecimal(0);
           

           Object results[] = (Object[])ls.get(i);
           if(results[3]!=null)
           {
              dept = (BigDecimal)results[3]; 
           }
           
           if(results[4]!=null){
               credit = (BigDecimal)results[4];
           }
           
           item = new TableItem(tableCashTrans,SWT.NULL);
           item.setText(new String[]{
                   		DatePicker.formatter.format((Date)results[0]),
                   		results[1].toString(),
                   		results[2].toString(),
                   		cf.format(dept),
                   		cf.format(credit),
           				});
           
           total_dept = total_dept.add(dept);
           total_credit = total_credit.add(credit);
           
           
           
       }
       
       item=new TableItem(tableCashTrans,SWT.NULL);
       item=new TableItem(tableCashTrans,SWT.NULL);
       item.setText(new String[]{
                     "", //$NON-NLS-1$
                     "", //$NON-NLS-1$
                     Messages.getString("CashUICashCardAbstract.18"), //$NON-NLS-1$
                     cf.format(total_dept),
                     cf.format(total_credit)
                      });
       
       item=new TableItem(tableCashTrans,SWT.NULL);  
       item.setText(new String[]{
               "", //$NON-NLS-1$
               "", //$NON-NLS-1$
               Messages.getString("CashUICashCardAbstract.21"), //$NON-NLS-1$
               cf.format(deferred_dept),
               cf.format(deferred_credit)
                });
       item=new TableItem(tableCashTrans,SWT.NULL);  
       item.setText(new String[]{
               "", //$NON-NLS-1$
               "", //$NON-NLS-1$
               Messages.getString("CashUICashCardAbstract.24"), //$NON-NLS-1$
               cf.format(deferred_dept.add(total_dept)),
               cf.format(deferred_credit.add(total_credit))
                });
       
     
     
     
     }
     catch(Exception ex){
         ex.printStackTrace();
     }
         
     }

    }
}
