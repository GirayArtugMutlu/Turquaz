/*
 * Created on Nov 2, 2004
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
import java.sql.ResultSet;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.dal.EngDALConnection;

public class EngUIDatabaseSelectionWizardPage extends WizardPage {
	 private ISelection selection;
	 private CCombo comboDatabases;
	 private EngDALConnection connection;
	public EngUIDatabaseSelectionWizardPage( ISelection selection){

        super("Database Connector");
        setTitle("Database Wizard");
        setDescription("This wizard creates a new database connection \n asdasd");
        this.selection = selection;
        setPageComplete(false);
     }
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite arg0) {
		Composite container = new Composite(arg0, SWT.NULL);
	            
	   this.setControl(container);

	}
	
	
	public void ShowPage(){
		Composite container = (Composite)this.getControl();
		Control children[] = container.getChildren();
		for(int i=0;i<children.length;i++){
			children[i].dispose();
			
		}		
		if(checkConnection()){
			setErrorMessage(null);
			GridLayout layout = new GridLayout();
		     container.setLayout(layout);
		     layout.numColumns = 2;
		     layout.verticalSpacing = 9;

		        Label label = new Label(container, SWT.NULL);
		        label.setText("&Database Name:");

		        comboDatabases = new CCombo(container, SWT.FLAT);
		        comboDatabases.setEditable(false);
		        comboDatabases.setBackground(SWTResourceManager.getColor(255, 255, 255));

		        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		        comboDatabases.setLayoutData(gd);
		        comboDatabases.addSelectionListener(new SelectionAdapter()
		            {
		                public void widgetSelected(SelectionEvent e)
		                {
		                    setPageComplete(true);
		                }
		            });
		         
		        container.layout();
		        
		        fillCombo();
		  }
			
			else{
			setErrorMessage("Can not establish database connection .Check connection information!\n" +
					"and be sure that your database server is running!");
				
			}
	}
	
	public void fillCombo(){
		if(connection!=null){
			try{
			ResultSet rs = connection.getResultSet("SELECT d.datname as name FROM pg_database d where d.datistemplate ='false'");
			while(rs.next()){
			comboDatabases.add(rs.getString("name"));		
			}
			rs.close();
		}
			catch(Exception ex){
			   ex.printStackTrace();
			}
			
		}
		
	}
	
	public boolean checkConnection(){
	   EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard)getWizard()).getPage1();
	   EngUIDatabaseConnectionInfoWizardPage page2 =((EngUIDatabaseConnectionWizard)getWizard()).getPage2();
	   
	   connection = new EngDALConnection(page1.getComboDBServer().getText(),
	   									 page2.getTxtUsername().getText(),
										 page2.getTxtPassword().getText(),
										 page2.getTxtServerAddress().getText()+":"+
										 page2.getTxtServerPort().getText(),
										 "template1");
	   
	   	try{
	   	    connection.connect();
	   		return true;
	   	}
	   	catch(Exception ex){
	   		ex.printStackTrace();
	   		return false;
	   	}
	
	}
	
   private void updateStatus(String message)
   {
	        setErrorMessage(message);
            setPageComplete(message == null);
   }
	 
   private void dialogChanged()
	{
	        if (comboDatabases.getText().length() == 0)
	        {
	            updateStatus("Username must be specified.");

	            return;
	        }
	        
	        
	        updateStatus(null);
	}
   	public IWizardPage getNextPage(){
	   
	  	EngUICreateTablesWizardPage page =((EngUIDatabaseConnectionWizard)getWizard()).getPage4();
	  	page.ShowPage(comboDatabases.getText());
	   
	  	return page;
	   	
	   	
	   }
	 

	/**
	 * @return Returns the comboDatabases.
	 */
	public CCombo getComboDatabases() {
		return comboDatabases;
	}
	/**
	 * @param comboDatabases The comboDatabases to set.
	 */
	public void setComboDatabases(CCombo comboDatabases) {
		this.comboDatabases = comboDatabases;
	}
}
