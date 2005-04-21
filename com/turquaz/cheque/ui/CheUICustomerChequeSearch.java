package com.turquaz.cheque.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CTabFolder;
import com.jasperassistant.designer.viewer.ViewerComposite;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import com.turquaz.cheque.CheKeys;
import com.turquaz.cheque.Messages;
import com.turquaz.cheque.bl.CheBLSearchCheques;
import com.turquaz.cheque.bl.CheBLUpdateCheque;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqChequeCheque;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Text;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CheUICustomerChequeSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compSearchPanle;
	private Text txtPortFoyNo;
	private ViewerComposite viewer;
	private Composite compReport;
	private CTabItem tabItemReport;
	private CTabItem cTabItem1;
	private CTabFolder tabFolder;
	private CurrentPicker currentPicker;
	private DatePicker datePickerEndEnterDate;
	private CLabel lblEnterDateEnd;
	private DatePicker datePickerStartEnterDate;
	private CLabel lblEnterDate;
	private TableColumn tableColumnCurrentCard;
	private DatePicker datePickerEndDueDate;
	private CLabel lblDueDateEnd;
	private TableColumn tableColumnStatus;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnDueDate;
	private TableColumn tableColumnEntryDate;
	private TableColumn tableColumnChequeNo;
	private Table tableCheques;
	private CLabel lblCurrentCard;
	private CCombo comboStatus;
	private CLabel lblStaus;
	private DatePicker datePickerStartDueDate;
	private CLabel lblDueDate;
	private CLabel lblPortfoyNo;
	private SearchTableViewer tableViewer = null;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public CheUICustomerChequeSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setBackground(SWTResourceManager.getColor(255, 255, 255));
			this.setSize(667, 412);
			//START >> compSearchPanle
			compSearchPanle = new Composite(this, SWT.NONE);
			GridLayout compSearchPanleLayout = new GridLayout();
			GridData compSearchPanleLData = new GridData();
			compSearchPanleLData.heightHint = 112;
			compSearchPanleLData.grabExcessHorizontalSpace = true;
			compSearchPanleLData.horizontalAlignment = GridData.FILL;
			compSearchPanle.setLayoutData(compSearchPanleLData);
			compSearchPanleLayout.numColumns = 4;
			compSearchPanle.setLayout(compSearchPanleLayout);
			//START >> lblPortfoyNo
			lblPortfoyNo = new CLabel(compSearchPanle, SWT.NONE);
			lblPortfoyNo.setText(Messages.getString("CheUICustomerChequeSearch.0")); //$NON-NLS-1$
			//END << lblPortfoyNo
			//START >> txtPortFoyNo
			txtPortFoyNo = new Text(compSearchPanle, SWT.NONE);
			GridData txtPortFoyNoLData = new GridData();
			txtPortFoyNoLData.widthHint = 155;
			txtPortFoyNoLData.heightHint = 16;
			txtPortFoyNo.setLayoutData(txtPortFoyNoLData);
			//END << txtPortFoyNo
			//START >> lblStaus
			lblStaus = new CLabel(compSearchPanle, SWT.NONE);
			lblStaus.setText(Messages.getString("CheUICustomerChequeSearch.1")); //$NON-NLS-1$
			//END << lblStaus
			//START >> comboStatus
			comboStatus = new CCombo(compSearchPanle, SWT.NONE);
			GridData comboStatusLData = new GridData();
			comboStatusLData.widthHint = 96;
			comboStatusLData.heightHint = 17;
			comboStatus.setLayoutData(comboStatusLData);
			comboStatus.setText(Messages.getString("CheUICustomerChequeSearch.2")); //$NON-NLS-1$
			comboStatus.add(Messages.getString("CheUICustomerChequeSearch.3")); //$NON-NLS-1$
			Iterator it = EngBLCommon.getChequeStatusMapWithStringKey().keySet().iterator();
			while (it.hasNext())
			{
				comboStatus.add(it.next().toString());
			}
			//END << comboStatus
			//START >> lblCurrentCard
			lblCurrentCard = new CLabel(compSearchPanle, SWT.NONE);
			lblCurrentCard.setText(Messages.getString("CheUICustomerChequeSearch.4")); //$NON-NLS-1$
			//END << lblCurrentCard
			//START >> currentPicker
			currentPicker = new CurrentPicker(compSearchPanle, SWT.NONE);
			GridData currentPickerLData = new GridData();
			currentPickerLData.widthHint = 348;
			currentPickerLData.heightHint = 16;
			currentPickerLData.horizontalSpan = 3;
			currentPicker.setLayoutData(currentPickerLData);
			//END << currentPicker
			//START >> lblDueDate
			lblDueDate = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDate.setText(Messages.getString("CheUICustomerChequeSearch.5")); //$NON-NLS-1$
			//END << lblDueDate
			//START >> datePickerStartDueDate
			datePickerStartDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerLData = new GridData();
			datePickerLData.widthHint = 137;
			datePickerLData.heightHint = 20;
			datePickerStartDueDate.setLayoutData(datePickerLData);
			datePickerStartDueDate.setFirstDayOfYear();
			//END << datePickerStartDueDate
			//START >> lblDueDateEnd
			lblDueDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblDueDateEnd.setText(Messages.getString("CheUICustomerChequeSearch.6")); //$NON-NLS-1$
			//END << lblDueDateEnd
			//START >> datePickerEndDueDate
			datePickerEndDueDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndLData = new GridData();
			datePickerEndLData.widthHint = 118;
			datePickerEndLData.heightHint = 20;
			datePickerEndDueDate.setLayoutData(datePickerEndLData);
			//END << datePickerEndDueDate
			//START >> lblEnterDate
			lblEnterDate = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDate.setText(Messages.getString("CheUICustomerChequeSearch.7")); //$NON-NLS-1$
			//END << lblEnterDate
			//START >> datePickerStartEnterDate
			datePickerStartEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerStartEnterDateLData = new GridData();
			datePickerStartEnterDateLData.widthHint = 137;
			datePickerStartEnterDateLData.heightHint = 20;
			datePickerStartEnterDate.setLayoutData(datePickerStartEnterDateLData);
			datePickerStartEnterDate.setFirstDayOfYear();
			//END << datePickerStartEnterDate
			//START >> lblEnterDateEnd
			lblEnterDateEnd = new CLabel(compSearchPanle, SWT.NONE);
			lblEnterDateEnd.setText(Messages.getString("CheUICustomerChequeSearch.8")); //$NON-NLS-1$
			//END << lblEnterDateEnd
			//START >> datePickerEndEnterDate
			datePickerEndEnterDate = new DatePicker(compSearchPanle, SWT.NONE);
			GridData datePickerEndEnterDateLData = new GridData();
			datePickerEndEnterDateLData.widthHint = 116;
			datePickerEndEnterDateLData.heightHint = 21;
			datePickerEndEnterDate.setLayoutData(datePickerEndEnterDateLData);
			//END << datePickerEndEnterDate
			//END << compSearchPanle
			//START >> tabFolder
			tabFolder = new CTabFolder(this, SWT.NONE);
			//START >> cTabItem1
			cTabItem1 = new CTabItem(tabFolder, SWT.NONE);
			cTabItem1.setText("Arama Sonucu");
			//START >> tableCheques
			tableCheques = new Table(tabFolder, SWT.SINGLE | SWT.FULL_SELECTION);
			cTabItem1.setControl(tableCheques);
			GridData tableChequesLData = new GridData();
			tableCheques.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableChequesMouseDoubleClick(evt);
				}
			});
			tableCheques.setLinesVisible(true);
			tableCheques.setHeaderVisible(true);
			tableChequesLData.horizontalAlignment = GridData.FILL;
			tableChequesLData.grabExcessHorizontalSpace = true;
			tableChequesLData.grabExcessVerticalSpace = true;
			tableChequesLData.verticalAlignment = GridData.FILL;
			tableCheques.setLayoutData(tableChequesLData);
			//START >> tableColumnChequeNo
			tableColumnChequeNo = new TableColumn(tableCheques, SWT.NONE);
			tableColumnChequeNo.setText(Messages.getString("CheUICustomerChequeSearch.9")); //$NON-NLS-1$
			tableColumnChequeNo.setWidth(76);
			//END << tableColumnChequeNo
			//START >> tableColumnEntryDate
			tableColumnEntryDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnEntryDate.setText(Messages.getString("CheUICustomerChequeSearch.10")); //$NON-NLS-1$
			tableColumnEntryDate.setWidth(90);
			//END << tableColumnEntryDate
			//START >> tableColumnCurrentCard
			tableColumnCurrentCard = new TableColumn(tableCheques, SWT.NONE);
			tableColumnCurrentCard.setText(Messages.getString("CheUICustomerChequeSearch.11")); //$NON-NLS-1$
			tableColumnCurrentCard.setWidth(122);
			//END << tableColumnCurrentCard
			//START >> tableColumnDueDate
			tableColumnDueDate = new TableColumn(tableCheques, SWT.NONE);
			tableColumnDueDate.setText(Messages.getString("CheUICustomerChequeSearch.12")); //$NON-NLS-1$
			tableColumnDueDate.setWidth(107);
			//END << tableColumnDueDate
			//START >> tableColumnStatus
			tableColumnStatus = new TableColumn(tableCheques, SWT.NONE);
			tableColumnStatus.setText("Son \u0130\u015flem");
			tableColumnStatus.setWidth(105);
			//END << tableColumnStatus
			//START >> tableColumnAmount
			tableColumnAmount = new TableColumn(tableCheques, SWT.RIGHT);
			tableColumnAmount.setText(Messages.getString("CheUICustomerChequeSearch.14")); //$NON-NLS-1$
			tableColumnAmount.setWidth(98);
			//END << tableColumnAmount
			//END << tableCheques
			GridData tabFolderLData = new GridData();
			tabFolderLData.grabExcessHorizontalSpace = true;
			tabFolderLData.horizontalAlignment = GridData.FILL;
			tabFolderLData.verticalAlignment = GridData.FILL;
			tabFolderLData.grabExcessVerticalSpace = true;
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
			viewerLData.grabExcessVerticalSpace = true;
			viewerLData.grabExcessHorizontalSpace = true;
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
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[6];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCheques, columnTypes, true);
	}

	public void delete()
	{
		
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableCheques);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCheques, Messages.getString("CheUICustomerChequeSearch.15")); //$NON-NLS-1$
	}

	public void search()
	{
		tableViewer.removeAll();
		try
		{
			Integer cheStat = null;
			Map map = EngBLCommon.getChequeStatusMapWithStringKey();
			if (map.containsKey(comboStatus.getText()))
			{
				cheStat = (Integer) map.get(comboStatus.getText());
			}
			
			HashMap argMap = new HashMap();
			argMap.put(EngKeys.DOCUMENT_NO,txtPortFoyNo.getText().trim());
			argMap.put(EngKeys.CURRENT_CARD,currentPicker.getData());
			argMap.put(CheKeys.CHE_STATUS,cheStat);
			argMap.put(CheKeys.CHE_START_ENTER_DATE,datePickerStartEnterDate.getDate());
			argMap.put(CheKeys.CHE_END_ENTER_DATE,datePickerEndEnterDate.getDate());
			argMap.put(CheKeys.CHE_START_DUE_DATE,datePickerStartDueDate.getDate());
			argMap.put(CheKeys.CHE_END_DUE_DATE,datePickerEndDueDate.getDate());
			
			
			List ls = (List)EngTXCommon.doSingleTX(CheBLSearchCheques.class.getName(),"searchCheque",argMap);
		
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal total = new BigDecimal(0);
			for (int i = 0; i < ls.size(); i++)
			{
				String status = ""; //$NON-NLS-1$
				Object result[] = (Object[]) ls.get(i);
				Map statusMap = EngBLCommon.getChequeTransMapWithIntegerKey();
				if (statusMap.containsKey(result[5]))
				{
					status = statusMap.get(result[5]).toString();
				}
				Integer id = (Integer) result[0];
				tableViewer.addRow(new String[]{result[1].toString(), DatePicker.formatter.format(result[2]), result[3].toString(),
						DatePicker.formatter.format(result[4]), status, cf.format(result[6])}, id);
				total = total.add((BigDecimal) result[6]);
			}
			tableViewer.addRow(new String[]{"", "", "", "", "", ""}, null);
			tableViewer.addRow(new String[]{"", "", "", "", "Toplam", cf.format(total)}, null);
			if (ls.size() > 0)
				GenerateJasper(ls);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void GenerateJasper(List list)
	{
		try
		{
			Map parameters = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			parameters.put("reportDate", sdf.format(Calendar.getInstance().getTime()));
			parameters.put("startDate", sdf.format(datePickerStartEnterDate.getDate()));
			parameters.put("endDate", sdf.format(datePickerEndEnterDate.getDate()));
			parameters.put("dueDateStart", sdf.format(datePickerStartDueDate.getDate()));
			parameters.put("dueDateEnd", sdf.format(datePickerEndDueDate.getDate()));
			parameters.put("dateFormatter", sdf);
			parameters.put("currenyFormatter", cf);
			String[] fields = new String[]{"id", "cheques_portfolio_no", "cheque_rolls_date", "cards_name", "cheques_due_date",
					"cheque_transaction_types_id", "cheques_amount", "transaction_typs_name"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/cheque/CustomerChequeReport.jrxml");
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/cheque/CustomerChequeReport.jasper"); //$NON-NLS-1$
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

	private void tableChequesMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem[] selection = tableCheques.getSelection();
			if (selection.length > 0)
			{
				Integer cheqId = (Integer) ((ITableRow) selection[0].getData()).getDBObject();
				if (cheqId != null)
				{
					HashMap argMap = new HashMap();
					argMap.put(CheKeys.CHE_CHEQUE,cheqId);
					
					TurqChequeCheque cheque = (TurqChequeCheque)EngTXCommon.doSingleTX(CheBLUpdateCheque.class.getName(),"initCheque",argMap);
					
					boolean isUpdated = new CheUICustomerChequeUpdate(getShell(), SWT.NULL, cheque).open();
					if (isUpdated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}
}