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
 import org.eclipse.swt.custom.CTabFolder;
 import org.eclipse.swt.custom.CTabItem;
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
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
public class AccUIAddMainAccount extends Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	/**
	 * @return Returns the txtAccAccountCode.
	 */
	public Text getTxtAccAccountCode()
	{
		return txtAccAccountCode;
	}

	/**
	 * @return Returns the txtAccAcountName.
	 */
	public Text getTxtAccAcountName()
	{
		return txtAccAcountName;
	}
	/**
	 * @return Returns the txtParentAccount.
	 */
	private CLabel lblAccountCode;
	private Text txtAccAcountName;
	private Composite compAcc;
	private CTabItem cTabItem1;
	private CTabFolder TabFolderAccountInfo;
	private Text txtAccountGroup;
	private CLabel lblAccountGroup;
	private Text txtAccountClass;
	private CLabel lblAccountClass;
	private CLabel lblAccountName;
	private Text txtAccAccountCode;

	public AccUIAddMainAccount(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			this.setSize(478, 162);
			//START >>  TabFolderAccountInfo
			TabFolderAccountInfo = new CTabFolder(this, SWT.NONE);
			//START >>  cTabItem1
			cTabItem1 = new CTabItem(TabFolderAccountInfo, SWT.NONE);
			cTabItem1.setText("Hesap Bilgileri");
			//START >>  compAcc
			compAcc = new Composite(TabFolderAccountInfo, SWT.NONE);
			GridLayout compAccLayout = new GridLayout();
			compAccLayout.numColumns = 2;
			compAcc.setLayout(compAccLayout);
			cTabItem1.setControl(compAcc);
			{
				lblAccountCode = new CLabel(compAcc, SWT.NONE);
				lblAccountCode.setSize(new org.eclipse.swt.graphics.Point(83, 17));
				GridData cLabel1LData = new GridData();
				lblAccountCode.setText(AccLangKeys.STR_ACCOUNT_CODE);
				cLabel1LData.widthHint = 83;
				cLabel1LData.heightHint = 17;
				lblAccountCode.setLayoutData(cLabel1LData);
			}
			{
				txtAccAccountCode = new Text(compAcc, SWT.NONE);
				GridData txtAccAccountCodeLData = new GridData();
				txtAccAccountCodeLData.widthHint = 200;
				txtAccAccountCodeLData.heightHint = 17;
				txtAccAccountCode.setLayoutData(txtAccAccountCodeLData);
			}
			//START >> lblAccountName
			lblAccountName = new CLabel(compAcc, SWT.NONE);
			lblAccountName.setText(AccLangKeys.STR_ACCOUNT_NAME);
			//END << lblAccountName
			{
				txtAccAcountName = new Text(compAcc, SWT.NONE);
				GridData txtAccAcountNameLData = new GridData();
				txtAccAcountNameLData.widthHint = 200;
				txtAccAcountNameLData.heightHint = 17;
				txtAccAcountName.setLayoutData(txtAccAcountNameLData);
			}
			//START >> lblAccountClass
			lblAccountClass = new CLabel(compAcc, SWT.NONE);
			lblAccountClass.setText(AccLangKeys.STR_ACCOUNT_CLASS);
			//END << lblAccountClass
			//START >> txtAccountClass
			txtAccountClass = new Text(compAcc, SWT.NONE);
			GridData txtAccountClassLData = new GridData();
			txtAccountClassLData.widthHint = 200;
			txtAccountClassLData.heightHint = 17;
			txtAccountClass.setLayoutData(txtAccountClassLData);
			//END << txtAccountClass
			//START >> lblAccountGroup
			lblAccountGroup = new CLabel(compAcc, SWT.NONE);
			lblAccountGroup.setText(AccLangKeys.STR_ACCOUNT_GROUP);
			//END << lblAccountGroup
			//START >> txtAccountGroup
			txtAccountGroup = new Text(compAcc, SWT.NONE);
			GridData txtAccountGroupLData = new GridData();
			txtAccountGroupLData.widthHint = 200;
			txtAccountGroupLData.heightHint = 17;
			txtAccountGroup.setLayoutData(txtAccountGroupLData);
			//END << txtAccountGroup
			//END <<  compAcc
			TabFolderAccountInfo.setSelection(0);
			GridData TabFolderAccountInfoLData = new GridData();
			TabFolderAccountInfoLData.grabExcessHorizontalSpace = true;
			TabFolderAccountInfoLData.grabExcessVerticalSpace = true;
			TabFolderAccountInfoLData.horizontalAlignment = GridData.FILL;
			TabFolderAccountInfoLData.verticalAlignment = GridData.FILL;
			TabFolderAccountInfo.setLayoutData(TabFolderAccountInfoLData);
			//END <<  cTabItem1
			//END <<  TabFolderAccountInfo
			final Color txtAccAccountCodebackground = new Color(Display.getDefault(), 255, 255, 255);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 20;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
					txtAccAccountCodebackground.dispose();
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}
	/** Add your post-init code in here */
	TextContentAssistSubjectAdapter adapter;
	TurquazContentAssistant asistant;

	public void postInitGUI()
	{
	}

	public boolean verifyFields(boolean update, TurqAccountingAccount toUpdate)
	{
		return true;
	}

	public void clearFields()
	{
		txtAccAccountCode.setText(""); //$NON-NLS-1$
		txtAccAcountName.setText(""); //$NON-NLS-1$
	}

	public void save()
	{
	}

	public void search()
	{
	}

	public void delete()
	{
	}

	public void newForm()
	{
		clearFields();
	}



	/** Auto-generated event handler method */
	protected void txtParentAccountMouseUp(MouseEvent evt)
	{
	}
}