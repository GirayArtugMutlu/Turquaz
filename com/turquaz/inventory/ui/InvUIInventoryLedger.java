package com.turquaz.inventory.ui;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.Messages;
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
					lblDate.setText("Tarih"); //$NON-NLS-1$
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
					groupInv.setText("Filtre");
					{
						btnAll = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnAll.setText("Bütün Stoklar");
						btnAll.setSelection(true);
					}
					{
						btnWithTrans = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnWithTrans.setText("Hareketliler");
					}
					{
						btnWithBalance = new Button(groupInv, SWT.RADIO | SWT.LEFT);
						btnWithBalance.setText("Bakiyeliler");
					}
				}
				{
					lblInvCode = new CLabel(compFilter, SWT.NONE);
					lblInvCode.setText("Stok Kodu");
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
					tableColumnInvCode.setText(Messages.getString("InvUIInventoryLedger.0")); //$NON-NLS-1$
					tableColumnInvCode.setWidth(87);
				}
				{
					tableColumnInvName = new TableColumn(tableInventories, SWT.NONE);
					tableColumnInvName.setText(Messages.getString("InvUIInventoryLedger.1")); //$NON-NLS-1$
					tableColumnInvName.setWidth(88);
				}
				{
					tableColumnLastAmount = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnLastAmount.setText(Messages.getString("InvUIInventoryLedger.2")); //$NON-NLS-1$
					tableColumnLastAmount.setWidth(100);
				}
				{
					tableColumnAvgPrice = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnAvgPrice.setText(Messages.getString("InvUIInventoryLedger.3")); //$NON-NLS-1$
					tableColumnAvgPrice.setWidth(100);
				}
				{
					tableColumnTotalPrice = new TableColumn(tableInventories, SWT.RIGHT);
					tableColumnTotalPrice.setText(Messages.getString("InvUIInventoryLedger.4")); //$NON-NLS-1$
					tableColumnTotalPrice.setWidth(100);
				}
			}
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
			List list = (List)EngTXCommon.doSingleTX(InvBLInventoryLedger.class.getName(),"getInventoryLedger",argMap);
			Object[] result;
			String invCode = ""; //$NON-NLS-1$
			String invName = ""; //$NON-NLS-1$
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
			for (int i = 0; i < list.size(); i++)
			{
				result = (Object[]) list.get(i);
				invCode = result[0].toString();
				invName = result[1].toString();
				amountIn = (BigDecimal) result[2];
				priceIn = (BigDecimal) result[3];
				amountOut = (BigDecimal) result[4];
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
						avgPrice = priceIn.divide(amountIn, 2, BigDecimal.ROUND_HALF_DOWN);
					}
					balanceAmount = amountIn.subtract(amountOut);
					totalPrice = avgPrice.multiply(balanceAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				}
				else if (reportType == INV_WITH_TRANS)
				{
					if (amountIn != null)
					{
						if (amountOut == null)
						{
							amountOut = new BigDecimal(0);
						}
						avgPrice = priceIn.divide(amountIn, 2, BigDecimal.ROUND_HALF_DOWN);
						balanceAmount = amountIn.subtract(amountOut);
						totalPrice = avgPrice.multiply(balanceAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
					}
					else if (amountOut != null)
					{
						amountIn = new BigDecimal(0);
						avgPrice = new BigDecimal(0);
						balanceAmount = amountIn.subtract(amountOut);
						totalPrice = avgPrice.multiply(balanceAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
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
						avgPrice = priceIn.divide(amountIn, 2, BigDecimal.ROUND_HALF_DOWN);
					}
					if (amountOut == null)
					{
						amountOut = new BigDecimal(0);
					}
					balanceAmount = amountIn.subtract(amountOut);
					if (balanceAmount.doubleValue() == 0)
						continue;
					totalPrice = avgPrice.multiply(balanceAmount).setScale(2, BigDecimal.ROUND_HALF_DOWN);
				}
				tableViewer.addRow(new String[]{invCode, invName, balanceAmount.toString(), curFormat.format(avgPrice),
						curFormat.format(totalPrice)}, invCode);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void delete()
	{
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableInventories);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInventories, Messages.getString("InvUIInventoryLedger.5")); //$NON-NLS-1$
	}
}