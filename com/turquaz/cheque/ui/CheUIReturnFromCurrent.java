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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;

import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSaveChequeTransaction;
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
public class CheUIReturnFromCurrent extends org.eclipse.swt.widgets.Composite implements SecureComposite{

    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }

	private Composite compInfoPanel;
	private ToolBar toolBarButtons;
	private ToolItem toolItemAdd;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnPaymentPlace;
	private TableColumn tableColumnDeptor;
	private TableColumn tableColumnDueDaye;
	private TableColumn tableColumnNo;
	private DatePicker datePicker1;
	private CLabel lblRollDate;
	private Text txtRollNo;
	private CLabel lblRollNo;
	private Table tableCheques;
	private ToolItem toolItemDelete;
	List cheques = new ArrayList();
	TurkishCurrencyFormat cf = new TurkishCurrencyFormat();


	public CheUIReturnFromCurrent(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(666, 401);
            {
                compInfoPanel = new Composite(this, SWT.NONE);
                GridLayout compInfoPanelLayout = new GridLayout();
                GridData compInfoPanelLData = new GridData();
                compInfoPanelLData.grabExcessHorizontalSpace = true;
                compInfoPanelLData.horizontalAlignment = GridData.FILL;
                compInfoPanelLData.heightHint = 86;
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
            }
            {
                toolBarButtons = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
                GridData toolBarButtonsLData = new GridData();
                toolBarButtonsLData.horizontalAlignment = GridData.FILL;
                toolBarButtonsLData.grabExcessHorizontalSpace = true;
                toolBarButtons.setLayoutData(toolBarButtonsLData);
                {
                    toolItemAdd = new ToolItem(toolBarButtons, SWT.NONE);
                    toolItemAdd.setText(Messages.getString("CheUIChequeInPayroll.0")); //$NON-NLS-1$
                    toolItemAdd.setImage(SWTResourceManager.getImage("icons/plus.gif")); //$NON-NLS-1$
                    toolItemAdd.addSelectionListener(new SelectionAdapter() {
                        public void widgetSelected(SelectionEvent evt) {
                            addCheque();
                            
                        }
                    });

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
                    tableColumnNo.setWidth(72);
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
       
        CheUIReturnFromCurrent  curCard = new CheUIReturnFromCurrent(this.getParent(),this.getStyle());
		CTabFolder tabfld = (CTabFolder)this.getParent();
		tabfld.getSelection().setControl(curCard);	 
		this.dispose();

        

    }
    public boolean verifyFields(){
     
    	if(tableCheques.getItemCount()==0)
        {
            EngUICommon.showMessageBox(getShell(),Messages.getString("CheUIChequeInPayroll.12"),SWT.ICON_WARNING); //$NON-NLS-1$
            toolItemAdd.setSelection(true);
            return false;
        }
        return true;
    }
    
    
    public void save() {
     try{
         
        if(verifyFields()){ 

//	          TODO cheq trans exRate
              CheBLSaveChequeTransaction.saveReturnToCurrent(null,
              		
			  txtRollNo.getText().trim(),
			  datePicker1.getDate(),cheques);

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
            	   cheques.remove(selection[0].getData());
              selection[0].dispose();
           
                
            }            
            
        }
        
        
        
    } 
   
    public void addCheque(){
     
        cheques = new CheUICustomerChequeChooseDialog(getShell(),SWT.NULL,cheques).open();
        fillTable();
      
        
    }
    public void fillTable(){
        tableCheques.removeAll();
        for(int i= 0;i<cheques.size();i++)
        { 
            TableItem item;
            TurqChequeCheque cheque = (TurqChequeCheque) cheques.get(i);
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
        
    
    }
    
    
	
	/**
	 * @return Returns the toolItemAdd.
	 */
	public ToolItem getToolItemAdd() {
		return toolItemAdd;
	}
	/**
	 * @param toolItemAdd The toolItemAdd to set.
	 */
	public void setToolItemAdd(ToolItem toolItemAdd) {
		this.toolItemAdd = toolItemAdd;
	}
	/**
	 * @return Returns the toolItemDelete.
	 */
	public ToolItem getToolItemDelete() {
		return toolItemDelete;
	}
	/**
	 * @param toolItemDelete The toolItemDelete to set.
	 */
	public void setToolItemDelete(ToolItem toolItemDelete) {
		this.toolItemDelete = toolItemDelete;
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
    
	
