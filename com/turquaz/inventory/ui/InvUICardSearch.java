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
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLCardUpdate;
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
public class InvUICardSearch extends Composite implements SearchComposite
{
	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	InvBLCardUpdate cardUpdate = new InvBLCardUpdate();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private CLabel lblInvSubGroup;
	private CCombo comboInvSubGroup;
	private CCombo comboInvMainGroup;
	private CLabel lblInvGroup;
	private TableColumn tableColumnInvCode;
	private TableColumn tableColumnAmountIn;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnAmountOut;
	private TableColumn tableColumnBalanceAmountIn;
	private TableColumn tableColumnBalanceAmountOut;
	private TableColumn tableColumnPriceIn;
	private TableColumn tableColumnPriceOut;
	private Table tableSearcResults;
	private Text txtInvName;
	private InventoryPicker txtInvCode;
	private CLabel lblInvCode;
	private Composite compInvCardSearchPanel;
	private SearchTableViewer tableViewer = null;

	public InvUICardSearch(Composite parent, int style)
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
			this.setSize(new org.eclipse.swt.graphics.Point(573, 437));
			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			{
				compInvCardSearch = new Composite(this, SWT.NONE);
				GridLayout compInvCardSearchLayout = new GridLayout();
				compInvCardSearchLayout.makeColumnsEqualWidth = true;
				compInvCardSearch.setLayout(compInvCardSearchLayout);
				compInvCardSearch.setSize(new org.eclipse.swt.graphics.Point(573, 437));
				{
					compInvCardSearchPanel = new Composite(compInvCardSearch, SWT.NONE);
					GridLayout compInvCardSearchPanelLayout = new GridLayout();
					compInvCardSearchPanelLayout.numColumns = 4;
					GridData compInvCardSearchPanelLData = new GridData();
					compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
					compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
					compInvCardSearchPanelLData.heightHint = 71;
					compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
					compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
					{
						lblInvCode = new CLabel(compInvCardSearchPanel, SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2LData.widthHint = 97;
						cLabel2LData.heightHint = 17;
						lblInvCode.setLayoutData(cLabel2LData);
						lblInvCode.setText(InvLangKeys.STR_INV_CODE);
						lblInvCode.setSize(new org.eclipse.swt.graphics.Point(97, 17));
					}
					{
						txtInvCode = new InventoryPicker(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeLData = new GridData();
						txtInvCodeLData.widthHint = 141;
						txtInvCodeLData.heightHint = 17;
						txtInvCode.setLayoutData(txtInvCodeLData);
						txtInvCode.setSize(new org.eclipse.swt.graphics.Point(147, 17));
					}
					{
						lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvName.setText(InvLangKeys.STR_INV_NAME);
						lblInvName.setSize(100, 18);
						GridData lblInvNameLData = new GridData();
						lblInvNameLData.widthHint = 100;
						lblInvNameLData.heightHint = 18;
						lblInvName.setLayoutData(lblInvNameLData);
					}
					{
						txtInvName = new Text(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvNameLData = new GridData();
						txtInvName.addKeyListener(new KeyAdapter()
						{
							public void keyReleased(KeyEvent evt)
							{
								if (evt.keyCode == SWT.CR)
									search();
							}
						});
						txtInvNameLData.widthHint = 141;
						txtInvNameLData.heightHint = 17;
						txtInvName.setLayoutData(txtInvNameLData);
					}
					//START >> lblInvGroup
					lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvGroup.setText(InvLangKeys.STR_INV_MAIN_GROUP);
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
					comboInvGroupLData.widthHint = 127;
					comboInvGroupLData.heightHint = 18;
					comboInvMainGroup.setLayoutData(comboInvGroupLData);
					//END << comboInvMainGroup
					//START >> lblInvSubGroup
					lblInvSubGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvSubGroup.setText(InvLangKeys.STR_INV_SUB_GROUP);
					//END << lblInvSubGroup
					//START >> comboInvSubGroup
					comboInvSubGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
					GridData comboInvSubGroupLData = new GridData();
					comboInvSubGroupLData.widthHint = 125;
					comboInvSubGroupLData.heightHint = 13;
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
						tableColumnInvCode = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInvCode.setText(InvLangKeys.STR_INV_CODE);
						tableColumnInvCode.setWidth(69);
					}
					{
						tableColumnInvName = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInvName.setText(InvLangKeys.STR_INV_NAME);
						tableColumnInvName.setWidth(107);
					}
					{
						tableColumnAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountIn.setText(InvLangKeys.STR_AMOUNT_IN);
						tableColumnAmountIn.setWidth(60);
					}
					{
						tableColumnAmountOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountOut.setText(InvLangKeys.STR_AMOUNT_OUT);
						tableColumnAmountOut.setWidth(60);
					}
					{
						tableColumnBalanceAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalanceAmountIn.setText(InvLangKeys.STR_BALANCE_AMOUNT_IN);
						tableColumnBalanceAmountIn.setWidth(69);
					}
					{
						tableColumnBalanceAmountOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalanceAmountOut.setText(InvLangKeys.STR_BALANCE_AMOUNT_OUT);
						tableColumnBalanceAmountOut.setWidth(71);
					}
					{
						tableColumnPriceIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceIn.setText(InvLangKeys.STR_PRICE_IN);
						tableColumnPriceIn.setWidth(75);
					}
					{
						tableColumnPriceOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceOut.setText(InvLangKeys.STR_PRICE_OUT);
						tableColumnPriceOut.setWidth(76);
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
            EngBLLogger.log(this.getClass(),e,getShell());
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

	public void createTableViewer()
	{
		int columnTypes[] = new int[8];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[7] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableSearcResults, columnTypes, true);
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
			while (it.hasNext())
			{
				TurqInventoryGroup invGr = (TurqInventoryGroup) it.next();
				comboInvSubGroup.add(invGr.getGroupsName());
				comboInvSubGroup.setData(invGr.getGroupsName(), invGr);
			}
			if (comboInvSubGroup.getItemCount() > 0)
				comboInvSubGroup.setText(comboInvSubGroup.getItem(0));
		}
	}

	public void fillComboGroup()
	{
		try
		{
			List groupList =(List)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null);
			comboInvMainGroup.add("");
			for (int k = 0; k < groupList.size(); k++)
			{
				TurqInventoryGroup gr = (TurqInventoryGroup) groupList.get(k);
				comboInvMainGroup.add(gr.getGroupsName());
				comboInvMainGroup.setData(gr.getGroupsName(), gr);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void save()
	{
	}

	public void delete()
	{
		try
		{
			TableItem items[] = tableSearcResults.getSelection();
			if (items.length > 0)
			{
				Integer cardId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (cardId != null)
				{
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD_ID,cardId);
					TurqInventoryCard invCard = (TurqInventoryCard)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCardById",argMap);
					boolean okToDelete=EngUICommon.okToDelete(getShell());
					if (!okToDelete)
						return;
					
					// if the inventory card contains transactions
					argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD,invCard);
					Boolean hasTX=(Boolean)EngTXCommon.doSelectTX(InvBLCardUpdate.class.getName(),"hasTransactions",argMap);
					if (hasTX.booleanValue())
					{
						EngUICommon.showMessageBox(getShell(),InvLangKeys.MSG_INV_CARD_HAS_TRANSACTION,SWT.ICON_WARNING);
						return;
					}
					argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD,invCard);					
					EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"deleteInventoryCard",argMap);
					
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

	public void newForm()
	{
	}

	public void search()
	{
		tableViewer.removeAll();
		try
		{
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD_NAME,txtInvName.getText().trim());
			argMap.put(InvKeys.INV_CARD_CODE, txtInvCode.getText().trim());
			argMap.put(InvKeys.INV_GROUP,comboInvSubGroup.getData(comboInvSubGroup.getText()));
			List result =(List)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"searchCards",argMap);
			int listSize = result.size();
			for (int i = 0; i < listSize; i++)
			{
				Object[] objs = (Object[]) result.get(i);
				String invCode = objs[1].toString();
				String invName = objs[2].toString();
				Integer cardId = (Integer) objs[3];
				TurqViewInventoryTotal invView = (TurqViewInventoryTotal) ((Object[]) result.get(i))[0];
				BigDecimal totalAmountIn = (invView.getTotalAmountIn() == null) ? new BigDecimal(0) : invView.getTotalAmountIn();
				BigDecimal totalAmountOut = (invView.getTotalAmountOut() == null) ? new BigDecimal(0) : invView.getTotalAmountOut();
				BigDecimal totalPriceIn = (invView.getTotalPriceIn() == null) ? new BigDecimal(0) : invView.getTotalPriceIn();
				BigDecimal totalPriceOut = (invView.getTotalPriceOut() == null) ? new BigDecimal(0) : invView.getTotalPriceOut();
				BigDecimal balanceAmountIn = new BigDecimal(0);
				BigDecimal balanceAmountOut = new BigDecimal(0);
				if ((totalAmountIn.subtract(totalAmountOut).doubleValue() <= 0))
				{
					balanceAmountOut = totalAmountOut.subtract(totalAmountIn);
				}
				else
				{
					balanceAmountIn = totalAmountIn.subtract(totalAmountOut);
				}
				TurkishCurrencyFormat format = new TurkishCurrencyFormat();
				tableViewer.addRow(new String[]{invCode, invName, totalAmountIn.toString(), totalAmountOut.toString(),
						balanceAmountIn.toString(), balanceAmountOut.toString(), format.format(totalPriceIn),
						format.format(totalPriceOut)}, cardId);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
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
				if (cardId != null)
				{
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD_ID,cardId);
					TurqInventoryCard invCard = (TurqInventoryCard)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCardById",argMap);
					boolean updated = new InvUICardUpdateDialog(this.getShell(), SWT.NULL, invCard).open();
					if (updated)
						search();
				}
			}
			catch (Exception ex)
			{
                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableSearcResults, InvLangKeys.STR_INV_CARDS);
	}
}