package com.turquaz.engine.ui;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Properties;

import org.eclipse.core.internal.preferences.Base64;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.EngDALSessionFactory;
import com.turquaz.engine.ui.wizards.EngUIDatabaseConnectionWizard;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
public class EngUIEntryFrame extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private CLabel lblUserName;
	private Text txtUserName;
	private Button checkRememberPassword;
	private Composite composite1;
	private Button btnCancel;
	private Button btnOk;
	private Text txtPassword;
	private CLabel lblPassword;
	private Label label1;
	private EngBLCommon blCommon = new EngBLCommon();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		EngUIEntryFrame inst = new EngUIEntryFrame(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setText("Turquaz");
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public EngUIEntryFrame(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			preInitGui();
			GridLayout thisLayout = new GridLayout();
			this.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if(evt.character == SWT.CR){
						btnOkMouseUp();
					}
				}
			});
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			thisLayout.marginHeight = 20;
			this.setSize(377, 143);
			{
				lblUserName = new CLabel(this, SWT.NONE);
				lblUserName.setText("Username");
			}
			{
				txtUserName = new Text(this, SWT.NONE);
				GridData txtUserNameLData = new GridData();
				txtUserNameLData.heightHint = 16;
				txtUserNameLData.grabExcessHorizontalSpace = true;
				txtUserNameLData.horizontalAlignment = GridData.FILL;

				txtUserName.setLayoutData(txtUserNameLData);
			}
			{
				lblPassword = new CLabel(this, SWT.NONE);
				lblPassword.setText("Password");
			}
			{
				txtPassword = new Text(this, SWT.PASSWORD);
				GridData txtPasswordLData = new GridData();
				txtPassword.setSize(305, 16);
				txtPasswordLData.heightHint = 16;
				txtPasswordLData.horizontalAlignment = GridData.FILL;
				txtPassword.setLayoutData(txtPasswordLData);
			}
			{
				checkRememberPassword = new Button(this, SWT.CHECK | SWT.LEFT);
				checkRememberPassword.setText("Remember Password");
				GridData checkRememberPasswordLData = new GridData();
				checkRememberPasswordLData.horizontalSpan = 2;
				checkRememberPasswordLData.widthHint = 162;
				checkRememberPasswordLData.heightHint = 19;
				checkRememberPassword.setLayoutData(checkRememberPasswordLData);
			}
			{
				label1 = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
				label1.setText("label1");
				GridData label1LData = new GridData();
				label1LData.horizontalSpan = 2;
				label1LData.horizontalAlignment = GridData.FILL;
				label1LData.grabExcessHorizontalSpace = true;
				label1LData.heightHint = 2;
				label1LData.grabExcessVerticalSpace = true;
				label1.setLayoutData(label1LData);
			}
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.widthHint = 164;
				composite1LData.heightHint = 40;
				composite1LData.horizontalSpan = 2;
				composite1LData.horizontalAlignment = GridData.END;
				composite1.setLayoutData(composite1LData);
				composite1Layout.makeColumnsEqualWidth = true;
				composite1Layout.numColumns = 2;
				composite1.setLayout(composite1Layout);
				{
					btnCancel = new Button(composite1, SWT.PUSH | SWT.FLAT | SWT.CENTER);
					btnCancel.setText("Cancel");
					GridData btnCancelLData = new GridData();
					btnCancel.setImage(SWTResourceManager.getImage("icons/Cancel24.gif"));
					btnCancel.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnCancelMouseUp(evt);

						}
					});
					btnCancel.setSize(70, 24);
					btnCancelLData.horizontalAlignment = GridData.END;
					btnCancelLData.widthHint = 70;
					btnCancelLData.heightHint = 24;
					btnCancel.setLayoutData(btnCancelLData);
				}
				{
					btnOk = new Button(composite1, SWT.PUSH | SWT.FLAT | SWT.CENTER);
					btnOk.setText("Ok");
					GridData btnOkLData = new GridData();
					btnOk.setImage(SWTResourceManager.getImage("icons/Ok24.gif"));
					btnOk.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							btnOkMouseUp();
						}
					});
					btnOkLData.horizontalAlignment = GridData.END;
					btnOkLData.widthHint = 70;
					btnOkLData.heightHint = 24;
					btnOk.setLayoutData(btnOkLData);
				}
			}
			this.layout();
			postInitGui();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void btnCancelMouseUp(MouseEvent e){
		
		this.getShell().dispose();
		
	}
	public void btnOkMouseUp(){
		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
		try{
		if(blCommon.checkUserPass(txtUserName.getText(),txtPassword.getText())){
			
			try{
				FileInputStream input = new FileInputStream("config/turquaz.properties");
			    Properties props = new Properties();
			    props.load(input);
			    
			    if(checkRememberPassword.getSelection()){
			    	 String password = new String(org.eclipse.core.internal.preferences.Base64.encode(txtPassword.getText().getBytes()));
					 props.put("username",txtUserName.getText());
					 props.put("password",password);
					 props.put("remember_password","true");
			    }
			    else{
			    	props.remove("username");
			    	props.remove("password");
			    	props.put("remember_password","false");
			    }
			   
			    input.close();
			    
			    FileOutputStream output = new FileOutputStream("config/turquaz.properties");
			    props.save(output,"Turquaz Configuration");
			    
			    System.setProperty("user",txtUserName.getText());
			    System.setProperty("company","0");
			    
			    EngDALSessionFactory.init();
			    
				}
				catch(Exception ex){
					ex.printStackTrace();
				}
			
			
			this.getShell().dispose();
			
			EngUIMainFrame.showGUI2();
			
			
		}
		else {
		msg.setMessage("Wrong username or password");
		msg.open();
		}
		}
		catch(Exception ex){
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}
	public void preInitGui(){
			
		Locale.setDefault(new Locale("tr","TR"));
		
		File config = new File("config/turquaz.properties");
		if(!config.exists()){
			EngUIDatabaseConnectionWizard wizard = new EngUIDatabaseConnectionWizard();
			WizardDialog dialog = new WizardDialog(this.getShell(),wizard);
			dialog.open();	
			txtPassword.setText("admin");
			txtUserName.setText("admin");
		}
		
	
		EngDALSessionFactory.init();
		
		
	}
	
	public void postInitGui(){
    btnOk.setFocus();
	String username = EngConfiguration.getString("username");
	String password = EngConfiguration.getString("password");
	String rememberPassword = EngConfiguration.getString("remember_password");
	if(username!=null&&password!=null){
	txtPassword.setText(new String(Base64.decode(password.getBytes())));
	txtUserName.setText(username);	
		
	}
	checkRememberPassword.setSelection(false);
	if(rememberPassword!=null&&rememberPassword.equals("true")){
		checkRememberPassword.setSelection(true);
	}
		
	}
	public Text getTxtPassword() {
		return txtPassword;
	}
	public void setTxtPassword(Text txtPassword) {
		this.txtPassword = txtPassword;
	}
	public Text getTxtUserName() {
		return txtUserName;
	}
	public void setTxtUserName(Text txtUserName) {
		this.txtUserName = txtUserName;
	}
}
