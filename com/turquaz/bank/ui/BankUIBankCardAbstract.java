package com.turquaz.bank.ui;

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
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLTransactionSearch;
import com.turquaz.bank.ui.comp.BankCardPicker;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIBankCardAbstract extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Calendar cal = Calendar.getInstance();
	private CLabel lblBankCard;
	private ViewerComposite viewer;
	private Composite compViewer;
	private CTabItem tabItemReport;
	private TableColumn tableColumnBalanceCredit;
	private TableColumn tableColumnBalanceDept;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnTransType;
	private TableColumn tableColumnDate;
	private Table tableAbstract;
	private Composite compDesign;
	private CTabItem tabItemSearch;
	private CTabFolder tabFolder;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private BankCardPicker bankPicker;
	private Composite compSearchPanel;
	SearchTableViewer tableViewer = null;

	public BankUIBankCardAbstract(org.eclipse.swt.widgets.Composite parent, int style)
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
			thisLayout.horizontalSpacing = 0;
			thisLayout.marginWidth = 0;
			thisLayout.verticalSpacing = 0;
			thisLayout.marginHeight = 0;
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(659, 387);
			//START >> compSearchPanel
			compSearchPanel = new Composite(this, SWT.NONE);
			GridLayout compSearchPanelLayout = new GridLayout();
			compSearchPanelLayout.numColumns = 2;
			GridData compSearchPanelLData = new GridData();
			compSearchPanelLData.horizontalAlignment = GridData.FILL;
			compSearchPanelLData.verticalAlignment = GridData.FILL;
			compSearchPanel.setLayoutData(compSearchPanelLData);
			compSearchPanel.setLayout(compSearchPanelLayout);
			//START >> lblBankCard
			lblBankCard = new CLabel(compSearchPanel, SWT.NONE);
			lblBankCard.setText(Messages.getString("BankUIBankCardAbstract.0")); //$NON-NLS-1$
			//END << lblBankCard
			//START >> bankPicker
			bankPicker = new BankCardPicker(compSearchPanel, SWT.NONE);
			GridData bankPickerLData = new GridData();
			bankPickerLData.widthHint = 157;
			bankPickerLData.heightHint = 17;
			bankPicker.setLayoutData(bankPickerLData);
			//END << bankPicker
			//START >> lblStartDate
			lblStartDate = new CLabel(compSearchPanel, SWT.NONE);
			lblStartDate.setText(Messages.getString("BankUIBankCardAbstract.1")); //$NON-NLS-1$
			//END << lblStartDate
			//START >> dateStartDate
			dateStartDate = new DatePicker(compSearchPanel, SWT.NONE);
			GridData dateStartDateLData = new GridData();
			dateStartDateLData.widthHint = 157;
			dateStartDateLData.heightHint = 23;
			dateStartDate.setLayoutData(dateStartDateLData);
			//END << dateStartDate
			//START >> lblEndDate
			lblEndDate = new CLabel(compSearchPanel, SWT.NONE);
			lblEndDate.setText(Messages.getString("BankUIBankCardAbstract.2")); //$NON-NLS-1$
			//END << lblEndDate
			//START >> dateEndDate
			dateEndDate = new DatePicker(compSearchPanel, SWT.NONE);
			GridData dateEndDateLData = new GridData();
			dateEndDateLData.widthHint = 157;
			dateEndDateLData.heightHint = 23;
			dateEndDate.setLayoutData(dateEndDateLData);
			//END << dateEndDate
			//END << compSearchPanel
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> tabItemSearch
			tabItemSearch = new CTabItem(tabFolder, SWT.NONE);
			tabItemSearch.setText("Arama");
			//START >> compDesign
			compDesign = new Composite(tabFolder, SWT.NONE);
			tabItemSearch.setControl(compDesign);
			GridLayout compDesignLayout = new GridLayout();
			compDesignLayout.makeColumnsEqualWidth = true;
			compDesign.setLayout(compDesignLayout);
			//START >> tableAbstract
			tableAbstract = new Table(compDesign, SWT.SINGLE | SWT.FULL_SELECTION);
			tableAbstract.setLinesVisible(true);
			tableAbstract.setHeaderVisible(true);
			GridData tableAbstractLData = new GridData();
			tableAbstractLData.verticalAlignment = GridData.FILL;
			tableAbstractLData.horizontalAlignment = GridData.FILL;
			tableAbstractLData.grabExcessVerticalSpace = true;
			tableAbstractLData.grabExcessHorizontalSpace = true;
			tableAbstract.setLayoutData(tableAbstractLData);
			//START >> tableColumnDate
			tableColumnDate = new TableColumn(tableAbstract, SWT.NONE);
			tableColumnDate.setText(Messages.getString("BankUIBankCardAbstract.3")); //$NON-NLS-1$
			tableColumnDate.setWidth(83);
			//END << tableColumnDate
			//START >> tableColumnTransType
			tableColumnTransType = new TableColumn(tableAbstract, SWT.NONE);
			tableColumnTransType.setText("HareketTipi");
			tableColumnTransType.setWidth(97);
			//END << tableColumnTransType
			//START >> tableColumnDefinition
			tableColumnDefinition = new TableColumn(tableAbstract, SWT.NONE);
			tableColumnDefinition.setText(Messages.getString("BankUIBankCardAbstract.5")); //$NON-NLS-1$
			tableColumnDefinition.setWidth(110);
			//END << tableColumnDefinition
			//START >> tableColumnDebit
			tableColumnDebit = new TableColumn(tableAbstract, SWT.RIGHT);
			tableColumnDebit.setText(Messages.getString("BankUIBankCardAbstract.6")); //$NON-NLS-1$
			tableColumnDebit.setWidth(62);
			//END << tableColumnDebit
			//START >> tableColumnCredit
			tableColumnCredit = new TableColumn(tableAbstract, SWT.RIGHT);
			tableColumnCredit.setText(Messages.getString("BankUIBankCardAbstract.7")); //$NON-NLS-1$
			tableColumnCredit.setWidth(67);
			//END << tableColumnCredit
			//START >> tableColumnBalanceDept
			tableColumnBalanceDept = new TableColumn(tableAbstract, SWT.RIGHT);
			tableColumnBalanceDept.setText("Bakiye Borç");
			tableColumnBalanceDept.setWidth(84);
			//END << tableColumnBalanceDept
			//START >> tableColumnBalanceCredit
			tableColumnBalanceCredit = new TableColumn(tableAbstract, SWT.RIGHT);
			tableColumnBalanceCredit.setText("Bakiye Alacak");
			tableColumnBalanceCredit.setWidth(84);
			//END << tableColumnBalanceCredit
			//END << tableAbstract
			//END << compDesign
			GridData tabFolderLData = new GridData();
			tabFolder.setSelection(0);
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.grabExcessVerticalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolder.setLayoutData(tabFolderLData);
			//END << tabItemSearch
			//START >> tabItemReport
			tabItemReport = new CTabItem(tabFolder, SWT.NONE);
			tabItemReport.setText("Rapor");
			tabFolder.setSelection(0);
			//START >> compViewer
			compViewer = new Composite(tabFolder, SWT.NONE);
			tabItemReport.setControl(compViewer);
			GridLayout compViewerLayout = new GridLayout();
			compViewerLayout.makeColumnsEqualWidth = true;
			compViewer.setLayout(compViewerLayout);
			//START >> viewer
			viewer = new ViewerComposite(compViewer, SWT.NONE);
			GridData viewerLData = new GridData();
			viewerLData.grabExcessVerticalSpace = true;
			viewerLData.grabExcessHorizontalSpace = true;
			viewerLData.horizontalAlignment = GridData.FILL;
			viewerLData.verticalAlignment = GridData.FILL;
			viewer.setLayoutData(viewerLData);
			//END << viewer
			//END << compViewer
			//END << tabItemReport
			//END << tabFolder
			this.layout();
			PostInit();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[7];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableAbstract, columnTypes, false);
	}

	public void PostInit()
	{
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		createTableViewer();
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableAbstract);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableAbstract, Messages.getString("BankUIBankCardAbstract.9")); //$NON-NLS-1$
	}

	public boolean verifyFields()
	{
		if (bankPicker.getData() == null)
		{
			EngUICommon.showMessageBox(getShell(), Messages.getString("BankUIBankCardAbstract.8"), SWT.ICON_WARNING); //$NON-NLS-1$
			bankPicker.setFocus();
			return false;
		}
		return true;
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
				BigDecimal balance = new BigDecimal(0);
				TurqBanksCard bankCard = (TurqBanksCard) bankPicker.getData();
				List deferred = BankBLTransactionSearch.getDeferredTotal(bankCard, dateStartDate.getDate());
				Map parameters = new HashMap();
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				parameters.put("reportDate", dateFormatter.format(Calendar.getInstance().getTime()));
				parameters.put("startDate", dateFormatter.format(dateStartDate.getDate()));
				parameters.put("endDate", dateFormatter.format(dateEndDate.getDate()));
				parameters.put("dateFormat", dateFormatter);
				parameters.put("currencyFormat", new TurkishCurrencyFormat());
				parameters.put("bankName", bankCard.getBankName());
				parameters.put("bankBranchName", bankCard.getBankBranchName());
				parameters.put("bankAccountNo", bankCard.getBankAccountNo());
				if (deferred.size() != 0)
				{
					Object[] amounts = (Object[]) deferred.get(0);
					parameters.put("initialDept", (BigDecimal) amounts[0]);
					parameters.put("initialCredit", (BigDecimal) amounts[1]);
					parameters.put("initialBalance", ((BigDecimal) amounts[1]).subtract((BigDecimal) amounts[0]));
					deferred_dept = deferred_dept.add((BigDecimal) amounts[0]);
					deferred_credit = deferred_credit.add((BigDecimal) amounts[1]);
					balance = deferred_dept.subtract(deferred_credit);
					if (balance.doubleValue() > 0)
					{
						tableViewer
								.addRow(
										new String[]{
												"", "", Messages.getString("BankUIBankCardAbstract.11"), cf.format(amounts[0]), cf.format(amounts[1]), cf.format(balance), cf.format(new BigDecimal(0)) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
										}, null);
					}
					else
					{
						tableViewer
								.addRow(
										new String[]{
												"", "", Messages.getString("BankUIBankCardAbstract.11"), cf.format(amounts[0]), cf.format(amounts[1]), cf.format(new BigDecimal(0)), cf.format(balance.negate()) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
										}, null);
					}
				}
				else
				{
					tableViewer
							.addRow(
									new String[]{
											"", "", Messages.getString("BankUIBankCardAbstract.14"), cf.format(0), cf.format(0), cf.format(0), cf.format(0) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
									}, null);
					parameters.put("initialDept", new BigDecimal(0));
					parameters.put("initialCredit", new BigDecimal(0));
					parameters.put("initialBalance", new BigDecimal(0));
				}
				List ls = BankBLTransactionSearch.getTransactions((TurqBanksCard) bankPicker.getData(), dateStartDate.getDate(),
						dateEndDate.getDate());
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
					total_dept = total_dept.add(dept);
					total_credit = total_credit.add(credit);
					balance = balance.add(dept).subtract(credit);
					if (balance.doubleValue() > 0)
					{
						tableViewer.addRow(new String[]{DatePicker.formatter.format((Date) results[0]), results[5].toString(),
								results[2].toString(), cf.format(dept), cf.format(credit), cf.format(balance), cf.format(0)}, null);
					}
					else
					{
						tableViewer.addRow(new String[]{DatePicker.formatter.format((Date) results[0]), results[5].toString(),
								results[2].toString(), cf.format(dept), cf.format(credit), cf.format(0),
								cf.format(balance.negate())}, null);
					}
				}
				tableViewer.addRow(new String[]{"", "", "", "", "", "", ""}, null);
				String balance_dept = "";
				String balance_credit = "";
				if (total_dept.subtract(total_credit).doubleValue() > 0)
				{
					balance_dept = cf.format(total_dept.subtract(total_credit));
					balance_credit = cf.format(0);
				}
				else
				{
					balance_credit = cf.format(total_dept.subtract(total_credit).negate());
					balance_dept = cf.format(0);
				}
				tableViewer.addRow(new String[]{"", //$NON-NLS-1$
						"", //$NON-NLS-1$
						Messages.getString("BankUIBankCardAbstract.17"), //$NON-NLS-1$
						cf.format(total_dept), cf.format(total_credit), balance_dept, balance_credit}, null);
				if (balance.doubleValue() > 0)
				{
					balance_dept = cf.format(balance);
					balance_credit = cf.format(0);
				}
				else
				{
					balance_credit = cf.format(balance.negate());
					balance_dept = cf.format(0);
				}
				tableViewer.addRow(new String[]{"", //$NON-NLS-1$
						"", //$NON-NLS-1$
						Messages.getString("BankUIBankCardAbstract.20"), //$NON-NLS-1$
						cf.format(deferred_dept), cf.format(deferred_credit), balance_dept, balance_credit}, null);
				BigDecimal grand_total_dept = deferred_dept.add(total_dept);
				BigDecimal grand_total_credit = deferred_credit.add(total_credit);
				if (grand_total_dept.subtract(grand_total_credit).doubleValue() > 0)
				{
					balance_dept = cf.format(grand_total_dept.subtract(grand_total_credit));
					balance_credit = cf.format(0);
				}
				else
				{
					balance_credit = cf.format(grand_total_dept.subtract(grand_total_credit).negate());
					balance_dept = cf.format(0);
				}
				tableViewer.addRow(new String[]{"", //$NON-NLS-1$
						"", //$NON-NLS-1$
						Messages.getString("BankUIBankCardAbstract.23"), //$NON-NLS-1$
						cf.format(grand_total_dept), cf.format(grand_total_credit), balance_dept, balance_credit}, null);
				//REPORT PART
				if (ls.size() > 0)
				{
					GenerateJasper(ls, parameters);
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			EngUICommon.showMessageBox(getShell(), ex.getMessage().toString(), SWT.ICON_ERROR);
		}
	}

	public void GenerateJasper(List list, Map parameters)
	{
		try
		{
			String[] fields = new String[]{"transaction_bill_date", " bank_code", "transaction_bill_definition", "dept_amount",
					"credit_amount", "transaction_type_name", "id"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/bank/BankCardAbstract.jasper"); //$NON-NLS-1$
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
}