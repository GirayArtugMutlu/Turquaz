/*
 * Created on Nov 1, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.wizards;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.FileOutputStream;
import java.util.Properties;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;

import com.turquaz.engine.dal.EngDALConnection;
public class EngUIDatabaseConnectionWizard extends Wizard {
    
	private EngUIDatabaseTypeWizardPage page1;
	private EngUIDatabaseConnectionInfoWizardPage page2;
	private EngUIDatabaseSelectionWizardPage page3;
	private EngUICreateTablesWizardPage page4;
	
	private ISelection selection;
	
	public EngUIDatabaseConnectionWizard(){
		super();
		setNeedsProgressMonitor(true);
	}
	public void addPages(){
		
		page1 = new EngUIDatabaseTypeWizardPage(selection);
		page2 = new  EngUIDatabaseConnectionInfoWizardPage(selection);
		page3 = new EngUIDatabaseSelectionWizardPage(selection);
		page4 = new EngUICreateTablesWizardPage(selection);
		addPage(page1);
		addPage(page2);
		addPage(page3);
		addPage(page4);
		
		//addPage(page4);
		
		
	}
	public boolean performFinish(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		try{
		
		String dbType = page1.getComboDBServer().getText();
		String username= page2.getTxtUsername().getText();
		String password=  page2.getTxtPassword().getText();
		String serverAddress= page2.getTxtServerAddress().getText();
		String serverPort = page2.getTxtServerPort().getText();
		String dbName = page3.getComboDatabases().getText();
		
	   Properties props = new Properties();	
		props.setProperty("dbType",dbType);
		props.setProperty("dbUsername",username);
		props.setProperty("dbPassword",password);
		props.setProperty("serverAddress",serverAddress);
		props.setProperty("serverPort",serverPort);
		props.setProperty("dbName",dbName);
	  
		FileOutputStream fileout = new FileOutputStream("config/turquaz.properties");
	    props.save(fileout,"Turquaz Properties File");
		
		
	  if(page4.getButtonYes().getSelection()){
	
			EngDALConnection conn = new EngDALConnection(dbType,username,password,
														serverAddress+":"+serverPort,
														dbName);
			conn.connect();
			
			conn.createTables();
			msg.setMessage("Tables Succesfully Created");
			msg.open();
			
			
		}
		
		
	  
	  else{
			
		System.exit(-1);		
			
		
	  }
			
		
		return true;
	}
	 catch(Exception ex){
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		return false;
	 }	
	}
	/**
	 * @return Returns the page1.
	 */
	public EngUIDatabaseTypeWizardPage getPage1() {
		return page1;
	}
	/**
	 * @param page1 The page1 to set.
	 */
	public void setPage1(EngUIDatabaseTypeWizardPage page1) {
		this.page1 = page1;
	}
	/**
	 * @return Returns the page2.
	 */
	public EngUIDatabaseConnectionInfoWizardPage getPage2() {
		return page2;
	}
	/**
	 * @param page2 The page2 to set.
	 */
	public void setPage2(EngUIDatabaseConnectionInfoWizardPage page2) {
		this.page2 = page2;
	}
	/**
	 * @return Returns the page3.
	 */
	public EngUIDatabaseSelectionWizardPage getPage3() {
		return page3;
	}
	/**
	 * @param page3 The page3 to set.
	 */
	public void setPage3(EngUIDatabaseSelectionWizardPage page3) {
		this.page3 = page3;
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
	/**
	 * @return Returns the page4.
	 */
	public EngUICreateTablesWizardPage getPage4() {
		return page4;
	}
	/**
	 * @param page4 The page4 to set.
	 */
	public void setPage4(EngUICreateTablesWizardPage page4) {
		this.page4 = page4;
	}
}
