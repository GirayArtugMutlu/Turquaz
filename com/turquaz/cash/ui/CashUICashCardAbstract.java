package com.turquaz.cash.ui;

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
 * @author  Onsel
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import org.eclipse.swt.layout.GridLayout;
import com.turquaz.cash.Messages;
import com.turquaz.cash.bl.CashBLCashTransactionSearch;
import com.turquaz.cash.ui.comp.CashCardPicker;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCashCard;
import com.turquaz.engine.dal.TurqCashTransaction;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CashUICashCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CashCardPicker cashCardPicker;
	private Composite compReport;
	private Composite compSearchPanel;
	private CTabItem cTabItem1;
	private DatePicker datePicker;
	private DatePicker datePickerEndDate;
	private CLabel lblCashCard;
	private CLabel lblEndDate;
	private CLabel lblStartDate;
	private CTabFolder tabFolder;
	private CTabItem tabItemReport;
	private Table tableCashTrans;
	private TableColumn tableColumnCashCode;
	private TableColumn tableColumnCollect;
	private TableColumn tableColumnDate;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnPayment;
	private TableColumn tableColumnType;
	private ViewerComposite viewer;
	private SearchTableViewer tableViewer=null;

	public CashUICashCardAbstract(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}
	
	public void createTableViewer()
	{
		int columnTypes[] = new int[6];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCashTrans, columnTypes,true);
	}

	public void delete()
	{
		//TODO should be implemented..
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableCashTrans);
	}

	public void GenerateJasper(List list, List deferred)
	{
		try
		{
			Map parameters = new HashMap();
			if (deferred.size() != 0)
			{
				Object[] amounts = (Object[]) deferred.get(0);
				parameters.put("initialDept", (BigDecimal) amounts[0]);
				parameters.put("initialCredit", (BigDecimal) amounts[1]);
			}
			else
			{
				parameters.put("initialDept", new BigDecimal(0));
				parameters.put("initialCredit", new BigDecimal(0));
			}
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			parameters.put("reportDate", sdf.format(Calendar.getInstance().getTime()));
			parameters.put("startDate", sdf.format(datePicker.getDate()));
			parameters.put("endDate", sdf.format(datePickerEndDate.getDate()));
			parameters.put("dateFormatter", sdf);
			parameters.put("currencyFormatter", new TurkishCurrencyFormat());
			parameters.put("cashCardName", ((TurqCashCard) cashCardPicker.getData()).getCashCardName());
			String[] fields = new String[]{"id", "transaction_date", "transaction_definition", "dept_amount", "credit_amount",
					"cash_transaction_type_name"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/cash/CashCardAbstract.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(631, 395);
			{
				compSearchPanel = new Composite(this, SWT.NONE);
				GridLayout compSearchPanelLayout = new GridLayout();
				compSearchPanelLayout.numColumns = 2;
				GridData compSearchPanelLData = new GridData();
				compSearchPanelLData.heightHint = 84;
				compSearchPanelLData.grabExcessHorizontalSpace = true;
				compSearchPanelLData.horizontalAlignment = GridData.FILL;
				compSearchPanel.setLayoutData(compSearchPanelLData);
				compSearchPanel.setLayout(compSearchPanelLayout);
				{
					lblCashCard = new CLabel(compSearchPanel, SWT.NONE);
					lblCashCard.setText(Messages.getString("CashUICashCardAbstract.0")); //$NON-NLS-1$
				}
				{
					cashCardPicker = new CashCardPicker(compSearchPanel, SWT.NONE);
					GridData cashCardPickerLData = new GridData();
					cashCardPickerLData.widthHint = 157;
					cashCardPickerLData.heightHint = 17;
					cashCardPicker.setLayoutData(cashCardPickerLData);
				}
				{
					lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
					lblStartDate.setText(Messages.getString("CashUICashCardAbstract.1")); //$NON-NLS-1$
				}
				{
					datePicker = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePickerLData = new GridData();
					datePickerLData.widthHint = 157;
					datePickerLData.heightHint = 23;
					datePicker.setLayoutData(datePickerLData);
				}
				{
					lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
					lblEndDate.setText(Messages.getString("CashUICashCardAbstract.2")); //$NON-NLS-1$
				}
				{
					datePickerEndDate = new DatePicker(compSearchPanel, SWT.NONE);
					GridData datePickerEndDateLData = new GridData();
					datePickerEndDateLData.widthHint = 157;
					datePickerEndDateLData.heightHint = 23;
					datePickerEndDate.setLayoutData(datePickerEndDateLData);
				}
			}
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> cTabItem1
			cTabItem1 = new CTabItem(tabFolder, SWT.NONE);
			cTabItem1.setText("Arama Sonucu");
			{
				tableCashTrans = new Table(tabFolder, SWT.FULL_SELECTION);
				cTabItem1.setControl(tableCashTrans);
				GridData tableCashTransLData = new GridData();
				tableCashTrans.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableCashTransMouseDoubleClick(evt);
					}
				});
				tableCashTrans.setHeaderVisible(true);
				tableCashTrans.setLinesVisible(true);
				tableCashTransLData.grabExcessHorizontalSpace = true;
				tableCashTransLData.horizontalAlignment = GridData.FILL;
				tableCashTransLData.grabExcessVerticalSpace = true;
				tableCashTransLData.verticalAlignment = GridData.FILL;
				tableCashTrans.setLayoutData(tableCashTransLData);
				{
					tableColumnDate = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnDate.setText(Messages.getString("CashUICashCardAbstract.3")); //$NON-NLS-1$
					tableColumnDate.setWidth(67);
				}
				{
					tableColumnCashCode = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnCashCode.setText(Messages.getString("CashUICashCardAbstract.4")); //$NON-NLS-1$
					tableColumnCashCode.setWidth(70);
				}
				//START >> tableColumnType
				tableColumnType = new TableColumn(tableCashTrans, SWT.NONE);
				tableColumnType.setText("Tipi");
				tableColumnType.setWidth(60);
				//END << tableColumnType
				{
					tableColumnDefinition = new TableColumn(tableCashTrans, SWT.NONE);
					tableColumnDefinition.setText(Messages.getString("CashUICashCardAbstract.5")); //$NON-NLS-1$
					tableColumnDefinition.setWidth(183);
				}
				{
					tableColumnCollect = new TableColumn(tableCashTrans, SWT.RIGHT);
					tableColumnCollect.setText(Messages.getString("CashUICashCardAbstract.6")); //$NON-NLS-1$
					tableColumnCollect.setWidth(100);
				}
				{
					tableColumnPayment = new TableColumn(tableCashTrans, SWT.RIGHT);
					tableColumnPayment.setText(Messages.getString("CashUICashCardAbstract.7")); //$NON-NLS-1$
					tableColumnPayment.setWidth(100);
				}
			}
			GridData tabFolderLData = new GridData();
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.grabExcessVerticalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolder.setLayoutData(tabFolderLData);
			//END << cTabItem1
			//START >> tabItemReport
			tabItemReport = new CTabItem(tabFolder, SWT.NONE);
			tabItemReport.setText("Rapor");
			//START >> compReport
			compReport = new Composite(tabFolder, SWT.NONE);
			GridLayout compReportLayout = new GridLayout();
			compReportLayout.makeColumnsEqualWidth = true;
			compReport.setLayout(compReportLayout);
			tabItemReport.setControl(compReport);
			//START >> viewer
			viewer = new ViewerComposite(compReport, SWT.NONE);
			GridData viewerLData = new GridData();
			viewerLData.grabExcessHorizontalSpace = true;
			viewerLData.grabExcessVerticalSpace = true;
			viewerLData.horizontalAlignment = GridData.FILL;
			viewerLData.verticalAlignment = GridData.FILL;
			viewer.setLayoutData(viewerLData);
			//END << viewer
			//END << compReport
			tabFolder.setSelection(0);
			//END << tabItemReport
			//END << tabFolder
			this.layout();
			PostInitGui();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void PostInitGui()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		datePicker.setDate(cal.getTime());
		createTableViewer();
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCashTrans, Messages.getString("CashUICashCardAbstract.9")); //$NON-NLS-1$
	}

	public void search()
	{
		try
		{
			if (verifyFields())
			{
				tableViewer.removeAll();
				TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
				BigDecimal total_dept = new BigDecimal(0);
				BigDecimal total_credit = new BigDecimal(0);
				BigDecimal deferred_dept = new BigDecimal(0);
				BigDecimal deferred_credit = new BigDecimal(0);
				List deferred = CashBLCashTransactionSearch.getDeferredTotal((TurqCashCard) cashCardPicker.getData(), datePicker
						.getDate());
				if (deferred.size() != 0)
				{
					Object[] amounts = (Object[]) deferred.get(0);
					deferred_dept = deferred_dept.add((BigDecimal) amounts[0]);
					deferred_credit = deferred_credit.add((BigDecimal) amounts[1]);
				}
				List ls = CashBLCashTransactionSearch.getTransactions((TurqCashCard) cashCardPicker.getData(), datePicker.getDate(),
						datePickerEndDate.getDate());
				BigDecimal credit;
				BigDecimal dept;
				for (int i = 0; i < ls.size(); i++)
				{
					credit = new BigDecimal(0);
					dept = new BigDecimal(0);
					Object results[] = (Object[]) ls.get(i);
					if (results[3] != null)
					{
						dept = (BigDecimal) results[3];
					}
					if (results[4] != null)
					{
						credit = (BigDecimal) results[4];
					}
					Integer id=(Integer)results[0];
					tableViewer.addRow(new String[]{DatePicker.formatter.format((Date) results[1]),
							cashCardPicker.getTurqCashCard().getCashCardName(), results[5].toString(), results[2].toString(),
							cf.format(dept), cf.format(credit)},id);
					
					total_dept = total_dept.add(dept);
					total_credit = total_credit.add(credit);
				}
				tableViewer.addRow(new String[]{"","","","","",""},null);
				tableViewer.addRow(new String[]{"","","",Messages.getString("CashUICashCardAbstract.18"), //$NON-NLS-1$
						cf.format(total_dept), cf.format(total_credit)},null);
				tableViewer.addRow(new String[]{"","","", Messages.getString("CashUICashCardAbstract.21"), //$NON-NLS-1$
						cf.format(deferred_dept), cf.format(deferred_credit)},null);
				
				BigDecimal finalDept=deferred_dept.add(total_dept);
				BigDecimal finalCredit=deferred_credit.add(total_credit);
				tableViewer.addRow(new String[]{"","","", Messages.getString("CashUICashCardAbstract.24"), //$NON-NLS-1$
						cf.format(finalDept), cf.format(finalCredit)},null);
				BigDecimal finalBalance=finalCredit.subtract(finalDept);
				if (finalBalance.doubleValue()>0)
					tableViewer.addRow(new String[]{"","","",Messages.getString("CashUICashCardDailyAbstract.16"),"",cf.format(finalBalance)},null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				else
					tableViewer.addRow(new String[]{"","","",Messages.getString("CashUICashCardDailyAbstract.20"),cf.format(finalBalance.abs()),""},null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
				GenerateJasper(ls, deferred);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	private void tableCashTransMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem selection[] = tableCashTrans.getSelection();
			if (selection.length > 0)
			{
				TableItem item = selection[0];
				Integer id = (Integer)((ITableRow) item.getData()).getDBObject();
				if (id == null)
				{
					return;
				}
				TurqCashTransaction cashTrans = CashBLCashTransactionSearch.initializeCashTransaction(id);
				if (cashTrans.getTurqEngineSequence().getTurqModule().getId().intValue() != EngBLCommon.MODULE_CASH)
				{
					EngUICommon.showMessageBox(this.getShell(), Messages.getString("CashUICashTransactionSearch.7")); //$NON-NLS-1$
					return;
				}
				boolean updated = false;
				if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_COLLECT)
				{
					updated = new CashUICashCollectTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_CURRENT_PAYMENT)
				{
					updated = new CashUICashPaymentTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_COLLECT)
				{
					updated = new CashUICashOtherCollectTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_OTHER_PAYMENT)
				{
					updated = new CashUICashOtherPaymentTransactionUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				else if (cashTrans.getTurqCashTransactionType().getId().intValue() == EngBLCommon.CASH_TRANSFER_BETWEEN_CARDS)
				{
					updated = new CashUICashTransferBetweenCardsUpdate(this.getShell(), SWT.NULL, cashTrans).open();
				}
				if (updated)
					search();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public boolean verifyFields()
	{
		if (cashCardPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(), Messages.getString("CashUICashCardAbstract.8")); //$NON-NLS-1$
			cashCardPicker.setFocus();
			return false;
		}
		return true;
	}
}