package com.turquaz.current.ui;

import java.util.List;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;


import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionAdapter;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.CoolItem;
/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CurUICurrentCardTransactions extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private TurqCurrentCard currentCard;
	private CurBLSearchTransaction BLSearch = new CurBLSearchTransaction();
	private Table tableCurrentTransactions;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnTransGroup;
	static private ToolItem toolPrint;
	static private ToolItem toolExportToExcel;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/

	public CurUICurrentCardTransactions(Shell parent, int style, TurqCurrentCard card) {
		super(parent, style);
		currentCard=card;
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

				{
					//Register as a resource user - SWTResourceManager will
					//handle the obtaining and disposing of resources
					SWTResourceManager.registerResourceUser(dialogShell);
				}


			dialogShell.setLayout(new GridLayout());
		
			
			
			dialogShell.setSize(574, 566);
            {
                coolBar1 = new CoolBar(dialogShell, SWT.NONE);
                GridData coolBar1LData = new GridData();
                coolBar1LData.horizontalAlignment = GridData.FILL;
                coolBar1LData.grabExcessHorizontalSpace = true;
                coolBar1.setLayoutData(coolBar1LData);
                {
                    coolItem1 = new CoolItem(coolBar1, SWT.NONE);
                    coolItem1.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 45));
                    coolItem1.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 45));
                    coolItem1.setSize(45, 45);
                    {	
                        toolBar1 = new ToolBar(coolBar1, SWT.NONE);
                        coolItem1.setControl(toolBar1);
                        {
                            toolExportToExcel = new ToolItem(toolBar1, SWT.NONE);
                            toolExportToExcel.setText(Messages.getString("CurUICurrentCardTransactions.0")); //$NON-NLS-1$
                            toolExportToExcel.setImage(SWTResourceManager
                                .getImage("icons/excel.jpeg")); //$NON-NLS-1$
                            toolExportToExcel.setWidth(68);
                            toolExportToExcel
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        EngBLUtils
                                            .Export2Excel(tableCurrentTransactions);
                                    }
                                });
                        }
                        {
                            toolPrint = new ToolItem(toolBar1, SWT.NONE);
                            toolPrint.setText(Messages.getString("CurUICurrentCardTransactions.2")); //$NON-NLS-1$
                            toolPrint.setImage(SWTResourceManager
                                .getImage("icons/Print16.gif")); //$NON-NLS-1$
                            toolPrint
                                .addSelectionListener(new SelectionAdapter() {
                                    public void widgetSelected(
                                        SelectionEvent evt) {
                                        EngBLUtils.printTable(
                                            tableCurrentTransactions,
                                            Messages.getString("CurUICurrentCardTransactions.4") //$NON-NLS-1$
                                                + currentCard
                                                    .getCardsCurrentCode());

                                    }
                                });
                        }
                    }
                }
            }
            {
                tableCurrentTransactions = new Table(
                    dialogShell,
                    SWT.FULL_SELECTION);
                tableCurrentTransactions.setHeaderVisible(true);
                tableCurrentTransactions.setLinesVisible(true);
                GridData tableCurrentTransactionsLData = new GridData();

                tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
                tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
                tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
                tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
                tableCurrentTransactions
                    .setLayoutData(tableCurrentTransactionsLData);
                {
                    tableColumnTransDate = new TableColumn(
                        tableCurrentTransactions,
                        SWT.NONE);
                    tableColumnTransDate.setText(Messages
                        .getString("CurUITransactionSearch.9")); //$NON-NLS-1$
                    tableColumnTransDate.setWidth(100);
                }
                {
                    tableColumnTransGroup = new TableColumn(
                        tableCurrentTransactions,
                        SWT.NONE);
                    tableColumnTransGroup.setText(Messages
                        .getString("CurUITransactionSearch.6")); //$NON-NLS-1$
                    tableColumnTransGroup.setWidth(114);
                }
                {
                    tableColumnDebit = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
                    tableColumnDebit.setText(Messages
                        .getString("CurUITransactionSearch.7")); //$NON-NLS-1$
                    tableColumnDebit.setWidth(106);
                }
                {
                    tableColumnCredit = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
                    tableColumnCredit.setText(Messages
                        .getString("CurUITransactionSearch.8")); //$NON-NLS-1$
                    tableColumnCredit.setWidth(101);
                }
            }
			PostInit();
			dialogShell.layout();
			
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void PostInit()
	{
		try{
		tableCurrentTransactions.removeAll();
		
		List results =BLSearch.getCurrentTransactions(currentCard, null, null);
		
		TurqCurrentTransaction transaction;
		TableItem item;
		TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
		for(int i=0;i<results.size();i++){
		
		transaction = (TurqCurrentTransaction)results.get(i);
		item = new TableItem(tableCurrentTransactions,SWT.NULL);
		item.setData(transaction);
		item.setText(new String[]{DatePicker.formatter.format(transaction.getTransactionsDate()),
		        				  transaction.getTurqCurrentTransactionType().getTransactionTypeName(),
								  cf.format(transaction.getTransactionsTotalDept()),
								  cf.format(transaction.getTransactionsTotalCredit()),
								  
									});
		
	}
		}
		catch(Exception ex){
		ex.printStackTrace();
		}
	}
}
