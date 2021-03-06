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
import java.util.HashMap;
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
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.bl.EngBLVersionValidate;
import com.turquaz.engine.dal.DatabaseThread;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.wizards.EngUIDatabaseConnectionWizard;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Composite;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EngUIEntryFrame extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lblUserName;
	private Text txtUserName;
	private CCombo comboLanguage;
	private CLabel lblLanguage;
	private Button checkRememberPassword;
	private Composite compEngUIMainFrame;
	private Button btnCancel;
	private Button btnOk;
	private Text txtPassword;
	private CLabel lblPassword;
	private Label lblSeperator;
	boolean guiReady = false;

	

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI(Display display)
	{
		Shell shell = new Shell(display);
		EngUIEntryFrame inst = new EngUIEntryFrame(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setText(EngLangCommonKeys.STR_APPLICATION_NAME); //$NON-NLS-1$
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		EngUICommon.centreWindow(shell);
		shell.open();
		
		
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public EngUIEntryFrame(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	
	}

	private void initGUI()
	{
		try
		{
					
			String database = EngConfiguration.getString("serverAddress"); //$NON-NLS-1$
			database = database.trim();
			if (database == null || database.equals("") || database.equals("localhost") || database.equals("127.0.0.1")) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			{
				DatabaseThread dbThread = new DatabaseThread();
				dbThread.start();
			}
			GridLayout thisLayout = new GridLayout();
			this.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent evt)
				{
					if (evt.character == SWT.CR)
					{
						btnOkMouseUp();
					}
				}
			});
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			thisLayout.marginHeight = 20;
			this.setSize(385, 202);
			{
				lblUserName = new CLabel(this, SWT.NONE);
				lblUserName.setText(EngLangCommonKeys.STR_USERNAME); //$NON-NLS-1$
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
				lblPassword.setText(EngLangCommonKeys.STR_PASSWORD); //$NON-NLS-1$
				GridData lblPasswordLData = new GridData();
				lblPasswordLData.widthHint = 81;
				lblPasswordLData.heightHint = 19;
				lblPassword.setLayoutData(lblPasswordLData);
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
				checkRememberPassword.setText(EngLangCommonKeys.STR_REMEMBER_PASSWORD); //$NON-NLS-1$
				GridData checkRememberPasswordLData = new GridData();
				checkRememberPasswordLData.horizontalSpan = 2;
				checkRememberPasswordLData.widthHint = 162;
				checkRememberPasswordLData.heightHint = 19;
				checkRememberPassword.setLayoutData(checkRememberPasswordLData);
			}
			{
				lblLanguage = new CLabel(this, SWT.NONE);
				lblLanguage.setText(EngLangCommonKeys.STR_LANGUAGE); //$NON-NLS-1$
				GridData lblLanguageLData = new GridData();
				lblLanguageLData.widthHint = 106;
				lblLanguageLData.heightHint = 19;
				lblLanguage.setLayoutData(lblLanguageLData);
			}
			{
				comboLanguage = new CCombo(this, SWT.NONE);
				comboLanguage.setEditable(false);
				comboLanguage.setBackground(SWTResourceManager.getColor(255, 255, 255));
				GridData comboLanguageLData = new GridData();
				comboLanguage.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						if (comboLanguage.getData(comboLanguage.getText()).equals(new Integer(1)))
						{
							Locale.setDefault(new Locale("tr", "TR")); //$NON-NLS-1$ //$NON-NLS-2$
							displayStrings();
						}
						else if (comboLanguage.getData(comboLanguage.getText()).equals(new Integer(2)))
						{
							Locale.setDefault(new Locale("en", "US")); //$NON-NLS-1$ //$NON-NLS-2$
							displayStrings();
						}
					}
				});
				comboLanguageLData.widthHint = 86;
				comboLanguageLData.heightHint = 16;
				comboLanguage.setLayoutData(comboLanguageLData);
			}
			{
				lblSeperator = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
				lblSeperator.setText(""); //$NON-NLS-1$
				GridData label1LData = new GridData();
				label1LData.horizontalSpan = 2;
				label1LData.horizontalAlignment = GridData.FILL;
				label1LData.grabExcessHorizontalSpace = true;
				label1LData.heightHint = 2;
				label1LData.grabExcessVerticalSpace = true;
				lblSeperator.setLayoutData(label1LData);
			}
			{
				compEngUIMainFrame = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				GridData composite1LData = new GridData();
				composite1LData.widthHint = 164;
				composite1LData.heightHint = 44;
				composite1LData.horizontalSpan = 2;
				composite1LData.horizontalAlignment = GridData.END;
				compEngUIMainFrame.setLayoutData(composite1LData);
				composite1Layout.makeColumnsEqualWidth = true;
				composite1Layout.numColumns = 2;
				compEngUIMainFrame.setLayout(composite1Layout);
				{
					btnOk = new Button(compEngUIMainFrame, SWT.PUSH | SWT.FLAT | SWT.CENTER);
				
					GridData btnOkLData = new GridData();
					btnOk.setImage(SWTResourceManager.getImage("icons/Ok24.gif")); //$NON-NLS-1$
					btnOk.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnOkMouseUp();
						}
					});
					btnOkLData.horizontalAlignment = GridData.END;
					btnOkLData.widthHint = 74;
					btnOkLData.heightHint = 37;
					btnOk.setLayoutData(btnOkLData);
				}
				{
					btnCancel = new Button(compEngUIMainFrame, SWT.PUSH | SWT.FLAT | SWT.CENTER);
					GridData btnCancelLData = new GridData();
					btnCancel.setSize(74, 37);
					btnCancel.setImage(SWTResourceManager.getImage("icons/Cancel24.gif")); //$NON-NLS-1$
					btnCancel.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							btnCancelMouseUp(evt);
						}
					});
					btnCancelLData.horizontalAlignment = GridData.END;
					btnCancelLData.widthHint = 74;
					btnCancelLData.heightHint = 37;
					btnCancel.setLayoutData(btnCancelLData);
				}
			}
			this.layout();
			preInitGui();
			postInitGui();
			
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e);
		}
	}

	// display the strings
	public void displayStrings()
	{
		checkRememberPassword.setText(EngLangCommonKeys.STR_REMEMBER_PASSWORD); //$NON-NLS-1$
		lblLanguage.setText(EngLangCommonKeys.STR_LANGUAGE); //$NON-NLS-1$
		lblPassword.setText(EngLangCommonKeys.STR_PASSWORD); //$NON-NLS-1$
		lblUserName.setText(EngLangCommonKeys.STR_USERNAME); //$NON-NLS-1$
	}

	public void btnCancelMouseUp(MouseEvent e)
	{
		this.getShell().dispose();
		System.exit(-1);
	}

	public void showSplashScreen()
	{
		/*
		 * Shell shell; Shell invisibleShell; Display display = getDisplay(); shell = new Shell(getShell(), SWT.ON_TOP); Label label = new
		 * Label(shell, SWT.NONE); label.setImage(SWTResourceManager.getImage("icons/splash.gif")); //$NON-NLS-1$
		 * label.addDisposeListener(new DisposeListener(){ public void widgetDisposed(DisposeEvent e){ if (((Label) e.widget).getImage() !=
		 * null) ((Label) e.widget).getImage().dispose(); } } ); FormLayout layout = new FormLayout(); shell.setLayout(layout); FormData
		 * labelData = new FormData(); labelData.right = new FormAttachment(100, 0); labelData.bottom = new FormAttachment(100, 0);
		 * label.setLayoutData(labelData); shell.pack(); shell.setText("Turquaz"); //$NON-NLS-1$ EngUICommon.centreWindow(shell);
		 * shell.open(); getDisplay().asyncExec(new Runnable() { public void run() { showMainFrame(); guiReady = true; } }); while
		 * (!guiReady) { if (!display.readAndDispatch()) display.sleep(); } display.dispose();
		 */
	}

	public void showMainFrame()
	{
		try
		{
			DatabaseThread thread = new DatabaseThread();
			thread.start();
			FileInputStream input = new FileInputStream("config/turquaz.properties"); //$NON-NLS-1$
			Properties props = new Properties();
			props.load(input);
			if (checkRememberPassword.getSelection())
			{
				String password = new String(org.eclipse.core.internal.preferences.Base64.encode(txtPassword.getText().getBytes()));
				props.put("username", txtUserName.getText()); //$NON-NLS-1$
				props.put("password", password); //$NON-NLS-1$
				props.put("remember_password", "true"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else
			{
				props.remove("username"); //$NON-NLS-1$
				props.remove("password"); //$NON-NLS-1$
				props.put("remember_password", "false"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			input.close();
			FileOutputStream output = new FileOutputStream("config/turquaz.properties"); //$NON-NLS-1$
			props.store(output, "Turquaz Configuration"); //$NON-NLS-1$
			System.setProperty("user", txtUserName.getText()); //$NON-NLS-1$
			if (((Integer) comboLanguage.getData(comboLanguage.getText())).intValue() == 1)
			{
				Locale.setDefault(new Locale("tr", "TR")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			else if (((Integer) comboLanguage.getData(comboLanguage.getText())).intValue() == 2)
			{
				Locale.setDefault(new Locale("en", "US")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
			validateDB();			
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
		this.getShell().dispose();
		
	}
	public void validateDB(){
		try{
		Boolean isVersionUpdated=(Boolean)EngTXCommon.doSelectTX(EngBLVersionValidate.class.getName(),"checkVersion",null);		 //$NON-NLS-1$
		if (!isVersionUpdated.booleanValue())
		{
			EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_DATABASE_WILL_BE_UPDATED); //$NON-NLS-1$
			Boolean successfull=(Boolean)EngTXCommon.doTransactionTX(EngBLVersionValidate.class.getName(),"validateVersion",null); //$NON-NLS-1$
			if (successfull.booleanValue())
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_DATABASE_UPDATED_SUCCESFULLY); //$NON-NLS-1$
			}
			else
			{
				EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_DATABASE_UPDATE_FAILED); //$NON-NLS-1$
				System.exit(1);
			}
		}
		}
		catch(Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	public void btnOkMouseUp()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.USER,txtUserName.getText());
			argMap.put(EngKeys.PASSWORD,txtPassword.getText());
			
			Boolean result = (Boolean)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"checkUserPass",argMap); //$NON-NLS-1$
			if (result.booleanValue())
			{
				showMainFrame();
			}
			else
			{
				msg.setMessage(EngLangCommonKeys.MSG_WRONG_USERNAME_OR_PASSWORD); //$NON-NLS-1$
				msg.open();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
	
		}
	}

	public void preInitGui()
	{
		Locale.setDefault(new Locale("tr", "TR")); //$NON-NLS-1$ //$NON-NLS-2$
		File config = new File("config/turquaz.properties"); //$NON-NLS-1$
		if (!config.exists())
		{
			EngUIDatabaseConnectionWizard wizard = new EngUIDatabaseConnectionWizard();
			WizardDialog dialog = new WizardDialog(this.getShell(), wizard);
			dialog.open();
			txtPassword.setText("admin"); //$NON-NLS-1$
			txtUserName.setText("admin"); //$NON-NLS-1$
			checkRememberPassword.setSelection(true);
		}
		EngConfiguration.refreshConfig();
	
	}

	public void postInitGui()
	{
		try
		{
			
			btnOk.setFocus();
			String username = EngConfiguration.getString("username"); //$NON-NLS-1$
			String password = EngConfiguration.getString("password"); //$NON-NLS-1$
			String rememberPassword = EngConfiguration.getString("remember_password"); //$NON-NLS-1$
			if (username != null && password != null)
			{
				txtPassword.setText(new String(Base64.decode(password.getBytes())));
				txtUserName.setText(username);
			}
			checkRememberPassword.setSelection(false);
			if (rememberPassword != null && rememberPassword.equals("true")) { //$NON-NLS-1$
				checkRememberPassword.setSelection(true);
			}
			comboLanguage.add("T\u00FCrk\u00E7e"); //$NON-NLS-1$
			comboLanguage.add("English"); //$NON-NLS-1$
			comboLanguage.setData("T\u00FCrk\u00E7e", new Integer(1)); //$NON-NLS-1$
			comboLanguage.setData("English", new Integer(2)); //$NON-NLS-1$
			comboLanguage.setText("T\u00FCrk\u00E7e"); //$NON-NLS-1$
		
			EngBLClient.getBaseCurrencyId();
			
            //checkRememberPassword.setVisible(false);
            
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}

	public Text getTxtPassword()
	{
		return txtPassword;
	}

	public void setTxtPassword(Text txtPassword)
	{
		this.txtPassword = txtPassword;
	}

	public Text getTxtUserName()
	{
		return txtUserName;
	}

	public void setTxtUserName(Text txtUserName)
	{
		this.txtUserName = txtUserName;
	}

	public void updateDBSchema()
	{
		try
		{
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex);
		}
	}
}