package com.turquaz.inventory.ui;

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
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.SWT;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLWarehouseAdd;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;


public class InvUIWarehouseAdd extends Composite implements SecureComposite
{
	private Text txtWarehouseDescription;
	private Text txtWarehouseCode;
	private CLabel lblWarehouseCode;
	private CLabel lblDescription;
	private Text txtTelephone;
	private CLabel lblWarehouseTelephone;

	/**
	 * @return Returns the txtTelephone.
	 */
	public Text getTxtTelephone()
	{
		return txtTelephone;
	}

	/**
	 * @return Returns the txtWarehouseAdres.
	 */
	public Text getTxtWarehouseAdres()
	{
		return txtWarehouseAdres;
	}

	/**
	 * @return Returns the txtWarehouseCity.
	 */
	public Text getTxtWarehouseCity()
	{
		return txtWarehouseCity;
	}

	/**
	 * @return Returns the txtWarehouseDescription.
	 */
	public Text getTxtWarehouseDescription()
	{
		return txtWarehouseDescription;
	}

	/**
	 * @return Returns the txtWarehouseName.
	 */
	public Text getTxtWarehouseName()
	{
		return txtWarehouseName;
	}
	private Text txtWarehouseAdres;
	private CLabel lblWarehouseAdres;
	private Text txtWarehouseCity;
	private CLabel lblWareHouseCity;
	private Text txtWarehouseName;
	private CLabel lblWarehouseName;

	public InvUIWarehouseAdd(Composite parent, int style)
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
			{
				lblWarehouseCode = new CLabel(this, SWT.NONE);
				lblWarehouseCode.setText(InvLangKeys.STR_WAREHOUSE_CODE);
			}
			{
				txtWarehouseCode = new Text(this, SWT.NONE);
				txtWarehouseCode.setTextLimit(50);
				GridData txtWarehouseCodeLData = new GridData();
				txtWarehouseCodeLData.heightHint = 18;
				txtWarehouseCodeLData.horizontalAlignment = GridData.FILL;
				txtWarehouseCode.setLayoutData(txtWarehouseCodeLData);
			}
			lblWarehouseName = new CLabel(this, SWT.NULL);
			txtWarehouseName = new Text(this, SWT.NULL);
			lblWarehouseAdres = new CLabel(this, SWT.NULL);

			txtWarehouseAdres = new Text(this, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL);
			GridData txtWarehouseAdresLData = new GridData();
			txtWarehouseAdresLData.widthHint = 321;
			txtWarehouseAdresLData.heightHint = 62;
			txtWarehouseAdres.addVerifyListener(new VerifyListener() {
				public void verifyText(VerifyEvent evt) {
					if (evt.keyCode == SWT.TAB) {
						txtWarehouseCity.setFocus();
						evt.doit = false;
					}
				}
			});
			txtWarehouseAdres.setLayoutData(txtWarehouseAdresLData);
			txtWarehouseAdres.setTextLimit(250);

			lblWareHouseCity = new CLabel(this, SWT.NULL);
			txtWarehouseCity = new Text(this, SWT.NULL);
			lblWarehouseTelephone = new CLabel(this, SWT.NULL);
			txtTelephone = new Text(this, SWT.NULL);
			lblDescription = new CLabel(this, SWT.NULL);
			txtWarehouseDescription = new Text(this, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL);
			this.setSize(new org.eclipse.swt.graphics.Point(593, 343));
			GridData lblWarehouseNameLData = new GridData();
			lblWarehouseNameLData.verticalAlignment = GridData.CENTER;
			lblWarehouseNameLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseNameLData.widthHint = -1;
			lblWarehouseNameLData.heightHint = -1;
			lblWarehouseNameLData.horizontalIndent = 0;
			lblWarehouseNameLData.horizontalSpan = 1;
			lblWarehouseNameLData.verticalSpan = 1;
			lblWarehouseNameLData.grabExcessHorizontalSpace = false;
			lblWarehouseNameLData.grabExcessVerticalSpace = false;
			lblWarehouseName.setLayoutData(lblWarehouseNameLData);
			lblWarehouseName.setText(InvLangKeys.STR_WAREHOUSE_NAME);
			GridData txtWarehouseNameLData = new GridData();
			txtWarehouseNameLData.horizontalAlignment = GridData.FILL;
			txtWarehouseNameLData.heightHint = 18;
			txtWarehouseName.setLayoutData(txtWarehouseNameLData);
			txtWarehouseName.setTextLimit(50);
			GridData lblWarehouseAdresLData = new GridData();
			lblWarehouseAdresLData.verticalAlignment = GridData.BEGINNING;
			lblWarehouseAdresLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseAdresLData.widthHint = -1;
			lblWarehouseAdresLData.heightHint = -1;
			lblWarehouseAdresLData.horizontalIndent = 0;
			lblWarehouseAdresLData.horizontalSpan = 1;
			lblWarehouseAdresLData.verticalSpan = 1;
			lblWarehouseAdresLData.grabExcessHorizontalSpace = false;
			lblWarehouseAdresLData.grabExcessVerticalSpace = false;
			lblWarehouseAdres.setLayoutData(lblWarehouseAdresLData);
			lblWarehouseAdres.setText(EngLangCommonKeys.STR_ADDRESS);
			GridData lblWareHouseCityLData = new GridData();
			lblWareHouseCityLData.verticalAlignment = GridData.CENTER;
			lblWareHouseCityLData.horizontalAlignment = GridData.BEGINNING;
			lblWareHouseCityLData.widthHint = -1;
			lblWareHouseCityLData.heightHint = -1;
			lblWareHouseCityLData.horizontalIndent = 0;
			lblWareHouseCityLData.horizontalSpan = 1;
			lblWareHouseCityLData.verticalSpan = 1;
			lblWareHouseCityLData.grabExcessHorizontalSpace = false;
			lblWareHouseCityLData.grabExcessVerticalSpace = false;
			lblWareHouseCity.setLayoutData(lblWareHouseCityLData);
			lblWareHouseCity.setText(EngLangCommonKeys.STR_CITY);
			GridData txtWarehouseCityLData = new GridData();
			txtWarehouseCityLData.verticalAlignment = GridData.CENTER;
			txtWarehouseCityLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseCityLData.widthHint = 153;
			txtWarehouseCityLData.heightHint = 17;
			txtWarehouseCityLData.horizontalIndent = 0;
			txtWarehouseCityLData.horizontalSpan = 1;
			txtWarehouseCityLData.verticalSpan = 1;
			txtWarehouseCityLData.grabExcessHorizontalSpace = false;
			txtWarehouseCityLData.grabExcessVerticalSpace = false;
			txtWarehouseCity.setLayoutData(txtWarehouseCityLData);
			txtWarehouseCity.setTextLimit(50);
			txtWarehouseCity.setSize(new org.eclipse.swt.graphics.Point(153, 17));
			GridData lblWarehouseTelephoneLData = new GridData();
			lblWarehouseTelephoneLData.verticalAlignment = GridData.CENTER;
			lblWarehouseTelephoneLData.horizontalAlignment = GridData.BEGINNING;
			lblWarehouseTelephoneLData.widthHint = 56;
			lblWarehouseTelephoneLData.heightHint = 19;
			lblWarehouseTelephoneLData.horizontalIndent = 0;
			lblWarehouseTelephoneLData.horizontalSpan = 1;
			lblWarehouseTelephoneLData.verticalSpan = 1;
			lblWarehouseTelephoneLData.grabExcessHorizontalSpace = false;
			lblWarehouseTelephoneLData.grabExcessVerticalSpace = false;
			lblWarehouseTelephone.setLayoutData(lblWarehouseTelephoneLData);
			lblWarehouseTelephone.setText(EngLangCommonKeys.STR_TELEPHONE);
			lblWarehouseTelephone.setSize(new org.eclipse.swt.graphics.Point(56, 19));
			GridData txtTelephoneLData = new GridData();
			txtTelephoneLData.verticalAlignment = GridData.CENTER;
			txtTelephoneLData.horizontalAlignment = GridData.BEGINNING;
			txtTelephoneLData.widthHint = 153;
			txtTelephoneLData.heightHint = 17;
			txtTelephoneLData.horizontalIndent = 0;
			txtTelephoneLData.horizontalSpan = 1;
			txtTelephoneLData.verticalSpan = 1;
			txtTelephoneLData.grabExcessHorizontalSpace = false;
			txtTelephoneLData.grabExcessVerticalSpace = false;
			txtTelephone.setLayoutData(txtTelephoneLData);
			txtTelephone.setSize(new org.eclipse.swt.graphics.Point(153, 17));
			GridData lblDescriptionLData = new GridData();
			lblDescriptionLData.verticalAlignment = GridData.BEGINNING;
			lblDescriptionLData.horizontalAlignment = GridData.BEGINNING;
			lblDescriptionLData.widthHint = -1;
			lblDescriptionLData.heightHint = -1;
			lblDescriptionLData.horizontalIndent = 0;
			lblDescriptionLData.horizontalSpan = 1;
			lblDescriptionLData.verticalSpan = 1;
			lblDescriptionLData.grabExcessHorizontalSpace = false;
			lblDescriptionLData.grabExcessVerticalSpace = false;
			lblDescription.setLayoutData(lblDescriptionLData);
			lblDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);
			GridData txtWarehouseDescriptionLData = new GridData();
			txtWarehouseDescription.addVerifyListener(new VerifyListener()
			{
				public void verifyText(VerifyEvent evt)
				{
					if (evt.keyCode == SWT.TAB)
					{
						txtWarehouseCode.setFocus();
						evt.doit = false;
					}
				}
			});
			txtWarehouseDescriptionLData.verticalAlignment = GridData.CENTER;
			txtWarehouseDescriptionLData.horizontalAlignment = GridData.BEGINNING;
			txtWarehouseDescriptionLData.widthHint = 347;
			txtWarehouseDescriptionLData.heightHint = 93;
			txtWarehouseDescriptionLData.horizontalIndent = 0;
			txtWarehouseDescriptionLData.horizontalSpan = 1;
			txtWarehouseDescriptionLData.verticalSpan = 1;
			txtWarehouseDescriptionLData.grabExcessHorizontalSpace = false;
			txtWarehouseDescriptionLData.grabExcessVerticalSpace = false;
			txtWarehouseDescription.setLayoutData(txtWarehouseDescriptionLData);
			txtWarehouseDescription.setTextLimit(50);
			txtWarehouseDescription.setSize(new org.eclipse.swt.graphics.Point(347, 93));
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 15;
			this.layout();
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
	public void postInitGUI()
	{
	}

	boolean verifyFields()
	{
		if (txtWarehouseName.getText().trim().equals("")) { //$NON-NLS-1$
			EngUICommon.showMessageBox(getShell(), InvLangKeys.MSG_ENTER_WAREHOUSE_NAME,SWT.ICON_WARNING);
			txtWarehouseName.setFocus();
			return false;
		}
		return true;
	}

	public void delete()
	{
	}

	public void clearFields()
	{
		txtWarehouseName.setText(""); //$NON-NLS-1$
		txtWarehouseDescription.setText(""); //$NON-NLS-1$
		txtTelephone.setText(""); //$NON-NLS-1$
		txtWarehouseAdres.setText(""); //$NON-NLS-1$
		txtWarehouseCity.setText(""); //$NON-NLS-1$
		txtWarehouseCode.setText("");
	}

	public void save()
	{
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_WAREHOUSE_NAME,txtWarehouseName.getText().trim());
				argMap.put(InvKeys.INV_WAREHOUSE_CODE,txtWarehouseCode.getText().trim());
				argMap.put(InvKeys.INV_WAREHOUSE_DESC,txtWarehouseDescription.getText().trim());
				argMap.put(InvKeys.INV_WAREHOUSE_ADDRESS,txtWarehouseAdres.getText().trim());
				argMap.put(InvKeys.INV_WAREHOUSE_TEL,txtTelephone.getText().trim());
				argMap.put(InvKeys.INV_WAREHOUSE_CITY,txtWarehouseCity.getText().trim());
				
				EngTXCommon.doTransactionTX(InvBLWarehouseAdd.class.getName(),"saveWarehouse",argMap);
				EngUICommon.showSavedSuccesfullyMessage(getShell());
				clearFields();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
		clearFields();
	}

	public void search()
	{
	}

	

	/**
	 * @return Returns the txtWarehouseCode.
	 */
	public Text getTxtWarehouseCode()
	{
		return txtWarehouseCode;
	}

}