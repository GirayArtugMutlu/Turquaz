package com.turquaz.admin.ui;

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
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TableColumn;
import com.turquaz.admin.AdmKeys;
import com.turquaz.admin.bl.AdmBLGroups;
import com.turquaz.admin.bl.AdmBLUsers;
import com.turquaz.common.HashBag;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.interfaces.SearchComposite;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;

public class AdmUIGroups extends org.eclipse.swt.widgets.Composite implements SecureComposite, SearchComposite
{
	private Table tableGroups;
	private TableColumn tableColumnGroupname;
	private TableColumn tableColumnDescription;

	public AdmUIGroups(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	public void save()
	{
	}

	public void delete()
	{
		try
		{
			TableItem[] selection=tableGroups.getSelection();
			if (selection.length > 0)
			{
				Integer groupNumber=(Integer)selection[0].getData();
				if (groupNumber != null)
				{
					boolean delete = EngUICommon.okToDelete(this.getShell());  //$NON-NLS-1$
					if (delete)
					{
						HashMap argMap=new HashMap();
						argMap.put(AdmKeys.ADM_GROUP_ID,groupNumber);
						EngTXCommon.doTransactionTX(AdmBLUsers.class.getName(),"deleteGroup",argMap); //$NON-NLS-1$
						EngUICommon.showMessageBox(this.getShell(),EngLangCommonKeys.MSG_DELETED_SUCCESS); //$NON-NLS-1$
						fillTable();
					}					
				}
			}

		}
		catch (Exception ex)
		{
			EngBLLogger.log(getClass(),ex,getShell());
		}
	}

	public void newForm()
	{
		AdmUIGroups curCard = new AdmUIGroups(this.getParent(), this.getStyle());
		CTabFolder tabfld = (CTabFolder) this.getParent();
		tabfld.getSelection().setControl(curCard);
		this.dispose();
	}

	public void search()
	{
	}

	private void initGUI()
	{
		try
		{
			this.setLayout(new GridLayout());
			this.setSize(377, 322);
			{
				tableGroups = new Table(this, SWT.SINGLE | SWT.FULL_SELECTION);
				GridData tableUsersLData = new GridData();
				tableGroups.setHeaderVisible(true);
				tableGroups.setLinesVisible(true);
				tableUsersLData.grabExcessHorizontalSpace = true;
				tableUsersLData.grabExcessVerticalSpace = true;
				tableUsersLData.horizontalAlignment = GridData.FILL;
				tableUsersLData.verticalAlignment = GridData.FILL;
				tableGroups.setLayoutData(tableUsersLData);
				tableGroups.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableGroupsMouseDoubleClick(evt);
					}
				});
				{
					tableColumnGroupname = new TableColumn(tableGroups, SWT.NONE);
					tableColumnGroupname.setText(EngLangCommonKeys.STR_GROUP_NAME); //$NON-NLS-1$
					tableColumnGroupname.setWidth(112);
				}
				{
					tableColumnDescription = new TableColumn(tableGroups, SWT.NONE);
					tableColumnDescription.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
					tableColumnDescription.setWidth(200);
				}
			}
			this.layout();
			fillTable();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}

	public void fillTable()
	{
		try
		{
			tableGroups.removeAll();
            
			HashBag groupBag =(HashBag)EngTXCommon.doSelectTX(AdmBLGroups.class.getName(),"getGroups",null); //$NON-NLS-1$
			
            HashMap groupMap = (HashMap)groupBag.get(AdmKeys.ADM_GROUP);
            
            TableItem item;
			for (int i = 0; i < groupMap.size(); i++)
			{
                HashMap rowMap = (HashMap)groupMap.get(new Integer(i));
                
				item = new TableItem(tableGroups, SWT.NULL);
				item.setData(rowMap.get(AdmKeys.ADM_GROUP_ID));
				item.setText(new String[]{rowMap.get(AdmKeys.ADM_GROUP_NAME).toString(), rowMap.get(AdmKeys.ADM_GROUP_DESCRIPTION).toString()});
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableGroups);
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableGroups, EngLangCommonKeys.STR_GROUPS); //$NON-NLS-1$
	}
	
	private void tableGroupsMouseDoubleClick(MouseEvent evt) {
		TableItem items[] = tableGroups.getSelection();
        
		if(items.length>0)
		{
            Object[] data = new Object[3];
            
            data[0] = items[0].getText(0);
            data[1] = items[0].getText(1);
            data[2] = items[0].getData();
            
			new AdmUIGroupUpdateDialog(getShell(),SWT.NULL,data).open();	
			tableGroups.removeAll();
			fillTable();
			
		}	
		
	}
}