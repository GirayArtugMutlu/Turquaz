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
import java.util.List;
import java.util.Set;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardSearchDialog extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Composite compCurrentCardSearch;
	private Text txtCurrentCode;
	private TableColumn tableColumnContactName;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CCombo comboTurqGroupName;
	private CLabel lblTurqGroupName;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private CLabel lblCurrentCode;
	private Button btnSearch;
	Object returnData = null;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */
	public static void main(String[] args)
	{
		try
		{
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			CurUICurrentCardSearchDialog inst = new CurUICurrentCardSearchDialog(shell, SWT.NULL);
			inst.open();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public CurUICurrentCardSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public Object open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setLayout(new GridLayout());
			dialogShell.pack();
			dialogShell.setSize(439, 375);
			{
				compCurrentCardSearch = new Composite(dialogShell, SWT.NONE);
				GridLayout compCurrentCardSearchLayout = new GridLayout();
				compCurrentCardSearchLayout.numColumns = 2;
				GridData compCurrentCardSearchLData = new GridData();
				compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
				compCurrentCardSearchLData.heightHint = 129;
				compCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				compCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
				{
					lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0")); //$NON-NLS-1$
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				}
				{
					txtCurrentCode = new Text(compCurrentCardSearch, SWT.NONE);
					GridData txtCurrentCodeLData = new GridData();
					txtCurrentCode.addKeyListener(new KeyAdapter()
					{
						public void keyReleased(KeyEvent evt)
						{
							if (evt.keyCode == SWT.CR)
								search();
						}
					});
					txtCurrentCodeLData.widthHint = 234;
					txtCurrentCodeLData.heightHint = 15;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
				}
				{
					lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1")); //$NON-NLS-1$
					GridData lblCurrentNameLData = new GridData();
					lblCurrentName.setLayoutData(lblCurrentNameLData);
				}
				{
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
					txtCurrentName.setSize(234, 15);
					txtCurrentNameLData.widthHint = 234;
					txtCurrentNameLData.heightHint = 15;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
				}
				{
					lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblTurqGroupName.setText(Messages.getString("CurUICurrentCardSearch.2")); //$NON-NLS-1$
					GridData lblTurqGroupNameLData = new GridData();
					lblTurqGroupNameLData.widthHint = 97;
					lblTurqGroupNameLData.heightHint = 23;
					lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
				}
				{
					comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
					GridData comboTurqGroupNameLData = new GridData();
					comboTurqGroupNameLData.widthHint = 50;
					comboTurqGroupNameLData.heightHint = 9;
					comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
				}
				{
					btnSearch = new Button(compCurrentCardSearch, SWT.PUSH | SWT.CENTER);
					btnSearch.setText(Messages.getString("CurUICurrentCardSearchDialog.0")); //$NON-NLS-1$
					GridData btnSearchLData = new GridData();
					btnSearch.addMouseListener(new MouseAdapter()
					{
						public void mouseUp(MouseEvent evt)
						{
							search();
						}
					});
					btnSearchLData.widthHint = 90;
					btnSearchLData.heightHint = 34;
					btnSearch.setLayoutData(btnSearchLData);
				}
			}
			{
				tableCurrentCardSearch = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL);
				tableCurrentCardSearch.setHeaderVisible(true);
				tableCurrentCardSearch.setLinesVisible(true);
				tableCurrentCardSearch.setSize(new org.eclipse.swt.graphics.Point(409, 168));
				GridData tableCurrentCardSearchLData = new GridData();
				tableCurrentCardSearch.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						if (tableCurrentCardSearch.getSelection().length > 0)
						{
							returnData = tableCurrentCardSearch.getSelection()[0].getData();
							dialogShell.close();
						}
					}
				});
				tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
				tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
				{
					tableColumnCurrentCode = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0")); //$NON-NLS-1$
					tableColumnCurrentCode.setWidth(120);
				}
				{
					tableColumnCurrentName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1")); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(120);
				}
				{
					tableColumnContactName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnContactName.setText(Messages.getString("CurUICurrentCardSearch.5")); //$NON-NLS-1$
					tableColumnContactName.setWidth(120);
				}
			}
			postInitGui();
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return returnData;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return returnData;
		}
	}

	public void search()
	{
		try
		{
			tableCurrentCardSearch.removeAll();
			List listCurrentCards = CurBLCurrentCardSearch.searchCurrentCard(txtCurrentCode.getText().trim(), txtCurrentName.getText()
					.trim(), (TurqCurrentGroup) comboTurqGroupName.getData(comboTurqGroupName.getText()));
			for (int k = 0; k < listCurrentCards.size(); k++)
			{
				TurqCurrentCard aCurrentCard = (TurqCurrentCard) ((Object[]) listCurrentCards.get(k))[1];
				TableItem item = new TableItem(tableCurrentCardSearch, SWT.NULL);
				item.setData(aCurrentCard);
				String contactName = ""; //$NON-NLS-1$
				Set contacts = aCurrentCard.getTurqCurrentContacts();
				if (contacts.size() > 0)
				{
					Object curContact[] = contacts.toArray();
					contactName = ((TurqCurrentContact) curContact[0]).getContactsName();
				}
				item.setText(new String[]{aCurrentCard.getCardsCurrentCode(), aCurrentCard.getCardsName(), contactName});
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void postInitGui()
	{
		try
		{
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText(""); //$NON-NLS-1$
			List groups = CurBLCurrentCardSearch.getTurqCurrentGroups();
			for (int k = 0; k < groups.size(); k++)
			{
				TurqCurrentGroup group = (TurqCurrentGroup) groups.get(k);
				comboTurqGroupName.add(group.getGroupsName());
				comboTurqGroupName.setData(group.getGroupsName(), group);
			}
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getParent(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}
}