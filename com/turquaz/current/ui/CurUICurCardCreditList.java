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
 * @author Cem Dayanik
 * 
 */

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import com.turquaz.current.ui.comp.CurrentCodePicker;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import com.turquaz.current.CurKeys;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.interfaces.SearchComposite;

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
public class CurUICurCardCreditList extends Composite implements SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private MenuItem item;
	private Text txtDefinition;
	private DatePicker dateEndDate;
	private CLabel lblEndDate;
	private DatePicker dateStartDate;
	private CLabel lblDateStart;
	private CLabel lblDefinition;
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

	public CurUICurCardCreditList(Composite parent, int style)
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
			compCurrentCardSearchLayout.numColumns = 4;
			GridData compCurrentCardSearchLData = new GridData();
			compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
			compCurrentCardSearchLData.grabExcessHorizontalSpace = true;
			compCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
			compCurrentCardSearchLData.verticalAlignment = GridData.BEGINNING;
			compCurrentCardSearchLData.heightHint = 88;
			compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
			//START >> lblCurrentCode
			lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0"));
			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			//END << lblCurrentCode
			//START >> txtCurrentCode
			txtCurrentCode = new CurrentCodePicker(compCurrentCardSearch, SWT.NONE);
			GridData txtCurrentCodeLData = new GridData();
			txtCurrentCodeLData.widthHint = 157;
			txtCurrentCodeLData.heightHint = 17;
			txtCurrentCode.setLayoutData(txtCurrentCodeLData);
			//END << txtCurrentCode
			//START >> lblCurrentName
			lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1"));
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
			txtCurrentNameLData.widthHint = 150;
			txtCurrentNameLData.heightHint = 17;
			txtCurrentName.setLayoutData(txtCurrentNameLData);
			//END << txtCurrentName
			//START >> lblTurqGroupName
			lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblTurqGroupName.setText(Messages.getString("CurUICurrentCardSearch.2"));
			//END << lblTurqGroupName
			//START >> comboTurqGroupName
			comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
			GridData comboTurqGroupNameLData = new GridData();
			comboTurqGroupNameLData.widthHint = 135;
			comboTurqGroupNameLData.heightHint = 17;
			comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
			//END << comboTurqGroupName
			//START >>  lblDefinition
			lblDefinition = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblDefinition.setText("Aç\u0131klama");
			//END <<  lblDefinition
			//START >>  txtDefinition
			txtDefinition = new Text(compCurrentCardSearch, SWT.NONE);
			GridData txtDefinitionLData = new GridData();
			txtDefinitionLData.widthHint = 150;
			txtDefinitionLData.heightHint = 17;
			txtDefinition.setLayoutData(txtDefinitionLData);
			//END <<  txtDefinition
			//START >>  lblDateStart
			lblDateStart = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblDateStart.setText("Ba\u015flang\u0131ç Tarihi");
			//END <<  lblDateStart
			//START >>  dateStartDate
			dateStartDate = new DatePicker(compCurrentCardSearch, SWT.NONE);
			GridData dateStartDateLData = new GridData();
			dateStartDateLData.widthHint = 157;
			dateStartDateLData.heightHint = 22;
			dateStartDate.setLayoutData(dateStartDateLData);
			//END <<  dateStartDate
			//START >>  lblEndDate
			lblEndDate = new CLabel(compCurrentCardSearch, SWT.NONE);
			lblEndDate.setText("Biti\u015f Tarihi");
			//END <<  lblEndDate
			//START >>  dateEndDate
			dateEndDate = new DatePicker(compCurrentCardSearch, SWT.NONE);
			GridData dateEndDateLData = new GridData();
			dateEndDateLData.widthHint = 157;
			dateEndDateLData.heightHint = 22;
			dateEndDate.setLayoutData(dateEndDateLData);
			//END <<  dateEndDate
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
			tableColumnCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0"));
			tableColumnCurrentCode.setWidth(123);
			//END << tableColumnCurrentCode
			//START >> tableColumnCurrentName
			tableColumnCurrentName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
			tableColumnCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1"));
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
			tableColumnBalance.setText("Alacak Bakiye");
			tableColumnBalance.setWidth(101);
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
		try
		{
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText(""); //$NON-NLS-1$
			
			Calendar cal=Calendar.getInstance();
			cal.set(cal.get(Calendar.YEAR),0,1);
			dateStartDate.setDate(cal.getTime());
			
			List groups = (List)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"getTurqCurrentGroups",null);
						
			for (int k = 0; k < groups.size(); k++)
			{
				TurqCurrentGroup group = (TurqCurrentGroup) groups.get(k);
				comboTurqGroupName.add(group.getGroupsName());
				comboTurqGroupName.setData(group.getGroupsName(), group);
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
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
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
					TurqCurrentCard currentCard =(TurqCurrentCard)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"initializeCurrentCard",argMap);
					
					
					argMap = new HashMap();
					argMap.put(EngKeys.CURRENT_CARD,currentCard);
					
					List curCardTrans = (List)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"getTransactions",argMap);
					
					if (curCardTrans.size() > 0)
					{
						msg.setMessage(Messages.getString("CurUICurrentCardUpdate.15")); //$NON-NLS-1$
						msg.open();
						return;
					}
					msg.setMessage(Messages.getString("CurUICurrentCardUpdate.21")); //$NON-NLS-1$
					int result = msg.open();
					if (result == SWT.OK)
					{
						
						 argMap = new HashMap();
						argMap.put(EngKeys.CURRENT_CARD,currentCard);
						EngTXCommon.doTransactionTX(CurBLCurrentCardUpdate.class.getName(),"deleteCurrentCard",argMap);
					
						msg.setMessage(Messages.getString("CurUICurrentCardUpdate.22")); //$NON-NLS-1$
						msg.open();
					}
					search();
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	
	public void search()
	{
		try
		{
			tableViewer.removeAll();
			
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CURRENT_CODE,txtCurrentCode.getText().trim());
			argMap.put(CurKeys.CUR_CURRENT_NAME,txtCurrentName.getText().trim());
			argMap.put(CurKeys.CUR_GROUP, comboTurqGroupName.getData(comboTurqGroupName.getText()));
			argMap.put(EngKeys.DEFINITION,txtDefinition.getText().trim());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			
			List listCurrentCards = (List)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"searchCurrentCardBalanceList",argMap);
			
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat(2);
			BigDecimal generalCredit = new BigDecimal(0);
			BigDecimal generalDept = new BigDecimal(0);
			for (int k = 0; k < listCurrentCards.size(); k++)
			{
				Object result[] = (Object[]) listCurrentCards.get(k);
				BigDecimal totalDept = (BigDecimal) result[3];
				BigDecimal totalCredit =(BigDecimal) result[4];				
				BigDecimal balance = totalCredit.subtract(totalDept);
				if (balance.doubleValue() > 0)
				{
					Integer cardId = (Integer) result[0];
					String curCode = result[1].toString();
					String curName = result[2].toString();
					
					generalCredit = generalCredit.add(totalCredit);
					generalDept = generalDept.add(totalDept);
				
					tableViewer.addRow(new String[]{curCode, curName, cf.format(totalDept), cf.format(totalCredit), cf.format(balance)},
						cardId);
				}
			}
			BigDecimal finalBalance=generalCredit.subtract(generalDept);
			tableViewer.addRow(new String[]{"", "", "", "", ""}, null);
			tableViewer.addRow(new String[]{"", "TOPLAM", cf.format(generalDept), cf.format(generalCredit),
					cf.format(finalBalance)}, null);
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void newForm()
	{
	}

	public void save()
	{
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
			CurUICurrentCardSearch inst = new CurUICurrentCardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0, 0, 435, 318);
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
					HashMap argMap = new HashMap();
					argMap.put(CurKeys.CUR_CARD_ID,cardId);
					TurqCurrentCard currentCard =(TurqCurrentCard)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"initializeCurrentCard",argMap);
					boolean updated = new CurUICurrentCardUpdate(this.getShell(), SWT.NULL, currentCard).open();
					if (updated)
						search();
				}
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
			}
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableCurrentCardSearch);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableCurrentCardSearch, Messages.getString("CurUICurrentCardSearch.4")); //$NON-NLS-1$
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
					HashMap argMap = new HashMap();
					argMap.put(CurKeys.CUR_CARD_ID,cardId);
					TurqCurrentCard currentCard =(TurqCurrentCard)EngTXCommon.doSingleTX(CurBLCurrentCardSearch.class.getName(),"initializeCurrentCard",argMap);
					new CurUICurrentCardTransactions(getShell(), SWT.NONE, currentCard).open();
				}
			}
			catch (Exception ex)
			{
				Logger loger = Logger.getLogger(this.getClass());
				loger.error("Exception Caught", ex);
				ex.printStackTrace();
			}
		}
	}
}