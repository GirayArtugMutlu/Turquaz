package com.turquaz.bill.ui;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.admin.AdmKeys;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
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
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;


public class BillUIBillSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite composite1;
	private Table tableBills;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private CurrentPicker txtCurCard;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnCurrentCode;
	private TableColumn tableColumnDocNo;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private CCombo comboBillType;
	private CLabel lblType;
	private CLabel lblEndDate;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private TableColumn tableColumnConsignmentDate;
	private Calendar cal = Calendar.getInstance();
	private SearchTableViewer tableViewer = null;

	public BillUIBillSearch(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(663, 344);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 89;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1.setLayoutData(composite1LData);
				composite1.setLayout(composite1Layout);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD);
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 109;
					lblCurrentCardLData.heightHint = 18;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 157;
					txtCurCardLData.heightHint = 17;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblDocNo = new CLabel(composite1, SWT.NONE);
					lblDocNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
				}
				{
					txtDocNo = new Text(composite1, SWT.NONE);
					GridData txtDocNoLData = new GridData();
					txtDocNoLData.widthHint = 150;
					txtDocNoLData.heightHint = 17;
					txtDocNo.setLayoutData(txtDocNoLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 157;
					dateStartDateLData.heightHint = 23;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 157;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(EngLangCommonKeys.STR_TYPE);
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(BillLangKeys.STR_BUY);
					comboConsignmentTypeLData.widthHint = 134;
					comboConsignmentTypeLData.heightHint = 17;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			{
				tableBills = new Table(this, SWT.FULL_SELECTION | SWT.VIRTUAL);
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
				tableColumnCurrency = new TableColumn(tableBills, SWT.NONE);
				tableColumnCurrency.setText(EngLangCommonKeys.STR_CURRENCY);
				tableColumnCurrency.setWidth(70);
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
			postInitGui();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGui()
	{
		comboBillType.add(EngLangCommonKeys.COMMON_BUY_STRING);
		comboBillType.add(EngLangCommonKeys.COMMON_SELL_STRING);
		comboBillType.add(EngLangCommonKeys.COMMON_ALL_STRING);
		comboBillType.setText(EngLangCommonKeys.COMMON_ALL_STRING);
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		createTableViewer();
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
			HashMap argMap=new HashMap();
			
			argMap.put(CurKeys.CUR_CARD_ID, txtCurCard.getCardId());
			argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.TYPE,new Integer(type));
			
			HashBag billBag =(HashBag)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"searchBill",argMap);
			HashMap billList =(HashMap)billBag.get(BillKeys.BILLS);
			
			HashMap billInfo;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			BigDecimal generalTotalAmount=new BigDecimal(0);
			BigDecimal generalVATAmount=new BigDecimal(0);
			BigDecimal generalSpecVATAmount=new BigDecimal(0);
			for (int i = 0; i < billList.size(); i++)
			{
				billInfo = (HashMap) billList.get(new Integer(i));
				
				
				Integer billId = (Integer) billInfo.get(BillKeys.BILL_ID);
				Date billDate = (Date)  billInfo.get(BillKeys.BILL_DATE);
				String billDocNo = (String) billInfo.get(BillKeys.BILL_DOC_NO);
				String curCardCode = (String) billInfo.get(CurKeys.CUR_CURRENT_CODE);
				String curCardName = (String)  billInfo.get(CurKeys.CUR_CURRENT_NAME);
				BigDecimal totalAmount = (BigDecimal) billInfo.get(BillKeys.BILL_TOTAL_AMOUNT);
				BigDecimal discountAmount = (BigDecimal) billInfo.get(BillKeys.BILL_DISCOUNT_AMOUNT);
				BigDecimal vatAmount = (BigDecimal)  billInfo.get(BillKeys.BILL_TOTAL_VAT);
				BigDecimal specVatAmount = (BigDecimal) billInfo.get(BillKeys.BILL_SPECIAL_VAT);
				String currency=(String) billInfo.get(AdmKeys.ADM_CURRENCY_ABBR);
				
				BigDecimal netTotalAmount=totalAmount.add(vatAmount).add(specVatAmount).subtract(discountAmount);
				
				generalTotalAmount=generalTotalAmount.add(netTotalAmount);
				generalVATAmount=generalVATAmount.add(vatAmount);
				generalSpecVATAmount=generalSpecVATAmount.add(specVatAmount);
				
				tableViewer.addRow(new String[]{DatePicker.formatter.format(billDate), billDocNo, curCardCode, curCardName,currency,
						cf.format(netTotalAmount), cf.format(vatAmount), cf.format(specVatAmount)}, billId);
			}
			tableViewer.addRow(new String[]{"","","","","","","",""},null);
			tableViewer.addRow(new String[]{"","","","",EngLangCommonKeys.STR_GENERAL_TOTAL_CAPITAL,cf.format(generalTotalAmount),cf.format(generalVATAmount),cf.format(generalSpecVATAmount)},null);
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
				//TODO bill should be initialized in get method..
				Integer billId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (billId != null)
				{
					HashMap argMap=new HashMap();
					argMap.put(BillKeys.BILL_ID,billId);
					
					
					HashBag result=(HashBag)EngTXCommon.doSelectTX(BillBLSearchBill.class.getName(),"canUpdateBill",argMap);
					
					Boolean canUpdateBill =(Boolean)result.get(BillKeys.BILL_CAN_UPDATE);
				
					if (canUpdateBill.booleanValue())
					{
						//delete Consignment Group
						boolean okToDelete=EngUICommon.okToDelete(getShell());
						if (okToDelete)
						{
							boolean deleteCons = false;
							if (EngUICommon.showQuestion(getShell(), BillLangKeys.MSG_WILL_DELETE_CONS))
							{
								deleteCons = true;
							}
							argMap=new HashMap();
							argMap.put(BillKeys.BILL_ID,billId);
							argMap.put(BillKeys.BILL_DELETE_CONS,new Boolean(deleteCons));
							EngTXCommon.doTransactionTX(BillBLUpdateBill.class.getName(),"deleteBill",argMap);
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

	public static boolean updateBill(Integer billId, Shell shell) throws Exception
	{
		if (billId != null)
		{
			
			boolean updated = new BillUIBillUpdateDialog(shell, SWT.NULL, billId).open();
			if (updated)
				return true;
		}
		return false;
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem items[] = tableBills.getSelection();
			if (items.length > 0)
			{
				Integer billId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				boolean updated = updateBill(billId, getShell());
				if (updated)
					search();
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