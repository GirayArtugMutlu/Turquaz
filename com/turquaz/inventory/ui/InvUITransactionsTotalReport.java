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
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
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
	private TableColumn tableColumnInvCode;
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
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnAmountOut;
	private TableColumn tableColumnBalanceAmountIn;
	private TableColumn tableColumnBalancePrice;
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
						lblInvCode.setText(InvLangKeys.STR_INV_CODE_START);
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
						lblInvCodeEnd.setText(InvLangKeys.STR_INV_CODE_END);
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
						lblInvName.setText(InvLangKeys.STR_INV_NAME_START);
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
						lblInvNameEnd.setText(InvLangKeys.STR_INV_NAME_END);
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
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD_START);
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
					lblCurCarEnd.setText(CurLangKeys.STR_CUR_CARD_END);
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
					lblStartDate.setText(EngLangCommonKeys.STR_START_DATE);
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
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
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
					comboInvGroupLData.widthHint = 134;
					comboInvGroupLData.heightHint = 17;
					comboInvMainGroup.setLayoutData(comboInvGroupLData);
					//END << comboInvMainGroup
					//START >> lblInvSubGroup
					lblInvSubGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvSubGroup.setText(InvLangKeys.STR_INV_SUB_GROUP);
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
						tableColumnInvCode = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInvCode.setText(InvLangKeys.STR_INV_CODE);
						tableColumnInvCode.setWidth(69);
					}
					{
						tableColumnInvName = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnInvName.setText(InvLangKeys.STR_INV_NAME);
						tableColumnInvName.setWidth(50);
					}
					{
						tableColumnTransOverAmount = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnTransOverAmount.setText(InvLangKeys.STR_TRANSOVER_AMOUNT);
						tableColumnTransOverAmount.setWidth(50);
					}
					{
						tableColumnTransOverPrice = new TableColumn(tableSearcResults, SWT.NONE);
						tableColumnTransOverPrice.setText(InvLangKeys.STR_TRANSOVER_PRICE);
						tableColumnTransOverPrice.setWidth(60);
					}
					//START >> tableColumnUnitPriceTransOver
					tableColumnUnitPriceTransOver = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceTransOver.setText(InvLangKeys.STR_TRANSOVER_UNIT_PRICE);
					tableColumnUnitPriceTransOver.setWidth(50);
					//END << tableColumnUnitPriceTransOver
					{
						tableColumnAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountIn.setText(InvLangKeys.STR_AMOUNT_IN);
						tableColumnAmountIn.setWidth(60);
					}
					{
						tableColumnPriceIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceIn.setText(InvLangKeys.STR_PRICE_IN);
						tableColumnPriceIn.setWidth(75);
					}
					//START >> tableColumnUnitPriceIn
					tableColumnUnitPriceIn = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceIn.setText(InvLangKeys.STR_UNIT_PRICE_IN);
					tableColumnUnitPriceIn.setWidth(50);
					//END << tableColumnUnitPriceIn
					{
						tableColumnAmountOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnAmountOut.setText(InvLangKeys.STR_AMOUNT_OUT);
						tableColumnAmountOut.setWidth(60);
					}
					{
						tableColumnPriceOut = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnPriceOut.setText(InvLangKeys.STR_PRICE_OUT);
						tableColumnPriceOut.setWidth(76);
					}
					//START >> tableColumnUnitPriceOut
					tableColumnUnitPriceOut = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnUnitPriceOut.setText(InvLangKeys.STR_UNIT_PRICE_OUT);
					tableColumnUnitPriceOut.setWidth(50);
					//END << tableColumnUnitPriceOut
					{
						tableColumnBalanceAmountIn = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalanceAmountIn.setText(InvLangKeys.STR_BALANCE_AMOUNT_IN);
						tableColumnBalanceAmountIn.setWidth(69);
					}
					{
						tableColumnBalancePrice = new TableColumn(tableSearcResults, SWT.RIGHT);
						tableColumnBalancePrice.setText(InvLangKeys.STR_BALANCE_PRICE);
						tableColumnBalancePrice.setWidth(71);
					}
					//START >>  tableColumnBalanceUnitPrice
					tableColumnBalanceUnitPrice = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnBalanceUnitPrice.setText(InvLangKeys.STR_BALANCE_UNIT_PRICE);
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
		try
		{
			TableItem items[] = tableSearcResults.getSelection();
			if (items.length > 0)
			{
				Integer cardId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				
				boolean okToDelete=EngUICommon.okToDelete(getShell());
				if (okToDelete)
				{
					HashMap argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD_ID,cardId);
					TurqInventoryCard invCard = (TurqInventoryCard)EngTXCommon.doSelectTX(InvBLCardSearch.class.getName(),"initializeInventoryCardById",argMap); //$NON-NLS-1$
					// if the inventory card contains transactions
					argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD,invCard);
					Boolean hasTX=(Boolean)EngTXCommon.doSelectTX(InvBLCardUpdate.class.getName(),"hasTransactions",argMap); //$NON-NLS-1$
					if (hasTX.booleanValue())
					{
						EngUICommon.showMessageBox(getShell(),InvLangKeys.MSG_INV_CARD_HAS_TRANSACTION,SWT.ICON_WARNING);
						return;
					}
					argMap=new HashMap();
					argMap.put(InvKeys.INV_CARD,invCard);					
					EngTXCommon.doTransactionTX(InvBLCardUpdate.class.getName(),"deleteInventoryCard",argMap); //$NON-NLS-1$
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
			BigDecimal GENERAL_TOTAL_TRANSOVER_AMOUNT=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_AMOUNT_IN=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_AMOUNT_OUT=new BigDecimal(0);
			BigDecimal GENERAL_TOTAL_BALANCE_IN=new BigDecimal(0);
			
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
							tableViewer.addRow(new String[]{"","",EngLangCommonKeys.STR_TOTAL_CAPITAL,cf.format(TOTAL_TRANSOVER_PRICE),"","",cf.format(TOTAL_PRICE_IN),"","",cf.format(TOTAL_PRICE_OUT),"","",cf.format(TOTAL_BALANCE),""},null);
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
				GENERAL_TOTAL_TRANSOVER_AMOUNT=GENERAL_TOTAL_TRANSOVER_AMOUNT.add(transOverAmountNet);
				GENERAL_TOTAL_AMOUNT_IN=GENERAL_TOTAL_AMOUNT_IN.add(totalAmountIn);
				GENERAL_TOTAL_AMOUNT_OUT=GENERAL_TOTAL_AMOUNT_OUT.add(totalAmountOut);
				GENERAL_TOTAL_BALANCE_IN=totalAmountOut.add(balanceAmount);
				
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
						tableViewer.addRow(new String[]{"","",EngLangCommonKeys.STR_TOTAL_CAPITAL,cf.format(TOTAL_TRANSOVER_PRICE),"","",cf.format(TOTAL_PRICE_IN),"","",cf.format(TOTAL_PRICE_OUT),"","",cf.format(TOTAL_BALANCE),""},null);
						tableViewer.addRow(new String[]{"","","","","","","","","","","","","",""},null);					
					}
				}
				
			}
			BigDecimal averageTransOverUnitPrice=new BigDecimal(0);
			BigDecimal averageUnitPriceIn=new BigDecimal(0);
			BigDecimal averageUnitPriceOut=new BigDecimal(0);
			BigDecimal averageBalanceUnitPrice=new BigDecimal(0);
			
			if (GENERAL_TOTAL_TRANSOVER_AMOUNT.doubleValue()!=0)
			{
				averageTransOverUnitPrice=GENERAL_TOTAL_TRANSOVER_PRICE.divide(GENERAL_TOTAL_TRANSOVER_AMOUNT,4,EngBLCommon.ROUNDING_METHOD);
			}
			if (GENERAL_TOTAL_AMOUNT_IN.doubleValue() != 0)
			{
				averageUnitPriceIn=GENERAL_TOTAL_PRICE_IN.divide(GENERAL_TOTAL_AMOUNT_IN,4,EngBLCommon.ROUNDING_METHOD);
			}
			if (GENERAL_TOTAL_AMOUNT_OUT.doubleValue() != 0)
			{
				averageUnitPriceOut=GENERAL_TOTAL_PRICE_OUT.divide(GENERAL_TOTAL_AMOUNT_OUT,4,EngBLCommon.ROUNDING_METHOD);
			}
			if (GENERAL_TOTAL_BALANCE_IN.doubleValue() !=0)
			{
				averageBalanceUnitPrice=GENERAL_TOTAL_BALANCE.divide(GENERAL_TOTAL_BALANCE_IN,4,EngBLCommon.ROUNDING_METHOD);
			}
			
			tableViewer.addRow(new String[]{"","","","","","","","","","","","","",""},null);
			tableViewer.addRow(new String[]{"",EngLangCommonKeys.STR_GENERAL_TOTAL_CAPITAL,cf.format(GENERAL_TOTAL_TRANSOVER_AMOUNT),cf.format(GENERAL_TOTAL_TRANSOVER_PRICE),cf.format(averageTransOverUnitPrice),cf.format(GENERAL_TOTAL_AMOUNT_IN),cf.format(GENERAL_TOTAL_PRICE_IN),cf.format(averageUnitPriceIn),cf.format(GENERAL_TOTAL_AMOUNT_OUT),cf.format(GENERAL_TOTAL_PRICE_OUT),cf.format(averageUnitPriceOut),cf.format(GENERAL_TOTAL_BALANCE_IN),cf.format(GENERAL_TOTAL_BALANCE),cf.format(averageBalanceUnitPrice)},null);
				
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
					boolean updated = new InvUICardUpdateDialog(this.getShell(), SWT.NULL, invCard.getId()).open();
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