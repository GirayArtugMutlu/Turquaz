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
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.Messages;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.current.ui.comp.CurrentCodePicker;
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
public class InvUITransactionsTotalReport extends Composite implements SearchComposite
{
	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	InvBLCardUpdate cardUpdate = new InvBLCardUpdate();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private CurrentCodePicker txtCurCardEnd;
	private CLabel lblCurCarEnd;
	private CurrentCodePicker txtCurCardStart;
	private CLabel lblCurrentCard;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private TableColumn tableColumnBalanceUnitPrice;
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
					compInvCardSearchPanelLData.heightHint = 134;
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
					//START >>  lblCurrentCard
					lblCurrentCard = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("InvUIInventoryTransactionReport.2"));
					//END <<  lblCurrentCard
					//START >>  txtCurCardStart
					txtCurCardStart = new CurrentCodePicker(compInvCardSearchPanel, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 157;
					txtCurCardLData.heightHint = 17;
					txtCurCardStart.setLayoutData(txtCurCardLData);
					//END <<  txtCurCardStart
					//START >>  lblCurCarEnd
					lblCurCarEnd = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblCurCarEnd.setText(Messages.getString("InvUIInventoryTransactionReport.3"));
					//END <<  lblCurCarEnd
					//START >>  txtCurCardEnd
					txtCurCardEnd = new CurrentCodePicker(compInvCardSearchPanel, SWT.NONE);
					GridData txtCurCardEndLData = new GridData();
					txtCurCardEndLData.widthHint = 157;
					txtCurCardEndLData.heightHint = 17;
					txtCurCardEnd.setLayoutData(txtCurCardEndLData);
					//END <<  txtCurCardEnd
					//START >>  lblStartDate
					lblStartDate = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblStartDate.setText(Messages.getString("InvUIInventoryTransactionReport.4"));
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
					//END <<  lblStartDate
					//START >>  dateStartDate
					dateStartDate = new DatePicker(compInvCardSearchPanel, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 157;
					dateStartDateLData.heightHint = 23;
					dateStartDate.setLayoutData(dateStartDateLData);
					//END <<  dateStartDate
					//START >>  lblEndDate
					lblEndDate = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblEndDate.setText(Messages.getString("InvUIInventoryTransactionReport.5"));
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
					//END <<  lblEndDate
					//START >>  dateEndDate
					dateEndDate = new DatePicker(compInvCardSearchPanel, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 157;
					dateEndDateLData.heightHint = 23;
					dateEndDate.setLayoutData(dateEndDateLData);
					//END <<  dateEndDate
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
					//START >>  tableColumnBalanceUnitPrice
					tableColumnBalanceUnitPrice = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnBalanceUnitPrice.setText(Messages.getString("InvUITransactionsTotalReport.14")); //$NON-NLS-1$
					tableColumnBalanceUnitPrice.setWidth(80);
					//END <<  tableColumnBalanceUnitPrice
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
		Calendar cal=Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),0,1);
		dateStartDate.setDate(cal.getTime());
		fillComboGroup();
		createTableViewer();
	}

	public void fillComboGroup()
	{
		try
		{
			List groupList = (List)EngTXCommon.doSelectTX(InvBLCardAdd.class.getName(),"getParentInventoryGroups",null); //$NON-NLS-1$
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
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void save()
	{
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[14];
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
		columnTypes[13] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableSearcResults, columnTypes, false);
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
				HashMap argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD_ID,cardId);
				TurqInventoryCard invCard = (TurqInventoryCard)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCardById",argMap); //$NON-NLS-1$
				msg.setMessage(Messages.getString("InvUICardUpdateDialog.7")); //$NON-NLS-1$
				if (msg.open() == SWT.NO)
					return;
				// if the inventory card contains transactions
				argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD,invCard);
				Boolean hasTX=(Boolean)EngTXCommon.doSelectTX(InvBLCardUpdate.class.getName(),"hasTransactions",argMap); //$NON-NLS-1$
				if (hasTX.booleanValue())
				{
					MessageBox msg2 = new MessageBox(this.getShell(), SWT.ICON_WARNING);
					msg2.setMessage("Inventory card contains transactions and \ncan not be deleted. Delete them first. "); //$NON-NLS-1$
					msg2.open();
					return;
				}
				argMap=new HashMap();
				argMap.put(InvKeys.INV_CARD,invCard);					
				EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"deleteInventoryCard",argMap); //$NON-NLS-1$
				msg = new MessageBox(this.getShell(), SWT.NULL);
				msg.setMessage(Messages.getString("InvUICardUpdateDialog.6")); //$NON-NLS-1$
				msg.open();
				search();
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
		try
		{
			tableViewer.removeAll();
			HashMap argMap=new HashMap();
			TurqInventoryGroup invMainGroup=(TurqInventoryGroup)comboInvMainGroup.getData(comboInvMainGroup.getText());
			TurqInventoryGroup invSubGroup=(TurqInventoryGroup)comboInvSubGroup.getData(comboInvSubGroup.getText());
			argMap.put(InvKeys.INV_CARD_CODE_START,txtInvCodeStart.getText().trim());
			argMap.put(InvKeys.INV_CARD_CODE_END,txtInvCodeEnd.getText().trim());
			argMap.put(InvKeys.INV_CARD_NAME_START,txtInvNameStart.getText().trim());
			argMap.put(InvKeys.INV_CARD_NAME_END,txtInvNameEnd.getText().trim());
			argMap.put(EngKeys.CURRENT_CARD_START, txtCurCardStart.getText().trim());
			argMap.put(EngKeys.CURRENT_CARD_END,txtCurCardEnd.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(InvKeys.INV_MAIN_GROUP,invMainGroup);
			argMap.put(InvKeys.INV_SUB_GROUP,invSubGroup);
			argMap.put(InvKeys.INV_GROUP,comboInvSubGroup.getData(comboInvSubGroup.getText()));
			
			List result=(List)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"getTransactionTotalReport",argMap);
			int listSize = result.size();
			int currentGroupId=-2;
			Integer groupId=new Integer(-2);
			String groupName="";
			boolean giveTotal=false;
			BigDecimal TOTAL_TRANSOVER_PRICE=new BigDecimal(0);
			BigDecimal TOTAL_PRICE_IN=new BigDecimal(0);
			BigDecimal TOTAL_PRICE_OUT=new BigDecimal(0);
			BigDecimal TOTAL_BALANCE=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_TRANSOVER_PRICE=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_PRICE_IN=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_PRICE_OUT=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_BALANCE=new BigDecimal(0);
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < listSize; i++)
			{
				Object[] objs = (Object[]) result.get(i);
				Integer cardId=(Integer)objs[0];
				String invCode = objs[1].toString();
				String invName = objs[2].toString();
				BigDecimal totalAmountIn=((BigDecimal)objs[3]==null) ? new BigDecimal(0) : (BigDecimal)objs[3];
				BigDecimal totalPriceIn=((BigDecimal)objs[4]==null) ? new BigDecimal(0) : (BigDecimal)objs[4];
				BigDecimal totalAmountOut=((BigDecimal)objs[5]==null) ? new BigDecimal(0) : (BigDecimal)objs[5];
				BigDecimal totalPriceOut=((BigDecimal)objs[6]==null) ? new BigDecimal(0) : (BigDecimal)objs[6];
				BigDecimal totaltransOverAmountIn=((BigDecimal)objs[7]==null) ? new BigDecimal(0) : (BigDecimal)objs[7];
				BigDecimal totaltransOverPriceIn=((BigDecimal)objs[8]==null) ? new BigDecimal(0) : (BigDecimal)objs[8];
				BigDecimal totaltransOverAmountOut=((BigDecimal)objs[9]==null) ? new BigDecimal(0) : (BigDecimal)objs[9];
				BigDecimal totaltransOverPriceOut=((BigDecimal)objs[10]==null) ? new BigDecimal(0) : (BigDecimal)objs[10];
				
				
				if (invMainGroup != null)
				{
					groupId=(Integer)objs[11];
					groupName=(String)objs[12];
				}

				BigDecimal balanceAmount = totaltransOverAmountIn.add(totalAmountIn).subtract(totaltransOverAmountOut).subtract(
						totalAmountOut);
				BigDecimal balancePrice = (totalAmountIn.doubleValue() == 0) ? new BigDecimal(0) : balanceAmount
						.multiply(totalPriceIn.divide(totalAmountIn, 2, EngBLCommon.ROUNDING_METHOD));
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
				BigDecimal balanceTotalPrice=totalPriceIn.add(totaltransOverPriceIn);
				BigDecimal balanceTotalAmount=totalAmountIn.add(totaltransOverAmountIn);
				BigDecimal balanceUnitPrice=(balanceTotalAmount.doubleValue() ==0) ? new BigDecimal(0) :
					balanceTotalPrice.divide(balanceTotalAmount,2,EngBLCommon.ROUNDING_METHOD);
				
				BigDecimal transOverNetPrice=totaltransOverPriceIn.subtract(totaltransOverPriceOut);
				

				
				if (invMainGroup != null)
				{
					if (currentGroupId != groupId.intValue())
					{
						if (giveTotal)
						{
							tableViewer.addRow(new String[]{"","","TOPLAM",cf.format(TOTAL_TRANSOVER_PRICE),"","",cf.format(TOTAL_PRICE_IN),"","",cf.format(TOTAL_PRICE_OUT),"","",cf.format(TOTAL_BALANCE),""},null);
							tableViewer.addRow(new String[]{"","","","","","","","","","","","","",""},null);
						}
						TOTAL_TRANSOVER_PRICE=new BigDecimal(0);
						TOTAL_PRICE_IN=new BigDecimal(0);
						TOTAL_PRICE_OUT=new BigDecimal(0);
						TOTAL_BALANCE=new BigDecimal(0);
						tableViewer.addRow(new String[]{groupName,"","","","","","","","","","","","",""},null);
						giveTotal=true;
						currentGroupId=groupId.intValue();							
					}
				}
				
				TOTAL_TRANSOVER_PRICE=TOTAL_TRANSOVER_PRICE.add(transOverNetPrice);
				TOTAL_PRICE_IN=TOTAL_PRICE_IN.add(totalPriceIn);
				TOTAL_PRICE_OUT=TOTAL_PRICE_OUT.add(totalPriceOut);
				TOTAL_BALANCE=TOTAL_BALANCE.add(balancePrice);
				
				GENERAL_TOTAL_TRANSOVER_PRICE=GENERAL_TOTAL_TRANSOVER_PRICE.add(transOverNetPrice);
				GENERAL_TOTAL_PRICE_IN=GENERAL_TOTAL_PRICE_IN.add(totalPriceIn);
				GENERAL_TOTAL_PRICE_OUT=GENERAL_TOTAL_PRICE_OUT.add(totalPriceOut);
				GENERAL_TOTAL_BALANCE=GENERAL_TOTAL_BALANCE.add(balancePrice);
				
				tableViewer.addRow(new String[]{invCode, invName,
						cf.format(totaltransOverAmountIn.subtract(totaltransOverAmountOut)),
						cf.format(transOverNetPrice), cf.format(unitPriceTransover),
						cf.format(totalAmountIn), cf.format(totalPriceIn), cf.format(unitPriceIn), cf.format(totalAmountOut),
						cf.format(totalPriceOut), cf.format(unitPriceOut), cf.format(balanceAmount), cf.format(balancePrice),
						cf.format(balanceUnitPrice)},
						cardId);
				
				if (invMainGroup != null)
				{
					if (i==listSize-1)
					{
						tableViewer.addRow(new String[]{"","","TOPLAM",cf.format(TOTAL_TRANSOVER_PRICE),"","",cf.format(TOTAL_PRICE_IN),"","",cf.format(TOTAL_PRICE_OUT),"","",cf.format(TOTAL_BALANCE),""},null);
						tableViewer.addRow(new String[]{"","","","","","","","","","","","","",""},null);					
					}
				}
				
			}
			tableViewer.addRow(new String[]{"","","","","","","","","","","","","",""},null);
			tableViewer.addRow(new String[]{"","","GENEL TOPLAM",cf.format(GENERAL_TOTAL_TRANSOVER_PRICE),"","",cf.format(GENERAL_TOTAL_PRICE_IN),"","",cf.format(GENERAL_TOTAL_PRICE_OUT),"","",cf.format(GENERAL_TOTAL_BALANCE),""},null);
			
			
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
					TurqInventoryCard invCard = (TurqInventoryCard)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCardById",argMap); //$NON-NLS-1$
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
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableSearcResults, ""); //$NON-NLS-1$
	}
}