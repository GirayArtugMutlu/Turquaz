/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;


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
/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
