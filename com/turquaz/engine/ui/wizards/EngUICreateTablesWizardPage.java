/*
 * Created on Nov 2, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

import java.awt.Container;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngUICreateTablesWizardPage extends WizardPage {

	 private ISelection selection;
	 private boolean isDisplaySet = false;
	 private Button btnYes;
	 private Button btnNo;
	public EngUICreateTablesWizardPage(ISelection selection)
    {		
        super("Database Connector");
        setTitle("Database Wizard");
        setDescription("This wizard creates a new database connection");
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
	        label.setText("Could not find tables? Would you like to create?");

	        btnYes = new Button(container, SWT.RADIO | SWT.LEFT);
	        btnYes.setSelection(true);
			btnYes.setText("Yes, create tables now!(Recommended)");
			btnYes.addSelectionListener(new SelectionAdapter(){
			
				public void widgetSelected(SelectionEvent e){
				
					setPageComplete(true);
				
				}
				
			});
			
			
			btnNo = new Button(container, SWT.RADIO | SWT.LEFT);
		    btnNo.setText("No, I will create manually!");
		    btnNo.addSelectionListener(new SelectionAdapter(){
				
					public void widgetSelected(SelectionEvent e){
					
						setPageComplete(true);
					
					}
					
				});
		    
	        }
	        else{
	        	   Label label = new Label(container, SWT.NULL);	
	        	   label.setText("Congratulations! You finished database configuration..");
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