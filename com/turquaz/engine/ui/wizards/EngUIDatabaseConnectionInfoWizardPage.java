/*
 * Created on Nov 2, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

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
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.dal.EngDALConnection;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngUIDatabaseConnectionInfoWizardPage extends WizardPage {

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
	/**
	 * @return Returns the txtPassword.
	 */
	public Text getTxtPassword() {
		return txtPassword;
	}
	/**
	 * @param txtPassword The txtPassword to set.
	 */
	public void setTxtPassword(Text txtPassword) {
		this.txtPassword = txtPassword;
	}
	/**
	 * @return Returns the txtServerAddress.
	 */
	public Text getTxtServerAddress() {
		return txtServerAddress;
	}
	/**
	 * @param txtServerAddress The txtServerAddress to set.
	 */
	public void setTxtServerAddress(Text txtServerAddress) {
		this.txtServerAddress = txtServerAddress;
	}
	/**
	 * @return Returns the txtServerPort.
	 */
	public Text getTxtServerPort() {
		return txtServerPort;
	}
	/**
	 * @param txtServerPort The txtServerPort to set.
	 */
	public void setTxtServerPort(Text txtServerPort) {
		this.txtServerPort = txtServerPort;
	}
	/**
	 * @return Returns the txtUsername.
	 */
	public Text getTxtUsername() {
		return txtUsername;
	}
	/**
	 * @param txtUsername The txtUsername to set.
	 */
	public void setTxtUsername(Text txtUsername) {
		this.txtUsername = txtUsername;
	}
	 private ISelection selection;
	 private Text txtServerAddress;
     private Text txtServerPort;
     private Text txtUsername;
     private Text txtPassword;
   
	 
	public EngUIDatabaseConnectionInfoWizardPage(ISelection selection){
		  super("Database Connector");
	      setTitle("Database Wizard");
	      setDescription("This wizard creates a new database connection");
	      this.selection = selection;
	      setPageComplete(false);
	       
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createControl(Composite arg0) {
		 Composite container = new Composite(arg0, SWT.NULL);
	     GridLayout layout = new GridLayout();
	     container.setLayout(layout);
	     layout.numColumns = 2;
	     layout.verticalSpacing = 9;

	        Label label = new Label(container, SWT.NULL);
	        label.setText("&Server Address:");

	        txtServerAddress = new Text(container, SWT.BORDER | SWT.SINGLE);

	        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	        txtServerAddress.setLayoutData(gd);
	        txtServerAddress.addModifyListener(new ModifyListener()
	            {
	                public void modifyText(ModifyEvent e)
	                {
	                    dialogChanged();
	                }
	            });

	        label = new Label(container, SWT.NULL);
	        label.setText("&Port:");

	        txtServerPort = new Text(container, SWT.BORDER | SWT.SINGLE);
	       txtServerPort.setText("5432");
	        gd = new GridData(GridData.FILL_HORIZONTAL);
	        txtServerPort.setLayoutData(gd);
	        txtServerPort.addModifyListener(new ModifyListener()
	            {
	                public void modifyText(ModifyEvent e)
	                {
	                    dialogChanged();
	                }
	            });

	        
	       label = new Label(container, SWT.NULL);
	        label.setText("&Username:");

	        txtUsername = new Text(container, SWT.BORDER | SWT.SINGLE);

	        gd = new GridData(GridData.FILL_HORIZONTAL);
	        txtUsername.setLayoutData(gd);
	        txtUsername.addModifyListener(new ModifyListener()
	            {
	                public void modifyText(ModifyEvent e)
	                {
	                	 dialogChanged();
	                	
	                }
	            });

	        label = new Label(container, SWT.NULL);
	        label.setText("&Password:");

	        txtPassword = new Text(container, SWT.BORDER | SWT.SINGLE|SWT.PASSWORD);
	        gd = new GridData(GridData.FILL_HORIZONTAL);
	        txtPassword.setLayoutData(gd);
	        txtPassword.addModifyListener(new ModifyListener()
		            {
		                public void modifyText(ModifyEvent e)
		                {
		                	 dialogChanged();             
		                }
		            });
      
	        
	      
	        this.setControl(container);


	}
	
	 private void updateStatus(String message)
	 {
	        setErrorMessage(message);
	        setPageComplete(message == null);
	       
	 }
	 
	 
	   private void dialogChanged()
	    {
	        if (txtServerAddress.getText().length() == 0)
	        {
	            updateStatus("Server Address must be specified");

	            return;
	        }
	        else if (txtUsername.getText().length() == 0)
	        {
	            updateStatus("Username must be specified.");

	            return;
	        }
	       updateStatus(null);
	        
	    
	    }
	  public IWizardPage getNextPage(){
	   
	  	EngUIDatabaseSelectionWizardPage page =((EngUIDatabaseConnectionWizard)getWizard()).getPage3();
	  	 page.ShowPage();
	   
	  
	  	
	  	return page;
	   	
	   	
	   }
	   
	 	
	 
	 

}
