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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLUpdateChequeRoll;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqChequeChequeInRoll;
import com.turquaz.engine.dal.TurqChequeRoll;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

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
public class CheUIChequeOutPayrollCurrentUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private ToolItem toolUpdate;
	private CheUIChequeOutPayrollCurrent compChequeRoll;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolBar toolBar1;

	boolean isUpdated = false;
	TurqChequeRoll chequeRoll = null;

	public CheUIChequeOutPayrollCurrentUpdate(Shell parent, int style, TurqChequeRoll chequeRoll) {
		super(parent, style);
		this.chequeRoll = chequeRoll;
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


			dialogShell.setLayout(new GridLayout());
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(757, 612);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolUpdate = new ToolItem(toolBar1, SWT.NONE);
                    toolUpdate.setText(Messages.getString("CheUIChequeInPayrollUpdate.0")); //$NON-NLS-1$
                    toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolUpdate.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                         update();
                            
                        }
                    });
                }
				{
					toolDelete = new ToolItem(toolBar1, SWT.NONE);
					toolDelete.setText(Messages
						.getString("CheUIChequeInPayrollUpdate.2")); //$NON-NLS-1$
					toolDelete.setImage(SWTResourceManager
						.getImage("icons/delete_edit.gif")); //$NON-NLS-1$
					toolDelete.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {
							delete();
						}
					});
				}
				{
					toolCancel = new ToolItem(toolBar1, SWT.NONE);
					toolCancel.setText(Messages
						.getString("CheUIChequeInPayrollUpdate.4")); //$NON-NLS-1$
					toolCancel.setImage(SWTResourceManager
						.getImage("icons/cancel.jpg")); //$NON-NLS-1$
					toolCancel.addSelectionListener(new SelectionAdapter() {
						public void widgetSelected(SelectionEvent evt) {

							dialogShell.close();

						}
					});
				}
            }
            {
                compChequeRoll = new CheUIChequeOutPayrollCurrent(dialogShell, SWT.NONE);
                GridData compChequeRollLData = new GridData();
                compChequeRollLData.grabExcessHorizontalSpace = true;
                compChequeRollLData.horizontalAlignment = GridData.FILL;
                compChequeRollLData.grabExcessVerticalSpace = true;
                compChequeRollLData.verticalAlignment = GridData.FILL;
                compChequeRoll.setLayoutData(compChequeRollLData);
            }
            postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void postInitGUI(){
	    try{
	        EngUICommon.centreWindow(dialogShell);
	        TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
	        CheBLUpdateChequeRoll.initializeChequeRoll(chequeRoll);
	        compChequeRoll.getTxtRollNo().setText(chequeRoll.getChequeRollNo());
	        compChequeRoll.getDatePicker1().setDate(chequeRoll.getChequeRollsDate());
	        compChequeRoll.getCurrentPicker().setText(chequeRoll.getTurqCurrentCard().getCardsName()+" {"+chequeRoll.getTurqCurrentCard().getCardsCurrentCode()+"}"); //$NON-NLS-1$ //$NON-NLS-2$
	        compChequeRoll.getToolItemAddCustomer().setEnabled(false);
	        compChequeRoll.getToolItemDelete().setEnabled(false);
	        compChequeRoll.getToolItemUpdate().setEnabled(false);
	        compChequeRoll.getToolItemAddOwn().setEnabled(false);
	        
	        TableItem item;
	        
	        Iterator it = chequeRoll.getTurqChequeChequeInRolls().iterator();
	        
	        while(it.hasNext()){
	            
	        TurqChequeChequeInRoll chequeInRoll = (TurqChequeChequeInRoll)it.next();
	        TurqChequeCheque cheque = chequeInRoll.getTurqChequeCheque();
	        
	        item = new TableItem(compChequeRoll.getTableCheques(),SWT.NULL);
            item.setData(cheque);            
            item.setText(new String[]{
            cheque.getChequesPortfolioNo(),
            DatePicker.formatter.format(cheque.getChequesDueDate()),
            cheque.getChequesPaymentPlace(),
            cheque.getChequesDebtor(),
            cf.format(cheque.getChequesAmount())            
            });
            
	        
	        
	        
	        
	        
	        
	        }
	        
	        
	        
	      
	        
	        
	    }
	    catch(Exception ex) {
	        ex.printStackTrace();
	    }
	    
	}
	public void delete(){
	    try{
	        
	        if(EngUICommon.okToDelete(getParent()))
	        {
	          if(compChequeRoll.getTableCheques().getItemCount()>0)
	          {
	          	 EngUICommon.showMessageBox(getParent(),"�ek bulunan bordrolar? silemezsiniz!",SWT.ICON_WARNING); 
	             return;
	          }
	            CheBLUpdateChequeRoll.deleteChequeRollIn(chequeRoll);
	            EngUICommon.showMessageBox(getParent(),Messages.getString("CheUIChequeInPayrollUpdate.8"),SWT.ICON_INFORMATION); //$NON-NLS-1$
	            isUpdated=true;
	            dialogShell.close();
	        }
	        
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	        EngUICommon.showMessageBox(getParent(),ex.getMessage().toString(),SWT.ICON_ERROR);
	    }
	}
	public void update(){
	    try{
	        
	    	if(compChequeRoll.verifyFields()){ 
	            List chequeList = new ArrayList();
	            int count = compChequeRoll.getTableCheques().getItemCount();
	            for(int i=0;i<count;i++)
	            {
	                chequeList.add(compChequeRoll.getTableCheques().getItem(i).getData());
	                
	            }
	            
	           
	           
	            
	           CheBLUpdateChequeRoll.updateChequeRollIn(chequeRoll,(TurqCurrentCard)compChequeRoll.getCurrentPicker().getData(),null,compChequeRoll.getTxtRollNo().getText().trim(),compChequeRoll.getDatePicker1().getDate(),chequeList,EngBLCommon.CHEQUE_TRANS_OUT_CURRENT,compChequeRoll.getBtnSumTotals().getSelection());
	           EngUICommon.showMessageBox(getParent(),Messages.getString("CheUIChequeInPayroll.13"),SWT.ICON_INFORMATION); //$NON-NLS-1$
	           isUpdated=true;
	           dialogShell.close();
	        }
	        
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	        EngUICommon.showMessageBox(getParent(),ex.getMessage(),SWT.ICON_ERROR);
	    }
	}
}