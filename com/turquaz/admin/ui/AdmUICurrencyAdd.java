package com.turquaz.admin.ui;

import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLCurrencyAdd;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AdmUICurrencyAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lblCurrencyName;
	private Text txtCurrencyName;
	private CLabel lblCurrencyAbbr;
	private Text txtCurrencyAbbr;
	private Text txtCurrencyCountry;
	private CLabel lblCurrencyCountry;


	public AdmUICurrencyAdd(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(467, 176);
			//START >> lblCurrencyName
			lblCurrencyName = new CLabel(this, SWT.NONE);
			lblCurrencyName.setText(EngLangCommonKeys.STR_CURRENCY); //$NON-NLS-1$
			//END << lblCurrencyName
			//START >> txtCurrencyName
			txtCurrencyName = new Text(this, SWT.NONE);
			GridData txtCurrencyNameLData = new GridData();
			txtCurrencyNameLData.widthHint = 130;
			txtCurrencyNameLData.heightHint = 17;
			txtCurrencyName.setLayoutData(txtCurrencyNameLData);
			//END << txtCurrencyName
			//START >> lblCurrencyAbbr
			lblCurrencyAbbr = new CLabel(this, SWT.NONE);
			lblCurrencyAbbr.setText(EngLangCommonKeys.STR_CURRENCY_ABBR); //$NON-NLS-1$
			//END << lblCurrencyAbbr
			//START >> txtCurrencyAbbr
			txtCurrencyAbbr = new Text(this, SWT.NONE);
			GridData txtCurrencyAbbrLData = new GridData();
			txtCurrencyAbbrLData.widthHint = 130;
			txtCurrencyAbbrLData.heightHint = 17;
			txtCurrencyAbbr.setLayoutData(txtCurrencyAbbrLData);
			//END << txtCurrencyAbbr
			//START >> lblCurrencyCountry
			lblCurrencyCountry = new CLabel(this, SWT.NONE);
			lblCurrencyCountry.setText(EngLangCommonKeys.STR_CURRENCY_COUNTRY); //$NON-NLS-1$
			//END << lblCurrencyCountry
			//START >> txtCurrencyCountry
			txtCurrencyCountry = new Text(this, SWT.NONE);
			GridData txtCurrencyCountryLData = new GridData();
			txtCurrencyCountryLData.widthHint = 130;
			txtCurrencyCountryLData.heightHint = 17;
			txtCurrencyCountry.setLayoutData(txtCurrencyCountryLData);
			//END << txtCurrencyCountry
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
		if (txtCurrencyName.getText().equals("")) //$NON-NLS-1$
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_FILL_CURRENCY); //$NON-NLS-1$
			msg.open();
			txtCurrencyName.setFocus();
			return false;
		}
		else if (txtCurrencyAbbr.getText().equals("")) //$NON-NLS-1$
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_FILL_CURRENCY_ABBR); //$NON-NLS-1$
			msg.open();
			txtCurrencyAbbr.setFocus();
			return false;
		}
		return true;
	}

	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				HashMap argMap=new HashMap();
				
				argMap.put(AdmKeys.ADM_CURRENCY_NAME,txtCurrencyName.getText().trim());
				argMap.put(AdmKeys.ADM_CURRENCY_ABBR,txtCurrencyAbbr.getText().trim());
				argMap.put(AdmKeys.ADM_CURRENCY_COUNTRY,txtCurrencyCountry.getText().trim());
				
				EngTXCommon.doTransactionTX(AdmBLCurrencyAdd.class.getName(),"saveCurrency",argMap);
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); //$NON-NLS-1$
				msg.open();
				newForm();
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
		txtCurrencyName.setFocus();
	}

	public void clearFields()
	{
		txtCurrencyAbbr.setText(""); //$NON-NLS-1$
		txtCurrencyCountry.setText(""); //$NON-NLS-1$
		txtCurrencyName.setText(""); //$NON-NLS-1$
	}
}