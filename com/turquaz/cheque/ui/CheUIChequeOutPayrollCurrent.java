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
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.cheque.Messages;
import com.turquaz.engine.ui.component.SecureComposite;



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
public class CheUIChequeOutPayrollCurrent extends org.eclipse.swt.widgets.Composite implements SecureComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compInfoPanel;
	private ToolBar toolBarButtons;
	private ToolItem toolItemAddOwn;
	private ToolItem toolItemAddCustomer;
	private Button btnSumTotals;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnPaymentPlace;
	private TableColumn tableColumnDeptor;
	private TableColumn tableColumnDueDaye;
	private TableColumn tableColumnNo;
	private CurrentPicker currentPicker;
	private CLabel lblCurrentCode;
	private DatePicker datePicker1;
	private CLabel lblRollDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private Table tableCheques;
	private ToolItem toolItemUpdate;
	private ToolItem toolItemDelete;
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();

	public CheUIChequeOutPayrollCurrent(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(663, 373);
            {
                compInfoPanel = new Composite(this, SWT.NONE);
                GridLayout compInfoPanelLayout = new GridLayout();
                GridData compInfoPanelLData = new GridData();
                compInfoPanelLData.grabExcessHorizontalSpace = true;
                compInfoPanelLData.horizontalAlignment = GridData.FILL;
                compInfoPanelLData.heightHint = 103;
                compInfoPanel.setLayoutData(compInfoPanelLData);
                compInfoPanelLayout.numColumns = 2;
                compInfoPanel.setLayout(compInfoPanelLayout);
                {
                    lblRollNo = new CLabel(compInfoPanel, SWT.NONE);
                    lblRollNo.setText(Messages
                        .getString("CheUIChequeInPayroll.1")); //$NON-NLS-1$
                }
                {
                    txtRollNo = new Text(compInfoPanel, SWT.NONE);
                    GridData txtRollNoLData = new GridData();
                    txtRollNoLData.widthHint = 134;
                    txtRollNoLData.heightHint = 18;
                    txtRollNo.setLayoutData(txtRollNoLData);
                }
                {
                    lblRollDate = new CLabel(compInfoPanel, SWT.NONE);
                    lblRollDate.setText(Messages
                        .getString("CheUIChequeInPayroll.3")); //$NON-NLS-1$
                }
                {
                    datePicker1 = new DatePicker(compInfoPanel, SWT.NONE);
                    GridData datePicker1LData = new GridData();
                    datePicker1LData.widthHint = 143;
                    datePicker1LData.heightHint = 19;
                    datePicker1.setLayoutData(datePicker1LData);
                }
                {
                    lblCurrentCode = new CLabel(compInfoPanel, SWT.NONE);
                    lblCurrentCode.setText(Messages
                        .getString("CheUIChequeInPayroll.5")); //$NON-NLS-1$
                }
                {
                    currentPicker = new CurrentPicker(compInfoPanel, SWT.NONE);
                    GridData currentPickerLData = new GridData();
                    currentPickerLData.widthHint = 330;
                    currentPickerLData.heightHint = 15;
                    currentPicker.setLayoutData(currentPickerLData);
                }
                {
                    btnSumTotals = new Button(compInfoPanel, SWT.CHECK
                        | SWT.LEFT);
                    btnSumTotals.setText("Cari Hareketleri Topla ");
                }
            }
            {
                toolBarButtons = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
                GridData toolBarButtonsLData = new GridData();
                toolBarButtonsLData.horizontalAlignment = GridData.FILL;
                toolBarButtonsLData.grabExcessHorizontalSpace = true;
                toolBarButtons.setLayoutData(toolBarButtonsLData);
                {
                    toolItemAddOwn = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemAddOwn.setText("Firma �eki"); //$NON-NLS-1$
                    toolItemAddOwn.setImage(SWTResourceManager.getImage("icons/plus.gif")); //$NON-NLS-1$
                    toolItemAddOwn.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            addOwnCheque();
                            
                        }
                    });

                }
                {
                    toolItemAddCustomer = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemAddCustomer.setText("M�?teri �eki");
                    toolItemAddCustomer.setImage(SWTResourceManager.getImage("icons/plus.gif"));
                }
                {
                    toolItemDelete = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemDelete.setText(Messages.getString("CheUIChequeInPayroll.2")); //$NON-NLS-1$
                    toolItemDelete.setImage(SWTResourceManager
                        .getImage("icons/minus.gif")); //$NON-NLS-1$
                        toolItemDelete
                            .addSelectionListener(new SelectionAdapter() {
                            public void widgetSelected(SelectionEvent evt) {
                              
                            deleteTableRow();
                            
                            
                            }
                            });
                }
                {
                    toolItemUpdate = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemUpdate.setText(Messages.getString("CheUIChequeInPayroll.4")); //$NON-NLS-1$
                    toolItemUpdate.setImage(SWTResourceManager.getImage("icons/Refresh16.gif")); //$NON-NLS-1$
                    toolItemUpdate.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            updateCheque();
                            
                        }
                    });
                }
            }
            {
                tableCheques = new Table(this, SWT.FULL_SELECTION);
                tableCheques.setLinesVisible(true);
                tableCheques.setHeaderVisible(true);
                GridData tableChequesLData = new GridData();
                tableChequesLData.grabExcessHorizontalSpace = true;
                tableChequesLData.horizontalAlignment = GridData.FILL;
                tableChequesLData.verticalAlignment = GridData.FILL;
                tableChequesLData.grabExcessVerticalSpace = true;
                tableCheques.setLayoutData(tableChequesLData);
                {
                    tableColumnNo = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnNo.setText(Messages.getString("CheUIChequeInPayroll.6")); //$NON-NLS-1$
                    tableColumnNo.setWidth(59);
                }
                {
                    tableColumnDueDaye = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnDueDaye.setText(Messages.getString("CheUIChequeInPayroll.7")); //$NON-NLS-1$
                    tableColumnDueDaye.setWidth(100);
                }
                {
                    tableColumnPaymentPlace = new TableColumn(
                        tableCheques,
                        SWT.NONE);
                    tableColumnPaymentPlace.setText(Messages.getString("CheUIChequeInPayroll.9")); //$NON-NLS-1$
                    tableColumnPaymentPlace.setWidth(151);
                }
                {
                    tableColumnDeptor = new TableColumn(tableCheques, SWT.NONE);
                    tableColumnDeptor.setText(Messages.getString("CheUIChequeInPayroll.8")); //$NON-NLS-1$
                    tableColumnDeptor.setWidth(145);
                }
                {
                    tableColumnAmount = new TableColumn(tableCheques, SWT.RIGHT);
                    tableColumnAmount.setText(Messages.getString("CheUIChequeInPayroll.10")); //$NON-NLS-1$
                    tableColumnAmount.setWidth(100);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public void newForm() {
       
        CheUIChequeOutPayrollCurrent  curCard = new CheUIChequeOutPayrollCurrent(this.getParent(),this.getStyle());
		 CTabFolder tabfld = (CTabFolder)this.getParent();
		 tabfld.getSelection().setControl(curCard);	 
		 this.dispose();

        

    }
    public boolean verifyFields(){
        if(currentPicker.getData()==null)
        {
            EngUICommon.showMessageBox(getShell(),Messages.getString("CheUIChequeInPayroll.11"),SWT.ICON_WARNING); //$NON-NLS-1$
            currentPicker.setFocus();
            return false;
        }
        else if(tableCheques.getItemCount()==0)
        {
            EngUICommon.showMessageBox(getShell(),Messages.getString("CheUIChequeInPayroll.12"),SWT.ICON_WARNING); //$NON-NLS-1$
            toolItemAddOwn.setSelection(true);
            return false;
        }
        return true;
    }
    
    
    public void save() {
     try{
         
        if(verifyFields()){ 
        List chequeList = new ArrayList();
        int count = tableCheques.getItemCount();
        for(int i=0;i<count;i++)
        {
            chequeList.add(tableCheques.getItem(i).getData());
            
        }
        /**
         * TODO new save function...
         */
       // CheBLSaveChequeTransaction.saveChequeRoll((TurqCurrentCard)currentPicker.getData(),null,txtRollNo.getText().trim(),datePicker1.getDate(),chequeList,EngBLCommon.CHEQUE_TRANS_IN,btnSumTotals.getSelection());
        EngUICommon.showMessageBox(getShell(),Messages.getString("CheUIChequeInPayroll.13"),SWT.ICON_INFORMATION); //$NON-NLS-1$
        newForm();
        }
         
     }
     catch(Exception ex){
         ex.printStackTrace();
         EngUICommon.showMessageBox(getShell(),ex.getMessage().toString(),SWT.ICON_ERROR);
     }

    }
    public void deleteTableRow(){
        TableItem selection [] = tableCheques.getSelection();
        if(selection.length>0){
            if(EngUICommon.okToDelete(this.getShell()))
            {
              selection[0].dispose();
                
            }            
            
        }
        
        
        
    }
  
    public void updateCheque(){
        
        TableItem selection[]= tableCheques.getSelection();
        TurqChequeCheque cheque=null;
        if(selection.length>0){
         /**
          * TODO update Dialog
          */
            
       //  cheque = new CheUICustomerChequeAddDialog(getShell(),SWT.NULL).open((TurqChequeCheque)selection[0].getData());
         if(cheque!=null){
            
             selection[0].setData(cheque);
             selection[0].setText(new String[]{
             cheque.getChequesPortfolioNo(),
             DatePicker.formatter.format(cheque.getChequesDueDate()),
             cheque.getChequesPaymentPlace(),
             cheque.getChequesDebtor(),
             cf.format(cheque.getChequesAmount())            
             });
             
         }
         
            
        }
         
       
    
        
    
    
    }    
    public void addOwnCheque(){
        TableItem item;
        /**
         * TODO add dialog
         */
        TurqChequeCheque cheque = new CheUIOwnChequeAddDialog(getShell(),SWT.NULL).open();
        if(cheque!=null){
            item = new TableItem(tableCheques,SWT.NULL);
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
    
    
    public CurrentPicker getCurrentPicker() {
        return currentPicker;
    }
    public void setCurrentPicker(CurrentPicker currentPicker) {
        this.currentPicker = currentPicker;
    }
    public DatePicker getDatePicker1() {
        return datePicker1;
    }
    public void setDatePicker1(DatePicker datePicker1) {
        this.datePicker1 = datePicker1;
    }
    public Table getTableCheques() {
        return tableCheques;
    }
    public void setTableCheques(Table tableCheques) {
        this.tableCheques = tableCheques;
    }
    public Text getTxtRollNo() {
        return txtRollNo;
    }
    public void setTxtRollNo(Text txtRollNo) {
        this.txtRollNo = txtRollNo;
    }
}