package com.turquaz.bill.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLClient;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqBillInGroup;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqInventoryTransaction;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.BillLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
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
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import com.turquaz.engine.ui.component.CurrencyText;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.ui.InvUITransactionTableRow;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.ui.comp.CurrentCodePicker;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillUIBillReport extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private Calendar cal = Calendar.getInstance();
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
	private TableColumn tableColumnCurrency;
	private ToolItem toolItemForward;
	private ToolItem toolItemBack;
	private ToolItem toolPrint;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private Composite composite2;
	private CTabItem tabItemView;
	private CTabItem cTabItem2;
	private TurqBill bill = null;
	private Integer billId=null;
	private int currentIndex = 0;
	private HashMap billList=null;
	private SearchTableViewer tableViewer = null;

	public BillUIBillReport(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(661, 571);
			//START >> compView
			compView = new CTabFolder(this, SWT.NONE);
			//START >> cTabItem2
			cTabItem2 = new CTabItem(compView, SWT.NONE);
			cTabItem2.setText(EngLangCommonKeys.STR_SEARCHING);
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
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD_START);
				}
				{
					txtCurCardStart = new CurrentCodePicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					GridData txtCurCardStartLData = new GridData();
					txtCurCardStartLData.widthHint = 156;
					txtCurCardStartLData.heightHint = 17;
					txtCurCardStart.setLayoutData(txtCurCardStartLData);
				}
				{
					lblCurCardEnd = new CLabel(composite1, SWT.NONE);
					lblCurCardEnd.setText(CurLangKeys.STR_CUR_CARD_END);
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
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
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
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
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
					lblDueDateStart.setText(EngLangCommonKeys.STR_DUE_DATE_START);
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
					lblDueDateEnd.setText(EngLangCommonKeys.STR_DUE_DATE_END);
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
					lblMinInvoiceTotal.setText(EngLangCommonKeys.STR_TOTAL_MIN);
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
					lblMaxInvoiceTotal.setText(EngLangCommonKeys.STR_TOTAL_MAX);
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
					lblDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO_START);
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
					lblDocNoEnd.setText(EngLangCommonKeys.STR_DOCUMENT_NO_END);
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
					lblType.setText(EngLangCommonKeys.STR_TYPE);
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(EngLangCommonKeys.STR_TYPE);
					comboConsignmentTypeLData.widthHint = 130;
					comboConsignmentTypeLData.heightHint = 14;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
				}
				//START >> tabFolderReport
				tabFolderReport = new CTabFolder(composite1, SWT.NONE);
				//START >> cTabItem1
				cTabItem1 = new CTabItem(tabFolderReport, SWT.NONE);
				cTabItem1.setText(EngLangCommonKeys.STR_SEARCH_RESULT);
				{
					tableBills = new Table(tabFolderReport, SWT.FULL_SELECTION);
					cTabItem1.setControl(tableBills);
					GridData tableConsignmentsLData = new GridData();
					tableBills.addMouseListener(new MouseAdapter()
					{
						public void mouseDoubleClick(MouseEvent evt)
						{
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
						tableColumnConsignmentDate = new TableColumn(tableBills, SWT.NONE);
						tableColumnConsignmentDate.setText(EngLangCommonKeys.STR_DATE);
						tableColumnConsignmentDate.setWidth(104);
						tableColumnConsignmentDate.addListener(SWT.Selection, new Listener()
						{
							public void handleEvent(Event e)
							{
								TableSorter.sortTable(tableBills, tableColumnConsignmentDate);
							}
						});
					}
					{
						tableColumnDocNo = new TableColumn(tableBills, SWT.NONE);
						tableColumnDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
						tableColumnDocNo.setWidth(74);
					}
					//START >> tableColumnCurrentCode
					tableColumnCurrentCode = new TableColumn(tableBills, SWT.NONE);
					tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE);
					tableColumnCurrentCode.setWidth(100);
					//END << tableColumnCurrentCode
					{
						tableColumnCurrentName = new TableColumn(tableBills, SWT.NONE);
						tableColumnCurrentName.setText(CurLangKeys.STR_CUR_NAME);
						tableColumnCurrentName.setWidth(150);
						tableColumnCurrentName.addListener(SWT.Selection, new Listener()
						{
							public void handleEvent(Event e)
							{
								TableSorter.sortTable(tableBills, tableColumnCurrentName);
							}
						});
					}
					//START >>  tableColumnCurrency
					tableColumnCurrency = new TableColumn(tableBills, SWT.CENTER);
					tableColumnCurrency.setText(EngLangCommonKeys.STR_CURRENCY);
					tableColumnCurrency.setWidth(60);
					//END <<  tableColumnCurrency
					{
						tableColumnCumulativePrice = new TableColumn(tableBills, SWT.RIGHT);
						tableColumnCumulativePrice.setText(EngLangCommonKeys.STR_TOTAL_PRICE);
						tableColumnCumulativePrice.setWidth(100);
						tableColumnCumulativePrice.addListener(SWT.Selection, new Listener()
						{
							public void handleEvent(Event e)
							{
								TableSorter.sortTable(tableBills, tableColumnCumulativePrice);
							}
						});
					}
					{
						tableColumnVatAmount = new TableColumn(tableBills, SWT.RIGHT);
						tableColumnVatAmount.setText(InvLangKeys.STR_VAT_TOTAL);
						tableColumnVatAmount.setWidth(100);
						tableColumnVatAmount.addListener(SWT.Selection, new Listener()
						{
							public void handleEvent(Event e)
							{
								TableSorter.sortTable(tableBills, tableColumnVatAmount);
							}
						});
					}
					{
						tableColumnSpecialVatAmount = new TableColumn(tableBills, SWT.RIGHT);
						tableColumnSpecialVatAmount.setText(InvLangKeys.STR_SPEC_VAT);
						tableColumnSpecialVatAmount.setWidth(100);
						tableColumnSpecialVatAmount.addListener(SWT.Selection, new Listener()
						{
							public void handleEvent(Event e)
							{
								TableSorter.sortTable(tableBills, tableColumnSpecialVatAmount);
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
				//END << cTabItem1
				//START >> tabItemReport
				tabItemReport = new CTabItem(tabFolderReport, SWT.NONE);
				tabItemReport.setText(EngLangCommonKeys.STR_REPORT);
				//START >> compReport
				compReport = new Composite(tabFolderReport, SWT.NONE);
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
				//END << tabItemReport
				//END << tabFolderReport
			}
			GridData compViewLData = new GridData();
			compViewLData.grabExcessVerticalSpace = true;
			compViewLData.grabExcessHorizontalSpace = true;
			compViewLData.verticalAlignment = GridData.FILL;
			compViewLData.horizontalAlignment = GridData.FILL;
			compView.setLayoutData(compViewLData);
			//END << cTabItem2
			//START >> tabItemView
			tabItemView = new CTabItem(compView, SWT.NONE);
			tabItemView.setText(EngLangCommonKeys.STR_FAST_VIEW);
			//START >> composite2
			composite2 = new Composite(compView, SWT.NONE);
			GridLayout composite2Layout = new GridLayout();
			composite2Layout.makeColumnsEqualWidth = true;
			composite2.setLayout(composite2Layout);
			tabItemView.setControl(composite2);
			//START >> toolBar1
			toolBar1 = new ToolBar(composite2, SWT.NONE);
			//START >> toolUpdate
			toolUpdate = new ToolItem(toolBar1, SWT.NONE);
			toolUpdate.setEnabled(false);
			toolUpdate.setText(EngLangCommonKeys.STR_UPDATE);
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					try
					{
						if (bill != null)
						{
							//TODO exchange rate
							int type = compAddBill.BILL_TYPE;
							
							HashMap argMap=new HashMap();
							
							argMap.put(BillKeys.BILL,bill);
							argMap.put(BillKeys.BILL_DOC_NO,compAddBill.getTxtDocumentNo().getText().trim());
							argMap.put(BillKeys.BILL_DEFINITION,compAddBill.getTxtDefinition().getText().trim());
							argMap.put(BillKeys.BILL_IS_PRINTED,new Boolean(false));
							argMap.put(BillKeys.BILL_DATE,compAddBill.getDateConsignmentDate().getDate());
							argMap.put(EngKeys.TYPE,new Integer(type));
							argMap.put(CurKeys.CUR_CARD_ID,compAddBill.getTxtCurrentCard().getCardId());
							argMap.put(BillKeys.BILL_DUE_DATE,compAddBill.getDateDueDate().getDate());
							argMap.put(BillKeys.BILL_DISCOUNT_AMOUNT,compAddBill.getTxtDiscountAmount().getBigDecimalValue());			
							argMap.put(BillKeys.BILL_TOTAL_AMOUNT,compAddBill.getTxtTotalAmount().getBigDecimalValue());
							argMap.put(EngKeys.CURRENCY_ID,EngBLClient.getBaseCurrencyId());
							argMap.put(BillKeys.BILL_GROUPS,compAddBill.getBillGroups());
							argMap.put(InvKeys.INV_TRANSACTIONS,compAddBill.getInventoryTransactions());	
							
							int[] result=(int[])EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"updateBill",argMap); //$NON-NLS-1$
							
							
							if(result[0]==EngBLCommon.BILL_ERR_TOO_MANY_CONS)
							{
								EngUICommon.showMessageBox(getShell(),BillLangKeys.MSG_COULDNT_UPDATE_CONS_DUE_TO_MANY_CONS,SWT.ICON_WARNING);
							}
							if(result[1]==-1)
							{			   	
								EngUICommon.showMessageBox(getShell(),EngLangCommonKeys.MSG_ACCOUNTING_ENTEGRATION_COULDNT_BE_MADE,SWT.ICON_WARNING);
							}
							
							EngUICommon.showUpdatedSuccesfullyMessage(getShell());
							search();
						}
					}
					catch (Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			//END << toolUpdate
			//START >> toolDelete
			toolDelete = new ToolItem(toolBar1, SWT.NONE);
			toolDelete.setEnabled(false);
			toolDelete.setText(EngLangCommonKeys.STR_DELETE);
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			toolDelete.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					try
					{
						if (bill != null)
						{
							boolean okToDelete = EngUICommon.okToDelete(getShell());
							if (okToDelete)
							{
								boolean deleteCons = false;
								//TODO check there exist cons...
								if (EngUICommon.showQuestion(getShell(), BillLangKeys.MSG_WILL_DELETE_CONS))
								{
									deleteCons = true;
								}
								HashMap argMap=new HashMap();
								argMap.put(BillKeys.BILL_ID,billId);
								argMap.put(BillKeys.BILL_DELETE_CONS,new Boolean(true));
								EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"deleteBill",argMap); //$NON-NLS-1$
								EngUICommon.showDeletedSuccesfullyMessage(getShell());
								search();
							}							
						}
					}
					catch (Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			//END << toolDelete
			//START >> toolPrint
			toolPrint = new ToolItem(toolBar1, SWT.NONE);
			toolPrint.setText(EngLangCommonKeys.STR_PRINT);
			toolPrint.setImage(SWTResourceManager.getImage("gfx/print.gif")); //$NON-NLS-1$
			toolPrint.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					try
					{
						if (bill != null)
						{
							boolean answer = EngUICommon.showQuestion(getShell(), BillLangKeys.MSG_WILL_BALANCE_BE_PRINTED);
							HashMap argMap=new HashMap();
							argMap.put(BillKeys.BILL,bill);
							argMap.put(BillKeys.BILL_BALANCE,new Boolean(answer));
							EngTXCommon.doSelectTX(EngBLUtils.class.getName(),"printBill",argMap); //$NON-NLS-1$
						}
					}
					catch(Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			//END << toolPrint
			//START >> toolItemBack
			toolItemBack = new ToolItem(toolBar1, SWT.NONE);
			toolItemBack.setText(EngLangCommonKeys.STR_BACKWARD);
			toolItemBack.setImage(SWTResourceManager.getImage("icons/backward.gif")); //$NON-NLS-1$
			toolItemBack.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					try
					{
						if (billList != null && billList.size() > 0)
						{
							if (currentIndex - 1 >= 0)
							{
								currentIndex--;
								HashMap billInfo = (HashMap) billList.get(new Integer(currentIndex));
								
								billId = (Integer) billInfo.get(BillKeys.BILL_ID);
								
								HashMap argMap=new HashMap();
								argMap.put(BillKeys.BILL_ID,billId);
								bill = (TurqBill)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"initializeBillById",argMap); //$NON-NLS-1$
								postFinalizeGui();
								
								if (currentIndex == 0)
									toolItemBack.setEnabled(false);
								if (currentIndex < billList.size() - 1)
									toolItemForward.setEnabled(true);
							}
						}
					}
					catch (Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			//END << toolItemBack
			//START >> toolItemForward
			toolItemForward = new ToolItem(toolBar1, SWT.NONE);
			toolItemForward.setText(EngLangCommonKeys.STR_FORWARD);
			toolItemForward.setImage(SWTResourceManager.getImage("icons/forward.gif")); //$NON-NLS-1$
			toolItemForward.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					try
					{
						if (billList != null && billList.size() > 0)
						{
							if (currentIndex + 1 <= billList.size() - 1)
							{
								currentIndex++;
								
								HashMap billInfo = (HashMap) billList.get(new Integer(currentIndex));
								
								billId = (Integer) billInfo.get(BillKeys.BILL_ID);
								
								
								
								HashMap argMap=new HashMap();
								argMap.put(BillKeys.BILL_ID,billId);
								bill = (TurqBill)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"initializeBillById",argMap); //$NON-NLS-1$
								postFinalizeGui();
								if (currentIndex == billList.size() - 1)
									toolItemForward.setEnabled(false);
								if (currentIndex > 0)
									toolItemBack.setEnabled(true);
							}
						}
					}
					catch (Exception ex)
					{
                        EngBLLogger.log(this.getClass(),ex,getShell());
					}
				}
			});
			//END << toolItemForward
			//END << toolBar1
			//START >> compAddBill
			compAddBill = new BillUIAddBill(composite2, SWT.NONE);
			GridData compLData = new GridData();
			compLData.grabExcessHorizontalSpace = true;
			compLData.grabExcessVerticalSpace = true;
			compLData.horizontalAlignment = GridData.FILL;
			compLData.verticalAlignment = GridData.FILL;
			compAddBill.setLayoutData(compLData);
			GridLayout compLayout1 = new GridLayout();
			compLayout1.makeColumnsEqualWidth = true;
			//END << compAddBill
			//END << composite2
			compView.setSelection(0);
			//END << tabItemView
			//END << compView
			postInitGui();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void clearFields()
	{
		compAddBill.getTableConsignmentRows().removeAll();
		compAddBill.getCompRegisterGroup().getTableAllGroups().removeAll();
	}

	public void postInitGui()
	{
		//TODO add combo string from EngBLCommon
		comboBillType.add(EngLangCommonKeys.COMMON_ALL_STRING);
		comboBillType.add(EngLangCommonKeys.COMMON_BUY_STRING);
		comboBillType.add(EngLangCommonKeys.COMMON_SELL_STRING);
		comboBillType.setText(EngLangCommonKeys.COMMON_ALL_STRING);
		
		
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateDueDateStart.setDate(cal.getTime());
		cal.add(Calendar.YEAR, 1);
		cal.add(Calendar.DATE, -1);
		dateDueDateEnd.setDate(cal.getTime());
		tabFolderReport.setSelection(0);
		createTableViewer();
		//postFinalizeGui();
	}

	public void postFinalizeGui()
	{
		try
		{
			toolUpdate.setEnabled(false);
			toolDelete.setEnabled(false);
			if (bill == null)
				return;
			HashMap argMap=new HashMap();
			
			HashBag result=(HashBag)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"canUpdateBill",argMap);
			
			Boolean canUpdateBill =(Boolean)result.get(BillKeys.BILL_CAN_UPDATE);
		
			
			
			if (!canUpdateBill.booleanValue())
			{
				toolDelete.setEnabled(false);
				toolUpdate.setEnabled(false);
			}
			else
			{
				if (EngBLPermissions.getPermission(compAddBill.getClass().getName()) == 2)
				{
					toolUpdate.setEnabled(true);
				}
				else if (EngBLPermissions.getPermission(compAddBill.getClass().getName()) == 3)
				{
					toolDelete.setEnabled(true);
					toolUpdate.setEnabled(true);
				}
			}
			compAddBill.getTxtCurrentCard().setData(bill.getTurqCurrentCard());
			compAddBill.getTxtCurrentCard().setText(
					bill.getTurqCurrentCard().getCardsName() + " {" + bill.getTurqCurrentCard().getCardsCurrentCode() + "}"); //$NON-NLS-1$ //$NON-NLS-2$
			;
			compAddBill.getTxtDocumentNo().setText(bill.getBillDocumentNo());
			compAddBill.getDateConsignmentDate().setDate(bill.getBillsDate());
		
			compAddBill.getDateDueDate().setDate(bill.getDueDate());
			compAddBill.getTxtDefinition().setText(bill.getBillsDefinition());
			compAddBill.getTxtConsignmentDocumentNo().setText(""); //$NON-NLS-1$
			fillInvTransactionColumns();
			fillRegisteredGroup();
			EngUICommon.centreWindow(this.getShell());
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[8];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableBills, columnTypes, true);
	}

	

	public void fillRegisteredGroup()
	{
		TurqBillInGroup group;
		Iterator it = bill.getTurqBillInGroups().iterator();
		while (it.hasNext())
		{
			group = (TurqBillInGroup) it.next();
			compAddBill.getCompRegisterGroup().RegisterGroup(group.getTurqBillGroup());
		}
	}

	public void fillInvTransactionColumns()
	{
		compAddBill.tableViewer.removeAll();
		TableItem item;
		TurqInventoryTransaction invTrans;
		Iterator it = bill.getTurqBillInEngineSequences().iterator();
		while (it.hasNext())
		{
			TurqBillInEngineSequence billInEng = (TurqBillInEngineSequence) it.next();
			Iterator it2 = billInEng.getTurqEngineSequence().getTurqConsignments().iterator();
			if (it2.hasNext())
			{
				TurqConsignment cons = (TurqConsignment) it2.next();
				if (!cons.getConsignmentDocumentNo().equals("")) //$NON-NLS-1$
					compAddBill.getTxtConsignmentDocumentNo().append("[" + cons.getConsignmentDocumentNo() + "]"); //$NON-NLS-1$ //$NON-NLS-2$
			}
			Iterator it3 = billInEng.getTurqEngineSequence().getTurqInventoryTransactions().iterator();
			while (it3.hasNext())
			{
				invTrans = (TurqInventoryTransaction) it3.next();
				InvUITransactionTableRow row = new InvUITransactionTableRow(compAddBill.BILL_TYPE, compAddBill.tableViewer);
				row.setDBObject(invTrans);
				compAddBill.tableViewer.addRow(row);
			}
		}
		compAddBill.calculateTotals();
	}

	public void save()
	{
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboBillType.getText().equals(EngLangCommonKeys.COMMON_BUY_STRING))
			{
				type = EngBLCommon.COMMON_BUY_INT;
			}
			else if (comboBillType.getText().equals(EngLangCommonKeys.COMMON_SELL_STRING))
			{
				type = EngBLCommon.COMMON_SELL_INT;
			}
			
			HashMap argMap = new HashMap();
			
			argMap.put(CurKeys.CUR_CARD_START,txtCurCardStart.getCardId());
			argMap.put(CurKeys.CUR_CARD_END,txtCurCardEnd.getCardId());
			
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.DUE_DATE_START,dateDueDateStart.getDate());
			argMap.put(EngKeys.DUE_DATE_END, dateDueDateEnd.getDate());
			argMap.put(EngKeys.MIN_VALUE,txtMinInvoiceTotal.getBigDecimalValue());
			argMap.put(EngKeys.MAX_VALUE,txtMaxInvoiceTotal.getBigDecimalValue());
			argMap.put(EngKeys.DOCUMENT_NO_START, txtDocNoStart.getText());
			argMap.put(EngKeys.DOCUMENT_NO_END,txtDocNoEnd.getText());
			argMap.put(EngKeys.TYPE,new Integer(type));
			
			HashBag resultBag =(HashBag) EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"searchBillAdvanced",argMap); //$NON-NLS-1$
			
			billList = (HashMap)resultBag.get(BillKeys.BILLS);
			
			
			HashMap billInfo;
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal total = new BigDecimal(0);
			BigDecimal VAT = new BigDecimal(0);
			BigDecimal SpecialVAT = new BigDecimal(0);
			for (int i = 0; i < billList.size(); i++)
			{
				billInfo = (HashMap) billList.get(new Integer(i));
				
				Integer billId = (Integer) billInfo.get(BillKeys.BILL_ID);
				Date billDate = (Date) billInfo.get(BillKeys.BILL_DATE);
				String billDocNo = (String) billInfo.get(BillKeys.BILL_DOC_NO);
				String curCardCode = (String)billInfo.get(CurKeys.CUR_CURRENT_CODE);
				String curCardName = (String) billInfo.get(CurKeys.CUR_CURRENT_NAME);
				BigDecimal totalAmount = (BigDecimal)billInfo.get(BillKeys.BILL_TOTAL_AMOUNT);
				BigDecimal vatAmount =  (BigDecimal)billInfo.get(BillKeys.BILL_TOTAL_VAT);
				BigDecimal specVatAmount =  (BigDecimal) billInfo.get(BillKeys.BILL_SPECIAL_VAT);
				String currency=(String)billInfo.get(AdmKeys.ADM_CURRENCY_ABBR);
			
				
				total = total.add(totalAmount);
				VAT = VAT.add(vatAmount);
				SpecialVAT = SpecialVAT.add(specVatAmount);
				tableViewer.addRow(new String[]{DatePicker.formatter.format(billDate), billDocNo, curCardCode, curCardName,currency,
						cf.format(totalAmount), cf.format(vatAmount), cf.format(specVatAmount)}, billId);
			}
			tableViewer.addRow(new String[]{"","", "", "", "", "", "", ""}, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$
			tableViewer.addRow(new String[]{"","", "", "", "TOPLAM", cf.format(total), cf.format(VAT), //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
					cf.format(SpecialVAT)}, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			currentIndex = 0;
			if (billList.size() > 0)
			{
				billInfo = (HashMap) billList.get(new Integer(0));
				Integer billId = (Integer) billInfo.get(BillKeys.BILL_ID);
				argMap=new HashMap();
				argMap.put(BillKeys.BILL_ID,billId);
				bill = (TurqBill)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"initializeBillById",argMap); //$NON-NLS-1$
				postFinalizeGui();
				toolItemBack.setEnabled(false);
				//Generate Jasper Report
			//	GenerateJasper(list);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void GenerateJasper(List list)
	{
		try
		{
			Map parameters = new HashMap();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			parameters.put("reportDate", sdf.format(Calendar.getInstance().getTime())); //$NON-NLS-1$
			parameters.put("startDate", sdf.format(dateStartDate.getDate())); //$NON-NLS-1$
			parameters.put("endDate", sdf.format(dateEndDate.getDate())); //$NON-NLS-1$
			parameters.put("dueDateStart", sdf.format(dateDueDateStart.getDate())); //$NON-NLS-1$
			parameters.put("dueDateEnd", sdf.format(dateDueDateEnd.getDate())); //$NON-NLS-1$
			parameters.put("dateFormatter", sdf); //$NON-NLS-1$
			parameters.put("currencyFormatter", new TurkishCurrencyFormat()); //$NON-NLS-1$
			String[] fields = new String[]{"id", "bills_date", "bill_document_no", "cards_current_code", "cards_name", "total_amount", //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
					"vat_amount", "special_vat_amount","currency"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/bill/BillReport.jrxml");
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/bill/BillReport.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			viewer.getReportViewer().setDocument(jasperPrint);
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
	}

	public void delete()
	{
		try
		{
			TableItem items[] = tableBills.getSelection();
			if (items.length > 0)
			{
				Integer billId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (billId != null)
				{
					HashMap argMap=new HashMap();
					argMap.put(BillKeys.BILL_ID,billId);
					TurqBill bill = (TurqBill)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"initializeBillById",argMap); //$NON-NLS-1$
					Boolean canUpdateBill=(Boolean)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"canUpdateBill",argMap); //$NON-NLS-1$
					if (canUpdateBill.booleanValue())
					{
						boolean okToDelete=EngUICommon.okToDelete(getShell());
						if (okToDelete)
						{
							argMap=new HashMap();
							argMap.put(BillKeys.BILL,bill);
							argMap.put(BillKeys.BILL_DELETE_CONS,new Boolean(false));
							EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"deleteBill",argMap); //$NON-NLS-1$
							EngUICommon.showDeletedSuccesfullyMessage(getShell());
							search();
						}
					}
					else
					{
						//XXX bu ne???
						EngUICommon.showUpdatedSuccesfullyMessage(getShell());
						return;
					}
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem items[] = tableBills.getSelection();
			if (items.length > 0)
			{
				Integer billId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (billId != null)
				{
					boolean updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, billId).open();
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableBills, BillLangKeys.STR_BILLS);
	}
}