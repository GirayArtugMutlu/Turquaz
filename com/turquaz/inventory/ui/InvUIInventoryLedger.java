package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLInventoryLedger;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import com.turquaz.inventory.ui.comp.InventoryPicker;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CLabel;
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
public class InvUIInventoryLedger extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite compFilter;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnInvName;
	private Button btnWithBalance;
	private Button btnWithTrans;
	private Button btnAll;
	private Group groupInv;
	private InventoryPicker txtInvCode;
	private CLabel lblInvCode;
	private TableColumn tableColumnTotalPrice;
	private TableColumn tableColumnAvgPrice;
	private TableColumn tableColumnLastAmount;
	private DatePicker datePicker;
	private CLabel lblDate;
	private Table tableInventories;
	final int INV_ALL = 0;
	final int INV_WITH_TRANS = 1;
	final int INV_WITH_BALANCE = 2;
	private SearchTableViewer tableViewer = null;

	/**
	 * Bu Class Envanter Defterinin Cikarilmasini Saglar..
	 * 
	 * @param parent
	 * @param style
	 */
	public InvUIInventoryLedger(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(667, 356);
			{
				compFilter = new Composite(this, SWT.NONE);
				GridLayout compFilterLayout = new GridLayout();
				compFilterLayout.numColumns = 3;
				compFilterLayout.horizontalSpacing = 15;
				GridData compFilterLData = new GridData();
				compFilterLData.heightHint = 100;
				compFilterLData.grabExcessHorizontalSpace = true;
				compFilterLData.horizontalAlignment = GridData.FILL;
				compFilter.setLayoutData(compFilterLData);
				compFilter.setLayout(compFilterLayout);
				{
					lblDate = new CLabel(compFilter, SWT.NONE);
					lblDate.setText(EngLangCommonKeys.STR_DATE);
					GridData lblDateLData = new GridData();
					lblDateLData.widthHint = 51;
					lblDate.setLayoutData(lblDateLData);
				}
				{
					datePicker = new DatePicker(compFilter, SWT.NONE);
					GridData datePickerLData = new GridData();
					datePickerLData.widthHint = 157;
					datePickerLData.heightHint = 23;
					datePicker.setLayoutData(datePickerLData);
				}
				{
					groupInv = new Group(compFilter, SWT.NONE);
					GridLayout groupInvLayout = new GridLayout();
					GridData groupInvLData = new GridData();
					groupInvLData.widthHint = 255;
					groupInvLData.heightHint = 74;
					groupInvLData.verticalSpan = 2;
					groupInvLData.verticalAlignment = GridData.BEGINNING;
					groupInvLData.grabExcessHorizontalSpace = true;
					groupInvLData.horizontalIndent = 20;
					groupInv.setLayoutData(groupInvLData);
					groupInvLayout.makeColumnsEqualWidth = true;
					groupInv.setLayout(groupInvLayout);
					groupInv.setText(EngLangCommonKeys.STR_FILTER);
					{
						btnAll = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnAll.setText(InvLangKeys.STR_ALL_INV);
						btnAll.setSelection(true);
					}
					{
						btnWithTrans = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnWithTrans.setText(InvLangKeys.STR_HAS_TRANSACTIONS);
					}
					{
						btnWithBalance = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnWithBalance.setText(InvLangKeys.STR_HAS_BALANCE);
					}
				}
				{
					lblInvCode = new CLabel(compFilter, SWT.NONE);
					lblInvCode.setText(InvLangKeys.STR_INV_CODE);
					GridData lblInvCodeLData = new GridData();
					lblInvCodeLData.widthHint = 54;
					lblInvCodeLData.heightHint = 19;
					lblInvCodeLData.verticalAlignment = GridData.BEGINNING;
					lblInvCode.setLayoutData(lblInvCodeLData);
				}
				{
					txtInvCode = new InventoryPicker(compFilter, SWT.NONE);
					GridData txtInvCodeLData = new GridData();
					txtInvCodeLData.widthHint = 157;
					txtInvCodeLData.heightHint = 17;
					txtInvCodeLData.verticalAlignment = GridData.BEGINNING;
					txtInvCode.setLayoutData(txtInvCodeLData);
				}
			}
			{
				tableInventories = new Table(this, SWT.FULL_SELECTION);
				GridData table1LData = new GridData();
				tableInventories.setLinesVisible(true);
				tableInventories.setHeaderVisible(true);
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalAlignment = GridData.FILL;
				table1LData.verticalAlignment = GridData.FILL;
				tableInventories.setLayoutData(table1LData);
				{
					tableColumnInvCode = new TableColumn(tableInventories, SWT.NONE);
					tableColumnInvCode.setText(InvLangKeys.STR_INV_CODE);
					tableColumnInvCode.setWidth(87);
				}
				{
					tableColumnInvName = new TableColumn(tableInventories, SWT.NONE);
					tableColumnInvName.setText(InvLangKeys.STR_INV_NAME);
					tableColumnInvName.setWidth(88);
				}
				{
					tableColumnLastAmount = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnLastAmount.setText(InvLangKeys.STR_LAST_AMOUNT);
					tableColumnLastAmount.setWidth(100);
				}
				{
					tableColumnAvgPrice = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnAvgPrice.setText(InvLangKeys.STR_AVERAGE_PRICE);
					tableColumnAvgPrice.setWidth(100);
				}
				{
					tableColumnTotalPrice = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnTotalPrice.setText(EngLangCommonKeys.STR_TOTAL_PRICE);
					tableColumnTotalPrice.setWidth(100);
				}
			}
			this.layout();
			postInitGui();
		}
		catch (Exception e)
		{

            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void postInitGui()
	{
		createTableViewer();
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableInventories, columnTypes, true);
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			TurkishCurrencyFormat curFormat = new TurkishCurrencyFormat();
			HashMap argMap=new HashMap();
			argMap.put(EngKeys.DATE,datePicker.getDate());
			argMap.put(InvKeys.INV_CARD_CODE,txtInvCode.getText().trim());
			HashBag ledgerBag = (HashBag)EngTXCommon.doSelectTX(InvBLInventoryLedger.class.getName(),"getInventoryLedger",argMap);
			HashMap cards=(HashMap)ledgerBag.get(InvKeys.INV_CARDS);
			
			
			String invCode = ""; 
			String invName = "";
			BigDecimal amountIn = new BigDecimal(0);
			BigDecimal priceIn = new BigDecimal(0);
			BigDecimal amountOut = new BigDecimal(0);
			BigDecimal balanceAmount = new BigDecimal(0);
			BigDecimal avgPrice = new BigDecimal(0);
			BigDecimal totalPrice = new BigDecimal(0);
			int reportType = INV_ALL;
			if (btnAll.getSelection() == true)
			{
				reportType = INV_ALL;
			}
			else if (btnWithTrans.getSelection() == true)
			{
				reportType = INV_WITH_TRANS;
			}
			else if (btnWithBalance.getSelection() == true)
			{
				reportType = INV_WITH_BALANCE;
			}
			
			
			for (int i = 0; i < cards.size(); i++)
			{
				HashMap invCard=(HashMap)cards.get(new Integer(i));
				invCode =(String) invCard.get(InvKeys.INV_CARD_CODE);
				invName = (String) invCard.get(InvKeys.INV_CARD_NAME);
				amountIn = (BigDecimal)invCard.get(InvKeys.INV_AMOUNT_IN);
				priceIn = (BigDecimal)invCard.get(InvKeys.INV_PRICE_IN);
				amountOut = (BigDecimal)invCard.get(InvKeys.INV_AMOUNT_OUT);
				if (reportType == INV_ALL)
				{
					if (priceIn == null)
					{
						priceIn = new BigDecimal(0);
					}
					if (amountOut == null)
					{
						amountOut = new BigDecimal(0);
					}
					if (amountIn == null)
					{
						amountIn = new BigDecimal(0);
						avgPrice = new BigDecimal(0);
					}
					else
					{
						avgPrice = priceIn.divide(amountIn, 2, EngBLCommon.ROUNDING_METHOD);
					}
					balanceAmount = amountIn.subtract(amountOut);
					totalPrice = avgPrice.multiply(balanceAmount).setScale(2, EngBLCommon.ROUNDING_METHOD);
				}
				else if (reportType == INV_WITH_TRANS)
				{
					if (amountIn != null)
					{
						if (amountOut == null)
						{
							amountOut = new BigDecimal(0);
						}
						avgPrice = priceIn.divide(amountIn, 2, EngBLCommon.ROUNDING_METHOD);
						balanceAmount = amountIn.subtract(amountOut);
						totalPrice = avgPrice.multiply(balanceAmount).setScale(2, EngBLCommon.ROUNDING_METHOD);
					}
					else if (amountOut != null)
					{
						amountIn = new BigDecimal(0);
						avgPrice = new BigDecimal(0);
						balanceAmount = amountIn.subtract(amountOut);
						totalPrice = avgPrice.multiply(balanceAmount).setScale(2, EngBLCommon.ROUNDING_METHOD);
					}
					else
					{
						continue;
					}
				}
				else if (reportType == INV_WITH_BALANCE)
				{
					if (amountIn == null)
					{
						amountIn = new BigDecimal(0);
						avgPrice = new BigDecimal(0);
					}
					else
					{
						avgPrice = priceIn.divide(amountIn, 2, EngBLCommon.ROUNDING_METHOD);
					}
					if (amountOut == null)
					{
						amountOut = new BigDecimal(0);
					}
					balanceAmount = amountIn.subtract(amountOut);
					if (balanceAmount.doubleValue() == 0)
						continue;
					totalPrice = avgPrice.multiply(balanceAmount).setScale(2, EngBLCommon.ROUNDING_METHOD);
				}
				tableViewer.addRow(new String[]{invCode, invName,curFormat.format(balanceAmount), curFormat.format(avgPrice),
						curFormat.format(totalPrice)}, invCode);
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInventories, InvLangKeys.STR_INV_LEDGER);
	}
}