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

import com.turquaz.admin.bl.AdmBLCurrencyAdd;
import com.turquaz.engine.ui.component.SecureComposite;


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
public class AdmUICurrencyAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite {
	private CLabel lblCurrencyName;
	private Text txtCurrencyName;
	private CLabel lblCurrencyAbbr;
	private Text txtCurrencyAbbr;
	private Text txtCurrencyCountry;
	private CLabel lblCurrencyCountry;

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
		AdmUICurrencyAdd inst = new AdmUICurrencyAdd(shell, SWT.NULL);
		Point size = inst.getSize();
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

	public AdmUICurrencyAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(467, 176);
			//START >>  lblCurrencyName
			lblCurrencyName = new CLabel(this, SWT.NONE);
			lblCurrencyName.setText("Para Birimi \u0130smi");
			//END <<  lblCurrencyName
			//START >>  txtCurrencyName
			txtCurrencyName = new Text(this, SWT.NONE);
			GridData txtCurrencyNameLData = new GridData();
			txtCurrencyNameLData.widthHint = 130;
			txtCurrencyNameLData.heightHint = 17;
			txtCurrencyName.setLayoutData(txtCurrencyNameLData);
			//END <<  txtCurrencyName
			//START >>  lblCurrencyAbbr
			lblCurrencyAbbr = new CLabel(this, SWT.NONE);
			lblCurrencyAbbr.setText("Para Birimi K\u0131saltmas\u0131");
			//END <<  lblCurrencyAbbr
			//START >>  txtCurrencyAbbr
			txtCurrencyAbbr = new Text(this, SWT.NONE);
			GridData txtCurrencyAbbrLData = new GridData();
			txtCurrencyAbbrLData.widthHint = 130;
			txtCurrencyAbbrLData.heightHint = 17;
			txtCurrencyAbbr.setLayoutData(txtCurrencyAbbrLData);
			//END <<  txtCurrencyAbbr
			//START >>  lblCurrencyCountry
			lblCurrencyCountry = new CLabel(this, SWT.NONE);
			lblCurrencyCountry.setText("Ülke");
			//END <<  lblCurrencyCountry
			//START >>  txtCurrencyCountry
			txtCurrencyCountry = new Text(this, SWT.NONE);
			GridData txtCurrencyCountryLData = new GridData();
			txtCurrencyCountryLData.widthHint = 130;
			txtCurrencyCountryLData.heightHint = 17;
			txtCurrencyCountry.setLayoutData(txtCurrencyCountryLData);
			//END <<  txtCurrencyCountry
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyFields()
	{
		MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
		if (txtCurrencyName.getText().equals(""))
		{
			msg.setMessage("Lütfen para birimi için isim giriniz!");
			msg.open();
			txtCurrencyName.setFocus();
			return false;
		}
		else if (txtCurrencyAbbr.getText().equals(""))
		{
			msg.setMessage("Lütfen para birimi için k?saltma giriniz!");
			msg.open();
			txtCurrencyAbbr.setFocus();
			return false;
		}
		return true;
	}
	
	public void save()
	{
		MessageBox msg=new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			if (verifyFields())
			{
				AdmBLCurrencyAdd.saveCurrency(txtCurrencyName.getText(),
					txtCurrencyAbbr.getText(),txtCurrencyCountry.getText());
				msg.setMessage("Para birimi ba?ar?yla kaydedildi.");
				msg.open();
				newForm();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage("Daha önce varolan bir para birimi k?saltmas?n? kullanamazs?n?z!");
			msg.open();
		}
	}
	
	public void newForm()
	{
		clearFields();
	}
	
	public void clearFields()
	{
		txtCurrencyAbbr.setText("");
		txtCurrencyCountry.setText("");
		txtCurrencyName.setText("");
	}

}
