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
import java.util.Calendar;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;

import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLUpdateCheque;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.CurrencyText;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import com.turquaz.engine.ui.component.DatePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
public class CheUICustomerChequeUpdate extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CLabel lblPortfolioNo;
	private CurrencyText curText;
	private CLabel lblBankAccount;
	private ToolItem toolDelete;
	private Text txtBankAccountNO;
	private ToolItem toolCancel;
	private ToolItem toolSave;
	private ToolBar toolBar1;
	private CLabel lblAmount;
	private Text txtPaymentPlace;
	private CLabel lblPaymentPlace;
	private CLabel lblBankName;
	private Text txtDeptor;
	private CLabel lblDeptor;
	private DatePicker datePickValueDate;
	private CLabel lblDueDate;
	private Text txtBankBranch;
	private CLabel lblBankBranch;
	private Text txtBankName;
	private Text txtChequeNo;
	private CLabel lblChequeNo;
	private Text txtPortfoyNo;
	TurqChequeCheque cheque = null;
	boolean isUpdated = false;

	public CheUICustomerChequeUpdate(Shell parent, int style,TurqChequeCheque cheque) {
		super(parent, style);
		this.cheque = cheque;
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


			GridLayout dialogShellLayout = new GridLayout();
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.numColumns = 2;
			dialogShell.layout();
			dialogShell.setText(Messages.getString("CheUICustomerChequeAddDialog.3")); //$NON-NLS-1$
			dialogShell.pack();
			dialogShell.setText(Messages.getString("CheUICustomerChequeAddDialog.1")); //$NON-NLS-1$
			dialogShell.setSize(507, 303);
            {
                toolBar1 = new ToolBar(dialogShell, SWT.NONE);
                GridData toolBar1LData = new GridData();
                toolBar1LData.horizontalAlignment = GridData.FILL;
                toolBar1LData.grabExcessHorizontalSpace = true;
                toolBar1LData.horizontalSpan = 2;
                toolBar1.setLayoutData(toolBar1LData);
                {
                    toolSave = new ToolItem(toolBar1, SWT.NONE);
                    toolSave.setText(Messages.getString("CheUICustomerChequeAddDialog.0")); //$NON-NLS-1$
                    toolSave.setImage(SWTResourceManager
                        .getImage("icons/save_edit.gif")); //$NON-NLS-1$
                    toolSave.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            update();
                        }
                    });
                }
				//START >>  toolDelete
				toolDelete = new ToolItem(toolBar1, SWT.NONE);
				toolDelete.setText("Sil");
				toolDelete.setImage(SWTResourceManager.getImage("icons/delete_edit.gif"));
				toolDelete.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						toolDeleteWidgetSelected(evt);
					}
				});
				//END <<  toolDelete
                {
                    toolCancel = new ToolItem(toolBar1, SWT.NONE);
                    toolCancel.setText("Kapat"); //$NON-NLS-1$
                    toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
                    toolCancel.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                          dialogShell.close();
                        }
                    });
                }
            }
            {
                lblPortfolioNo = new CLabel(dialogShell, SWT.NONE);
                lblPortfolioNo.setText(Messages.getString("CheUICustomerChequeAddDialog.4")); //$NON-NLS-1$
            }
            {
                txtPortfoyNo = new Text(dialogShell, SWT.NONE);
                GridData txtPortfoyNoLData = new GridData();
                txtPortfoyNoLData.widthHint = 120;
                txtPortfoyNoLData.heightHint = 18;
                txtPortfoyNo.setLayoutData(txtPortfoyNoLData);
            }
            {
                lblChequeNo = new CLabel(dialogShell, SWT.NONE);
                lblChequeNo.setText(Messages.getString("CheUICustomerChequeAddDialog.5")); //$NON-NLS-1$
            }
            {
                txtChequeNo = new Text(dialogShell, SWT.NONE);
                GridData txtChequeNoLData = new GridData();
                txtChequeNoLData.widthHint = 119;
                txtChequeNoLData.heightHint = 17;
                txtChequeNo.setLayoutData(txtChequeNoLData);
            }
            {
                lblBankName = new CLabel(dialogShell, SWT.NONE);
                lblBankName.setText(Messages.getString("CheUICustomerChequeAddDialog.6")); //$NON-NLS-1$
            }
            {
                txtBankName = new Text(dialogShell, SWT.NONE);
                GridData txtBankNameLData = new GridData();
                txtBankNameLData.widthHint = 118;
                txtBankNameLData.heightHint = 19;
                txtBankName.setLayoutData(txtBankNameLData);
            }
            {
                lblBankBranch = new CLabel(dialogShell, SWT.NONE);
                lblBankBranch.setText(Messages.getString("CheUICustomerChequeAddDialog.7")); //$NON-NLS-1$
            }
            {
                txtBankBranch = new Text(dialogShell, SWT.NONE);
                GridData txtBankBranchLData = new GridData();
                txtBankBranchLData.widthHint = 117;
                txtBankBranchLData.heightHint = 18;
                txtBankBranch.setLayoutData(txtBankBranchLData);
            }
			//START >>  lblBankAccount
			lblBankAccount = new CLabel(dialogShell, SWT.NONE);
			lblBankAccount.setText(Messages.getString("CheUICustomerChequeAddDialog.12")); //$NON-NLS-1$
			//END <<  lblBankAccount
			//START >>  txtBankAccountNO
			txtBankAccountNO = new Text(dialogShell, SWT.NONE);
			GridData txtBankAccountNOLData = new GridData();
			txtBankAccountNOLData.widthHint = 118;
			txtBankAccountNOLData.heightHint = 17;
			txtBankAccountNO.setLayoutData(txtBankAccountNOLData);
			//END <<  txtBankAccountNO
            {
                lblDueDate = new CLabel(dialogShell, SWT.NONE);
                lblDueDate.setText(Messages.getString("CheUICustomerChequeAddDialog.8")); //$NON-NLS-1$
            }
            {
                datePickValueDate = new DatePicker(dialogShell, SWT.NONE);
                GridData datePickValueDateLData = new GridData();
                datePickValueDateLData.widthHint = 113;
                datePickValueDateLData.heightHint = 19;
                datePickValueDate.setLayoutData(datePickValueDateLData);
            }
            {
                lblDeptor = new CLabel(dialogShell, SWT.NONE);
                lblDeptor.setText(Messages.getString("CheUICustomerChequeAddDialog.9")); //$NON-NLS-1$
                GridData lblDeptorLData = new GridData();
                lblDeptorLData.widthHint = 42;
                lblDeptorLData.heightHint = 19;
                lblDeptor.setLayoutData(lblDeptorLData);
            }
            {
                txtDeptor = new Text(dialogShell, SWT.NONE);
                GridData txtDeptorLData = new GridData();
                txtDeptorLData.widthHint = 190;
                txtDeptorLData.heightHint = 17;
                txtDeptor.setLayoutData(txtDeptorLData);
            }
            {
                lblPaymentPlace = new CLabel(dialogShell, SWT.NONE);
                lblPaymentPlace.setText(Messages.getString("CheUICustomerChequeAddDialog.10")); //$NON-NLS-1$
            }
            {
                txtPaymentPlace = new Text(dialogShell, SWT.NONE);
                GridData txtPaymentPlaceLData = new GridData();
                txtPaymentPlaceLData.widthHint = 117;
                txtPaymentPlaceLData.heightHint = 19;
                txtPaymentPlace.setLayoutData(txtPaymentPlaceLData);
            }
            {
                lblAmount = new CLabel(dialogShell, SWT.NONE);
                lblAmount.setText(Messages.getString("CheUICustomerChequeAddDialog.11")); //$NON-NLS-1$
            }
            {
                curText = new CurrencyText(dialogShell, SWT.NONE);
                GridData curTextLData = new GridData();
                curTextLData.widthHint = 117;
                curTextLData.heightHint = 19;
                curText.setLayoutData(curTextLData);
            }
            postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			return isUpdated;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public void postInitGUI(){
	  
		EngUICommon.centreWindow(dialogShell);
	    if(cheque!=null){
	        txtBankBranch.setText(cheque.getBankBranchName());
	        txtBankName.setText(cheque.getBankName());
	        txtChequeNo.setText(cheque.getChequesNo());
	        txtDeptor.setText(cheque.getChequesDebtor());
	        txtPaymentPlace.setText(cheque.getChequesPaymentPlace());
	        txtPortfoyNo.setText(cheque.getChequesPortfolioNo());
	        datePickValueDate.setDate(cheque.getChequesDueDate());
	        curText.setText(cheque.getChequesAmount());
	      
	        if(cheque.getBankAccountNo()!=null){
	        txtBankAccountNO.setText(cheque.getBankAccountNo());
	        }
	        
	    }
	    
	}
	
	public void update(){
		try{
			
		
	  
	    cheque.setBankBranchName(txtBankBranch.getText().trim());
	    cheque.setBankName(txtBankName.getText().trim());
	    cheque.setChequesPortfolioNo(txtPortfoyNo.getText().trim());
	    cheque.setChequesNo(txtChequeNo.getText().trim());
	    cheque.setChequesDueDate(datePickValueDate.getDate());
	    cheque.setChequesValueDate(datePickValueDate.getDate());
	    cheque.setChequesDebtor(txtDeptor.getText().trim());
	    cheque.setChequesPaymentPlace(txtPaymentPlace.getText().trim());
	    cheque.setChequesAmount(curText.getBigDecimalValue());	  
	    cheque.setBankAccountNo(txtBankAccountNO.getText().trim());
	    
        cheque.setUpdatedBy(System.getProperty("user")); //$NON-NLS-1$
        cheque.setLastModified(Calendar.getInstance().getTime());
        
        CheBLUpdateCheque.updateCheque(cheque);
        
        isUpdated =true;
	    
	    dialogShell.close();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	    
	}
	
	private void toolDeleteWidgetSelected(SelectionEvent evt) {
		try{
		//	CheBLUpdateCheque.deleteCheque(cheque);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

}
