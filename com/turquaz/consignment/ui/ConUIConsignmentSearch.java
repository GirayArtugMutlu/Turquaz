package com.turquaz.consignment.ui;

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
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.consignment.bl.ConBLUpdateConsignment;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.lang.ConsLangKeys;
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
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class ConUIConsignmentSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite
{
	private Composite composite1;
	private Table tableConsignments;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnVatAmount;
	private CurrentPicker txtCurCard;
	private TableColumn tableColumnCurrentCode;
	private TableColumn tableColumnDcoNo;
	private Text txtDocNo;
	private CLabel lblDocNo;
	private CCombo comboConsignmentType;
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

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		ConUIConsignmentSearch inst = new ConUIConsignmentSearch(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public ConUIConsignmentSearch(org.eclipse.swt.widgets.Composite parent, int style)
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
				composite1Layout.horizontalSpacing = 0;
				GridData composite1LData = new GridData();
				composite1LData.heightHint = 88;
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
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(EngLangCommonKeys.STR_TYPE);
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboConsignmentType = new CCombo(composite1, SWT.NONE);
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentType.setText(EngLangCommonKeys.COMMON_BUY_STRING);
					comboConsignmentTypeLData.widthHint = 135;
					comboConsignmentTypeLData.heightHint = 17;
					comboConsignmentType.setLayoutData(comboConsignmentTypeLData);
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
					lblEndDateLData.widthHint = 77;
					lblEndDateLData.heightHint = 21;
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
			}
			{
				tableConsignments = new Table(this, SWT.FULL_SELECTION);
				GridData tableConsignmentsLData = new GridData();
				tableConsignments.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableMouseDoubleClick();
					}
				});
				tableConsignments.setHeaderVisible(true);
				tableConsignments.setLinesVisible(true);
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableConsignments.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnConsignmentDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnConsignmentDate.setWidth(104);
					tableColumnConsignmentDate.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableConsignments, tableColumnConsignmentDate);
						}
					});
				}
				//START >> tableColumnCurrentCode
				tableColumnCurrentCode = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE);
				tableColumnCurrentCode.setWidth(100);
				//END << tableColumnCurrentCode
				{
					tableColumnCurrentName = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCurrentName.setText(CurLangKeys.STR_CUR_NAME);
					tableColumnCurrentName.setWidth(150);
					tableColumnCurrentName.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableConsignments, tableColumnCurrentName);
						}
					});
				}
				{
					tableColumnDcoNo = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnDcoNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
					tableColumnDcoNo.setWidth(82);
				}
				{
					tableColumnCumulativePrice = new TableColumn(tableConsignments, SWT.RIGHT);
					tableColumnCumulativePrice.setText(EngLangCommonKeys.STR_TOTAL_PRICE);
					tableColumnCumulativePrice.setWidth(100);
					tableColumnCumulativePrice.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableConsignments, tableColumnCumulativePrice);
						}
					});
				}
				{
					tableColumnVatAmount = new TableColumn(tableConsignments, SWT.RIGHT);
					tableColumnVatAmount.setText(InvLangKeys.STR_VAT_TOTAL);
					tableColumnVatAmount.setWidth(100);
					tableColumnVatAmount.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableConsignments, tableColumnVatAmount);
						}
					});
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(tableConsignments, SWT.RIGHT);
					tableColumnSpecialVatAmount.setText(InvLangKeys.STR_SPEC_VAT);
					tableColumnSpecialVatAmount.setWidth(100);
					tableColumnSpecialVatAmount.addListener(SWT.Selection, new Listener()
					{
						public void handleEvent(Event e)
						{
							TableSorter.sortTable(tableConsignments, tableColumnSpecialVatAmount);
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
		comboConsignmentType.add(EngLangCommonKeys.COMMON_BUY_STRING);
		comboConsignmentType.add(EngLangCommonKeys.COMMON_SELL_STRING);
		comboConsignmentType.add(EngLangCommonKeys.COMMON_ALL_STRING);
		comboConsignmentType.setText(EngLangCommonKeys.COMMON_ALL_STRING);
		cal.set(cal.get(Calendar.YEAR), 0, 1);
		dateStartDate.setDate(cal.getTime());
		createTableViewer();
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
			if (comboConsignmentType.getText().equals(EngLangCommonKeys.COMMON_SELL_STRING))
			{
				type = EngBLCommon.COMMON_SELL_INT;
			}
			else if (comboConsignmentType.getText().equals(EngLangCommonKeys.COMMON_BUY_STRING))
			{
				type = EngBLCommon.COMMON_BUY_INT;
			}
			HashMap argMap=new HashMap();
			
			argMap.put(CurKeys.CUR_CARD_ID,txtCurCard.getCardId());
			argMap.put(EngKeys.DATE_START,dateStartDate.getDate());
			argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
			argMap.put(EngKeys.TYPE,new Integer(type));
			argMap.put(EngKeys.DOCUMENT_NO,txtDocNo.getText().trim());	
			
			
			List list =(List)EngTXCommon.doSelectTX(ConBLSearchConsignment.class.getName(),"searchConsignment",argMap);
			Object[] cons;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < list.size(); i++)
			{
				cons = (Object[]) list.get(i);
				Integer consId = (Integer) cons[0];
				Date consDate = (Date) cons[1];
				String curCardCode = (String) cons[2];
				String curCardName = (String) cons[3];
				String consDocNo = (String) cons[4];
				BigDecimal totalAmount = (BigDecimal) cons[5];
				BigDecimal vatAmount = (BigDecimal) cons[6];
				BigDecimal specVatAmount = (BigDecimal) cons[7];
				tableViewer.addRow(new String[]{DatePicker.formatter.format(consDate), curCardCode, curCardName, consDocNo,
						cf.format(totalAmount), cf.format(vatAmount), cf.format(specVatAmount)}, consId);
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

	public void createTableViewer()
	{
		int columnTypes[] = new int[7];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_DATE;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[5] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		columnTypes[6] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
		tableViewer = new SearchTableViewer(tableConsignments, columnTypes, true);
	}

	public void delete()
	{
		try
		{
			TableItem items[] = tableConsignments.getSelection();
			if (items.length > 0)
			{
				Integer consId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				
				HashMap argMap=new HashMap();
				argMap.put(ConsKeys.CONS_ID,consId);
				TurqConsignment cons =(TurqConsignment)EngTXCommon.doSelectTX(ConBLSearchConsignment.class.getName(),"initiliazeConsignmentById",argMap);
				//TODO if bill exist?? result never return -1 ?
				if (cons.getTurqEngineSequence().getTurqBillInEngineSequences().isEmpty())
				{
					boolean okToDelete=EngUICommon.okToDelete(getShell());
					if (okToDelete)
					{
						argMap=new HashMap();
						argMap.put(ConsKeys.CONS,cons);
						Integer result =(Integer)EngTXCommon.doTransactionTX(ConBLUpdateConsignment.class.getName(),"deleteConsignment",argMap);
						
						if(result.intValue()==1)
						{
							EngUICommon.showDeletedSuccesfullyMessage(getShell());
							search();
						}
						else if(result.intValue() ==-1)
						{
							EngUICommon.showMessageBox(getShell(),ConsLangKeys.MSG_HAS_BILL_CAN_NOT_DELETE,SWT.ICON_WARNING); 
						}
					}
				}
				else
				{
					EngUICommon.showMessageBox(getShell(),ConsLangKeys.MSG_HAS_BILL_CAN_NOT_DELETE,SWT.ICON_WARNING);
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
	ConBLUpdateConsignment blUpdate = new ConBLUpdateConsignment();

	public void tableMouseDoubleClick()
	{
		try
		{
			TableItem items[] = tableConsignments.getSelection();
			if (items.length > 0)
			{
				Integer consId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
				if (consId != null)
				{
					HashMap argMap=new HashMap();
					argMap.put(ConsKeys.CONS_ID,consId);
					TurqConsignment cons =(TurqConsignment)EngTXCommon.doSelectTX(ConBLSearchConsignment.class.getName(),"getConsignmentByConsId",argMap);
					boolean updated = new ConUIConsignmentUpdateDialog(this.getShell(), SWT.NULL, cons).open();
					if (updated)
						search();
				}
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableConsignments, ConsLangKeys.STR_CONSIGNMENTS);
	}
}