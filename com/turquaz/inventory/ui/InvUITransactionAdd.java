package com.turquaz.inventory.ui;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.inventory.Messages;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUITransactionAdd extends Composite implements SecureComposite
{
	private CCombo comboInvTransWhSelect;
	private Label lblInvTransWhSelect;
	private CCombo comboInvTransUnit;
	private Text txtNumInvTransAmount;
	private Label lblInvTransAmount;
	private CCombo combpInvTransType;
	private Label lblInvTransType;
	private CCombo comboInvTransCard;
	private CLabel lblInvTransCard;
	private Composite compInvTransAdd;

	public InvUITransactionAdd(Composite parent, int style)
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
			this.setSize(new org.eclipse.swt.graphics.Point(329, 223));
			GridLayout thisLayout = new GridLayout();
			thisLayout.makeColumnsEqualWidth = true;
			this.setLayout(thisLayout);
			{
				compInvTransAdd = new Composite(this, SWT.NONE);
				GridLayout compInvTransAddLayout = new GridLayout();
				GridData compInvTransAddLData = new GridData();
				compInvTransAddLData.grabExcessHorizontalSpace = true;
				compInvTransAddLData.grabExcessVerticalSpace = true;
				compInvTransAddLData.horizontalAlignment = GridData.FILL;
				compInvTransAddLData.verticalAlignment = GridData.FILL;
				compInvTransAdd.setLayoutData(compInvTransAddLData);
				compInvTransAddLayout.numColumns = 4;
				compInvTransAddLayout.makeColumnsEqualWidth = true;
				compInvTransAdd.setLayout(compInvTransAddLayout);
				{
					lblInvTransCard = new CLabel(compInvTransAdd, SWT.NONE);
					GridLayout lblInvTransCardLayout = new GridLayout(1, true);
					lblInvTransCardLayout.marginWidth = 5;
					lblInvTransCardLayout.marginHeight = 5;
					lblInvTransCardLayout.numColumns = 1;
					lblInvTransCardLayout.makeColumnsEqualWidth = true;
					lblInvTransCardLayout.horizontalSpacing = 5;
					lblInvTransCardLayout.verticalSpacing = 5;
					GridData lblInvTransCardLData = new GridData();
					lblInvTransCardLData.widthHint = 52;
					lblInvTransCardLData.heightHint = 19;
					lblInvTransCard.setLayoutData(lblInvTransCardLData);
					lblInvTransCard.setText(Messages.getString("InvUITransactionAdd.0")); //$NON-NLS-1$
					lblInvTransCard.setLayout(lblInvTransCardLayout);
					lblInvTransCard.layout();
				}
				{
					comboInvTransCard = new CCombo(compInvTransAdd, SWT.NONE);
					GridData comboInvTransCardLData = new GridData();
					comboInvTransCardLData.widthHint = 64;
					comboInvTransCardLData.heightHint = 16;
					comboInvTransCardLData.horizontalSpan = 3;
					comboInvTransCard.setLayoutData(comboInvTransCardLData);
				}
				{
					lblInvTransType = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransTypeLData = new GridData();
					lblInvTransTypeLData.widthHint = 57;
					lblInvTransTypeLData.heightHint = 13;
					lblInvTransType.setLayoutData(lblInvTransTypeLData);
					lblInvTransType.setText(Messages.getString("InvUITransactionAdd.1")); //$NON-NLS-1$
				}
				{
					combpInvTransType = new CCombo(compInvTransAdd, SWT.NONE);
					GridData combpInvTransTypeLData = new GridData();
					combpInvTransTypeLData.widthHint = 64;
					combpInvTransTypeLData.heightHint = 16;
					combpInvTransTypeLData.horizontalSpan = 3;
					combpInvTransType.setLayoutData(combpInvTransTypeLData);
				}
				{
					lblInvTransAmount = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransAmountLData = new GridData();
					lblInvTransAmountLData.widthHint = 29;
					lblInvTransAmountLData.heightHint = 13;
					lblInvTransAmount.setLayoutData(lblInvTransAmountLData);
					lblInvTransAmount.setText(Messages.getString("InvUITransactionAdd.2")); //$NON-NLS-1$
				}
				{
					txtNumInvTransAmount = new Text(compInvTransAdd, SWT.NONE);
					GridData txtNumInvTransAmountLData = new GridData();
					txtNumInvTransAmountLData.widthHint = 64;
					txtNumInvTransAmountLData.heightHint = 13;
					txtNumInvTransAmount.setLayoutData(txtNumInvTransAmountLData);
				}
				{
					comboInvTransUnit = new CCombo(compInvTransAdd, SWT.NONE);
					GridData comboInvTransUnitLData = new GridData();
					comboInvTransUnitLData.widthHint = 64;
					comboInvTransUnitLData.heightHint = 16;
					comboInvTransUnitLData.horizontalSpan = 2;
					comboInvTransUnit.setLayoutData(comboInvTransUnitLData);
				}
				{
					lblInvTransWhSelect = new Label(compInvTransAdd, SWT.NONE);
					GridData lblInvTransWhSelectLData = new GridData();
					lblInvTransWhSelectLData.widthHint = 25;
					lblInvTransWhSelectLData.heightHint = 13;
					lblInvTransWhSelect.setLayoutData(lblInvTransWhSelectLData);
					lblInvTransWhSelect.setText(Messages.getString("InvUITransactionAdd.3")); //$NON-NLS-1$
				}
				{
					comboInvTransWhSelect = new CCombo(compInvTransAdd, SWT.NONE);
					GridData comboInvTransWhSelectLData = new GridData();
					comboInvTransWhSelectLData.widthHint = 64;
					comboInvTransWhSelectLData.heightHint = 16;
					comboInvTransWhSelectLData.horizontalSpan = 3;
					comboInvTransWhSelect.setLayoutData(comboInvTransWhSelectLData);
				}
				compInvTransAdd.layout();
			}
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

	public void save()
	{
	}

	public void delete()
	{
	}

	public void newForm()
	{
	}

	public void search()
	{
	}

	
}