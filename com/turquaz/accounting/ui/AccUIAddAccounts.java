package com.turquaz.accounting.ui;


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



import org.eclipse.jface.contentassist.SubjectControlContentAssistant;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.VerifyKeyListener;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountAdd;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.VerifyEvent;

import com.turquaz.engine.bl.EngBLAccountingAccounts;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistProcessors;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;



import com.cloudgarden.resource.SWTResourceManager;
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
public class AccUIAddAccounts extends  Composite implements SecureComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}


	/**
	 * @return Returns the txtAccAccountCode.
	 */
	public Text getTxtAccAccountCode() {
		return txtAccAccountCode;
	}
	/**
	 * @return Returns the txtAccAcountName.
	 */
	public Text getTxtAccAcountName() {
		return txtAccAcountName;
	}
	/**
	 * @return Returns the txtParentAccount.
	 */
	public Text getTxtParentAccount() {
		return txtParentAccount;
	}
	private AccBLAccountAdd blAccountAdd = new AccBLAccountAdd();
	private CLabel cLabel1;
	private Text txtAccAcountName;
	private Text txtParentAccount;
	private CLabel cLabel2;
	private Label label1;
	private Text txtAccAccountCode;
	public AccUIAddAccounts(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();

			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
	
			this.setSize(413, 176);
            {
                cLabel2 = new CLabel(this, SWT.NONE);
                GridData cLabel2LData = new GridData();
                cLabel2.setText(Messages.getString("AccUIAddAccounts.2"));
                cLabel2.setLayoutData(cLabel2LData);
            }
            {
                txtParentAccount = new Text(this, SWT.NONE);
                GridData txtParentAccountLData = new GridData();
                txtParentAccount.addModifyListener(new ModifyListener() {
                    public void modifyText(ModifyEvent evt) {
                        try {
                            txtParentAccount.setData(EngBLAccountingAccounts
                                .getAccount(txtParentAccount.getText().trim()));
                            
                            
                            if(txtParentAccount.getData()!=null){
                             txtAccAccountCode.setText(txtParentAccount.getText().trim()+".");
                                                   
                            }
                            else{
                                txtAccAccountCode.setText("");
                            }
                            
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }

                    }
                });
                txtParentAccountLData.widthHint = 252;
                txtParentAccountLData.heightHint = 22;
                txtParentAccount.setLayoutData(txtParentAccountLData);
                txtParentAccount.setEnabled(true);
            }
			{
				cLabel1 = new CLabel(this, SWT.NONE);
				cLabel1.setSize(new org.eclipse.swt.graphics.Point(83, 17));
				GridData cLabel1LData = new GridData();
				cLabel1.setText(Messages.getString("AccUIAddAccounts.0"));
				cLabel1LData.widthHint = 83;
				cLabel1LData.heightHint = 17;
				cLabel1.setLayoutData(cLabel1LData);
			}
			{
				txtAccAccountCode = new Text(this, SWT.NONE);
				GridData txtAccAccountCodeLData = new GridData();
				
				txtAccAccountCodeLData.widthHint = 250;
				txtAccAccountCodeLData.heightHint = 20;
				txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			}
			{
				label1 = new Label(this, SWT.NONE);
				label1.setSize(new org.eclipse.swt.graphics.Point(91, 18));
				GridData label1LData = new GridData();
				label1.setText(Messages.getString("AccUIAddAccounts.1"));
				label1LData.widthHint = 91;
				label1LData.heightHint = 18;
				label1.setLayoutData(label1LData);
			}
			{
				txtAccAcountName = new Text(this, SWT.NONE);
				GridData txtAccAcountNameLData = new GridData();
				txtAccAcountNameLData.widthHint = 251;
				txtAccAcountNameLData.heightHint = 19;
				txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			}

			final Color txtAccAccountCodebackground = new Color(Display.getDefault(),255,255,255);

			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 20;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					txtAccAccountCodebackground.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	 TextContentAssistSubjectAdapter adapter = new TextContentAssistSubjectAdapter(txtParentAccount);
	    
	 final TurquazContentAssistant asistant= new TurquazContentAssistant(adapter,0);
	   
	public void postInitGUI(){
	   
	     adapter.appendVerifyKeyListener(
	             new VerifyKeyListener() {
	                 public void verifyKey(VerifyEvent event) {

	                 // Check for Ctrl+Spacebar
	                 if (event.stateMask == SWT.CTRL && event.character == ' ') {
	             
	                  asistant.showPossibleCompletions();    
	                   event.doit = false;

	                 }
	              }
	           });
	    
	    
	}
	
	
	public boolean verifyFields(){
	
	MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
   
    boolean valid = false;
   
	
    if(txtAccAccountCode.getText().trim().equals("")){ //$NON-NLS-1$
    msg.setMessage(Messages.getString("AccUIAddAccounts.4")); //$NON-NLS-1$
    msg.open();	
    this.txtAccAccountCode.setFocus();
    return false;
    }
    
	else if(txtParentAccount.getData()==null){
	  msg.setMessage(Messages.getString("AccUIAddAccounts.5")); //$NON-NLS-1$
     msg.open();	
     this.txtParentAccount.setFocus();
    return false;
	}

	
	return true;
	
	}
	public void clearFields(){
	txtAccAccountCode.setText(""); //$NON-NLS-1$
	txtAccAcountName.setText(""); //$NON-NLS-1$
	
	txtParentAccount.setFocus();
	txtParentAccount.setSelection(txtParentAccount.getText().length());
	}
	
	
	public void save(){
		try{
			
	if(verifyFields()){
	String accountName = txtAccAcountName.getText().trim();
	String accountCode = txtAccAccountCode.getText().trim();
  
		
    blAccountAdd.saveAccount(accountName,accountCode,txtParentAccount.getData());	
    MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
    msg.setMessage(Messages.getString("AccUIAddAccounts.8")); //$NON-NLS-1$
    msg.open();
    
   asistant.refreshContentAssistant(0);
    
    clearFields();
	}
	}
	catch(Exception ex){
		ex.printStackTrace();
		 MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		 msg.setMessage(ex.getMessage());
		 msg.open();
		
	}
	
		
	}
	public void search(){
	}
	public void delete(){
	
	}
	public void newForm(){
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			AccUIAddAccounts inst = new AccUIAddAccounts(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,435,204);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void txtParentAccountMouseUp(MouseEvent evt){
	
	
	Object[] obj = new AccUIStaticAccountsDialog(this.getShell(),SWT.NULL).showDialog(""); //$NON-NLS-1$
		if (obj[0] != null) {
			txtParentAccount.setData(obj[1]);
		
		}
	
	
	}
}
