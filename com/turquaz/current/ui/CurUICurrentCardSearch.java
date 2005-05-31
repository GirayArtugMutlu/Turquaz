package com.turquaz.current.ui;

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
import java.util.List;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

import com.turquaz.admin.AdmKeys;
import com.turquaz.common.HashBag;
import com.turquaz.current.ui.comp.CurrentCodePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.current.CurKeys;
import org.eclipse.swt.widgets.Button;

import com.turquaz.current.bl.CurBLCurrentCardAdd;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardSearch extends Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private MenuItem item;
	private TableColumn tableColumnCreditBalance;
	private Button radioCurrentName;
	private Button radioCurrentCode;
	private Menu popup;
	private TableColumn tableColumnBalance;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CCombo comboTurqGroupName;
	private CLabel lblTurqGroupName;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private CurrentCodePicker txtCurrentCode;
	private CLabel lblCurrentCode;
	private Composite compCurrentCardSearch;
	private SearchTableViewer tableViewer = null;

	public CurUICurrentCardSearch(Composite parent, int style)
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
			this.setSize(834, 510);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			//START >> compCurrentCardSearch
			compCurrentCardSearch = new Composite(this, SWT.NONE);
			GridLayout compCurrentCardSearchLayout = new GridLayout();
			compCurrentCardSearchLayout.numColumns = 3;
			GridData compCurrentCardSearchLData = new GridData();
			compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
			compCurrentCardSearchLData.heightHint = 77;
			compCurrentCardSearchLData.grabExcessHorizontalSpace = true;
			compCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
			compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
			//START >> lblCurrentCode
			lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblCurrentCode.setText(CurLangKeys.STR_CUR_CODE);
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			//END << lblCurrentCode
			//START >> txtCurrentCode
			txtCurrentCode = new CurrentCodePicker(compCurrentCardSearch, SWT.NONE);
			GridData txtCurrentCodeLData = new GridData();
			txtCurrentCodeLData.widthHint = 242;
			txtCurrentCodeLData.heightHint = 17;
			txtCurrentCode.setLayoutData(txtCurrentCodeLData);
			//END << txtCurrentCode
			//START >>  radioCurrentCode
			radioCurrentCode = new Button(compCurrentCardSearch, SWT.RADIO | SWT.LEFT);
			radioCurrentCode.setText("Koda Göre Ara");
			radioCurrentCode.setSelection(true);
			//END <<  radioCurrentCode
			//START >> lblCurrentName
			lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblCurrentName.setText(CurLangKeys.STR_CUR_NAME);
			GridData lblCurrentNameLData = new GridData();
			lblCurrentName.setLayoutData(lblCurrentNameLData);
			//END << lblCurrentName
			//START >> txtCurrentName
			txtCurrentName = new Text(compCurrentCardSearch, SWT.NONE);
			GridData txtCurrentNameLData = new GridData();
			txtCurrentName.addKeyListener(new KeyAdapter()
			{
				public void keyReleased(KeyEvent evt)
				{
					if (evt.keyCode == SWT.CR)
						search();
				}
			});
			txtCurrentNameLData.widthHint = 235;
			txtCurrentNameLData.heightHint = 17;
			txtCurrentName.setLayoutData(txtCurrentNameLData);
			//END << txtCurrentName
			//START >>  radioCurrentName
			radioCurrentName = new Button(compCurrentCardSearch, SWT.RADIO | SWT.LEFT);
			radioCurrentName.setText("Ünvana Göre Ara");
			//END <<  radioCurrentName
			//START >> lblTurqGroupName
			lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblTurqGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME);
			GridData lblTurqGroupNameLData = new GridData();
			lblTurqGroupNameLData.widthHint = 91;
			lblTurqGroupNameLData.heightHint = 21;
			lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
			lblTurqGroupName.setSize(91, 21);
			//END << lblTurqGroupName
			//START >> comboTurqGroupName
			comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
			GridData comboTurqGroupNameLData = new GridData();
			comboTurqGroupNameLData.widthHint = 221;
			comboTurqGroupNameLData.heightHint = 14;
			comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
			//END << comboTurqGroupName
			//END << compCurrentCardSearch
			//START >> tableCurrentCardSearch
			tableCurrentCardSearch = new Table(this, SWT.FULL_SELECTION | SWT.H_SCROLL);
			tableCurrentCardSearch.setHeaderVisible(true);
			tableCurrentCardSearch.setLinesVisible(true);
			GridData tableCurrentCardSearchLData = new GridData();
			tableCurrentCardSearch.addMouseListener(new MouseAdapter()
			{
				public void mouseDoubleClick(MouseEvent evt)
				{
					tableCurrentCardSearchMouseDoubleClick(evt);
				}
			});
			tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
			tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
			tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
			//START >> tableColumnCurrentCode
			tableColumnCurrentCode = new TableColumn(tableCurrentCardSearch, SWT.NONE);
			tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE);
			tableColumnCurrentCode.setWidth(123);
			//END << tableColumnCurrentCode
			//START >> tableColumnCurrentName
			tableColumnCurrentName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
			tableColumnCurrentName.setText(CurLangKeys.STR_CUR_NAME);
			tableColumnCurrentName.setWidth(124);
			//END << tableColumnCurrentName
			//START >> tableColumnTotalCredit
			tableColumnTotalCredit = new TableColumn(tableCurrentCardSearch, SWT.RIGHT);
			tableColumnTotalCredit.setText("Toplam Borç");
			tableColumnTotalCredit.setWidth(120);
			//END << tableColumnTotalCredit
			//START >> tableColumnTotalDept
			tableColumnTotalDept = new TableColumn(tableCurrentCardSearch, SWT.RIGHT);
			tableColumnTotalDept.setText("Toplam Alacak");
			tableColumnTotalDept.setWidth(120);
			//END << tableColumnTotalDept
			//START >> tableColumnBalance
			tableColumnBalance = new TableColumn(tableCurrentCardSearch, SWT.RIGHT);
			tableColumnBalance.setText("Borç Bakiye");
			tableColumnBalance.setWidth(80);
			//END << tableColumnBalance
			//START >> popup
			popup = new Menu(tableCurrentCardSearch);
			tableCurrentCardSearch.setMenu(popup);
			//START >> item
			item = new MenuItem(popup, SWT.PUSH);
			item.setText("Cari kart hareketlerini getir");
			item.addSelectionListener(new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent evt)
				{
					itemWidgetSelected(evt);
				}
			});
			//END << item
			//END << popup
			//START >>  tableColumnCreditBalance
			tableColumnCreditBalance = new TableColumn(tableCurrentCardSearch, SWT.RIGHT);
			tableColumnCreditBalance.setText("Alacak Bakiye");
			tableColumnCreditBalance.setWidth(80);
			//END <<  tableColumnCreditBalance
			//END << tableCurrentCardSearch
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
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
		try
		{
			txtCurrentCode.setTxtCurrentName(txtCurrentName);
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText(""); //$NON-NLS-1$
			
			HashBag groupBag = (HashBag)EngTXCommon.doSelectTX(CurBLCurrentCardAdd.class.getName(),"getCurrentGroups",null);
					
			HashMap groupMap = (HashMap)groupBag.get(AdmKeys.ADM_GROUPS);
			
			for (int k = 0; k < groupMap.size(); k++)
			{
				HashMap groupInfo = (HashMap) groupMap.get(new Integer(k));
				comboTurqGroupName.add(groupInfo.get(AdmKeys.ADM_GROUP_NAME).toString());
				comboTurqGroupName.setData(groupInfo.get(AdmKeys.ADM_GROUP_NAME).toString(), groupInfo.get(AdmKeys.ADM_GROUP_ID));
			}
			createTableViewer();
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[6];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableCurrentCardSearch, columnTypes, true);
	}

	public void delete()
	{
		MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
		try
		{
			TableItem items[] = tableCurrentCardSearch.getSelection();
			if (items.length > 0)
			{
				Integer cardId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (cardId != null)
				{
					
					
					HashMap argMap = new HashMap();
					argMap.put(CurKeys.CUR_CARD_ID,cardId);
					
					
					List curCardTrans = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getTransactions",argMap);
					
					if (curCardTrans.size() > 0)
					{
						msg.setMessage(CurLangKeys.MSG_CUR_CARD_HAS_TRANSACTIONS); //$NON-NLS-1$
						msg.open();
						return;
					}
					msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); //$NON-NLS-1$
					int result = msg.open();
					if (result == SWT.OK)
					{
						
						 argMap = new HashMap();
						 argMap.put(CurKeys.CUR_CARD_ID,cardId);
						EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"deleteCurrentCard",argMap);
						msg.setMessage(EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
						msg.open();
					}
					search();
				}
			}
		}
		catch (Exception ex)
		{

            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	
	public void search()
	{
		try
		{
			tableViewer.removeAll();
			
			HashMap argMap = new HashMap();
			if (radioCurrentCode.getSelection())
			{
				argMap.put(CurKeys.CUR_CURRENT_CODE,txtCurrentCode.getText().trim());
				argMap.put(CurKeys.CUR_CURRENT_NAME,"");
			}
			else
			{
				argMap.put(CurKeys.CUR_CURRENT_CODE,"");
				argMap.put(CurKeys.CUR_CURRENT_NAME,txtCurrentName.getText().trim());
			}	
			argMap.put(CurKeys.CUR_GROUP_ID, comboTurqGroupName.getData(comboTurqGroupName.getText()));
			
			
			List listCurrentCards = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"searchCurrentCard",argMap);
			
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat(2);
			BigDecimal generalCredit = new BigDecimal(0);
			BigDecimal generalDept = new BigDecimal(0);
			BigDecimal deptBalance;
			BigDecimal creditBalance;
			for (int k = 0; k < listCurrentCards.size(); k++)
			{
				Object result[] = (Object[]) listCurrentCards.get(k);
				Integer cardId = (Integer) result[0];
				String curCode = result[1].toString();
				String curName = result[2].toString();
				BigDecimal totalCredit =((result[3]==null) ? new BigDecimal(0) : (BigDecimal)result[3]);
				BigDecimal totalDept = ((result[4]==null) ? new BigDecimal(0) : (BigDecimal)result[4]);
				BigDecimal balance = ((result[5]==null) ? new BigDecimal(0) : (BigDecimal)result[5]);
				generalCredit = generalCredit.add(totalCredit);
				generalDept = generalDept.add(totalDept);
				if (balance.doubleValue() <=0 )
				{
					deptBalance=balance;
					creditBalance=new BigDecimal(0);
				}
				else
				{
					creditBalance=balance;
					deptBalance=new BigDecimal(0);
				}
				
				tableViewer.addRow(new String[]{curCode, curName, cf.format(totalDept), cf.format(totalCredit), cf.format(deptBalance.abs()),
						cf.format(creditBalance)},
						cardId);
			}
			BigDecimal generalBalance=generalCredit.subtract(generalDept);
			tableViewer.addRow(new String[]{"", "", "", "", "",""}, null);
			if (generalBalance.doubleValue() <= 0)
			{
				tableViewer.addRow(new String[]{"", "TOPLAM", cf.format(generalDept), cf.format(generalCredit),
					cf.format(generalBalance.abs()),""}, null);
			}
			else
			{
				tableViewer.addRow(new String[]{"", "TOPLAM", cf.format(generalDept), cf.format(generalCredit),
						"",cf.format(generalBalance)}, null);
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

	public void save()
	{
	}

	

	/** Auto-generated event handler method */
	protected void tableCurrentCardSearchMouseDoubleClick(MouseEvent evt)
	{
		TableItem[] selection = tableCurrentCardSearch.getSelection();
		if (selection.length > 0)
		{
			try
			{
				Integer cardId = (Integer) ((ITableRow) selection[0].getData()).getDBObject();
				if (cardId != null)
				{
					boolean updated = new CurUICurrentCardUpdate(this.getShell(), SWT.NULL, cardId).open();
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
		EngBLUtils.printTable(tableCurrentCardSearch,CurLangKeys.STR_CUR_CARDS ); //$NON-NLS-1$
	}

	private void itemWidgetSelected(SelectionEvent evt)
	{
		TableItem[] selection = tableCurrentCardSearch.getSelection();
		if (selection.length > 0)
		{
			try
			{
				Integer cardId = (Integer) ((ITableRow) selection[0].getData()).getDBObject();
				if (cardId != null)
				{
						new CurUICurrentCardTransactions(getShell(), SWT.NONE, cardId).open();
				}
			}
			catch (Exception ex)
			{

                EngBLLogger.log(this.getClass(),ex,getShell());
			}
		}
	}
}