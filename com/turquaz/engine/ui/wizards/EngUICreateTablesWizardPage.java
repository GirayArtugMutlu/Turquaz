
package com.turquaz.engine.ui.wizards;

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


import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

import com.turquaz.engine.Messages;

public class EngUICreateTablesWizardPage extends WizardPage {

	 private ISelection selection;
	 private boolean isDisplaySet = false;
	 private Button btnYes;
	 private Button btnNo;
	public EngUICreateTablesWizardPage(ISelection selection)
    {		
        super("Database Connector"); //$NON-NLS-1$
        setTitle(Messages.getString("EngUICreateTablesWizardPage.1")); //$NON-NLS-1$
        setDescription(Messages.getString("EngUICreateTablesWizardPage.2")); //$NON-NLS-1$
        this.selection = selection;
        setPageComplete(true);
     
       
    }
	public void createControl(Composite arg0) {
		Composite container = new Composite(arg0, SWT.NULL);
       
        this.setControl(container);
	}
	
	public void ShowPage(String dbName){
		Composite container = (Composite)this.getControl();
		Control children[] = container.getChildren();
		for(int i=0;i<children.length;i++){
			children[i].dispose();
			
		}		
		 GridLayout layout = new GridLayout();
	        container.setLayout(layout);
	        layout.numColumns = 1;
	        layout.verticalSpacing = 9;
	        if(!checkTables()){

	        Label label = new Label(container, SWT.NULL);
	        label.setText(Messages.getString("EngUICreateTablesWizardPage.3")); //$NON-NLS-1$

	        btnYes = new Button(container, SWT.RADIO | SWT.LEFT);
	        btnYes.setSelection(true);
			btnYes.setText(Messages.getString("EngUICreateTablesWizardPage.4")); //$NON-NLS-1$
			btnYes.addSelectionListener(new SelectionAdapter(){
			
				public void widgetSelected(SelectionEvent e){
				
					setPageComplete(true);
				
				}
				
			});
			
			
			btnNo = new Button(container, SWT.RADIO | SWT.LEFT);
		    btnNo.setText(Messages.getString("EngUICreateTablesWizardPage.5")); //$NON-NLS-1$
		    btnNo.addSelectionListener(new SelectionAdapter(){
				
					public void widgetSelected(SelectionEvent e){
					
						setPageComplete(true);
					
					}
					
				});
		    
	        }
	        else{
	        	   Label label = new Label(container, SWT.NULL);	
	        	   label.setText(Messages.getString("EngUICreateTablesWizardPage.6")); //$NON-NLS-1$
	        }
	        container.layout();
	
	}
	
	public boolean checkTables(){
		return false;
	}

	/**
	 * @return Returns the btnYes.
	 */
	public Button getButtonYes() {
		return btnYes;
	}
	/**
	 * @param btnYes The btnYes to set.
	 */
	public void setButtonYes(Button button1) {
		this.btnYes = button1;
	}
	/**
	 * @return Returns the btnNo.
	 */
	public Button getBtnNo() {
		return btnNo;
	}
	/**
	 * @param btnNo The btnNo to set.
	 */
	public void setBtnNo(Button button2) {
		this.btnNo = button2;
	}
	/**
	 * @return Returns the isDisplaySet.
	 */
	public boolean isDisplaySet() {
		return isDisplaySet;
	}
	/**
	 * @param isDisplaySet The isDisplaySet to set.
	 */
	public void setDisplaySet(boolean isDisplaySet) {
		this.isDisplaySet = isDisplaySet;
	}
	/**
	 * @return Returns the selection.
	 */
	public ISelection getSelection() {
		return selection;
	}
	/**
	 * @param selection The selection to set.
	 */
	public void setSelection(ISelection selection) {
		this.selection = selection;
	}
}
