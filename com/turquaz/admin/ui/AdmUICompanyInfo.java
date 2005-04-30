package com.turquaz.admin.ui;

import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLCompanyInfo;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUIMainFrame;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AdmUICompanyInfo extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lblCompanyName;
	private Text txtCompanyName;
	private Text txtCompanyFax;
	private CLabel lblCompanyFax;
	private Text txtCompanyPhone;
	private CLabel lblCompanyPhone;
	private Text txtCompanyAddress;
	private CLabel lblCompanyAddress;
	TurqCompany company;

	public AdmUICompanyInfo(org.eclipse.swt.widgets.Composite parent, int style)
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
			this.setSize(568, 322);
			{
				lblCompanyName = new CLabel(this, SWT.NONE);
				lblCompanyName.setText(AdmLangKeys.STR_COMPANY_NAME);
			}
			{
				txtCompanyName = new Text(this, SWT.NONE);
				GridData txtCompanyNameLData = new GridData();
				txtCompanyNameLData.widthHint = 351;
				txtCompanyNameLData.heightHint = 16;
				txtCompanyName.setLayoutData(txtCompanyNameLData);
			}
			{
				lblCompanyAddress = new CLabel(this, SWT.NONE);
				lblCompanyAddress.setText(AdmLangKeys.STR_COMPANY_ADDRESS); 
				GridData lblCompanyAddressLData = new GridData();
				lblCompanyAddressLData.verticalAlignment = GridData.BEGINNING;
				lblCompanyAddress.setLayoutData(lblCompanyAddressLData);
			}
			{
				txtCompanyAddress = new Text(this, SWT.MULTI | SWT.WRAP | SWT.H_SCROLL);
				GridData txtCompanyAddressLData = new GridData();
				txtCompanyAddressLData.widthHint = 350;
				txtCompanyAddressLData.heightHint = 70;
				txtCompanyAddress.setLayoutData(txtCompanyAddressLData);
			}
			{
				lblCompanyPhone = new CLabel(this, SWT.NONE);
				lblCompanyPhone.setText(AdmLangKeys.STR_TELEPHONE); //$NON-NLS-1$
			}
			{
				txtCompanyPhone = new Text(this, SWT.NONE);
				GridData txtCompanyPhoneLData = new GridData();
				txtCompanyPhoneLData.widthHint = 126;
				txtCompanyPhoneLData.heightHint = 18;
				txtCompanyPhone.setLayoutData(txtCompanyPhoneLData);
			}
			{
				lblCompanyFax = new CLabel(this, SWT.NONE);
				lblCompanyFax.setText(AdmLangKeys.STR_FAX); //$NON-NLS-1$
			}
			{
				txtCompanyFax = new Text(this, SWT.NONE);
				GridData txtCompanyFaxLData = new GridData();
				txtCompanyFaxLData.widthHint = 124;
				txtCompanyFaxLData.heightHint = 17;
				txtCompanyFax.setLayoutData(txtCompanyFaxLData);
			}
			this.layout();
			postInitGUI();
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
			company =(TurqCompany)EngTXCommon.doSelectTX(AdmBLCompanyInfo.class.getName(),"getCompany",null);
			txtCompanyName.setText(company.getCompanyName());
			txtCompanyAddress.setText(company.getCompanyAddress());
			txtCompanyFax.setText(company.getCompanyFax());
			txtCompanyPhone.setText(company.getCompanyTelephone());
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void save()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			HashMap argMap = new HashMap();
			
			argMap.put(AdmKeys.ADM_COMPANY,company);
			argMap.put(AdmKeys.ADM_COMPANY_NAME,txtCompanyName.getText().trim());
			argMap.put(AdmKeys.ADM_COMPANY_ADDRESS,txtCompanyAddress.getText().trim());
			argMap.put(AdmKeys.ADM_COMPANY_PHONE,txtCompanyPhone.getText().trim());
			argMap.put(AdmKeys.ADM_COMPANY_FAX,txtCompanyPhone.getText().trim());
			
			EngTXCommon.doTransactionTX(AdmBLCompanyInfo.class.getName(),"updateCompany",argMap);
			EngUIMainFrame.shell.setText("Turquaz - " + txtCompanyName.getText().trim());
			msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); 
			msg.open();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}