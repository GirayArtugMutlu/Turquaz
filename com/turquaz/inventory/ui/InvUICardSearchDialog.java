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
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TableItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.inventory.InvKeys;
import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardSearch;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class InvUICardSearchDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite compInvCardSearchPanel;
	private CLabel lblInvName;
	private CCombo comboInvGroup;
	private Table tableSearcResults;
	private TableColumn tableColumnInvName;
	private Label label1;
	private Button btnSearch;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private CLabel lblInvGroup;
	private Text txtInvCode;
	private CLabel cLabel2;
	private Text txtInvName;
	TurqInventoryCard invCard;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */
	public static void main(String[] args)
	{
		try
		{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUICardSearchDialog inst = new InvUICardSearchDialog(shell, SWT.NULL);
			inst.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public InvUICardSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public TurqInventoryCard open()
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
			dialogShell.setText(Messages.getString("InvUICardSearchDialog.0")); //$NON-NLS-1$
			dialogShell.pack();
			dialogShell.setSize(486, 418);
			{
				compInvCardSearchPanel = new Composite(dialogShell, SWT.NONE);
				GridLayout compInvCardSearchPanelLayout = new GridLayout();
				compInvCardSearchPanelLayout.numColumns = 2;
				GridData compInvCardSearchPanelLData = new GridData();
				compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
				compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
				compInvCardSearchPanelLData.heightHint = 134;
				compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
				compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
				{
					lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvName.setText(Messages.getString("InvUICardSearch.0"));//$NON-NLS-1$
					lblInvName.setSize(new org.eclipse.swt.graphics.Point(114, 18));
					GridData lblInvNameLData = new GridData();
					lblInvNameLData.widthHint = 114;
					lblInvNameLData.heightHint = 18;
					lblInvName.setLayoutData(lblInvNameLData);
				}
				{
					txtInvName = new Text(compInvCardSearchPanel, SWT.NONE);
					GridData txtInvNameLData = new GridData();
					txtInvNameLData.widthHint = 166;
					txtInvNameLData.heightHint = 18;
					txtInvName.setLayoutData(txtInvNameLData);
				}
				{
					cLabel2 = new CLabel(compInvCardSearchPanel, SWT.NONE);
					cLabel2.setText(Messages.getString("InvUICardSearch.1"));//$NON-NLS-1$
					cLabel2.setSize(new org.eclipse.swt.graphics.Point(97, 17));
					GridData cLabel2LData = new GridData();
					cLabel2LData.widthHint = 97;
					cLabel2LData.heightHint = 17;
					cLabel2.setLayoutData(cLabel2LData);
				}
				{
					txtInvCode = new Text(compInvCardSearchPanel, SWT.NONE);
					GridData txtInvCodeLData = new GridData();
					txtInvCodeLData.widthHint = 166;
					txtInvCodeLData.heightHint = 18;
					txtInvCode.setLayoutData(txtInvCodeLData);
				}
				{
					lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
					lblInvGroup.setText(Messages.getString("InvUICardSearch.2"));//$NON-NLS-1$
					lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(110, 17));
					GridData lblInvGroupLData = new GridData();
					lblInvGroupLData.widthHint = 110;
					lblInvGroupLData.heightHint = 17;
					lblInvGroup.setLayoutData(lblInvGroupLData);
				}
				{
					comboInvGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
					GridData comboInvGroupLData = new GridData();
					comboInvGroupLData.widthHint = 98;
					comboInvGroupLData.heightHint = 18;
					comboInvGroup.setLayoutData(comboInvGroupLData);
				}
				{
					label1 = new Label(compInvCardSearchPanel, SWT.SEPARATOR | SWT.HORIZONTAL);
					GridData label1LData = new GridData();
					label1LData.heightHint = 4;
					label1LData.horizontalAlignment = GridData.FILL;
					label1LData.horizontalSpan = 2;
					label1LData.grabExcessHorizontalSpace = true;
					label1.setLayoutData(label1LData);
				}
				{
					btnSearch = new Button(compInvCardSearchPanel, SWT.PUSH | SWT.CENTER);
					btnSearch.setText("button1");//$NON-NLS-1$
					GridData btnSearchLData = new GridData();
					btnSearch.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							search();
						}
					});
					btnSearch.setImage(SWTResourceManager.getImage("icons/Find24.gif"));//$NON-NLS-1$
					btnSearchLData.horizontalAlignment = GridData.END;
					btnSearchLData.grabExcessHorizontalSpace = true;
					btnSearchLData.horizontalSpan = 2;
					btnSearchLData.widthHint = 80;
					btnSearchLData.heightHint = 37;
					btnSearch.setLayoutData(btnSearchLData);
				}
			}
			{
				tableSearcResults = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				tableSearcResults.setHeaderVisible(true);
				tableSearcResults.setLinesVisible(true);
				tableSearcResults.setSize(new org.eclipse.swt.graphics.Point(543, 318));
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
					tableColumnInvName = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnInvName.setText(Messages.getString("InvUICardSearch.0"));//$NON-NLS-1$
					tableColumnInvName.setWidth(115);
				}
				{
					tableColumnInventoryCode = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnInventoryCode.setText(Messages.getString("InvUICardSearch.1"));//$NON-NLS-1$
					tableColumnInventoryCode.setWidth(107);
				}
				{
					tableColumnAmount = new TableColumn(tableSearcResults, SWT.NONE);
					tableColumnAmount.setText(Messages.getString("InvUICardSearch.5"));//$NON-NLS-1$
					tableColumnAmount.setWidth(118);
				}
			}
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return invCard;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	protected void tableSearcResultsMouseDoubleClick(MouseEvent evt)
	{
		TableItem[] selection = tableSearcResults.getSelection();
		if (selection.length > 0)
		{
			invCard = (TurqInventoryCard) selection[0].getData();
			dialogShell.close();
		}
	}

	public void search()
	{		
		try
		{
			tableSearcResults.removeAll();
			HashMap argMap=new HashMap();
			argMap.put(InvKeys.INV_CARD_NAME,txtInvName.getText().trim());
			argMap.put(InvKeys.INV_CARD_CODE, txtInvCode.getText().trim());
			argMap.put(InvKeys.INV_GROUP,comboInvGroup.getData(comboInvGroup.getText()));
			List result = (List)EngTXCommon.doSingleTX(InvBLCardSearch.class.getName(),"searchCards",argMap);
			TableItem item;
			int listSize = result.size();
			for (int i = 0; i < listSize; i++)
			{
				TurqInventoryCard card = (TurqInventoryCard) ((Object[]) result.get(i))[1];
				TurqViewInventoryAmountTotal invView = (TurqViewInventoryAmountTotal) ((Object[]) result.get(i))[0];
				item = new TableItem(tableSearcResults, SWT.NULL);
				item.setData(card);
				item.setText(new String[]{card.getCardInventoryCode(), card.getCardName(),
						invView.getTransactionsTotalAmountNow().toString()});
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