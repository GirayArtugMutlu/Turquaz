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
* @author  Cem Dayanik
* @version  $Id$
*/





import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.custom.CLabel;

import org.eclipse.swt.SWT;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLAccountUpdate;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.ui.component.SecureComposite;
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
public class AccUIAddMainAccount extends  Composite implements SecureComposite{

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

	private AccBLAccountAdd blAccountAdd = new AccBLAccountAdd();
	private AccBLAccountUpdate blAccountUpdate=new AccBLAccountUpdate();
	private CLabel cLabel1;
	private Text txtAccAcountName;
	private Text txtAccountGroup;
	private CLabel lblAccountGroup;
	private Text txtAccountClass;
	private CLabel lblAccountClass;
	private CLabel lblAccountName;
	private Text txtAccAccountCode;
	public AccUIAddMainAccount(Composite parent, int style) {
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
	
			this.setSize(395, 168);
			{
				cLabel1 = new CLabel(this, SWT.NONE);
				cLabel1.setSize(new org.eclipse.swt.graphics.Point(83, 17));
				GridData cLabel1LData = new GridData();
				cLabel1.setText(Messages.getString("AccUIAddAccounts.0")); //$NON-NLS-1$
				cLabel1LData.widthHint = 83;
				cLabel1LData.heightHint = 17;
				cLabel1.setLayoutData(cLabel1LData);
			}
			{
				txtAccAccountCode = new Text(this, SWT.NONE);
				GridData txtAccAccountCodeLData = new GridData();
				
				txtAccAccountCodeLData.widthHint = 200;
				txtAccAccountCodeLData.heightHint = 17;
				txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			}
			//START >>  lblAccountName
			lblAccountName = new CLabel(this, SWT.NONE);
			lblAccountName.setText("Hesap Ad\u0131");
			//END <<  lblAccountName
			{
				txtAccAcountName = new Text(this, SWT.NONE);
				GridData txtAccAcountNameLData = new GridData();
				txtAccAcountNameLData.widthHint = 200;
				txtAccAcountNameLData.heightHint = 17;
				txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			}
			//START >>  lblAccountClass
			lblAccountClass = new CLabel(this, SWT.NONE);
			lblAccountClass.setText("Hesap S\u0131n\u0131f\u0131");
			//END <<  lblAccountClass
			//START >>  txtAccountClass
			txtAccountClass = new Text(this, SWT.NONE);
			GridData txtAccountClassLData = new GridData();
			txtAccountClassLData.widthHint = 200;
			txtAccountClassLData.heightHint = 17;
			txtAccountClass.setLayoutData(txtAccountClassLData);
			//END <<  txtAccountClass
			//START >>  lblAccountGroup
			lblAccountGroup = new CLabel(this, SWT.NONE);
			lblAccountGroup.setText("Hesap Grubu");
			//END <<  lblAccountGroup
			//START >>  txtAccountGroup
			txtAccountGroup = new Text(this, SWT.NONE);
			GridData txtAccountGroupLData = new GridData();
			txtAccountGroupLData.widthHint = 200;
			txtAccountGroupLData.heightHint = 17;
			txtAccountGroup.setLayoutData(txtAccountGroupLData);
			//END <<  txtAccountGroup

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
	TextContentAssistSubjectAdapter adapter;
	TurquazContentAssistant asistant;
	public void postInitGUI(){
	    
	    
	    
	    
	}
	
	
	public boolean verifyFields(boolean update, TurqAccountingAccount toUpdate){
		return true;
	
	}
	public void clearFields(){
	txtAccAccountCode.setText(""); //$NON-NLS-1$
	txtAccAcountName.setText(""); //$NON-NLS-1$
	
	}
	
	
	public void save(){

		}

	public void search(){
	}
	public void delete(){
	
	}
	public void newForm(){
	    clearFields();	    
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
	
	
	
	}
}