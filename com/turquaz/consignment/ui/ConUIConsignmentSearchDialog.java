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
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import com.turquaz.current.ui.comp.CurrentPicker;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class ConUIConsignmentSearchDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite composite1;
	private CurrentPicker txtCurCard;
	private TableColumn tableColumnType;
	private TableColumn tableColumnConNo;
	private TableColumn tableColumnCurCode;
	private ToolItem toolOk;
	private ToolItem toolCancel;
	private ToolItem toolItem1;
	private ToolBar toolBar1;
	private Label lblSeperator;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private CLabel lblEndDate;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnConsignmentDate;
	private Table tableConsignments;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private Object result[] = new Object[2];
	TurqCurrentCard curCard = null;

	public ConUIConsignmentSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public Object[] open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent,SWT.DIALOG_TRIM| SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.pack();
			dialogShell.setSize(707, 418);
			dialogShell.setText(Messages.getString("ConUIConsignmentSearchDialog.13")); //$NON-NLS-1$
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 4;
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 108;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				{
					lblCurrentCard = new CLabel(composite1, SWT.NONE);
					lblCurrentCard.setText(Messages.getString("ConUIConsignmentSearchDialog.0")); //$NON-NLS-1$
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 96;
					lblCurrentCardLData.heightHint = 16;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 208;
					txtCurCardLData.heightHint = 20;
					txtCurCardLData.horizontalSpan = 3;
					txtCurCard.setLayoutData(txtCurCardLData);
				}
				{
					lblStartDate = new CLabel(composite1, SWT.NONE);
					lblStartDate.setText(Messages.getString("ConUIConsignmentSearchDialog.1")); //$NON-NLS-1$
					GridData lblStartDateLData = new GridData();
					lblStartDateLData.widthHint = 109;
					lblStartDateLData.heightHint = 17;
					lblStartDate.setLayoutData(lblStartDateLData);
				}
				{
					dateStartDate = new DatePicker(composite1, SWT.NONE);
					GridData dateStartDateLData = new GridData();
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(Messages.getString("ConUIConsignmentSearchDialog.2")); //$NON-NLS-1$
					GridData lblEndDateLData = new GridData();
					lblEndDateLData.widthHint = 105;
					lblEndDateLData.heightHint = 19;
					lblEndDate.setLayoutData(lblEndDateLData);
				}
				{
					dateEndDate = new DatePicker(composite1, SWT.NONE);
					GridData dateEndDateLData = new GridData();
					dateEndDateLData.widthHint = 140;
					dateEndDateLData.heightHint = 22;
					dateEndDate.setLayoutData(dateEndDateLData);
				}
				{
					lblSeperator = new Label(composite1, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridData lblSeperatorLData = new GridData();
					lblSeperatorLData.horizontalAlignment = GridData.FILL;
					lblSeperatorLData.grabExcessHorizontalSpace = true;
					lblSeperatorLData.horizontalSpan = 4;
					lblSeperatorLData.heightHint = 2;
					lblSeperator.setLayoutData(lblSeperatorLData);
				}
				//START >> toolBar1
				toolBar1 = new ToolBar(composite1, SWT.WRAP);
				GridData toolBar1LData = new GridData();
				toolBar1LData.horizontalAlignment = GridData.FILL;
				toolBar1LData.horizontalSpan = 4;
				toolBar1LData.grabExcessHorizontalSpace = true;
				toolBar1LData.heightHint = 47;
				toolBar1.setLayoutData(toolBar1LData);
				//START >> toolItem1
				toolItem1 = new ToolItem(toolBar1, SWT.NONE);
				toolItem1.setText(Messages.getString("ConUIConsignmentSearchDialog.3")); //$NON-NLS-1$
				toolItem1.setImage(SWTResourceManager.getImage("icons/search.gif")); //$NON-NLS-1$
				toolItem1.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						search();
					}
				});
				//END << toolItem1
				//START >> toolOk
				toolOk = new ToolItem(toolBar1, SWT.NONE);
				toolOk.setText(Messages.getString("ConUIConsignmentSearchDialog.5")); //$NON-NLS-1$
				toolOk.setImage(SWTResourceManager.getImage("icons/Ok16.gif")); //$NON-NLS-1$
				toolOk.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						toolOkWidgetSelected(evt);
					}
				});
				//END << toolOk
				//START >> toolCancel
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(Messages.getString("ConUIConsignmentSearchDialog.11")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						dialogShell.close();
					}
				});
				//END << toolCancel
				//END << toolBar1
			}
			{
				tableConsignments = new Table(dialogShell, SWT.CHECK | SWT.FULL_SELECTION);
				tableConsignments.setHeaderVisible(true);
				tableConsignments.setLinesVisible(true);
				GridData tableConsignmentsLData = new GridData();
				tableConsignments.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableDoubleMouseClick();
					}
				});
				tableConsignmentsLData.verticalAlignment = GridData.FILL;
				tableConsignmentsLData.horizontalAlignment = GridData.FILL;
				tableConsignmentsLData.grabExcessHorizontalSpace = true;
				tableConsignmentsLData.grabExcessVerticalSpace = true;
				tableConsignments.setLayoutData(tableConsignmentsLData);
				{
					tableColumnConsignmentDate = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnConsignmentDate.setText(Messages.getString("ConUIConsignmentSearchDialog.6")); //$NON-NLS-1$
					tableColumnConsignmentDate.setWidth(83);
				}
				//START >>  tableColumnType
				tableColumnType = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnType.setText(Messages.getString("ConUIConsignmentSearchDialog.14")); //$NON-NLS-1$
				tableColumnType.setWidth(48);
				//END <<  tableColumnType
				{
					tableColumnCurrentName = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCurrentName.setText("Cari Kodu"); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(94);
				}
				//START >>  tableColumnCurCode
				tableColumnCurCode = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnCurCode.setText(Messages.getString("ConUIConsignmentSearchDialog.15")); //$NON-NLS-1$
				tableColumnCurCode.setWidth(80);
				//END <<  tableColumnCurCode
				//START >>  tableColumnConNo
				tableColumnConNo = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnConNo.setText(Messages.getString("ConUIConsignmentSearchDialog.16")); //$NON-NLS-1$
				tableColumnConNo.setWidth(100);
				//END <<  tableColumnConNo
				{
					tableColumnCumulativePrice = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCumulativePrice.setText(Messages.getString("ConUIConsignmentSearchDialog.8")); //$NON-NLS-1$
					tableColumnCumulativePrice.setWidth(100);
				}
				{
					tableColumnVatAmount = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnVatAmount.setText(Messages.getString("ConUIConsignmentSearchDialog.9")); //$NON-NLS-1$
					tableColumnVatAmount.setWidth(100);
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnSpecialVatAmount.setText(Messages.getString("ConUIConsignmentSearchDialog.10")); //$NON-NLS-1$
					tableColumnSpecialVatAmount.setWidth(100);
				}
			}
			composite1.layout();
			dialogShell.layout();
			EngUICommon.centreWindow(dialogShell);
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return result;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void tableDoubleMouseClick()
	{
	}
	
	public boolean verifyFields(){
	
		if(txtCurCard.getData()==null)
		{
			EngUICommon.showMessageBox(getParent(),Messages.getString("ConUIConsignmentSearchDialog.17")); //$NON-NLS-1$
			txtCurCard.setFocus();
			return false;
		}
		return true;
		
	}

	public void search()
	{
		try
		{
			if (verifyFields())
			{
				curCard = (TurqCurrentCard)txtCurCard.getData();
				tableConsignments.removeAll();
				HashMap argMap=new HashMap();
				argMap.put(EngKeys.CURRENT_CARD,txtCurCard.getData());
				argMap.put(EngKeys.DATE_START, dateStartDate.getDate());
				argMap.put(EngKeys.DATE_END,dateEndDate.getDate());
				List list =(List)EngTXCommon.doSingleTX(ConBLSearchConsignment.class.getName(),"chooseConsignment",argMap);
				Object cons[];
				TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
				TableItem item;
				for (int i = 0; i < list.size(); i++)
				{
					cons = (Object[]) list.get(i);
					item = new TableItem(tableConsignments, SWT.NULL);
					item.setData(cons[0]);
					Date consDate = (Date) cons[1];
					String curCardCode = (String) cons[2];
					String curCardName = (String) cons[3];
					String consDocNo = (String) cons[4];
					BigDecimal totalAmount = (BigDecimal) cons[5];
					BigDecimal vatAmount = (BigDecimal) cons[6];
					BigDecimal specVatAmount = (BigDecimal) cons[7];
					Integer type = (Integer)cons[8];
					String transType =""; //$NON-NLS-1$
					if(type.intValue()==EngBLCommon.COMMON_BUY_INT)
					{
						transType = EngBLCommon.COMMON_BUY_STRING;
					}
					else if(type.intValue()==EngBLCommon.COMMON_SELL_INT)
					{
						transType = EngBLCommon.COMMON_SELL_STRING;
					}
					
					item.setText(new String[]{DatePicker.formatter.format(consDate),transType,curCardCode, curCardName, consDocNo,
							cf.format(totalAmount), cf.format(vatAmount), cf.format(specVatAmount)});
				}
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex); //$NON-NLS-1$
			ex.printStackTrace();
		}
	}
	
	private void toolOkWidgetSelected(SelectionEvent evt) {
	
		result[1]=null;
		result[0] = curCard;
		List consigments = new ArrayList();
		TableItem items[] = tableConsignments.getItems();
		String type =""; //$NON-NLS-1$
		boolean okToSave = true;
		for(int i=0;i<items.length;i++)
		{
			if(items[i].getChecked())
			{
				if(consigments.size()==0)
				{
					consigments.add(items[i].getData());
					type = items[i].getText(1);
				}
				else if(type.equals(items[i].getText(1)))
				{
					consigments.add(items[i].getData());
				}
				else
				{
					okToSave = false;
					break;
				}
			}			
		}
		
		if(okToSave){
		result[1]=consigments;
		
		dialogShell.close();
		}
		else{
			EngUICommon.showMessageBox(getParent(),Messages.getString("ConUIConsignmentSearchDialog.21")); //$NON-NLS-1$
		}
		
		
		
	}
}