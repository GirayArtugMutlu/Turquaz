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
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;

import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.lang.InvLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
import com.turquaz.inventory.bl.InvBLWarehouseUpdate;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyAdapter;

public class InvUIWarehouseSearch extends Composite implements SecureComposite, SearchComposite
{
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}
	private CLabel lblWarehouseCity;
	private TableColumn tableColumnDescription;
	private TableColumn tableColumnTelephone;
	private TableColumn tableColumnWarehouseCity;
	private TableColumn tableColumnName;
	private TableColumn tableColumnCode;
	private Table tableInvUIWarehouses;
	private Text txtCity;
	private Text txtWarehouseName;
	private CLabel lblWarehouseName;
	private Composite composite1;
	private SearchTableViewer tableViewer = null;

	public InvUIWarehouseSearch(Composite parent, int style)
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
			this.setSize(new org.eclipse.swt.graphics.Point(618, 381));
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			{
				composite1 = new Composite(this, SWT.NONE);
				GridLayout composite1Layout = new GridLayout();
				composite1Layout.numColumns = 2;
				composite1.setSize(new org.eclipse.swt.graphics.Point(608, 92));
				GridData composite1LData = new GridData();
				composite1.setLayout(composite1Layout);
				composite1.setBackground(SWTResourceManager.getColor(255, 255, 255));
				composite1LData.horizontalAlignment = GridData.FILL;
				composite1LData.heightHint = 92;
				composite1LData.grabExcessHorizontalSpace = true;
				composite1.setLayoutData(composite1LData);
				{
					lblWarehouseName = new CLabel(composite1, SWT.NONE);
					lblWarehouseName.setText(InvLangKeys.STR_WAREHOUSE_NAME);
					lblWarehouseName.setSize(new org.eclipse.swt.graphics.Point(105, 20));
					GridData lblWarehouseNameLData = new GridData();
					lblWarehouseNameLData.widthHint = 105;
					lblWarehouseNameLData.heightHint = 20;
					lblWarehouseName.setLayoutData(lblWarehouseNameLData);
				}
				{
					txtWarehouseName = new Text(composite1, SWT.BORDER);
					txtWarehouseName.setSize(new org.eclipse.swt.graphics.Point(117, 15));
					GridData txtWarehouseNameLData = new GridData();
					txtWarehouseName.addKeyListener(new KeyAdapter()
					{
						public void keyReleased(KeyEvent evt)
						{
							if (evt.keyCode == SWT.CR)
								search();
						}
					});
					txtWarehouseNameLData.widthHint = 104;
					txtWarehouseNameLData.heightHint = 8;
					txtWarehouseName.setLayoutData(txtWarehouseNameLData);
				}
				{
					lblWarehouseCity = new CLabel(composite1, SWT.NONE);
					lblWarehouseCity.setText(EngLangCommonKeys.STR_CITY);
					GridData lblWarehouseCityLData = new GridData();
					lblWarehouseCity.setLayoutData(lblWarehouseCityLData);
				}
				{
					txtCity = new Text(composite1, SWT.BORDER);
					txtCity.setSize(new org.eclipse.swt.graphics.Point(114, 16));
					GridData txtCityLData = new GridData();
					txtCity.addKeyListener(new KeyAdapter()
					{
						public void keyReleased(KeyEvent evt)
						{
							if (evt.keyCode == SWT.CR)
								search();
						}
					});
					txtCityLData.widthHint = 101;
					txtCityLData.heightHint = 9;
					txtCity.setLayoutData(txtCityLData);
				}
			}
			{
				tableInvUIWarehouses = new Table(this, SWT.FULL_SELECTION);
				tableInvUIWarehouses.setHeaderVisible(true);
				tableInvUIWarehouses.setLinesVisible(true);
				tableInvUIWarehouses.setSize(new org.eclipse.swt.graphics.Point(592, 258));
				GridData tableInvUIWarehousesLData = new GridData();
				tableInvUIWarehouses.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						tableInvUIWarehousesMouseDoubleClick(evt);
					}
				});
				tableInvUIWarehousesLData.verticalAlignment = GridData.FILL;
				tableInvUIWarehousesLData.horizontalAlignment = GridData.FILL;
				tableInvUIWarehousesLData.grabExcessHorizontalSpace = true;
				tableInvUIWarehousesLData.grabExcessVerticalSpace = true;
				tableInvUIWarehouses.setLayoutData(tableInvUIWarehousesLData);
				{
					tableColumnCode = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnCode.setText(InvLangKeys.STR_WAREHOUSE_CODE);
					tableColumnCode.setWidth(84);
				}
				{
					tableColumnName = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnName.setText(InvLangKeys.STR_WAREHOUSE_NAME);
					tableColumnName.setWidth(161);
				}
				{
					tableColumnWarehouseCity = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnWarehouseCity.setText(EngLangCommonKeys.STR_CITY);
					tableColumnWarehouseCity.setWidth(100);
				}
				{
					tableColumnTelephone = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnTelephone.setText(EngLangCommonKeys.STR_TELEPHONE);
					tableColumnTelephone.setWidth(100);
				}
				{
					tableColumnDescription = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnDescription.setText(EngLangCommonKeys.STR_DESCRIPTION);
					tableColumnDescription.setWidth(150);
				}
			}
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			addDisposeListener(new DisposeListener()
			{
				public void widgetDisposed(DisposeEvent e)
				{
				}
			});
			postInitGUI();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
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
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_WAREHOUSE_NAME,txtWarehouseName.getText().trim());
			argMap.put(InvKeys.INV_WAREHOUSE_CITY,txtCity.getText().trim());
			HashBag resultBag = (HashBag)EngTXCommon.doSelectTX(InvBLWarehouseSearch.class.getName(),"searchWarehouse",argMap );
			
            HashMap resultMap = (HashMap)resultBag.get(InvKeys.INV_WAREHOUSES);
            
            for (int i = 0; i < resultMap.size(); i++)
			{
                    HashMap rowMap = (HashMap)resultMap.get(new Integer(i));
                    
						tableViewer.addRow(new String[]{(String)rowMap.get(InvKeys.INV_WAREHOUSE_CODE),
                                (String)rowMap.get(InvKeys.INV_WAREHOUSE_NAME),
						(String)rowMap.get(InvKeys.INV_WAREHOUSE_CITY),(String)rowMap.get(InvKeys.INV_WAREHOUSE_TEL), 
                        (String)rowMap.get(InvKeys.INV_WAREHOUSE_DESC)}, rowMap.get(InvKeys.INV_WAREHOUSE_ID));
			}
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
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		tableViewer = new SearchTableViewer(tableInvUIWarehouses, columnTypes, true);
	}

	public void delete()
	{
		try
		{
			TableItem[] selection = tableInvUIWarehouses.getSelection();
			if (selection.length > 0)
			{
				boolean okToDelete = EngUICommon.okToDelete(getShell());
				ITableRow row=(ITableRow)selection[0].getData();
				if (okToDelete)
				{
					HashMap argMap = new HashMap();
					argMap.put(InvKeys.INV_WAREHOUSE_ID, row.getDBObject());
					EngTXCommon.doTransactionTX(InvBLWarehouseUpdate.class.getName(), "deleteWarehouse",
							argMap);
					EngUICommon.showDeletedSuccesfullyMessage(getShell());
					search();
				}
			}
		}
		catch (Exception ex)
		{
			EngBLLogger.log(this.getClass(), ex, getShell());
		}
	}

	public void newForm()
	{
	}

	/** Auto-generated event handler method */
	protected void tableInvUIWarehousesMouseDoubleClick(MouseEvent evt)
	{
		TableItem items[] = tableInvUIWarehouses.getSelection();
		if (items.length > 0)
		{
			Integer warehouseId = (Integer) ((ITableRow) items[0].getData()).getDBObject();
			new InvUIWarehouseUpdate(this.getShell(), SWT.NULL, warehouseId).open();
			search();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableViewer);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInvUIWarehouses, InvLangKeys.STR_WAREHOUSES);
	}
}