/*
 * Created on Nov 2, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

import java.sql.ResultSet;

import org.eclipse.jface.viewers.ISelection;
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
	    
		if(checkConnection()){
		GridLayout layout = new GridLayout();
	     container.setLayout(layout);
	     layout.numColumns = 2;
	     layout.verticalSpacing = 9;

	        Label label = new Label(container, SWT.NULL);
	        label.setText("&Username:");

	        comboDatabases = new CCombo(container, SWT.FLAT);

	        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
	        comboDatabases.setLayoutData(gd);
	        comboDatabases.addSelectionListener(new SelectionAdapter()
	            {
	                public void widgetSelected(SelectionEvent e)
	                {
	                    setPageComplete(true);
	                }
	            });
	         
	        fillCombo();
	}
		
		else{
		setErrorMessage("Can not establish database connection .Check connection information!\n" +
				"and be sure that your database server is running!");
			
		}
	        
	this.setControl(container);

	}
	
	public void fillCombo(){
		if(connection!=null){
			try{
			ResultSet rs = connection.getResultSet("SELECT d.datname as name FROM pg_database d where d.datistemplate ='false'");
			while(rs.next()){
			comboDatabases.add(rs.getString("name"));		
			}
			
			
			}
			catch(Exception ex){
			   ex.printStackTrace();
			}
			
		}
		
	}
	
	public boolean checkConnection(){
	   EngUIDatabaseTypeWizardPage page1 = ((EngUIDatabaseConnectionWizard)getWizard()).getPage1();
	   EngUIDatabaseConnectionInfoWizardPage page2 =((EngUIDatabaseConnectionWizard)getWizard()).getPage2();
	   
	   System.out.println(page2.getTxtPassword().getText());
	   connection = new EngDALConnection(page1.getComboDBServer().getText(),
	   									 page2.getTxtUsername().getText(),
										 page2.getTxtPassword().getText(),
										 page2.getTxtServerAddress().getText()+":"+
										 page2.getTxtServerPort().getText());
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
	 

}
