package com.turquaz.bill.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.eclipse.swt.layout.GridLayout;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;


import org.eclipse.swt.widgets.TableItem;

import org.eclipse.swt.widgets.Composite;

import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TableSorter;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CTabFolder;
import com.jasperassistant.designer.viewer.ViewerComposite;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.SWT;



import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import com.turquaz.current.ui.comp.CurrentCodePicker;
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
public class BillUIBillReport extends org.eclipse.swt.widgets.Composite implements SearchComposite{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	private BillBLSearchBill blSearch = new BillBLSearchBill();
	private Calendar cal=Calendar.getInstance();
	private Composite composite1;
	private CurrentCodePicker txtCurCardEnd;
	private ToolBar toolBar1;
	private BillUIAddBill compAddBill;
	private ViewerComposite viewer;
	private Composite compReport;
	private CTabItem tabItemReport;
	private CTabItem cTabItem1;
	private CTabFolder tabFolderReport;
	private TableColumn tableColumnCurrentCode;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnDocNo;
	private TableColumn tableColumnConsignmentDate;
	private Table tableBills;
	private CCombo comboBillType;
	private CLabel lblType;
	private Text txtDocNoEnd;
	private CLabel lblDocNoEnd;
	private Text txtDocNoStart;
	private CLabel lblDocNo;
	private CurrencyText txtMaxInvoiceTotal;
	private CLabel lblMaxInvoiceTotal;
	private CurrencyText txtMinInvoiceTotal;
	private CLabel lblMinInvoiceTotal;
	private DatePicker dateDueDateEnd;
	private CLabel lblDueDateEnd;
	private DatePicker dateDueDateStart;
	private CLabel lblDueDateStart;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurCardEnd;
	private CurrentCodePicker txtCurCardStart;
	private CLabel lblCurrentCard;
	
	private CTabFolder compView;
	private ToolItem toolItemForward;
	private ToolItem toolItemBack;
	private ToolItem toolPrint;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private Composite composite2;
	private CTabItem tabItemView;
	private CTabItem cTabItem2;
	private List list=null;
	private TurqBill bill=null;
	private int currentIndex=0;
	private ConBLUpdateConsignment blUpdateCons = new ConBLUpdateConsignment();
	private BillBLUpdateBill blUpdateBill = new BillBLUpdateBill();

	public BillUIBillReport(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(661, 571);
			//START >>  compView
			compView = new CTabFolder(this, SWT.NONE);
			//START >>  cTabItem2
			cTabItem2 = new CTabItem(compView, SWT.NONE);
			cTabItem2.setText("Arama");
			{
				composite1 = new Composite(compView, SWT.NONE);
				cTabItem2.setControl(composite1);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 156;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(Messages
						.getString("BillUIBillReport.12")); //$NON-NLS-1$
				}
				{
					txtCurCardStart = new CurrentCodePicker(
						composite1,
						SWT.NONE);
					GridData txtCurCardLData = new GridData();
					GridData txtCurCardStartLData = new GridData();
					txtCurCardStartLData.widthHint = 156;
					txtCurCardStartLData.heightHint = 17;
					txtCurCardStart.setLayoutData(txtCurCardStartLData);
				}
				{
					lblCurCardEnd = new CLabel(composite1, SWT.NONE);
					lblCurCardEnd.setText(Messages
						.getString("BillUIBillReport.0")); //$NON-NLS-1$
				}
				{
					txtCurCardEnd = new CurrentCodePicker(composite1, SWT.NONE);
					GridData txtCurCardEndLData = new GridData();
					txtCurCardEndLData.widthHint = 156;
					txtCurCardEndLData.heightHint = 17;
					txtCurCardEnd.setLayoutData(txtCurCardEndLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.1")); //$NON-NLS-1$
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					GridData dateStartDateLData1 = new GridData();
					dateStartDateLData1.widthHint = 156;
					dateStartDateLData1.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData1);

				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.2")); //$NON-NLS-1$
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 156;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblDueDateStart = new CLabel(composite1, SWT.NONE);
					lblDueDateStart.setText(Messages
						.getString("BillUIBillReport.1")); //$NON-NLS-1$
				}
				{
					dateDueDateStart = new DatePicker(composite1, SWT.NONE);
					GridData dateDueDateStartLData = new GridData();
					dateDueDateStartLData.widthHint = 156;
					dateDueDateStartLData.heightHint = 20;
					dateDueDateStart.setLayoutData(dateDueDateStartLData);
				}
				{
					lblDueDateEnd = new CLabel(composite1, SWT.NONE);
					lblDueDateEnd.setText(Messages
						.getString("BillUIBillReport.2")); //$NON-NLS-1$
				}
				{
					dateDueDateEnd = new DatePicker(composite1, SWT.NONE);
					GridData dateDueDateEndLData = new GridData();
					dateDueDateEndLData.widthHint = 156;
					dateDueDateEndLData.heightHint = 22;
					dateDueDateEnd.setLayoutData(dateDueDateEndLData);
				}
				{
					lblMinInvoiceTotal = new CLabel(composite1, SWT.NONE);
					lblMinInvoiceTotal.setText(Messages
						.getString("BillUIBillReport.3")); //$NON-NLS-1$
				}
				{
					txtMinInvoiceTotal = new CurrencyText(composite1, SWT.NONE);
					GridData txtMinInvoiceTotalLData = new GridData();
					txtMinInvoiceTotalLData.widthHint = 150;
					txtMinInvoiceTotalLData.heightHint = 17;
					txtMinInvoiceTotal.setLayoutData(txtMinInvoiceTotalLData);
				}
				{
					lblMaxInvoiceTotal = new CLabel(composite1, SWT.NONE);
					lblMaxInvoiceTotal.setText(Messages
						.getString("BillUIBillReport.4")); //$NON-NLS-1$
				}
				{
					txtMaxInvoiceTotal = new CurrencyText(composite1, SWT.NONE);
					GridData txtMaxInvoiceTotalLData = new GridData();
					txtMaxInvoiceTotalLData.widthHint = 150;
					txtMaxInvoiceTotalLData.heightHint = 17;
					txtMaxInvoiceTotal.setLayoutData(txtMaxInvoiceTotalLData);
				}
				{
					lblDocNo = new CLabel(composite1, SWT.NONE);
					lblDocNo.setText(Messages.getString("BillUIBillReport.5")); //$NON-NLS-1$
				}
				{
					txtDocNoStart = new Text(composite1, SWT.NONE);
					GridData txtDocNoLData = new GridData();
					GridData txtDocNoStartLData = new GridData();
					txtDocNoStartLData.widthHint = 150;
					txtDocNoStartLData.heightHint = 17;
					txtDocNoStart.setLayoutData(txtDocNoStartLData);
				}
				{
					lblDocNoEnd = new CLabel(composite1, SWT.NONE);
					lblDocNoEnd.setText(Messages
						.getString("BillUIBillReport.6")); //$NON-NLS-1$
				}
				{
					txtDocNoEnd = new Text(composite1, SWT.NONE);
					GridData txtDocNoEndLData = new GridData();
					txtDocNoEndLData.widthHint = 150;
					txtDocNoEndLData.heightHint = 17;
					txtDocNoEnd.setLayoutData(txtDocNoEndLData);
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(com.turquaz.bill.Messages
						.getString("BillUIBillSearch.3")); //$NON-NLS-1$
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(Messages
						.getString("BillUIBillReport.11")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 130;
					comboConsignmentTypeLData.heightHint = 14;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
				}
				//START >>  tabFolderReport
				tabFolderReport = new CTabFolder(composite1, SWT.NONE);
				//START >>  cTabItem1
				cTabItem1 = new CTabItem(tabFolderReport, SWT.NONE);
				cTabItem1.setText("Arama Sonucu");
				{
					tableBills = new Table(tabFolderReport, SWT.FULL_SELECTION);
					cTabItem1.setControl(tableBills);
					GridData tableConsignmentsLData = new GridData();
					tableBills.addMouseListener(new MouseAdapter() {
						public void mouseDoubleClick(MouseEvent evt) {
							tableMouseDoubleClick();
						}
					});
					tableBills.setHeaderVisible(true);
					tableBills.setLinesVisible(true);
					tableConsignmentsLData.grabExcessHorizontalSpace = true;
					tableConsignmentsLData.horizontalAlignment = GridData.FILL;
					tableConsignmentsLData.verticalAlignment = GridData.FILL;
					tableConsignmentsLData.grabExcessVerticalSpace = true;
					tableBills.setLayoutData(tableConsignmentsLData);
					{
						tableColumnConsignmentDate = new TableColumn(
							tableBills,
							SWT.NONE);
						tableColumnConsignmentDate
							.setText(com.turquaz.bill.Messages
								.getString("BillUIBillSearch.5")); //$NON-NLS-1$
						tableColumnConsignmentDate.setWidth(104);
						tableColumnConsignmentDate.addListener(
							SWT.Selection,
							new Listener() {
								public void handleEvent(Event e) {
									TableSorter.sortTable(
										tableBills,
										tableColumnConsignmentDate);
								}
							});
					}
					{
						tableColumnDocNo = new TableColumn(tableBills, SWT.NONE);
						tableColumnDocNo.setText(Messages
							.getString("BillUIBillReport.7")); //$NON-NLS-1$
						tableColumnDocNo.setWidth(74);
					}
					//START >>  tableColumnCurrentCode
					tableColumnCurrentCode = new TableColumn(
						tableBills,
						SWT.NONE);
					tableColumnCurrentCode.setText("Cari Kod");
					tableColumnCurrentCode.setWidth(100);
					//END <<  tableColumnCurrentCode
					{
						tableColumnCurrentName = new TableColumn(
							tableBills,
							SWT.NONE);
						tableColumnCurrentName
							.setText(com.turquaz.bill.Messages
								.getString("BillUIBillSearch.6")); //$NON-NLS-1$
						tableColumnCurrentName.setWidth(150);
						tableColumnCurrentName.addListener(
							SWT.Selection,
							new Listener() {
								public void handleEvent(Event e) {
									TableSorter.sortTable(
										tableBills,
										tableColumnCurrentName);
								}
							});
					}
					{
						tableColumnCumulativePrice = new TableColumn(
							tableBills,
							SWT.RIGHT);
						tableColumnCumulativePrice
							.setText(com.turquaz.bill.Messages
								.getString("BillUIBillSearch.7")); //$NON-NLS-1$
						tableColumnCumulativePrice.setWidth(100);
						tableColumnCumulativePrice.addListener(
							SWT.Selection,
							new Listener() {
								public void handleEvent(Event e) {
									TableSorter.sortTable(
										tableBills,
										tableColumnCumulativePrice);
								}
							});
					}
					{
						tableColumnVatAmount = new TableColumn(
							tableBills,
							SWT.RIGHT);
						tableColumnVatAmount.setText(com.turquaz.bill.Messages
							.getString("BillUIBillSearch.8")); //$NON-NLS-1$
						tableColumnVatAmount.setWidth(100);
						tableColumnVatAmount.addListener(
							SWT.Selection,
							new Listener() {
								public void handleEvent(Event e) {
									TableSorter.sortTable(
										tableBills,
										tableColumnVatAmount);
								}
							});
					}
					{
						tableColumnSpecialVatAmount = new TableColumn(
							tableBills,
							SWT.RIGHT);
						tableColumnSpecialVatAmount
							.setText(com.turquaz.bill.Messages
								.getString("BillUIBillSearch.9")); //$NON-NLS-1$
						tableColumnSpecialVatAmount.setWidth(100);
						tableColumnSpecialVatAmount.addListener(
							SWT.Selection,
							new Listener() {
								public void handleEvent(Event e) {
									TableSorter.sortTable(
										tableBills,
										tableColumnSpecialVatAmount);
								}
							});
					}
				}
				GridData tabFolderReportLData = new GridData();
				tabFolderReportLData.grabExcessHorizontalSpace = true;
				tabFolderReportLData.horizontalAlignment = GridData.FILL;
				tabFolderReportLData.verticalAlignment = GridData.FILL;
				tabFolderReportLData.grabExcessVerticalSpace = true;
				tabFolderReportLData.horizontalSpan = 4;
				tabFolderReport.setLayoutData(tabFolderReportLData);
				//END <<  cTabItem1
				//START >>  tabItemReport
				tabItemReport = new CTabItem(tabFolderReport, SWT.NONE);
				tabItemReport.setText("Rapor");
				//START >>  compReport
				compReport = new Composite(tabFolderReport, SWT.NONE);
				GridLayout compReportLayout = new GridLayout();
				compReportLayout.makeColumnsEqualWidth = true;
				compReport.setLayout(compReportLayout);
				tabItemReport.setControl(compReport);
				//START >>  viewer
				viewer = new ViewerComposite(compReport, SWT.NONE);
				GridData viewerLData = new GridData();
				viewerLData.grabExcessHorizontalSpace = true;
				viewerLData.grabExcessVerticalSpace = true;
				viewerLData.horizontalAlignment = GridData.FILL;
				viewerLData.verticalAlignment = GridData.FILL;
				viewer.setLayoutData(viewerLData);
				//END <<  viewer
				//END <<  compReport
				//END <<  tabItemReport
				//END <<  tabFolderReport
			}
			GridData compViewLData = new GridData();
			compViewLData.grabExcessVerticalSpace = true;
			compViewLData.grabExcessHorizontalSpace = true;
			compViewLData.verticalAlignment = GridData.FILL;
			compViewLData.horizontalAlignment = GridData.FILL;
			compView.setLayoutData(compViewLData);
			//END <<  cTabItem2
			//START >>  tabItemView
			tabItemView = new CTabItem(compView, SWT.NONE);
			tabItemView.setText("H\u0131zl\u0131 Görüntüleme");
			//START >>  composite2
			composite2 = new Composite(compView, SWT.NONE);
			GridLayout composite2Layout = new GridLayout();
			composite2Layout.makeColumnsEqualWidth = true;
			composite2.setLayout(composite2Layout);
			tabItemView.setControl(composite2);
			//START >>  toolBar1
			toolBar1 = new ToolBar(composite2, SWT.NONE);
			//START >>  toolUpdate
			toolUpdate = new ToolItem(toolBar1, SWT.NONE);
			toolUpdate.setEnabled(false);
			toolUpdate.setText(Messages.getString("BillUIBillUpdateDialog.0"));
			toolUpdate.setImage(SWTResourceManager
				.getImage("icons/save_edit.gif"));
			toolUpdate.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (bill != null)
					{
						//TODO write update method for BillReport fast view
					}
				}
			});
			//END <<  toolUpdate
			//START >>  toolDelete
			toolDelete = new ToolItem(toolBar1, SWT.NONE);
			toolDelete.setEnabled(false);
			toolDelete.setText(Messages.getString("BillUIBillUpdateDialog.2"));
			toolDelete.setImage(SWTResourceManager
				.getImage("icons/Delete16.gif"));
			toolDelete.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (bill != null){
						boolean answer = EngUICommon.okToDelete(getShell(),"Faturay? silmek istedi?inizden emin misiniz?");
						if (answer)
						{
							
							
						}						
					}						
				}
			});
			//END <<  toolDelete
			//START >>  toolPrint
			toolPrint = new ToolItem(toolBar1, SWT.NONE);
			toolPrint.setText(Messages.getString("BillUIBillUpdateDialog.5"));
			toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif"));
			toolPrint.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					if (bill != null)
					{
						boolean answer = EngUICommon.okToDelete(
								getShell(),
								Messages.getString("BillUIBillUpdateDialog.7")); //$NON-NLS-1$
						EngBLUtils.printBill(bill, answer);
					}

				}
			});
			//END <<  toolPrint
			//START >>  toolItemBack
			toolItemBack = new ToolItem(toolBar1, SWT.NONE);
			toolItemBack.setText("Geri");
			toolItemBack.setImage(SWTResourceManager.getImage("icons/backward.gif"));
			toolItemBack.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					try
					{
						if (list!=null && list.size() > 0)
						{
							if (currentIndex-1 >=0)
							{
								currentIndex--;
								Object[] billObj=(Object[])list.get(currentIndex);
								Integer billId=(Integer)billObj[0];
								bill=BillBLSearchBill.getBillByBillId(billId);
								initializeBill(bill);
								postFinalizeGui();
								if (currentIndex==0)
									toolItemBack.setEnabled(false);
								
								if (currentIndex < list.size()-1)
									toolItemForward.setEnabled(true);
									
							}
						}
					}
					catch (Exception ex)
					{
						ex.printStackTrace();
					}
				}
			});
			//END <<  toolItemBack
			//START >>  toolItemForward
			toolItemForward = new ToolItem(toolBar1, SWT.NONE);
			toolItemForward.setText("\u0130leri");
			toolItemForward.setImage(SWTResourceManager.getImage("icons/forward.gif"));
			toolItemForward.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					try
					{
						if (list != null && list.size() > 0)
						{
							if (currentIndex+1 <= list.size()-1)
							{
								currentIndex++;
								Object[] billObj=(Object[])list.get(currentIndex);
								Integer billId=(Integer)billObj[0];
								bill=BillBLSearchBill.getBillByBillId(billId);
								initializeBill(bill);
								postFinalizeGui();
								
								if (currentIndex==list.size()-1)
									toolItemForward.setEnabled(false);
								
								if (currentIndex > 0)
									toolItemBack.setEnabled(true);
							}
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
			});
			//END <<  toolItemForward
			//END <<  toolBar1
			//START >>  compAddBill
			compAddBill = new BillUIAddBill(composite2, SWT.NONE);
			GridData compLData = new GridData();
			compLData.grabExcessHorizontalSpace = true;
			compLData.grabExcessVerticalSpace = true;
			compLData.horizontalAlignment = GridData.FILL;
			compLData.verticalAlignment = GridData.FILL;
			compAddBill.setLayoutData(compLData);
			GridLayout compLayout1 = new GridLayout();
			compLayout1.makeColumnsEqualWidth = true;
			//END <<  compAddBill
			//END <<  composite2
			compView.setSelection(0);
			//END <<  tabItemView
			//END <<  compView
			postInitGui();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clearFields()
	{
		compAddBill.getTableConsignmentRows().removeAll();
		compAddBill.getCompRegisterGroup().getTableAllGroups().removeAll();
		
	}
	public void postInitGui(){
		comboBillType.add(com.turquaz.bill.Messages.getString("BillUIBillSearch.10"));  //$NON-NLS-1$
		comboBillType.add(com.turquaz.bill.Messages.getString("BillUIBillSearch.11"));  //$NON-NLS-1$
		comboBillType.add(Messages.getString("BillUIBillReport.8")); //$NON-NLS-1$
		comboBillType.setText(Messages.getString("BillUIBillReport.9")); //$NON-NLS-1$
		//dateStartDate.setDate(new Date(cal.getTime().getYear(),0,1));
		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());

		cal.set(cal.get(Calendar.YEAR),0,1);
		dateDueDateStart.setDate(cal.getTime());
		
		cal.add(Calendar.YEAR,1);
		cal.add(Calendar.DATE,-1);
		
		dateDueDateEnd.setDate(cal.getTime());
		
		tabFolderReport.setSelection(cTabItem1);
		//postFinalizeGui();	
	
	}
	
	public void postFinalizeGui(){
	    try{
	        
	        toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			
			if (bill==null)
				return;
			
			if(!blUpdateBill.canUpdateBill(bill)){
			    toolDelete.setEnabled(false);
			    toolUpdate.setEnabled(false); 
			}
		    else{
		        
				if(EngBLPermissions.getPermission(compAddBill.getClass().getName())==2){
				    toolUpdate.setEnabled(true); 
				}
				else if(EngBLPermissions.getPermission(compAddBill.getClass().getName())==3){
				    toolDelete.setEnabled(true);
				    toolUpdate.setEnabled(true); 
				}
		    }
			
			
			
			compAddBill.getTxtCurrentCard().setData(bill.getTurqBillConsignmentCommon().getTurqCurrentCard());
			compAddBill.getTxtCurrentCard().setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName()+" {" +bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsCurrentCode() +"}"); //$NON-NLS-1$ //$NON-NLS-2$
			;
			compAddBill.getTxtDocumentNo().setText(bill.getTurqBillConsignmentCommon().getBillDocumentNo());
			compAddBill.getDateConsignmentDate().setDate(bill.getBillsDate());
			compAddBill.getTxtConsignmentDocumentNo().setText(bill.getTurqBillConsignmentCommon().getConsignmentDocumentNo());
			if (bill.isIsOpen())
			{
				compAddBill.getComboPaymentType().setText(Messages.getString("BillUIBillUpdateDialog.8")); //$NON-NLS-1$
			}
			else {
				compAddBill.getComboPaymentType().setText(Messages.getString("BillUIBillUpdateDialog.11")); //$NON-NLS-1$
			}
		    
			
			compAddBill.getDateDueDate().setDate(bill.getDueDate());
			
		
			compAddBill.getTxtDefinition().setText(bill.getBillsDefinition());
			fillInvTransactionColumns();
			fillRegisteredGroup();  
	        EngUICommon.centreWindow(this.getShell());
	        
	    
	    }	    
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	    
	    
	}
	
	
	public void currentCardChoose(){
		Object data = new CurUICurrentCardSearchDialog(this.getShell(),SWT.NULL).open();
	    if(data!=null){
	   
		TurqCurrentCard curCard = (TurqCurrentCard)data;
	    txtCurCardStart.setText(curCard.getCardsCurrentCode()+" - "+curCard.getCardsName());  //$NON-NLS-1$
		txtCurCardStart.setData(curCard);
		
	    }
		
	}
	
	public void fillRegisteredGroup(){
		
			TurqBillInGroup group;
			Iterator it = bill.getTurqBillInGroups().iterator();
			while(it.hasNext()){
				group = (TurqBillInGroup)it.next();
				compAddBill.getCompRegisterGroup().RegisterGroup(group.getTurqBillGroup());
				
				
			}
			
		
		}
	
	public void fillInvTransactionColumns(){
		
		compAddBill.rowList.removeAll();
		
	    TableItem item;
		TurqInventoryTransaction invTrans;
		
		Iterator it = bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator();
		
		if(it.hasNext()){
	    TurqConsignment cons = (TurqConsignment)it.next();
		
	    Iterator it2 = cons.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
		
		while(it2.hasNext()){
			
		    invTrans = (TurqInventoryTransaction)it2.next();
			
		    InvUITransactionTableRow row = new InvUITransactionTableRow(compAddBill.rowList,compAddBill.BILL_TYPE,compAddBill.tableViewer);
            row.setDBObject(invTrans);
			compAddBill.rowList.addTask(row);
		}
		}
		
		InvUITransactionTableRow row2 = new InvUITransactionTableRow(compAddBill.rowList,compAddBill.BILL_TYPE,compAddBill.tableViewer);
		compAddBill.rowList.addTask(row2);
		
		compAddBill.calculateTotals();
		
	}
	
	
	public void save(){
		
	}
	
	public void initializeBill(TurqBill bill){
	    try{
	        
	        blSearch.initializeBill(bill);
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	
	
	
	public void search()
	{
		
		try
		{
			
			tableBills.removeAll();	
			int type=EngBLCommon.COMMON_ALL_INT;
			if(comboBillType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
			{
				type =EngBLCommon.COMMON_BUY_INT;
			}
			else if (comboBillType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
			{
				type=EngBLCommon.COMMON_SELL_INT;
			}
			
			list = blSearch.searchBillAdvanced(
				(TurqCurrentCard)txtCurCardStart.getData(),
				(TurqCurrentCard)txtCurCardEnd.getData(),
				dateStartDate.getDate(),dateEndDate.getDate(),
				dateDueDateStart.getDate(),dateDueDateEnd.getDate(),
				txtMinInvoiceTotal.getBigDecimalValue(),txtMaxInvoiceTotal.getBigDecimalValue(),
				txtDocNoStart.getText(),txtDocNoEnd.getText(),type);
		        								
			Object[] billObj;
			TableItem item;
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			BigDecimal total=new BigDecimal(0);
			BigDecimal VAT=new BigDecimal(0);
			BigDecimal SpecialVAT=new BigDecimal(0);
		
			for(int i=0;i<list.size();i++)
			{
			
				billObj = (Object[])list.get(i);
				item = new TableItem(tableBills,SWT.NULL);

				
				Integer billId=(Integer)billObj[0];
				Date billDate=(Date)billObj[1];
				String billDocNo=(String)billObj[2];
				String curCardCode=(String)billObj[3];
				String curCardName=(String) billObj[4];
				BigDecimal totalAmount=(BigDecimal)billObj[5];
				BigDecimal vatAmount=(BigDecimal)billObj[6];
				BigDecimal specVatAmount=(BigDecimal)billObj[7];	
				
				total=total.add(totalAmount);
				VAT=VAT.add(vatAmount);
				SpecialVAT=SpecialVAT.add(specVatAmount);
				
				
				item.setData(billId);
				
				
				item.setText(new String[]{DatePicker.formatter.format(billDate),
			        				billDocNo,
									curCardCode,
									curCardName,
									cf.format(totalAmount),
									cf.format(vatAmount),
									cf.format(specVatAmount)});
			
			}
		
			item=new TableItem(tableBills,SWT.NULL);
			item=new TableItem(tableBills,SWT.NULL);
			item.setText(new String[]{"","","",Messages.getString("BillUIBillReport.14"),cf.format(total),cf.format(VAT),cf.format(SpecialVAT)}); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			
			
			currentIndex=0;
			if (list.size() > 0)
			{
				billObj = (Object[])list.get(0);
				Integer billId=(Integer)billObj[0];
				bill=BillBLSearchBill.getBillByBillId(billId);
				initializeBill(bill);
				postFinalizeGui();
				
				toolItemBack.setEnabled(false);
				
				//Generate Jasper Report
				GenerateJasper(list);
				
			}
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}		
	}
	
	 public void GenerateJasper(List list)
	 {
    	try
		{
    		Map parameters=new HashMap();
    		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    		parameters.put("reportDate", sdf.format(Calendar.getInstance().getTime()));
    		parameters.put("startDate",sdf.format(dateStartDate.getDate()));
    		parameters.put("endDate", sdf.format(dateEndDate.getDate()));
    		parameters.put("dueDateStart", sdf.format(dateDueDateStart.getDate()));
    		parameters.put("dueDateEnd", sdf.format(dateDueDateEnd.getDate()));
    		parameters.put("dateFormatter",sdf);
    		parameters.put("currencyFormatter", new TurkishCurrencyFormat());
    		
    		
    		String []fields = new String[]{"id",
    				"bills_date",
					"bill_document_no",
					"cards_current_code",
					"cards_name",
					"total_amount",
					"vat_amount",		
					"special_vat_amount"
    		};  	
    	
    		HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list,fields);
    		JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/bill/BillReport.jasper");   //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
    	catch(Exception ex)
		{
    		ex.printStackTrace();
		}
    	
    	
    }
	
	
	
	public void newForm(){
		
	}
	public void delete(){
	    
	MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
	BillBLUpdateBill blUpdateBill = new BillBLUpdateBill();
	    try{
	        TableItem items[] = tableBills.getSelection();
	        if(items.length>0){
	           
	           TurqBill bill = (TurqBill)items[0].getData();
	         
	           if(blSearch.canUpdateBill(bill)){
	               //delete Consignment Group
	               MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
	               msg2.setMessage(Messages.getString("BillUIBillSearch.12")); //$NON-NLS-1$
	               if(msg2.open()==SWT.OK){
					initializeBill(bill);
	                Iterator it = bill.getTurqBillInGroups().iterator();
					while(it.hasNext()){
					    
						blUpdateBill.deleteObject(it.next());
					    				
					}
					
					BillBLUpdateBill.deleteAccountingTransactions(bill);
					BillBLUpdateBill.deleteCurrentTransactions(bill);
				
					blUpdateBill.deleteObject(bill); 
					msg.setMessage(Messages.getString("BillUIBillSearch.14")); //$NON-NLS-1$
	                msg.open();
	                search();
	               }
	               
	               
	           
	           }
	           else{
	               MessageBox msg3 = new MessageBox(this.getShell(),SWT.ICON_WARNING);
	               msg3.setMessage(Messages.getString("BillUIBillSearch.15")); //$NON-NLS-1$
	               msg3.open();
	               return;
	           }
	            
	            
	            
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        
	        ex.printStackTrace();
	    }
	    
	    
		
	}
	
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableBills);
		
	}
	
	
		
	
	
	
	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem items[] = tableBills.getSelection();
			if(items.length>0)
			{
				Integer billId=(Integer)items[0].getData();
				if (billId != null)
				{
					TurqBill bill = BillBLSearchBill.getBillByBillId(billId);
					if (bill!=null)
					{
						initializeBill(bill);
						boolean updated=new BillUIBillUpdateDialog(this.getShell(),SWT.NULL,bill).open();
						if (updated)
							search();    		   
					}
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	
	public void printTable(){
	    EngBLUtils.printTable(tableBills,Messages.getString("BillUIBillSearch.16")); //$NON-NLS-1$
	    
	}
	
	
	
	
	
	
	
	
	
	
	

}
