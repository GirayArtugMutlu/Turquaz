/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

import org.dom4j.Text;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngUIDatabaseSelectionWizardPage extends WizardPage {
	 private ISelection selection;
	 private boolean isDisplaySet = false;
	public EngUIDatabaseSelectionWizardPage(ISelection selection)
	    {
	        super("Database Connector");
	        setTitle("Database Wizard");
	        setDescription("This wizard creates a new database connection");
	        this.selection = selection;
	        setPageComplete(false);
	        setErrorMessage("Please Choose a Database Server");
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

	        CCombo comboDBServer = new CCombo(container, SWT.WRAP);

	        comboDBServer.add("Postgresql RDBM"); 
	         
	        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	        comboDBServer.setLayoutData(gd);
	        comboDBServer.addSelectionListener(new SelectionAdapter()
	            {
	                public void widgetSelected(SelectionEvent e)
	                {
	                    setPageComplete(true);
	                    setErrorMessage(null);
	                }
	            });
	      
	        this.setControl(container);

	 		 	
	  }
	 private void updateStatus(String message)
	   {
	        setErrorMessage(message);
	        setPageComplete(message == null);
	    }
}
