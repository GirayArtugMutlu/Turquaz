package com.turquaz.admin.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.admin.Messages;
import com.turquaz.admin.bl.AdmBLCurrencyExchangeRateAdd;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class AdmUICurrencyExchangeRateSearch extends org.eclipse.swt.widgets.Composite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Composite compTable;
	private Table tableExchange;
	private TableColumn tableColumnDate;
	private TableColumn tableColumnExchangeRatio;
	private TableColumn tableColumnExchangeCurrencyAbbr;

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
		AdmUICurrencyExchangeRateSearch inst = new AdmUICurrencyExchangeRateSearch(shell, SWT.NULL);
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

	public AdmUICurrencyExchangeRateSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(574, 203);
			//START >> compTable
			compTable = new Composite(this, SWT.NONE);
			GridLayout compTableLayout = new GridLayout();
			GridData compTableLData = new GridData();
			compTableLData.grabExcessHorizontalSpace = true;
			compTableLData.grabExcessVerticalSpace = true;
			compTableLData.verticalAlignment = GridData.FILL;
			compTableLData.horizontalAlignment = GridData.FILL;
			compTable.setLayoutData(compTableLData);
			compTableLayout.makeColumnsEqualWidth = true;
			compTable.setLayout(compTableLayout);
			//START >> tableExchange
			tableExchange = new Table(compTable, SWT.NONE);
			tableExchange.setLinesVisible(true);
			tableExchange.setHeaderVisible(true);
			GridData tableExchangeLData = new GridData();
			tableExchangeLData.grabExcessHorizontalSpace = true;
			tableExchangeLData.grabExcessVerticalSpace = true;
			tableExchangeLData.horizontalAlignment = GridData.FILL;
			tableExchangeLData.verticalAlignment = GridData.FILL;
			tableExchange.setLayoutData(tableExchangeLData);
			//START >> tableColumnDate
			tableColumnDate = new TableColumn(tableExchange, SWT.NONE);
			tableColumnDate.setText(Messages.getString("AdmUICurrencyExchangeRateSearch.0")); //$NON-NLS-1$
			tableColumnDate.setWidth(100);
			//END << tableColumnDate
			//START >> tableColumnExchangeCurrencyAbbr
			tableColumnExchangeCurrencyAbbr = new TableColumn(tableExchange, SWT.NONE);
			tableColumnExchangeCurrencyAbbr.setText(Messages.getString("AdmUICurrencyExchangeRateSearch.1")); //$NON-NLS-1$
			tableColumnExchangeCurrencyAbbr.setWidth(100);
			//END << tableColumnExchangeCurrencyAbbr
			//START >> tableColumnExchangeRatio
			tableColumnExchangeRatio = new TableColumn(tableExchange, SWT.NONE);
			tableColumnExchangeRatio.setText(Messages.getString("AdmUICurrencyExchangeRateSearch.2")); //$NON-NLS-1$
			tableColumnExchangeRatio.setWidth(100);
			//END << tableColumnExchangeRatio
			//END << tableExchange
			//END << compTable
			this.layout();
			PostInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void PostInit()
	{
		try
		{
			List exchangeRates = AdmBLCurrencyExchangeRateAdd.getCurrencyExchangeRates();
			TableItem item;
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int k = 0; k < exchangeRates.size(); k++)
			{
				Object[] exRate = (Object[]) exchangeRates.get(k);
				Integer exchangeId = (Integer) exRate[0];
				Date exchangeDate = (Date) exRate[1];
				String exchangeCurrency = (String) exRate[2];
				BigDecimal exchangeRatio = (BigDecimal) exRate[3];
				item = new TableItem(tableExchange, SWT.NONE);
				item.setText(new String[]{df.format(exchangeDate), exchangeCurrency, cf.format(exchangeRatio)});
				item.setData(exchangeId);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}