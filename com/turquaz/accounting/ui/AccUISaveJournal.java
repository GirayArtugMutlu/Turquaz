package com.turquaz.accounting.ui;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.accounting.Messages;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;


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
public class AccUISaveJournal extends org.eclipse.swt.widgets.Composite {
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
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		AccUISaveJournal inst = new AccUISaveJournal(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public AccUISaveJournal(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
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
                    tableColumnTransType = new TableColumn(
                        tableAccountingTransaction,
                        SWT.NONE);
                    tableColumnTransType.setText(Messages.getString("AccUISaveJournal.0")); //$NON-NLS-1$
                    tableColumnTransType.setWidth(105);
                }
                {
                    tableColumnDocumentNo = new TableColumn(
                        tableAccountingTransaction,
                        SWT.NONE);
                    tableColumnDocumentNo.setText(Messages.getString("AccUISaveJournal.1")); //$NON-NLS-1$
                    tableColumnDocumentNo.setWidth(108);
                }
                {
                    tableColumnDate = new TableColumn(
                        tableAccountingTransaction,
                        SWT.NONE);
                    tableColumnDate.setText(Messages.getString("AccUISaveJournal.2")); //$NON-NLS-1$
                    tableColumnDate.setWidth(107);
                }
                {
                    tableColumnTotalAmount = new TableColumn(
                        tableAccountingTransaction,
                        SWT.RIGHT);
                    tableColumnTotalAmount.setText(Messages.getString("AccUISaveJournal.3")); //$NON-NLS-1$
                    tableColumnTotalAmount.setWidth(103);
                }
                {
                    tableColumnDefinition = new TableColumn(
                        tableAccountingTransaction,
                        SWT.NONE);
                    tableColumnDefinition.setText(Messages.getString("AccUISaveJournal.4")); //$NON-NLS-1$
                    tableColumnDefinition.setWidth(100);
                }
            }
            {
                lblJournalDate = new CLabel(this, SWT.NONE);
                lblJournalDate.setText(Messages.getString("AccUISaveJournal.6")); //$NON-NLS-1$
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
                btnSaveJournal.setText(Messages.getString("AccUISaveJournal.5")); //$NON-NLS-1$
                btnSaveJournal.addMouseListener(new MouseAdapter() {
                    public void mouseUp(MouseEvent evt) {
                    
                        saveJournalItems();
                    
                    }
                });
            }
            fillTable();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void fillTable()
	{
	    try
		{
	    	tableAccountingTransaction.removeAll();  
	    	  List result = AccBLTransactionSearch.getUnsavedTransactions();
	     	 TableItem item;
	  	
	     	 int listSize = result.size();
	     	 TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
	     	 for(int i =0; i<listSize;i++)
	     	 {
	     	 	TurqAccountingTransaction accTrans = (TurqAccountingTransaction)result.get(i);
	     	 	item = new TableItem(tableAccountingTransaction,SWT.NULL);
	     	 	item.setData(accTrans);
	  	
	     	 	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$
	  	
	  	
	  		BigDecimal total = new BigDecimal(0);
	  		Iterator it = accTrans.getTurqAccountingTransactionColumns().iterator();
	  		while(it.hasNext()){
	  			TurqAccountingTransactionColumn transColumn = (TurqAccountingTransactionColumn)it.next();
	  			total = total.add(transColumn.getRowsCreditInBaseCurrency());
	  		}
	  	
	  		String transDate =formatter.format(accTrans.getTransactionsDate());
	  		item.setText(new String[]{accTrans.getTurqAccountingTransactionType().getTypesName(),
	  					accTrans.getTransactionDocumentNo(),transDate,cf.format(total),accTrans.getTransactionDescription()}); //$NON-NLS-1$
	  	
	     	 }
	        
	    }
	    
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	    
	    
	}
	public void saveJournalItems(){
	    try{
	        MessageBox msg = new MessageBox(this.getShell(),SWT.ICON_WARNING|SWT.OK|SWT.CANCEL);
	        msg.setMessage(Messages.getString("AccUISaveJournal.7")); //$NON-NLS-1$
	        
	        int result = msg.open();
	        if(result ==SWT.OK){
	        TableItem items[] = tableAccountingTransaction.getItems();
	        for(int i=0;i<items.length;i++){
	            
	           if( items[i].getChecked()){
	           	AccBLTransactionSearch.addToJournal((TurqAccountingTransaction)items[i].getData(),datePickerJournalDate.getDate());
	              
	           }
	            
	            
	        }
	         
	        fillTable();
	        }
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    
	}
}
