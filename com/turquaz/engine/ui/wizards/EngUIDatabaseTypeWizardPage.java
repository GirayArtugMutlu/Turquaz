/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


public class EngUIDatabaseTypeWizardPage extends WizardPage {
	 private ISelection selection;
	 private boolean isDisplaySet = false;
	 private CCombo comboDBServer;
	public EngUIDatabaseTypeWizardPage(ISelection selection)
	    {
	        super("Database Connector");
	        setTitle("Database Wizard");
	        setDescription("This wizard creates a new database connection");
	        this.selection = selection;
	        setPageComplete(false);
	    }
	 public void createControl(Composite parent)
	  {
	 	  Composite container = new Composite(parent, SWT.NULL);
	        GridLayout layout = new GridLayout();
	        container.setLayout(layout);
	        layout.numColumns = 2;
	        layout.verticalSpacing = 9;

	        Label label = new Label(container, SWT.NULL);
	        label.setText("&Database Server:");

	        comboDBServer = new CCombo(container, SWT.WRAP);

	        comboDBServer.add("Postgresql RDBM"); 
	         
	        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	        comboDBServer.setLayoutData(gd);
	        comboDBServer.addSelectionListener(new SelectionAdapter()
	            {
	                public void widgetSelected(SelectionEvent e)
	                {
	                updateStatus(null);
	                }
	            });
	      
	        this.setControl(container);

	 		 	
	  }
	 private void updateStatus(String message)
	   {
	        setErrorMessage(message);
	        setPageComplete(message == null);
	    }
	 
	
	 
	/**
	 * @return Returns the comboDBServer.
	 */
	public CCombo getComboDBServer() {
		return comboDBServer;
	}
	/**
	 * @param comboDBServer The comboDBServer to set.
	 */
	public void setComboDBServer(CCombo comboDBServer) {
		this.comboDBServer = comboDBServer;
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
