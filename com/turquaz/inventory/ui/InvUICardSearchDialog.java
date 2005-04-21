package com.turquaz.inventory.ui;

/************************************************************************/
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* the Free Software Foundation; either version 2 of the License, or    */
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
import org.eclipse.swt.widgets.TableItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
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
	private MenuItem menuItemChoose;
	private MenuItem menuItemSearch;
	private Menu menu1;
	private MenuItem menuActions;
	private Menu SearchMenu;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private CLabel lblInvGroup;
	private Text txtInvCode;
	private CLabel cLabel2;
	private Text txtInvName;
    String invCardCode ="";

	

	public InvUICardSearchDialog(Shell parent, int style)
	{
		super(parent, style);
	}

	public String open(String cardCode)
	{
		try
		{
			
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			
			{
				SearchMenu = new Menu(dialogShell, SWT.BAR);
				dialogShell.setMenuBar(SearchMenu);
				SearchMenu.setVisible(true);
				{
					menuActions = new MenuItem(SearchMenu, SWT.CASCADE);
					menuActions.setText("\u0130\u015flemler");
					{
						menu1 = new Menu(menuActions);
						menuActions.setMenu(menu1);
						{
							menuItemSearch = new MenuItem(menu1, SWT.PUSH);
							menuItemSearch.setText("Ara");
							menuItemSearch.setAccelerator(SWT.CR);
							menuItemSearch
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									search();	
								
								}
								});
						}
						{
							menuItemChoose = new MenuItem(menu1, SWT.PUSH);
							menuItemChoose.setText("Seç");
							menuItemChoose.setAccelerator(SWT.F2);
							menuItemChoose
								.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									tableSearcResultsMouseDoubleClick();
								}
								});
						}
					}
				}
			}
			
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			dialogShell.setLayout(new GridLayout());
			dialogShell.setText(Messages.getString("InvUICardSearchDialog.0")); //$NON-NLS-1$
			dialogShell.pack();
			dialogShell.setSize(501, 420);
			{
				compInvCardSearchPanel = new Composite(dialogShell, SWT.BORDER);
				GridLayout compInvCardSearchPanelLayout = new GridLayout();
				compInvCardSearchPanelLayout.numColumns = 2;
				GridData compInvCardSearchPanelLData = new GridData();
				compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
				compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
				compInvCardSearchPanelLData.heightHint = 78;
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
					txtInvCode.setText(cardCode);
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
						tableSearcResultsMouseDoubleClick();
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
					tableColumnAmount.setText("Miktar");//$NON-NLS-1$
					tableColumnAmount.setWidth(118);
				}
			}
			dialogShell.layout();
			dialogShell.open();
			EngUICommon.centreWindow(dialogShell);
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
			return invCardCode;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	protected void tableSearcResultsMouseDoubleClick()
	{
		TableItem[] selection = tableSearcResults.getSelection();
		if (selection.length > 0)
		{
			invCardCode = (String) selection[0].getData();
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
	            String cardName = (String) ((Object[]) result.get(i))[2];
				String cardCode = (String) ((Object[]) result.get(i))[1];
				TurqViewInventoryTotal invView = (TurqViewInventoryTotal) ((Object[]) result.get(i))[0];
				item = new TableItem(tableSearcResults, SWT.NULL);
				item.setData(cardCode);
				
				item.setText(new String[]{cardCode, cardName,""});
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