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
import java.util.Iterator;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.dal.TurqCashTransactionRow;
import com.turquaz.engine.dal.TurqCurrentCard;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
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
public class CashUICashPaymentTransactionUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CoolItem coolItem1;
	private ToolItem toolUpdate;
	private ToolItem tooldelete;
	private CashUICashPaymentTransactionAdd compTransAdd;
	private ToolItem toolCancel;
	private ToolBar toolBar1;
	private CoolBar coolBar1;
	private TurqCashTransaction cashTrans;
	private CashBLCashTransactionUpdate blUpdate = new CashBLCashTransactionUpdate();
	private boolean updated=false;

	public CashUICashPaymentTransactionUpdate(Shell parent, int style,TurqCashTransaction cashTrans) {
		super(parent, style);
		this.cashTrans = cashTrans;
	}

	public boolean open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

                {
                    //Register as a resource user - SWTResourceManager will
                    //handle the obtaining and disposing of resources
                    SWTResourceManager.registerResourceUser(dialogShell);
                }

            dialogShell.setText(Messages.getString("CashUICashPaymentTransactionUpdate.0")); //$NON-NLS-1$
			dialogShell.setLayout(new GridLayout());
			dialogShell.setImage(SWTResourceManager.getImage("icons/Editor16.gif")); //$NON-NLS-1$
			dialogShell.layout();
			dialogShell.setSize(636, 591);
            {
                coolBar1 = new CoolBar(dialogShell, SWT.NONE);
                GridData coolBar1LData = new GridData();
                coolBar1LData.horizontalAlignment = GridData.FILL;
                coolBar1LData.heightHint = 49;
                coolBar1LData.grabExcessHorizontalSpace = true;
                coolBar1.setLayoutData(coolBar1LData);
                {
                    coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                    coolItem1.setSize(45, 47);
                    coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 47));
                    coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 47));
                    {
                        toolBar1 = new ToolBar(coolBar1, SWT.NONE);
                        coolItem1.setControl(toolBar1);
                        {
                            toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                            toolUpdate.setText(Messages.getString("CashUICashPaymentTransactionUpdate.1")); //$NON-NLS-1$
                            toolUpdate.setImage(SWTResourceManager
                                .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                            toolUpdate
                            .addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                               
                            update();
                            }
                            });
                        }
                        {
                            tooldelete = new ToolItem(toolBar1, SWT.NONE);
                            tooldelete.setText(Messages.getString("CashUICashPaymentTransactionUpdate.3")); //$NON-NLS-1$
                            tooldelete.setImage(SWTResourceManager
                                .getImage("icons/delete_edit.gif")); //$NON-NLS-1$
                            tooldelete
                                .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                   
                                delete();
                                }
                                });
                        }
                        {
                            toolCancel = new ToolItem(toolBar1, SWT.NONE);
                            toolCancel.setText(Messages.getString("CashUICashPaymentTransactionUpdate.5")); //$NON-NLS-1$
                            toolCancel.setImage(SWTResourceManager
                                .getImage("icons/cancel.jpg")); //$NON-NLS-1$
                            toolCancel
                                .addSelectionListener(new SelectionAdapter() {
                                public void widgetSelected(SelectionEvent evt) {
                                   
                                dialogShell.close();
                                
                                }
                                });
                        }
                    }
                }
            }
            {
                compTransAdd = new CashUICashPaymentTransactionAdd(
                    dialogShell,
                    SWT.NONE);
                GridData compCahsTransLData = new GridData();
                compCahsTransLData.horizontalAlignment = GridData.FILL;
                compCahsTransLData.verticalAlignment = GridData.FILL;
                compCahsTransLData.grabExcessVerticalSpace = true;
                compTransAdd.setLayoutData(compCahsTransLData);
            }
            
            postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return updated;
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
	}
	
	public void postInitGUI()
	{
	    if(cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue()!= EngBLCommon.MODULE_CASH)
	    {	    
	     toolUpdate.setEnabled(false);
	     tooldelete.setEnabled(false);
	        
	    }
	    compTransAdd.getTxtDocumentNo().setText(cashTrans.getDocumentNo());
	    compTransAdd.getDatePicker().setDate(cashTrans.getTransactionDate());
	  
        compTransAdd.getTxtDefinition().setText(cashTrans.getTransactionDefinition());
	    
	   
        try{
        TurqCurrentCard curCard = blUpdate.getCurrentCard(cashTrans.getTurqEngineSequence());
        
        if(curCard!=null){
        compTransAdd.getTxtCurrentAccount().setText(curCard.getCardsName()+" {"+curCard.getCardsCurrentCode()+"}");
            
        }
        
        
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        
        
        
	    Iterator it = cashTrans.getTurqCashTransactionRows().iterator();
	    if(it.hasNext()){
	     
	        TurqCashTransactionRow row = (TurqCashTransactionRow)it.next();
	        compTransAdd.getTxtCashCard().setText(row.getTurqCashCard().getCashCardName());
	        if(row.getDeptAmount().compareTo(new BigDecimal(0))==1){
	            
	            compTransAdd.getCurTextTotalAmount().setText(row.getDeptAmount());
	            
	        }
	        else
	        {
	            compTransAdd.getCurTextTotalAmount().setText(row.getCreditAmount());
	        }
	   }
	    
	    
	
	}
	
	public void delete(){
	    try
		{
	        MessageBox msg = new MessageBox(this.getParent(),SWT.ICON_QUESTION|SWT.YES|SWT.NO);
	        msg.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.7")); //$NON-NLS-1$
	        int answer = msg.open();
	        
	        if(answer == SWT.YES)
	        {
	        	updated=true;
	        	blUpdate.deleteCashTrans(cashTrans);
	        	MessageBox msg2 = new MessageBox(this.getParent(),SWT.ICON_INFORMATION);
	        	msg2.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.8")); //$NON-NLS-1$
	        	msg2.open();          
	          
	        	dialogShell.close();
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	}
	public void update(){
	    try{
	        MessageBox msg = new MessageBox(this.getParent(),SWT.ICON_INFORMATION);
	        if(compTransAdd.verifyFields())
	        {
	        	updated=true;
//	          TODO current trans exRate
	        	blUpdate.updateCashTrans(cashTrans,(TurqCashCard)compTransAdd.getTxtCashCard().getData(),
	                                (TurqCurrentCard)compTransAdd.getTxtCurrentAccount().getData(),
	                                compTransAdd.getCurTextTotalAmount().getBigDecimalValue(),
	                                compTransAdd.getDatePicker().getDate(),
	                                compTransAdd.getTxtDefinition().getText(),
	                                compTransAdd.getTxtDocumentNo().getText(),
									EngBLCommon.getBaseCurrencyExchangeRate());
	        
	        	msg.setMessage(Messages.getString("CashUICashPaymentTransactionUpdate.9")); //$NON-NLS-1$
	        	msg.open();
	        
	        	dialogShell.close();
	        }
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	
}
