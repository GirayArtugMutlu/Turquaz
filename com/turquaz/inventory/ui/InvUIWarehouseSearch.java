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
import java.util.List;
import org.apache.log4j.Logger;
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
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryWarehous;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.SecureComposite;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLWarehouseSearch;
/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
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
			preInitGUI();
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
					lblWarehouseName.setText(Messages.getString("InvUIWarehouseSearch.0"));
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
					lblWarehouseCity.setText(Messages.getString("InvUIWarehouseSearch.1"));
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
					tableColumnCode.setText("Depo Kodu");
					tableColumnCode.setWidth(84);
				}
				{
					tableColumnName = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnName.setText(Messages.getString("InvUIWarehouseSearch.0")); //$NON-NLS-1$
					tableColumnName.setWidth(161);
				}
				{
					tableColumnWarehouseCity = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnWarehouseCity.setText(Messages.getString("InvUIWarehouseSearch.1"));
					tableColumnWarehouseCity.setWidth(100);
				}
				{
					tableColumnTelephone = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnTelephone.setText(Messages.getString("InvUIWarehouseSearch.4"));
					tableColumnTelephone.setWidth(100);
				}
				{
					tableColumnDescription = new TableColumn(tableInvUIWarehouses, SWT.NONE);
					tableColumnDescription.setText(Messages.getString("InvUIWarehouseSearch.5"));
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
			TurqInventoryWarehous warehouse;
			List result = InvBLWarehouseSearch.searchWarehouse(txtWarehouseName.getText().trim(), txtCity.getText().trim());
			for (int i = 0; i < result.size(); i++)
			{
				warehouse = (TurqInventoryWarehous) result.get(i);
				tableViewer.addRow(new String[]{warehouse.getWarehousesCode(), warehouse.getWarehousesName(),
						warehouse.getWarehousesCity(), warehouse.getWarehousesTelephone(), warehouse.getWarehousesDescription()},
						warehouse);
			}
		}
		catch (Exception ex)
		{
			Logger loger = Logger.getLogger(this.getClass());
			loger.error("Exception Caught", ex);
			ex.printStackTrace();
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
		//TODO should be implemented..
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
			TurqInventoryWarehous wareh = (TurqInventoryWarehous) ((ITableRow) items[0].getData()).getDBObject();
			new InvUIWarehouseUpdate(this.getShell(), SWT.NULL, wareh).open();
			search();
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableInvUIWarehouses);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableInvUIWarehouses, "Depolar");
	}
}