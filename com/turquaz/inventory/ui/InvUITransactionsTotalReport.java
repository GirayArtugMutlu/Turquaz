package com.turquaz.inventory.ui;

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
 * @author  Cem Dayanik
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.Messages;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLCardUpdate;
import com.turquaz.inventory.dal.InvDALCardUpdate;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import com.turquaz.inventory.ui.comp.InventoryPicker;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUITransactionsTotalReport extends Composite implements SearchComposite
{
	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	InvBLCardUpdate cardUpdate = new InvBLCardUpdate();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnUnitPriceOut;
	private TableColumn tableColumnUnitPriceIn;
	private TableColumn tableColumnUnitPriceTransOver;
	private CCombo comboInvSubGroup;
	private CLabel lblInvSubGroup;
	private CCombo comboInvMainGroup;
	private CLabel lblInvGroup;
	private TableColumn tableColumnTransOverAmount;
	private TableColumn tableColumnTransOverPrice;
	private CLabel lblInvNameEnd;
	private Text txtInvNameEnd;
	private CLabel lblInvCodeEnd;
	private InventoryPicker txtInvCodeEnd;
	private TableColumn tableColumnAmountIn;
	private TableColumn tableColumnInventoryCode;
	private TableColumn tableColumnAmountOut;
	private TableColumn tableColumnBalanceAmountIn;
	private TableColumn tableColumnBalanceAmountOut;
	private TableColumn tableColumnPriceIn;
	private TableColumn tableColumnPriceOut;
	private Table tableSearcResults;
	private Text txtInvNameStart;
	private InventoryPicker txtInvCodeStart;
	private CLabel lblInvCode;
	private Composite compInvCardSearchPanel;
	private SearchTableViewer tableViewer = null;

	public InvUITransactionsTotalReport(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(700, 437);
			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			{
				compInvCardSearch = new Composite(this, SWT.NONE);
				GridLayout compInvCardSearchLayout = new GridLayout();
				compInvCardSearchLayout.makeColumnsEqualWidth = true;
				compInvCardSearch.setLayout(compInvCardSearchLayout);
				{
					compInvCardSearchPanel = new Composite(compInvCardSearch, SWT.NONE);
					GridLayout compInvCardSearchPanelLayout = new GridLayout();
					compInvCardSearchPanelLayout.numColumns = 4;
					GridData compInvCardSearchPanelLData = new GridData();
					compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
					compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
					compInvCardSearchPanelLData.heightHint = 82;
					compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
					compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
					{
						lblInvCode = new CLabel(compInvCardSearchPanel, SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2LData.widthHint = 123;
						cLabel2LData.heightHint = 17;
						lblInvCode.setLayoutData(cLabel2LData);
						lblInvCode.setText(Messages.getString("InvUITransactionsTotalReport.0")); //$NON-NLS-1$
					}
					{
						txtInvCodeStart = new InventoryPicker(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeLData = new GridData();
						txtInvCodeLData.widthHint = 157;
						txtInvCodeLData.heightHint = 17;
						txtInvCodeStart.setLayoutData(txtInvCodeLData);
					}
					{
						lblInvCodeEnd = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvCodeEnd.setText(Messages.getString("InvUITransactionsTotalReport.1")); //$NON-NLS-1$
					}
					{
						txtInvCodeEnd = new InventoryPicker(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeEndLData = new GridData();
						txtInvCodeEndLData.widthHint = 157;
						txtInvCodeEndLData.heightHint = 17;
						txtInvCodeEnd.setLayoutData(txtInvCodeEndLData);
					}
					{
						lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvName.setText(Messages.getString("InvUITransactionsTotalReport.4")); //$NON-NLS-1$
						GridData lblInvNameLData = new GridData();
						lblInvNameLData.widthHint = 118;
						lblInvNameLData.heightHint = 16;
						lblInvName.setLayoutData(lblInvNameLData);
					}
					{
						txtInvNameStart = new Text(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvNameLData = new GridData();
						txtInvNameStart.addKeyListener(new KeyAdapter()
						{
							public void keyReleased(KeyEvent evt)
							{
								if (evt.keyCode == SWT.CR)
									search();
							}
						});
						txtInvNameLData.widthHint = 150;
						txtInvNameLData.heightHint = 17;
						txtInvNameStart.setLayoutData(txtInvNameLData);
					}
					{
						lblInvNameEnd = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvNameEnd.setText(Messages.getString("InvUITransactionsTotalReport.5")); //$NON-NLS-1$
					}
					{
						txtInvNameEnd = new Text(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvNameEndLData = new GridData();
						txtInvNameEndLData.widthHint = 150;
						txtInvNameEndLData.heightHint = 17;
						txtInvNameEnd.setLayoutData(txtInvNameEndLData);
					}
					//START >> lblInvGroup
					lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvGroup.setText(Messages.getString("InvUITransactionsTotalReport.2")); //$NON-NLS-1$
					GridData lblInvGroupLData = new GridData();
					lblInvGroupLData.widthHint = 85;
					lblInvGroupLData.heightHint = 19;
					lblInvGroup.setLayoutData(lblInvGroupLData);
					//END << lblInvGroup
					//START >> comboInvMainGroup
					comboInvMainGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
					GridData comboInvGroupLData = new GridData();
					comboInvMainGroup.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							comboInvMainGroupWidgetSelected(evt);
						}
					});
					comboInvGroupLData.widthHint = 134;
					comboInvGroupLData.heightHint = 17;
					comboInvMainGroup.setLayoutData(comboInvGroupLData);
					//END << comboInvMainGroup
					//START >> lblInvSubGroup
					lblInvSubGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvSubGroup.setText(Messages.getString("InvUITransactionsTotalReport.10")); //$NON-NLS-1$
					//END << lblInvSubGroup
					//START >> comboInvSubGroup
					comboInvSubGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
					GridData comboInvSubGroupLData = new GridData();
					comboInvSubGroupLData.widthHint = 134;
					comboInvSubGroupLData.heightHint = 17;
					comboInvSubGroup.setLayoutData(comboInvSubGroupLData);
					//END << comboInvSubGroup
				}
				{
					tableSearcResults = new Table(compInvCardSearch, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
					tableSearcResults.setHeaderVisible(true);
					tableSearcResults.setLinesVisible(true);
					tableSearcResults.setSize(new org.eclipse.swt.graphics.Point(543, 318));
					GridData tableSearcResultsLData = new GridData();
					tableSearcResults.addMouseListener(new MouseAdapter()
					{
						public void mouseDoubleClick(MouseEvent evt)
						{
							tableSearcResultsMouseDoubleClick(evt);
						}
					});
					tableSearcResultsLData.verticalAlignment = GridData.FILL;
					tableSearcResultsLData.horizontalAlignment = GridData.FILL;
					tableSearcResultsLData.grabExcessHorizontalSpace = true;
					tableSearcResultsLData.grabExcessVerticalSpace = true;
					tableSearcResults.setLayoutData(tableSearcResultsLData);
					{
						tableColumnInvName = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInvName.setText(Messages.getString("InvUITransactionsTotalReport.3")); //$NON-NLS-1$
						tableColumnInvName.setWidth(69);
					}
					{
						tableColumnInventoryCode = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInventoryCode.setText(Messages.getString("InvUICardSearch.4")); //$NON-NLS-1$
						tableColumnInventoryCode.setWidth(50);
					}
					{
						tableColumnTransOverAmount = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnTransOverAmount.setText(Messages.getString("InvUITransactionsTotalReport.6")); //$NON-NLS-1$
						tableColumnTransOverAmount.setWidth(50);
					}
					{
						tableColumnTransOverPrice = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnTransOverPrice.setText(Messages.getString("InvUITransactionsTotalReport.7")); //$NON-NLS-1$
						tableColumnTransOverPrice.setWidth(60);
					}
					//START >> tableColumnUnitPriceTransOver
					tableColumnUnitPriceTransOver = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceTransOver.setText(Messages.getString("InvUITransactionsTotalReport.11")); //$NON-NLS-1$
					tableColumnUnitPriceTransOver.setWidth(50);
					//END << tableColumnUnitPriceTransOver
					{
						tableColumnAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountIn.setText(Messages.getString("InvUICardSearch.5")); //$NON-NLS-1$
						tableColumnAmountIn.setWidth(60);
					}
					{
						tableColumnPriceIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceIn.setText(Messages.getString("InvUICardSearch.10")); //$NON-NLS-1$
						tableColumnPriceIn.setWidth(75);
					}
					//START >> tableColumnUnitPriceIn
					tableColumnUnitPriceIn = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceIn.setText(Messages.getString("InvUITransactionsTotalReport.12")); //$NON-NLS-1$
					tableColumnUnitPriceIn.setWidth(50);
					//END << tableColumnUnitPriceIn
					{
						tableColumnAmountOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountOut.setText(Messages.getString("InvUICardSearch.7")); //$NON-NLS-1$
						tableColumnAmountOut.setWidth(60);
					}
					{
						tableColumnPriceOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceOut.setText(Messages.getString("InvUICardSearch.11")); //$NON-NLS-1$
						tableColumnPriceOut.setWidth(76);
					}
					//START >> tableColumnUnitPriceOut
					tableColumnUnitPriceOut = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceOut.setText(Messages.getString("InvUITransactionsTotalReport.13")); //$NON-NLS-1$
					tableColumnUnitPriceOut.setWidth(50);
					//END << tableColumnUnitPriceOut
					{
						tableColumnBalanceAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalanceAmountIn.setText(Messages.getString("InvUITransactionsTotalReport.8")); //$NON-NLS-1$
						tableColumnBalanceAmountIn.setWidth(69);
					}
					{
						tableColumnBalanceAmountOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalanceAmountOut.setText(Messages.getString("InvUITransactionsTotalReport.9")); //$NON-NLS-1$
						tableColumnBalanceAmountOut.setWidth(71);
					}
				}
			}
			thisLayout.type = SWT.HORIZONTAL;
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.spacing = 0;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		fillComboGroup();
		createTableViewer();
	}

	public void fillComboGroup()
	{
		try
		{
			List groupList = InvBLCardAdd.getParentInventoryGroups();
			comboInvMainGroup.add(""); //$NON-NLS-1$
			for (int k = 0; k < groupList.size(); k++)
			{
				TurqInventoryGroup gr = (TurqInventoryGroup) groupList.get(k);
				comboInvMainGroup.add(gr.getGroupsName());
				comboInvMainGroup.setData(gr.getGroupsName(), gr);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
		}
	}

	public void save()
	{
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[13];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[8] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[9] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[10] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[11] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[12] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableSearcResults, columnTypes, true);
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.YES | SWT.NO);
		try
		{
			TableItem items[] = tableSearcResults.getSelection();
			if (items.length > 0)
			{
				Integer cardId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				TurqInventoryCard invCard = InvBLCardSearch.initializeInventoryCard(cardId);
				msg.setMessage(Messages.getString("InvUICardUpdateDialog.7")); //$NON-NLS-1$
				if (msg.open() == SWT.NO)
					return;
				// if the inventory card contains transactions
				if (InvDALCardUpdate.hasTransactions(invCard))
				{
					MessageBox msg2 = new MessageBox(this.getShell(), SWT.ICON_WARNING);
					msg2.setMessage("Inventory card contains transactions and \ncan not be deleted. Delete them first. "); //$NON-NLS-1$
					msg2.open();
					return;
				}
				InvBLCardUpdate.deleteInventoryCard(invCard);
				msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("InvUICardUpdateDialog.6")); //$NON-NLS-1$
				msg.open();
				search();
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg = new MessageBox(this.getShell(), SWT.ICON_ERROR);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void newForm()
	{
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			List result = InvBLCardSearch.searchCardsAdvanced(txtInvCodeStart.getText().trim(), txtInvCodeEnd.getText().trim(),
					txtInvNameStart.getText().trim(), txtInvNameEnd.getText().trim(), (TurqInventoryGroup) comboInvSubGroup
							.getData(comboInvSubGroup.getText()));
			int listSize = result.size();
			for (int i = 0; i < listSize; i++)
			{
				Object[] objs = (Object[]) result.get(i);
				String invCode = objs[1].toString();
				String invName = objs[2].toString();
				Integer cardId = (Integer) objs[3];
				TurqViewInventoryTotal invView = (TurqViewInventoryTotal) ((Object[]) result.get(i))[0];
				boolean add = false;
				if (invView.getTotalAmountIn() != null)
					add = true;
				else if (invView.getTotalAmountOut() != null)
					add = true;
				else if (invView.getTotalPriceIn() != null)
					add = true;
				else if (invView.getTotalPriceOut() != null)
					add = true;
				else if (invView.getTotalTransoverPriceIn() != null)
					add = true;
				else if (invView.getTotalTransoverAmountIn() != null)
					add = true;
				else if (invView.getTotalTransoverPriceOut() != null)
					add = true;
				else if (invView.getTotalTransoverAmountOut() != null)
					add = true;
				if (add)
				{
					BigDecimal totalAmountIn = (invView.getTotalAmountIn() == null) ? new BigDecimal(0) : invView.getTotalAmountIn();
					BigDecimal totalAmountOut = (invView.getTotalAmountOut() == null) ? new BigDecimal(0) : invView
							.getTotalAmountOut();
					BigDecimal totalPriceIn = (invView.getTotalPriceIn() == null) ? new BigDecimal(0) : invView.getTotalPriceIn();
					BigDecimal totalPriceOut = (invView.getTotalPriceOut() == null) ? new BigDecimal(0) : invView.getTotalPriceOut();
					BigDecimal totaltransOverPriceIn = (invView.getTotalTransoverPriceIn() == null) ? new BigDecimal(0) : invView
							.getTotalTransoverPriceIn();
					BigDecimal totaltransOverAmountIn = (invView.getTotalTransoverAmountIn() == null) ? new BigDecimal(0) : invView
							.getTotalTransoverAmountIn();
					BigDecimal totaltransOverPriceOut = (invView.getTotalTransoverPriceOut() == null) ? new BigDecimal(0) : invView
							.getTotalTransoverPriceOut();
					BigDecimal totaltransOverAmountOut = (invView.getTotalTransoverAmountOut() == null) ? new BigDecimal(0) : invView
							.getTotalTransoverAmountOut();
					BigDecimal balanceAmount = totaltransOverAmountIn.add(totalAmountIn).subtract(totaltransOverAmountOut).subtract(
							totalAmountOut);
					BigDecimal balancePrice = (totalAmountIn.doubleValue() == 0) ? new BigDecimal(0) : balanceAmount
							.multiply(totalPriceIn.divide(totalAmountIn, 2, BigDecimal.ROUND_HALF_DOWN));
					BigDecimal unitPriceTransover = new BigDecimal(0);
					BigDecimal unitPriceIn = new BigDecimal(0);
					BigDecimal unitPriceOut = new BigDecimal(0);
					if (totalAmountIn.doubleValue() != 0)
					{
						unitPriceIn = totalPriceIn.divide(totalAmountIn, 2, EngBLCommon.ROUNDING_METHOD);
					}
					if (totalAmountOut.doubleValue() != 0)
					{
						unitPriceOut = totalPriceOut.divide(totalAmountOut, 2, EngBLCommon.ROUNDING_METHOD);
					}
					BigDecimal transOverAmountNet = totaltransOverAmountIn.subtract(totaltransOverAmountOut);
					BigDecimal transOverPriceNet = totaltransOverPriceIn.subtract(totaltransOverPriceOut);
					if (transOverAmountNet.doubleValue() != 0)
					{
						unitPriceTransover = transOverPriceNet.divide(transOverAmountNet, 2, EngBLCommon.ROUNDING_METHOD);
					}
					TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
					tableViewer.addRow(new String[]{invCode, invName,
							cf.format(totaltransOverAmountIn.subtract(totaltransOverAmountOut)),
							cf.format(totaltransOverPriceIn.subtract(totaltransOverPriceOut)), cf.format(unitPriceTransover),
							cf.format(totalAmountIn), cf.format(totalPriceIn), cf.format(unitPriceIn), cf.format(totalAmountOut),
							cf.format(totalPriceOut), cf.format(unitPriceOut), cf.format(balanceAmount), cf.format(balancePrice)},
							cardId);
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

	/**
	 * This static method creates a new instance of this class and shows it inside a new Shell. It is a convenience method for showing the
	 * GUI, but it can be copied and used as a basis for your own code. * It is auto-generated code - the body of this method will be
	 * re-generated after any changes are made to the GUI. However, if you delete this method it will not be re-created.
	 */
	public static void showGUI()
	{
		try
		{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUITransactionsTotalReport inst = new InvUITransactionsTotalReport(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0, 0, 573, 437);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Auto-generated event handler method */
	protected void tableSearcResultsMouseDoubleClick(MouseEvent evt)
	{
		TableItem[] selection = tableSearcResults.getSelection();
		if (selection.length > 0)
		{
			try
			{
				Integer cardId = (Integer) ((ITableRow) selection[0].getData()).getDBObject();
				TurqInventoryCard card = InvBLCardSearch.initializeInventoryCard(cardId);
				boolean updated = new InvUICardUpdateDialog(this.getShell(), SWT.NULL, card).open();
				if (updated)
					search();
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
			}
		}
	}

	private void comboInvMainGroupWidgetSelected(SelectionEvent evt)
	{
		comboInvSubGroup.removeAll();
		if (comboInvMainGroup.getSelectionIndex() == -1)
			return;
		TurqInventoryGroup invMainGr = (TurqInventoryGroup) comboInvMainGroup.getData(comboInvMainGroup.getText());
		if (invMainGr != null)
		{
			Iterator it = invMainGr.getTurqInventoryGroups().iterator();
			comboInvSubGroup.add(""); //$NON-NLS-1$
			while (it.hasNext())
			{
				TurqInventoryGroup invGr = (TurqInventoryGroup) it.next();
				comboInvSubGroup.add(invGr.getGroupsName());
				comboInvSubGroup.setData(invGr.getGroupsName(), invGr);
			}
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableSearcResults);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableSearcResults, ""); //$NON-NLS-1$
	}
}