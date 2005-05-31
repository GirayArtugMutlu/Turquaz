package com.turquaz.accounting.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.bl.EngBLLogger;



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
public class AccUISaveJournal extends org.eclipse.swt.widgets.Composite
{
	private Table tableAccountingTransaction;
	private TableColumn tableColumnDate;
	private CLabel lblJournalDate;
	private DatePicker datePickerJournalDate;
	private Button btnSaveJournal;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnTotalAmount;
	private TableColumn tableColumnDocumentNo;
	private TableColumn tableColumnTransType;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void main(String[] args)
	{
		showGUI();
	}

	/**
	 * Auto-generated method to display this org.eclipse.swt.widgets.Composite inside a new Shell.
	 */
	public static void showGUI()
	{
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AccUISaveJournal inst = new AccUISaveJournal(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0)
		{
			inst.pack();
			shell.pack();
		}
		else
		{
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed())
		{
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AccUISaveJournal(org.eclipse.swt.widgets.Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	private void initGUI()
	{
		try
		{
			GridLayout thisLayout = new GridLayout();
			this.setLayout(thisLayout);
			thisLayout.numColumns = 2;
			this.setSize(568, 311);
			{
				tableAccountingTransaction = new Table(this, SWT.CHECK | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				GridData tableAccountingTransactionLData = new GridData();
				tableAccountingTransaction.setHeaderVisible(true);
				tableAccountingTransaction.setLinesVisible(true);
				tableAccountingTransactionLData.grabExcessHorizontalSpace = true;
				tableAccountingTransactionLData.verticalAlignment = GridData.FILL;
				tableAccountingTransactionLData.horizontalSpan = 2;
				tableAccountingTransactionLData.horizontalAlignment = GridData.FILL;
				tableAccountingTransactionLData.grabExcessVerticalSpace = true;
				tableAccountingTransaction.setLayoutData(tableAccountingTransactionLData);
				{
					tableColumnTransType = new TableColumn(tableAccountingTransaction, SWT.NONE);
					tableColumnTransType.setText(AccLangKeys.STR_VOUCHER_TYPE); 
					tableColumnTransType.setWidth(105);
				}
				{
					tableColumnDocumentNo = new TableColumn(tableAccountingTransaction, SWT.NONE);
					tableColumnDocumentNo.setText(AccLangKeys.STR_DOCUMENT_NO); 
					tableColumnDocumentNo.setWidth(108);
				}
				{
					tableColumnDate = new TableColumn(tableAccountingTransaction, SWT.NONE);
					tableColumnDate.setText(EngLangCommonKeys.STR_DATE); 
					tableColumnDate.setWidth(107);
				}
				{
					tableColumnTotalAmount = new TableColumn(tableAccountingTransaction, SWT.RIGHT);
					tableColumnTotalAmount.setText(AccLangKeys.STR_TOTAL_AMOUNT_YTL);
					tableColumnTotalAmount.setWidth(103);
				}
				{
					tableColumnDefinition = new TableColumn(tableAccountingTransaction, SWT.NONE);
					tableColumnDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); 
					tableColumnDefinition.setWidth(100);
				}
			}
			{
				lblJournalDate = new CLabel(this, SWT.NONE);
				lblJournalDate.setText(AccLangKeys.STR_JOURNAL_DATE);
				GridData lblJournalDateLData = new GridData();
				lblJournalDateLData.widthHint = 92;
				lblJournalDateLData.heightHint = 19;
				lblJournalDate.setLayoutData(lblJournalDateLData);
			}
			{
				datePickerJournalDate = new DatePicker(this, SWT.NONE);
				GridData datePickerJournalDateLData = new GridData();
				datePickerJournalDateLData.widthHint = 159;
				datePickerJournalDateLData.heightHint = 24;
				datePickerJournalDate.setLayoutData(datePickerJournalDateLData);
			}
			{
				btnSaveJournal = new Button(this, SWT.PUSH | SWT.CENTER);
				btnSaveJournal.setText(AccLangKeys.STR_ADD_JOURNAL_ID); 
				btnSaveJournal.addMouseListener(new MouseAdapter()
				{
					public void mouseUp(MouseEvent evt)
					{
						saveJournalItems();
					}
				});
			}
			PostInitGui();
			this.layout();
		}
		catch (Exception e)
		{
            EngBLLogger.log(this.getClass(),e,getShell());
		}
	}
	
	public void PostInitGui()
	{
		fillTable();
	}

	public void fillTable()
	{
		try
		{
			tableAccountingTransaction.removeAll();
			HashBag transBag = (HashBag)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getUnsavedTransactions",null);
			TableItem item;
			
			HashMap transMaps=(HashMap)transBag.get(AccKeys.ACC_TRANSACTIONS);
			
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
			for (int k = 0; k < transMaps.size(); k++)
			{
				HashMap transMap=(HashMap)transMaps.get(new Integer(k));
				item = new TableItem(tableAccountingTransaction, SWT.NULL);
				item.setData(transMap);
				
				BigDecimal total = (BigDecimal)transMap.get(EngKeys.TOTAL_AMOUNT);
				
				Date transDate=(Date)transMap.get(AccKeys.ACC_TRANS_DATE);
				String transTypeName=(String)transMap.get(AccKeys.ACC_TRANS_TYPE_NAME);
				String documentNo=(String)transMap.get(AccKeys.ACC_TRANSACTION_DOC_NO);
				String transDefinition=(String)transMap.get(AccKeys.ACC_TRANSACTION_DEFINITION);
				
				item.setText(new String[]{transTypeName,documentNo,formatter.format(transDate),
						cf.format(total), transDefinition}); //$NON-NLS-1$
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}

	public void saveJournalItems()
	{
		try
		{
			boolean result=EngUICommon.showQuestion(getShell(),AccLangKeys.MSG_NOT_DELETE_VOUCHER_WITH_JOURNAL_ID);
			if (result)
			{
				TableItem items[] = tableAccountingTransaction.getItems();
				for (int i = 0; i < items.length; i++)
				{
					if (items[i].getChecked())
					{
						HashMap argMap = new HashMap();
						argMap.put(AccKeys.ACC_TRANSACTION,items[i].getData());
						argMap.put(AccKeys.ACC_TRANS_DATE,datePickerJournalDate.getDate());
						EngTXCommon.doTransactionTX(AccBLTransactionSearch.class.getName(),"addToJournal",argMap);	
					}
				}
				fillTable();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(this.getClass(),ex,getShell());
		}
	}
}