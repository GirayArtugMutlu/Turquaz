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
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.custom.CCombo;
import com.turquaz.consignment.Messages;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.ui.component.DatePicker;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import com.turquaz.current.ui.comp.CurrentPicker;
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
	private Button btnSearch;
	private Label lblSeperator;
	private TableColumn tableColumnSpecialVatAmount;
	private TableColumn tableColumnVatAmount;
	private TableColumn tableColumnCumulativePrice;
	private CLabel lblEndDate;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnConsignmentDate;
	private Table tableConsignments;
	private CCombo comboConsignmentType;
	private CLabel lblType;
	private DatePicker dateEndDate;
	private DatePicker dateStartDate;
	private CLabel lblStartDate;
	private CLabel lblCurrentCard;
	private TurqConsignment cons = null;

	public ConUIConsignmentSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public TurqConsignment open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.pack();
			dialogShell.setSize(566, 350);
			dialogShell.setText(Messages.getString("ConUIConsignmentSearchDialog.13")); //$NON-NLS-1$
			{
				composite1 = new Composite(dialogShell, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 2;
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 158;
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
					lblType = new CLabel(composite1, SWT.NONE);
					lblType.setText(Messages.getString("ConUIConsignmentSearchDialog.3")); //$NON-NLS-1$
					GridData lblTypeLData = new GridData();
					lblTypeLData.widthHint = 74;
					lblTypeLData.heightHint = 21;
					lblType.setLayoutData(lblTypeLData);
				}
				{
					comboConsignmentType = new CCombo(composite1, SWT.NONE);
					comboConsignmentType.setText(Messages.getString("ConUIConsignmentSearchDialog.4")); //$NON-NLS-1$
					GridData comboConsignmentTypeLData = new GridData();
					comboConsignmentTypeLData.widthHint = 72;
					comboConsignmentTypeLData.heightHint = 14;
					comboConsignmentType.setLayoutData(comboConsignmentTypeLData);
				}
				{
					lblSeperator = new Label(composite1, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridData lblSeperatorLData = new GridData();
					lblSeperatorLData.horizontalAlignment = GridData.FILL;
					lblSeperatorLData.grabExcessHorizontalSpace = true;
					lblSeperatorLData.horizontalSpan = 2;
					lblSeperator.setLayoutData(lblSeperatorLData);
				}
				{
					btnSearch = new Button(composite1, SWT.PUSH | SWT.CENTER);
					btnSearch.setImage(SWTResourceManager.getImage("icons/Find24.gif")); //$NON-NLS-1$
					GridData btnSearchLData = new GridData();
					btnSearch.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							search();
						}
					});
					btnSearchLData.widthHint = 62;
					btnSearchLData.heightHint = 30;
					btnSearch.setLayoutData(btnSearchLData);
				}
			}
			{
				tableConsignments = new Table(dialogShell, SWT.FULL_SELECTION);
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
					tableColumnConsignmentDate.setWidth(104);
				}
				{
					tableColumnCurrentName = new TableColumn(tableConsignments, SWT.NONE);
					tableColumnCurrentName.setText(Messages.getString("ConUIConsignmentSearchDialog.7")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(150);
				}
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
			comboConsignmentType.add(Messages.getString("ConUIConsignmentSearchDialog.11")); //$NON-NLS-1$
			comboConsignmentType.add(Messages.getString("ConUIConsignmentSearchDialog.12")); //$NON-NLS-1$
			composite1.layout();
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return cons;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public void tableDoubleMouseClick()
	{
		TableItem items[] = tableConsignments.getSelection();
		if (items.length > 0)
		{
			cons = (TurqConsignment) items[0].getData();
			dialogShell.close();
		}
	}

	public void search()
	{
		try
		{
			tableConsignments.removeAll();
			int type = 0;
			if (comboConsignmentType.getText().equals(Messages.getString("ConUIConsignmentSearchDialog.5"))) //$NON-NLS-1$
			{
				type = 1;
			}
			List list = ConBLSearchConsignment.chooseConsignment((TurqCurrentCard) txtCurCard.getData(), dateStartDate.getDate(),
					dateEndDate.getDate(), type);
			TurqConsignment cons;
			TableItem item;
			for (int i = 0; i < list.size(); i++)
			{
				cons = (TurqConsignment) list.get(i);
				item = new TableItem(tableConsignments, SWT.NULL);
				item.setData(cons);
				//XXX the data should be retrieved from view
				/*
				 * item.setText(new String[]{DatePicker.formatter.format(cons.getConsignmentsDate()),
				 * cons.getTurqCurrentCard().getCardsName(), cons.getTurqBillConsignmentCommon().getTotalAmount().toString(),
				 * cons.getTurqBillConsignmentCommon().getVatAmount().toString(),
				 * cons.getTurqBillConsignmentCommon().getSpecialVatAmount().toString()});
				 */
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