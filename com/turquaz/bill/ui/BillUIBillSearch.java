package com.turquaz.bill.ui;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.bill.Messages;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.bl.BillBLUpdateBill;
import com.turquaz.current.ui.CurUICurrentCardSearchDialog;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TableSorter;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BillUIBillSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite composite1;
	private Table tableBills;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private CurrentPicker txtCurCard;
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
			this.setSize(591, 344);
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
					lblCurrentCard.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.0")); //$NON-NLS-1$
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
					lblDocNo.setText("Belge No");
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
					lblStartDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.1")); //$NON-NLS-1$
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
					lblEndDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.2")); //$NON-NLS-1$
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
					lblType.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.3")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboBillType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboBillType.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.4")); //$NON-NLS-1$
					comboConsignmentTypeLData.widthHint = 134;
					comboConsignmentTypeLData.heightHint = 17;
					comboBillType.setLayoutData(comboConsignmentTypeLData);
				}
			}
			{
				tableBills = new Table(this, SWT.FULL_SELECTION | SWT.VIRTUAL);
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
					tableColumnConsignmentDate.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.5")); //$NON-NLS-1$
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
					tableColumnDocNo.setText("Belge No");
					tableColumnDocNo.setWidth(74);
				}
				//START >> tableColumnCurrentCode
				tableColumnCurrentCode = new TableColumn(tableBills, SWT.NONE);
				tableColumnCurrentCode.setText("Cari Kod");
				tableColumnCurrentCode.setWidth(100);
				//END << tableColumnCurrentCode
				{
					tableColumnCurrentName = new TableColumn(tableBills, SWT.NONE);
					tableColumnCurrentName.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.6")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
					tableColumnCurrentName.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableBills, tableColumnCurrentName);
						}
					});
				}
				{
					tableColumnCumulativePrice = new TableColumn(tableBills, SWT.RIGHT);
					tableColumnCumulativePrice.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.7")); //$NON-NLS-1$
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
					tableColumnVatAmount.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.8")); //$NON-NLS-1$
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
					tableColumnSpecialVatAmount.setText(com.turquaz.bill.Messages.getString("BillUIBillSearch.9")); //$NON-NLS-1$
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
			e.printStackTrace();
		}
	}

	public void postInitGui()
	{
		comboBillType.add(EngBLCommon.COMMON_BUY_STRING);
		comboBillType.add(EngBLCommon.COMMON_SELL_STRING);
		comboBillType.add(EngBLCommon.COMMON_ALL_STRING);
		comboBillType.setText(EngBLCommon.COMMON_ALL_STRING);
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
	}

	public void currentCardChoose()
	{
		Object data = new CurUICurrentCardSearchDialog(this.getShell(), SWT.NULL).open();
		if (data != null)
		{
			TurqCurrentCard curCard = (TurqCurrentCard) data;
			txtCurCard.setText(curCard.getCardsCurrentCode() + " - " + curCard.getCardsName()); //$NON-NLS-1$
			txtCurCard.setData(curCard);
		}
	}

	public void save()
	{
	}

	public void initializeBill(TurqBill bill)
	{
		try
		{
			BillBLSearchBill.initializeBill(bill);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void search()
	{
		try
		{
			tableBills.removeAll();
			int type = EngBLCommon.COMMON_ALL_INT;
			if (comboBillType.getText().equals(EngBLCommon.COMMON_BUY_STRING))
			{
				type = EngBLCommon.COMMON_BUY_INT;
			}
			else if (comboBillType.getText().equals(EngBLCommon.COMMON_SELL_STRING))
			{
				type = EngBLCommon.COMMON_SELL_INT;
			}
			List list = BillBLSearchBill.searchBill((TurqCurrentCard) txtCurCard.getData(), txtDocNo.getText().trim(), dateStartDate
					.getDate(), dateEndDate.getDate(), type);
			Object[] bill;
			TableItem item;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < list.size(); i++)
			{
				bill = (Object[]) list.get(i);
				item = new TableItem(tableBills, SWT.NULL);
				Integer billId = (Integer) bill[0];
				Date billDate = (Date) bill[1];
				String billDocNo = (String) bill[2];
				String curCardCode = (String) bill[3];
				String curCardName = (String) bill[4];
				BigDecimal totalAmount = (BigDecimal) bill[5];
				BigDecimal vatAmount = (BigDecimal) bill[6];
				BigDecimal specVatAmount = (BigDecimal) bill[7];
				item.setData(billId);
				item.setText(new String[]{DatePicker.formatter.format(billDate), billDocNo, curCardCode, curCardName,
						cf.format(totalAmount), cf.format(vatAmount), cf.format(specVatAmount)});
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void newForm()
	{
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			TableItem items[] = tableBills.getSelection();
			if (items.length > 0)
			{
				TurqBill bill = (TurqBill) items[0].getData();
				if (BillBLSearchBill.canUpdateBill(bill))
				{
					//delete Consignment Group
					MessageBox msg2 = new MessageBox(this.getShell(), SWT.OK | SWT.CANCEL);
					msg2.setMessage(Messages.getString("BillUIBillSearch.12")); //$NON-NLS-1$
					if (msg2.open() == SWT.OK)
					{
						initializeBill(bill);
						boolean deleteCons = false;
						if (EngUICommon.okToDelete(getShell(), Messages.getString("BillUIBillUpdateDialog.9"))) { //$NON-NLS-1$
							deleteCons = true;
						}
						BillBLUpdateBill.deleteBill(bill,deleteCons);
						msg.setMessage(Messages.getString("BillUIBillSearch.14")); //$NON-NLS-1$
						msg.open();
						search();
					}
				}
				else
				{
					MessageBox msg3 = new MessageBox(this.getShell(), SWT.ICON_WARNING);
					msg3.setMessage(Messages.getString("BillUIBillSearch.15")); //$NON-NLS-1$
					msg3.open();
					return;
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableBills);
	}

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem items[] = tableBills.getSelection();
			if (items.length > 0)
			{
				Integer billId = (Integer) items[0].getData();
				if (billId != null)
				{
					TurqBill bill = BillBLSearchBill.getBillByBillId(billId);
					initializeBill(bill);
					boolean updated = new BillUIBillUpdateDialog(this.getShell(), SWT.NULL, bill).open();
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableBills, Messages.getString("BillUIBillSearch.16")); //$NON-NLS-1$
	}
}