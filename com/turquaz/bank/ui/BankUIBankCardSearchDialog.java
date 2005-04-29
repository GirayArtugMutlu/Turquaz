package com.turquaz.bank.ui;

import java.util.HashMap;
import java.util.List;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.SearchDialogMenu;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.bank.BankKeys;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.interfaces.SearchDialogInterface;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

public class BankUIBankCardSearchDialog extends org.eclipse.swt.widgets.Dialog implements SearchDialogInterface {

	private Shell dialogShell;
	private Composite compBankSearchDialog;
	private CLabel lblBankCard;
	private TableColumn colBankCode;
	private SearchDialogMenu searchMenu;
	private TableColumn colDefinition;
	private TableColumn colCurrency;
	private TableColumn colAccNo;
	private TableColumn colBranchName;
	private TableColumn colBankName;
	private Table table1;
	private Text txtBankName;
	private CLabel lblBankName;
	private Text txtBankCard;
	private String bankCodeReturn = "";


	public BankUIBankCardSearchDialog(Shell parent, int style) {
		super(parent, style);
	}

	public String open(String searchCriteria) {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			GridLayout dialogShellLayout = new GridLayout();
			dialogShellLayout.horizontalSpacing = 0;
			dialogShellLayout.verticalSpacing = 0;
			dialogShell.setLayout(dialogShellLayout);
			dialogShell.setSize(562, 402);
			{
				GridData searchMenuLData = new GridData();
				searchMenuLData.grabExcessHorizontalSpace = true;
				searchMenuLData.horizontalAlignment = GridData.FILL;
				searchMenu = new SearchDialogMenu(dialogShell, SWT.NONE,this);
				searchMenu.setLayoutData(searchMenuLData);
			}
			{
				compBankSearchDialog = new Composite(dialogShell, SWT.NONE);
				GridLayout compBankSearchDialogLayout = new GridLayout();
				compBankSearchDialogLayout.numColumns = 4;
				compBankSearchDialogLayout.horizontalSpacing = 0;
				compBankSearchDialogLayout.marginHeight = 0;
				compBankSearchDialogLayout.marginWidth = 0;
				GridData compBankSearchDialogLData = new GridData();
				compBankSearchDialogLData.grabExcessHorizontalSpace = true;
				compBankSearchDialogLData.horizontalAlignment = GridData.FILL;
				compBankSearchDialogLData.verticalAlignment = GridData.BEGINNING;
				compBankSearchDialogLData.heightHint = 59;
				compBankSearchDialog.setLayoutData(compBankSearchDialogLData);
				compBankSearchDialog.setLayout(compBankSearchDialogLayout);
				{
					lblBankName = new CLabel(compBankSearchDialog, SWT.NONE);
					lblBankName.setText("Banka Ad\u0131");
				}
				{
					GridData txtBankNameLData = new GridData();
					txtBankNameLData.horizontalSpan = 3;
					txtBankNameLData.heightHint = 17;
					txtBankNameLData.widthHint = 150;
					txtBankName = new Text(compBankSearchDialog, SWT.NONE);
					txtBankName.setLayoutData(txtBankNameLData);
				}
				{
					lblBankCard = new CLabel(compBankSearchDialog, SWT.NONE);
					lblBankCard.setText("Banka Kodu");
				}
				{
					GridData txtBankCardLData = new GridData();
					txtBankCardLData.widthHint = 150;
					txtBankCardLData.heightHint = 17;
					txtBankCard = new Text(compBankSearchDialog, SWT.NONE);
					txtBankCard.setLayoutData(txtBankCardLData);
					txtBankCard.setText(searchCriteria);
					
				}
			}
			{
				table1 = new Table(dialogShell, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				table1.setHeaderVisible(true);
				GridData table1LData = new GridData();
				table1LData.grabExcessHorizontalSpace = true;
				table1LData.grabExcessVerticalSpace = true;
				table1LData.horizontalAlignment = GridData.FILL;
				table1LData.verticalAlignment = GridData.FILL;
				table1.setLayoutData(table1LData);
				table1.setLinesVisible(true);
				{
					colBankCode = new TableColumn(table1, SWT.NONE);
					colBankCode.setText("Banka Kodu");
					colBankCode.setWidth(80);
				}
				table1.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						if (table1.getSelection().length > 0) {
							choose();
						}
					}
				});
				{
					colBankName = new TableColumn(table1, SWT.NONE);
					colBankName.setText("Banka Ad\u0131");
					colBankName.setWidth(80);
				}
				{
					colBranchName = new TableColumn(table1, SWT.NONE);
					colBranchName.setText("\u015eube Ad\u0131");
					colBranchName.setWidth(80);
				}
				{
					colAccNo = new TableColumn(table1, SWT.NONE);
					colAccNo.setText("Hesap No");
					colAccNo.setWidth(80);
				}
				{
					colCurrency = new TableColumn(table1, SWT.NONE);
					colCurrency.setText("Para Birimi");
					colCurrency.setWidth(80);
				}
				{
					colDefinition = new TableColumn(table1, SWT.NONE);
					colDefinition.setText("Aç\u0131klama");
					colDefinition.setWidth(80);
				}
			}
			if (!searchCriteria.equals(""))
			{
				search();
			}
			
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
			
			return bankCodeReturn;
			
		} catch (Exception e) {
			e.printStackTrace();
			return bankCodeReturn;
		}
		
	}
	
	public  void search ()
	{
		try {
		
			table1.removeAll();
		HashMap argMap=new HashMap();
		
		argMap.put(BankKeys.BANK_NAME,txtBankName.getText().trim());
		argMap.put(BankKeys.BANK_CODE,txtBankCard.getText().trim());

		List listBankCards =(List) EngTXCommon.doTransactionTX(BankBLBankCardSearch.class.getName(),"searchBankCardsWithCode",argMap);
		
		TableItem item;
		
		for (int i = 0; i < listBankCards.size(); i++)
		{
			
			String cardCode = (String) ((Object[]) listBankCards.get(i))[1];
			String cardName = (String) ((Object[]) listBankCards.get(i))[2];
			String branchName = (String) ((Object[]) listBankCards.get(i))[3];
			String AccNo = (String) ((Object[]) listBankCards.get(i))[4];
			String currency = (String) ((Object[]) listBankCards.get(i))[5];
			String definition = (String) ((Object[]) listBankCards.get(i))[6];
			item = new TableItem(table1, SWT.NULL);
			item.setData(cardCode);
			
			item.setText(new String[]{cardCode, cardName, branchName,AccNo,currency,definition});	}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public void choose ()
	{
		
		if (table1.getSelection().length > 0) {
			bankCodeReturn = (String)table1.getSelection()[0].getData();
			dialogShell.close();
		}
		
	}
	
}
