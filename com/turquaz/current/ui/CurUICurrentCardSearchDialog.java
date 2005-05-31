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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
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
import com.turquaz.current.CurKeys;
import com.turquaz.engine.ui.component.SearchDialogMenu;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.interfaces.SearchDialogInterface;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;


/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardSearchDialog extends org.eclipse.swt.widgets.Dialog implements SearchDialogInterface
{
	private Shell dialogShell;
	private Composite compCurrentCardSearch;
	private Text txtCurrentCode;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CCombo comboTurqGroupName;
	private CLabel lblTurqGroupName;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private CLabel lblCurrentCode;
	private TableColumn tableColumnBalance;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDept;
	private SearchDialogMenu searchDialogMenu1;
	Object returnData = "";
	int type = 0;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */


	public CurUICurrentCardSearchDialog(Shell parent, int style,int type)
	{
		super(parent, style);
		this.type = type;
	}

	public Object open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
			dialogShell.setLayout(new GridLayout());
			
			dialogShell.setSize(607, 383);
			{
				GridData searchDialogMenu1LData = new GridData();
				searchDialogMenu1LData.heightHint = 35;
				searchDialogMenu1LData.grabExcessHorizontalSpace = true;
				searchDialogMenu1LData.horizontalAlignment = GridData.FILL;
				searchDialogMenu1 = new SearchDialogMenu(dialogShell, SWT.NONE,this);
				searchDialogMenu1.setLayoutData(searchDialogMenu1LData);
			}	
			
			{
				compCurrentCardSearch = new Composite(dialogShell, SWT.NONE);
				GridLayout compCurrentCardSearchLayout = new GridLayout();
				compCurrentCardSearchLayout.numColumns = 2;
				GridData compCurrentCardSearchLData = new GridData();
				compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
				compCurrentCardSearchLData.heightHint = 92;
				compCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				compCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
				{
					lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentCode.setText(CurLangKeys.STR_CUR_CODE); //$NON-NLS-1$
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				}
				{
					txtCurrentCode = new Text(compCurrentCardSearch, SWT.NONE);
					GridData txtCurrentCodeLData = new GridData();
					
					txtCurrentCodeLData.widthHint = 150;
					txtCurrentCodeLData.heightHint = 17;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
				}
				{
					lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentName.setText(CurLangKeys.STR_CUR_NAME); //$NON-NLS-1$
					GridData lblCurrentNameLData = new GridData();
					lblCurrentName.setLayoutData(lblCurrentNameLData);
				}
				{
					txtCurrentName = new Text(compCurrentCardSearch, SWT.NONE);
					GridData txtCurrentNameLData = new GridData();
									
					txtCurrentNameLData.widthHint = 150;
					txtCurrentNameLData.heightHint = 17;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
				}
				{
					lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblTurqGroupName.setText(EngLangCommonKeys.STR_GROUP_NAME); //$NON-NLS-1$
					GridData lblTurqGroupNameLData = new GridData();
					lblTurqGroupNameLData.widthHint = 97;
					lblTurqGroupNameLData.heightHint = 23;
					lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
				}
				{
					comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
					GridData comboTurqGroupNameLData = new GridData();
					comboTurqGroupNameLData.widthHint = 112;
					comboTurqGroupNameLData.heightHint = 10;
					comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
				}
			}
			{
				tableCurrentCardSearch = new Table(dialogShell, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.BORDER);
				tableCurrentCardSearch.setHeaderVisible(true);
				tableCurrentCardSearch.setLinesVisible(true);
				tableCurrentCardSearch.setSize(new org.eclipse.swt.graphics.Point(409, 168));
				GridData tableCurrentCardSearchLData = new GridData();
				tableCurrentCardSearch.addMouseListener(new MouseAdapter()
				{
					public void mouseDoubleClick(MouseEvent evt)
					{
						choose();
					}
				});
				tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
				tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
				{
					tableColumnCurrentCode = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnCurrentCode.setText(CurLangKeys.STR_CUR_CODE); //$NON-NLS-1$
					tableColumnCurrentCode.setWidth(120);
				}
				{
					tableColumnCurrentName = new TableColumn(tableCurrentCardSearch, SWT.NONE);
					tableColumnCurrentName.setText(CurLangKeys.STR_CUR_NAME); //$NON-NLS-1$
					tableColumnCurrentName.setWidth(120);
				}
				{
					tableColumnDept = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnDept.setText("Toplam Borç");
					tableColumnDept.setWidth(104);
				}
				{
					tableColumnCredit = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnCredit.setText("Toplam alacak");
					tableColumnCredit.setWidth(100);
				}
				{
					tableColumnBalance = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnBalance.setText("Bakiye");
					tableColumnBalance.setWidth(119);
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
            EngBLLogger.log(this.getClass(),e,getParent());
			return returnData;
		}
	}

	public void choose()
	{
		
		if (tableCurrentCardSearch.getSelection().length > 0)
		{
			returnData = tableCurrentCardSearch.getSelection()[0].getData();
			dialogShell.close();
		}
	}
	public void search()
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			
			tableCurrentCardSearch.removeAll();
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CURRENT_CODE,txtCurrentCode.getText().trim());
			argMap.put(CurKeys.CUR_CURRENT_NAME,txtCurrentName.getText().trim());
			argMap.put(CurKeys.CUR_GROUP_ID, comboTurqGroupName.getData(comboTurqGroupName.getText()));
			
			
			List listCurrentCards = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"searchCurrentCard",argMap);
			
			for (int k = 0; k < listCurrentCards.size(); k++)
			{
				TableItem item = new TableItem(tableCurrentCardSearch, SWT.NULL);
			    Object result[] = (Object[])listCurrentCards.get(k);
                String cardCode = (String)((Object[]) listCurrentCards.get(k))[1]; //$NON-NLS-1$
			    String cardName = (String)((Object[]) listCurrentCards.get(k))[2]; //$NON-NLS-1$
			    if(type==0)
				{
				item.setData(cardCode);
				}
			    else
				{
					item.setData(cardName+" {"+cardCode+"}");
				}
				BigDecimal totalDept = new BigDecimal(0);
				BigDecimal totalCredit = new BigDecimal(0);
				BigDecimal balance = new BigDecimal(0);
				if(result[4]!=null)
				{
					totalDept = (BigDecimal)result[4];
				}
				if(result[3] != null)
				{
					totalCredit = (BigDecimal)result[3];
				}
				if(result[5] != null)
				{
					balance =(BigDecimal)result[5];
				}
				
				item.setText(new String[]{cardCode,cardName,cf.format(totalDept),cf.format(totalCredit),cf.format(balance)});
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}

	public void postInitGui()
	{
		try
		{
			EngUICommon.centreWindow(dialogShell);
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText(""); //$NON-NLS-1$
			List groups = (List)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getTurqCurrentGroups",null);
			
			for (int k = 0; k < groups.size(); k++)
			{
				TurqCurrentGroup group = (TurqCurrentGroup) groups.get(k);
				comboTurqGroupName.add(group.getGroupsName());
				comboTurqGroupName.setData(group.getGroupsName(), group);
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}