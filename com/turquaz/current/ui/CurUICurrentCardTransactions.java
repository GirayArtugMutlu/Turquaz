package com.turquaz.current.ui;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;

import com.turquaz.common.HashBag;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
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
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUICurrentCardTransactions extends org.eclipse.swt.widgets.Dialog
{
	private Shell dialogShell;
	private Table tableCurrentTransactions;
	private TableColumn tableColumnDocumentNo;
	private ToolBar toolBar1;
	private CoolItem coolItem1;
	private CoolBar coolBar1;
	private TableColumn tableColumnTransDate;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnTransGroup;
	static private ToolItem toolPrint;
	static private ToolItem toolExportToExcel;
	Integer curCardId =null;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog inside a new Shell.
	 */
	public CurUICurrentCardTransactions(Shell parent, int style, Integer curCardId)
	{
		super(parent, style);
		this.curCardId = curCardId;
	
	}

	public void open()
	{
		try
		{
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
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
							toolExportToExcel.setText(EngLangCommonKeys.STR_EXPORT_TO_EXCEL); //$NON-NLS-1$
							toolExportToExcel.setImage(SWTResourceManager.getImage("icons/excel.jpeg")); //$NON-NLS-1$
							toolExportToExcel.setWidth(68);
							toolExportToExcel.addSelectionListener(new SelectionAdapter()
							{
								public void widgetSelected(SelectionEvent evt)
								{
									EngBLUtils.Export2Excel(tableCurrentTransactions);
								}
							});
						}
						{
							toolPrint = new ToolItem(toolBar1, SWT.NONE);
							toolPrint.setText(EngLangCommonKeys.STR_PRINT); //$NON-NLS-1$
							toolPrint.setImage(SWTResourceManager.getImage("icons/Print16.gif")); //$NON-NLS-1$
						
						}
					}
				}
			}
			{
				tableCurrentTransactions = new Table(dialogShell, SWT.FULL_SELECTION);
				tableCurrentTransactions.setHeaderVisible(true);
				tableCurrentTransactions.setLinesVisible(true);
				GridData tableCurrentTransactionsLData = new GridData();
				tableCurrentTransactionsLData.verticalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.horizontalAlignment = GridData.FILL;
				tableCurrentTransactionsLData.grabExcessHorizontalSpace = true;
				tableCurrentTransactionsLData.grabExcessVerticalSpace = true;
				tableCurrentTransactions.setLayoutData(tableCurrentTransactionsLData);
				{
					tableColumnTransDate = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnTransDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
					tableColumnTransDate.setWidth(100);
				}
				{
					tableColumnTransGroup = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnTransGroup.setText(CurLangKeys.STR_TRANSACTION_GROUP); //$NON-NLS-1$
					tableColumnTransGroup.setWidth(114);
				}
				{
					tableColumnDocumentNo = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnDocumentNo.setText("Belge No");
					tableColumnDocumentNo.setWidth(120);
				}
				{
					tableColumnDebit = new TableColumn(tableCurrentTransactions, SWT.RIGHT);
					tableColumnDebit.setText(EngLangCommonKeys.STR_DEPT); //$NON-NLS-1$
					tableColumnDebit.setWidth(106);
				}
				{
					tableColumnCredit = new TableColumn(tableCurrentTransactions, SWT.NONE);
					tableColumnCredit.setText(EngLangCommonKeys.STR_CREDIT); //$NON-NLS-1$
					tableColumnCredit.setWidth(86);
					tableColumnCredit.setAlignment(131072);
				}
			}
			PostInit();
			dialogShell.layout();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed())
			{
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getParent());
		}
	}

	public void PostInit()
	{
		try
		{
			tableCurrentTransactions.removeAll();
			HashMap argMap = new HashMap();
			argMap.put(CurKeys.CUR_CARD_ID,curCardId);
			
			final HashBag result =(HashBag)EngTXCommon.doSelectTX(CurBLSearchTransaction.class.getName(),"getCurrentTransactions",argMap); 
			
			toolPrint.addSelectionListener(new SelectionAdapter()
					{
						public void widgetSelected(SelectionEvent evt)
						{
							EngBLUtils.printTable(tableCurrentTransactions,CurLangKeys.STR_CURRENT_CARD_ABSTRAT_CODE//$NON-NLS-1$
									+ result.get(CurKeys.CUR_CURRENT_CODE).toString());
						}
					});
			
			
			HashMap transList = (HashMap)result.get(CurKeys.CUR_TRANSACTIONS);
			
			TableItem item;
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			for (int i = 0; i < transList.size(); i++)
			{
				HashMap transInfo = (HashMap)transList.get(new Integer(i));
				item = new TableItem(tableCurrentTransactions, SWT.NULL);
				item.setData(transInfo.get(CurKeys.CUR_TRANSACTION_ID));
				Date transDate = (Date)transInfo.get(EngKeys.DATE);
				String typeName =(String)transInfo.get(EngKeys.TYPE_NAME);
				String docNo =(String)transInfo.get(EngKeys.DOCUMENT_NO);
				BigDecimal totalCredit=(BigDecimal)transInfo.get(EngKeys.CREDIT_AMOUNT);
				BigDecimal totalDept=(BigDecimal)transInfo.get(EngKeys.DEPT_AMOUNT);
				
				item.setText(new String[]{DatePicker.formatter.format(transDate),
						typeName,
						docNo, cf.format(totalDept),
						cf.format(totalCredit)});
			}
			
			
			
			
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getParent());
		}
	}
}