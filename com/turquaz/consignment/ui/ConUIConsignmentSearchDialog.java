package com.turquaz.consignment.ui;

/** ********************************************************************* */
/* TURQUAZ: Higly Modular Accounting/ERP Program */
/* ============================================ */
/* Copyright (c) 2004 by Turquaz Software Development Group */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or */
/* (at your option) any later version. */
/* 																		*/
/* This program is distributed in the hope that it will be useful, */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the */
/* GNU General Public License for more details. */
/** ********************************************************************* */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.common.HashBag;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.ConsLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Label;

import com.turquaz.current.CurKeys;
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
	Integer curCardId = null;

	public ConUIConsignmentSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public Object[] open(Date billDate)
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.pack();
			dialogShell.setSize(707, 418);
			dialogShell.setText(ConsLangKeys.TITLE_CONS_SEARCH);
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
					lblCurrentCard.setText(CurLangKeys.STR_CUR_CARD);
					GridData lblCurrentCardLData = new GridData();
					lblCurrentCardLData.widthHint = 96;
					lblCurrentCardLData.heightHint = 16;
					lblCurrentCard.setLayoutData(lblCurrentCardLData);
				}
				{
					txtCurCard = new CurrentPicker(composite1, SWT.NONE);
					GridData txtCurCardLData = new GridData();
					txtCurCardLData.widthHint = 391;
					txtCurCardLData.heightHint = 19;
					txtCurCardLData.horizontalSpan = 3;
					txtCurCard.setLayoutData(txtCurCardLData);
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
					dateStartDateLData.widthHint = 141;
					dateStartDateLData.heightHint = 22;
					dateStartDate.setLayoutData(dateStartDateLData);
					dateStartDate.setEnabled(false);
				}
				{
					lblEndDate = new CLabel(composite1, SWT.NONE);
					lblEndDate.setText(EngLangCommonKeys.STR_END_DATE);
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
					dateEndDate.setEnabled(false);
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
				toolItem1.setText(EngLangCommonKeys.STR_SEARCH);
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
				toolOk.setText(EngLangCommonKeys.STR_OK);
				toolOk.setImage(SWTResourceManager.getImage("icons/Ok16.gif")); //$NON-NLS-1$
				toolOk.addSelectionListener(new SelectionAdapter()
				{
					public void widgetSelected(SelectionEvent evt)
					{
						toolOkWidgetSelected(evt);
					}
				});
				//END << toolOk
				//START >> toolCancel
				toolCancel = new ToolItem(toolBar1, SWT.NONE);
				toolCancel.setText(EngLangCommonKeys.STR_CANCEL);
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
					tableColumnConsignmentDate.setText(EngLangCommonKeys.STR_DATE);
					tableColumnConsignmentDate.setWidth(83);
				}
				//START >> tableColumnType
				tableColumnType = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnType.setText(EngLangCommonKeys.STR_TYPE);
				tableColumnType.setWidth(48);
				//END << tableColumnType
				{
					tableColumnCurrentName = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCurrentName.setText(CurLangKeys.STR_CUR_CODE);
					tableColumnCurrentName.setWidth(94);
				}
				//START >> tableColumnCurCode
				tableColumnCurCode = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnCurCode.setText(CurLangKeys.STR_CUR_NAME);
				tableColumnCurCode.setWidth(80);
				//END << tableColumnCurCode
				//START >> tableColumnConNo
				tableColumnConNo = new TableColumn(tableConsignments, SWT.NONE);
				tableColumnConNo.setText(EngLangCommonKeys.STR_DOCUMENT_NO);
				tableColumnConNo.setWidth(100);
				//END << tableColumnConNo
				{
					tableColumnCumulativePrice = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCumulativePrice.setText(EngLangCommonKeys.STR_TOTAL_PRICE);
					tableColumnCumulativePrice.setWidth(100);
				}
				{
					tableColumnVatAmount = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnVatAmount.setText(InvLangKeys.STR_VAT_TOTAL);
					tableColumnVatAmount.setWidth(100);
				}
				{
					tableColumnSpecialVatAmount = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnSpecialVatAmount.setText(InvLangKeys.STR_SPEC_VAT);
					tableColumnSpecialVatAmount.setWidth(100);
				}
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(billDate);
			cal.add(Calendar.DATE, -7);
			dateStartDate.setDate(cal.getTime());
			dateEndDate.setData(billDate);
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
			EngBLLogger.log(this.getClass(), e, getParent());
			return null;
		}
	}

	public void tableDoubleMouseClick()
	{
	}

	public boolean verifyFields()
	{
		if (txtCurCard.getData() == null)
		{
			EngUICommon.showMessageBox(getParent(), CurLangKeys.MSG_SELECT_CUR_ACCOUNT, SWT.ICON_WARNING);
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
				curCardId =  txtCurCard.getCardId();
				tableConsignments.removeAll();
				HashMap argMap = new HashMap();
				argMap.put(CurKeys.CUR_CARD_ID, txtCurCard.getCardId());
				argMap.put(EngKeys.DATE_START, dateStartDate.getDate());
				argMap.put(EngKeys.DATE_END, dateEndDate.getDate());
				
				HashBag consBag = (HashBag) EngTXCommon.doSelectTX(ConBLSearchConsignment.class.getName(),
						"chooseConsignment", argMap);
				
				HashMap consList =(HashMap)consBag.get(ConsKeys.CONS);			
				
				HashMap consInfo;
				
				TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
				TableItem item;
				for (int i = 0; i < consList.size(); i++)
				{
					consInfo = (HashMap) consList.get(new Integer(i));
					
					item = new TableItem(tableConsignments, SWT.NULL);
					item.setData( consInfo.get(ConsKeys.CONS_ID));
					Date consDate = (Date) consInfo.get(ConsKeys.CONS_DATE);
					String curCardCode = (String) consInfo.get(CurKeys.CUR_CURRENT_CODE);
					String curCardName = (String) consInfo.get(CurKeys.CUR_CURRENT_NAME);;
					String consDocNo = (String) consInfo.get(ConsKeys.CONS_DOC_NO);;
					BigDecimal totalAmount = (BigDecimal) consInfo.get(ConsKeys.CONS_TOTAL_AMOUNT);;
					BigDecimal vatAmount = (BigDecimal) consInfo.get(ConsKeys.CONS_VAT_AMOUNT);;
					BigDecimal specVatAmount = (BigDecimal)consInfo.get(ConsKeys.CONS_SPEC_VAT_AMOUNT);;
					
					Integer type = (Integer) consInfo.get(ConsKeys.CONS_TYPE);
					String transType = ""; //$NON-NLS-1$
					if (type.intValue() == EngBLCommon.COMMON_BUY_INT)
					{
						transType = EngLangCommonKeys.COMMON_BUY_STRING;
					}
					else if (type.intValue() == EngBLCommon.COMMON_SELL_INT)
					{
						transType = EngLangCommonKeys.COMMON_SELL_STRING;
					}
					item.setText(new String[]{DatePicker.formatter.format(consDate), transType, curCardCode,
							curCardName, consDocNo, cf.format(totalAmount), cf.format(vatAmount),
							cf.format(specVatAmount)});
				}
			}
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getParent());
		}
	}

	private void toolOkWidgetSelected(SelectionEvent evt)
	{
		result[1] = null;
		result[0] = curCardId;
		List consigments = new ArrayList();
		TableItem items[] = tableConsignments.getItems();
		String type = ""; //$NON-NLS-1$
		boolean okToSave = true;
		for (int i = 0; i < items.length; i++)
		{
			if (items[i].getChecked())
			{
				if (consigments.size() == 0)
				{
					consigments.add(items[i].getData());
					type = items[i].getText(1);
				}
				else if (type.equals(items[i].getText(1)))
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
		if (okToSave)
		{
			result[1] = consigments;
			dialogShell.close();
		}
		else
		{
			EngUICommon.showMessageBox(getParent(), ConsLangKeys.MSG_SELECT_ONLY_ONE_TYPE,SWT.ICON_WARNING);
		}
	}
}