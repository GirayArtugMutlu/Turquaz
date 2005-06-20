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
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLGroupAdd;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

public class AdmUIGroupAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblAdmGroupName;
	private Text txtAdmGroupName;
	private Text txtAdmGroupDesc;
	private CLabel lblAdmGroupDesc;

	public AdmUIGroupAdd(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			thisLayout.numColumns = 2;
			thisLayout.verticalSpacing = 20;
			thisLayout.marginHeight = 20;
			this.setLayout(thisLayout);
			this.setSize(438, 170);
			{
				lblAdmGroupName = new CLabel(this, SWT.NONE);
				lblAdmGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME); //$NON-NLS-1$
				GridData lblAdmGroupNameLData = new GridData();
				lblAdmGroupNameLData.widthHint = 65;
				lblAdmGroupNameLData.heightHint = 19;
				lblAdmGroupName.setLayoutData(lblAdmGroupNameLData);
			}
			{
				txtAdmGroupName = new Text(this, SWT.NONE);
				GridData txtAdmGroupNameLData = new GridData();
				txtAdmGroupNameLData.heightHint = 18;
				txtAdmGroupNameLData.horizontalAlignment = GridData.FILL;
				txtAdmGroupName.setLayoutData(txtAdmGroupNameLData);
			}
			{
				lblAdmGroupDesc = new CLabel(this, SWT.NONE);
				lblAdmGroupDesc.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
				GridData lblAdmGroupDescLData = new GridData();
				lblAdmGroupDescLData.verticalAlignment = GridData.BEGINNING;
				lblAdmGroupDescLData.widthHint = 113;
				lblAdmGroupDescLData.heightHint = 20;
				lblAdmGroupDesc.setLayoutData(lblAdmGroupDescLData);
			}
			{
				txtAdmGroupDesc = new Text(this, SWT.MULTI | SWT.V_SCROLL);
				GridData txtAdmGroupDescLData = new GridData();
				txtAdmGroupDesc.addVerifyListener(new VerifyListener()
				{
					public void verifyText(VerifyEvent evt)
					{
						if (evt.keyCode == SWT.TAB)
						{
							txtAdmGroupName.setFocus();
							evt.doit = false;
						}
					}
				});
				txtAdmGroupDescLData.widthHint = 239;
				txtAdmGroupDescLData.heightHint = 55;
				txtAdmGroupDesc.setLayoutData(txtAdmGroupDescLData);
			}
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (txtAdmGroupName.getText().trim().length() == 0)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_FILL_GROUP_NAME);
			msg.open();
			txtAdmGroupName.setFocus();
			return false;
		}
		return true;
	}

	public void save()
	{
		
		if (verifyFields())
		{
			try
			{
				HashMap argMap=new HashMap();
				argMap.put(AdmKeys.ADM_GROUP_NAME,txtAdmGroupName.getText().trim());
				argMap.put(AdmKeys.ADM_GROUP_DESCRIPTION,txtAdmGroupDesc.getText().trim());
				
				EngTXCommon.doTransactionTX(AdmBLGroupAdd.class.getName(),"saveGroup",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
                
				newForm();
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}

	public void search()
	{
	}

	public void newForm()
	{
		AdmUIGroupAdd curCard = new AdmUIGroupAdd(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void delete()
	{
	}
	/**
	 * @return Returns the txtAdmGroupDesc.
	 */
	public Text getTxtAdmGroupDesc()
	{
		return txtAdmGroupDesc;
	}
	/**
	 * @return Returns the txtAdmGroupName.
	 */
	public Text getTxtAdmGroupName()
	{
		return txtAdmGroupName;
	}
}