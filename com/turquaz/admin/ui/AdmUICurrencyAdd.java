package com.turquaz.admin.ui;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLCurrencyAdd;
import com.turquaz.engine.ui.component.SecureComposite;

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

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AdmUICurrencyAdd inst = new AdmUICurrencyAdd(shell, SWT.NULL);
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
			lblCurrencyName.setText(Messages.getString("AdmUICurrencyAdd.0")); //$NON-NLS-1$
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
			lblCurrencyAbbr.setText(Messages.getString("AdmUICurrencyAdd.1")); //$NON-NLS-1$
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
			lblCurrencyCountry.setText(Messages.getString("AdmUICurrencyAdd.2")); //$NON-NLS-1$
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
			e.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (txtCurrencyName.getText().equals("")) //$NON-NLS-1$
		{
			msg.setMessage(Messages.getString("AdmUICurrencyAdd.4")); //$NON-NLS-1$
			msg.open();
			txtCurrencyName.setFocus();
			return false;
		}
		else if (txtCurrencyAbbr.getText().equals("")) //$NON-NLS-1$
		{
			msg.setMessage(Messages.getString("AdmUICurrencyAdd.6")); //$NON-NLS-1$
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
				AdmBLCurrencyAdd.saveCurrency(txtCurrencyName.getText(), txtCurrencyAbbr.getText(), txtCurrencyCountry.getText());
				msg.setMessage(Messages.getString("AdmUICurrencyAdd.7")); //$NON-NLS-1$
				msg.open();
				newForm();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage(Messages.getString("AdmUICurrencyAdd.8")); //$NON-NLS-1$
			msg.open();
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