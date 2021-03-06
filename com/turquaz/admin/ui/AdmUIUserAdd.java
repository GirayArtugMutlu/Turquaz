package com.turquaz.admin.ui;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.admin.bl.AdmBLUserAdd;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.component.RegisterGroupComposite;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class AdmUIUserAdd extends Composite implements SecureComposite
{
	private CLabel lblUsername;
	private Text txtUsername;
	private Text txtPassword;
	private Text txtRePassword;
	private Text txtDescription;
	private RegisterGroupComposite registeredGroups;
	private CLabel lblGroups;
	private CLabel lblDescription;
	private Text txtRealName;
	private CLabel lblRealName;
	private CLabel lblReTypePassword;
	private CLabel lblPassWord;

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUIUserAdd inst = new AdmUIUserAdd(shell, SWT.NULL);
		Point size = inst.getSize();
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
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AdmUIUserAdd(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(452, 320);
			{
				lblUsername = new CLabel(this, SWT.NONE);
				GridData lblUsernameLData = new GridData();
				lblUsername.setText(AdmLangKeys.STR_USERNAME); //$NON-NLS-1$
				lblUsernameLData.widthHint = 104;
				lblUsernameLData.heightHint = 20;
				lblUsername.setLayoutData(lblUsernameLData);
			}
			{
				txtUsername = new Text(this, SWT.NONE);
				GridData txtUsernameLData = new GridData();
				txtUsernameLData.heightHint = 17;
				txtUsernameLData.widthHint = 190;
				txtUsername.setLayoutData(txtUsernameLData);
			}
			{
				lblPassWord = new CLabel(this, SWT.NONE);
				lblPassWord.setText(AdmLangKeys.STR_PASSWORD); //$NON-NLS-1$
			}
			{
				txtPassword = new Text(this, SWT.PASSWORD);
				GridData txtPasswordLData = new GridData();
				txtPasswordLData.heightHint = 18;
				txtPasswordLData.horizontalAlignment = GridData.FILL;
				txtPassword.setLayoutData(txtPasswordLData);
			}
			{
				lblReTypePassword = new CLabel(this, SWT.NONE);
				lblReTypePassword.setText(AdmLangKeys.STR_RE_PASSWORD); //$NON-NLS-1$
				GridData lblReTypePasswordLData = new GridData();
				lblReTypePasswordLData.widthHint = 114;
				lblReTypePasswordLData.heightHint = 19;
				lblReTypePassword.setLayoutData(lblReTypePasswordLData);
			}
			{
				txtRePassword = new Text(this, SWT.PASSWORD);
				GridData txtRePasswordLData = new GridData();
				txtRePasswordLData.heightHint = 18;
				txtRePasswordLData.horizontalAlignment = GridData.FILL;
				txtRePassword.setLayoutData(txtRePasswordLData);
			}
			{
				lblRealName = new CLabel(this, SWT.NONE);
				lblRealName.setText(AdmLangKeys.STR_REAL_NAME); //$NON-NLS-1$
				GridData lblRealNameLData = new GridData();
				lblRealNameLData.widthHint = 90;
				lblRealNameLData.heightHint = 17;
				lblRealName.setLayoutData(lblRealNameLData);
			}
			{
				txtRealName = new Text(this, SWT.NONE);
				GridData txtRealNameLData = new GridData();
				txtRealNameLData.horizontalAlignment = GridData.FILL;
				txtRealNameLData.heightHint = 17;
				txtRealName.setLayoutData(txtRealNameLData);
			}
			{
				lblDescription = new CLabel(this, SWT.NONE);
				lblDescription.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
				GridData lblDescriptionLData = new GridData();
				lblDescriptionLData.widthHint = 107;
				lblDescriptionLData.heightHint = 17;
				lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
				lblDescription.setLayoutData(lblDescriptionLData);
			}
			{
				txtDescription = new Text(this, SWT.MULTI | SWT.V_SCROLL);
				GridData txtDescriptionLData = new GridData();
				txtDescription.addVerifyListener(new VerifyListener()
				{
					public void verifyText(VerifyEvent evt)
					{
						if (evt.keyCode == SWT.TAB)
						{
							registeredGroups.setFocus();
							evt.doit = false;
						}
					}
				});
				txtDescriptionLData.horizontalAlignment = GridData.FILL;
				txtDescriptionLData.heightHint = 59;
				txtDescription.setLayoutData(txtDescriptionLData);
			}
			{
				lblGroups = new CLabel(this, SWT.NONE);
				lblGroups.setText(EngLangCommonKeys.STR_GROUPS); //$NON-NLS-1$
				GridData lblGroupsLData = new GridData();
				lblGroupsLData.widthHint = 105;
				lblGroupsLData.heightHint = 34;
				lblGroupsLData.verticalAlignment = GridData.BEGINNING;
				lblGroups.setLayoutData(lblGroupsLData);
			}
			{
				registeredGroups = new RegisterGroupComposite(this, SWT.NONE);
				GridData tableAllGroupsLData = new GridData();
				tableAllGroupsLData.widthHint = 139;
				tableAllGroupsLData.heightHint = 92;
				GridData registerGroupComposite1LData = new GridData();
				registerGroupComposite1LData.widthHint = 191;
				registerGroupComposite1LData.heightHint = 127;
				registeredGroups.setLayoutData(registerGroupComposite1LData);
				registeredGroups.getTableAllGroups().setLayoutData(tableAllGroupsLData);
				postInitGUI();
			}
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGUI()
	{
		try
		{
			            
			HashBag groupBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroups.class.getName(),"getGroups",null);
		
            HashMap groupMap = (HashMap)groupBag.get(AdmKeys.ADM_GROUP);
            
			registeredGroups.fillTableAllGroups(groupMap);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (txtUsername.getText().trim().length() == 0)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_ENTER_USERNAME); //$NON-NLS-1$
			msg.open();
			txtUsername.setFocus();
			return false;
		}
		else if (!txtPassword.getText().equals(txtRePassword.getText()))
		{
			msg.setMessage(AdmLangKeys.MSG_PASSWORD_MUST_BE_SAME); //$NON-NLS-1$
			msg.open();
			txtPassword.setText(""); //$NON-NLS-1$
			txtRePassword.setText(""); //$NON-NLS-1$
			txtPassword.setFocus();
			return false;
		}
		return true;
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_USERNAME,txtUsername.getText().trim());
				argMap.put(AdmKeys.ADM_PASSWORD,txtPassword.getText().trim());
				argMap.put(AdmKeys.ADM_REALNAME,txtRealName.getText().trim());
				argMap.put(EngKeys.DESCRIPTION,txtDescription.getText().trim());
				argMap.put(AdmKeys.ADM_USER_GROUPS,getUserGroups());
				
				EngTXCommon.doTransactionTX(AdmBLUserAdd.class.getName(),"saveUser",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
	
	public List getUserGroups()
	{
		List userGroups=new ArrayList();
		TableItem items[] = registeredGroups.getTableAllGroups().getItems();
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getChecked())
			{
				userGroups.add(items[i].getData());
			}
		}
		return userGroups;
	}

	public void search()
	{
	}

	public void newForm()
	{
		AdmUIUserAdd curCard = new AdmUIUserAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void delete()
	{
	}

	/**
	 * @return Returns the registeredGroups.
	 */
	public RegisterGroupComposite getRegisteredGroups()
	{
		return registeredGroups;
	}

	/**
	 * @return Returns the txtDescription.
	 */
	public Text getTxtDescription()
	{
		return txtDescription;
	}

	/**
	 * @return Returns the txtPassword.
	 */
	public Text getTxtPassword()
	{
		return txtPassword;
	}

	/**
	 * @return Returns the txtRealName.
	 */
	public Text getTxtRealName()
	{
		return txtRealName;
	}

	/**
	 * @return Returns the txtRePassword.
	 */
	public Text getTxtRePassword()
	{
		return txtRePassword;
	}


	/**
	 * @return Returns the txtUsername.
	 */
	public Text getTxtUsername()
	{
		return txtUsername;
	}

}