package com.turquaz.current.ui;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridData;
import com.turquaz.current.ui.comp.CurrentCodePicker;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.widgets.Text;

public class CurUICurrentCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compSearch;
	private CurrentCodePicker txtCurrentCard2;
	private CLabel lblCurCard2;
	private CLabel lblCurrentCard;
	private CurrentCodePicker txtCurrentCard;
	private DatePicker datePickerEndDate;
	private ViewerComposite viewer;
	private CurrencyText txtTransAmount;
	private CLabel lblAmount;
	private Text txtDefinition;
	private CLabel lblDefinition;
	private CLabel lblEndDate;
	private DatePicker datePickerStartDate;
	private CLabel lblStartDate;
	private CurBLSearchTransaction BLsearch = new CurBLSearchTransaction();
	private TurqCurrentCard currentCard = null;
	private TurqCurrentCard currentCard2 = null;
	private Calendar cal = Calendar.getInstance();

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
		CurUICurrentCardAbstract inst = new CurUICurrentCardAbstract(shell, SWT.NULL);
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

	public CurUICurrentCardAbstract(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(880, 283);
			{
				compSearch = new Composite(this, SWT.NONE);
				GridLayout compSearchLayout = new GridLayout();
				GridData compSearchLData = new GridData();
				compSearchLData.grabExcessHorizontalSpace = true;
				compSearchLData.horizontalAlignment = GridData.FILL;
				compSearchLData.heightHint = 87;
				compSearch.setLayoutData(compSearchLData);
				compSearchLayout.numColumns = 4;
				compSearch.setLayout(compSearchLayout);
				{
					lblCurrentCard = new CLabel(compSearch, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("CurUICurrentCardAbstract.0")); //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 120;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurrentCard = new CurrentCodePicker(compSearch, SWT.NONE);
					GridData txtCurrentCardLData = new GridData();
					txtCurrentCardLData.widthHint = 157;
					txtCurrentCardLData.heightHint = 17;
					txtCurrentCard.setLayoutData(txtCurrentCardLData);
				}
				{
					lblCurCard2 = new CLabel(compSearch, SWT.NONE);
					lblCurCard2.setText(Messages.getString("CurUICurrentCardAbstract.3")); //$NON-NLS-1$
				}
				{
					txtCurrentCard2 = new CurrentCodePicker(compSearch, SWT.NONE);
					GridData txtCurrentCard2LData = new GridData();
					txtCurrentCard2LData.widthHint = 157;
					txtCurrentCard2LData.heightHint = 17;
					txtCurrentCard2.setLayoutData(txtCurrentCard2LData);
				}
				{
					lblStartDate = new CLabel(compSearch, SWT.NONE);
					lblStartDate.setText(Messages.getString("CurUICurrentCardAbstract.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 96;
					lblStartDateLData.heightHint = 18;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					datePickerStartDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerStartDateLData = new GridData();
					datePickerStartDateLData.widthHint = 157;
					datePickerStartDateLData.heightHint = 23;
					datePickerStartDate.setLayoutData(datePickerStartDateLData);
				}
				{
					lblEndDate = new CLabel(compSearch, SWT.NONE);
					lblEndDate.setText(Messages.getString("CurUICurrentCardAbstract.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 77;
					lblEndDateLData.heightHint = 20;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					datePickerEndDate = new DatePicker(compSearch, SWT.NONE);
					GridData datePickerEndDateLData = new GridData();
					datePickerEndDateLData.widthHint = 157;
					datePickerEndDateLData.heightHint = 23;
					datePickerEndDate.setLayoutData(datePickerEndDateLData);
				}
				//START >> lblAmount
				lblAmount = new CLabel(compSearch, SWT.NONE);
				lblAmount.setText("Miktar - En az");
				//END << lblAmount
				//START >> txtTransAmount
				txtTransAmount = new CurrencyText(compSearch, SWT.NONE);
				GridData txtTransAmountLData = new GridData();
				txtTransAmountLData.widthHint = 150;
				txtTransAmountLData.heightHint = 17;
				txtTransAmount.setLayoutData(txtTransAmountLData);
				//END << txtTransAmount
				{
					lblDefinition = new CLabel(compSearch, SWT.NONE);
					lblDefinition.setText(Messages.getString("CurUICurrentCardAbstract.5")); //$NON-NLS-1$
				}
				{
					txtDefinition = new Text(compSearch, SWT.WRAP | SWT.V_SCROLL);
					GridData txtDefinitionLData = new GridData();
					txtDefinitionLData.widthHint = 270;
					txtDefinitionLData.heightHint = 23;
					txtDefinition.setLayoutData(txtDefinitionLData);
				}
			}
			{
				viewer = new ViewerComposite(this, SWT.NONE);
				GridData viewerLData = new GridData();
				viewerLData.grabExcessHorizontalSpace = true;
				viewerLData.horizontalAlignment = GridData.FILL;
				viewerLData.grabExcessVerticalSpace = true;
				viewerLData.verticalAlignment = GridData.FILL;
				viewer.setLayoutData(viewerLData);
			}
			postInitGui();
			this.layout();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void postInitGui()
	{
		//datePickerStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		datePickerStartDate.setDate(cal.getTime());
	}

	public void exportToExcel()
	{
	}

	public void delete()
	{
	}

	public void search()
	{
		try
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			currentCard = null;
			currentCard2 = null;
			if (txtCurrentCard.getData() == null && txtCurrentCard2.getData() != null)
			{
				currentCard = (TurqCurrentCard) txtCurrentCard2.getData();
				currentCard2 = null;
			}
			else if (txtCurrentCard2.getData() == null && txtCurrentCard.getData() != null)
			{
				currentCard = (TurqCurrentCard) txtCurrentCard.getData();
				currentCard2 = null;
			}
			else if (txtCurrentCard.getData() != null && txtCurrentCard2.getData() != null)
			{
				currentCard = (TurqCurrentCard) txtCurrentCard.getData();
				currentCard2 = (TurqCurrentCard) txtCurrentCard2.getData();
			}
			SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd"); //$NON-NLS-1$
			
			HashMap argMap = new HashMap();
			
			argMap.put(EngKeys.CURRENT_CARD_START,currentCard);
			argMap.put(EngKeys.CURRENT_CARD_END,currentCard2);
			argMap.put(EngKeys.DATE_START,datePickerStartDate.getDate());
			argMap.put(EngKeys.DATE_END,datePickerEndDate.getDate());
			argMap.put(EngKeys.DEFINITION,txtDefinition.getText().trim());
			argMap.put(EngKeys.MIN_VALUE,txtTransAmount.getBigDecimalValue());			
			
			List list=(List)EngTXCommon.doSingleTX(CurBLSearchTransaction.class.getName(),"getCurrentCardAbstract",argMap);
			Map parameters = new HashMap();
			SimpleDateFormat dformat2 = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			parameters.put("startDate", dformat2.format(datePickerStartDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", dformat2.format(datePickerEndDate.getDate())); //$NON-NLS-1$
			parameters.put("dformat", dformat2); //$NON-NLS-1$
			parameters.put("currentCard1", (currentCard == null) ? "" : currentCard.getCardsCurrentCode()); //$NON-NLS-1$
			parameters.put("currentCard2", (currentCard2 == null) ? "" : currentCard2.getCardsCurrentCode()); //$NON-NLS-1$ //$NON-NLS-2$
			parameters.put("formatter", new TurkishCurrencyFormat(2)); //$NON-NLS-1$
			parameters.put("currency", new TurkishCurrencyFormat(2)); //$NON-NLS-1$
			parameters.put("currentDate", dformat2.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			
			
			argMap = new HashMap();
			
			argMap.put(EngKeys.CURRENT_CARD_START,currentCard);
			argMap.put(EngKeys.CURRENT_CARD_END,currentCard2);
			argMap.put(EngKeys.DATE_START,datePickerStartDate.getDate());
			
			List balances =(List)EngTXCommon.doSingleTX(CurBLSearchTransaction.class.getName(),"getCurrentBalances",argMap);
			if (currentCard2 == null)
			{
				parameters.put("showGeneralTotal", new Boolean(true));
			}
			else if (currentCard.getId().intValue() == currentCard2.getId().intValue())
			{
				parameters.put("showGeneralTotal", new Boolean(true));
			}
			else
			{
				parameters.put("showGeneralTotal", new Boolean(true));
			}
			HashMap balanceList = new HashMap();
			for (int k = 0; k < balances.size(); k++)
			{
				Object[] balanceArr = (Object[]) balances.get(k);
				balanceList.put((String) balanceArr[0], balanceArr);
			}
			parameters.put("balanceList", balanceList); //$NON-NLS-1$
			GenerateJasper(list, parameters);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void GenerateJasper(List list, Map parameters)
	{
		try
		{
			String[] fields = new String[]{"cards_current_code", "cards_name", "transaction_type_name", "transactions_date",
					"transactions_document_no", "transactions_total_credit", "transactions_total_dept", "current_transactions_id",
					"transactions_definition"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/current/CurrentCardAbstract.jrxml");//(JasperReport) JRLoader.loadObject("reports/current/CurrentCardAbstract.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
	
	public void printTable()
	{
	}
}