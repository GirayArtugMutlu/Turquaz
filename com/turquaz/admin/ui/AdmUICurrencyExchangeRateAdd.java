package com.turquaz.admin.ui;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.bl.AdmBLCurrencyExchangeRateAdd;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLServer;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AdmLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.CurrencyTextAdvanced;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AdmUICurrencyExchangeRateAdd extends org.eclipse.swt.widgets.Composite implements SecureComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lvlExchangeDate;
	private Text txtBaseCurrency;
	private CCombo comboExchangeCurrency;
	private CLabel lblExchangeCurrency;
	private CLabel lblBaseCurrency;
	private DatePicker dateExchangeDate;
	private Calendar cal = Calendar.getInstance();
	private CurrencyTextAdvanced txtExchangeRatio;
	private CLabel lvlExchangeRatio;

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
		AdmUICurrencyExchangeRateAdd inst = new AdmUICurrencyExchangeRateAdd(shell, SWT.NULL);
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

	public AdmUICurrencyExchangeRateAdd(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
		PostInit();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(495, 205);
			//START >> lvlExchangeDate
			lvlExchangeDate = new CLabel(this, SWT.NONE);
			lvlExchangeDate.setText(EngLangCommonKeys.STR_DATE); 
			//END << lvlExchangeDate
			//START >> dateExchangeDate
			dateExchangeDate = new DatePicker(this, SWT.NONE);
			GridData dateExchangeDateLData = new GridData();
			dateExchangeDateLData.widthHint = 130;
			dateExchangeDateLData.heightHint = 22;
			dateExchangeDate.setLayoutData(dateExchangeDateLData);
			//END << dateExchangeDate
			//START >> lblBaseCurrency
			lblBaseCurrency = new CLabel(this, SWT.NONE);
			lblBaseCurrency.setText(AdmLangKeys.STR_BASE_CURRENCY); //$NON-NLS-1$
			//END << lblBaseCurrency
			//START >> txtBaseCurrency
			txtBaseCurrency = new Text(this, SWT.NONE);
			GridData txtBaseCurrencyLData = new GridData();
			txtBaseCurrency.setEnabled(false);
			txtBaseCurrencyLData.widthHint = 121;
			txtBaseCurrencyLData.heightHint = 17;
			txtBaseCurrency.setLayoutData(txtBaseCurrencyLData);
			//END << txtBaseCurrency
			//START >> lblExchangeCurrency
			lblExchangeCurrency = new CLabel(this, SWT.NONE);
			lblExchangeCurrency.setText(AdmLangKeys.STR_EXCHANGED_CURRENCY); 
			//END << lblExchangeCurrency
			//START >> comboExchangeCurrency
			comboExchangeCurrency = new CCombo(this, SWT.NONE);
			GridData comboExchangeCurrencyLData = new GridData();
			comboExchangeCurrencyLData.widthHint = 107;
			comboExchangeCurrencyLData.heightHint = 18;
			comboExchangeCurrency.setLayoutData(comboExchangeCurrencyLData);
			//END << comboExchangeCurrency
			//START >> lvlExchangeRatio
			lvlExchangeRatio = new CLabel(this, SWT.NONE);
			lvlExchangeRatio.setText(EngLangCommonKeys.STR_EXCHANGE_RATE); //$NON-NLS-1$
			//END << lvlExchangeRatio
			//START >> txtExchangeRatio
			txtExchangeRatio = new CurrencyTextAdvanced(this, SWT.NONE, 4);
			GridData txtExchangeRatioLData = new GridData();
			txtExchangeRatioLData.widthHint = 121;
			txtExchangeRatioLData.heightHint = 17;
			txtExchangeRatio.setLayoutData(txtExchangeRatioLData);
			//END << txtExchangeRatio
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void PostInit()
	{
		txtBaseCurrency.setText(EngBLClient.getBaseCurrency().getCurrenciesAbbreviation());
		fillCurrencyCombo();
	}

	public void fillCurrencyCombo()
	{
		try
		{
			List currencies = (List)EngTXCommon.doSelectTX(EngBLServer.class.getName(),"getCurrencies",null);
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				if (!currency.isDefaultCurrency())
				{
					comboExchangeCurrency.add(currency.getCurrenciesAbbreviation());
					comboExchangeCurrency.setData(currency.getCurrenciesAbbreviation(), currency);
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
		comboExchangeCurrency.setText(""); //$NON-NLS-1$
		txtExchangeRatio.setText("");
		comboExchangeCurrency.setFocus();
		dateExchangeDate.setDate(cal.getTime());
	}

	public boolean verifyFields()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		if (comboExchangeCurrency.getData(comboExchangeCurrency.getText()) == null)
		{
			msg.setMessage(AdmLangKeys.MSG_PLEASE_CHOOSE_CURRENCY); //$NON-NLS-1$
			msg.open();
			comboExchangeCurrency.setFocus();
			return false;
		}
		else if (txtExchangeRatio.getBigDecimalValue().doubleValue() <= 0)
		{
			msg.setMessage(AdmLangKeys.MSG_NOT_EXCHANGE_RATE_GREATER_THAN_ZERO); //$NON-NLS-1$
			msg.open();
			txtExchangeRatio.setFocus();
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
				
				argMap.put(EngKeys.EXCHANGE_CURRENCY,comboExchangeCurrency.getData(comboExchangeCurrency.getText()));
				argMap.put(EngKeys.EXCHANGE_RATIO,txtExchangeRatio.getBigDecimalValue());
				argMap.put(EngKeys.EXCHANGE_DATE,dateExchangeDate.getDate());
				
				EngTXCommon.doTransactionTX(AdmBLCurrencyExchangeRateAdd.class.getName(),"saveExchangeRate",argMap);
				msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); 
				msg.open();
				newForm();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}