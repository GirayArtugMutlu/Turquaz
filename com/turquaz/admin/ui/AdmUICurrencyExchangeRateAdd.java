package com.turquaz.admin.ui;

import java.util.Calendar;
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;

import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.admin.bl.AdmBLCurrencyExchangeRateAdd;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.CurrencyTextAdvanced;
import com.turquaz.engine.ui.component.SecureComposite;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;


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
public class AdmUICurrencyExchangeRateAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	private CLabel lvlExchangeDate;
	private Text txtBaseCurrency;
	private CCombo comboExchangeCurrency;
	private CLabel lblExchangeCurrency;
	private CLabel lblBaseCurrency;
	private DatePicker dateExchangeDate;
	private Calendar cal=Calendar.getInstance();
	private CurrencyTextAdvanced txtExchangeRatio;
	private CLabel lvlExchangeRatio;

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
		AdmUICurrencyExchangeRateAdd inst = new AdmUICurrencyExchangeRateAdd(shell, SWT.NULL);
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

	public AdmUICurrencyExchangeRateAdd(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
		PostInit();
	}

	private void initGUI() {
		try {
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(495, 205);
			//START >>  lvlExchangeDate
			lvlExchangeDate = new CLabel(this, SWT.NONE);
			lvlExchangeDate.setText("Tarih");
			GridData lvlExchangeDateLData = new GridData();
			lvlExchangeDateLData.widthHint = 95;
			lvlExchangeDateLData.heightHint = 22;
			lvlExchangeDate.setLayoutData(lvlExchangeDateLData);
			//END <<  lvlExchangeDate
			//START >>  dateExchangeDate
			dateExchangeDate = new DatePicker(this, SWT.NONE);
			GridData dateExchangeDateLData = new GridData();
			dateExchangeDateLData.widthHint = 130;
			dateExchangeDateLData.heightHint = 22;
			dateExchangeDate.setLayoutData(dateExchangeDateLData);
			//END <<  dateExchangeDate
			//START >>  lblBaseCurrency
			lblBaseCurrency = new CLabel(this, SWT.NONE);
			lblBaseCurrency.setText("Ana Para Birimi");
			//END <<  lblBaseCurrency
			//START >>  txtBaseCurrency
			txtBaseCurrency = new Text(this, SWT.NONE);
			GridData txtBaseCurrencyLData = new GridData();
			txtBaseCurrency.setEnabled(false);
			txtBaseCurrencyLData.widthHint = 121;
			txtBaseCurrencyLData.heightHint = 17;
			txtBaseCurrency.setLayoutData(txtBaseCurrencyLData);
			//END <<  txtBaseCurrency
			//START >>  lblExchangeCurrency
			lblExchangeCurrency = new CLabel(this, SWT.NONE);
			lblExchangeCurrency.setText("De\u011fi\u015fim Para Birimi");
			//END <<  lblExchangeCurrency
			//START >>  comboExchangeCurrency
			comboExchangeCurrency = new CCombo(this, SWT.NONE);
			GridData comboExchangeCurrencyLData = new GridData();
			comboExchangeCurrencyLData.widthHint = 107;
			comboExchangeCurrencyLData.heightHint = 18;
			comboExchangeCurrency.setLayoutData(comboExchangeCurrencyLData);
			//END <<  comboExchangeCurrency
			//START >>  lvlExchangeRatio
			lvlExchangeRatio = new CLabel(this, SWT.NONE);
			lvlExchangeRatio.setText("De\u011fi\u015fim Oran\u0131");
			//END <<  lvlExchangeRatio
			//START >>  txtExchangeRatio
			txtExchangeRatio = new CurrencyTextAdvanced(this, SWT.NONE,4);
			GridData txtExchangeRatioLData = new GridData();
			txtExchangeRatioLData.widthHint = 121;
			txtExchangeRatioLData.heightHint = 17;
			txtExchangeRatio.setLayoutData(txtExchangeRatioLData);
			//END <<  txtExchangeRatio
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PostInit()
	{
		txtBaseCurrency.setText(EngBLCommon.getBaseCurrency().getCurrenciesAbbreviation());
		fillCurrencyCombo();
	}
	
	public void fillCurrencyCombo()
	{
		try
		{
			List currencies=AccBLTransactionSearch.getCurrencies();
			for (int k=0; k<currencies.size(); k++)
			{
				TurqCurrency currency=(TurqCurrency)currencies.get(k);				
				if (!currency.isDefaultCurrency())
				{
					comboExchangeCurrency.add(currency.getCurrenciesAbbreviation());
					comboExchangeCurrency.setData(currency.getCurrenciesAbbreviation(),currency);
				}
			
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void newForm()
	{
		comboExchangeCurrency.setText("");
		dateExchangeDate.setDate(cal.getTime());
	}
	
	public boolean verifyFields()
	{
		MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
		if (comboExchangeCurrency.getData(comboExchangeCurrency.getText())==null)
		{
			
			msg.setMessage("?lk önce bir para birimi seçmelisiniz!");
			msg.open();
			comboExchangeCurrency.setFocus();
			return false;
		}
		else if (txtExchangeRatio.getBigDecimalValue().doubleValue() <= 0)
		{
			msg.setMessage("De?i?im oran? 0'dan büyük bir say? olmal?d?r!");
			msg.open();
			txtExchangeRatio.setFocus();
			return false;
		}
		return true;
	}
	
	public void save()
	{
		MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
		try
		{
			
			if (verifyFields())
			{
				AdmBLCurrencyExchangeRateAdd.saveExchangeRate((TurqCurrency)
						comboExchangeCurrency.getData(comboExchangeCurrency.getText()),
						txtExchangeRatio.getBigDecimalValue(),
						dateExchangeDate.getDate()
						);
				msg.setMessage("Günlük de?i?im oran? ba?ar?yla kaydedildi!");
				msg.open();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			msg.setMessage("Bugüne ait bu para birimine ait bir de?i?im oran? zaten mevcut!");
			msg.open();
		}
	}

}
